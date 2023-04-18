package vtiger.OrganizationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateMultipleOrgTest {
	ExcelFileUtility eUtil=new ExcelFileUtility();
	JavaUtility jUtil=new JavaUtility();
	
	@Test(dataProvider="OrgWithIndustry")
	
	public void CreateOrgTest(String ORG,String INDUSTRY) throws IOException {
	
	//STEP1:CREATE OBJECT OF GENERIC UTILITIES
			
			PropertyFileUtility pUtil=new PropertyFileUtility();
			WebDriverUtility wUtil=new WebDriverUtility();
			
			//STEP2:READ ALL THE REQUIRED DATA
			String URL=pUtil.readDataFromPropertyFile("url");
	        String BROWSER=pUtil.readDataFromPropertyFile("browser");
	        String USERNAME=pUtil.readDataFromPropertyFile("username");
	        String PASSWORD=pUtil.readDataFromPropertyFile("password");
	        
	        String ORGNAME = ORG+jUtil.getRandomNumber();
	        
	        WebDriver driver=null;
	        
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
			
		
			//step5:navigate to organization tab
			HomePage hp=new HomePage(driver);
			hp.clickOnOrganizationLink();

			//step6:click on create organization lookup image
			OrganizationPage op=new OrganizationPage(driver);
			op.clickOnCreateOrganizationLookupImage();
			
			//step7:create organization with mandatory field
			CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
			cnop.CreateNewOrganization(ORGNAME);
			
			
			//step8:validate for organization for organization
			OrganizationInfoPage oip=new OrganizationInfoPage(driver);
			String OrgHeader=oip.getOrganizationHeader();
			if(OrgHeader.contains(ORGNAME)) 
			{
		System.out.println(OrgHeader+"---Organization created---");
		
			}
			else
			{
				System.out.println("--Organization creation failed--");
			}
			
			//step10:Logout of application
			hp.LogoutOfApp(driver);
			System.out.println("sign out successfully");
			
			//step11:close the browser
			driver.quit();
			
	}	
			
	@DataProvider(name="OrgWithIndustry")
	public Object[][] getData() throws IOException {
	Object[][]data=eUtil.readDatafromExcelToDataProvider("dataProviderOrg");
	
	
	return data;
	
}	
		}



