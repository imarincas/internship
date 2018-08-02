package Screens;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CoffeFiltersPage {
    WebDriver driver;

    @FindBy(how= How.ID,using = "ctl00_ContentPlaceHolderAll_HeroContentArea_ctlHeaderArea_ctlPageHeading_h1Tag")
    private WebElement titleMessage;

    public CoffeFiltersPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public CoffeFiltersPage verifyTitleText(){
        Assert.assertEquals("APARATE DE CAFEA CU FILTRU",titleMessage.getText());
        return this;
    }
}
