package edp.pageobject.pages.impl;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import edp.core.annotations.Page;
import edp.pageobject.pages.interfaces.IJenkins;
import edp.utils.wait.FlexWait;
import io.vavr.control.Try;
import org.openqa.selenium.interactions.Actions;
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

public class Jenkins implements IJenkins {

    private static final String CODEBASE_JENKINS_FOLDER = "//td[not(@class)]//a[contains(@href, '%s')]";
    private static final String CD_PIPELINE_OVERVIEW = "//a[contains(text(), '%s')]";
    private static final String PLUGIN_INSTALL = "//tr[@id='row1']";
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
    private static final String MANAGE_PLUGINS_BUTTON = "//div[@class='manage-option manage-page__column']//a[@title='Manage Plugins']";
    private static final String AVAILABLE_PLUGINS_BUTTON = "//a[contains(text(),'Available')]";
    private static final String PLUGIN_SEARCH_FIELD = "//input[@id='filter-box']";
    private static final String GITHUB_PULL_REQUEST_BUILDER_CHECKBOX = "//input[@name='plugin.ghprb.default']";
    private static final String INSTALL_WITHOUT_RESTART_BUTTON = "//button[text()='Install without restart']";
    private static final String GITLAB_CONNECTION_NAME_FIELD = "//input[@checkurl='/descriptorByName/com.dabsquared.gitlabjenkins.connection.GitLabConnectionConfig/checkName']";
    private static final String GITLAB_HOST_URL_FIELD = "//input[@checkurl='/descriptorByName/com.dabsquared.gitlabjenkins.connection.GitLabConnectionConfig/checkUrl']";
    private static final String GITHUB_HOST_URL_FIELD = "//input[@checkurl='/descriptorByName/com.dabsquared.gitlabjenkins.connection.GitLabConnectionConfig/checkUrl']";
    private static final String GITLAB_ACCESS_API_TOKEN_DROPDOWN = "//select[contains(@name, '_.apiTokenId')]";
    private static final String SAVE_BUTTON = "//button[text()='Save']";
    private static final String GITHUB_SECTION = "//div[text()='GitHub']";
    private static final String ADD_GITHUB_SERVER_BUTTON = "//button[text()='Add GitHub Server']";
    private static final String GITHUB_SERVER_BUTTON = "//li[@class='yuimenuitem first-of-type yui-button-selectedmenuitem']";
    private static final String GITHUB_CONNECTION_NAME_FIELD = "//tr[@class='has-help']//input[@name='_.name']";
    private static final String GITHUB_ACCESS_API_TOKEN_DROPDOWN = "//select[contains(@fillurl,'config.GitHubServerConfig')]";
    private static final String GITHUB_PULL_REQUEST_SECTION = "//div[text()='GitHub Pull Request Builder']";
    private static final String GITHUB_ACCESS_TOKEN_GHPRB = "//select[contains(@fillurl,'/descriptorByName/org.jenkinsci.plugins.ghprb.GhprbGitHubAuth/fillCredentialsIdItems')]";
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
    private static final String PARAMETERS_TYPE_DROPDOWN = "//ul[@class='first-of-type']//li[@id='yui-gen103']//a[text()='String Parameter']";
    private static final String PARAMETER_NAME_FIELD = "//input[@name='parameter.name']";
    private static final String BUILD_TRIGGER_BUTTON = "//div[contains(@class, 'config_build_triggers')]";
    private static final String ADD_BUILD_STEP_BUTTON = "//button[text()='Add build step']";
    private static final String BUILD_STEP_DROPDOWN = "//ul[@class='first-of-type']//a[text()='Process Job DSLs']";
    private static final String SAVE_PROVISIONER_BUTTON = "//button[@id='yui-gen87-button']";
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
    public void pluginInstallationStatusShouldBeActive(String pluginName) {
        Predicate<SelenideElement> checkStatus = status -> {
            $x(String.format(PLUGIN_INSTALL, pluginName)).shouldBe(Condition.visible);
            Selenide.refresh();
            return Try.of(() -> $x(String.format(PLUGIN_INSTALL, pluginName)).shouldHave(Condition.attribute("class", " icon-blue icon-md"))).isSuccess();
        };
        new FlexWait<SelenideElement>(String.format("wait for success status for %s plugin", pluginName))
                .during(20000).tryTo(checkStatus).every(5000).executeWithoutResult();
    }

