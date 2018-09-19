package com.Ljd.Ljduitest.webdriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.Ljd.Ljduitest.common.LogType;
import com.Ljd.Ljduitest.common.Logger;


public class BrowserEngine {
	public String browserName;
	public String serverURL;
	public WebDriver driver;

	public void initConfigData() throws IOException{
		Properties p = new Properties();
		// 加载配置文件
		InputStream ips = new FileInputStream(".\\TestConfig\\config.properties");
		//读取文件的数据
		p.load(ips);
		Logger.Output(LogType.LogTypeName.INFO, "Start to select browser name from properties file");
		browserName=p.getProperty("browserName");
		Logger.Output(LogType.LogTypeName.INFO, "Your had select test browser type is: "+ browserName);
		serverURL = p.getProperty("URL");
		Logger.Output(LogType.LogTypeName.INFO, "The test server URL is: "+ serverURL);
		ips.close();
	}

	public WebDriver getBrowser(){
		if(browserName.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver", ".\\Tools\\geckodriver.exe");	
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			Logger.Output(LogType.LogTypeName.INFO, "Loading and opening Firefox ...");
		}else if(browserName.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			Logger.Output(LogType.LogTypeName.INFO, "Loading and opening Chrome ...");
		}else if(browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", ".\\Tools\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
			driver.manage().window().maximize();
			Logger.Output(LogType.LogTypeName.INFO, "Loading and opening IE ...");
		}
		driver.get(serverURL);
		Logger.Output(LogType.LogTypeName.INFO, "Open URL: "+ serverURL);
		callWait(5);
		return driver;
	}
	/*
	 * 关闭浏览器并退出方法
	 */
	public void tearDown() throws InterruptedException{
		Logger.Output(LogType.LogTypeName.INFO, "Closing browser...");
		driver.quit();
		Thread.sleep(3000);
	}
	
	/*
	 * 隐式时间等待方法
	 */
	public void callWait(int time){
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
		Logger.Output(LogType.LogTypeName.INFO, "Wait for "+time+" seconds.");
	}
}