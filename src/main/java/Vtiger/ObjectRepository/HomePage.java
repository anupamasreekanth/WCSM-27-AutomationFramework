package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{//RULE1:CREATE A SEPERATE POM CLASS FOR EVERY WEB PAGE
	//RULE2:IDENTIFY ALL THE WEB ELEMENTS USING ANNOTATIONS
	@FindBy(linkText="Organizations")
	private WebElement OrganizationLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(linkText="Leads")
	private WebElement LeadsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLnk;
	
	@FindBy(linkText="Calendar")
	private WebElement CalendarLnk;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLnk;
	
	   //RULE3:INITIALIZE THESE WEB ELEMENTS WITH A CONSTRUCTOR
	
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		//RULE4:PROVIDE GETTERS TO ACCESS THESE ELEMENTS
		
		public WebElement getOrganizationLnk() {
			return OrganizationLnk;
		}
		public WebElement getContactsLnk() {
			return ContactsLnk;
		}
		public WebElement getLeadsLnk() {
			return LeadsLnk;
		}
		public WebElement getProductsLnk() {
			return ProductsLnk;
		}
		public WebElement getCalendarLnk() {
			return CalendarLnk;
		}
	    public WebElement getOpportunitiesLnk() {
			return OpportunitiesLnk;
		}

		public WebElement getAdministratorImg() {
			return AdministratorImg;
		}

		public WebElement getSignOutLnk() {
			return SignOutLnk;
		}

		//BUSINESS LIBRARIES
		
		/**
		 * This method will click on Organizations link
		 */
		
		public void clickOnOrganizationLink()
		{
			OrganizationLnk.click();	
		}
		

		/**
		 * This method will click on Contacts link
		 */
		public void clickOnContactsLink()
		{
			ContactsLnk.click();
		}

		/**
		 * This method will click on Opportunities link
		 */
		public void clickOnOpportunitiesLink()
		{
			OpportunitiesLnk.click();
		}
		

		/**
		 * This method will click on Leads link
		 */
		public void clickOnLeadsLink()
		{
			LeadsLnk.click();
		}
		
		/**
		 * This method will click on Product link
		 */
		public void clickOnProductLink()
		{
		    ProductsLnk.click();
		}
		

		/**
		 * This method will click on Calendar link
		 */
		public void clickOnCalendarLink()
		{
			CalendarLnk.click();
		}
		

		/**
		 * This method will perform sign out operation on web application
		 * @param driver
		 */
		public void LogoutOfApp(WebDriver driver)
		{
			mouseHoverAction(driver,AdministratorImg);
			SignOutLnk.click();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
}
