package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {//RULE1:CREATE A SEPERATE POM CLASS FOR EVERY WEB PAGE
			
	        //RULE2:IDENTIFY ALL THE WEB ELEMENTS USING ANNOTATIONS
			@FindBy(xpath="//span[@class='dvHeaderText']")
			private WebElement OrgHeaderText;
			
			@FindBy(name="Edit")
			private WebElement EditBtn;
			
			@FindBy(name="Duplicate")
			private WebElement DuplicateBtn;
			
			@FindBy(name="Delete")
			private WebElement DeleteBtn;
			
			@FindBy(linkText="Contacts")
			private WebElement ContactsBtn;
			
			//RULE3:INITIALIZE THESE WEB ELEMENTS WITH A CONSTRUCTOr
			public OrganizationInfoPage(WebDriver driver)
			{
				PageFactory.initElements(driver,this);
			}
			//RULE4:PROVIDE GETTERS TO ACCESS THESE ELEMENTS

			public WebElement getOrgHeaderText() {
				return OrgHeaderText;
			}

			public WebElement getEditBtn() {
				return EditBtn;
			}

			public WebElement getDuplicateBtn() {
				return DuplicateBtn;
			}

			public WebElement getDeleteBtn() {
				return DeleteBtn;
			}

			public WebElement getContactsBtn() {
				return ContactsBtn;
			}
			//BUISNESS LIBRARIES
			public String getOrganizationHeader()
			{
				return OrgHeaderText.getText();
			}
			
}

