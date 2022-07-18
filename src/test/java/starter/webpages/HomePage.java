package starter.webpages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageObject {


    @FindBy(xpath = "//a[@id='signin2']")
    WebElement signUpButton;

    @FindBy(xpath = "//a[@id='nameofuser']")
    WebElement welcomeMessage;
    @FindBy(xpath = "//input[@id='sign-username']")
    public WebElement usernameField;

    @FindBy(xpath = "//input[@id='sign-password']")
    public WebElement passwordField;

    @FindBy(css = "div#signInModal > div[role='document'] .btn.btn-primary")
    public WebElement signUpButtonOnPopUp;

    @FindBy(xpath = "//a[text()='Samsung galaxy s6']")
    WebElement productPhone;

    @FindBy(xpath = "//a[text()='Add to cart']")
    WebElement addToCartButton;



    public void clickOnSignUpButton(){
        signUpButton.click();
    }

    public void fillInEmail(String text) {

        usernameField.clear();
        usernameField.sendKeys(text);
    }

    public void fillInPassword(String text) {

        passwordField.clear();
        passwordField.sendKeys(text);
    }

    public void fillInRegistrationDetails(String username, String password){
        fillInEmail(username);
        fillInPassword(password);
    }

    public void dismissAlert(){
        waitFor(ExpectedConditions.alertIsPresent());

        getDriver().switchTo().alert().accept();
    }

     public String seeSuccessfulSignUpMessage(){
         waitFor(ExpectedConditions.alertIsPresent());
         String successfullmessage = getDriver().switchTo().alert().getText();
         return successfullmessage;
}

     public String ThisUserAlreadyExistsAlert(){
         waitFor(ExpectedConditions.alertIsPresent());
         String alreadyExists = getDriver().switchTo().alert().getText();
         return alreadyExists;
     }

    public boolean signUpSuccessful() {
        return  element(welcomeMessage).waitUntilVisible().isDisplayed();
    }

}