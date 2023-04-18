package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//RULE1:CREATE A SEPERATE POM CLASS FOR EVERY WEB PAGE
	//RULE2:IDENTIFY ALL THE WEB ELEMENTS USING ANNOTATIONS
	@FindBy(name="user_name")
	private WebElement UserNameEdt;
	
	@FindBy(name="user_password")
	private WebElement PassWordEdt;
	
	@FindAll({@FindBy(id="SubmitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement SubmitBtn;
	
	//RULE3:INITIALIZE THESE WEB ELEMENTS WITH A CONSTRUCTOr
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//RULE4:PROVIDE GETTERS TO ACCESS THESE ELEMENTS

	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPassWordEdt() {
		return PassWordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	//Business library-Generic methods-project specific
	/**
	 * This method will login to application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME,String PASSWORD)
	{
	UserNameEdt.sendKeys(USERNAME);
	PassWordEdt.sendKeys(PASSWORD);
	SubmitBtn.click();
		
	}
	

}
