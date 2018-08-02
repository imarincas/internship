package Screens;

import Help.HelperMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CoffePage {
    WebDriver driver;
    HelperMethods functions;

    @FindBy(how= How.ID,using="ctl00_ContentPlaceHolderAll_ContentPlaceHolderMain_ProductLeftNavigationContainer_ProductLeftNavigation_RepeaterTop_ctl01_RepeaterInner_ctl03_HyperLinkTitle")
    private WebElement aparateCafeaFiltruButton;
    @FindBy(how = How.ID,using = "userControl1_RepeaterTopNavigation_ctl04_HyperLinkTitle")
    private  WebElement clientSuportButton;

    public CoffePage(WebDriver driver){
        this.driver=driver;
        functions=new HelperMethods(driver);
        PageFactory.initElements(driver,this);
    }

    public CoffeFiltersPage goToCoffeFiltersPage(){

        functions.hoverWebElement(clientSuportButton,driver);

        aparateCafeaFiltruButton.click();
        return new CoffeFiltersPage(driver);
    }

    public CoffePage verifyPageTitle(){
        Assert.assertEquals("Aparate Cafea Profesionale | De'Longhi Romania",driver.getTitle());
        return this;
    }


}
