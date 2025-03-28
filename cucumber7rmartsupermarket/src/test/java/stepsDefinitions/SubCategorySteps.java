package stepsDefinitions;

import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SubCategoryPage;

public class SubCategorySteps{
	
	LoginPage loginpage;
	HomePage homepage;
	SubCategoryPage subcategorypage;
	
	//**************************************************Add a SubCategory Item********************************//
	@Given("I navigated to the Sub Category page")
	public void i_navigated_to_the_sub_category_page() {
		homepage=new HomePage(BaseClass.getDriver());
    	homepage.clickOnSubCategory();
	}

	@When("I click on the New button in Sub Category Page")
	public void i_click_on_the_new_button_in_sub_category_page() {
		subcategorypage=new SubCategoryPage(BaseClass.getDriver()); 
		subcategorypage.clickTheNew_Button();
	}

	@When("Selected the Category Field from dropdown as {string} and filled SubCategory Field as {string} and chosen an Image")
	public void selected_the_category_field_from_dropdown_as_and_filled_sub_category_field_as_and_chosen_an_image(String Category, String SubCategory) {
		subcategorypage.addSubCategoryDetails(Category,SubCategory);
	}

	@When("I clicked the Save Button in SubCategory Page")
	public void i_clicked_the_save_button_in_sub_category_page() {
		subcategorypage.clickTheSaveButton();
	}

	@Then("I should see a confirmation message as {string} in SubCategory Page")
	public void i_should_see_a_confirmation_message_as_in_sub_category_page(String string) {
		boolean greenAlertBoxDisplaystatus=subcategorypage.isGreenAlertboxDispalyed();
	    Assert.assertTrue(greenAlertBoxDisplaystatus);
	}
	//**************************************************Search for a SubCategory Item********************************//
	@When("I click on the Search Button in Sub Category Page")
	public void i_click_on_the_search_button_in_sub_category_page() {
		subcategorypage=new SubCategoryPage(BaseClass.getDriver()); 
		subcategorypage.clickSearchButton();
	}

	@When("I Selected the Category Field from dropdown as as {string} and filled Subcategory Field and {string}")
	public void i_selected_the_category_field_from_dropdown_as_as_and_filled_subcategory_field_and(String Category, String SubCategory) {
		subcategorypage.searchSubCategory(Category,SubCategory);
	}

	@When("I clicked the  Red Search Button in Sub Category Page")
	public void i_clicked_the_red_search_button_in_sub_category_page() {
		subcategorypage.clickSearchButtonRed();
	}

	@Then("I should see the searched Sub Category and its details in the search results")
	public void i_should_see_the_searched_sub_category_and_its_details_in_the_search_results() {
		boolean actual=subcategorypage.SearchedSubCategoryAvailability();	
	    Assert.assertTrue(actual);	
	}
	//**************************************Delete A SubCategotry*******************************************//
	@When("I click on the Blue Search Button in Sub Category Page")
	public void i_click_on_the_blue_search_button_in_sub_category_page() {
		subcategorypage=new SubCategoryPage(BaseClass.getDriver()); 
		subcategorypage.clickSearchButton();
	}

	@When("I Selected the Category Field from dropdown as as {string} and filled Subcategory Field as {string} I wants to delete")
	public void i_selected_the_category_field_from_dropdown_as_as_and_filled_subcategory_field_as_i_wants_to_delete(String Category, String SubCategory) {
		subcategorypage.searchSubCategory(Category,SubCategory);
	}

	@When("I click on Red Search button in Sub Category Page then I can see the searched Category in the below table")
	public void i_click_on_red_search_button_in_sub_category_page_then_i_can_see_the_searched_category_in_the_below_table() {
		subcategorypage.clickSearchButtonRed();
	}

	@When("I click on the delete icon then in the subCategory page then I should see a POP up alert for delete confirmation and I click on OK button")
	public void i_click_on_the_delete_icon_then_in_the_sub_category_page_then_i_should_see_a_pop_up_alert_for_delete_confirmation_and_i_click_on_ok_button() {
		subcategorypage.deleteSubCategory();
	}

	@Then("I should see a delete confirmation message as 'User Deleted successfully'in the Subcategory page.")
	public void i_should_see_a_delete_confirmation_message_as_user_deleted_successfully_in_the_subcategory_page() {
		String actualText=subcategorypage.getDeleteSuccessAlertmessage();
    	String expectedText="Sub Category Deleted Successfully";
    	Assert.assertTrue(actualText.contains(expectedText), "User deletion Unsuccessful");
	}
}
