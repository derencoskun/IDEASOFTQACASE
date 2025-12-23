package stepdefinition;
import pages.CasePages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;


public class StepDefinitions {


    WebDriver driver;
    CasePages casePages;

    public StepDefinitions(){

    }
    @Given("Webpage is open")
    public void webpageIsOpen() {
        System.out.println("### çalıştı ###");
        driver = DriverFactory.getDriver();
        casePages = new CasePages(driver);

    }

    @When("Search for {string}")
    public void searchForProduct(String product) {

        System.out.println("### STEP ÇALIŞTI ###");
        casePages.searchForProduct(product);


    }

    @When("Go to product detail")
    public void productDetail(){
        casePages.openProductDetail();
    }


    @When("Add {int} pieces of product")
    public void addCountPiecesOfProduct(int count) {

        casePages.addCountPiecesOfProduct(count);
        casePages.verifyAddedToCartMessage();

    }

    @When("Go to your Cart")
    public void goToYourCart() {

        casePages.goToYourCart();

    }

    @Then("Check the number of the products in the cart is {int}")
    public void checkTheNumberOfTheProductsInTheCart(int pieces) {
        casePages.checkTheNumberOfTheProductsInTheCart(pieces);

    }
}
