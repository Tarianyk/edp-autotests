package edp.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import edp.core.config.factory.YamlPropertySourceFactory;
import lombok.Getter;
import lombok.Setter;

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
    private String java8RepoUrlGitlab;
    private String java11RepoUrlGitlab;
    private String dotnet31RepoUrlGitlab;
    private String python38RepoUrlGitlab;
    private String javascriptRepoUrlGitlab;
    private String goBeegoRepoUrlGitlab;
    private String goOperatorSdkUrlGitlab;
    private String dotnet21RepoUrlGitlab;
    private String GitlabRepositoryLogin;
    private String GitlabRepositoryPassword;
    private String githubRepositoryLogin;
    private String githubRepositoryPassword;
    private String java8MavenRepoUrlGithub;
    private String javascriptRepoUrlGithub;
    private String python38RepoUrlGithub;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String gitlabApiToken;
    private String privatSshKey;
    private String githubSecretToken;
    private String gitlabProvisionerCode;
    private String gitlabSshKeyYaml;
    private String gitlabGitServer;
    private String  petclinicBeRepoUrlGitlab;
    private String petclinicFeRepoUrlGitlab;
    private String petclinicAutotestsUrlGitlab;
    private String petclinicDeployUrl;
}
