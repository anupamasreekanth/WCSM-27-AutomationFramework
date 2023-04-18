package vtiger.Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;





public class GenericUtilityPractice {
	public static void main(String[] args) throws IOException, Throwable {
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String data=pUtil.readDataFromPropertyFile("url");
		String data1=pUtil.readDataFromPropertyFile("abcd");
		System.out.println(data);
		System.out.println(data1);
		
		ExcelFileUtility eUtil=new ExcelFileUtility();
		String value=eUtil.readDataFromExcel("Contacts",1, 1);
		System.out.println(value);
		
		System.out.println(eUtil.getRowCount("Contacts"));
		
		eUtil.writeDataIntoExcel("Organization",10,9,"bats");
		System.out.println("data added");
		
		JavaUtility jUtil=new JavaUtility();
		System.out.println(jUtil.getRandomNumber());
		
		System.out.println(jUtil.getSystemDate());
		
		System.out.println(jUtil.getSystemDateInFormat());
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		
		WebDriverUtility wUtil=new WebDriverUtility();
		wUtil.maximizeWindow(driver);
		Thread.sleep(2000);
		wUtil.minimizeWindow(driver);

}
}