package Vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
    @FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(xpath="//input[@name='account_name']/following-sibling::Img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement OrgSearchEdt;
	
	@FindBy(name="search")
	private WebElement OrgSearchBtn;
	
	//Initialization
    public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//RULE4:PROVIDE GETTERS TO ACCESS THESE ELEMENT
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}
	public WebElement getOrgSearchEdt() {
		return OrgSearchEdt;
	}
	public WebElement getOrgSearchBtn() {
		return OrgSearchBtn;
	}
	
	//LIBRARIES
	/**
	 * This method will create new contact with mandatory data
	 * @param LASTNAME
	 */
	public void CreateNewContact(String LASTNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	
	/**
	 * This method will create contact with organization
	 * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 */
	public void CreateNewContact(String LASTNAME,String ORGNAME,WebDriver driver)
	{
		LastNameEdt.sendKeys(LASTNAME);
		OrgLookUpImg.click();
		switchToWindow(driver,"Accounts");
		OrgSearchEdt.sendKeys(ORGNAME);
		OrgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(driver,"Contacts");
		SaveBtn.click();
	}
	
}

	

