package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HipmenuHomePage {
    WebDriver driver;

    @FindBy(how= How.ID,using="home0OrderOnline")
    private WebElement orderButton;

    public HipmenuHomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public FindRestaurantsPage goToFindRestaurantsPage(){
        orderButton.click();
        return new FindRestaurantsPage(driver);
    }
}
