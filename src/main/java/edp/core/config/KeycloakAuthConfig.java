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
public class KeycloakAuthConfig {

    @Autowired
    private INativeResource nativeResource;

    @Value("${namespace}")
    private String targetNamespace;

    private String userName;

    private String firstName;

    private String lastName;

    private String password;

    private String clientId;

    private String acCreatorId;

    @PostConstruct
    public void init() throws JsonProcessingException {
        Secret secret = nativeResource.GetSecret(AUTOTEST_INTEGRATION_SECRET_NAME, targetNamespace);
        Secrets secrets = Secrets.getSecrets(secret);
        userName = Strings.encodeValue(secrets.getKeycloak().getUsername());
        firstName = Strings.encodeValue(secrets.getKeycloak().getFirstName());
        lastName = Strings.encodeValue(secrets.getKeycloak().getLastName());
        password = Strings.encodeValue(secrets.getKeycloak().getPassword());
        clientId = secrets.getKeycloak().getClientId();
        acCreatorId = secrets.getKeycloak().getAcCreatorId();
    }

}
