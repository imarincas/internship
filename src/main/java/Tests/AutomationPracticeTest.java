package Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Help.BaseTest;
import Help.HelperMethods;
import junit.framework.Assert;

public class AutomationPracticeTest extends BaseTest {
	
	
	//Objects
	public HelperMethods functions;
	
	@Before
	public void initiate()
	{
		functions=new HelperMethods(driver);
	}
		
	
	@Test
	public void test()
	{
		//Hover Demo Sites menu button
		WebElement demoSitesButton=driver.findElement(By.xpath("//span[@class='text-wrap']/span[@class='menu-item-text']/span[contains(text(),'DEMO')]"));
		functions.hoverWebElement(demoSitesButton, driver);
		
		//Click on Automation PRactice Form button
		WebElement automationPracticeFormButton=driver.findElement(By.xpath("//span[@class='text-wrap']/span[@class='menu-item-text']/span[contains(text(),'Practice Form')]"));
		//Wait explicit
		functions.waitExplicit(automationPracticeFormButton, driver);
		functions.clickWebElement(automationPracticeFormButton);
		
		//Validate the presence of two sex check boxes
		List<WebElement> sexCheckBoxes=driver.findElements(By.xpath("//input[@name='sex']"));
		int sexListSize=sexCheckBoxes.size();
		int expectedCheckBoxes=2;
		Assert.assertEquals(expectedCheckBoxes, sexListSize);
		
		//scroll down
		JavascriptExecutor jsx=(JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,650)", "");
		
		//Select 4 years of experience
		List<WebElement> yearsCheckBoxes=driver.findElements(By.xpath("//input[@name='exp']"));
		for(int index=0;index<yearsCheckBoxes.size();index++)
		{
			String actualValue=yearsCheckBoxes.get(index).getAttribute("value");
			String expectedValue="4";
			if(actualValue.equals(expectedValue))
			{
				yearsCheckBoxes.get(index).click();
			}
		}
		
	}

}
