package edp.pageobject.pages.interfaces;

public interface IContinuousDeliveryPage extends IBasePage {

    void clickCreateButtonInCdPipelineTab();

    void enterCdPipelineName(String cdPipelineName);

    void selectApplicationByCheckbox(String applicationName);

    void selectDockerStream(String dockerStream);

    void clickAddStageButton();

    void enterStageName(String stageName);

    void enterStageDescription(String stageDescription);

    void selectQualityGateType(String qualityGateType);

    void enterStepName(String stepName);

    void selectAutotest(String autotest);

    void selectAutotestsBranch(String autotestsBranch);

    void clickAddButton();

    void clickServicesSection();

    void cdPipelineNameStatusShouldBeActive(String cdPipelineName);
}

