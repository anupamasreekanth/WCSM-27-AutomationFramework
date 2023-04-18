package vtiger.ContactsTests;

import java.io.IOException;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;
import Vtiger.ObjectRepository.ContactsInfoPage;
import Vtiger.ObjectRepository.ContactsPage;
import Vtiger.ObjectRepository.CreateNewContactPage;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganizationWithPOM {

	public static void main(String[] args) throws IOException {
		//STEP1:CREATE OBJECT OF GENERIC UTILITIES
				ExcelFileUtility eUtil=new ExcelFileUtility();
				PropertyFileUtility pUtil=new PropertyFileUtility();
				JavaUtility jUtil=new JavaUtility();
				WebDriverUtility wUtil=new WebDriverUtility();
				
				//STEP2:READ ALL THE REQUIRED DATA
				String URL=pUtil.readDataFromPropertyFile("url");
		        String BROWSER=pUtil.readDataFromPropertyFile("browser");
		        String USERNAME=pUtil.readDataFromPropertyFile("username");
		        String PASSWORD=pUtil.readDataFromPropertyFile("password");
		        
		        String LASTNAME = eUtil.readDataFromExcel("Contacts",3,4);
		        String ORGNAME = eUtil.readDataFromExcel("Contacts",2,4);
		        WebDriver driver=null;

		       // STEP3:LAUNCH THE BROWSER
		        
		        //step3:Launch the browser.runtime polymorphism
		  		if(BROWSER.equalsIgnoreCase("chrome")) {
		  			WebDriverManager.chromedriver().setup();
		  		     driver=new ChromeDriver();
		  		}else if(BROWSER.equalsIgnoreCase("firefox")) {
		  		WebDriverManager.firefoxdriver().setup();
		  			driver=new FirefoxDriver();
		  		}else {
		  			System.out.println("Invalid browser name");
		  		}
		  		wUtil.maximizeWindow(driver);
		  		wUtil.waitForPageLoad(driver);
		  		driver.get(URL);
		  		
		  		
		  		//step4:login to application
		  	   LoginPage lp=new LoginPage(driver);
		  	   lp.loginToApp(USERNAME, PASSWORD);
		  	
		  		//step5:navigate to organization link
		  		HomePage hp=new HomePage(driver);
		  		hp.clickOnOrganizationLink();

		  		//step6:click on create organization lookup image
		  		OrganizationPage op=new OrganizationPage(driver);
		  		op.clickOnCreateOrganizationLookupImage();
		  		
		  		//step7:create organization with mandatory field
		  		
		  		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		  		cnop.CreateNewOrganization(ORGNAME);
		  		
		  		
		  		
		  		//step8:validate for organization
		  		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		  		String OrgHeader=oip.getOrganizationHeader();
		  		if(OrgHeader.contains(ORGNAME)) 
		  		{
		  	System.out.println(OrgHeader+"---Organization created");
		  	
		  		}
		  		else
		  		{
		  			System.out.println("--Organization creation failed--");
		  		}
		  		//step9:navigate to contacts link
		  		hp.clickOnContactsLink();
		  		
		  		//step10:click on create contact lookup image
		  		ContactsPage cp=new ContactsPage(driver);
		  		cp.clickOnCreateContactLookUpImg();
		  		
		  		//step11:create contact
		  		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		  		cncp.CreateNewContact(LASTNAME,ORGNAME,driver);
		  		
		  		
		  		//step12:Validate for contacts
		  		
		  		ContactsInfoPage cip=new ContactsInfoPage(driver);
		  		String ContactHeader=cip.getContactHeader();
		  		if(ContactHeader.contains("jspider")) 
		  		{
		  	System.out.println(ContactHeader+"---Organization created");
		  	
		  		}
		  		else
		  		{
		  			System.out.println("--Organization creation failed--");
		  		}
		  		//step13:logout
		  	
				hp.LogoutOfApp(driver);
				System.out.println("sign out successfully");
				
				//step14:close the browser
				//driver.quit();
		        
		        
	}	        

}
