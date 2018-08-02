package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import Help.BaseTest;
import Help.HelperMethods;
import junit.framework.Assert;

public class RegistrationTest extends BaseTest {
	
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
		//Steps
		//Click on Registration button
		WebElement registrationButton=driver.findElement(By.xpath("//a[contains(text(),'Registration')]"));
		functions.clickWebElement(registrationButton);
		
		//Validate Registration page
		String expectedResult="Registration | Demoqa";
		functions.validatePage(expectedResult, driver);
		
		//Fill firstName field
		WebElement firstnameField=driver.findElement(By.id("name_3_firstname"));
		String firstNameValue="Dorha";
		functions.fillWebElement(firstnameField, firstNameValue);
		
		//Fill lastname field
		WebElement lastNameField=driver.findElement(By.id("name_3_lastname"));
		String lastNameValue="Alex";
		functions.fillWebElement(lastNameField, lastNameValue);
		
		//Check statut
		WebElement statutCheck=driver.findElement(By.xpath("//input[@value='single']"));
		statutCheck.click();
		
		//Check hobby
		WebElement hobbyCheck=driver.findElement(By.xpath("//input[@value='dance']"));
		hobbyCheck.click();
		
		//Select country
		//Select after text
		WebElement countryDropDownWeb=driver.findElement(By.id("dropdown_7"));		
		String countryValue="Romania";
		functions.selectByText(countryDropDownWeb, countryValue);
		
		//Select month
		//Select after value
		WebElement monthDropDownWeb=driver.findElement(By.id("mm_date_8"));		
		String monthValue="11";
		functions.selectByValue(monthDropDownWeb, monthValue);
		
		//Select day
		//Select after value
		WebElement dayDropDownWeb=driver.findElement(By.id("dd_date_8"));
		Select dayDropDown=new Select(dayDropDownWeb);
		String dayValue="15";
		dayDropDown.selectByValue(dayValue);
				
		//Select year
		//Select after value
		WebElement yearDropDownWeb=driver.findElement(By.id("yy_date_8"));
		Select yearDropDown=new Select(yearDropDownWeb);
		String yearValue="1994";
		yearDropDown.selectByValue(yearValue);
		
		//Fills the username
		WebElement usernameField=driver.findElement(By.id("username"));
		String usernameValue="AlexDorha"+System.currentTimeMillis();
		usernameField.sendKeys(usernameValue);
		
		//Fills the email
		WebElement emailField=driver.findElement(By.id("email_1"));
		String emailValue=System.currentTimeMillis()+"@endava.com";
		emailField.sendKeys(emailValue);
		
		//Fills the password and confirm password fields
		WebElement passwordField=driver.findElement(By.id("password_2"));
		WebElement confirmPasswordField=driver.findElement(By.id("confirm_password_password_2"));
		String passwordValue="d&st8PRaBe!";
		passwordField.sendKeys(passwordValue);
		confirmPasswordField.sendKeys(passwordValue);
		
		//Validate the password inserted
		WebElement passowrdStrength=driver.findElement(By.xpath("//div[@id='piereg_passwordStrength']"));
		String actualPasswordResult=passowrdStrength.getText();
		String expectedPasswordResult="Very weak";
		Assert.assertEquals(expectedPasswordResult, actualPasswordResult);

		
	}

}
