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
import com.Ljd.Ljduitest.common.assertion;
import com.Ljd.Ljduitest.page.LjDisclosurePage;
import com.Ljd.Ljduitest.page.LjHomePage;
import com.Ljd.Ljduitest.webdriver.BrowserEngine;

public class TestLogin {
	WebDriver driver;
	@BeforeClass
	public void setUp() throws IOException{
		BrowserEngine browserEngine = new BrowserEngine();
		browserEngine.initConfigData();
		driver = browserEngine.getBrowser();
	}
	
	@Test(priority = 0)
	public void homepage(){
		//进入首页点击登录按钮跳转登录页面
		LjHomePage homepage = PageFactory.initElements(driver, LjHomePage.class);
		Logger.Output(LogType.LogTypeName.INFO, "进入龙驹带首页...");
		String Welcome = homepage.getText();
		assertion.verifyassert(Welcome, "欢迎来到龙驹贷", "测试两个字符是否相同:");
		homepage.clickDisclosureButton();
		Logger.Output(LogType.LogTypeName.INFO, "进入信息披露页面...");
		Assert.assertTrue(assertion.flog);
	}
	
	@Test(priority = 1)
	public void disclosurepage(){
		LjDisclosurePage dlrpage = PageFactory.initElements(driver, LjDisclosurePage.class);
		String Platform = dlrpage.getCurrentPageUrl();
		dlrpage.assertEquals(Platform, "https://stat.longjubank.com/html/Information/platformInfor/CompanyIntro.html");
		dlrpage.clickHonors();
		Logger.Output(LogType.LogTypeName.INFO, "进入荣誉资质并验证是否正确");
		String Honorsurl = dlrpage.getCurrentPageUrl();
		dlrpage.assertEquals(Honorsurl, "https://stat.longjubank.com/html/Information/platformInfor/honor.html");
		dlrpage.clickComProfile();
		Logger.Output(LogType.LogTypeName.INFO, "进入公司简介并验证是否正确");
		String ComProfileurl = dlrpage.getCurrentPageUrl();
		dlrpage.assertEquals(ComProfileurl, "https://stat.longjubank.com/html/Information/platformInfor/CompanyIntro.html");
		
	}
	
	@AfterClass
	public void tearDown(){
		driver.close();
	}
}
