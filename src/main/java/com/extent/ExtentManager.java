package com.extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.base.BaseClass;

public class ExtentManager extends BaseClass{

	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	public static void setExtent() 
	{
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+BaseClass.getCurrentTime()+".html");
		htmlReporter.config().setDocumentTitle("Automation");
		htmlReporter.config().setReportName("HRM auto");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("HostName","MyHost");
		extent.setSystemInfo("ProjectName","HMOrange");
		extent.setSystemInfo("Tester","sanjay");
		extent.setSystemInfo("Browser","Chrome");
	}
	public static  void endReport() 
	{
		
		extent.flush();
	}
	
}
