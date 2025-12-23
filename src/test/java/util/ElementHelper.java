package util;

import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class ElementHelper {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.action = new Actions(driver);
    }

    public WebElement visibleElement(By key){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(key));
    }

    public WebElement findElement(By key){
        WebElement webElement = visibleElement(key);
        return webElement;
    }

    public void clickElement(By key){
        findElement(key).click();
    }

    public void sendText(By key, String text){
        findElement(key).sendKeys(text);
    }

    public void scrollToElement(By location){
        /*WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(location));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'});",element);*/

        JavascriptExecutor js = (JavascriptExecutor) driver;
        int scrollY = 0;

        for (int i = 0; i < 10; i++) {

            List<WebElement> elements = driver.findElements(location);

            for (WebElement element : elements) {
                if (element.isDisplayed() && element.getSize().getHeight() > 0) {
                    js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
                    element.click();
                    return;
                }
            }

            scrollY += 600;
            js.executeScript("window.scrollTo(0, arguments[0]);", scrollY);
        }

        throw new NoSuchElementException("Scroll sonrası ürün bulunamadı");

    }

}