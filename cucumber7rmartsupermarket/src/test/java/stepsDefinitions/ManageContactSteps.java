package stepsDefinitions;

import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ManageContactPage;

public class ManageContactSteps
{
	LoginPage loginpage;
	HomePage homepage;
	ManageContactPage managecontactpage;	
	
	//****************************************Edit Contact Us information**********************//
	@Given("I navigated to the Contact Us page")
	public void i_navigated_to_the_contact_us_page() {
		homepage=new HomePage(BaseClass.getDriver());
		homepage.clickOnManageContact();
	}

	@When("I click on Edit Button")
	public void i_click_on_edit_button() {
		managecontactpage=new ManageContactPage(BaseClass.getDriver());
		managecontactpage.clickTheEditButton();
	    
	}

	@When("I Edit the phone number field and delivery time")
	public void i_edit_the_phone_number_field_and_delivery_time() {
		managecontactpage.editContactUsInformation("+91-23745854578","40");
	}

	@When("I click on Update button")
	public void i_click_on_update_button() {
		managecontactpage.clickUpdateButton();
	}

	@Then("I should see an alert as {string}")
	public void i_should_see_an_alert_as(String string) {
		boolean greenAlertDisplayedStatus=managecontactpage.isSuccessAlertDisplayed();
	    Assert.assertTrue(greenAlertDisplayedStatus);   
	}
}
