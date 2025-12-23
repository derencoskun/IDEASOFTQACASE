package util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class    Hooks {

    WebDriver driver;
    Properties properties;


    @Before
    public void before() {
        DriverFactory.initDriver("chrome");

    }

    @After
    public void after() {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
