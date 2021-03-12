package edp.pageobject.pages.impl;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import edp.core.annotations.CurrentUrl;
import edp.core.annotations.Page;
import edp.core.config.EnvironmentConfig;
import edp.core.driver.interfaces.IWebDriverService;
import edp.pageobject.pages.interfaces.IBasePage;
import edp.utils.wait.FlexWait;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.function.Predicate;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static edp.core.utils.WaitingUtils.waitForAjaxToComplete;
import static edp.core.utils.WaitingUtils.waitForPageReadyState;

@Lazy
@Page
@Scope("prototype")
public abstract class AbstractBasePage implements IBasePage {

    @Autowired
    private IWebDriverService webDriverService;

    @Autowired
    private EnvironmentConfig environmentConfig;

    private static final String CREATE_BUTTON = "//button[contains(@class,'btn-primary')]";
    private static final String PROCEED_BUTTON = "//button[contains(@class,'edp-submit-form-btn')]";
    private static final String APPLICATION_LANGUAGE = "//span[text()='%s']";
    private static final String BUILD_TOOL_DROPDOWN = "//select[@name='buildTool']";
    private static final String CONTINUE_BUTTON = "//button[@id='btn-modal-continue']";
    private static final String APPLICATION_STATUS = "//tr[@data-codebase-name='%s']";
    private static final String LANGUAGE_VERSION = "//label[@for='framework-%s']";
    private static final String AUTHENTICATION_CHECKBOX = "//label[@for='isRepoPrivate']";
    private static final String VERSIONING_TYPE_DROPDOWN = "//select[@id='versioningType']";
    private static final String START_VERSION_FIELD = "//input[@id='startVersioningFrom']";
    private static final String INTEGRATE_WITH_JIRA_CHECKBOX = "//input[@id='jiraServerToggle']";
    private static final String JIRA_SERVER = "//select[@name='jiraServer']";
    private static final String COMMIT_MESSAGE_PATTERN = "//input[@id='commitMessagePattern']";
    private static final String JIRA_TICKET_PATTERN = "//input[@id='ticketNamePattern']";
    private static final String NEW_BRANCH_NAME_INPUT = "//input[@id='branchName']";
    private static final String DEFAULT_BRANCH_NAME = "//input[@id='defaultBranchName']";
    private static final String USERNAME_FIELD = "//input[@id='username']";
    private static final String PASSWORD_FIELD = "//input[@id='password']";
    private static final String LOGIN_BUTTON = "//input[@id='kc-login']";
    private static final String FIRST_NAME_FIELD = "//input[@id='firstName']";
    private static final String LAST_NAME_FIELD = "//input[@id='lastName']";
    private static final String SUBMIT_BUTTON = "//input[contains(@class,'btn-block btn-lg')]";
    private static final String DELETE_CODEBASE_BUTTON = "//button[@class='delete delete-codebase']";
    private static final String CONFIRMATION_FIELD = "//input[@id='entity-name']";
    private static final String DELETE_CONFIRMATION_BUTTON = "//button[text()='Delete']";
    private static final String VCS_LINK = "//a[contains(@href,'gerrit-oc-green-edp')]";
    private static final String GERRIT_LINK = "//a[contains(@href,'gerrit-oc-green-edp')]";
    private static final String BROWSE_BUTTON = "";
    private static final String JENKINS_LINK = "//a[contains(@href,'jenkins-edp-delivery')]";
    private static final String OPENSHIFT_LINK = "//a[contains(@href,'master.delivery.aws')]";
    private static final String ENTIRES_DROPDOWN = "//select[@name='edp-table_length']";


    @Override
    public void enterNewBranchName(String newBranchName) {
        $x(NEW_BRANCH_NAME_INPUT).shouldBe(Condition.visible).sendKeys(newBranchName);
    }

    @Override
    public void specifyJiraTicketPattern(String jiraTicketPattern) {
        $x(JIRA_TICKET_PATTERN).shouldBe(Condition.visible).sendKeys(jiraTicketPattern);
    }

    @Override
    public void specifyCommitMessagePattern(String commitMessagePattern) {
        $x(COMMIT_MESSAGE_PATTERN).shouldBe(Condition.visible).sendKeys(commitMessagePattern);
    }

    @Override
    public void selectJiraServer(String jiraServer) {
        $x(JIRA_SERVER).shouldBe(Condition.visible).selectOptionContainingText(jiraServer);
        $x(JIRA_SERVER).shouldHave(Condition.exactValue(jiraServer));
    }

    @Override
    public void selectAmountOfEntires(String amountOfEntires) {
        $x(ENTIRES_DROPDOWN).shouldBe(Condition.visible).selectOptionContainingText(amountOfEntires);
        $x(ENTIRES_DROPDOWN).shouldHave(Condition.exactValue(amountOfEntires));
    }

    @Override
    public void checkIntegrateWithJiraCheckbox() {
        $x(INTEGRATE_WITH_JIRA_CHECKBOX).shouldBe(Condition.visible).click();
    }

