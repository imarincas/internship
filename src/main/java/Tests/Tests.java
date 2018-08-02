package Tests;

import Help.BaseTest;
import Help.HelperMethods;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tests extends BaseTest {

    public HelperMethods functions;

    @Before
    public void init(){functions=new HelperMethods(driver);}


    @Test
    public void firstTest(){

        WebElement alertButton=driver.findElement(By.id("alert"));

        JavascriptExecutor jsx=(JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,650)", "");

        alertButton.sendKeys(Keys.ENTER);
        alertButton.click();

       driver.switchTo().alert().accept();
    }

    @Test
    public void secondTest(){
        new WebDriverWait(driver,50).until(ExpectedConditions.textToBe(By.id("clock"),"Buzz Buzz"));
        Assert.assertTrue("The text is not correct.",driver.findElement(By.id("clock")).getText().contains("Buzz Buzz"));
    }

    @Test
    public void thirdTest() {
        WebElement newBrowserWindButton=driver.findElement(By.id("button1"));

        newBrowserWindButton.click();
        newBrowserWindButton.sendKeys(Keys.ENTER);
        String parentWind=switchToChildWindow();

        WebElement homeButton=driver.findElement(By.xpath("//a[@class='ripple']//span[contains(text(),'HOME')]"));
        functions.waitExplicit(homeButton,driver);

        Assert.assertEquals(driver.getTitle(),"QA Automation Tools Tutorial");

    }

    public String switchToChildWindow(){
        String parentWindow=driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()){
            if(!parentWindow.equals(winHandle))
            {
            driver.switchTo().window(winHandle);
            driver.manage().window().maximize();
            }
        }
        return parentWindow;
    }



}
