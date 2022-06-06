package com.TestCases;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.PageObject.LoginPage;

public class TC_01 extends BaseClass{
public TC_01() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

@Test
public void logintest() throws IOException
{
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(username);
	logger.info("Username Provided");
	lp.setPassword(password);
	logger.info("Password Provided");
	lp.ClickSubmit();
	logger.info("Submitted");
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	{
		Assert.assertTrue(true);
		logger.info("TEST CASE PASSED");
	}
	else
	{
		captureScreen(driver,"logintest");
		Assert.assertTrue(false);
		logger.info("Title failed");
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)", "");

	lp.clicklogout();
	driver.switchTo().alert().accept();
	driver.switchTo().defaultContent();
}

	}
	
	
	

