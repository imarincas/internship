package Utils;

import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverHelper {
    WebDriver driver;

    public WebDriver loadDriver() throws IOException {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        String browser = getBrowserType();
        if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
            System.out.println("Firefox driver loaded");
            return driver;
        }
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
            System.out.println("Chrome driver loaded");
            return driver;
        }

        driver = new FirefoxDriver();
        System.out.println("Firefox driver loaded as default");
        return driver;
    }

    public String getBrowserType() throws IOException {
        String systemBrowserProperty = System.getProperty("browser");
        if(null != systemBrowserProperty )
            return systemBrowserProperty;
        else
            return getBrowserFromFile();
    }

    private String getBrowserFromFile() throws IOException {
        Properties prop = new Properties();
        InputStream propFile = new FileInputStream("src/test/resources/browserType.properties");
        prop.load(propFile);
        return prop.getProperty("browser");
    }
}
