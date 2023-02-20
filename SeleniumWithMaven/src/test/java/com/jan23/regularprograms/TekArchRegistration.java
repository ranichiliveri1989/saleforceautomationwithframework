package com.jan23.regularprograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TekArchRegistration {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.32.0-win32\\geckodriver.exe ");
		
		WebDriverManager.edgedriver().setup();
		WebDriver fd=new EdgeDriver();
		fd.get("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(2000);
		
		
		By uname=By.id("email_field");
		WebElement emailid=fd.findElement(uname);
		emailid.sendKeys("admin123@gmail.com");
		
		
		By password=By.xpath("//*[@id=\"password_field\"]");
		WebElement passcheck=fd.findElement(password);
		passcheck.sendKeys("admin123");
		
		By login=By.xpath("/html/body/div[1]/button");
		WebElement loginbutton=fd.findElement(login);
		loginbutton.click();
		
		Thread.sleep(3000);
        
		WebElement namecheck=fd.findElement(By.id("name"));
		namecheck.sendKeys("rani");
		
		 
		WebElement fnamecheck=fd.findElement(By.name("lastname"));
		fnamecheck.sendKeys("ranidad");
		
		 
		WebElement postaladdress=fd.findElement(By.id("postaladdress"));
		postaladdress.sendKeys("raniaddress");
		
		 
		WebElement personaladdress=fd.findElement(By.id("personaladdress"));
		personaladdress.sendKeys("ranipersonaladdress");
		
		
		
		
		
		
		
		
		
		
		/*WebElement fname=fd.findElement(By.name("lastname"));
		fname.sendKeys("ranidad");
		
		
		WebElement paddress=fd.findElement(By.id("postaladdress"));
		paddress.sendKeys("raniaddress");
		
		/*
		
		By login=By.xpath("/html/body/div[1]/button");
		WebElement loginbutton=fd.findElement(login);
		loginbutton.click();*/
		
		
		
		
		
		
		
		
		
		
				
		

		// TODO Auto-generated method stub

	}

}
