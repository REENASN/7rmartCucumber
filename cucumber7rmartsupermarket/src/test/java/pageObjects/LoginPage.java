package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.BaseClass;


public class LoginPage extends BaseClass
{
	WebDriver driver;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userName_Field;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password_Field;
	
	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	private WebElement signIn_Button;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']//h5[contains(text(),'Alert!')]")
	private WebElement invalidAlert_Message;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String userName) {
		userName_Field.sendKeys(userName);
	}

	public void enterPassword(String password) {
		password_Field.sendKeys(password);
	}

	public void clickOnSignInButton() {
		signIn_Button.click();
	}

	public boolean alertMessageForInvalidCredentials()
	{
	   return invalidAlert_Message.isDisplayed();
	}
}

