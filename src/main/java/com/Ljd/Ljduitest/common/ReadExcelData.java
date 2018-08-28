package com.Ljd.Ljduitest.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

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
					//把单元格中的数值转化为String类型
					Cell cell=row.getCell(j);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
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
