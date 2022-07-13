package com.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.extent.ExtentManager;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;

import java.util.Date;
import java.util.concurrent.TimeUnit;
//import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class BaseClass {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void beforesuite() 
	{
		ExtentManager.setExtent();
		
	}
	
    @AfterSuite
    
    public static void afterSuite()
{
    	ExtentManager.endReport();
      
}
    @BeforeMethod
    public void setup() 
    {
   	
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\neosphere\\eclipse-workspace\\first_project\\Driver\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
			

	
   	 
    }
    
    public static String screenShot(WebDriver driver ,String filename) 
	{
		//String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\Screenshot\\"+filename+".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return destination;
	}
    
    @AfterMethod
    public void tearDown() 
    
    {
   	 
   	
   	 driver.quit();
		}
    
    public static String getCurrentTime() 
    {
    	String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
    	
    	
    }
}
