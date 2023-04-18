package Vtiger.GenericUtilities;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * This class consists of all basic configuration annotation
 * @author Anu
 */



public class BaseClass {
	
	//STEP1:CREATE OBJECT OF GENERIC UTILITIES
		public ExcelFileUtility eUtil=new ExcelFileUtility();
		public PropertyFileUtility pUtil=new PropertyFileUtility();
		public JavaUtility jUtil=new JavaUtility();
		public WebDriverUtility wUtil=new WebDriverUtility();
			
		  public WebDriver driver=null;
		  public static WebDriver sDriver=null;//This is for listeners
			
@BeforeSuite(alwaysRun=true)
public void bsConfig()
{
	System.out.println("------Database connection successful-----");
}
// @Parameters("browser")
//@BeforeTest
@BeforeClass(groups={"SmokeSuite","RegressionSuite"})
public void bcConfig(/*String BROWSER*/) throws IOException
{
	String URL=pUtil.readDataFromPropertyFile("url");
    String BROWSER=pUtil.readDataFromPropertyFile("browser");
    
    //step3:Launch the browser.runtime polymorphism
	if(BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
	     driver=new ChromeDriver();
	     
	     System.out.println("---"+BROWSER+"launched");
	     
	}else if(BROWSER.equalsIgnoreCase("firefox")) {
	WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		
		System.out.println("---"+BROWSER+"launched");
	}else {
		System.out.println("Invalid browser name");
	}
	
	sDriver=driver;//This is for listeners
	wUtil.maximizeWindow(driver);
	wUtil.waitForPageLoad(driver);
	driver.get(URL);
}
	@BeforeMethod(groups={"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws IOException
	{
		String USERNAME=pUtil.readDataFromPropertyFile("username");
        String PASSWORD=pUtil.readDataFromPropertyFile("password");
        LoginPage lp=new LoginPage(driver);
        lp.loginToApp(USERNAME, PASSWORD);
        System.out.println("---Login to app successful---");
        	
	}
	
	
	@AfterMethod(groups={"SmokeSuite","RegressionSuite"})
	public void amConfig() throws Throwable
	{
	Thread.sleep(2000);
	HomePage hp=new HomePage(driver);
	hp.LogoutOfApp(driver);

		System.out.println("-----log out of app successfully-----");
	}

	//@AfterTest
	@AfterClass(groups={"SmokeSuite","RegressionSuite"})
    public void acConfig()
   {
	driver.quit();
	System.out.println("-----Browser closed----");
   }

  @AfterSuite(groups={"SmokeSuite","RegressionSuite"})
  public void asConfig()
  {
	System.out.println("------------Database closed successfully----");
  }
  }
