package edp.stepdefs;

import com.codeborne.selenide.Selenide;
import edp.pageobject.pages.interfaces.IContinuousDeliveryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class ContinuousDeliveryDefinitionSteps {
    @Autowired
    private IContinuousDeliveryPage continuousDeliveryPage;

    @And("User clicks 'Create' button in CD pipeline tab")
    public void userClicksCreateButtonInCdPipelineTab() {
        Selenide.sleep(1_000);
        continuousDeliveryPage.clickCreateButtonInCdPipelineTab();
    }

    @And("User enters {string} cd pipeline name")
    public void userEntersCdPipelineName(final String cdPipelineName) {
        continuousDeliveryPage.enterCdPipelineName(cdPipelineName);
    }

    @And("User selects {string} application by checkbox")
    public void userSelectsApplicationByCheckbox(final String applicationName) {
        continuousDeliveryPage.selectApplicationByCheckbox(applicationName);
    }

    @And("User selects {string} docker stream")
    public void userSelectsDockerStream(final String dockerStream) {
        continuousDeliveryPage.selectDockerStream(dockerStream);
    }

    @And("User clicks 'Add CD pipeline stage' button")
    public void userClicksAddStageButton() {
        continuousDeliveryPage.clickAddStageButton();
    }

    @And("User enters {string} cd pipeline stage name")
    public void userEntersStageName(final String stageName) {
        continuousDeliveryPage.enterStageName(stageName);
    }

    @And("User enters {string} description")
    public void userEntersStageDescription(final String stageDescription) {
        continuousDeliveryPage.enterStageDescription(stageDescription);
    }

    @And("User selects {string} quality gate type")
    public void userSelectsQualityGateType(final String qualityGateType) {
        continuousDeliveryPage.selectQualityGateType(qualityGateType);
    }

    @And("User enters {string} step name")
    public void userEntersStepName(final String stepName) {
        continuousDeliveryPage.enterStepName(stepName);
    }

    @And("User selects {string} autotest")
    public void userSelectsAutotest(String autotest) {
        continuousDeliveryPage.selectAutotest(autotest);
    }

    @And("User selects {string} autotests branch")
    public void userSelectsAutotestsBranch(String autotestsBranch) {
        continuousDeliveryPage.selectAutotestsBranch(autotestsBranch);
    }

    @And("User clicks 'Add' button")
    public void userClicksAddButton() {
        continuousDeliveryPage.clickAddButton();
    }

    @And("User clicks 'Services' section")
    public void userClicksServicesSection() {
        Selenide.sleep(1_000);
        continuousDeliveryPage.clickServicesSection();
    }

    @Then("User sees success status for {string} cd pipeline name")
    public void userSeesSuccessStatusForCdPipelineName(final String cdPipelineName) {
        continuousDeliveryPage.cdPipelineNameStatusShouldBeActive(cdPipelineName);
    }
}
