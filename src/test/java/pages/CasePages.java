package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;

import java.time.Duration;

public class CasePages {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;

    By searchInput = new By.ByName("q");
    By searchButton = new By.ByXPath("//*[@id=\"header\"]/div/div/div/div[2]/div/form/button");
    By add = new By.ByClassName("add-to-cart-button");
    By check = new By.ByCssSelector("div.shopping-information-cart");
    By cart = new By.ByXPath("//*[@id='header']//div[contains(@class,'cart-menu')]//a");
    By cartPageCheck = new By.ByXPath("//*[@id=\"cart-content\"]/div[1]/h4");
    By number = new By.ByXPath("//*[@id=\"cart-items\"]/div/div/div[2]/div/div/div[2]/div/div/div/input");
    By product = new By.ByCssSelector("a[href='/urun/test-urunudur']");
    By piece = new By.ByXPath("//*[@id=\"product-detail-container\"]/div[1]/div/div[2]/div/div[4]/div[1]/div/a[2]");

    public CasePages (WebDriver driver){
        this.driver = driver;
        this.elementHelper = new ElementHelper(driver);
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }



    public void searchForProduct(String productName) {

        elementHelper.clickElement(searchInput);
        elementHelper.sendText(searchInput,productName);
        elementHelper.clickElement(searchButton);
        System.out.println("### Ürün Arama Yapıldı ###");

    }

    public void openProductDetail(){

        elementHelper.scrollToElement(product);
        System.out.println("### Ürün Detayı Açıldı ###");



    }

    public void verifyAddedToCartMessage(){

        //By toast = By.cssSelector("div[class*='toast'], div[role='alert']");

        WebElement message = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(check));

        Assert.assertTrue(
                message.getText().contains("SEPETİNİZE EKLENMİŞTİR")
        );

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(check));

        System.out.println("### Sepete ekleme mesajı görüldü ###");


    }


    public  void addCountPiecesOfProduct(int count) {
        for (int i = 0; i<(count-1); i++){
            elementHelper.clickElement(piece);

        }
        elementHelper.clickElement(add);
        elementHelper.findElement(check);
        System.out.println("### Sepete ekleme tıklandı ###");

    }

    public  void goToYourCart() {


        elementHelper.clickElement(cart);
        elementHelper.findElement(cartPageCheck);
        System.out.println("### Sepet açıldı  ###");

    }

    public  void checkTheNumberOfTheProductsInTheCart(int pieces) {
        int a = Integer.parseInt(elementHelper.findElement(number).getAttribute("value"));
       if (a == pieces){
           System.out.println("Sepetteki ürün sayısı doğru");
        }
        else{
            System.out.println("Sepetteki ürün sayısı yanlış" );
        }


    }
}
