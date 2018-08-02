package Tests;

import Help.BaseTest;
import Help.HelperMethods;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CelTest extends BaseTest {

    public HelperMethods functions;

    @Before
    public void initiate() {
        functions = new HelperMethods(driver);
    }


    @Test

    public void celTest() {

        String registrationPageTitle = driver.getTitle();
        String expectedRegageTitle = "Login";
        Assert.assertEquals(registrationPageTitle, expectedRegageTitle);


        WebElement nameTextBox = driver.findElement(By.id("firstname"));
        functions.fillWebElement(nameTextBox, "Andrei");

        WebElement lastnameTextBox = driver.findElement(By.id("lastname"));
        functions.fillWebElement(lastnameTextBox, "Durban");

        WebElement emailAddresBox = driver.findElement(By.xpath("//form[@name='create_account']//input[@id='email_address']"));
        functions.fillWebElement(emailAddresBox, System.currentTimeMillis() + "@yahoo.com");

        WebElement genderDropDown = driver.findElement(By.id("customers_gender"));
        functions.selectByValue(genderDropDown, "f");

        WebElement passwordTextBox = driver.findElement(By.id("password"));
        functions.fillWebElement(passwordTextBox,"12345678");

        WebElement confirmPasswordTextBox= driver.findElement(By.id("confirmation"));
        functions.fillWebElement(confirmPasswordTextBox, "12345678");

        WebElement telphone = driver.findElement(By.id("telephone"));
        functions.fillWebElement(telphone, "07561478857");

        WebElement contactadress = driver.findElement(By.id("street_address"));
        functions.fillWebElement(contactadress, "Cluj Napoca , nr.124, Ap. 45");

        WebElement suburb = driver.findElement(By.id("entry_suburb"));
        functions.selectByValue(suburb, "Salaj");

        WebElement city = driver.findElement(By.id("city"));
        functions.selectByValue( city, "Zalau");

        WebElement submitbutton = driver.findElement(By.xpath("//form[@name='create_account']//button[@type='submit']"));
        submitbutton.click();

        WebElement succesmessage = driver.findElement(By.xpath("//td[@class='pageHeading']"));
        Assert.assertEquals(succesmessage.getText(),"Contul tau a fost creat !");













    }


}
