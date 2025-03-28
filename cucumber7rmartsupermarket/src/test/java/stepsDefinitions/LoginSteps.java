package stepsDefinitions;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginSteps {
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	
	//********************Successful login************************************
	@Given("the user is on the 7rmartsupermarket login page")
	public void the_user_is_on_the_7rmartsupermarket_login_page() 
	{
		BaseClass.getLogger().info("user is on 7rmartsupermarket LoginPage.. ");
	}

	@When("the user enters username as {string} and password as {string}")
	public void the_user_enters_username_as_and_password_as(String user, String pwd) {
		BaseClass.getLogger().info("Entering username and password.. ");
		
		loginpage=new LoginPage(BaseClass.getDriver());
		loginpage.enterUserName(user);
		loginpage.enterPassword(pwd);
	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() {
		
		loginpage.clickOnSignInButton();
        BaseClass.getLogger().info("clicked on Sign In button...");	
	}

	@Then("the user should be redirected to the Admin page")
	public void the_user_should_be_redirected_to_the_admin_page() {
		
		BaseClass.getLogger().info("User is on the DashBoard/HomePage");
		
		homepage=new HomePage(BaseClass.getDriver());
		
		String actualDashboardTitle = homepage.getPageTitle();
		String expectedDashboardTitle = "Dashboard";
        Assert.assertTrue(actualDashboardTitle.contains(expectedDashboardTitle));
	}
	//***********************Unsuccessful login************************************//
	@When("the user enters invalid username as {string} and password as {string}")
	public void the_user_enters_invalid_username_as_and_password_as(String user, String pwd) {
		
		BaseClass.getLogger().info("Entering username and password.. ");
		
		loginpage=new LoginPage(BaseClass.getDriver());
		loginpage.enterUserName(user);
		loginpage.enterPassword(pwd);
	}

	@Then("the user should not be redirected to the Admin page")
	public void the_user_should_not_be_redirected_to_the_admin_page() {
		BaseClass.getLogger().info("User still remain in the login page.Sign In Failed.. ");
	}

	@Then("Invalid Username\\/Password Alert should be displayed")
	public void invalid_username_password_alert_should_be_displayed() {
		
		BaseClass.getLogger().info("Invalid username/password Red alert message is displayed");
		
		loginpage=new LoginPage(BaseClass.getDriver());
		boolean isRedAlertMessageDisplayed=loginpage.alertMessageForInvalidCredentials();
		Assert.assertTrue(isRedAlertMessageDisplayed);	
	}
	
	//*********************************Verifying loginpage loads correctly******************
	@Then("the user can verify the loginpage is loaded correctly")
	public void the_user_can_verify_the_loginpage_is_loaded_correctly() {
		 String expectedTitle = "Login";
	     String actualTitle = BaseClass.getDriver().getTitle();
	     Assert.assertTrue(actualTitle.contains(expectedTitle));
	}

	//*******************************Verify the Profile name after successful login***************
	@Then("Admin user can verify the profile Name")
	public void admin_user_can_verify_the_profile_name() {
		loginpage=new LoginPage(BaseClass.getDriver());
		homepage=new HomePage(BaseClass.getDriver());
		
        String expectedProfileName="Admin";
      	String actualProfileName=homepage.getProfileName();
      	Assert.assertEquals(actualProfileName, expectedProfileName);
	}
}
