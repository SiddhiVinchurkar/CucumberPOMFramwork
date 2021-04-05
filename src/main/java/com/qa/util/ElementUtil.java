package com.qa.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;





public class ElementUtil {
	
	private WebDriver driver;
	
		
		public ElementUtil(WebDriver driver) 
		{                                   
			this.driver=driver;
		}
		
		public String getTitle()
		{
			return driver.getTitle();
		}
		
		public  WebElement getElement(By locator)
		{
			return  driver.findElement(locator);
		}

		public  void doSendKeys(By locator,String value)
		{
			WebElement element=getElement(locator);
			element.clear();
			element.sendKeys(value);
		}
		
		public  void doClick(By locator)
		{
			getElement(locator).click();
		}
		
		public List<WebElement> getElements(By locator)
		{
			return driver.findElements(locator);
		}
		
		public int getSize(By locator)
		{
			return getElements(locator).size();
		}

		public boolean isLinkDisplayed(By locator)
		{
			return getElement(locator).isDisplayed();
		}
		
		public String doGetText(By locator) 
		{
			return getElement(locator).getText();
		}
		
		public  void doSelectDropDownByVisibleText(By locator,String text)
		{
			Select sc=new Select(getElement(locator));
			sc.selectByVisibleText(text);		
		}

		
		public void doSelectDropDownByIndex(By locator,int index)
		{
			Select sc=new Select(getElement(locator));
			sc.selectByIndex(index);		
		}
		
		public  void doSelectDropDownByValue(By locator,String value)
		{
			Select sc=new Select(getElement(locator));
			sc.selectByValue(value);		
		}
		
}
