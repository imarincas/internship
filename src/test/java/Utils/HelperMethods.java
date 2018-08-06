package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class HelperMethods {
	
	WebDriver driver;
	
	//Constructor
	public HelperMethods(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//METHODS//
	//Click on a random WebElement
	public void clickWebElement(WebElement element)
	{
		element.click();
	}
	
	//Validate a page displayed
	public void validatePage(String expected,WebDriver driver) 
	{
		if(!(expected.isEmpty()))
		{
			String actual=driver.getTitle();
			Assert.assertEquals(expected, actual);
		}
	}
	
	//Fill a WebElement with a value
	public void fillWebElement(WebElement element,String value)
	{
		element.sendKeys(value);
	}
	
	//Select by text
	public void selectByText(WebElement element,String text)
	{
		Select dropDown=new Select(element);
		dropDown.selectByVisibleText(text);
	}
	
	//Select by value
	public void selectByValue(WebElement element,String value)
	{
		Select dropDown=new Select(element);
		dropDown.selectByValue(value);
	}
	
	//Hover a WebElement
	public void hoverWebElement(WebElement element,WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	//WaitExplicit on a WebElement
	public void waitExplicit(WebElement element,WebDriver driver)
	{
		new WebDriverWait(driver, 250).until(ExpectedConditions.visibilityOf(element));
	}

}
