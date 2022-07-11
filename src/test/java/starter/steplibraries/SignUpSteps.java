package starter.steplibraries;

import Configuration.ConfigurationReader;
import lombok.var;
import net.thucydides.core.annotations.Step;
import starter.webpages.HomePage;

import java.io.IOException;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class SignUpSteps {

    private ConfigurationReader configurationReader;
    private HomePage homePage;

    public SignUpSteps() throws IOException {
        configurationReader = new ConfigurationReader();
        homePage = new HomePage(getDriver());
    }

    @Step
    public void navigateToHomePage(){
        var url = configurationReader.getApplicationUrl();
        getDriver().get(url);
    }

    @Step("Clicking on sign up button")
    public void clickOnSignUpButton(){
        homePage.clickOnSignUpButton();
    }

    @Step
    public void dismissAlert(){
        homePage.dismissAlert();
    }

    @Step
    public void seeSuccessfulSignUp(){
        homePage.seeSuccessfulSignUpMessage();
    }

    @Step
    public void seeThisUserAlreadyExistsAlert(){
        homePage.ThisUserAlreadyExistsAlert();
    }

    @Step
    public void clickOnSignUpButtonOnPopUp(){
        homePage.signUpButtonOnPopUp.click();

    }
}