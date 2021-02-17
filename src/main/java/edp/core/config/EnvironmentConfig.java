package edp.core.config;

import edp.core.config.factory.YamlPropertySourceFactory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@PropertySource(
        value = "${config.location}",
        factory = YamlPropertySourceFactory.class
)
@EnableConfigurationProperties(EnvironmentConfig.class)
@ConfigurationProperties("environment-config")
public class EnvironmentConfig {

    private String adminConsoleUrl;
    private String keycloakUrl;
    private String kubernetesUrl;
    private String java8RepoUrlGitlab;
    private String java8GradleRepoUrlGitlab;
    private String java11RepoUrlGitlab;
    private String java11MavenRepoUrlGitlab;
    private String dotnet31RepoUrlGitlab;
    private String dotnet21RepoUrlGitlab;
    private String python38RepoUrlGitlab;
    private String javascriptRepoUrlGitlab;
    private String goBeegoRepoUrlGitlab;
    private String goOperatorSdkUrlGitlab;
    private String java8MultimoduleGitlab;
    private String java11MultimoduleGitlab;
    private String terraformRepoUrlGitlab;
    private String GitlabRepositoryLogin;
    private String GitlabRepositoryPassword;
    private String githubRepositoryLogin;
    private String githubRepositoryPassword;
    private String java8MavenRepoUrlGithub;
    private String java8GradleRepoUrlGithub;
    private String java11MavenRepoUrlGithub;
    private String java11GradleRepoUrlGithub;
    private String java8MultimoduleGithub;
    private String java11MultimoduleGithub;
    private String goBeegoRepoUrlGithub;
    private String goOperatorSdkUrlGithub;
    private String javascriptRepoUrlGithub;
    private String python38RepoUrlGithub;
    private String dotnet31RepoUrlGithub;
    private String dotnet21RepoUrlGithub;
    private String terraformRepoUrlGithub;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String gitlabApiToken;
    private String privatSshKey;
    private String githubSecretToken;
    private String gitlabSshKeyYaml;
    private String gitlabGitServer;
    private String petclinicBeRepoUrlGitlab;
    private String petclinicFeRepoUrlGitlab;
    private String petclinicAutotestsUrlGitlab;
    private String petclinicDeployUrl;

}
