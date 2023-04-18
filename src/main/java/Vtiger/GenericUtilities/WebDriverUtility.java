package Vtiger.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


	/**
	 * This  class consists of generic methods related to webdriver actions
	 * 
	 * @author driver
	 *
	 */
	public class WebDriverUtility {
		/**
		 * This method will maximize the window
		 * @param driver
		 * 
		 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
		
		/**
		 * This method will minimize the window
		 * @param driver
		 */
		
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will wait for 20 seconds to page load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	/**
	 * This method will wait until the element becomes visible
	 * @param driver
	 * @param element
	 */

	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}



	/**
	 * This method will wait until the element becomes clickable
	 * @param driver
	 * @param element
	 * 
	 */

	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
				
	}

	/**
	 * This method will handle drop down based on index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method will handle dropdown based on value
	 * @param element
	 * @param value
	 */


	public void handleDropdown(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}


	/**
	 * This method will handle dropdown based on visible text
	 * @param text
	 * @param element
	 */




	public void handleDropdown(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method will perform mousehover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform mousehover action
	 * @param driver
	 * @param element
	 */
	public void righClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}

	/**
	 * This method will perform mousehover action
	 * @param driver
	 * @param element
	 */

	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will perform mousehover action
	 * @param driver
	 * @param element
	 */

	public void doubleClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * This method will perform mousehover action
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}




		
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param element
	 */
	public void dragAndDropAction(WebDriver driver,WebElement srcElement,WebElement dstElement)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcElement,dstElement).perform();
	}
	
	/**This method will press the enter key 
	 * @throws AWTException
	 * 
	 */
	public void pressEnterKey() throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	/**This method will release the enter key 
	 * @throws AWTException
	 * 
	 */
	public void releaseEnterKey() throws AWTException
	{
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	
	/**
	 * This method will accept the alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	/**
	 * This method will dismiss the alert
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}


	/**
	 * This method will capture the text from alert pop up
	 * @param driver
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will  handle frame based on index
	 * @param driver
	 *@param nameOrId
	 */
	public void handleFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}

/**
	 * This method will  handle frame based on name or id
	 * @param driver
	 *@param nameOrId
	 */
	public void handleFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}


	/**
	 * This method will switch to immediate parent frame
	 * @param driver

	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}



	/**
	 * This method will switch to default frame
	 * @param driver
	 * 
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will switch the window based on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */

	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		//step1:capture all the window IDs
		Set<String>winIDs= driver.getWindowHandles();
		//step2:Navigate to each window
		for(String win:winIDs)
		{
			//step3:switch to window and capture the title
			String winTitle=driver.switchTo().window(win).getTitle();
			//step4:compare the title with required partial title
			if(winTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
		
		/** 
		 * This method will take the screenshot and save it in folder
		 * @throws IOException 
		 * 
		 */
		
		public String takesScreenShot(WebDriver driver,String screenshotName) throws IOException
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dst=new File(".\\Screenshots\\"+screenshotName+".png");
			FileUtils.copyFile(src,dst);
		
		return dst.getAbsolutePath();//used for extent reports
		
	}
	
	
	
	
	
	
	

}
