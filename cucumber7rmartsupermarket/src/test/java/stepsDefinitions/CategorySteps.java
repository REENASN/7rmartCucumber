package stepsDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.AdminUsersPage;
import pageObjects.CategoryPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class CategorySteps {

	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	AdminUsersPage adminuserpage;
	CategoryPage categorypage;
	
	@Given("I navigated to the Category page")
	public void i_navigated_to_the_category_page() {
		homepage=new HomePage(BaseClass.getDriver());
		homepage.clickOnCategory();
	}

	@When("Filled the fields category,select groups,chose Image,select radio buttons")
	public void filled_the_fields_category_select_groups_chose_image_select_radio_buttons() {
		categorypage=new CategoryPage(BaseClass.getDriver());
		String category="BeautyProducts";
	    categorypage.addCategoryDetails(category);
	}
	
	@When("I click on the Red save Button")
	public void i_click_on_the_red_save_button() {
		categorypage.clickOnSaveButton();   
	}

	@Then("I should see a confirmation message as {string}")
	public void i_should_see_a_confirmation_message_as(String expectedData) {
		boolean alertMessageStatus=categorypage.getSavebuttonAlertMessage();
		Assert.assertTrue(alertMessageStatus);
	}
//***********************************Search for a category*********************************************//
	@When("I click on the Blue Search Button")
	public void i_click_on_the_blue_search_button() {
		categorypage=new CategoryPage(BaseClass.getDriver());
		categorypage.clickOnSearchButton();  
	}

	@When("Fill the Category Field with the Category you wants to search")
	public void fill_the_category_field_with_the_category_you_wants_to_search() {
		categorypage.searchCategories("BeautyProducts");	
	}

	@When("I click on Red Search button")
	public void i_click_on_red_search_button() {
		categorypage.clickOnSubmitSearchButton();
	}

	@Then("I should see the searched Category in the table below")
	public void i_should_see_the_searched_category_in_the_table_below() {
		 boolean actual=categorypage.SearchedCategoryAvailability();	
		 Assert.assertTrue(actual);
	}

//*****************************Add an existing category************************************//
	@Then("I should see a message as {string}")
	public void i_should_see_a_message_as(String string) {
		String actualAlert= categorypage.getDuplicationAlertMessage();
	    String expectedAlert="Alert!";
	    Assert.assertEquals(actualAlert,expectedAlert);
	}

//************************************Delete a Category************************************//
	
	@When("I click on the delete icon then I should see a POP up alert for delete confirmation and I click on OK button")
	public void i_click_on_the_delete_icon_then_i_should_see_a_pop_up_alert_for_delete_confirmation_and_i_click_on_ok_button() {
		categorypage.clickOnDelete();
	}

	@Then("I should see a delete confirmation message as {string}")
	public void i_should_see_a_delete_confirmation_message_as(String string) {
		String PopupText=categorypage.SwitchtoalertAndCatchPoPUpMessage();
		System.out.println(PopupText);
	}
}
