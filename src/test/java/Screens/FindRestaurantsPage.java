package Screens;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FindRestaurantsPage {
    WebDriver driver;

    @FindBy(how= How.ID,using="h-addrListPicker-cityNameId")
    private WebElement cityTextbox;
    @FindBy(how=How.ID,using="h-addrListPicker-addressNameId")
    private WebElement streetTextbox;
    @FindBy(how=How.ID,using="h-addrListPicker-addressNumberId")
    private WebElement numberTextbox;
    @FindBy(how=How.ID,using="h-addrListPicker-btnFindRestaurantsId")
    private WebElement findRestaurantsButton;
    @FindBy(how=How.ID,using="home0AddressTitle")
    private WebElement findRestaurantsPageTitle;

    public FindRestaurantsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public FindRestaurantsPage fillSearchRestaurants(String city, String street,String number){
        cityTextbox.sendKeys(city);
        streetTextbox.sendKeys(street);
        numberTextbox.sendKeys(number);
        return this;
    }

    public RestaurantsPage findRestaurants(){
        findRestaurantsButton.click();
        return new RestaurantsPage(driver);
    }

    public FindRestaurantsPage verifyTitle(){
        Assert.assertTrue(findRestaurantsPageTitle.getText().contains("Ajută-ne să găsim"));
        return this;
    }

}
