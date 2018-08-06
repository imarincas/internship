package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FirstRestaurantPage {
    WebDriver driver;

    @FindBy(how= How.ID,using="h-restInfoPanel-orderOnlineId")
    private WebElement preorder;

    public FirstRestaurantPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public MenuPage clickOnPreorderButton(){
        preorder.click();
        return new MenuPage(driver);
    }

}
