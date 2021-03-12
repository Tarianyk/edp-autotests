package edp.core.config;

import edp.core.config.factory.CommonPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Data
@PropertySource(
        value = "classpath:application.yml",
        factory = CommonPropertySourceFactory.class
)
@EnableConfigurationProperties(RepositoryPathsConfig.class)
@ConfigurationProperties("repository-paths")
public class RepositoryPathsConfig {
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
    private String petclinicBeRepoUrlGitlab;
    private String petclinicFeRepoUrlGitlab;
    private String petclinicAutotestsUrlGitlab;
    private String petclinicDeployUrl;
    private String terraformRepoUrlGitlab;
    private String terraformRepoUrlGithub;
}
