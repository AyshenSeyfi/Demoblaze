package starter.steplibraries;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.webpages.PurchasePage;

public class PurchaseSteps {

    @Steps(shared = true)
    PurchasePage purchasePage;

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
