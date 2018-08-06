package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RestaurantsPage {
    WebDriver driver;

    @FindBy(how= How.XPATH,using="//*[@id='restList']/div[@class='list']/div")
    private List<WebElement> restaurantsList;

    public RestaurantsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public FirstRestaurantPage clickOnFirstRestaurant(){
        restaurantsList.get(0).click();
        return new FirstRestaurantPage(driver);
    }
}
