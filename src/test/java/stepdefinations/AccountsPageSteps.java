package stepdefinations;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) 
	{
		List<Map<String,String>> credList = credTable.asMaps();
		
		String username = credList.get(0).get("username");
		String pwd = credList.get(0).get("password");
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		accountsPage=loginPage.doLogin(username, pwd);
		
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() 
	{
	    String title = accountsPage.getAccountsPageTitle();
	    System.out.println("Accounts page title : "+ title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionTable) 
	{
		List<String> expAccSectionList = sectionTable.asList();
		
		System.out.println("Expected Account Section List : "+expAccSectionList);
		
		List<String> actualAccSectionList = accountsPage.getAccountsSectionList();
		
		System.out.println("Actual Account Section List : "+actualAccSectionList);
		
		Assert.assertTrue(expAccSectionList.containsAll(actualAccSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expSectionCount) 
	{
		Assert.assertTrue(accountsPage.getAccountsSectionCount() == expSectionCount);
	}

}
