package edp.pageobject.pages.interfaces;

public interface IBasePage<T extends IBasePage> {
    void openPage();

    void clickCreateButton();

    void clickProceedButton();

    void selectCodebaseLanguage(String codebaseLanguage);

    void selectBuildTool(String buildTool);

    void clickContinueButton();

    void applicationNameStatusShouldBeActive(String appName);

    void selectLanguageVersion(String languageVersion);

    void checkAuthenticationCheckbox();

    void selectVersioningType(String versioningType);

    void enterStartVersion(String startVersion);

    void checkIntegrateWithJiraCheckbox();

    void selectJiraServer(String jiraServer);

    void specifyCommitMessagePattern(String commitMessagePattern);

    void specifyJiraTicketPattern(String jiraTicketPattern);

    void enterNewBranchName(String newBranchName);

    void enterDefaultBranchName(String defaultBranchName);

    void enterUsername(String username);

    void enterPassword(String password);

    void clickLoginButton();

    void clickSubmitButton();

    void enterFirstName(String firstName);

    void enterLastName(String lastName);

    void clickDeleteCodebaseButton();

    void enterApplicationNameInConfirmationField(String applicationName);

    void clickDeleteConfirmationButton();

    void clickVcsLink();

    void clickGerritLink();

    void clickBrowseButton();

    void clickJenkinsLink();

    void clickOpenShiftLink();

    void selectAmountOfEntires(String amountOfEntires);


}

