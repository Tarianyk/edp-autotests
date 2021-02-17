package edp;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CustomCucumberJunitRunner;
import org.junit.runner.RunWith;

@RunWith(CustomCucumberJunitRunner.class)
@CucumberOptions(
        features = "src/main/resources/features/placeholder.feature",
        plugin = {"json:build/cucumber.json", "html:build/site/cucumber-pretty"},
        glue = {"edp.stepdefs", "edp.types"},
        stepNotifications = true

)
public class CucumberTest {

}
