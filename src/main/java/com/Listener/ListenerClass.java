package com.Listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.base.BaseClass;
import com.extent.ExtentManager;

public class ListenerClass extends ExtentManager implements ITestListener {

	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				test.log(Status.FAIL,
						MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				test.log(Status.FAIL,
						MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
				String imgPath = BaseClass.screenShot(BaseClass.driver, result.getName());
				//String imgPath = BaseClass.screenShot(driver, result.getName());
				//test.addScreenCaptureFromPath(imgPath);
			
				test.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
