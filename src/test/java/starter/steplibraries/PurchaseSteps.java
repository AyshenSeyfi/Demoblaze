package starter.steplibraries;

import Configuration.ConfigurationReader;
import net.thucydides.core.annotations.Step;
import starter.webpages.HomePage;
import starter.webpages.PurchasePage;

import java.io.IOException;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class PurchaseSteps {

    private PurchasePage purchasePage;
    private ConfigurationReader configurationReader;

    public PurchaseSteps() throws IOException {
        configurationReader = new ConfigurationReader();
        purchasePage = new PurchasePage(getDriver());
    }

    @Step
    public void clickOnProduct(){
        purchasePage.Product1.click();
    }
    @Step
    public void clickOnAddToCartButton(){
        purchasePage.addToCartButton.click();
    }
    @Step
    public void clickOnCartButton(){
        purchasePage.cartButton.click();
    }
    @Step
    public void clickOnPlaceOrder(){
        purchasePage.placeOrderButton.click();
    }
    @Step
    public void clickOnPurchaseButton(){
        purchasePage.purchaseButton.click();
    }
}
