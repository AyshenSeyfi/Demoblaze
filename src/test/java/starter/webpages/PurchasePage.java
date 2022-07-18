package starter.webpages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchasePage extends PageObject {

    @FindBy(xpath = "//a[text()='Samsung galaxy s6']")
    public WebElement Product1;

    @FindBy(xpath = "//a[text()='Add to cart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//a[@id='cartur']")
    public WebElement cartButton;

    @FindBy(xpath = "//button[text()='Place Order']")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameField;

    @FindBy(xpath = "//input[@id='card']")
    public WebElement creditCardField;

    @FindBy(xpath = "//button[text()='Purchase']")
    public WebElement purchaseButton;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement okButton;

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    public WebElement successfulPurchaseMessage;


    public void fillInName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void fillInCreditCard(String creditCard) {
        creditCardField.clear();
        creditCardField.sendKeys(creditCard);
    }

    public void fillInPurchaseDetails(String name, String creditCard) {
        fillInName(name);
        fillInCreditCard(creditCard);
    }

    public boolean ThankYouForPurchaseMessage() {
        return element(successfulPurchaseMessage).waitUntilVisible().isDisplayed();
    }
}