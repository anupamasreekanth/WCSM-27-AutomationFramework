package vtiger.Practice;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoScriptWithDDT {

	public static void main(String[] args) throws IOException {
		//READ ALL THE NECESSARY DATA//
		
		/*Read data from property file*/
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
		Properties pObj=new Properties();
		pObj.load(fisp);
		String URL=pObj.getProperty("url");
	    String BROWSER=pObj.getProperty("browser");
	    String USERNAME=pObj.getProperty("username");
	    String PASSWORD=pObj.getProperty("password");
	    
	    /*Read the data from excel sheet*/
	    FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	    Workbook wb=WorkbookFactory.create(fise);
	    String LASTNAME=wb.getSheet("Contacts").getRow(1).getCell(3).getStringCellValue();
	    
	    WebDriver driver=null;
	   //*Launch the browser*/-runtime polymorphism
	    if(BROWSER.equalsIgnoreCase("chrome"))
	    		{
	    	driver=new ChromeDriver();
	    		}
	    else if(BROWSER.equalsIgnoreCase("firefox"))
	    {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver=new FirefoxDriver();
	    }
	    else
	    {
	    	System.out.println("Invalid browser name");
	    }
	    
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
	    
		//login to application
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	
		//navigate to contact tab
		driver.findElement(By.linkText("Contacts")).click();

		//click on create contact lookup image
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
		//create contact with mandatory field
		
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verification for contact
		String ContactHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ContactHeader.contains(LASTNAME)) 
		{
	System.out.println(ContactHeader+"---pass---");
	
		}
		else
		{
			System.out.println("--FAIL--");
		}
		
		//Logout of application
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("sign out successfully");
		
		
		
	    
	    
	}    	
}	    
	    


