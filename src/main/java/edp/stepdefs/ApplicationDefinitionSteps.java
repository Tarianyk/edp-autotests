package edp.stepdefs;

import com.codeborne.selenide.Selenide;
import edp.core.config.TestConfiguration;
import edp.pageobject.pages.interfaces.IApplicationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.vavr.API.*;

public class ApplicationDefinitionSteps {
    @Autowired
    private IApplicationPage applicationPage;
    @Autowired
    private TestConfiguration testConfig;

    @And("User clicks 'Create' button")
    public void userClicksCreateButton() {
        applicationPage.clickCreateButton();
    }

    @And("User selects {string} codebase integration strategy")
    public void userSelectsCodebaseIntegrationStrategy(final String strategy) {
        applicationPage.selectCodebaseIntegrationStrategy(strategy);

    }

    @And("User selects {string} git server")
    public void selectGitServer(final String gitServer) {
        applicationPage.selectGitServer(gitServer);
    }

    @And("User enters {string} in git repository url field")
    public void userEntersGitUrlInGitRepositoryUrlField(final String repository) {
        String url = Match(repository).of(
                Case($("java8-gitlab"), testConfig.getEnvironmentConfig().getJava8RepoUrlGitlab()),
                Case($("java8-gradle-gitlab"), testConfig.getEnvironmentConfig().getJava8GradleRepoUrlGitlab()),
                Case($("java11-gitlab"), testConfig.getEnvironmentConfig().getJava11RepoUrlGitlab()),
                Case($("java11-maven-gitlab"), testConfig.getEnvironmentConfig().getJava11MavenRepoUrlGitlab()),
                Case($("dotnet31-gitlab"), testConfig.getEnvironmentConfig().getDotnet31RepoUrlGitlab()),
                Case($("dotnet21-gitlab"), testConfig.getEnvironmentConfig().getDotnet21RepoUrlGitlab()),
                Case($("python38-gitlab"), testConfig.getEnvironmentConfig().getPython38RepoUrlGitlab()),
                Case($("javascript-gitlab"), testConfig.getEnvironmentConfig().getJavascriptRepoUrlGitlab()),
                Case($("go-beego-gitlab"), testConfig.getEnvironmentConfig().getGoBeegoRepoUrlGitlab()),
                Case($("go-operatorsdk-gitlab"), testConfig.getEnvironmentConfig().getGoOperatorSdkUrlGitlab()),
                Case($("java8-multimodule-gitlab"), testConfig.getEnvironmentConfig().getJava8MultimoduleGitlab()),
                Case($("java11-multimodule-gitlab"), testConfig.getEnvironmentConfig().getJava11MultimoduleGitlab()),
                Case($("java8-mavem-github"), testConfig.getEnvironmentConfig().getJava8MavenRepoUrlGithub()),
                Case($("java8-gradle-github"), testConfig.getEnvironmentConfig().getJava8GradleRepoUrlGithub()),
                Case($("java11-mavem-github"), testConfig.getEnvironmentConfig().getJava11MavenRepoUrlGithub()),
                Case($("java11-gradle-github"), testConfig.getEnvironmentConfig().getJava11GradleRepoUrlGithub()),
                Case($("java8-multimodule-github"), testConfig.getEnvironmentConfig().getJava8MultimoduleGithub()),
                Case($("java11-multimodule-github"), testConfig.getEnvironmentConfig().getJava11MultimoduleGithub()),
                Case($("go-beego-github"), testConfig.getEnvironmentConfig().getGoBeegoRepoUrlGithub()),
                Case($("go-operatorsdk-github"), testConfig.getEnvironmentConfig().getGoOperatorSdkUrlGithub()),
                Case($("javascript-github"), testConfig.getEnvironmentConfig().getJavascriptRepoUrlGithub()),
                Case($("python38-github"), testConfig.getEnvironmentConfig().getPython38RepoUrlGithub()),
                Case($("dotnet31-github"), testConfig.getEnvironmentConfig().getDotnet31RepoUrlGithub()),
                Case($("dotnet21-github"), testConfig.getEnvironmentConfig().getDotnet21RepoUrlGithub()),
                Case($("petclinicBe-gitlab"), testConfig.getEnvironmentConfig().getPetclinicBeRepoUrlGitlab()),
                Case($("petclinicFe-gitlab"), testConfig.getEnvironmentConfig().getPetclinicFeRepoUrlGitlab()),
                Case($("petclinic-autotests-gitlab"), testConfig.getEnvironmentConfig().getPetclinicAutotestsUrlGitlab()),
                Case($("petclinic-deploy"), testConfig.getEnvironmentConfig().getPetclinicDeployUrl())
        );
        applicationPage.enterGitUrl(url);
    }

