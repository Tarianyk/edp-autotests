package edp.pageobject.pages.impl;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.conditions.Value;
import edp.core.annotations.Page;
import edp.pageobject.pages.interfaces.IJenkins;
import edp.utils.wait.FlexWait;
import io.vavr.control.Try;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.interactions.Actions;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import javax.swing.*;
import java.util.function.Predicate;

import static com.codeborne.selenide.Selenide.*;
import static edp.core.utils.WaitingUtils.waitForAjaxToComplete;
import static edp.core.utils.WaitingUtils.waitForPageReadyState;

@Lazy
@Page
@Scope("prototype")

public class Jenkins implements IJenkins {

    private static final String CODEBASE_JENKINS_FOLDER = "//td[not(@class)]//a[contains(@href, '%s')]";
    private static final String CD_PIPELINE_OVERVIEW = "//a[contains(text(), '%s')]";
    private static final String CREATE_RELEASE_JOB = "//tr[@id='job_%s']";
    private static final String BUILD_JOB = "//tr[@id='job_%s']";
    private static final String CD_PIPELINE_STAGE = "//tr[@id='job_%s']";
    private static final String MANAGE_JENKINS_BUTTON = "//span[text()='Manage Jenkins']";
    private static final String MANAGE_CREDENTIALS_BUTTON = "//dt[text()='Manage Credentials']";
    private static final String GLOBAL_BUTTON = "//a[text()='(global)']";
    private static final String ADD_CREDENTIALS_BUTTON = "//span[contains(text(),'Add Credentials')]";
    private static final String CREDENTIALS_KIND_DROPDOWN = "//select[contains(@class, 'dropdownList')]";
    private static final String API_TOKEN_INPUT = "//input[@name='_.apiToken']";
    private static final String TOKEN_ID_FIELD = "//input[contains(@checkurl, 'GitLabApiToken')]";
    private static final String OK_BUTTON = "//button[@id='yui-gen8-button']";
    private static final String SSH_KEY_ID_FIELD = "//input[contains(@checkurl, 'sshcredentials')]";
    private static final String ENTER_DIRECTLY_BUTTON = "//input[@id='radio-block-0']";
    private static final String ADD_SSH_BUTTON = "//input[contains(@class, 'secret-update-btn')]";
    private static final String PRIVAT_SSH_KEY_INPUT = "//textarea[contains(@name,'_.privateKey')]";
    private static final String SECRET_TOKEN = "//input[@name='_.secret']";
    private static final String SECRET_ID = "//input[contains(@checkurl,'StringCredentials')]";
    private static final String CONFIGURE_SYSTEM_BUTTON = "//div[@class='manage-option manage-page__column']";
    private static final String GITLAB_CONNECTION_NAME_FIELD = "//input[@checkurl='/descriptorByName/com.dabsquared.gitlabjenkins.connection.GitLabConnectionConfig/checkName']";
    private static final String GITLAB_HOST_URL_FIELD = "//input[@checkurl='/descriptorByName/com.dabsquared.gitlabjenkins.connection.GitLabConnectionConfig/checkUrl']";
    private static final String GITHUB_HOST_URL_FIELD = "//input[@checkurl='/descriptorByName/com.dabsquared.gitlabjenkins.connection.GitLabConnectionConfig/checkUrl']";
    private static final String GITLAB_ACCESS_API_TOKEN_DROPDOWN = "//select[contains(@name, '_.apiTokenId')]";
    private static final String SAVE_BUTTON = "//button[text()='Save']";
    private static final String GITHUB_SECTION = "//div[text()='GitHub']";
    private static final String ADD_GITHUB_SERVER_BUTTON = "//button[text()='Add GitHub Server']";
    private static final String GITHUB_SERVER_BUTTON = "//a[text()='GitHub Server']";
    private static final String GITHUB_CONNECTION_NAME_FIELD = "//tr[@class='has-help']//input[@name='_.name']";
    private static final String GITHUB_ACCESS_API_TOKEN_DROPDOWN = "//select[contains(@fillurl,'config.GitHubServerConfig')]";
    private static final String JOB_PROVISIONS_FOLDER = "//a[contains(@href, 'job-provisions')]";
    private static final String CI_FOLDER = "//a[contains(@href, 'job/ci/')]";
    private static final String NEW_ITEM_BUTTON = "//a[contains(@href, 'job/job-provisions/job/ci/newJob')]";
    private static final String PROVISIONER_NAME_FIELD = "//input[@id='name']";
    private static final String FREESTILE_PROJECT_OPTION = "//span[text()='Freestyle project']";
    private static final String CREATE_PROVISIONER_BUTTON = "//span[@class='yui-button primary large-button']";
    private static final String LABEL_EXPRESSION_FIELD = "//input[contains(@checkurl, 'FreeStyleProject/checkLabel')]";
    private static final String EXECUTE_CONCURRENT_BUILD_IF_NECESSARY_CHECKBOX = "//label[text()='Execute concurrent builds if necessary']";
    private static final String THIS_PROJECT_IS_PARAMETERIZED_CHECKBOX = "//label[text()='This project is parameterized']";
    private static final String ADD_PARAMETER_BUTTON = "//span[@class= 'yui-button yui-menu-button']";
    private static final String PARAMETERS_TYPE_DROPDOWN = "//ul[@class='first-of-type']//li[@id='yui-gen94']//a[text()='String Parameter']";
    private static final String PARAMETER_NAME_FIELD = "//input[@name='parameter.name']";
    private static final String BUILD_TRIGGER_BUTTON = "//div[contains(@class, 'config_build_triggers')]";
    private static final String ADD_BUILD_STEP_BUTTON = "//button[text()='Add build step']";
    private static final String BUILD_STEP_DROPDOWN = "//ul[@class='first-of-type']//a[text()='Process Job DSLs']";
    private static final String SAVE_PROVISIONER_BUTTON = "//button[@id='yui-gen78-button']";
    private static final String USE_THE_PROVIDED_DSL_SCRIPT_CHECKBOX = "//*[text()[contains(.,'Use the provided DSL script')]]//input";
    private static final String DSL_SCRIPT_WINDOW = "//div[@class='CodeMirror-scroll cm-s-default']";
    //    private static final String PROVISIONER_CODE_INPUT = "//div[@name='builder']//div[@class='CodeMirror-lines']/div/div[not(contains(@style,'hidden'))]/pre";
    private static final String CODE_INPUT = "//div[@class='CodeMirror-scroll cm-s-default']";
    private static final String GITHUB_CODE_INPUT = "//div[@class='CodeMirror-scroll cm-s-default']";
    private static final String SIT_JOB_BUTTON = "//a[@href='job/sit/']";
    private static final String BUILD_WITH_PARAMETERS_BUTTON = "//span[text()='Build with Parameters']";
    private static final String BUILD_BUTTON = "//button[text()='Build']";
    //    private static final String JOB_INFO_PAGE = "//a[contains(text(),'petclinic-sit')]";
    private static final String JOB_INFO_PAGE = "//a[@class='build-status-link']";
    private static final String PIPELINE_PROGRESS_BAR = "//td[@class='build-caption-progress-bar']";
    private static final String INIT_STAGE_PROGRESS = "//div[@class='progress']";
    private static final String VERSION_FOR_DEPLOY_DROPDOWN = "//div[@name='parameter']//select[@name='value']";
    private static final String PROCEED_BUTTON_IN_VERSION_INFORMATION_POPUP = "//button[text()='Proceed']";
    private static final String INPUT_REQUESTED_BUTTON = "//a[text()='Input requested']";
    private static final String PROSEED_TO_PROMOTE_BUTTON = "//a[text()='Proceed']";


    @Override
    public void clickCodebaseJenkinsFolder(String codebaseJenkinsFolder) {
        Selenide.sleep(5_000);
//        $$x(String.format(CODEBASE_JENKINS_FOLDER,codebaseJenkinsFolder)).shouldHaveSize(1).first().click();
        $x(String.format(CODEBASE_JENKINS_FOLDER, codebaseJenkinsFolder)).shouldBe(Condition.visible).click();
    }

    @Override
    public void openCdPipelineOverview(String codebaseJenkinsFolder) {
        $x(String.format(CD_PIPELINE_OVERVIEW, codebaseJenkinsFolder)).shouldBe(Condition.visible).click();
    }

