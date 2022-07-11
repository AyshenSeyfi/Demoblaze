package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import starter.steplibraries.PurchaseSteps;
import starter.steplibraries.SignUpSteps;
import starter.webpages.HomePage;
import starter.webpages.PurchasePage;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import static TestData.UIConstants.SUCCESSFUL_PURCHASE;
import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.core.Serenity.webdriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Purchase extends PageObject {
    @Steps
    PurchaseSteps purchaseSteps;

    HomePage homePage;
    PurchasePage purchasePage;

    public Purchase() {homePage = new HomePage(getDriver());}

    @And("I click on the product")
    public void iClickOnTheProduct() {
        purchaseSteps.clickOnProduct();
    }

    @And("I click on Add to Cart button")
    public void iClickOnAddToCartButton() {
        purchaseSteps.clickOnAddToCartButton();
    }

    @And("I dismiss the message")
    public void iDismissTheMessage() {
        homePage.dismissAlert();
    }

    @When("I click on Cart button")
    public void iClickOnCartButton() {
        purchaseSteps.clickOnCartButton();
    }

    @And("I click on Place order")
    public void iClickOnPlaceOrder() {
        purchaseSteps.clickOnPlaceOrder();
    }

    @And("I fill in mandatory information")
    public void iFillInMandatoryInformation(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        String name = data.get(0).get("name");
        String creditCard = data.get(0).get("creditCard");

        purchasePage.fillInPurchaseDetails(name,creditCard);
    }

    @Then("I click on Purchase button")
    public void iClickOnPurchaseButton() {
        purchaseSteps.clickOnPurchaseButton();
    }

    @And("I should see successful purchase message")
    public void iShouldSeeSuccessfulPurchaseMessage() {
        assertTrue("Thank you for your purchase!", purchasePage.ThankYouForPurchaseMessage());
    }
}