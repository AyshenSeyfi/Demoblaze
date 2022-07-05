package starter.webpages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageObject {

    WebDriver webDriver;

    @FindBy(xpath = "//a[@id='login2']")
    WebElement logInButton;

    @FindBy(css = "div#logInModal > div[role='document'] .btn.btn-primary")
    public
    WebElement logInButtonOnPopUp;

    @FindBy(id = "loginusername")
    WebElement loginUsernameField;

    @FindBy(id = "loginpassword")
    WebElement loginPasswordField;

    @FindBy(xpath = "//a[@id='nameofuser']")
    WebElement welcomeMessage;


    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;

    }
    public void clickOnLoginButton(){
        logInButton.click();
    }

    public void fillInUsername(String username) {
        loginUsernameField.clear();
        loginUsernameField.sendKeys(username);
    }

    public void filInPassword(String password) {

        loginPasswordField.clear();
        loginPasswordField.sendKeys(password);
    }

    public void fillInLoginDetails(String username, String password){
        fillInUsername(username);
        filInPassword(password);
    }

    public boolean isUserLoggedIn() {
      return  element(welcomeMessage).waitUntilVisible().isDisplayed();
    }
}
