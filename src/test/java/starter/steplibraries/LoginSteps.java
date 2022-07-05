package starter.steplibraries;

import Configuration.ConfigurationReader;
import net.thucydides.core.annotations.Step;
import starter.webpages.HomePage;
import starter.webpages.LoginPage;

import java.io.IOException;

import static net.serenitybdd.core.Serenity.getDriver;

public class LoginSteps {

    private ConfigurationReader configurationReader;
    private HomePage homePage;
    private LoginPage loginPage;


    public LoginSteps() throws IOException {
        configurationReader = new ConfigurationReader();
        loginPage = new LoginPage(getDriver());
    }

    @Step("Clicking on login button")
    public void clickOnLoginButton(){
        loginPage.clickOnLoginButton();
    }

    @Step("Clicking on login button on pop up")
    public void clickOnLoginButtonOnPopUp(){
        loginPage.logInButtonOnPopUp.click();
    }
}
