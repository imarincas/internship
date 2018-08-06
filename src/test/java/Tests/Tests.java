package Tests;

import Screens.HipmenuHomePage;
import org.junit.Test;

public class Tests extends BaseTest {

    @Test
    public void firstTest(){
        HipmenuHomePage homePage=new HipmenuHomePage(driver);
        homePage.goToFindRestaurantsPage()
                .verifyTitle()
                .fillSearchRestaurants("Cluj-Napoca","Strada Alexandru Vaida Voevod","51")
                .findRestaurants()
                .clickOnFirstRestaurant()
                .clickOnPreorderButton();

    }
}
