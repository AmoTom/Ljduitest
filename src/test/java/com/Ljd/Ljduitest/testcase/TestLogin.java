package com.Ljd.Ljduitest.testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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
		homepage.clickLoginButton();
		Logger.Output(LogType.LogTypeName.INFO, "进入信息披露页面.............");
		
		//输入正确的用户名和密码点击登录按钮
		LjLoginPage loginpage = PageFactory.initElements(driver, LjLoginPage.class);
		String Platform = loginpage.gettext();
		Assert.assertEquals(Platform, "平台信息");
		Logger.Output(LogType.LogTypeName.INFO, "进入信息披露并验证是否正确");
		loginpage.clickHonors();
		String Honorsurl = loginpage.getCurrentPageUrl();
		Assert.assertEquals(Honorsurl, "https://stat.longjubank.com/html/Information/platformInfor/honor.html");
		Logger.Output(LogType.LogTypeName.INFO, "进入荣誉资质并验证是否正确");
		loginpage.clickComProfile();
		String ComProfileurl = loginpage.getCurrentPageUrl();
		Assert.assertEquals(ComProfileurl, "https://stat.longjubank.com/html/Information/platformInfor/CompanyIntro.html");
		Logger.Output(LogType.LogTypeName.INFO, "进入公司简介并验证是否正确");
	}
	
	@AfterClass
	public void tearDown(){
		driver.close();
	}
}
