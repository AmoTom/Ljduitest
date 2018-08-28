package com.Ljd.Ljduitest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Ljd.Ljduitest.common.BasePage;

public class LjHomePage extends BasePage{
	//首页隐藏上面提示
    @FindBy (id = "trusted_show_image")
    WebElement none;
    
	//首页登录链接
	@FindBy (xpath = "/html/body/div[2]/div/div[2]/ul/li[2]/a")
	WebElement login_link;
	
	public LjHomePage(WebDriver driver) {
		super(driver);
	}
	
	//首页点击隐藏按钮，用于显示登录按钮
	public void Clicknone(){
		click(none);
	}
	//首页点击登录按钮跳转登录页面
	public LjLoginPage clickLoginButton(){
		verifyElementIsPresent(login_link);
		click(login_link);
		return new LjLoginPage(driver);
	}
}