    @Override
    public void selectVersioningType(String versioningType) {
        $x(VERSIONING_TYPE_DROPDOWN).shouldBe(Condition.visible).selectOptionContainingText(versioningType);
        $x(VERSIONING_TYPE_DROPDOWN).shouldHave(Condition.exactValue(versioningType));

    }

    @Override
    public void enterStartVersion(String startVersion) {
        $x(START_VERSION_FIELD).shouldBe(Condition.visible).setValue(startVersion);
    }

    @Override
    public void checkAuthenticationCheckbox() {
        $x(AUTHENTICATION_CHECKBOX).shouldBe(Condition.visible).click();
    }

    @Override
    public void selectLanguageVersion(String languageVersion) {
        $x(String.format(LANGUAGE_VERSION, languageVersion)).shouldBe(Condition.visible).click();
    }

    @Override
    public void applicationNameStatusShouldBeActive(String appName) {
        waitForPageReadyState();
        waitForAjaxToComplete();
        Selenide.refresh();
//        $x(String.format(APPLICATION_STATUS, appName)).hover().shouldHave(Condition.attribute("data-codebase-status", "active"));
        Predicate<SelenideElement> checkStatus = status -> {
            $x(String.format(APPLICATION_STATUS, appName)).shouldBe(Condition.visible);
            Selenide.refresh();
//            return Try.of(() -> StringUtils.equals($x(String.format(BRANCH_NAME, branchName)).getAttribute("data-branch-status"), "active")).isSuccess();
            return Try.of(() -> $x(String.format(APPLICATION_STATUS, appName)).shouldHave(Condition.attribute("data-codebase-status", "active"))).isSuccess();
        };
        new FlexWait<SelenideElement>(String.format("wait for success status of %s codebase", appName))
                .during(150000).tryTo(checkStatus).every(5000).executeWithoutResult();
    }

    @Override
    public void clickContinueButton() {
        waitForPageReadyState();
        waitForAjaxToComplete();
        Selenide.sleep(1_000);
        $x(CONTINUE_BUTTON).scrollIntoView(false).shouldBe(Condition.visible).click();
        Selenide.refresh();
    }

    @Override
    public void selectBuildTool(String buildTool) {
        $$x(BUILD_TOOL_DROPDOWN).filter(Condition.visible).first().selectOption(buildTool);
    }

    @Override
    public void selectCodebaseLanguage(String codebaseLanguage) {
        $x(String.format(APPLICATION_LANGUAGE, codebaseLanguage)).shouldBe(Condition.visible).click();
    }

    @Override
    public void openPage() {
        webDriverService.initWebDriver();
        getWebDriver().get(environmentConfig.getAdminConsoleUrl() + this.getClass().getAnnotation(CurrentUrl.class).value());
    }

    @Override
    public void enterUsername(String username) {
        $x(USERNAME_FIELD).shouldBe(Condition.visible).sendKeys(username);
    }

    @Override
    public void enterPassword(String password) {
        $x(PASSWORD_FIELD).shouldBe(Condition.visible).sendKeys(password);
    }

    @Override
    public void clickLoginButton() {
        $x(LOGIN_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void enterFirstName(String firstName) {
        $x(FIRST_NAME_FIELD).shouldBe(Condition.visible).sendKeys(firstName);
    }

    @Override
    public void enterLastName(String lastName) {
        $x(LAST_NAME_FIELD).shouldBe(Condition.visible).sendKeys(lastName);
    }

    @Override
    public void clickSubmitButton() {
        $x(SUBMIT_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickDeleteCodebaseButton() {
        Selenide.sleep(2_000);
        $x(DELETE_CODEBASE_BUTTON).shouldBe(Condition.visible).click();
    }


    @Override
    public void enterDefaultBranchName(String defaultBranchName) {
        $x(DEFAULT_BRANCH_NAME).shouldBe(Condition.visible).sendKeys(defaultBranchName);
    }

    @Override
    public void clickCreateButton() {
        waitForPageReadyState();
        waitForAjaxToComplete();
        Selenide.sleep(1_000);
        $$x(CREATE_BUTTON).filter(Condition.visible).first().click();
    }

    @Override
    public void clickProceedButton() {
        $$x(PROCEED_BUTTON).filter(Condition.visible).first().click();
    }

    @Override
    public void enterApplicationNameInConfirmationField(String applicationName) {
        $x(CONFIRMATION_FIELD).shouldBe(Condition.visible).sendKeys(applicationName);
    }

    @Override
    public void clickDeleteConfirmationButton() {
        Selenide.sleep(2_000);
        $x(DELETE_CONFIRMATION_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickVcsLink() {
        $x(VCS_LINK).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickGerritLink() {
        $x(GERRIT_LINK).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickJenkinsLink() {
        Selenide.sleep(1_000);
        $x(JENKINS_LINK).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickBrowseButton() {

    }

    @Override
    public void clickOpenShiftLink() {
        Selenide.sleep(1_000);
        $x(OPENSHIFT_LINK).shouldBe(Condition.visible).click();
    }
}
