package info.seleniumcucumber.pages;

import info.seleniumcucumber.annotations.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

// Custom annotation to mark this class as a Page Object
@PageObject
public class LoginPage extends AbstractPage {

    // Locates the element with ID "flash", typically used for showing messages (e.g., login success/failure)
    @FindBy(how = How.ID, using = "flash")
    private WebElement MESSAGE;

    // Returns the MESSAGE WebElement after waiting for it to become visible
    // Uses a custom wait method from DriverWait
    public WebElement getMessage() throws NoSuchFieldException {
        getDriverWait().waitForElementToLoad(MESSAGE);
        return MESSAGE;
    }
}
}

