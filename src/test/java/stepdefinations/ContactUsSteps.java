package stepdefinations;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.pages.ContactUsPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ContactUsSteps {
	
	private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());

	
	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() 
	{
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber)
	{
		    ExcelReader reader = new ExcelReader();
	
			List<Map<String, String>> testData;
			try 
			{
				testData = reader.getData("C:\\Users\\siddhi.vinchurkar\\Documents\\automation.xlsx", sheetName);
			
				String heading = testData.get(rowNumber).get("subjectheading");
				String email = testData.get(rowNumber).get("email");
				String orderRef = testData.get(rowNumber).get("orderref");
				String message = testData.get(rowNumber).get("message");
			
				contactUsPage.fillContactUsForm(heading, email, orderRef, message);

			} 
			catch (InvalidFormatException e) 
			{
				System.out.println("File in invalid format");
			} 
			catch (IOException e) 
			{
				System.out.println("File not found at mentioned location");
			}
				
	 }

	@When("user clicks on send button")
	public void user_clicks_on_send_button()
	{
		contactUsPage.clickSend();
	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String expSuccessMsg) 
	{
		String actualMsg = contactUsPage.getSuccessMessg();
		Assert.assertEquals(actualMsg, expSuccessMsg);
	}

}
