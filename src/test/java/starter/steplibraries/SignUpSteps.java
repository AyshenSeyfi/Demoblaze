package starter.steplibraries;

import Configuration.ConfigurationReader;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.webpages.HomePage;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class SignUpSteps {

    @Steps(shared = true)
    HomePage homePage;
    @Steps(shared = true)
    ConfigurationReader configurationReader;


    @Step
    public void navigateToHomePage(){
        String url = configurationReader.getApplicationUrl();
        getDriver().get(url);
    }

    @Step("Clicking on sign up button")
    public void clickOnSignUpButton(){
        homePage.clickOnSignUpButton();
    }

    @Step
    public void clickOnSignUpButtonOnPopUp(){
        homePage.signUpButtonOnPopUp.click();
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
}