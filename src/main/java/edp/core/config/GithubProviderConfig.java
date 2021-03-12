package edp.core.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import edp.core.model.autotestintegration.Secrets;
import edp.core.service.interfaces.INativeResource;
import edp.utils.strings.Strings;
import io.fabric8.kubernetes.api.model.Secret;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

import static edp.utils.consts.AutotestIntegration.AUTOTEST_INTEGRATION_SECRET_NAME;

@Getter
@Configuration
@EnableAutoConfiguration
public class GithubProviderConfig {

    @Autowired
    private INativeResource nativeResource;

    @Value("${namespace}")
    private String targetNamespace;

    @Getter
    private String username;

    @Getter
    private String password;

    @Getter
    private String token;

    @Autowired
    private RepositoryPathsConfig repositoryPathsConfig;

    @PostConstruct
    public void init() throws JsonProcessingException {
        Secret secret = nativeResource.GetSecret(AUTOTEST_INTEGRATION_SECRET_NAME, targetNamespace);
        Secrets secrets = Secrets.getSecrets(secret);
        username = Strings.encodeValue(secrets.getGithub().getUsername());
        password = Strings.encodeValue(secrets.getGithub().getPassword());
        token = Strings.encodeValue(secrets.getGithub().getToken());
    }

}
