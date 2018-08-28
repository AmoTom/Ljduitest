package com.Ljd.Ljduitest.data;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.Ljd.Ljduitest.common.ReadExcelData;

public class BaiDuData {
	@DataProvider(name="TestData")
	public static Object[][] words() throws IOException{
		return ReadExcelData.getTestData(".\\Files\\","test-data.xlsx","Sheet1");
	}
	
	@DataProvider(name="TestDat1")
	public static Object[][] words1() throws IOException{
		return ReadExcelData.getTestData(".\\Files\\","test-data.xlsx","Sheet2");
	}
}
