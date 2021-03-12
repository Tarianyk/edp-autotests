package edp.core.config;

import edp.consts.ResourceNames;
import edp.core.cache.TestCache;
import edp.core.enums.testcachemanagement.TestCacheKey;
import edp.core.service.interfaces.ICodebaseResource;
import edp.core.service.interfaces.IEdpComponentResource;
import edp.core.service.interfaces.INativeResource;
import io.fabric8.kubernetes.api.model.Secret;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Data
@ComponentScan(basePackages = {"edp.*"})
@Configuration
@ConfigurationPropertiesScan(basePackages = "edp.*")
@EnableAutoConfiguration
@ToString
public class EnvironmentConfig {

    @Autowired
    private IEdpComponentResource edpComponentResource;

    @Autowired
    private ICodebaseResource codebaseResource;

    @Value("${namespace}")
    private String namespace;

    private String adminConsoleUrl;
    private String keycloakUrl;

    private String privatSshKey;
    private String gitlabProvisionerCode;
    private String gitlabSshKeyYaml;
    private String gitlabGitServer;

    @PostConstruct
    public void init() {
        this.adminConsoleUrl = edpComponentResource.GetEdpComponent(ResourceNames.EDP_ADMIN_CONSOLE_EDP_COMPONENT_NAME)
                .getSpec()
                .getUrl();
        this.keycloakUrl = edpComponentResource.GetEdpComponent(ResourceNames.KEYCLOAK_EDP_COMPONENT_NAME)
                .getSpec()
                .getUrl();
    }

}
