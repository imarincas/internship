package Help;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	
	public WebDriver driver;
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Development\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
//		driver.get("https://demoqa.com");
//      driver.get("https://www.cel.ro/index.php?main_page=login");
//      driver.get("http://toolsqa.com/automation-practice-switch-windows/");
        driver.get("http://www.delonghi.com/ro-ro");
        //driver.get("http://toolsqa.com/");
	    //driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown()
	{
//		driver.quit();
	}

}