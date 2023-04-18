package vtiger.OrganizationTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest {

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
        
        String ORGNAME = eUtil.readDataFromExcel("Organization",1,2)+jUtil.getRandomNumber();
        
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
	    driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
	
		//step5:navigate to organization tab
		driver.findElement(By.linkText("Organizations")).click();

		//step6:click on create organization lookup image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//step7:create organization with mandatory field
		
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//step8:save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step9:verification for organization
		String ContactHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ContactHeader.contains("jspider")) 
		{
	System.out.println(ContactHeader+"---pass---");
	
		}
		else
		{
			System.out.println("--FAIL--");
		}
		
		//step10:Logout of application
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver,ele);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("sign out successfully");
		
		//step11:close the browser
		driver.quit();
		
		
	}	
		
	}







	


