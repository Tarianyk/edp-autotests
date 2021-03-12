package edp.stepdefs;

import edp.core.config.EnvironmentConfig;
import edp.pageobject.pages.interfaces.IKubernetes;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class KubernetesDefinitionSteps {

    @Autowired
    private IKubernetes kubernetes;

    @Autowired
    private EnvironmentConfig environmentConfig;

    @And("User clicks 'Resources' button")
    public void userClicksResourcesButton() {
        kubernetes.clickResourcesButton();
    }

    @And("User clicks 'SSO' button")
    public void userClicksSsoButton() {
        kubernetes.clickSsoButton();
    }

    @And("User clicks 'Secrets' button")
    public void userClicksSecretsButton() {
        kubernetes.clickSecretsButton();
    }

    @And("User clicks 'Add to Project' button")
    public void userClicksAddToProjectButton() {
        kubernetes.clickAddToProjectButton();
    }

    @And("User selects 'Import YAML  JSON' option")
    public void userSelectsYamlJsonOption() {
        kubernetes.selectYamlJsonOption();
    }

    @And("User enters {string} Gitlab ssh key")
    public void userEntersGitlabSshKey(final String sshKey) {
        String gitlabSshKeyYaml = environmentConfig.getGitlabSshKeyYaml();
        kubernetes.enterGitlabSshKey(gitlabSshKeyYaml);
    }

    @And("User clicks 'Create secret' button")
    public void userClicksCreateSecretButton() {
        kubernetes.clickCreateSecretButton();
    }

    @And("User enters {string} Gitlab git server")
    public void userEntersGitlabGitServer(final String gitServer) {
        String gitlabGitServer = environmentConfig.getGitlabGitServer();
        kubernetes.enterGitlabGitServer(gitlabGitServer);
    }

    @And("User clicks 'Create Anyway' button")
    public void userClicksCreateAnywayButton() {
        kubernetes.clickCreateAnywayButton();
    }
}
