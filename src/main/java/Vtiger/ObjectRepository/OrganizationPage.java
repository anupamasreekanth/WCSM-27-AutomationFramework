package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage   {//RULE1:CREATE A SEPERATE POM CLASS FOR EVERY WEB PAGE\
	
		//RULE2:IDENTIFY ALL THE WEB ELEMENTS USING ANNOTATIONS
	
		@FindBy(xpath="//img[@alt='Create Organization...']")
		private WebElement CreateOrgLookUpImg;
		
		@FindBy(linkText="search_text")
		private WebElement SearchTextBox;
		
		
		//RULE3:INITIALIZE THESE WEB ELEMENTS WITH A CONSTRUCTOr
		public OrganizationPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		//RULE4:PROVIDE GETTERS TO ACCESS THESE ELEMENTS


		public WebElement getCreateOrganizationBtn() {
			return CreateOrgLookUpImg;
		}


		public WebElement getSearchBtn() {
			return SearchTextBox;
		}
		//BUSINESS LIBRARIES
		public void clickOnCreateOrganizationLookupImage()
		{
			CreateOrgLookUpImg.click();
		}



}
