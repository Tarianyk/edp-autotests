package edp.pageobject.pages.interfaces;

public interface IJenkins {
    void clickCodebaseJenkinsFolder(String codebaseJenkinsFolder);

    void openCdPipelineOverview(String codebaseJenkinsFolder);

    void createReleaseStatusShouldBeSuccess(String createReleaseJob);

    void pluginInstallationStatusShouldBeActive(String pluginName);

    void buildJobStatusShouldBeSuccess(String buildJob);

    void cdPipelineStageStatusShouldBeSuccess(String cdPipelineStage);

    void clickManageJenkinsButton();

    void clickManageCredentialsButton();

    void clickGlobalButton();

    void clickAddCredentialsButton();

    void selectCredentialsKind(String credentialsKind);

    void enterApiToken(String gitlabApiToken);

    void enterTokenId(String tokenId);

    void clickOkButton();

    void enterSshKeyId(String sshKeyId);

    void clickEnterDirectlyButton();

    void clickAddSshButton();

    void enterPrivatSshKey(String privatSshKey);

    void enterSecretToken(String githubSecretToken);

    void enterSecretTokenId(String secretId);

    void clickConfigureSystemButton();

    void clickManagePluginsButton();

    void clickAvailableButton();

    void enterPluginNameInSearchField(String pluginName);

    void clickInstallWithoutRestartButton();

    void checkGitHubPullRequestBuilderCheckbox();

    void enterGitlabConnectionName(String gitlabConnectionName);

    void enterGitlabHostUrl(String gitlabHostUrl);

    void enterGithubHostUrl(String githubHostUrl);

    void selectGitlabAccessApiToken(String gitlabAccessApiToken);

    void clickSaveButton();

    void clickAddGithubServerButton();

    void clickGithubServerButton();

    void enterGithubConnectionName(String githubConnectionName);

    void selectGithubAccessApiToken(String githubAccessToken);

    void selectsTokenForPullRequestBuilder(String githubAccessApiToken);

    void openJobProvisionsFolder();

    void openCiFolder();

    void clickNewItemButton();

    void enterProvisionerName(String provisionerName);

    void clickFreestyleProjectOption();

    void clickCreateProvisionerButton();

    void enterBranchNameInLabelExpressionField(String branchName);

    void checkExecuteConcurrentBuildsIfNecessaryCheckbox();

    void checkThisProjectIsParameterizedCheckbox();

    void clickAddParameterButton();

    void selectParametersType(String parametersType);

    void enterParameterName(String parameterName);

    void clickBuildTriggerButton();

    void clickAddBuildStepButton();

    void selectBuildStep(String buildStep);

    void clickSaveProvisionerButton();

    void clickUseTheProvidedDslScriptCheckbox();

    void activateDslScriptWindow();

    void enterProvisionerCode(String provisionerCode);

    void enterGitHubProvisionerCode(String gitHubProvisionerCode);

    void clickSitJob();

    void clickBuildWithParametersButton();

    void clickBuildButton();

    void openJobInfoPage();

    void clickProgressBar();

    void clickInputRequestedButton();

    void selectApplicationVersionForDeploy(String applicationVersion);

    void clickProceedButtonInVersionInfoPopup();

    void clickProceedButtonToPromoteImage();




}
