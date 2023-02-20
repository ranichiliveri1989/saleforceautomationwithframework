package com.jan23.regularprograms;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindAllLinks {
	
	public static WebDriver getDriver(String url) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	     driver.get(url);
		return driver;
		
	}
	public static void closeDriver(WebDriver driver)
	{
		
		driver.close();
	}
	public static void findBrokenLinks(String links) throws IOException
	{
		try {
		URL hlinks=new URL(links);
		
		
		HttpURLConnection httpConn = (HttpURLConnection) hlinks.openConnection();
		 httpConn.connect();
		 int code = httpConn.getResponseCode();
		 if(code>=400)
		 {
			 System.out.println("this is broken link:"+links);
		 }
		}
		
		
		catch(Exception  e )
		{
			System.out.println("its not a valid url:"+links);
		}
		
		}
		
	@Test
    public static void getLinks() throws InterruptedException, IOException
    {
		String url="https://www.zlti.com/";
    	WebDriver driver=getDriver(url);
    	Thread.sleep(5000);
    	
    	int count=0;
    
    	List<WebElement> links=driver.findElements(By.xpath("//*[@src or @href]"));
    	
    	for(WebElement wb:links)
    	{
    		String hrefLinks = wb.getAttribute("href");
    		String srcLinks = wb.getAttribute("src");
    		if(hrefLinks != null )
    		{	
      	    count++;
      	    findBrokenLinks(hrefLinks);
      	    
    		}
    		
    		else if(srcLinks != null )
    		{
    	    count++;
    	    findBrokenLinks(srcLinks);
    		}
    		
    	}
    	System.out.println("total url's in this page are:"+count);
    	closeDriver(driver);
    	
    	
    }
	
	
	
}
