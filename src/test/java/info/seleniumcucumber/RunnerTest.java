package info.seleniumcucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// Tells JUnit to run this class using Cucumber’s test runner
@RunWith(Cucumber.class)

// Cucumber configuration options
@CucumberOptions(
        // Reporting plugins
        plugin = {
                "pretty", // Prints readable console output
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", // Generates Extent Report
                "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm", // Generates Allure Report
                "json:target/reports/cucumber-json-reports/json-report.json", // Outputs JSON report
                "html:target/reports/cucumber-html-reports/html-report.html"  // Outputs HTML report
        },

        // Package(s) containing step definitions
        glue = {"info.seleniumcucumber.steps"},

        // Path to feature file(s) — here it's a single feature file
        features = {"classpath:features/my_first.feature"}
)
public class RunnerTest {
    // Empty class: JUnit uses annotations to control test execution
}
