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
		Logger.Output(LogType.LogTypeName.INFO, "进入龙驹带首页...");
		String Welcome = homepage.getText();
		homepage.assertEquals(Welcome, "欢迎来到龙驹贷！");
		homepage.clickLoginButton();
		Logger.Output(LogType.LogTypeName.INFO, "进入信息披露页面...");
		
		//输入正确的用户名和密码点击登录按钮
		LjLoginPage loginpage = PageFactory.initElements(driver, LjLoginPage.class);
		String Platform = loginpage.gettext();
		loginpage.assertEquals(Platform, "平台信息");
		loginpage.clickHonors();
		Logger.Output(LogType.LogTypeName.INFO, "进入荣誉资质并验证是否正确");
		String Honorsurl = loginpage.getCurrentPageUrl();
		loginpage.assertEquals(Honorsurl, "https://stat.longjubank.com/html/Information/platformInfor/honor.html");
		loginpage.clickComProfile();
		Logger.Output(LogType.LogTypeName.INFO, "进入公司简介并验证是否正确");
		String ComProfileurl = loginpage.getCurrentPageUrl();
		loginpage.assertEquals(ComProfileurl, "https://stat.longjubank.com/html/Information/platformInfor/CompanyIntro.html");
	}
	
	@AfterClass
	public void tearDown(){
		driver.close();
	}
}
