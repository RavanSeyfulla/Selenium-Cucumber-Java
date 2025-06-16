package info.seleniumcucumber.steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

// Class used for Cucumber hooks (code that runs before/after scenarios)
public class Hooks {

    // Logger instance used to print test execution logs
    private final Logger log = LoggerFactory.getLogger(Hooks.class);

    // Cucumber's @After hook — runs after each scenario
    @After
    public void afterScenario(Scenario scenario) {
        endOfTest(scenario); // Call method to handle post-test actions
    }

    // Method to handle actions after a test scenario finishes
    public void endOfTest(Scenario scenario) {
        // If scenario failed and has a valid status
        if (scenario.getStatus() != null && scenario.isFailed()) {
            // Create a clean filename from the scenario name
            String filename = scenario.getName().replaceAll("\\s+", "_");

            // Extract part of the scenario ID (likely the feature name) to append
            final String featureError = scenario.getId()
                    .replaceAll("\\s+", "_")
                    .replaceAll(":", "_")
                    .split("\\.")[1];

            filename = filename + "_" + featureError;

            // Attach failure info to the Cucumber report (placeholder as image/png)
            // NOTE: This line *pretends* to embed an image, but it's embedding text.
            // In actual use, you'd attach a real screenshot (byte[]) here.
            scenario.embed(filename.getBytes(StandardCharsets.UTF_8), "image/png", filename);
        }

        // Log scenario result
        log.info("");
        log.info("==========================================================================");
        log.info("================================Test " + scenario.getStatus().toString() + "===============================");
        log.info("==========================================================================");
        log.info("");
    }
}
