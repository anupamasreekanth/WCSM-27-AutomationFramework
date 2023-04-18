package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	//RULE1:CREATE A SEPERATE POM CLASS FOR EVERY WEB PAGE
		//RULE2:IDENTIFY ALL THE WEB ELEMENTS USING ANNOTATIONS
		@FindBy(name="accountname")
		private WebElement OrgNameEdt;
		
		
		
		@FindBy(name="industry")
		private WebElement IndustryDropDwn;
		
		@FindBy(name="button")
		private WebElement SaveBtn;
		
		
		
		//RULE3:INITIALIZE THESE WEB ELEMENTS WITH A CONSTRUCTOr
				public CreateNewOrganizationPage(WebDriver driver)
				{
					PageFactory.initElements(driver,this);
				}
				//RULE4:PROVIDE GETTERS TO ACCESS THESE ELEMENTS

				public WebElement getOrganizationNameChkbx() {
					return OrgNameEdt;
				}

				public WebElement getSaveBtn() {
					return SaveBtn;
				}

				public WebElement getIndustryDropDwn() {
					return IndustryDropDwn;
				}
				
				
				//BUSINESS LIBRARIES
				
				/*
				 * This method will create organization with mandatory information
				 * 
				 */
				public void CreateNewOrganization(String ORGNAME)
				{
					OrgNameEdt.sendKeys(ORGNAME);
					SaveBtn.click();
				}
				
				/*
				 * This method will create organization with industry drop down
				 * 
				 */
				public void CreateNewOrganization(String ORGNAME,String INDUSTRY)
				{
					OrgNameEdt.sendKeys(ORGNAME);
					handleDropdown(IndustryDropDwn,INDUSTRY);
					SaveBtn.click();
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		
}
