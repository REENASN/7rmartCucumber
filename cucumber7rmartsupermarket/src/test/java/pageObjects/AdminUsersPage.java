package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.BaseClass;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage extends BaseClass{
	
		WebDriver driver;
		PageUtility pageutility=new PageUtility(BaseClass.getDriver());
		GeneralUtility generalutility=new GeneralUtility();
		WaitUtility waitutility=new WaitUtility(driver);
		
		@FindBy(xpath = "//table")
		private WebElement adminTable;
		
		@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
		private WebElement btn_New;
		
		@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
		private WebElement btn_Search;
		
		@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
		private WebElement btn_Reset;
		
		@FindBy(xpath = "//input[@id='username']")
		private WebElement input_Username;
		
		@FindBy(xpath = "//input[@id='password']")
		private WebElement input_password;
		
		@FindBy(xpath = "//select[@id='user_type']")
		private WebElement select_Usertype;
		
		@FindBy(xpath = "//div[@class='card-footer center']//button[@type='submit']")
		private WebElement btn_Save;
		
		@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5[contains(text(),'Alert!')]")
		private WebElement btn_Save_Success_Message;
		
		@FindBy(xpath = "//table//tbody//tr//td[1]")
		private WebElement table_Firstrow_UserName;
		
		@FindBy(xpath = "//div[@class='col-sm-6 form-group']//input")
		private WebElement input_Search_Username;
		
		@FindBy(xpath = "//div[@class='col-sm-6 form-group']//select[@class='form-control']")
		private WebElement input_Search_Usertype;
		
		@FindBy(xpath = "//div[@class='card-body']//button[@name='Search']")
		private WebElement btn_Search_Search;
		
		@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']//h5[text()=' Alert!']")
		private WebElement alert_UnSuccessful;
		
		@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr")
		private List<WebElement> table_Data_Searched;
		
		@FindBy(xpath = "//span[@id='res']//center[contains(text(),'.........RESULT NOT FOUND.......')]")
		private WebElement not_Found_Search_Data;
		
		@FindBy(xpath = "//table//tbody//tr[1]//td[5]//a[3]")
		private WebElement btn_DeleteForFirstRow;
		
		@FindBy(xpath = "//table//tbody//tr[1]//td[3]")
		private WebElement btn_status_FirstRowUser;
		
		@FindBy(xpath = "//table//tbody//tr[1]//td[5]//a[1]")
		private WebElement btn_Change_Status;
		
		@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5[text()=' Alert!']")
		private WebElement alert_Change_Status;
		
		@FindBy(xpath = "//table//tbody//tr[1]//td[4]")
		private WebElement btn_Password_showDetails;
		
		@FindBy(xpath = "//table//tbody//tr[2]//span")
		private WebElement display_Password_Details;
		
		@FindBy(xpath = "//table//tbody//tr//td[5]//a[2]")
		private WebElement btn_Edit;
		
		@FindBy(xpath = "//div[@class='card-footer center']//button[@type='submit']")
		private WebElement updateButton;
		
		@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
		private WebElement updateSuccessAlert;
		
		@FindBy(xpath = "//li[@class='nav-item dropdown']//a[@class='nav-link']")
		private WebElement admin_icon;
		
		@FindBy(xpath = "//li[@class='nav-item dropdown show']//div//a[2]")
		private WebElement Logout_icon;
		
		public AdminUsersPage(WebDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		public String getPageTitle()
		{
			return driver.getTitle();
		}
		
		public boolean getAdminTable()
		{
			 return adminTable.isDisplayed();
		}
		
		public boolean getNewButtonStatus()
		{
			System.out.println("Button Name:::"+btn_New.getText());
			return btn_New.isDisplayed();
		}

		public boolean getSearchButtonStatus()
		{
			System.out.println("Button Name:::"+btn_Search.getText());
			return btn_Search.isDisplayed();
		}
		
		public boolean getResetButtonStatus()
		{
			System.out.println("Button Name:::"+btn_Reset.getText());
			return btn_Reset.isDisplayed();
		}
		
		public void clickOnNewButton()
		{
			btn_New.click();
		}
		
		public void enterUserName(String userName) {
			input_Username.clear();
			input_Username.sendKeys(userName);
		}

		public void enterPassword(String password) {
			input_password.sendKeys(password);
		}

		public void enterUserType(String userType) {
			select_Usertype.sendKeys(userType);
		}
		
		public void clickOnSaveButton()
		{   
			 btn_Save.click();
		}
		
		public String getSaveButtonText()
		{
			return btn_Save_Success_Message.getText();
		}
		
		public void enterUserNameForSearchFunction(String userName) 
		{
			input_Search_Username.sendKeys(userName);
		}
		public void clickOnSearchButton()
		{
			btn_Search.click();
		}
		
		public void enterUserTypeForSearchFunction(String userType) {
			input_Search_Usertype.sendKeys(userType);
		}
		
		public void clickOnSearchButtonForSearchFunction()
		{
			btn_Search_Search.click();
		}
		
		public String getFirstRowData()
		{ 
			driver.navigate().refresh();
			return table_Firstrow_UserName.getText();
		}
		
		public String getStatusOfFirstRowUser()
		{
			return btn_status_FirstRowUser.getText();
		}
		
		public void clickOnDownwardArrow()
		{
			btn_Password_showDetails.click();
		}
		
		public void clickonEditButton()
		{
			pageutility.mouseClick(driver, btn_Edit);
		}
		
		public void clickOnUpdateButton()
		{
			pageutility.mouseClick(driver, updateButton);
		}
		
		public boolean updateAlertSuccessText()
		{
			return updateSuccessAlert.isDisplayed();
		}
		
		public void clickOnAdminIcon()
		{
			admin_icon.click();
		}
		
		public void clickOnLogout()
		{
			Logout_icon.click();
		}
		
		public void addNewUser(String userName, String password,String userType)
		{
			enterUserName(userName);
			enterPassword(password);
			enterUserType(userType);
			clickOnSaveButton();
		}
		
		public void addNewUserusingFakerClass(String userType) 
		{
			enterUserName(GeneralUtility.getRandomName());
			enterPassword(GeneralUtility.getRandomName());
			enterUserType(userType); 
		}
		
		public void searchForValidUser(String userName,String userType)
		{
			enterUserNameForSearchFunction(userName);
			enterUserTypeForSearchFunction(userType);
			clickOnSearchButtonForSearchFunction();		
		}
		
		public String searchOption_InvalidData()
		{
			return not_Found_Search_Data.getText();
		}
		
		public void clickOnDeleteButton()
		{   
			driver.navigate().refresh();
			btn_DeleteForFirstRow.click();	
		}
		public String SwitchtoalertAndCatchPoPUpMessage()
		{
			return pageutility.switchToAlertAndGetText(driver,btn_DeleteForFirstRow);
		}
		
		public void userStatusChange()
		{ 
			pageutility.mouseClick(driver, btn_Change_Status);
		}
		
		public String getTextAfterStatusChangeOperation()
		{
			return alert_Change_Status.getText();
		}
		
		public boolean getPassWordOfaUser()
		{   
			clickOnDownwardArrow();
			return display_Password_Details.isDisplayed();
		}
		
		public void editUserDetails()
		{
			clickonEditButton();
			enterUserName("Helen");
			clickOnUpdateButton();
		}
}


