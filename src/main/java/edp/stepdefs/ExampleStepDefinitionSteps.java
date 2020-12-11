package edp.stepdefs;

import io.cucumber.java.en.Given;

public class ExampleStepDefinitionSteps {

    @Given("User prints {string} in a console")
    public void userPrintsStringInConsole(final String message) {
        System.out.println(message);
    }

}
