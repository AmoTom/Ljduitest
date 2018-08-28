package com.Ljd.Ljduitest.testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Ljd.Ljduitest.common.LogType;
import com.Ljd.Ljduitest.common.Logger;
import com.Ljd.Ljduitest.page.LjHomePage;
import com.Ljd.Ljduitest.page.LjLoginPage;
import com.Ljd.Ljduitest.webdriver.BrowserEngine;

public class TestLogin {
	WebDriver driver;
	@BeforeClass
	public void setUp() throws IOException{
		BrowserEngine browserEngine = new BrowserEngine();
		browserEngine.initConfigData();
		driver = browserEngine.getBrowser();
	}
	
	@Test
	public void Login(){
		//进入首页点击登录按钮跳转登录页面
		LjHomePage homepage = PageFactory.initElements(driver, LjHomePage.class);
		homepage.Clicknone();
		homepage.clickLoginButton();
		Logger.Output(LogType.LogTypeName.INFO, "进入登录页面.............");
		
		//输入正确的用户名和密码点击登录按钮
		LjLoginPage loginpage = PageFactory.initElements(driver, LjLoginPage.class);
		loginpage.login("13671573195", "qwe123");
	}
	
	@AfterClass
	public void tearDown(){
		driver.close();
	}
}
