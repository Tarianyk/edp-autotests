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
    private static final String CREATE_RELEASE_JOB = "//tr[@id='job_%s']";
    private static final String BUILD_JOB = "//tr[@id='job_%s']";
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
    private static final String PARAMETERS_TYPE_DROPDOWN = "//ul[@class='first-of-type']";
    private static final String PARAMETER_NAME_FIELD = "//input[@name='_.name']";
    private static final String BUILD_TRIGGER_BUTTON = "//div[contains(@class, 'config_build_triggers')]";
    private static final String ADD_BUILD_STEP_BUTTON = "//button[text()='Add build step']";
    private static final String BUILD_STEP_DROPDOWN = "//ul[@class='first-of-type']//a[text()='Process Job DSLs']";
    private static final String SAVE_PROVISIONER_BUTTON = "//button[@id='yui-gen78-button']";
    private static final String USE_THE_PROVIDED_DSL_SCRIPT_CHECKBOX = "//*[text()[contains(.,'Use the provided DSL script')]]//input";
    private static final String DSL_SCRIPT_WINDOW = "//div[@class='CodeMirror-scroll cm-s-default']";
    //    private static final String PROVISIONER_CODE_INPUT = "//div[@name='builder']//div[@class='CodeMirror-lines']/div/div[not(contains(@style,'hidden'))]/pre";
    private static final String CODE_INPUT = "//div[@class='CodeMirror-scroll cm-s-default']";
    private static final String SIT_JOB_BUTTON = "//a[@href='job/sit/']";
    private static final String BUILD_WITH_PARAMETERS_BUTTON = "//span[text()='Build with Parameters']";
    private static final String BUILD_BUTTON = "//button[text()='Build']";
    //    private static final String JOB_INFO_PAGE = "//a[contains(text(),'petclinic-sit')]";
    private static final String JOB_INFO_PAGE = "//a[@class='build-status-link']";
    private static final String PIPELINE_PROGRESS_BAR = "//td[@class='build-caption-progress-bar']";
    private static final String INIT_STAGE_PROGRESS = "//div[@class='progress']";
    private static final String VERSION_FOR_DEPLOY_DROPDOWN = "//select[text()='PETCLINIC_VERSION']";
    private static final String PROCEED_BUTTON_IN_VERSION_INFORMATION_POPUP = "//button[text()='Proceed']";
    private static final String INPUT_REQUESTED_BUTTON = "//a[text()='Input requested']";


    @Override
    public void clickCodebaseJenkinsFolder(String codebaseJenkinsFolder) {
        Selenide.sleep(2_000);
//        $$x(String.format(CODEBASE_JENKINS_FOLDER,codebaseJenkinsFolder)).shouldHaveSize(1).first().click();
        $x(String.format(CODEBASE_JENKINS_FOLDER, codebaseJenkinsFolder)).shouldBe(Condition.visible).click();
    }

    @Override
    public void createReleaseStatusShouldBeSuccess(String createReleaseJob) {
        Predicate<SelenideElement> checkStatus = status -> {
            $x(String.format(CREATE_RELEASE_JOB, createReleaseJob)).shouldBe(Condition.visible);
            Selenide.refresh();
            return Try.of(() -> $x(String.format(CREATE_RELEASE_JOB, createReleaseJob)).shouldHave(Condition.attribute("class", " job-status-blue"))).isSuccess();
        };
        new FlexWait<SelenideElement>(String.format("wait for success status for %s create release job", createReleaseJob))
                .during(60000).tryTo(checkStatus).every(5000).executeWithoutResult();
    }

    @Override
    public void buildJobStatusShouldBeSuccess(String buildJob) {
        Predicate<SelenideElement> checkStatus = status -> {
            $x(String.format(BUILD_JOB, buildJob)).shouldBe(Condition.visible);
            Selenide.refresh();
            return Try.of(() -> $x(String.format(BUILD_JOB, buildJob)).shouldHave(Condition.attribute("class", " job-status-blue"))).isSuccess();
        };
        new FlexWait<SelenideElement>(String.format("wait for success status for %s build job", buildJob))
                .during(250000).tryTo(checkStatus).every(5000).executeWithoutResult();
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
        $x(PRIVAT_SSH_KEY_INPUT).shouldBe(Condition.visible).sendKeys(privatSshKey);
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
        $x(SIT_JOB_BUTTON).waitUntil(Condition.visible, 5_000).click();
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
//        $x(INIT_STAGE_PROGRESS).shouldBe(Condition.visible).hover();
        $x(VERSION_FOR_DEPLOY_DROPDOWN).shouldBe(Condition.visible).selectOptionByValue(applicationVersion);
    }

    @Override
    public void clickProceedButtonInVersionInfoPopup() {
        $x(PROCEED_BUTTON_IN_VERSION_INFORMATION_POPUP).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickInputRequestedButton() {
        $x(INPUT_REQUESTED_BUTTON).waitUntil(Condition.visible,7_000).scrollIntoView(false).click();
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
        SelenideElement element = $$x(CODE_INPUT).filter(Condition.visible).last();
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
                "}").perform();

    }

}
