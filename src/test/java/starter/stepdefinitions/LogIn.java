package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.steplibraries.LoginSteps;
import starter.webpages.LoginPage;

import java.io.InterruptedIOException;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.core.Serenity.getDriver;
import static org.junit.Assert.assertTrue;

public class LogIn {

    private String username;
    LoginPage loginPage;

    @Steps
    LoginSteps loginSteps;

    public LogIn(){
        loginPage = new LoginPage(getDriver());
    }

    @And("I click on Login button")
    public void iClickOnLoginButton() {
        loginSteps.clickOnLoginButton();
    }

    @And("I fill in existing user credentials")
    public void iFillInExistingUserCredentials(DataTable table) {

        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        String username = data.get(0).get("username");
        String password = data.get(0).get("password");

        loginPage.fillInLoginDetails(username, password);
    }

   /* @When("I click on Log in button again")
    public void iClickOnLogInButtonAgain() {
        loginSteps.clickOnLoginButton();
    }*/

    @And("I click on log in button on pop up")
    public void iClickOnLogInButtonOnPopUp() {
     loginSteps.clickOnLoginButtonOnPopUp();
    }


    @Then("I should see a welcome message")
    public void iShouldSeeAWelcomeMessage() {
        assertTrue("Not logged in!", loginPage.isUserLoggedIn());
    }
}
