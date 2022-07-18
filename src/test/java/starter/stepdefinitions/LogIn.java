package starter.stepdefinitions;

import Utils.CustomActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.steplibraries.LoginSteps;
import starter.webpages.HomePage;
import starter.webpages.LoginPage;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class LogIn {
    @Steps(shared = true)
    LoginPage loginPage;
    @Steps(shared = true)
    LoginSteps loginSteps;
    @Steps(shared = true)
    CustomActions customActions;
    @Steps(shared = true)
    HomePage homePage;


    @And("I click on Login button")
    public void iClickOnLoginButton() {
        loginSteps.clickOnLoginButton();
    }

    @And("I fill in existing user credentials")
    public void iFillInExistingUserCredentials(DataTable table) {

        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        String username = data.get(0).get("username");
        String password = data.get(0).get("password");

//       loginPage.fillInLoginDetails(username, password);

        customActions.type(loginPage.loginUsernameField, username);
        customActions.type(loginPage.loginPasswordField, password);
    }

    @And("I click on log in button on pop up")
    public void iClickOnLogInButtonOnPopUp() {
     loginSteps.clickOnLoginButtonOnPopUp();
    }

    @Then("I should see a welcome message")
    public void iShouldSeeAWelcomeMessage() {
        assertTrue("Not logged in!", loginPage.isUserLoggedIn());
    }
}