    @Override
    public void createReleaseStatusShouldBeSuccess(String createReleaseJob) {
        Predicate<SelenideElement> checkStatus = status -> {
            $x(String.format(CREATE_RELEASE_JOB, createReleaseJob)).shouldBe(Condition.visible);
            Selenide.refresh();
            return Try.of(() -> $x(String.format(CREATE_RELEASE_JOB, createReleaseJob)).shouldHave(Condition.attribute("class", " job-status-blue"))).isSuccess();
        };
        new FlexWait<SelenideElement>(String.format("wait for success status for %s create release job", createReleaseJob))
                .during(100000).tryTo(checkStatus).every(5000).executeWithoutResult();
    }

    @Override
    public void buildJobStatusShouldBeSuccess(String buildJob) {
        Predicate<SelenideElement> checkStatus = status -> {
            $x(String.format(BUILD_JOB, buildJob)).shouldBe(Condition.visible);
            Selenide.refresh();
            return Try.of(() -> $x(String.format(BUILD_JOB, buildJob)).shouldHave(Condition.attribute("class", " job-status-blue"))).isSuccess();
        };
        new FlexWait<SelenideElement>(String.format("wait for success status for %s build job", buildJob))
                .during(500000).tryTo(checkStatus).every(5000).executeWithoutResult();
    }

    @Override
    public void cdPipelineStageStatusShouldBeSuccess(String cdPipelineStage) {
        Predicate<SelenideElement> checkStatus = status -> {
            $x(String.format(CD_PIPELINE_STAGE, cdPipelineStage)).shouldBe(Condition.visible);
            Selenide.refresh();
            return Try.of(() -> $x(String.format(BUILD_JOB, cdPipelineStage)).shouldHave(Condition.attribute("class", " job-status-blue"))).isSuccess();
        };
        new FlexWait<SelenideElement>(String.format("wait for success status for %s cd pipeline stage",cdPipelineStage))
                .during(500000).tryTo(checkStatus).every(5000).executeWithoutResult();
    }

