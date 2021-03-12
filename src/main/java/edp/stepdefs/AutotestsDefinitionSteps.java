package edp.stepdefs;

import edp.pageobject.pages.interfaces.IAutotestsPage;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class AutotestsDefinitionSteps {

    @Autowired
    private IAutotestsPage autotestsPage;

    @And("User enters {string} autotest description")
    public void userEntersAutotestDescription(final String autotestDescription) {
        autotestsPage.enterAutotestDescription(autotestDescription);
    }

    @And("User selects {string} test report framework")
    public void userSelectsTestReportFramework(final String testReportFramework) {
        autotestsPage.selectTestReportFramework(testReportFramework);
    }
}
