package com.jan23.commontests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.jan23.utility.Constants;

public class SfdcLogin extends BaseTest {
	

	@AfterMethod
	public void close()
	{
		driver.close();
	}
	
	@Test
	public static void loginErrorMessageTc1() throws InterruptedException, IOException
	{
		logger.info("Running loginErrorMessageTc1");
		driverSetup("chrome");
		sendKeys("//input[@id='username']", Constants.USER_NAME);
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		password.clear();
		click("//*[@id='Login']");
		String expectedErrorMessage=getText("//*[@id=\"error\"]");
		String actualErrorMessage="Please enter your password.";
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}
	
	@Test
	public static void loginSaleforce() throws InterruptedException, IOException
	{
		logger.info("Running loginSaleforce");
		login();
		String actual_name=driver.findElement(By.id("userNavLabel")).getText();
		Assert.assertEquals(actual_name, "Rani chiliveri");	
	}
	
	@Test
	public static void checkRememberMe() throws InterruptedException, IOException
	{
		logger.info("Running checkRememberMe");
		driverSetup("chrome");
		sendKeys("//input[@id='username']", Constants.USER_NAME);
		sendKeys("//input[@id='password']", Constants.PASSWORD);
		click("//*[@id=\"rememberUn\"]");	
		click("//*[@id='Login']");
		clickMenu();
		// logout
		click("//*[@id=\"userNav-menuItems\"]/a[5]");
		waiting();
		String actualUserName=getText("//*[@id=\"idcard-identity\"]");
		String expectedUserName="rani.ch@adcd.com";
		Assert.assertEquals(expectedUserName, actualUserName);
		
	}
	@Test
	public static void forgotPassword() throws InterruptedException, IOException
	{
		logger.info("Running forgotPassword");
		driverSetup("chrome");
		sendKeys("//input[@id='username']", Constants.USER_NAME);
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		password.clear();
		click("//*[@id=\"forgot_password_link\"]");
		sendKeys("//*[@id=\"un\"]", Constants.USER_NAME);		
		click("//*[@id=\"continue\"]");
		String actualMessage=getText("//*[@id=\"header\"]");
		String expectedMessage="Check Your Email";
		Assert.assertEquals(expectedMessage, actualMessage);	
	}
	
	@Test
	public static void wrongCredentials() throws InterruptedException, IOException 
	{
		logger.info("Running wrongCredentials");
		driverSetup("chrome");
		sendKeys("//input[@id='username']", "123");
		sendKeys("//input[@id='password']","22131");
		click("//*[@id='Login']");
		String actualErrorName=getText("//*[@id=\"error\"]");
		String expectedUserName="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		Assert.assertEquals(expectedUserName, actualErrorName);
	}
	}
	
	
