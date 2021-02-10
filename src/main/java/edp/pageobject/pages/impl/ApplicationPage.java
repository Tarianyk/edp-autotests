package edp.pageobject.pages.impl;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import edp.core.annotations.Page;
import edp.pageobject.pages.interfaces.IApplicationPage;
import edp.utils.wait.FlexWait;
import io.cucumber.datatable.dependency.difflib.StringUtills;
import io.vavr.control.Try;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.function.Predicate;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Lazy
@Page
@Scope("prototype")
public class ApplicationPage extends AbstractBasePage implements IApplicationPage {
    private static final String STRATEGY_DROPDOWN = "//select[@id='strategy']";
    private static final String APPLICATION_NAME_INPUT = "//input[@id='appName']";
    private static final String APPLICATION_NAME = "//a[text()[normalize-space(.) = '%s']]";
    private static final String BRANCH_NAME = "//tr[@data-branch-name='%s']";
    private static final String GIT_URL = "//input[@id='gitRepoUrl']";
    private static final String REPOSITORY_LOGIN = "//input[@id='repoLogin']";
    private static final String REPOSITORY_PASSWORD = "//input[@id='repoPassword']";
    private static final String GIT_SERVER = "//select[@id='gitServer']";
    private static final String RELATIVE_PATH = "//input[@id='gitRelativePath']";
    private static final String DEPLOYMENT_SCRIPT_DROPDOWN = "//select[@name='deploymentScript']";
    private static final String NEED_ROUTE_CHECKBOX = "//input[@id='needRoute']";
    private static final String ROUTE_NAME_INPUT = "//input[@id='routeSite']";
    private static final String ROUTE_PATH_INPUT = "//input[@id='routePath']";
    private static final String NEED_DATABASE_CHECKBOX = "//input[@id='needDb']";
    private static final String DATABASE_TYPE_DROPDOWN = "//select[@id='database']";
    private static final String DATABASE_VERSION_DROPDOVN = "//select[@id='dbVersion']";
    private static final String DATABASE_CAPACITY_INPUT = "//input[@id='dbCapacity']";
    private static final String CAPACITY_UNIT_DROPDOWN = "//select[@name='capacityExt']";
    private static final String PERSISTENT_STORAGE_DROPDOWN = "//select[@ID='dbPersistentStorage']";
    private static final String CI_PIPELINE_PROVISIONER = "//select[contains(@class, 'jobProvisioning')]";
    private static final String MULTI_MODULE_CHECKBOX = "//input[@id='multiModule']";

    @Override
    public void selectPersistentStorage(String persistentStorage) {
        $x(PERSISTENT_STORAGE_DROPDOWN).shouldBe(Condition.visible).selectOptionByValue(persistentStorage);
        $x(PERSISTENT_STORAGE_DROPDOWN).shouldHave(Condition.exactValue(persistentStorage));
    }

    @Override
    public void selectCapacityUnit(String capacityUnit) {
        $x(CAPACITY_UNIT_DROPDOWN).shouldBe(Condition.visible).selectOptionByValue(capacityUnit);
        $x(CAPACITY_UNIT_DROPDOWN).shouldHave(Condition.exactValue(capacityUnit));
    }

    @Override
    public void enterDatabaseCapacity(String databaseCapacity) {
        $x(DATABASE_CAPACITY_INPUT).shouldBe(Condition.visible).sendKeys(databaseCapacity);
    }

    @Override
    public void selectDatabaseVersion(String databaseVersion) {
        $x(DATABASE_VERSION_DROPDOVN).shouldBe(Condition.visible).selectOptionContainingText(databaseVersion);
        $x(DATABASE_VERSION_DROPDOVN).shouldHave(Condition.exactValue(databaseVersion));
    }

    @Override
    public void selectDatabaseType(String databaseType) {
        $x(DATABASE_TYPE_DROPDOWN).shouldBe(Condition.visible).selectOptionContainingText(databaseType);
        $x(DATABASE_TYPE_DROPDOWN).shouldHave(Condition.exactValue(databaseType));
    }

    @Override
    public void checkNeedDatabaseCheckbox() {
        $x(NEED_DATABASE_CHECKBOX).shouldBe(Condition.visible).click();
    }

    @Override
    public void enterRoutePath(String routePath) {
        $x(ROUTE_PATH_INPUT).shouldBe(Condition.visible).sendKeys(routePath);
    }

