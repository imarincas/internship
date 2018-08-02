package Tests;

import Help.BaseTest;
import Screens.DelonghiHomePage;
import org.junit.Test;

public class DelonghiTests extends BaseTest {

    @Test
    public void firstTest() {
        DelonghiHomePage homePage=new DelonghiHomePage(driver);
        homePage.goToCoffePage()
                .verifyPageTitle()
                .goToCoffeFiltersPage()
                .verifyTitleText();
    }

}
