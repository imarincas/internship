package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import Utils.DriverHelper;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	public WebDriver driver;
	
	@Before
	public void setup() throws IOException {
		driver =  new DriverHelper().loadDriver();
        driver.get("https://www.hipmenu.ro");
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}

}
