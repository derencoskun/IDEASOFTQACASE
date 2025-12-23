package util;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Properties;

public class DriverFactory {

    private static WebDriver driver;
    static Properties properties;

    public static WebDriver initDriver(String browser){

        if (driver != null){
            return driver;
        }
        properties = ConfigReader.getProperties();

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(Integer.parseInt(properties.getProperty("impWait")))
        );
        driver.manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(Integer.parseInt(properties.getProperty("pageLoadTimeout")))
        );

        driver.get(properties.getProperty("url"));
        return driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }


}
