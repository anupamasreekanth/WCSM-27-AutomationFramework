package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {//RULE1:CREATE A SEPERATE POM CLASS FOR EVERY WEB PAGE
	
	//RULE2:IDENTIFY ALL THE WEB ELEMENTS USING ANNOTATIONS
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement CreateContactLookupImg;
	
	//RULE3:INITIALIZE THESE WEB ELEMENTS WITH A CONSTRUCTOr
			public ContactsPage(WebDriver driver)
			{
				PageFactory.initElements(driver,this);
			}
			//RULE4:PROVIDE GETTERS TO ACCESS THESE ELEMENTS
             public WebElement getCreateContactLookupBtn() {
				return CreateContactLookupImg;
			}

   //BUISNESS LIBRARIES
             /**
              * This method will click on create contact look up image
              */
	public void clickOnCreateContactLookUpImg()
	{
		CreateContactLookupImg.click();
	}


	

}
