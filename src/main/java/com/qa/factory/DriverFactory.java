package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
	
	public WebDriver init_driver(String browserName)
	{
		System.out.println("Launched Browser is : "+browserName);
		
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browserName.equals("IE"))
		{
			WebDriverManager.iedriver().setup();
			tlDriver.set(new InternetExplorerDriver());
		}
		else if(browserName.equals("Safari"))
		{
			
			tlDriver.set(new SafariDriver());
		}
		else
		{
			System.out.println("Browser name is invalid");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
	}

	
	public static WebDriver getDriver()
	{
		return tlDriver.get();
	}
}