    @And("User selects {string} ci pipeline provisioner")
    public void userSelectsCiPipelineProvisioner(final String ciPipelineProvisioner) {
        applicationPage.selectCiPipelineProvisioner(ciPipelineProvisioner);
    }

    @And("User checks 'Codebase Authentication' check-box")
    public void userChecksAuthenticationCheckbox() {
        applicationPage.checkAuthenticationCheckbox();
    }

    @And("User enters {string} for Gitlab in repository login field")
    public void userEntersRepositoryLogin(final String gitlabRepositoryLogin) {
        String login = testConfig.getEnvironmentConfig().getGitlabRepositoryLogin();
        applicationPage.enterGitlabRepositoryLogin(login);
    }

    @And("User enters {string} for Github in repository login field")
    public void userEntersGithubRepositoryLogin(final String githubRepositoryLogin) {
        String login = testConfig.getEnvironmentConfig().getGithubRepositoryLogin();
        applicationPage.enterGithubRepositoryLogin(login);
    }

    @And("User enters {string} for Gitlab in repository password field")
    public void userEntersRepositoryPassword(final String gitlabRepositoryPassword) {
        String password = testConfig.getEnvironmentConfig().getGitlabRepositoryPassword();
        applicationPage.enterGitlabRepositoryPassword(password);
    }

    @And("User enters {string} for Github in repository password field")
    public void userEntersGithubRepositoryPassword(final String githubRepositoryPassword) {
        String password = testConfig.getEnvironmentConfig().getGithubRepositoryPassword();
        applicationPage.enterGithubRepositoryPassword(password);
    }

    @When("User enters {string} in username field")
    public void userEntersUsername(final String username) {
        String user = testConfig.getEnvironmentConfig().getUsername();
        applicationPage.enterUsername(user);
    }

    @And("User enters {string} in password field")
    public void userEntersPassword(final String password) {
        String pass = testConfig.getEnvironmentConfig().getPassword();
        applicationPage.enterPassword(pass);
    }

    @And("User enters {string} first name")
    public void userEntersFirstName(final String firstName) {
        String firstName1 = testConfig.getEnvironmentConfig().getFirstName();
        applicationPage.enterFirstName(firstName1);
    }

    @And("User enters {string} last name")
    public void userEntersLastName(final String lastName) {
        String lastName1 = testConfig.getEnvironmentConfig().getLastName();
        applicationPage.enterLastName(lastName1);
    }

    @And("User clicks 'Submit' button")
    public void userClicksSubmitButton() {
        applicationPage.clickSubmitButton();
    }

    @And("User clicks 'delete codebase' button")
    public void userClicksDeleteCodebaseButton() {
        applicationPage.clickDeleteCodebaseButton();
    }

    @And("User clicks 'login' button")
    public void userClicksLoginButton() {
        applicationPage.clickLoginButton();
    }


    @And("User clicks 'Proceed' button")

    public void userClicksProceedButton() {
        applicationPage.clickProceedButton();

    }

    @And("User enters {string} in application name field")
    public void userEntersNameInApplicationNameField(final String applicationName) {
        applicationPage.enterApplicationName(applicationName);
    }

    @And("User enters {string} in confirmation name field")
    public void userEntersApplicationNameInConfirmationField(final String applicationName) {
        applicationPage.enterApplicationNameInConfirmationField(applicationName);
    }

    @And("User clicks 'Delete confirmation' button")
    public void userClicksDeleteConfirmationButton() {
        applicationPage.clickDeleteConfirmationButton();
    }

    @And("User clicks 'VCS' link")
    public void userClicksVcsLink() {
        applicationPage.clickVcsLink();
    }

    @And("User selects {string} application code language")
    public void userSelectsApplicationCodeLanguage(final String codeLanguage) {
        applicationPage.selectCodebaseLanguage(codeLanguage);

    }

