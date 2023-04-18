package vtiger.Scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1 {
	public static void main(String[] args) {
		//Launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		
		//login to application
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
	
		//navigate to contact tab
		driver.findElement(By.linkText("Contacts")).click();

		//click on create contact lookup image
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
		//create contact with mandatory field
		
		driver.findElement(By.name("lastname")).sendKeys("ANU");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verification for contact
		String ContactHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ContactHeader.contains("ANU")) 
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


