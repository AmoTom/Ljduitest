package com.Ljd.Ljduitest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Ljd.Ljduitest.common.BasePage;

public class LjDisclosurePage extends BasePage{

	public LjDisclosurePage(WebDriver driver) {
		super(driver);
	}
	
	//信息披露中检验条件
	@FindBy (xpath="/html/body/div[2]/div[1]/div/div/ul[1]/li[1]/span")
	WebElement Platform;

	//信息披露中公司简介
	@FindBy (linkText="公司简介")
	WebElement ComProfile;
	
	//信息披露中荣誉资质
	@FindBy (linkText="荣誉资质")
	WebElement Honors;
	
	public String gettext(){
		return Platform.getText();
	}
		
	public void clickComProfile(){
		click(ComProfile);
	}
	
	public void clickHonors(){
		click(Honors);
	}
	
	
}
