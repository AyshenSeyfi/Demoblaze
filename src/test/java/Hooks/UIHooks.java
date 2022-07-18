package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.core.Serenity.getDriver;

public class UIHooks {

    @Before(value = "web", order = 1)
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }


        @After("@web")
        public void tearDown() {

            if (getDriver() != null) {
                getDriver().close();
            }
        }
}