    @And("User selects {string} language version")
    public void userSelectsLanguageVersion(final String languageVersion) {
        applicationPage.selectLanguageVersion(languageVersion);
    }

    @And("User selects {string} build tool")
    public void userSelectsBuildTool(final String buildTool) {
        applicationPage.selectBuildTool(buildTool);
    }

    @And("User selects {string} codebase versioning type")
    public void userSelectsVersioningType(final String versioningType) {
        applicationPage.selectVersioningType(versioningType);
    }


    @And("User enters {string} start version")
    public void userEntersStartVersion(final String startVersion) {
        Selenide.sleep(1_000);
        applicationPage.enterStartVersion(startVersion);
    }

    @And("User selects {string} deployment script")
    public void userSelectsDeploymentScript(final String deploymentScript) {
        applicationPage.selectDeploymentScript(deploymentScript);
    }

    @And("User checks 'Integrate with Jira' checkbox")
    public void userChecksIntegrateWithJiraCheckbox() {
        applicationPage.checkIntegrateWithJiraCheckbox();

    }

    @And("User selects {string} Jira Server")
    public void userSelectsJiraServer(final String jiraServer) {
        applicationPage.selectJiraServer(jiraServer);

    }

    @And("User specify {string} the pattern to validate commit message")
    public void userSpecifyCommitMessagePattern(final String commitMessagePattern) {
        applicationPage.specifyCommitMessagePattern(commitMessagePattern);
    }

    @And("User specify {string} the  pattern to find a Jira ticket number in a commit message")
    public void userSpecifyJiraTicketPattern(final String jiraTicketPattern) {
        applicationPage.specifyJiraTicketPattern(jiraTicketPattern);
    }

    @And("User checks 'Need Route' checkbox")
    public void userChecksNeedRouteCheckbox() {
        applicationPage.checkNeedRouteCheckbox();
    }

    @And("User enters {string} in route name field")
    public void userEntersRouteName(final String routeName) {
        applicationPage.enterRouteName(routeName);

    }

    @And("User enters {string} in route path field")
    public void userEntersRoutePath(final String routePath) {
        applicationPage.enterRoutePath(routePath);

    }

    @And("User checks 'Need Database' checkbox")
    public void userChecksNeedDatabaseCheckbox() {
        applicationPage.checkNeedDatabaseCheckbox();
    }

    @And("User selects {string} database type")
    public void userSelectsDatabaseType(final String databaseType) {
        applicationPage.selectDatabaseType(databaseType);

    }

    @And("User selects {string} database version")
    public void userSelectsDatabaseVersion(final String databaseVersion) {
        applicationPage.selectDatabaseVersion(databaseVersion);
    }

    @And("User enters {string} database capacity")
    public void userEntersDatabaseCapacity(final String databaseCapacity) {
        applicationPage.enterDatabaseCapacity(databaseCapacity);

    }

    @And("User selects {string} capacity unit")
    public void selectCapacityUnit(final String capacityUnit) {
        applicationPage.selectCapacityUnit(capacityUnit);

    }

    @And("User selects {string} persistent storage")
    public void userSelectsPersistentStorage(final String persistentStorage) {
        applicationPage.selectPersistentStorage(persistentStorage);

    }

    @And("User clicks 'Continue' button in confirmation popup")

    public void userClicksContinueButtonInConfirmationPopup() {
        applicationPage.clickContinueButton();

    }

    @And("User selects {string} amount of entires")
    public void userSelectsAmountOfEntires(final String amountOfEntires) {
        applicationPage.selectAmountOfEntires(amountOfEntires);
    }

    @Then("User sees success status for {string} application name")
    public void userSeesSuccessStatusForApplicationName(final String applicationName) {
        applicationPage.applicationNameStatusShouldBeActive(applicationName);

    }

    @And("User clicks {string} application name")
    public void userClicksApplicationName(final String appName) {
        applicationPage.clickApplicationName(appName);
    }

    @And("User sees success status in Branches section for {string} branch")
    public void userSeesSuccessStatusInBranchesSectionForBranchName(final String branchName) {
        applicationPage.branchNameStatusShouldBeActive(branchName);

    }


    @And("User enters {string} branch name")

    public void userEntersNewBranchName(final String newBranchName) {
        applicationPage.enterNewBranchName(newBranchName);
    }

