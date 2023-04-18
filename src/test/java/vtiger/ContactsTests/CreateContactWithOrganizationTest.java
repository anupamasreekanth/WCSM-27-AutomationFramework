package vtiger.ContactsTests;

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

public class CreateContactWithOrganizationTest {

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
		        
		        String LASTNAME = eUtil.readDataFromExcel("Contacts",4,2);
		        String ORGNAME = eUtil.readDataFromExcel("Contacts",4,3)+jUtil.getRandomNumber();
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
		  		
		  		//step9:validate for organization
		  		String OrgHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		  		if(OrgHeader.contains("jspider")) 
		  		{
		  	System.out.println(OrgHeader+"---Organization created");
		  	
		  		}
		  		else
		  		{
		  			System.out.println("--Organization creation failed--");
		  		}
		  		//step10:navigate to contacts link
		  		driver.findElement(By.linkText("Contacts")).click();
		  		
		  		//step11:click on create contact lookup image
		  		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		  		
		  		//step12:create contact
		  		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		  		
		  		//step13:click on organization lookup image
		  		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
		  		
		  		//step14:switch the control to the child window
		  		wUtil.switchToWindow(driver,"Accounts");
		  		
		  		//step15:search for organization
		  		driver.findElement(By.name("search_text")).sendKeys("ORGNAME");
		  		driver.findElement(By.name("search")).click();
		  		
		  		//step16:choose the organization
		  		//driver.findElement(By.linkText(ORGNAME)).click();
		  		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();//dynamic xpatho
		  		
		  		//step17:switch the control back to main window
		  		wUtil.switchToWindow(driver,"Contacts");
		  		
		  		//step18:save
		  		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  		
		  		String ContactHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		  		if(ContactHeader.contains("jspider")) 
		  		{
		  	System.out.println(ContactHeader+"---Organization created");
		  	
		  		}
		  		else
		  		{
		  			System.out.println("--Organization creation failed--");
		  		}
		  		//step20:logout
		  	
				WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wUtil.mouseHoverAction(driver,ele);
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("sign out successfully");
				
				//step21:close the browser
				driver.quit();
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
	}

}