    @Override
    public void clickManageJenkinsButton() {
        Selenide.sleep(2_000);
        $x(MANAGE_JENKINS_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickManageCredentialsButton() {
        $x(MANAGE_CREDENTIALS_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickGlobalButton() {
        $$x(GLOBAL_BUTTON).filter(Condition.visible).first().click();
    }

    @Override
    public void clickAddCredentialsButton() {
        $x(ADD_CREDENTIALS_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void selectCredentialsKind(String credentialsKind) {
        waitForPageReadyState();
        waitForAjaxToComplete();
        Selenide.sleep(1_000);
        $x(CREDENTIALS_KIND_DROPDOWN).shouldBe(Condition.visible).selectOption(credentialsKind);
//        $x(CREDENTIALS_KIND_DROPDOWN).shouldHave(Condition.exactValue(credentialsKind));
        Selenide.sleep(1_000);
    }

    @Override
    public void enterApiToken(String gitlabApiToken) {
        $x(API_TOKEN_INPUT).shouldBe(Condition.visible).sendKeys(gitlabApiToken);
    }

    @Override
    public void enterTokenId(String tokenId) {
        $x(TOKEN_ID_FIELD).shouldBe(Condition.visible).sendKeys(tokenId);
    }

    @Override
    public void clickOkButton() {
        waitForPageReadyState();
        waitForAjaxToComplete();
        Selenide.sleep(1_000);
        $x(OK_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void enterSshKeyId(String sshKeyId) {
        $x(SSH_KEY_ID_FIELD).shouldBe(Condition.visible).sendKeys(sshKeyId);
    }

    @Override
    public void clickEnterDirectlyButton() {
        $x(ENTER_DIRECTLY_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickAddSshButton() {
        $x(ADD_SSH_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void enterPrivatSshKey(String privatSshKey) {
        $x(PRIVAT_SSH_KEY_INPUT).shouldBe(Condition.visible).sendKeys("-----BEGIN OPENSSH PRIVATE KEY-----\n" +
                "b3BlbnNzaC1rZXktdjEAAAAABG5vbmUAAAAEbm9uZQAAAAAAAAABAAABlwAAAAdzc2gtcn\n" +
                "NhAAAAAwEAAQAAAYEAt4ar9ieTAQrm6wNGnC+wq6RlOjBFeqgjvHAXKc9KWYShjUywdbVR\n" +
                "k13pUqTulLDWfzLaQyu1Wmy3IGOI7J4nqKDzOYbRbbKqu94U7tlX90e3HJZEal/iyBhRSk\n" +
                "wgSFzNwqeV1fTQiMwEcWHolYgoCpQKLwPwG3pTaEhcWrasrjCuZMDWGgBQBlkzGVy8y7gq\n" +
                "tmPGRm3ZWDN/mWaF/ocC6DzPdxEv+RAZ+0gAnMSTlPQQpCzgvxk2SG8IIFpfrYSq/gCYvl\n" +
                "FNIXuHFk3FlAHbQiqAPTHfbNBeptvxhnWGIIWbJhEQOFuQS1bCkkuYTNHdjBswDy/g0svZ\n" +
                "OUdzErf+EzVLkc9jlmNy+4BVHlk1usyHNVdc8Qji3e53QB9LlXGRFI8Ne7wFgi4RHDs8Os\n" +
                "15Wq3YADc/SeIIhcDXdZxGKRofrkLRop/OtCI9JxT10l0RwzcZHLlNTXsCCRq0cY70i1ti\n" +
                "8AJ+bbALoYXDPQj4DsI22vR9Ju3FMWabOOuxPrqjAAAFmJShlQyUoZUMAAAAB3NzaC1yc2\n" +
                "EAAAGBALeGq/YnkwEK5usDRpwvsKukZTowRXqoI7xwFynPSlmEoY1MsHW1UZNd6VKk7pSw\n" +
                "1n8y2kMrtVpstyBjiOyeJ6ig8zmG0W2yqrveFO7ZV/dHtxyWRGpf4sgYUUpMIEhczcKnld\n" +
                "X00IjMBHFh6JWIKAqUCi8D8Bt6U2hIXFq2rK4wrmTA1hoAUAZZMxlcvMu4KrZjxkZt2Vgz\n" +
                "f5lmhf6HAug8z3cRL/kQGftIAJzEk5T0EKQs4L8ZNkhvCCBaX62Eqv4AmL5RTSF7hxZNxZ\n" +
                "QB20IqgD0x32zQXqbb8YZ1hiCFmyYREDhbkEtWwpJLmEzR3YwbMA8v4NLL2TlHcxK3/hM1\n" +
                "S5HPY5ZjcvuAVR5ZNbrMhzVXXPEI4t3ud0AfS5VxkRSPDXu8BYIuERw7PDrNeVqt2AA3P0\n" +
                "niCIXA13WcRikaH65C0aKfzrQiPScU9dJdEcM3GRy5TU17AgkatHGO9ItbYvACfm2wC6GF\n" +
                "wz0I+A7CNtr0fSbtxTFmmzjrsT66owAAAAMBAAEAAAGBALGLZkafaFak3lpS8/dbJ5YVVx\n" +
                "yg4EZV7SR6Z945vFq3tbZFj5yACef//R3Hk0tjfE7XulErMqnE7LA3upn2MrWu5z4qz+ZI\n" +
                "52UR5rxepPwDdAEC2jLyiik7ZUD0PnLi3OfISmsPCMKeZFnv9xrZ+qqpJuTu8VUT1SbYgg\n" +
                "f8Gzf0vnGYIEhNLx3FI2sQzVBj3WZPRdySnqX2RCX6Cfz/Te+wDKDKjtdrHUd8E6OVhJSg\n" +
                "PI0nIVGeKWaPi5QI+fCam1AU8ltOFZvKJvN44DOyjTvAAYvPRSQJltkNZq9mvHxd3xai1H\n" +
                "c5OLt8/Vqe5vnTf4w/PMouqW2xX9Q5mFFt59g48ND+Ezkl8b6d/LGNHgrmEsOKlSVPGTo4\n" +
                "zi+FTlx+m422mPTyLoTIz9SPXAfSd2m87IgmFhkGm85tzY1UG9pPGAFWfnJfp71NWL0ET+\n" +
                "2RsrU0iGbYBkNiEsVneSvV3LwUMSrWz0nubvazEwd7Q/IuvnRW9qbtT+Pe3GUVtlg+kQAA\n" +
                "AMAof/DWD5LsjNVFHk2V5OWz5nqkJKPaQ+jBYlOO00+HdXErWDbpQGOc2cqTc9vObLZfmD\n" +
                "sKkk+kzFbd8m32CqhWU3os23CfIRi0bDdw5l5XySlhdz9/3ESQyI2zA5tl2f4sw8RW0liU\n" +
                "fcDiOqDyNInUrf3RU5mRF+x4NFBDyQRlKLWiS7gvwI42gUiDCyXUiWZitdr4wewcP9G4io\n" +
                "kmHpxFx1w2Dzq1+EQWTBFIB5oW0AWun8gClYyYt3IQGwSiNa4AAADBAO5Dt1kfwDopNcSh\n" +
                "Chf9OcDBcMXUgydOQ2GaUD1OB6XvzKKXjffD0hRvCD+7mWy0lu2Wnz3HVtdd5oY1vojUJ4\n" +
                "YdPqEhYykC9nlAkNFrMsKL1mKQByGvA7DbHI+SbRuyNpY62hM5Za0qzX5G9kfxNipxlJcO\n" +
                "VFeYsRplnF5dr/URMtBDA6OPJqZpBCoOyBax8ZlFuX5AVwAbvPvcWeh0iRQniU7t8g5mbz\n" +
                "9zUJyAYMfkfWKAsccUhk75iGKIqW80qwAAAMEAxS/hBt51ASHQDgGPQZaUxvTSxVwCCrLq\n" +
                "cm8oPNRIoWUd/tViYLXp4FP3Kl+RZmCIJkkPhKXrRXN5QrAJdRMDuK3BauZoo0Ch9gipbD\n" +
                "xJK7Om65LFwhcINPHztmlBlodq80ExNaEl7mnE4JfXfoFiCEOSFTMVe+6Tn2ezGPMl38+Q\n" +
                "KWtLq0nfGuLpouBO9N2DGiuXi4Jiybf2lmLbZHCey1WRl0Ks8CPwTtwvWvDn0Rv13xp4b0\n" +
                "DASXBvnS7aOWHpAAAAG0RteXRyb19Lb25vbm92QEVQVUFLSEFXMDEwMgECAwQFBgc=\n" +
                "-----END OPENSSH PRIVATE KEY-----\n");

    }

    @Override
    public void enterSecretToken(String githubSecretToken) {
        $x(SECRET_TOKEN).shouldBe(Condition.visible).sendKeys(githubSecretToken);
    }

    @Override
    public void enterSecretTokenId(String secretId) {
        $x(SECRET_ID).shouldBe(Condition.visible).sendKeys(secretId);
    }

    @Override
    public void clickConfigureSystemButton() {
        $x(CONFIGURE_SYSTEM_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void enterGitlabConnectionName(String gitlabConnectionName) {
        $x(GITLAB_CONNECTION_NAME_FIELD).shouldBe(Condition.visible).sendKeys(gitlabConnectionName);
    }

    @Override
    public void enterGitlabHostUrl(String gitlabHostUrl) {
        $x(GITLAB_HOST_URL_FIELD).shouldBe(Condition.visible).sendKeys(gitlabHostUrl);
    }

    @Override
    public void enterGithubHostUrl(String githubHostUrl) {
        $x(GITHUB_HOST_URL_FIELD).shouldBe(Condition.visible).sendKeys(githubHostUrl);
    }

    @Override
    public void selectGitlabAccessApiToken(String gitlabAccessApiToken) {
        $x(GITLAB_ACCESS_API_TOKEN_DROPDOWN).shouldBe(Condition.visible).selectOptionByValue(gitlabAccessApiToken);
//        $x(GITLAB_ACCESS_API_TOKEN_DROPDOWN).shouldHave(Condition.exactValue(gitlabAccessApiToken));
    }

    @Override
    public void clickSaveButton() {
        $x(SAVE_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickAddGithubServerButton() {
        $x(GITHUB_SECTION).scrollTo();
        $x(ADD_GITHUB_SERVER_BUTTON).shouldHave(Condition.visible).hover().click();
//        $x(ADD_GITHUB_SERVER_BUTTON).shouldHave(Condition.exactText("Add GitHub Server"));
    }

    @Override
    public void clickGithubServerButton() {
        $x(GITHUB_SERVER_BUTTON).click();
    }

    @Override
    public void enterGithubConnectionName(String githubConnectionName) {
        $$x(GITHUB_CONNECTION_NAME_FIELD).filter(Condition.visible).first().setValue(githubConnectionName);
    }

    @Override
    public void selectGithubAccessApiToken(String githubAccessToken) {
        $x(GITHUB_ACCESS_API_TOKEN_DROPDOWN).shouldBe(Condition.visible).selectOptionByValue(githubAccessToken);
    }

    @Override
    public void openJobProvisionsFolder() {
        $x(JOB_PROVISIONS_FOLDER).shouldBe(Condition.visible).click();
    }

    @Override
    public void openCiFolder() {
        Selenide.sleep(1_000);
        $x(CI_FOLDER).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickNewItemButton() {
        Selenide.sleep(1_000);
        $x(NEW_ITEM_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void enterProvisionerName(String provisionerName) {
        $x(PROVISIONER_NAME_FIELD).shouldBe(Condition.visible).sendKeys(provisionerName);
    }

    @Override
    public void clickFreestyleProjectOption() {
        $x(FREESTILE_PROJECT_OPTION).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickCreateProvisionerButton() {
        $x(CREATE_PROVISIONER_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void enterBranchNameInLabelExpressionField(String branchName) {
        $x(LABEL_EXPRESSION_FIELD).shouldBe(Condition.visible).sendKeys(branchName);
    }

    @Override
    public void checkExecuteConcurrentBuildsIfNecessaryCheckbox() {
        $x(EXECUTE_CONCURRENT_BUILD_IF_NECESSARY_CHECKBOX).shouldBe(Condition.visible).click();
    }

    @Override
    public void checkThisProjectIsParameterizedCheckbox() {
        $x(THIS_PROJECT_IS_PARAMETERIZED_CHECKBOX).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickAddParameterButton() {
        $x(ADD_PARAMETER_BUTTON).scrollIntoView("{block: \"center\"}").shouldBe(Condition.visible).click();
    }

    @Override
    public void selectParametersType(String parametersType) {
        $$x(PARAMETERS_TYPE_DROPDOWN).findBy(Condition.text(parametersType)).click();
    }

    @Override
    public void enterParameterName(String parameterName) {
        $$x(PARAMETER_NAME_FIELD).filter(Condition.empty).first().sendKeys(parameterName);
    }

    @Override
    public void clickBuildTriggerButton() {
        $x(BUILD_TRIGGER_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickAddBuildStepButton() {
        $x(ADD_BUILD_STEP_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void selectBuildStep(String buildStep) {
        $$x(BUILD_STEP_DROPDOWN).findBy(Condition.text(buildStep)).click();
    }

    @Override
    public void clickSaveProvisionerButton() {
        $x(SAVE_PROVISIONER_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickUseTheProvidedDslScriptCheckbox() {
        $x(USE_THE_PROVIDED_DSL_SCRIPT_CHECKBOX).scrollIntoView("{block: \"center\"}").shouldBe(Condition.visible).click();
    }

    @Override
    public void clickSitJob() {
        Selenide.refresh();
        $x(SIT_JOB_BUTTON).waitUntil(Condition.visible, 15_000);
        Selenide.refresh();
        $x(SIT_JOB_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickBuildWithParametersButton() {
        $x(BUILD_WITH_PARAMETERS_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickBuildButton() {
        Selenide.sleep(1_000);
        $x(BUILD_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void selectApplicationVersionForDeploy(String applicationVersion) {
//        Selenide.sleep(15_000);
//        $x(INIT_STAGE_PROGRESS).shouldBe(Condition.visible).hover();

        $x(VERSION_FOR_DEPLOY_DROPDOWN).selectOptionContainingText(applicationVersion);
    }

    @Override
    public void clickProceedButtonInVersionInfoPopup() {
        $x(PROCEED_BUTTON_IN_VERSION_INFORMATION_POPUP).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickInputRequestedButton() {
        $x(INPUT_REQUESTED_BUTTON).waitUntil(Condition.visible, 100_000).scrollIntoView(false).click();
    }

    @Override
    public void clickProceedButtonToPromoteImage() {
        $x(PROSEED_TO_PROMOTE_BUTTON).waitUntil(Condition.visible, 200_000).scrollIntoView(false).click();
    }

    @Override
    public void openJobInfoPage() {
        waitForPageReadyState();
        waitForAjaxToComplete();
        $$x(JOB_INFO_PAGE).first().shouldBe(Condition.visible).click();
    }

    @Override
    public void clickProgressBar() {
        $x(PIPELINE_PROGRESS_BAR).shouldBe(Condition.visible).click();
    }

    @Override
    public void activateDslScriptWindow() {
        $$x(DSL_SCRIPT_WINDOW).filter(Condition.visible).last().click();
    }

    @Override
    public void enterProvisionerCode(String provisionerCode) {
//        $$x(PROVISIONER_CODE_INPUT).filter(Condition.visible).last().setValue(provisionerCode);
        SelenideElement element = $$x(CODE_INPUT).filter(Condition.visible).last().contextClick();
        Actions action = new Actions(WebDriverRunner.getWebDriver());
        action.click(element).sendKeys(element, "import groovy.json.*\n" +
                "import jenkins.model.Jenkins\n" +
                "\n" +
                "Jenkins jenkins = Jenkins.instance\n" +
                "def stages = [:]\n" +
                "def jiraIntegrationEnabled = Boolean.parseBoolean(\"${JIRA_INTEGRATION_ENABLED}\" as String)\n" +
                "def commitValidateStage = jiraIntegrationEnabled ? ',{\"name\": \"commit-validate\"}' : ''\n" +
                "def createJFVStage = jiraIntegrationEnabled ? ',{\"name\": \"create-jira-fix-version\"}' : ''\n" +
                "def platformType = \"${PLATFORM_TYPE}\"\n" +
                "def buildStage = platformType == \"kubernetes\" ? ',{\"name\": \"build-image-kaniko\"},' : ',{\"name\": \"build-image-from-dockerfile\"},'\n" +
                "\n" +
                "stages['Code-review-application-maven'] = '[{\"name\": \"checkout\"},{\"name\": \"compile\"},' +\n" +
                "    '{\"name\": \"tests\"}, {\"name\": \"sonar\"}]'\n" +
                "stages['Code-review-application-npm'] = stages['Code-review-application-maven']\n" +
                "stages['Code-review-application-gradle'] = stages['Code-review-application-maven']\n" +
                "stages['Code-review-application-dotnet'] = stages['Code-review-application-maven']\n" +
                "stages['Code-review-application-terraform'] = '[{\"name\": \"checkout\"},{\"name\": \"tool-init\"},{\"name\": \"lint\"}]'\n" +
                "stages['Code-review-application-helm'] = '[{\"name\": \"checkout\"},{\"name\": \"lint\"}]'\n" +
                "stages['Code-review-application-docker'] = '[{\"name\": \"checkout\"},{\"name\": \"lint\"}]'\n" +
                "stages['Code-review-application-go'] = '[{\"name\": \"checkout\"},{\"name\": \"build\"},' +\n" +
                "                                       '{\"name\": \"tests\"}, {\"name\": \"sonar\"}]'\n" +
                "stages['Code-review-application-python'] = '[{\"name\": \"checkout\"},{\"name\": \"compile\"},' +\n" +
                "                                       '{\"name\": \"tests\"}, {\"name\": \"sonar\"}]'\n" +
                "stages['Code-review-library'] = '[{\"name\": \"checkout\"},{\"name\": \"compile\"},{\"name\": \"tests\"},' +\n" +
                "        '{\"name\": \"sonar\"}]'\n" +
                "stages['Code-review-autotests-maven'] = '[{\"name\": \"checkout\"},{\"name\": \"tests\"},{\"name\": \"sonar\"}]'\n" +
                "stages['Build-library-maven'] = '[{\"name\": \"checkout\"},{\"name\": \"get-version\"},{\"name\": \"compile\"},' +\n" +
                "        '{\"name\": \"tests\"},{\"name\": \"sonar\"},{\"name\": \"build\"}' + \"${createJFVStage}\" + ',{\"name\": \"git-tag\"}]'\n" +
                "stages['Build-library-npm'] = stages['Build-library-maven']\n" +
                "stages['Build-library-gradle'] = stages['Build-library-maven']\n" +
                "stages['Build-library-dotnet'] = '[{\"name\": \"checkout\"},{\"name\": \"get-version\"},{\"name\": \"compile\"},' +\n" +
                "        '{\"name\": \"tests\"},{\"name\": \"sonar\"},{\"name\": \"push\"}' + \"${createJFVStage}\" + ',{\"name\": \"git-tag\"}]'\n" +
                "stages['Build-application-maven'] = '[{\"name\": \"checkout\"},{\"name\": \"get-version\"},{\"name\": \"compile\"},' +\n" +
                "        '{\"name\": \"tests\"},{\"name\": \"sonar\"},{\"name\": \"build\"}' + \"${buildStage}\" +\n" +
                "        '{\"name\": \"push\"}' + \"${createJFVStage}\" + ',{\"name\": \"git-tag\"}]'\n" +
                "stages['Build-application-python'] = '[{\"name\": \"checkout\"},{\"name\": \"get-version\"},{\"name\": \"compile\"},{\"name\": \"tests\"},{\"name\": \"sonar\"}' +\n" +
                "\"${buildStage}\" + '{\"name\":\"push\"}' + \"${createJFVStage}\" + ',{\"name\": \"git-tag\"}]'\n" +
                "stages['Build-application-npm'] = stages['Build-application-maven']\n" +
                "stages['Build-application-gradle'] = stages['Build-application-maven']\n" +
                "stages['Build-application-dotnet'] = '[{\"name\": \"checkout\"},{\"name\": \"get-version\"},{\"name\": \"compile\"},' +\n" +
                "        '{\"name\": \"tests\"},{\"name\": \"sonar\"}' + \"${buildStage}\" +\n" +
                "        '{\"name\": \"push\"}' + \"${createJFVStage}\" + ',{\"name\": \"git-tag\"}]'\n" +
                "stages['Build-application-terraform'] = '[{\"name\": \"checkout\"},{\"name\": \"tool-init\"},' +\n" +
                "        '{\"name\": \"lint\"},{\"name\": \"git-tag\"}]'\n" +
                "stages['Build-application-helm'] = '[{\"name\": \"checkout\"},{\"name\": \"lint\"}]'\n" +
                "stages['Build-application-docker'] = '[{\"name\": \"checkout\"},{\"name\": \"lint\"}]'\n" +
                "stages['Build-application-go'] = '[{\"name\": \"checkout\"},{\"name\": \"get-version\"},{\"name\": \"tests\"},{\"name\": \"sonar\"},' +\n" +
                "                                '{\"name\": \"build\"}' + \"${buildStage}\" + \"${createJFVStage}\" + '{\"name\": \"git-tag\"}]'\n" +
                "stages['Create-release'] = '[{\"name\": \"checkout\"},{\"name\": \"create-branch\"},{\"name\": \"trigger-job\"}]'\n" +
                "\n" +
                "\n" +
                "def codebaseName = \"${NAME}\"\n" +
                "def buildTool = \"${BUILD_TOOL}\"\n" +
                "def gitServerCrName = \"${GIT_SERVER_CR_NAME}\"\n" +
                "def gitServerCrVersion = \"${GIT_SERVER_CR_VERSION}\"\n" +
                "def gitServer = \"${GIT_SERVER ? GIT_SERVER : 'gerrit'}\"\n" +
                "def gitSshPort = \"${GIT_SSH_PORT ? GIT_SSH_PORT : '29418'}\"\n" +
                "def gitUsername = \"${GIT_USERNAME ? GIT_USERNAME : 'jenkins'}\"\n" +
                "def gitCredentialsId = \"${GIT_CREDENTIALS_ID ? GIT_CREDENTIALS_ID : 'gerrit-ciuser-sshkey'}\"\n" +
                "def defaultRepoPath = \"ssh://${gitUsername}@${gitServer}:${gitSshPort}/${codebaseName}\"\n" +
                "def repositoryPath = \"${REPOSITORY_PATH ? REPOSITORY_PATH : defaultRepoPath}\"\n" +
                "\n" +
                "def codebaseFolder = jenkins.getItem(codebaseName)\n" +
                "if (codebaseFolder == null) {\n" +
                "    folder(codebaseName)\n" +
                "}\n" +
                "\n" +
                "createListView(codebaseName, \"Releases\")\n" +
                "createReleasePipeline(\"Create-release-${codebaseName}\", codebaseName, stages[\"Create-release\"], \"create-release.groovy\",\n" +
                "        repositoryPath, gitCredentialsId, gitServerCrName, gitServerCrVersion, jiraIntegrationEnabled, platformType)\n" +
                "\n" +
                "if (BRANCH) {\n" +
                "    def branch = \"${BRANCH}\"\n" +
                "    def formattedBranch = \"${branch.toUpperCase().replaceAll(/\\\\//, \"-\")}\"\n" +
                "    createListView(codebaseName, formattedBranch)\n" +
                "\n" +
                "    def type = \"${TYPE}\"\n" +
                "    createCiPipeline(\"Code-review-${codebaseName}\", codebaseName, stages[\"Code-review-${type}-${buildTool.toLowerCase()}\"], \"code-review.groovy\",\n" +
                "            repositoryPath, gitCredentialsId, branch, gitServerCrName, gitServerCrVersion)\n" +
                "\n" +
                "    if (type.equalsIgnoreCase('application') || type.equalsIgnoreCase('library')) {\n" +
                "        def jobExists = false\n" +
                "        if(\"${formattedBranch}-Build-${codebaseName}\".toString() in Jenkins.instance.getAllItems().collect{it.name}) {\n" +
                "           jobExists = true\n" +
                "        }\n" +
                "        createCiPipeline(\"Build-${codebaseName}\", codebaseName, stages[\"Build-${type}-${buildTool.toLowerCase()}\"], \"build.groovy\",\n" +
                "                repositoryPath, gitCredentialsId, branch, gitServerCrName, gitServerCrVersion)\n" +
                "       if(!jobExists) {\n" +
                "         queue(\"${codebaseName}/${formattedBranch}-Build-${codebaseName}\")\n" +
                "       }\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "\n" +
                "def createCiPipeline(pipelineName, codebaseName, codebaseStages, pipelineScript, repository, credId, watchBranch = \"master\", gitServerCrName, gitServerCrVersion) {\n" +
                "def jobName = \"${watchBranch.toUpperCase().replaceAll(/\\\\//, \"-\")}-${pipelineName}\"\n" +
                "def existingJob = Jenkins.getInstance().getItemByFullName(\"${codebaseName}/${jobName}\")\n" +
                "def webhookToken = null\n" +
                "if (existingJob) {\n" +
                "    def triggersMap = existingJob.getTriggers()\n" +
                "    triggersMap.each { key, value ->\n" +
                "        webhookToken = value.getSecretToken()\n" +
                "    }\n" +
                "} else {\n" +
                "    def random = new byte[16]\n" +
                "    new java.security.SecureRandom().nextBytes(random)\n" +
                "    webhookToken = random.encodeHex().toString()\n" +
                "}\n" +
                "pipelineJob(\"${codebaseName}/${jobName}\") {\n" +
                "    logRotator {\n" +
                "        numToKeep(10)\n" +
                "        daysToKeep(7)\n" +
                "    }\n" +
                "    properties {\n" +
                "        gitLabConnection {\n" +
                "            gitLabConnection('git.epam.com')\n" +
                "        }\n" +
                "    }\n" +
                "    definition {\n" +
                "        cpsScm {\n" +
                "            scm {\n" +
                "                git {\n" +
                "                    remote {\n" +
                "                        url(repository)\n" +
                "                        credentials(credId)\n" +
                "                    }\n" +
                "                    branches(pipelineName.contains(\"Build\") ? \"${watchBranch}\" : \"\\${gitlabMergeRequestLastCommit}\")\n" +
                "                    scriptPath(\"${pipelineScript}\")\n" +
                "                }\n" +
                "            }\n" +
                "            parameters {\n" +
                "                stringParam(\"GIT_SERVER_CR_NAME\", \"${gitServerCrName}\", \"Name of Git Server CR to generate link to Git server\")\n" +
                "                stringParam(\"GIT_SERVER_CR_VERSION\", \"${gitServerCrVersion}\", \"Version of GitServer CR Resource\")\n" +
                "                stringParam(\"STAGES\", \"${codebaseStages}\", \"Consequence of stages in JSON format to be run during execution\")\n" +
                "                stringParam(\"GERRIT_PROJECT_NAME\", \"${codebaseName}\", \"Gerrit project name(Codebase name) to be build\")\n" +
                "                if (pipelineName.contains(\"Build\"))\n" +
                "                    stringParam(\"BRANCH\", \"${watchBranch}\", \"Branch to build artifact from\")\n" +
                "                else\n" +
                "                    stringParam(\"BRANCH\", \"\\${gitlabMergeRequestLastCommit}\", \"Branch to build artifact from\")\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "    triggers {\n" +
                "        gitlabPush {\n" +
                "            buildOnMergeRequestEvents(pipelineName.contains(\"Build\") ? false : true)\n" +
                "            buildOnPushEvents(pipelineName.contains(\"Build\") ? true : false)\n" +
                "            enableCiSkip(false)\n" +
                "            setBuildDescription(true)\n" +
                "            rebuildOpenMergeRequest(pipelineName.contains(\"Build\") ? 'never' : 'source')\n" +
                "            commentTrigger(\"Build it please\")\n" +
                "            skipWorkInProgressMergeRequest(true)\n" +
                "            targetBranchRegex(\"${watchBranch}\")\n" +
                "        }\n" +
                "    }\n" +
                "    configure {\n" +
                "        it / triggers / 'com.dabsquared.gitlabjenkins.GitLabPushTrigger' << secretToken(webhookToken)\n" +
                "        it / triggers / 'com.dabsquared.gitlabjenkins.GitLabPushTrigger' << triggerOnApprovedMergeRequest(pipelineName.contains(\"Build\") ? false : true)\n" +
                "        it / triggers / 'com.dabsquared.gitlabjenkins.GitLabPushTrigger' << pendingBuildName(pipelineName.contains(\"Build\") ? \"\" : \"Jenkins\")\n" +
                "    }\n" +
                "}\n" +
                "registerWebHook(repository, codebaseName, jobName, webhookToken)\n" +
                "}\n" +
                "\n" +
                "\n" +
                "def createReleasePipeline(pipelineName, codebaseName, codebaseStages, pipelineScript, repository, credId,\n" +
                "gitServerCrName, gitServerCrVersion, jiraIntegrationEnabled, platformType) {\n" +
                "    pipelineJob(\"${codebaseName}/${pipelineName}\") {\n" +
                "        logRotator {\n" +
                "            numToKeep(14)\n" +
                "            daysToKeep(30)\n" +
                "        }\n" +
                "        definition {\n" +
                "            cpsScm {\n" +
                "                scm {\n" +
                "                    git {\n" +
                "                        remote {\n" +
                "                            url(repository)\n" +
                "                            credentials(credId)\n" +
                "                        }\n" +
                "                        branches(\"master\")\n" +
                "                        scriptPath(\"${pipelineScript}\")\n" +
                "                    }\n" +
                "                }\n" +
                "                parameters {\n" +
                "                    stringParam(\"STAGES\", \"${codebaseStages}\", \"\")\n" +
                "                    if (pipelineName.contains(\"Create-release\")) {\n" +
                "                        stringParam(\"JIRA_INTEGRATION_ENABLED\", \"${jiraIntegrationEnabled}\", \"Is Jira integration enabled\")\n" +
                "                        stringParam(\"PLATFORM_TYPE\", \"${platformType}\", \"Platform type\")\n" +
                "                        stringParam(\"GERRIT_PROJECT\", \"${codebaseName}\", \"\")\n" +
                "                        stringParam(\"RELEASE_NAME\", \"\", \"Name of the release(branch to be created)\")\n" +
                "                        stringParam(\"COMMIT_ID\", \"\", \"Commit ID that will be used to create branch from for new release. If empty, HEAD of master will be used\")\n" +
                "                        stringParam(\"GIT_SERVER_CR_NAME\", \"${gitServerCrName}\", \"Name of Git Server CR to generate link to Git server\")\n" +
                "                        stringParam(\"GIT_SERVER_CR_VERSION\", \"${gitServerCrVersion}\", \"Version of GitServer CR Resource\")\n" +
                "                        stringParam(\"REPOSITORY_PATH\", \"${repository}\", \"Full repository path\")\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "def createListView(codebaseName, branchName) {\n" +
                "    listView(\"${codebaseName}/${branchName}\") {\n" +
                "        if (branchName.toLowerCase() == \"releases\") {\n" +
                "            jobFilters {\n" +
                "                regex {\n" +
                "                    matchType(MatchType.INCLUDE_MATCHED)\n" +
                "                    matchValue(RegexMatchValue.NAME)\n" +
                "                    regex(\"^Create-release.*\")\n" +
                "                }\n" +
                "            }\n" +
                "        } else {\n" +
                "            jobFilters {\n" +
                "                regex {\n" +
                "                    matchType(MatchType.INCLUDE_MATCHED)\n" +
                "                    matchValue(RegexMatchValue.NAME)\n" +
                "                    regex(\"^${branchName}-(Code-review|Build).*\")\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        columns {\n" +
                "            status()\n" +
                "            weather()\n" +
                "            name()\n" +
                "            lastSuccess()\n" +
                "            lastFailure()\n" +
                "            lastDuration()\n" +
                "            buildButton()\n" +
                "        }\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "def registerWebHook(repositoryPath, codebaseName, jobName, webhookToken) {\n" +
                "    def apiUrl = 'https://' + repositoryPath.replaceAll(\"ssh://\", \"\").split('@')[1].replace('/', \"%2F\").replaceAll(~/:\\d+%2F/, '/api/v4/projects/') + '/hooks'\n" +
                "    def jobWebhookUrl = \"${System.getenv('JENKINS_UI_URL')}/project/${codebaseName}/${jobName}\"\n" +
                "    def gitlabToken = getSecretValue('gitlab-access-token')\n" +
                "\n" +
                "    if (checkWebHookExist(apiUrl, jobWebhookUrl, gitlabToken)) {\n" +
                "        println(\"[JENKINS][DEBUG] Webhook for job ${jobName} is already exist\\r\\n\")\n" +
                "        return\n" +
                "    }\n" +
                "\n" +
                "    println(\"[JENKINS][DEBUG] Creating webhook for job ${jobName}\")\n" +
                "    def webhookConfig = [:]\n" +
                "    webhookConfig[\"url\"] = jobWebhookUrl\n" +
                "    webhookConfig[\"push_events\"] = jobName.contains(\"Build\") ? \"true\" : \"false\"\n" +
                "    webhookConfig[\"merge_requests_events\"] = jobName.contains(\"Build\") ? \"false\" : \"true\"\n" +
                "    webhookConfig[\"issues_events\"] = \"false\"\n" +
                "    webhookConfig[\"confidential_issues_events\"] = \"false\"\n" +
                "    webhookConfig[\"tag_push_events\"] = \"false\"\n" +
                "    webhookConfig[\"note_events\"] = \"true\"\n" +
                "    webhookConfig[\"job_events\"] = \"false\"\n" +
                "    webhookConfig[\"pipeline_events\"] = \"false\"\n" +
                "    webhookConfig[\"wiki_page_events\"] = \"false\"\n" +
                "    webhookConfig[\"enable_ssl_verification\"] = \"true\"\n" +
                "    webhookConfig[\"token\"] = webhookToken\n" +
                "    def requestBody = JsonOutput.toJson(webhookConfig)\n" +
                "    def httpConnector = new URL(apiUrl).openConnection() as HttpURLConnection\n" +
                "    httpConnector.setRequestMethod('POST')\n" +
                "    httpConnector.setDoOutput(true)\n" +
                "\n" +
                "    httpConnector.setRequestProperty(\"Accept\", 'application/json')\n" +
                "    httpConnector.setRequestProperty(\"Content-Type\", 'application/json')\n" +
                "    httpConnector.setRequestProperty(\"PRIVATE-TOKEN\", \"${gitlabToken}\")\n" +
                "    httpConnector.outputStream.write(requestBody.getBytes(\"UTF-8\"))\n" +
                "    httpConnector.connect()\n" +
                "\n" +
                "    if (httpConnector.responseCode == 201)\n" +
                "        println(\"[JENKINS][DEBUG] Webhook for job ${jobName} has been created\\r\\n\")\n" +
                "    else {\n" +
                "        println(\"[JENKINS][ERROR] Responce code - ${httpConnector.responseCode}\")\n" +
                "        def response = new JsonSlurper().parseText(httpConnector.errorStream.getText('UTF-8'))\n" +
                "        println(\"[JENKINS][ERROR] Failed to create webhook for job ${jobName}. Response - ${response}\")\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "def checkWebHookExist(apiUrl, jobWebhookUrl, gitlabToken) {\n" +
                "    println(\"[JENKINS][DEBUG] Checking if webhook ${jobWebhookUrl} exists\")\n" +
                "    def httpConnector = new URL(apiUrl).openConnection() as HttpURLConnection\n" +
                "    httpConnector.setRequestMethod('GET')\n" +
                "    httpConnector.setDoOutput(true)\n" +
                "\n" +
                "    httpConnector.setRequestProperty(\"Accept\", 'application/json')\n" +
                "    httpConnector.setRequestProperty(\"Content-Type\", 'application/json')\n" +
                "    httpConnector.setRequestProperty(\"PRIVATE-TOKEN\", \"${gitlabToken}\")\n" +
                "    httpConnector.connect()\n" +
                "\n" +
                "    if (httpConnector.responseCode == 200) {\n" +
                "        def response = new JsonSlurper().parseText(httpConnector.inputStream.getText('UTF-8'))\n" +
                "        return response.find { it.url == jobWebhookUrl } ? true : false\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "def getSecretValue(name) {\n" +
                "    def creds = com.cloudbees.plugins.credentials.CredentialsProvider.lookupCredentials(\n" +
                "            com.cloudbees.plugins.credentials.common.StandardCredentials.class,\n" +
                "            Jenkins.instance,\n" +
                "            null,\n" +
                "            null\n" +
                "    )\n" +
                "\n" +
                "    def secret = creds.find { it.properties['id'] == name }\n" +
                "    return secret != null ? secret.getApiToken() : null\n" +
                "}").build().perform();

    }

    @Override
    public void enterGitHubProvisionerCode(String gitHubProvisionerCode) {
        SelenideElement element = $$x(GITHUB_CODE_INPUT).filter(Condition.visible).last().contextClick();
        Actions action = new Actions(WebDriverRunner.getWebDriver());
        action.click(element).sendKeys(element, "import groovy.json.*\n" +
                "import jenkins.model.Jenkins\n" +
                "import javaposse.jobdsl.plugin.*\n" +
                "import com.cloudbees.hudson.plugins.folder.*\n" +
                "\n" +
                "Jenkins jenkins = Jenkins.instance\n" +
                "def stages = [:]\n" +
                "def jiraIntegrationEnabled = Boolean.parseBoolean(\"${JIRA_INTEGRATION_ENABLED}\" as String)\n" +
                "def commitValidateStage = jiraIntegrationEnabled ? ',{\"name\": \"commit-validate\"}' : ''\n" +
                "def createJFVStage = jiraIntegrationEnabled ? ',{\"name\": \"create-jira-fix-version\"}' : ''\n" +
                "def platformType = \"${PLATFORM_TYPE}\"\n" +
                "def buildStage = platformType == \"kubernetes\" ? ',{\"name\": \"build-image-kaniko\"},' : ',{\"name\": \"build-image-from-dockerfile\"},'\n" +
                "def buildTool = \"${BUILD_TOOL}\"\n" +
                "def goBuildStage = buildTool.toString() == \"go\" ? ',{\"name\": \"build\"}' : ',{\"name\": \"compile\"}'\n" +
                "\n" +
                "stages['Code-review-application'] = '[{\"name\": \"checkout\"}' + \"${commitValidateStage}\" + goBuildStage +\n" +
                "                                     ',{\"name\": \"tests\"},{\"name\": \"sonar\"}]'\n" +
                "stages['Code-review-library'] = '[{\"name\": \"checkout\"}' + \"${commitValidateStage}\" + ',{\"name\": \"compile\"},{\"name\": \"tests\"},' +\n" +
                "        '{\"name\": \"sonar\"}]'\n" +
                "stages['Code-review-autotests'] = '[{\"name\": \"checkout\"}' + \"${commitValidateStage}\" + ',{\"name\": \"tests\"},{\"name\": \"sonar\"}]'\n" +
                "stages['Build-library-maven'] = '[{\"name\": \"checkout\"},{\"name\": \"get-version\"},{\"name\": \"compile\"},' +\n" +
                "        '{\"name\": \"tests\"},{\"name\": \"sonar\"},{\"name\": \"build\"},{\"name\": \"push\"},{\"name\": \"git-tag\"}]'\n" +
                "stages['Build-library-npm'] = stages['Build-library-maven']\n" +
                "stages['Build-library-gradle'] = stages['Build-library-maven']\n" +
                "stages['Build-library-dotnet'] = '[{\"name\": \"checkout\"},{\"name\": \"get-version\"},{\"name\": \"compile\"},' +\n" +
                "        '{\"name\": \"tests\"},{\"name\": \"sonar\"},{\"name\": \"push\"}' + \"${createJFVStage}\" + ',{\"name\": \"git-tag\"}]'\n" +
                "\n" +
                "stages['Build-application-maven'] = '[{\"name\": \"checkout\"},{\"name\": \"get-version\"},{\"name\": \"compile\"},' +\n" +
                "        '{\"name\": \"tests\"},{\"name\": \"sonar\"},{\"name\": \"build\"}' + \"${buildStage}\" +\n" +
                "        '{\"name\": \"push\"}' + \"${createJFVStage}\" + ',{\"name\": \"git-tag\"}]'\n" +
                "stages['Build-application-npm'] = stages['Build-application-maven']\n" +
                "stages['Build-application-gradle'] = stages['Build-application-maven']\n" +
                "stages['Build-application-dotnet'] = '[{\"name\": \"checkout\"},{\"name\": \"get-version\"},{\"name\": \"compile\"},' +\n" +
                "        '{\"name\": \"tests\"},{\"name\": \"sonar\"}' + \"${buildStage}\" +\n" +
                "        '{\"name\": \"push\"}' + \"${createJFVStage}\" + ',{\"name\": \"git-tag\"}]'\n" +
                "stages['Build-application-go'] = '[{\"name\": \"checkout\"},{\"name\": \"get-version\"},{\"name\": \"tests\"},{\"name\": \"sonar\"},' +\n" +
                "                                    '{\"name\": \"build\"}' + \"${buildStage}\" + \"${createJFVStage}\" + ',{\"name\": \"git-tag\"}]'\n" +
                "stages['Build-application-python'] = '[{\"name\": \"checkout\"},{\"name\": \"get-version\"},{\"name\": \"compile\"},{\"name\": \"tests\"},{\"name\": \"sonar\"}' +\n" +
                "                                    \"${buildStage}\" + '{\"name\":\"push\"}' + \"${createJFVStage}\" + ',{\"name\": \"git-tag\"}]'\n" +
                "stages['Create-release'] = '[{\"name\": \"checkout\"},{\"name\": \"create-branch\"},{\"name\": \"trigger-job\"}]'\n" +
                "\n" +
                "def buildToolsOutOfTheBox = [\"maven\",\"npm\",\"gradle\",\"dotnet\",\"none\",\"go\",\"python\"]\n" +
                "def defaultStages = '[{\"name\": \"checkout\"}]'\n" +
                "\n" +
                "def codebaseName = \"${NAME}\"\n" +
                "def gitServerCrName = \"${GIT_SERVER_CR_NAME}\"\n" +
                "def gitServerCrVersion = \"${GIT_SERVER_CR_VERSION}\"\n" +
                "def gitCredentialsId = \"${GIT_CREDENTIALS_ID ? GIT_CREDENTIALS_ID : 'gerrit-ciuser-sshkey'}\"\n" +
                "def repositoryPath = \"${REPOSITORY_PATH.replaceAll(~/:\\d+\\\\//,\"/\")}\"\n" +
                "def githubRepository = \"https://${repositoryPath.split(\"@\")[1]}\"\n" +
                "\n" +
                "def codebaseFolder = jenkins.getItem(codebaseName)\n" +
                "if (codebaseFolder == null) {\n" +
                "    folder(codebaseName)\n" +
                "}\n" +
                "\n" +
                "createListView(codebaseName, \"Releases\")\n" +
                "createReleasePipeline(\"Create-release-${codebaseName}\", codebaseName, stages[\"Create-release\"], \"create-release.groovy\",\n" +
                "        repositoryPath, gitCredentialsId, gitServerCrName, gitServerCrVersion, jiraIntegrationEnabled, platformType)\n" +
                "\n" +
                "if (buildTool.toString().equalsIgnoreCase('none')) {\n" +
                "    return true\n" +
                "}\n" +
                "\n" +
                "if (BRANCH) {\n" +
                "    def branch = \"${BRANCH}\"\n" +
                "    def formattedBranch = \"${branch.toUpperCase().replaceAll(/\\\\//, \"-\")}\"\n" +
                "    createListView(codebaseName, formattedBranch)\n" +
                "\n" +
                "    def type = \"${TYPE}\"\n" +
                "\tdef supBuildTool = buildToolsOutOfTheBox.contains(buildTool.toString())\n" +
                "    def crKey = \"Code-review-${type}\".toString()\n" +
                "    createCodeReviewPipeline(\"Code-review-${codebaseName}\", codebaseName, stages.get(crKey, defaultStages), \"code-review.groovy\",\n" +
                "            repositoryPath, gitCredentialsId, branch, gitServerCrName, gitServerCrVersion, githubRepository)\n" +
                "    registerWebHook(repositoryPath)\n" +
                "\n" +
                "\n" +
                "\tdef buildKey = \"Build-${type}-${buildTool.toLowerCase()}\".toString()\n" +
                "\n" +
                "    if (type.equalsIgnoreCase('application') || type.equalsIgnoreCase('library')) {\n" +
                "\t\tdef jobExists = false\n" +
                "\t\tif(\"${formattedBranch}-Build-${codebaseName}\".toString() in Jenkins.instance.getAllItems().collect{it.name})\n" +
                "            jobExists = true\n" +
                "        createBuildPipeline(\"Build-${codebaseName}\", codebaseName, stages.get(buildKey, defaultStages), \"build.groovy\",\n" +
                "                repositoryPath, gitCredentialsId, branch, gitServerCrName, gitServerCrVersion, githubRepository)\n" +
                "        registerWebHook(repositoryPath, 'build')\n" +
                "\n" +
                "\t\tif(!jobExists)\n" +
                "          queue(\"${codebaseName}/${formattedBranch}-Build-${codebaseName}\")\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "def createCodeReviewPipeline(pipelineName, codebaseName, codebaseStages, pipelineScript, repository, credId, watchBranch = \"master\", gitServerCrName, gitServerCrVersion, githubRepository) {\n" +
                "    pipelineJob(\"${codebaseName}/${watchBranch.toUpperCase().replaceAll(/\\\\//, \"-\")}-${pipelineName}\") {\n" +
                "        logRotator {\n" +
                "            numToKeep(10)\n" +
                "            daysToKeep(7)\n" +
                "        }\n" +
                "        definition {\n" +
                "            cpsScm {\n" +
                "                scm {\n" +
                "                    git {\n" +
                "                        remote {\n" +
                "                            url(repository)\n" +
                "                            credentials(credId)\n" +
                "                            refspec(\"+refs/pull/*:refs/remotes/origin/pr/*\")\n" +
                "                        }\n" +
                "                        branches(\"\\${ghprbActualCommit}\")\n" +
                "                        scriptPath(\"${pipelineScript}\")\n" +
                "                    }\n" +
                "                }\n" +
                "                parameters {\n" +
                "                    stringParam(\"GIT_SERVER_CR_NAME\", \"${gitServerCrName}\", \"Name of Git Server CR to generate link to Git server\")\n" +
                "                    stringParam(\"GIT_SERVER_CR_VERSION\", \"${gitServerCrVersion}\", \"Version of GitServer CR Resource\")\n" +
                "                    stringParam(\"STAGES\", \"${codebaseStages}\", \"Consequence of stages in JSON format to be run during execution\")\n" +
                "                    stringParam(\"GERRIT_PROJECT_NAME\", \"${codebaseName}\", \"Gerrit project name(Codebase name) to be build\")\n" +
                "                    stringParam(\"BRANCH\", \"${watchBranch}\", \"Branch to build artifact from\")\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        triggers {\n" +
                "            githubPullRequest {\n" +
                "                cron('')\n" +
                "                onlyTriggerPhrase(false)\n" +
                "                useGitHubHooks(true)\n" +
                "                permitAll(true)\n" +
                "                autoCloseFailedPullRequests(false)\n" +
                "                displayBuildErrorsOnDownstreamBuilds(false)\n" +
                "                whiteListTargetBranches([watchBranch.toString()])\n" +
                "                extensions {\n" +
                "                    commitStatus {\n" +
                "                        context('Jenkins Code-Review')\n" +
                "                        triggeredStatus('Build is Triggered')\n" +
                "                        startedStatus('Build is Started')\n" +
                "                        addTestResults(true)\n" +
                "                        completedStatus('SUCCESS', 'Verified')\n" +
                "                        completedStatus('FAILURE', 'Failed')\n" +
                "                        completedStatus('PENDING', 'Penging')\n" +
                "                        completedStatus('ERROR', 'Error')\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        properties {\n" +
                "            githubProjectProperty {\n" +
                "                projectUrlStr(\"${githubRepository}\")\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "def createBuildPipeline(pipelineName, codebaseName, codebaseStages, pipelineScript, repository, credId, watchBranch = \"master\", gitServerCrName, gitServerCrVersion, githubRepository) {\n" +
                "    pipelineJob(\"${codebaseName}/${watchBranch.toUpperCase().replaceAll(/\\\\//, \"-\")}-${pipelineName}\") {\n" +
                "        logRotator {\n" +
                "            numToKeep(10)\n" +
                "            daysToKeep(7)\n" +
                "        }\n" +
                "        definition {\n" +
                "            cpsScm {\n" +
                "                scm {\n" +
                "                    git {\n" +
                "                        remote {\n" +
                "                            url(repository)\n" +
                "                            credentials(credId)\n" +
                "                        }\n" +
                "                        branches(\"${watchBranch}\")\n" +
                "                        scriptPath(\"${pipelineScript}\")\n" +
                "                    }\n" +
                "                }\n" +
                "                parameters {\n" +
                "                    stringParam(\"GIT_SERVER_CR_NAME\", \"${gitServerCrName}\", \"Name of Git Server CR to generate link to Git server\")\n" +
                "                    stringParam(\"GIT_SERVER_CR_VERSION\", \"${gitServerCrVersion}\", \"Version of GitServer CR Resource\")\n" +
                "                    stringParam(\"STAGES\", \"${codebaseStages}\", \"Consequence of stages in JSON format to be run during execution\")\n" +
                "                    stringParam(\"GERRIT_PROJECT_NAME\", \"${codebaseName}\", \"Gerrit project name(Codebase name) to be build\")\n" +
                "                    stringParam(\"BRANCH\", \"${watchBranch}\", \"Branch to run from\")\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        triggers {\n" +
                "            gitHubPushTrigger()\n" +
                "        }\n" +
                "        properties {\n" +
                "            githubProjectProperty {\n" +
                "                projectUrlStr(\"${githubRepository}\")\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "\n" +
                "def createListView(codebaseName, branchName) {\n" +
                "    listView(\"${codebaseName}/${branchName}\") {\n" +
                "        if (branchName.toLowerCase() == \"releases\") {\n" +
                "            jobFilters {\n" +
                "                regex {\n" +
                "                    matchType(MatchType.INCLUDE_MATCHED)\n" +
                "                    matchValue(RegexMatchValue.NAME)\n" +
                "                    regex(\"^Create-release.*\")\n" +
                "                }\n" +
                "            }\n" +
                "        } else {\n" +
                "            jobFilters {\n" +
                "                regex {\n" +
                "                    matchType(MatchType.INCLUDE_MATCHED)\n" +
                "                    matchValue(RegexMatchValue.NAME)\n" +
                "                    regex(\"^${branchName}-(Code-review|Build).*\")\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        columns {\n" +
                "            status()\n" +
                "            weather()\n" +
                "            name()\n" +
                "            lastSuccess()\n" +
                "            lastFailure()\n" +
                "            lastDuration()\n" +
                "            buildButton()\n" +
                "        }\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "def createReleasePipeline(pipelineName, codebaseName, codebaseStages, pipelineScript, repository, credId,\n" +
                " gitServerCrName, gitServerCrVersion, jiraIntegrationEnabled, platformType) {\n" +
                "    pipelineJob(\"${codebaseName}/${pipelineName}\") {\n" +
                "        logRotator {\n" +
                "            numToKeep(14)\n" +
                "            daysToKeep(30)\n" +
                "        }\n" +
                "        definition {\n" +
                "            cpsScm {\n" +
                "                scm {\n" +
                "                    git {\n" +
                "                        remote {\n" +
                "                            url(repository)\n" +
                "                            credentials(credId)\n" +
                "                        }\n" +
                "                        branches(\"master\")\n" +
                "                        scriptPath(\"${pipelineScript}\")\n" +
                "                    }\n" +
                "                }\n" +
                "                parameters {\n" +
                "                    stringParam(\"STAGES\", \"${codebaseStages}\", \"\")\n" +
                "                    if (pipelineName.contains(\"Create-release\")) {\n" +
                "                        stringParam(\"JIRA_INTEGRATION_ENABLED\", \"${jiraIntegrationEnabled}\", \"Is Jira integration enabled\")\n" +
                "                        stringParam(\"PLATFORM_TYPE\", \"${platformType}\", \"Platform type\")\n" +
                "                        stringParam(\"GERRIT_PROJECT\", \"${codebaseName}\", \"\")\n" +
                "                        stringParam(\"RELEASE_NAME\", \"\", \"Name of the release(branch to be created)\")\n" +
                "                        stringParam(\"COMMIT_ID\", \"\", \"Commit ID that will be used to create branch from for new release. If empty, HEAD of master will be used\")\n" +
                "                        stringParam(\"GIT_SERVER_CR_NAME\", \"${gitServerCrName}\", \"Name of Git Server CR to generate link to Git server\")\n" +
                "                        stringParam(\"GIT_SERVER_CR_VERSION\", \"${gitServerCrVersion}\", \"Version of GitServer CR Resource\")\n" +
                "                        stringParam(\"REPOSITORY_PATH\", \"${repository}\", \"Full repository path\")\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "def registerWebHook(repositoryPath, type = 'code-review') {\n" +
                "    def url = repositoryPath.split('@')[1].split('/')[0]\n" +
                "    def owner = repositoryPath.split('@')[1].split('/')[1]\n" +
                "    def repo = repositoryPath.split('@')[1].split('/')[2]\n" +
                "    def apiUrl = 'https://api.' + url + '/repos/' + owner + '/' + repo + '/hooks'\n" +
                "    def webhookUrl = ''\n" +
                "    def webhookConfig = [:]\n" +
                "    def config = [:]\n" +
                "    def events = []\n" +
                "\n" +
                "    if (type.equalsIgnoreCase('build')) {\n" +
                "        webhookUrl = System.getenv('JENKINS_UI_URL') + \"/github-webhook/\"\n" +
                "        events = [\"push\"]\n" +
                "        config[\"url\"] = webhookUrl\n" +
                "        config[\"content_type\"] = \"json\"\n" +
                "        config[\"insecure_ssl\"] = 0\n" +
                "        webhookConfig[\"name\"] = \"web\"\n" +
                "        webhookConfig[\"config\"] = config\n" +
                "        webhookConfig[\"events\"] = events\n" +
                "        webhookConfig[\"active\"] = true\n" +
                "\n" +
                "    } else {\n" +
                "        webhookUrl = System.getenv('JENKINS_UI_URL') + \"/ghprbhook/\"\n" +
                "        events = [\"issue_comment\",\"pull_request\"]\n" +
                "        config[\"url\"] = webhookUrl\n" +
                "        config[\"content_type\"] = \"form\"\n" +
                "        config[\"insecure_ssl\"] = 0\n" +
                "        webhookConfig[\"name\"] = \"web\"\n" +
                "        webhookConfig[\"config\"] = config\n" +
                "        webhookConfig[\"events\"] = events\n" +
                "        webhookConfig[\"active\"] = true\n" +
                "    }\n" +
                "\n" +
                "    def requestBody = JsonOutput.toJson(webhookConfig)\n" +
                "    def http = new URL(apiUrl).openConnection() as HttpURLConnection\n" +
                "    http.setRequestMethod('POST')\n" +
                "    http.setDoOutput(true)\n" +
                "    println(apiUrl)\n" +
                "    http.setRequestProperty(\"Accept\", 'application/json')\n" +
                "    http.setRequestProperty(\"Content-Type\", 'application/json')\n" +
                "    http.setRequestProperty(\"Authorization\", \"token ${getSecretValue('github-access-token')}\")\n" +
                "    http.outputStream.write(requestBody.getBytes(\"UTF-8\"))\n" +
                "    http.connect()\n" +
                "    println(http.responseCode)\n" +
                "\n" +
                "    if (http.responseCode == 201) {\n" +
                "        response = new JsonSlurper().parseText(http.inputStream.getText('UTF-8'))\n" +
                "    } else {\n" +
                "        response = new JsonSlurper().parseText(http.errorStream.getText('UTF-8'))\n" +
                "    }\n" +
                "\n" +
                "    println \"response: ${response}\"\n" +
                "}\n" +
                "\n" +
                "def getSecretValue(name) {\n" +
                "    def creds = com.cloudbees.plugins.credentials.CredentialsProvider.lookupCredentials(\n" +
                "            com.cloudbees.plugins.credentials.common.StandardCredentials.class,\n" +
                "            Jenkins.instance,\n" +
                "            null,\n" +
                "            null\n" +
                "    )\n" +
                "\n" +
                "    def secret = creds.find { it.properties['id'] == name }\n" +
                "    return secret != null ? secret['secret'] : null\n" +
                "}").build().perform();

    }
}
