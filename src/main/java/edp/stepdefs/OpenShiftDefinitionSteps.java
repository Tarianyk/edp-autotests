package edp.stepdefs;

import edp.core.config.TestConfiguration;
import edp.pageobject.pages.interfaces.IOpenShift;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class OpenShiftDefinitionSteps {
    @Autowired
    private IOpenShift openShift;
    @Autowired
    private TestConfiguration testConfiguration;

    @And("User clicks 'Resources' button")
    public void userClicksResourcesButton() {
        openShift.clickResourcesButton();
    }

    @And("User clicks 'SSO' button")
    public void userClicksSsoButton() {
        openShift.clickSsoButton();
    }

    @And("User clicks 'Secrets' button")
    public void userClicksSecretsButton() {
        openShift.clickSecretsButton();
    }

    @And("User clicks 'Add to Project' button")
    public void userClicksAddToProjectButton() {
        openShift.clickAddToProjectButton();
    }

    @And("User selects 'Import YAML  JSON' option")
    public void userSelectsYamlJsonOption() {
        openShift.selectYamlJsonOption();
    }

    @And("User enters {string} Gitlab ssh key")
    public void userEntersGitlabSshKey(final String sshKey) {
        String gitlabSshKeyYaml = testConfiguration.getEnvironmentConfig().getGitlabSshKeyYaml();
        openShift.enterGitlabSshKey(gitlabSshKeyYaml);
    }

    @And("User clicks 'Create secret' button")
    public void userClicksCreateSecretButton() {
        openShift.clickCreateSecretButton();
    }

    @And("User enters {string} Gitlab git server")
    public void userEntersGitlabGitServer(final String gitServer) {
        String gitlabGitServer = testConfiguration.getEnvironmentConfig().getGitlabGitServer();
        openShift.enterGitlabGitServer(gitlabGitServer);
    }

    @And("User clicks 'Create Anyway' button")
    public void userClicksCreateAnywayButton() {
        openShift.clickCreateAnywayButton();
    }
}
