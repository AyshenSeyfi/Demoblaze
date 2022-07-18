package starter.steplibraries;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.webpages.LoginPage;

public class LoginSteps {

    @Steps(shared = true)
    LoginPage loginPage;

    @Step("Clicking on login button")
    public void clickOnLoginButton(){
        loginPage.clickOnLoginButton();
    }

    @Step("Clicking on login button on pop up")
    public void clickOnLoginButtonOnPopUp(){
        loginPage.logInButtonOnPopUp.click();
    }
}
