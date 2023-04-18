package vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Vtiger.ObjectRepository.ContactsPage;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class POMClassPractice {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		LoginPage lp=new LoginPage(driver);
		lp.getUserNameEdt().sendKeys("admin");
		lp.getPassWordEdt().sendKeys("manager");
		lp.getSubmitBtn().click();
		
		lp.loginToApp("admin","admin");
		
		HomePage hp=new HomePage(driver);
		
		
		
		OrganizationPage op=new OrganizationPage(driver);
		
		op.getCreateOrganizationBtn().click();
		
		CreateNewOrganizationPage co=new CreateNewOrganizationPage(driver);
		
		co.getOrganizationNameChkbx().sendKeys("as");
		co.getSaveBtn().click();
		
		OrganizationInfoPage oi=new OrganizationInfoPage(driver);
		
		oi.getContactsBtn().click();
		
		ContactsPage cp=new ContactsPage(driver);
		
	}

}
