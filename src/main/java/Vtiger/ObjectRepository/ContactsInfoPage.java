package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	//IDENTIFY THE WEBELEMENTS
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;
	//INITIALIZE THESE WEB ELEMENTS WITH A CONSTRUCTOr
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//PROVIDE GETTERS TO ACCESS THESE ELEMENTS
	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	//BUISNESS LIBRARIES
	/**
	 * This method will get the contact header text and return it to caller
	 * @return
	 */
	public String getContactHeader()
	{
	return ContactHeaderText.getText();
	}
}