    @Override
    public void enterRouteName(String routeName) {
        $x(ROUTE_NAME_INPUT).shouldBe(Condition.visible).sendKeys(routeName);
    }

    @Override
    public void checkNeedRouteCheckbox() {
        $x(NEED_ROUTE_CHECKBOX).shouldBe(Condition.visible).click();
    }

    @Override
    public void selectDeploymentScript(String deploymentScript) {
        $x(DEPLOYMENT_SCRIPT_DROPDOWN).shouldBe(Condition.visible).selectOptionContainingText(deploymentScript);
        $x(DEPLOYMENT_SCRIPT_DROPDOWN).shouldHave(Condition.exactValue(deploymentScript));
    }


    @Override
    public void enterGithubRelativePath(String relativePath) {
        $x(RELATIVE_PATH).shouldBe(Condition.visible).sendKeys(relativePath);
    }

    @Override
    public void enterRelativePath(String relativePath) {
        $x(RELATIVE_PATH).shouldBe(Condition.visible).sendKeys(relativePath);
    }

    @Override
    public void checkMultiModuleProjectCheckbox() {
        $x(MULTI_MODULE_CHECKBOX).shouldBe(Condition.visible).click();
    }

    @Override
    public void selectCiPipelineProvisioner(String ciPipelineProvisioner) {
        $x(CI_PIPELINE_PROVISIONER).shouldBe(Condition.visible).selectOptionContainingText(ciPipelineProvisioner);
        $x(CI_PIPELINE_PROVISIONER).shouldHave(Condition.exactValue(ciPipelineProvisioner));
    }

    @Override
    public void selectGitServer(String gitServer) {
        $x(GIT_SERVER).shouldBe(Condition.visible).selectOptionByValue(gitServer);
        $x(GIT_SERVER).shouldHave(Condition.exactValue(gitServer));
    }

    @Override
    public void enterGithubRepositoryPassword(String githubRepositoryPassword) {
        $x(REPOSITORY_PASSWORD).shouldBe(Condition.visible).sendKeys(githubRepositoryPassword);
    }

    @Override
    public void enterGithubRepositoryLogin(String githubRepositoryLogin) {
        $x(REPOSITORY_LOGIN).shouldBe(Condition.visible).sendKeys(githubRepositoryLogin);
    }

    @Override
    public void enterGitlabRepositoryPassword(String gitlabRepositoryPassword) {
        $x(REPOSITORY_PASSWORD).shouldBe(Condition.visible).sendKeys(gitlabRepositoryPassword);
    }

    @Override
    public void enterGitlabRepositoryLogin(String gitlabRepositoryLogin) {
        $x(REPOSITORY_LOGIN).shouldBe(Condition.visible).sendKeys(gitlabRepositoryLogin);
    }

    @Override
    public void enterGitUrl(String gitUrl) {
        $x(GIT_URL).shouldBe(Condition.visible).sendKeys(gitUrl);
    }

    @Override
    public void branchNameStatusShouldBeActive(String branchName) {
        Predicate<SelenideElement> checkStatus = status -> {
            $x(String.format(BRANCH_NAME, branchName)).shouldBe(Condition.visible);
            Selenide.refresh();
//            return Try.of(() -> StringUtils.equals($x(String.format(BRANCH_NAME, branchName)).getAttribute("data-branch-status"), "active")).isSuccess();
            return Try.of(() -> $x(String.format(BRANCH_NAME, branchName)).shouldHave(Condition.attribute("data-branch-status", "active"))).isSuccess();
        };
        new FlexWait<SelenideElement>(String.format("wait for success status of %s application branch", branchName))
                .during(300000).tryTo(checkStatus).every(5000).executeWithoutResult();
    }

    @Override
    public void clickApplicationName(String appName) {
        $x(String.format(APPLICATION_NAME, appName)).hover().shouldBe(Condition.visible).click();
    }

    @Override
    public void selectCodebaseIntegrationStrategy(String strategy) {
        $x(STRATEGY_DROPDOWN).shouldBe(Condition.visible).selectOptionByValue(strategy);
        $x(STRATEGY_DROPDOWN).shouldHave(Condition.exactValue(strategy));
        Selenide.sleep(1_000);
    }

    @Override
    public void enterApplicationName(String appName) {
        $x(APPLICATION_NAME_INPUT).shouldBe(Condition.visible).sendKeys(appName);
    }
}
