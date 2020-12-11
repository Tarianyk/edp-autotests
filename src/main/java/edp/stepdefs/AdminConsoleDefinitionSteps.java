package edp.stepdefs;

import com.codeborne.selenide.Selenide;
import edp.pageobject.pages.IBrowserTabProcessing;
import edp.pageobject.pages.interfaces.IAdminConsolePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminConsoleDefinitionSteps {
    @Autowired
    private IAdminConsolePage adminConsolePage;

    @Given("User opens EDP Admin Console")
    public void userOpensEDPAdminConsole() {
        adminConsolePage.openPage();
    }

    @And("User clicks on Application tab")
    public void userClicksOnApplicationTab() {
        adminConsolePage.clickOnApplicationTab();
    }

    @When("User clicks on Libraries tab")
    public void userClicksOnLibrariesTab() {
        adminConsolePage.clickOnLibrariesTab();
    }

    @And("User clicks on Continuous Delivery tab")
    public void userClicksOnContinuousDeliveryTab() {
        Selenide.sleep(1_000);
        adminConsolePage.clickOnContinuousDeliveryTab();
    }

    @And("User clicks on Autotests tab")
    public void userClicksOnAutotestsTab() {
        adminConsolePage.clickOnAutotestsTab();
    }

    @And("User clicks 'Overview' tab")
    public void userClicksOnOverviewTab() {
        adminConsolePage.clickOnOverviewTab();
    }

    @And("User click 'Gerrit' link")
    public void userClicksGerritLink() {
        adminConsolePage.clickGerritLink();
    }

    @And("User clicks 'Jenkins' link")
    public void userClicksJenkinsLink() {
        adminConsolePage.clickJenkinsLink();
        IBrowserTabProcessing.switchToNewTab();
    }

    @And("User clicks 'Browse' button")
    public void userClicksBrowseButton() {

    }

    @And("User clicks 'OpenShift' link")
    public void userClicksOpenShiftLink() {
        adminConsolePage.clickOpenShiftLink();
        IBrowserTabProcessing.switchToNewTab();
    }

}
