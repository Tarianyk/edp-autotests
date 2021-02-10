package edp.pageobject.pages.interfaces;

public interface IApplicationPage extends IBasePage {
    void selectCodebaseIntegrationStrategy(String strategy);

    void enterApplicationName(String appName);

    void clickApplicationName(String appName);

    void branchNameStatusShouldBeActive(String branchName);

    void enterGitUrl(String gitUrl);

    void enterGitlabRepositoryLogin(String gitlabRepositoryLogin);

    void enterGithubRepositoryLogin(String githubRepositoryLogin);

    void enterGitlabRepositoryPassword(String gitlabRepositoryPassword);

    void enterGithubRepositoryPassword(String githubRepositoryPassword);

    void selectGitServer(String gitServer);

    void enterRelativePath(String relativePath);

    void enterGithubRelativePath(String relativePath);

    void selectCiPipelineProvisioner(String ciPipelineProvisioner);

    void selectDeploymentScript(String deploymentScript);

    void checkNeedRouteCheckbox();

    void enterRouteName(String routeName);

    void enterRoutePath(String routePath);

    void checkNeedDatabaseCheckbox();

    void selectDatabaseType(String databaseType);

    void selectDatabaseVersion(String databaseVersion);

    void enterDatabaseCapacity(String databaseCapacity);

    void selectCapacityUnit(String capacityUnit);

    void selectPersistentStorage(String persistentStorage);

    void checkMultiModuleProjectCheckbox();



}
