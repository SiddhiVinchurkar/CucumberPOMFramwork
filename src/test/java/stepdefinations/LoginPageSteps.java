package stepdefinations;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


/*
 * In this file do not maintain By locators or any page methods
 */

public class LoginPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	private static String title;

	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException 
	{
	
		DriverFactory.getDriver()
		.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}
	
	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() 
	{
		title=loginPage.getLoginPageTitle();
		System.out.println("Page title is :"+ title);
	}
	
	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) 
	{
		Assert.assertTrue(title.contains(expectedTitle));
	}
	
	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed()
	{
		Assert.assertTrue(loginPage.isForgotPwdLinkExists());
	}
	
	@When("user enters username {string}")
	public void user_enters_username(String username) 
	{
		loginPage.enterUsername(username);
	}
	
	@When("user enters password {string}")
	public void user_enters_password(String pwd) 
	{
		loginPage.enterPwd(pwd);
	}
	
	@When("user clicks on Login button")
	public void user_clicks_on_login_button() 
	{
		loginPage.clickOnLogin();
	}
	
	@Then("social links visible on the page are {int}")
	public void social_links_visible_on_the_page_are(Integer expLinksCount) 
	{
	  Assert.assertTrue(loginPage.socialMediaLinksCount() == expLinksCount);
	}

}
