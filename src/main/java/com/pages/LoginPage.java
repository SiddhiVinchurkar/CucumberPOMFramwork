package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	// By locators 
	
	private By email = By.id("email");
	private By passwd = By.id("passwd");
	private By loginButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");
	private By socialLinks = By.xpath("//section[@id='social_block']//li");
	
	// Constructor
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//Page actions
	
	public String getLoginPageTitle()
	{
		return elementUtil.getTitle();
	}
	
	public boolean isForgotPwdLinkExists()
	{
		return elementUtil.isLinkDisplayed(forgotPwdLink);
	}
	
	public void enterUsername(String username)
	{
		elementUtil.doSendKeys(email, username);
	}
	
	public void enterPwd(String pwd)
	{
		elementUtil.doSendKeys(passwd, pwd);
	}
	
	public void clickOnLogin()
	{
		elementUtil.doClick(loginButton);
	}
	
	public int socialMediaLinksCount()
	{
		return elementUtil.getSize(socialLinks);
	}
	
	public AccountsPage doLogin(String un,String pwd)
	{
		System.out.println("Login with username : "+un+" and pwd : "+pwd);
		
		elementUtil.doSendKeys(email, un);
		elementUtil.doSendKeys(passwd, pwd);
		elementUtil.doClick(loginButton);
		
		return new AccountsPage(driver);
	}
}
