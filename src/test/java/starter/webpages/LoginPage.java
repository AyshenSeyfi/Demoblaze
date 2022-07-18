package starter.webpages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    //WebDriver webDriver;

    @FindBy(xpath = "//a[@id='login2']")
    WebElement logInButton;

    @FindBy(css = "div#logInModal > div[role='document'] .btn.btn-primary")
    public
    WebElement logInButtonOnPopUp;

    @FindBy(id = "loginusername")
            public
    WebElement loginUsernameField;

    @FindBy(id = "loginpassword") public WebElement loginPasswordField;

    @FindBy(xpath = "//a[@id='nameofuser']")
    WebElement welcomeMessage;


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
