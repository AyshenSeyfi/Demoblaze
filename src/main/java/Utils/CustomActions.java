package Utils;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.WebElement;

public class CustomActions extends UIInteractionSteps {
        public void clickOnElement(WebElement element) {
            $(element).waitUntilClickable().click();
        }

        public void type(WebElement element, String text) {
            $(element).waitUntilEnabled().type(text);
        }

        public boolean isDisplayed(WebElement element){
            return $(element).waitUntilVisible().isDisplayed();
        }
}