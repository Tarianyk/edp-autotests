package edp.stepdefs;

import edp.core.config.TestConfiguration;
import edp.pageobject.pages.IBrowserTabProcessing;
import edp.pageobject.pages.interfaces.IJenkins;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class JenkinsDefinitionSteps {
    @Autowired
    private IJenkins jenkins;
    @Autowired
    private TestConfiguration testConfig;

    @And("User clicks {string} codebase jenkins folder")
    public void userClicksCodebaseJenkinsFolder(final String codebaseJenkinsFolder) {
        jenkins.clickCodebaseJenkinsFolder(codebaseJenkinsFolder);
    }

    @And("User sees success status for {string} create release job")
    public void userSeesSuccessStatusForCreateReleaseJob(final String createReleaseJob) {
        jenkins.createReleaseStatusShouldBeSuccess(createReleaseJob);
    }

    @And("User sees success status for {string} build job")
    public void userSeesSuccessStatusForBuildJob(final String buildJob) {
        jenkins.buildJobStatusShouldBeSuccess(buildJob);
        IBrowserTabProcessing.switchToFirstTab();
    }

    @And("User clicks 'Manage Jenkins' button")
    public void userClicksManageJenkinsButton() {
        jenkins.clickManageJenkinsButton();
    }

    @And("User clicks 'Manage Credentials' button")
    public void userClicksManageCredentialsButton() {
        jenkins.clickManageCredentialsButton();
    }

    @And("User clicks 'global' button")
    public void userClicksGlobalButton() {
        jenkins.clickGlobalButton();
    }

    @And("User clicks 'Add Credentials' button")
    public void userClicksAddCredentialsButton() {
        jenkins.clickAddCredentialsButton();
    }

    @And("User selects {string} credentials kind")
    public void userSelectsCredentialsKind(final String credentialsKind) {
        jenkins.selectCredentialsKind(credentialsKind);
    }

    @And("User enters {string} api token")
    public void userEntersApiToken(final String gitlabApiToken) {
        String token = testConfig.getEnvironmentConfig().getGitlabApiToken();
        jenkins.enterApiToken(gitlabApiToken);
    }

    @And("User enters {string} token id")
    public void userEntersTokenId(final String tokenId) {
        jenkins.enterTokenId(tokenId);
    }

    @And("User clicks 'ok' button")
    public void userClicksOkButton() {
        jenkins.clickOkButton();
    }

    @And("User enters {string} ssh key id")
    public void userEntersSshKeyId(final String sshKeyId) {
        jenkins.enterSshKeyId(sshKeyId);
    }

    @And("User clicks 'Enter directly' button")
    public void userClicksEnterDirectlyButton() {
        jenkins.clickEnterDirectlyButton();
    }

    @And("User clicks 'Add ssh' button")
    public void userClicksAddSshButton() {
        jenkins.clickAddSshButton();
    }

    @And("User enters {string} privat ssh key")
    public void userEntersPrivatSshKey(final String privatSshKey) {
        String sshKey = testConfig.getEnvironmentConfig().getPrivatSshKey();
        jenkins.enterPrivatSshKey(privatSshKey);
    }

    @And("User enters {string} secret token")
    public void userEntersSecretToken(final String githubSecretToken) {
        String secret = testConfig.getEnvironmentConfig().getGithubSecretToken();
        jenkins.enterSecretToken(githubSecretToken);
    }

    @And("User enters {string} secret id")
    public void userEntersSecretId(final String secretId) {
        jenkins.enterSecretTokenId(secretId);
    }

    @And("User clicks 'Configure System' button")
    public void userClicksConfigureSystemButton() {
        jenkins.clickConfigureSystemButton();
    }

    @And("User enters {string} gitlab connection name")
    public void userEntersGitlabConnectionName(final String gitlabConnectionName) {
        jenkins.enterGitlabConnectionName(gitlabConnectionName);
    }

    @And("User enters {string} gitlab host url")
    public void userEntersGitlabHostUrl(final String gitlabHostUrl) {
        jenkins.enterGitlabHostUrl(gitlabHostUrl);
    }

    @And("User selects {string} gitlab access api token")
    public void userSelectsGitlabAccessApiToken(final String gitlabAccessApiToken) {
        jenkins.selectGitlabAccessApiToken(gitlabAccessApiToken);
    }

    @And("User clicks 'Save' button")
    public void userClicksSaveButton() {
        jenkins.clickSaveButton();
    }

    @And("User clicks 'Add Github server' button")
    public void userClicksAddGithubServerButton() {
        jenkins.clickAddGithubServerButton();
    }

    @And("User clicks 'github Server' button")
    public void userClicksGithubServerButton() {
        jenkins.clickGithubServerButton();
    }

    @And("User enters {string} github connection name")
    public void userEntersGithubConnectionName(final String githubConnectionName) {
        jenkins.enterGithubConnectionName(githubConnectionName);
    }

    @And("User selects {string} github access api token")
    public void userSelectsGithubAccessApiToken(final String githubAccessApiToken) {
        jenkins.selectGithubAccessApiToken(githubAccessApiToken);
    }

    @And("User opens 'job provisions' folder")
    public void userOpensJobProvisionsFolder() {
        jenkins.openJobProvisionsFolder();
    }

    @And("User opens 'ci' folder")
    public void userOpensCiFolder() {
        jenkins.openCiFolder();
    }

    @And("User clicks 'New item' button")
    public void userClicksNewItemButton() {
        jenkins.clickNewItemButton();
    }

    @And("User enters {string} provisioner name")
    public void userEntersProvisionerName(final String provisionerName) {
        jenkins.enterProvisionerName(provisionerName);
    }

    @And("User clicks 'freestyle project' option")
    public void userClicksFreestyleProjectOption() {
        jenkins.clickFreestyleProjectOption();
    }

    @And("User clicks 'create provisioner' button")
    public void userClicksCreateProvisionerButton() {
        jenkins.clickCreateProvisionerButton();
    }

    @And("User enters {string} branch name in 'Label Expression' field")
    public void userEntersBranchNameInLabelExpressionField(final String branchName) {
        jenkins.enterBranchNameInLabelExpressionField(branchName);
    }

    @And("User checks 'Execute concurrent builds if necessary' checkbox")
    public void userChecksExecuteConcurrentBuildsIfNecessaryCheckbox() {
        jenkins.checkExecuteConcurrentBuildsIfNecessaryCheckbox();
    }

    @And("User checks 'This project is parameterized' checkbox")
    public void userChecksThisProjectIsParameterizedCheckbox() {
        jenkins.checkThisProjectIsParameterizedCheckbox();
    }

    @And("User clicks 'Add parameter' button")
    public void userClicksAddParameterButton() {
        jenkins.clickAddParameterButton();
    }

    @And("User selects {string} parameters type")
    public void userSelectsParametersType(final String parametersType) {
        jenkins.selectParametersType(parametersType);
    }

    @And("User enters {string} parameter name")
    public void userEntersParameterName(final String parameterName) {
        jenkins.enterParameterName(parameterName);
    }

    @And("User clicks 'Build triggers' button")
    public void userClicksBuildTriggersButton() {
        jenkins.clickBuildTriggerButton();
    }

    @And("User clicks 'Add Build step' button")
    public void userClicksAddBuildStepButton() {
        jenkins.clickAddBuildStepButton();
    }

    @And("User selects {string} build step")
    public void userSelectsBuildStep(final String buildStep) {
        jenkins.selectBuildStep(buildStep);
    }

    @And("User clicks 'Save provisioner' button")
    public void userClicksSaveProvisionerButton() {
        jenkins.clickSaveProvisionerButton();
    }

    @And("User clicks 'Use the provided DSL script' checkbox")
    public void userClicksUseTheProvidedDslScriptCheckbox() {
        jenkins.clickUseTheProvidedDslScriptCheckbox();
    }

    @And("User activate 'DSL script' window")
    public void userActivateDslScriptWindow() {
        jenkins.activateDslScriptWindow();
    }

    @And("User enters {string} provisioner code")
    public void userEntersProvisionerCode(final String provisionerCode) {
        String gitlabProvisioner = testConfig.getEnvironmentConfig().getGitlabProvisionerCode();
        jenkins.enterProvisionerCode(gitlabProvisioner);
    }

    @And("User clicks 'sit' job")
    public void clicksSitJob() {
        jenkins.clickSitJob();
    }

    @And("User clicks 'Build with Parameters' button")
    public void userClicksBuildWithParametersButton() {
        jenkins.clickBuildWithParametersButton();
    }

    @And("User clicks 'Build' button")
    public void userClicksBuildButton() {
        jenkins.clickBuildButton();
    }

    @And("User opens 'job info' page")
    public void userOpensJobInfoPage() {
        jenkins.openJobInfoPage();
    }

    @And("User clicks progress bar")
    public void userClicksProgressBar() {
        jenkins.clickProgressBar();
    }

    @And("User selects {string} application version for deploy")
    public void userSelectsApplicationVersionForDeploy(final String applicationVersion) {
        jenkins.selectApplicationVersionForDeploy(applicationVersion);
    }

    @Then("User clicks 'Proceed' button in version info popup")
    public void userClicksProceedButtonInVersionInfoPopup() {
        jenkins.clickProceedButtonInVersionInfoPopup();
    }

    @And("User clicks 'Input requeted' button")
    public void userClicksInputRequestedButton() {
        jenkins.clickInputRequestedButton();
    }
}
