package com.Ljd.Ljduitest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Ljd.Ljduitest.common.BasePage;

public class LjHomePage extends BasePage{
    
	//首页信息披露
	@FindBy (xpath = "/html/body/div[2]/ul/li[2]/a")
	WebElement login_link;
	
	public LjHomePage(WebDriver driver) {
		super(driver);
	}
	
	//首页点击信息披露按钮跳转
	public LjLoginPage clickLoginButton(){
		//判断元素是否在当前页面显示
		verifyElementIsPresent(login_link);
		click(login_link);
		return new LjLoginPage(driver);
	}
}
