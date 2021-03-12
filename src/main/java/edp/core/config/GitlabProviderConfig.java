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
public class GitlabProviderConfig {

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

    @Getter
    private String idRsaPub;

    @Getter
    private String idRsa;

    @PostConstruct
    public void init() throws JsonProcessingException {
        Secret secret = nativeResource.GetSecret(AUTOTEST_INTEGRATION_SECRET_NAME, targetNamespace);
        Secrets secrets = Secrets.getSecrets(secret);
        username = Strings.encodeValue(secrets.getGitlab().getUsername());
        password = Strings.encodeValue(secrets.getGitlab().getPassword());
        token = Strings.encodeValue(secrets.getGitlab().getToken());
        idRsaPub = Strings.encodeValue(secrets.getGitlab().getIdRsaPub());
        idRsa = Strings.encodeValue(secrets.getGitlab().getIdRsa());
    }

}
