package starter.hooks;

import io.cucumber.java.After;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.events.AfterScenario;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class UIHooks {

    @After("@web")
    public void tearDown() {

        if (Serenity.getDriver() != null) {
            Serenity.getDriver().close();
        }

    }

}
