package stepsDefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.AdminUsersPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class AdminUsersSteps {
	
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	AdminUsersPage adminuserpage;
	
	//************************Add new user***********************************************************//
	@Given("I am logged into the Admin login page")
	public void i_am_logged_into_the_admin_login_page() {
		
		loginpage=new LoginPage(BaseClass.getDriver());
		loginpage.enterUserName("admin");
		loginpage.enterPassword("admin");;
		loginpage.clickOnSignInButton();       
	}

	@Given("I navigated to the Admin Users page")
	public void i_navigated_to_the_admin_users_page() {
	    
		homepage=new HomePage(BaseClass.getDriver());
		homepage.clickOnAdminUsers();
	}

	@When("I click on the New Button")
	public void i_click_on_the_new_button() {
	   
		adminuserpage=new AdminUsersPage(BaseClass.getDriver());
		adminuserpage.clickOnNewButton();
	}

	@When("Filled the following details username,password and select usertype")
	public void filled_the_following_details_username_password_and_select_usertype(DataTable dataTable) {
	    
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		//adminuserpage=new AdminUsersPage(BaseClass.getDriver());
		adminuserpage.enterUserName(dataMap.get("Username"));
		adminuserpage.enterPassword(dataMap.get("Password"));
		adminuserpage.enterUserType(dataMap.get("UserType"));
	}

	@When("I click on the save Button")
	public void i_click_on_the_save_button() {
	   
		adminuserpage.clickOnSaveButton();
	}

	@Then("I should see a confirmation message {string}")
	public void i_should_see_a_confirmation_message(String string) {
	    
		String actual_SuccessText=adminuserpage.getSaveButtonText();
	    String expected_SuccessText="Alert!";
	    Assert.assertEquals(actual_SuccessText,expected_SuccessText);
	}
	//*************************************** new user creation using data from the Table*******************//
	@When("the Admin user enters {string},{string} and {string}")
	public void the_admin_user_enters_and(String Username, String Password, String UserType) {
		adminuserpage.enterUserName(Username);
		adminuserpage.enterPassword(Password);
		adminuserpage.enterUserType(UserType);
	}
	//***********************************New user creation using Random Username and password***************//
		@When("Filled the details username,password and select usertype")
		public void filled_the_details_username_password_and_select_usertype() {
		
			adminuserpage.enterUserName(BaseClass.randomeString());
			adminuserpage.enterPassword(BaseClass.randomeString());
			adminuserpage.enterUserType("Admin");
	}	
	//***********************************Add new user using faker class***************************************//
		
		@When("Filled the details username,password using Faker class and select usertype")
		public void filled_the_details_username_password_using_faker_class_and_select_usertype() {
			adminuserpage.addNewUserusingFakerClass("Admin");
	}		
	//***********************************Searching for a valid user*******************************************//
	@When("I click on the Search button")
	public void i_click_on_the_search_button() {
	    
		adminuserpage=new AdminUsersPage(BaseClass.getDriver());
		adminuserpage.clickOnSearchButton();
	}

	@When("I enter username as {string} and UserType as {string}")
	public void i_enter_username_as_and_user_type_as(String string, String string2) {
		adminuserpage.enterUserNameForSearchFunction(string);
		adminuserpage.enterUserTypeForSearchFunction(string2);
	}

	@When("click on Red serach button")
	public void click_on_red_serach_button() {
		adminuserpage.clickOnSearchButtonForSearchFunction();
	}

	@Then("I should see the searched users full data in the search results")
	public void i_should_see_the_searched_users_full_data_in_the_search_results() {
	    
	}
	//*********************************Searching for an invalid user********************************************//
	@Then("I should see the message as 'RESULT NOT FOUND'")
		public void i_should_see_the_message_as() {
			String actualData=adminuserpage.searchOption_InvalidData();
		    String expectedData=".........RESULT NOT FOUND.......";
		    Assert.assertEquals(actualData, expectedData);
	}
	//*********************************Admin changes User status***********************************************//
	@When("click on Status badge")
		public void click_on_status_badge() {
			adminuserpage.userStatusChange();    
	}

	@Then("I should see a status change confirmation message as 'User Status Changed Successfully'")
		public void i_should_see_a_status_change_confirmation_message() {
			 String actualData=adminuserpage.getTextAfterStatusChangeOperation();
			 String expectedData="Alert!";
			 Assert.assertEquals(actualData, expectedData);
	}	
	//********************************Admin deletes an existing user******************************************//
	@When("click on the delete icon and I should see a POP up alert for delete confirmation and I click on OK button")
	public void click_on_the_delete_icon_and_i_should_see_a_pop_up_alert_for_delete_confirmation_and_i_click_on_ok_button() {
		
		adminuserpage.clickOnDeleteButton(); 
	}

	@Then("I should see a delete confirmation message {string}")
	public void i_should_see_a_delete_confirmation_message(String string) {
		String actualData= adminuserpage.SwitchtoalertAndCatchPoPUpMessage(); 
	    String expectedData="Do you want to delete this User?";
	    Assert.assertEquals(actualData, expectedData);
	}
	//*******************************verify admin table is displayed or not***********************************//
	@Then("I should see the users data table")
	public void i_could_see_the_users_data_table() {
		adminuserpage=new AdminUsersPage(BaseClass.getDriver());
		 boolean tableDisplaystatus=adminuserpage.getAdminTable();
		 Assert.assertTrue(tableDisplaystatus);
	}
	//*****************************Logout Functionality******************************************************//
	@When("I click on Admin Icon")
	public void i_click_on_admin_icon() {
		adminuserpage=new AdminUsersPage(BaseClass.getDriver());
		adminuserpage.clickOnAdminIcon();
	}

	@When("I click on Logout")
	public void i_click_on_logout() {
		adminuserpage.clickOnLogout();
	}

	@Then("the user should get logged out and Navigated back to Login Page")
	public void the_user_should_get_logged_out_and_navigated_back_to_login_page() {
		String expectedTitle = "Login";
	    String actualTitle = BaseClass.getDriver().getTitle();
	    Assert.assertTrue(actualTitle.contains(expectedTitle));
	}
}
