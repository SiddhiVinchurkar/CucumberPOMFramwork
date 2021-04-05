package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By accSection=By.cssSelector("div#center_column span");
	
	public AccountsPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getAccountsPageTitle()
	{
		return elementUtil.getTitle();
	}
	
	public int getAccountsSectionCount()
	{
		return elementUtil.getSize(accSection);	
	}
	
	public List<String> getAccountsSectionList()
	{
		List<String> accList = new ArrayList<>();
		
		List<WebElement> accHeaderList =elementUtil.getElements(accSection);
		
		for(WebElement e:accHeaderList)
		{
			accList.add(e.getText());
		}
		
		return accList;
	}
}
