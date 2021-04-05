package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.qa.util.ElementUtil;

public class ContactUsPage {

	
	private WebDriver driver;
	private ElementUtil elementUtil;

	private By subjectHeading = By.id("id_contact");
	private By email = By.id("email");
	private By orderRef = By.id("id_order");
	private By messageText = By.id("message");
	private By sendButton = By.id("submitMessage");
	private By successMessg = By.cssSelector("div#center_column p");
	

	public ContactUsPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getContactUsPageTitle() 
	{
		return elementUtil.getTitle();
	}
	
	public void fillContactUsForm(String heading, String emailId, String orderReference, String message) 
	{
		
		elementUtil.doSelectDropDownByVisibleText(subjectHeading, heading);
		
		elementUtil.doSendKeys(email, emailId);
		elementUtil.doSendKeys(orderRef, orderReference);
		elementUtil.doSendKeys(messageText, message);
	}

	public void clickSend() 
	{

		elementUtil.doClick(sendButton);
	}
	
	public String getSuccessMessg() 
	{
		return elementUtil.doGetText(successMessg);
	}
}
