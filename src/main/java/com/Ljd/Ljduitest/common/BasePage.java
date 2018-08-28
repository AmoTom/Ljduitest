package com.Ljd.Ljduitest.common;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Ljd.Ljduitest.common.LogType.LogTypeName;
import com.google.common.io.Files;

public class BasePage {
	public static WebDriver driver;
	public static String pageTitle;
	public static String pageUrl;
	
	//构造方法
	protected  BasePage(WebDriver driver){
		BasePage.driver = driver;
	}
	
	//在文本框内输入字符
	protected void type(WebElement element, String text){
		try{
			if(element.isEnabled()){
				element.clear();
				Logger.Output(LogTypeName.INFO, "清空输入框。");
				element.sendKeys(text);
				Logger.Output(LogTypeName.INFO, "输入文本数据:"+text);
			}
		} catch (Exception e){
			Logger.Output(LogTypeName.ERROR, e.getMessage()+".");
		}
	}
	
    //点击元素，点击鼠标左键
	protected void click(WebElement element){
		try {
				if (element.isEnabled()) {
						element.click();
						Logger.Output(LogType.LogTypeName.INFO, "Element: "+element.toString()+" was clicked.");
					}
				} catch (Exception e) {
						Logger.Output(LogType.LogTypeName.ERROR, e.getMessage()+".");
						}
		}

     //在文本输入框执行清除操作
	protected void clean(WebElement element){
		try {
				if (element.isEnabled()) {
					element.clear();
					Logger.Output(LogType.LogTypeName.INFO, "Element "+element.toString()+" was cleaned.");
				}
			} catch (Exception e) {
				Logger.Output(LogType.LogTypeName.ERROR, e.getMessage()+".");
			}
		}

     //判断一个页面元素是否显示在当前页面
	protected void verifyElementIsPresent(WebElement element){
	    try {
				if (element.isDisplayed()) {
					Logger.Output(LogType.LogTypeName.INFO, "This Element " + element.toString().trim()+" is present.");
				}
			} catch (Exception e) {
				Logger.Output(LogType.LogTypeName.ERROR, e.getMessage()+".");
			}
	    }

	// 获取页面的标题
	public String getCurrentPageTitle(){
	    pageTitle=driver.getTitle();
	    Logger.Output(LogType.LogTypeName.INFO, "Current page title is "+pageTitle);
	    return pageTitle;
	   }

     //获取页面的url
	public String getCurrentPageUrl(){
	    pageUrl=driver.getCurrentUrl();
	    Logger.Output(LogType.LogTypeName.INFO, "Current page title is "+pageUrl);
	    return pageUrl;
	   }
    
     //处理多窗口之间切换
    public void switchWindow(){
	  String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄  
      Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄  
      Logger.Output(LogType.LogTypeName.INFO, "当前窗口数量： "+ handles.size());  
      Iterator<String> it = handles.iterator();  
      while (it.hasNext()) {  
          if (currentWindow == it.next()) {  
          	 continue;
          }  
          try {  
        	  driver.close();// 关闭旧窗口
              WebDriver window = driver.switchTo().window(it.next());// 切换到新窗口 
              Logger.Output(LogType.LogTypeName.INFO, "new page title is "+ window.getTitle());
            } catch (Exception e) {  
          	  Logger.Output(LogType.LogTypeName.ERROR,"法切换到新打开窗口"+ e.getMessage());  
          }  
          //driver.close();//关闭当前焦点所在的窗口  
      }  
      // driver.switchTo().window(currentWindow);//回到原来页面  
	}  
    
    //页面截图操作
    public void TakeScreenshot(){
    	// 调用截图方法(获取浏览器窗体内的内容)
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
        	Date day = new Date();
        	SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
        	String time = df.format(day);
            // 拷贝截图文件到我们项目./Screenshots
        	Files.copy(src, new File(".\\Screenshots"+"\\"+time+".png"));
        }
        catch (IOException e)
         {
        	System.out.println(e.getMessage());
         }
    }
    //网站文件上传方法
    public void FileUpload (String file) throws Exception{
    	// 指定图片的路径，放到电脑任意地方
    	StringSelection sel = new StringSelection(file);
    	// 把图片文件路径复制到剪贴板
    	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
    	// 新建一个Robot类的对象
	   	 Robot robot = new Robot();
	   	 Thread.sleep(1000);
	
	   	 // 按下 CTRL+V
	   	 robot.keyPress(KeyEvent.VK_CONTROL);
	   	 robot.keyPress(KeyEvent.VK_V);
	   	 
	   	 // 释放 CTRL+V
	   	 robot.keyRelease(KeyEvent.VK_CONTROL);
	   	 robot.keyRelease(KeyEvent.VK_V);
	   	 Thread.sleep(1000);
	
	   	 // 点击回车 Enter 
	   	 robot.keyPress(KeyEvent.VK_ENTER);
	   	 robot.keyRelease(KeyEvent.VK_ENTER);
    }
}