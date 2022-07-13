package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class OrangeHRMTest extends BaseClass {
	
	@Test
  public void LoginPageTest() {
	  
	  //test= extent.createTest("LoginPageTest");
	     WebElement imageweb=driver.findElement(By.xpath("//div[@id='divLogo']//img"));
	     Assert.assertTrue(imageweb.isDisplayed());
  }
  
  @Test
  public void LoginTest() 
  
  {
	  //test=extent.createTest("LoginTest");
	  driver.findElement(By.id("txtUsername")).sendKeys("admin1");
	  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	  driver.findElement(By.id("btnLogin")).click();
	  
	  
	  String actualtitle=  driver.getTitle();
	  String expectedtitle = "OrangeHRM1";
	  
	  Assert.assertEquals(actualtitle, expectedtitle);
  }
  

  //https://github.com/sanjay059/OrangeHRM.git
	
 
}
