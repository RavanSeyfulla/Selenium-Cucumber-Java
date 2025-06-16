package info.seleniumcucumber.pages;

import info.seleniumcucumber.utils.BaseTest;
import info.seleniumcucumber.utils.DriverManager;
import info.seleniumcucumber.utils.DriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

p// Abstract base class for all Page Objects
// Provides shared functionality like driver access and element initialization
public abstract class AbstractPage implements BaseTest {

    // Responsible for managing the WebDriver instance (e.g., ChromeDriver, FirefoxDriver)
    private final DriverManager driverManager = new DriverManager();

    // Provides custom wait methods (e.g., explicit waits like waiting for elements to be visible)
    private final DriverWait driverWait = new DriverWait(driverManager);

    // Constructor is called when a page object class (extending this) is instantiated
    // Initializes all @FindBy elements declared in the subclass using Selenium PageFactory
    protected AbstractPage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    // Returns the WebDriver instance so that child classes can perform actions like .get(), .click(), etc.
    public WebDriver getDriver() {
        return driverManager.getDriver();
    }

    // Returns the DriverWait instance to perform explicit wait operations
    public DriverWait getDriverWait() {
        return driverWait;
    }

    // Utility method to pause execution for a given amount of time
    // 'time' is expected to be a string representing milliseconds (e.g., "2000" = 2 seconds)
    public void wait(String time) throws InterruptedException {
        Thread.sleep(Integer.parseInt(time));
    }
}
}
