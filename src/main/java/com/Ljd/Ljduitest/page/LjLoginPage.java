package com.Ljd.Ljduitest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Ljd.Ljduitest.common.BasePage;

public class LjLoginPage extends BasePage{

	public LjLoginPage(WebDriver driver) {
		super(driver);
	}
	//登录账户
	@FindBy (id="txtLoginName")
	WebElement loginname;
	//登录密码
	@FindBy (id="txtPassword")
	WebElement loginpwd;
	//登录按钮
	@FindBy (xpath=".//button[@class='sure']")
	WebElement loginbutton;
	
	public void login(String username,String password){
		type(loginname, "username");
		type(loginname, "password");
		click(loginbutton);
	}
}
