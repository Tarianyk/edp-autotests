package edp.core.config;

import edp.core.config.factory.CommonPropertySourceFactory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@PropertySource(
        value = "classpath:secrets.yml",
        factory = CommonPropertySourceFactory.class
)
@EnableConfigurationProperties(SecretsConfig.class)
@ConfigurationProperties("secrets-config")

public class SecretsConfig {
    private String clientSecret;
    private String acCreatorPassword;
    private String userName;
    private String clientId;
    private String grantType;
}
