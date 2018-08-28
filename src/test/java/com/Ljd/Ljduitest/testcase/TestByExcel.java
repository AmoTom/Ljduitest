package com.Ljd.Ljduitest.testcase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestByExcel {
	public WebDriver driver;
	String url="http://www.baidu.com";

	@DataProvider(name="TestData")
		public static Object[][] words() throws IOException{
			return getTestData("d:\\","TestData1.xlsx","Sheet1");
	}

	@Test(dataProvider="TestData")
	public void testSearch(String words1, String words2, String result){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys(words1+ " "+words2);
		driver.findElement(By.id("su")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(driver.getPageSource().contains(result));
	}

	@BeforeMethod
	public void BeforeMethod(){
		driver =new FirefoxDriver();
	}

	@AfterMethod

	public void AfterMethod(){
		driver.quit();
	}

	//从Excel文件获取测试数据的静态方法
	public static Object[][] getTestData(String filepath,String filename,String SheetName) throws IOException{
		File file = new File(filepath + "\\" + filename);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook Workbook = null;

		//获取文件扩展名
		String fileExtensionName = filename.substring(filename.indexOf("."));

		//判断是.xlsx还是.xls的文件并进行实例化
		if(fileExtensionName.equals(".xlsx")){
			Workbook = new XSSFWorkbook(inputStream);
		}
		else if(fileExtensionName.equals(".xls")){
			Workbook = new HSSFWorkbook(inputStream);
		}

		//通过sheetName生成Sheet对象
		Sheet Sheet = Workbook.getSheet(SheetName);
		int rowCount = Sheet.getLastRowNum()-Sheet.getFirstRowNum();
		List<Object[]> records = new ArrayList<Object[]>();
		for(int i=0 ; i<rowCount+1; i++){
			Row row = Sheet.getRow(i);
			String fields[] = new String[row.getLastCellNum()];
			for(int j=0;j<row.getLastCellNum();j++){
				fields[j] = row.getCell(j).getStringCellValue();
			}
			records.add(fields);
		}
		Object[][] results = new Object[records.size()][];
		for (int i = 0 ; i < records.size();i++){
			results[i] = records.get(i);
		}
		return results;
	}
}
