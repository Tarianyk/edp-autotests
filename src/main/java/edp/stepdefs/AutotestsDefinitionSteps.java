package edp.stepdefs;

import edp.core.config.TestConfiguration;
import edp.pageobject.pages.interfaces.IAutotestsPage;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class AutotestsDefinitionSteps {
    @Autowired
    private IAutotestsPage autotestsPage;
    @Autowired
    private TestConfiguration testConfiguration;

    @And("User enters {string} autotest description")
    public void userEntersAutotestDescription(final String autotestDescription) {
        autotestsPage.enterAutotestDescription(autotestDescription);
    }

    @And("User selects {string} test report framework")
    public void userSelectsTestReportFramework(final String testReportFramework) {
        autotestsPage.selectTestReportFramework(testReportFramework);
    }
}
