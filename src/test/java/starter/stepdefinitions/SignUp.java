package starter.stepdefinitions;


import TestData.DefaultUser;
import TestData.UIConstants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import models.UserModel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import starter.steplibraries.SignUpSteps;
import starter.webpages.HomePage;
import starter.webpages.LoginPage;

import java.util.List;
import java.util.Map;

import static TestData.UIConstants.SUCCESSFULSIGNUP;
import static TestData.UIConstants.THISUSERALREADYEXISTSMESSAGE;
import static net.serenitybdd.core.Serenity.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignUp {
    @Steps
    SignUpSteps signUpSteps;

    HomePage homePage;
    private LoginPage loginPage;

    public SignUp() {
        homePage = new HomePage(getDriver());
    }

    @Given("I navigate to Demoblaze homepage")
    public void iNavigateToDemoblazeHomepage() {
        signUpSteps.navigateToHomePage();
    }

    @When("I click on Sign Up button")
    public void iClickOnSignUpButton() {
        signUpSteps.clickOnSignUpButton();
    }
    @And("I fill in with valid username and password")
    public void iFillInWithValidUsernameAndPassword() {

        UserModel myUserModel = DefaultUser.getDefaultUser();
        String username = myUserModel.getUsername();
        String password = myUserModel.getPassword();

        Serenity.setSessionVariable(UIConstants.USERNAME).to(username);
        Serenity.setSessionVariable(UIConstants.PASSWORD).to(password);

        homePage.fillInRegistrationDetails(username, password);
    }

    @And("I click on Sign Up button on pop up")
    public void iClickOnSignUpButtonOnPopUp() {
        signUpSteps.clickOnSignUpButtonOnPopUp();

    }

    @And("I log in with the signed up user")
    public void iLogInWithTheSignedUpUser() {

        String username = Serenity.sessionVariableCalled(UIConstants.USERNAME);
        String password = Serenity.sessionVariableCalled(UIConstants.PASSWORD);
        loginPage.fillInLoginDetails(username, password);
    }

    @And("I dismiss the successful sign up message")
    public void iDismissTheSuccessfulSignUpMessage() {
        signUpSteps.dismissAlert();
    }


    @And("I see the successful sign up message")
    public void iSeeTheSuccessfulSignUpMessage() {
        signUpSteps.seeSuccessfulSignUp();
        assertEquals(SUCCESSFULSIGNUP, homePage.seeSuccessfulSignUpMessage());
    }

    @And("I fill in with already existing user credentials")
    public void iFillInWithAlreadyExistingUserCredentials(DataTable table)  {

        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        String username = data.get(0).get("username");
        String password = data.get(0).get("password");

        homePage.fillInRegistrationDetails(username, password);
    }

    @Then("I see an error message that this user already exists")
    public void iSeeAnErrorMessageThatThisUserAlreadyExists() {
        signUpSteps.seeThisUserAlreadyExistsAlert();
        assertEquals(THISUSERALREADYEXISTSMESSAGE, homePage.ThisUserAlreadyExistsAlert());
    }
}