    @And("User enters {string} repository relative path")
    public void userEntersRelativePath(final String relativePath) {
        String path = Match(relativePath).of(
                Case($("java8-gitlab"), testConfig.getEnvironmentConfig().getJava8RepoUrlGitlab()),
                Case($("java8-gradle-gitlab"), testConfig.getEnvironmentConfig().getJava8GradleRepoUrlGitlab()),
                Case($("java11-gitlab"), testConfig.getEnvironmentConfig().getJava11RepoUrlGitlab()),
                Case($("java11-maven-gitlab"), testConfig.getEnvironmentConfig().getJava11MavenRepoUrlGitlab()),
                Case($("dotnet31-gitlab"), testConfig.getEnvironmentConfig().getDotnet31RepoUrlGitlab()),
                Case($("dotnet21-gitlab"), testConfig.getEnvironmentConfig().getDotnet21RepoUrlGitlab()),
                Case($("python38-gitlab"), testConfig.getEnvironmentConfig().getPython38RepoUrlGitlab()),
                Case($("javascript-gitlab"), testConfig.getEnvironmentConfig().getJavascriptRepoUrlGitlab()),
                Case($("go-beego-gitlab"), testConfig.getEnvironmentConfig().getGoBeegoRepoUrlGitlab()),
                Case($("go-operatorsdk-gitlab"), testConfig.getEnvironmentConfig().getGoOperatorSdkUrlGitlab()),
                Case($("java8-multimodule-gitlab"), testConfig.getEnvironmentConfig().getJava8MultimoduleGitlab()),
                Case($("java11-multimodule-gitlab"), testConfig.getEnvironmentConfig().getJava11MultimoduleGitlab()),
                Case($("petclinic-autotests-gitlab"), testConfig.getEnvironmentConfig().getPetclinicAutotestsUrlGitlab())

        );
        Pattern pattern = Pattern.compile("(?<=epam.com)(.*)(?=.git)");
        Matcher matcher = pattern.matcher(path);
        if (matcher.find())
            path = matcher.group();
        applicationPage.enterRelativePath(path);
    }

    @And("User enters {string} relative path for github repository")
    public void userEntersGithubRelativePath(final String relativePath) {
        String path = Match(relativePath).of(
                Case($("java8-mavem-github"), testConfig.getEnvironmentConfig().getJava8MavenRepoUrlGithub()),
                Case($("java8-gradle-github"), testConfig.getEnvironmentConfig().getJava8GradleRepoUrlGithub()),
                Case($("java11-mavem-github"), testConfig.getEnvironmentConfig().getJava11MavenRepoUrlGithub()),
                Case($("java11-gradle-github"), testConfig.getEnvironmentConfig().getJava11GradleRepoUrlGithub()),
                Case($("javascript-github"), testConfig.getEnvironmentConfig().getJavascriptRepoUrlGithub()),
                Case($("python38-github"), testConfig.getEnvironmentConfig().getPython38RepoUrlGithub()),
                Case($("dotnet31-github"), testConfig.getEnvironmentConfig().getDotnet31RepoUrlGithub()),
                Case($("dotnet21-github"), testConfig.getEnvironmentConfig().getDotnet21RepoUrlGithub()),
                Case($("go-beego-github"), testConfig.getEnvironmentConfig().getGoBeegoRepoUrlGithub()),
                Case($("go-operatorsdk-github"), testConfig.getEnvironmentConfig().getGoOperatorSdkUrlGithub()),
                Case($("java8-multimodule-github"), testConfig.getEnvironmentConfig().getJava8MultimoduleGithub()),
                Case($("java11-multimodule-github"), testConfig.getEnvironmentConfig().getJava11MultimoduleGithub())

        );
        Pattern pattern1 = Pattern.compile("(?<=github.com)(.*)(?=.git)");
        Matcher matcher = pattern1.matcher(path);
        if (matcher.find())
            path = matcher.group();
        applicationPage.enterGithubRelativePath(path);
    }

    @And("User enters {string} default branch name")
    public void userEntersDefaultBranchName(final String defaultBranchName) {
        applicationPage.enterDefaultBranchName(defaultBranchName);
    }

    @And("User checks 'Multi-module Project' checkbox")
    public void userChecksMultiModuleProjectCheckbox() {
        applicationPage.checkMultiModuleProjectCheckbox();
    }


}




