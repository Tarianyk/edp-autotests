package edp;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/petclinicDeploy.feature",
        plugin = {"json:build/cucumber.json", "html:build/site/cucumber-pretty"},
        glue = {"edp.stepdefs", "edp.types"},
        stepNotifications = true

)
public class CucumberTest {

}
