package edp.pageobject.pages.impl;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import edp.core.annotations.Page;
import edp.pageobject.pages.interfaces.IContinuousDeliveryPage;
import edp.utils.wait.FlexWait;
import io.vavr.control.Try;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.function.Predicate;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static edp.core.utils.WaitingUtils.waitForAjaxToComplete;
import static edp.core.utils.WaitingUtils.waitForPageReadyState;

@Lazy
@Page
@Scope("prototype")
public class ContinuousDeliveryPage extends AbstractBasePage implements IContinuousDeliveryPage {
    private static final String CREATE_CD_PIPELINE_BUTTON = "//button[contains(@class,'btn-success')]";
    private static final String CD_PIPELINE_NAME = "//input[@id='pipelineName']";
    private static final String APPLICATION_CHECKBOX = "//label[@for = '%s']";
    private static final String ADD_STAGE_BUTTON = "//button[@class='add-stage-modal circle plus']";
    private static final String STAGE_NAME = "//input[@id='stageName']";
    private static final String STAGE_DESCRIPTION = "//input[@id='stageDesc']";
    private static final String QUALITY_GATE_DROPDOWN = "//select[@id='qualityGateType']";
    private static final String STEP_NAME = "//input[@id='nameOfStep']";
    private static final String AUTOTESTS_DROPDOWN = "//select[@class='form-control element-width autotest-projects']";
    private static final String AUTOTESTS_BRANCH_DROPDOWN = "//select[@class='form-control element-width autotest-branches']";
    private static final String ADD_BUTTON = "//button[@class='add-stage btn btn-primary']";
    private static final String SERVICES_SECTION = "//button[text()[normalize-space(.) = 'Services']]";
    private static final String DOCKER_STREAM_DROPDOWN = "//select[@title='Input Docker Streams']";
    private static final String CD_PIPELINE_STATUS = "//tr[@data-cd-pipeline-name='%s']";


    @Override
    public void clickServicesSection() {
        waitForPageReadyState();
        waitForAjaxToComplete();
        $x(SERVICES_SECTION).shouldBe(Condition.visible).click();
    }

    @Override
    public void enterStageName(String stageName) {
        $x(STAGE_NAME).shouldBe(Condition.visible).sendKeys(stageName);

    }

    @Override
    public void clickAddStageButton() {
        $x(ADD_STAGE_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void selectDockerStream(String dockerStream) {
        $$x(String.format(DOCKER_STREAM_DROPDOWN, dockerStream)).first().hover().shouldBe(Condition.visible).click();
//        $x(DOCKER_STREAM_DROPDOWN).shouldBe(Condition.visible).selectOptionByValue(dockerStream);
//        $x(DOCKER_STREAM_DROPDOWN).shouldHave(Condition.exactValue(dockerStream));
    }

    @Override
    public void selectApplicationByCheckbox(String applicationName) {
        waitForPageReadyState();
        waitForAjaxToComplete();
        $x(String.format(APPLICATION_CHECKBOX, applicationName)).hover().shouldBe(Condition.visible).click();
//        $$x(APPLICATION_CHECKBOX).filter(Condition.visible).first().hover().shouldBe(Condition.visible).click();
    }

    @Override
    public void enterStepName(String stepName) {
        $x(STEP_NAME).shouldBe(Condition.visible).sendKeys(stepName);
    }

    @Override
    public void clickAddButton() {
        $x(ADD_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void selectAutotestsBranch(String autotestsBranch) {
        $x(AUTOTESTS_BRANCH_DROPDOWN).shouldBe(Condition.visible).selectOptionByValue(autotestsBranch);
        $x(AUTOTESTS_BRANCH_DROPDOWN).shouldHave(Condition.exactValue(autotestsBranch));
    }

    @Override
    public void selectAutotest(String autotest) {
        $x(AUTOTESTS_DROPDOWN).shouldBe(Condition.visible).selectOptionByValue(autotest);
        $x(AUTOTESTS_DROPDOWN).shouldHave(Condition.exactValue(autotest));
    }

    @Override
    public void selectQualityGateType(String qualityGateType) {
        $x(QUALITY_GATE_DROPDOWN).shouldBe(Condition.visible).selectOptionByValue(qualityGateType);
        $x(QUALITY_GATE_DROPDOWN).shouldHave(Condition.exactValue(qualityGateType));
    }

    @Override
    public void enterStageDescription(String stageDescription) {
        $x(STAGE_DESCRIPTION).shouldBe(Condition.visible).sendKeys(stageDescription);
    }

    @Override
    public void clickCreateButtonInCdPipelineTab() {
        waitForPageReadyState();
        waitForAjaxToComplete();
        $x(CREATE_CD_PIPELINE_BUTTON).shouldBe(Condition.visible).click();

    }

    @Override
    public void enterCdPipelineName(String cdPipelineName) {
        waitForPageReadyState();
        waitForAjaxToComplete();
        Selenide.sleep(1_000);
        $x(CD_PIPELINE_NAME).shouldBe(Condition.visible).sendKeys(cdPipelineName);
    }

    @Override
    public void cdPipelineNameStatusShouldBeActive(String cdPipelineName) {
        waitForPageReadyState();
        waitForAjaxToComplete();
        Selenide.refresh();
//        $x(String.format(APPLICATION_STATUS, appName)).hover().shouldHave(Condition.attribute("data-codebase-status", "active"));
        Predicate<SelenideElement> checkStatus = status -> {
            $x(String.format(CD_PIPELINE_STATUS, cdPipelineName)).shouldBe(Condition.visible);
            Selenide.refresh();
//            return Try.of(() -> StringUtils.equals($x(String.format(BRANCH_NAME, branchName)).getAttribute("data-branch-status"), "active")).isSuccess();
            return Try.of(() -> $x(String.format(CD_PIPELINE_STATUS, cdPipelineName)).shouldHave(Condition.attribute("data-cd-pipeline-status", "active"))).isSuccess();
        };
        new FlexWait<SelenideElement>(String.format("wait for success status of %s cd pipeline", cdPipelineName))
                .during(100000).tryTo(checkStatus).every(5000).executeWithoutResult();

    }
}