    @Override
    public void createReleaseStatusShouldBeSuccess(String createReleaseJob) {
        Predicate<SelenideElement> checkStatus = status -> {
            $x(String.format(CREATE_RELEASE_JOB, createReleaseJob)).shouldBe(Condition.visible);
            Selenide.refresh();
            return Try.of(() -> $x(String.format(CREATE_RELEASE_JOB, createReleaseJob)).shouldHave(Condition.attribute("class", " job-status-blue"))).isSuccess();
        };
        new FlexWait<SelenideElement>(String.format("wait for success status for %s create release job", createReleaseJob))
                .during(200000).tryTo(checkStatus).every(5000).executeWithoutResult();
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
        new FlexWait<SelenideElement>(String.format("wait for success status for %s cd pipeline stage", cdPipelineStage))
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
        Selenide.sleep(5_000);
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
    public void clickManagePluginsButton() {
        $x(MANAGE_PLUGINS_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickAvailableButton() {
        $x(AVAILABLE_PLUGINS_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void enterPluginNameInSearchField(String pluginName) {
        waitForPageReadyState();
        waitForAjaxToComplete();
        Selenide.sleep(2_000);
        $x(PLUGIN_SEARCH_FIELD).shouldBe(Condition.visible).sendKeys(pluginName);
    }

    @Override
    public void checkGitHubPullRequestBuilderCheckbox() {
        waitForPageReadyState();
        waitForAjaxToComplete();
        Selenide.sleep(1_000);
        $x(GITHUB_PULL_REQUEST_BUILDER_CHECKBOX).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickInstallWithoutRestartButton() {
        waitForPageReadyState();
        waitForAjaxToComplete();
        $x(INSTALL_WITHOUT_RESTART_BUTTON).shouldBe(Condition.visible).click();
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
        Selenide.sleep(1000);
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
        $x(GITHUB_SECTION).scrollIntoView("{block: \"center\"}");
        $x(ADD_GITHUB_SERVER_BUTTON).shouldBe(Condition.visible).hover().click();
//        $x(ADD_GITHUB_SERVER_BUTTON).shouldHave(Condition.exactText("Add GitHub Server"));
    }

    @Override
    public void clickGithubServerButton() {
        Selenide.sleep(1000);
        $x(GITHUB_SERVER_BUTTON).click();
    }

    @Override
    public void enterGithubConnectionName(String githubConnectionName) {
        waitForPageReadyState();
        waitForAjaxToComplete();
        Selenide.sleep(1_000);
        $$x(GITHUB_CONNECTION_NAME_FIELD).filter(Condition.visible).first().setValue(githubConnectionName);
    }

    @Override
    public void selectGithubAccessApiToken(String githubAccessToken) {
        $x(GITHUB_ACCESS_API_TOKEN_DROPDOWN).shouldBe(Condition.visible).selectOptionByValue(githubAccessToken);
    }

    @Override
    public void selectsTokenForPullRequestBuilder(String githubAccessApiToken) {
        $x(GITHUB_PULL_REQUEST_SECTION).scrollIntoView("{block: \"center\"}");
        $x(GITHUB_ACCESS_TOKEN_GHPRB).shouldBe(Condition.visible).selectOptionByValue(githubAccessApiToken);
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
        SelenideElement element = $$x(CODE_INPUT).filter(Condition.visible).last().doubleClick();
        Actions action = new Actions(WebDriverRunner.getWebDriver());
        action.sendKeys(element, provisionerCode).perform();
    }

    @Override
    public void enterGitHubProvisionerCode(String gitHubProvisionerCode) {
        SelenideElement element = $$x(CODE_INPUT).filter(Condition.visible).last().doubleClick();
        Actions action = new Actions(WebDriverRunner.getWebDriver());
        action.sendKeys(element, gitHubProvisionerCode).perform();

    }
}
