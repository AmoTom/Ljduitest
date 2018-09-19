package com.Ljd.Ljduitest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Ljd.Ljduitest.common.BasePage;

public class LjHomePage extends BasePage{
	//首页判断条件元素
	@FindBy (className = "welcome")
	WebElement Welcome;
	
	//首页信息披露
	@FindBy (xpath = "/html/body/div[2]/ul/li[2]/a")
	WebElement information;
	
	@FindBy (xpath = "//a[@href = '#/register']")
	WebElement register;
	
	@FindBy (xpath = "//a[@href = '#/login']")
	WebElement login;
	
	public LjHomePage(WebDriver driver) {
		super(driver);
	}
	//获得当前页面判断条件
	public String getText(){
		return Welcome.getText();
	}
	
	//首页点击信息披露按钮跳转
	public LjDisclosurePage clickDisclosureButton(){
		verifyElementIsPresent(information);
		click(information);
		return new LjDisclosurePage(driver);
	}
	
	//点击首页登录按钮
	public LjDisclosurePage clicklogin(){
		click(login);
		return new LjDisclosurePage(driver);
	}
	
	//点击注册按钮
	public LjDisclosurePage clickregister(){
		click(register);
		return new LjDisclosurePage(driver);
	}
}
