package stepsDefinitions;

import org.openqa.selenium.WebDriver;

import org.junit.Assert;

import factory.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AdminUsersPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class HomeSteps {
	
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	AdminUsersPage adminuserpage;
	
	//*******************************After successful login Verify HomePage Loads correctly by using PageTitle Verification*******//
	@Given("the user is navigated to the Home page")
	public void the_user_is_navigated_to_the_home_page() {
		
		loginpage=new LoginPage(BaseClass.getDriver());
		loginpage.enterUserName("admin");
		loginpage.enterPassword("admin");;
		loginpage.clickOnSignInButton();    
	}

	@Then("the Admin user can verify the HomePage Title")
	public void the_admin_user_can_verify_the_home_page_title() {
		
		homepage=new HomePage(BaseClass.getDriver());
	    
	    String actualDashboardTitle = homepage.getPageTitle();
	    System.out.println(actualDashboardTitle);
	    String expectedDashboardTitle = "Dashboard | 7rmart supermarket";
	    Assert.assertEquals(actualDashboardTitle, expectedDashboardTitle);
	}
	//*******************************Verify that admin is able to navigate to Admin Users page from HomePage:**************//
	@When("the user click on the moreinfo in the Admin Users Tile")
	public void the_user_click_on_the_moreinfo_in_the_admin_users_tile() {
		
		homepage=new HomePage(BaseClass.getDriver());
		homepage.clickOnAdminUsers();
	}

	@Then("the user should be redirected to the Admin Users Page")
	public void the_user_should_be_redirected_to_the_admin_users_page() {
		
		adminuserpage=new AdminUsersPage(BaseClass.getDriver());
	    String actualAdminUserPageTitle = adminuserpage.getPageTitle();
	    String expectedAdminUserPageTitle = "Admin Users | 7rmart supermarket";
		Assert.assertEquals(actualAdminUserPageTitle, expectedAdminUserPageTitle);
	}
}
