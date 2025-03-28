package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.BaseClass;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class SubCategoryPage extends BaseClass
{
	WebDriver driver;
	PageUtility pageutility=new PageUtility(driver);
	GeneralUtility generaluser=new GeneralUtility();
	WaitUtility waitutility=new WaitUtility(driver);
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add']")
 	private WebElement newbutton;
	
	@FindBy(xpath = "//select[@id='cat_id']")
 	private WebElement categoryDropDown;
	
 	@FindBy(xpath = "//input[@id='subcategory']")
 	private WebElement sub_Category;
 	
 	@FindBy(xpath = "//input[@id='main_img']")
 	private WebElement image_Upload;
 	
 	@FindBy(xpath = "//button[@name='create']")
 	private WebElement saveButton;
 	
 	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
 	private WebElement green_Alertbox;
 	
 	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
 	private WebElement searchButton;
 	
 	@FindBy(xpath = "//select[@class='form-control selectpicker']")
 	private WebElement searchCategoryDropdown;
 	
 	@FindBy(xpath = "//input[@placeholder='Sub Category']")
 	private WebElement searchSubCategory;
 	
 	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
 	private WebElement searchButtonRed;
 	
 	@FindBy(xpath = "//table//tbody//tr[1]//td[1]")
 	private WebElement SearchedData;
 	
 	@FindBy(xpath = "//table//tbody//tr//td[5]//a[2]")
 	private WebElement deteteButton;
 	
 	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
 	private WebElement alertMessageafterDetetion;
 	
	public SubCategoryPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickTheNew_Button()
	{
		newbutton.click();
	}
	
	public void selectCategory_Dropdown(WebElement dropdown ,String category)
	{
		pageutility.selectByVisibleText(dropdown, category);
	}
	
	public void enterSubCategory(WebElement subcategoryElement,String subcategory)
	{
		subcategoryElement.sendKeys(subcategory);
	}
	
	public void uploadTheImage()
	{
		pageutility.uploadImage(image_Upload,"softToys");
	}
	
	public void clickTheSaveButton()
	{
		saveButton.click();
	}
	
	public boolean isGreenAlertboxDispalyed()
	{
		return green_Alertbox.isDisplayed();
	}
	
	public void clickSearchButton()
	{
		pageutility.mouseClick(driver, searchButton);
	}
	
	public boolean SearchedSubCategoryAvailability()
	{
		return SearchedData.isDisplayed();
	}
	
	public String getDeleteSuccessAlertmessage()
	{
		return alertMessageafterDetetion.getText();
	}
	
	public void clickSearchButtonRed()
	{
		searchButtonRed.click();
	}
	public void addSubCategoryDetails(String category,String subcategory)
	{
		 selectCategory_Dropdown(categoryDropDown,category);
		 enterSubCategory(sub_Category,subcategory);
		 uploadTheImage();
	}
	
	public void searchSubCategory(String category,String subcategory)
	{
		selectCategory_Dropdown(searchCategoryDropdown,category);
		enterSubCategory(searchSubCategory,subcategory);
	}
	
	public void deleteSubCategory()
	{
		deteteButton.click();
		pageutility.switchToAlert(driver,deteteButton);	
	}	
}
