package edp.pageobject.pages.interfaces;

public interface IKubernetes {

    void clickResourcesButton();

    void clickSsoButton();

    void clickSecretsButton();

    void clickAddToProjectButton();

    void selectYamlJsonOption();

    void enterGitlabSshKey(String sshKey);

    void clickCreateSecretButton();

    void enterGitlabGitServer(String gitlabGitServer);

    void clickCreateAnywayButton();

}
