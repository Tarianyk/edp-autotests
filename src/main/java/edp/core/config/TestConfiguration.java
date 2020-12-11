package edp.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@ComponentScan(basePackages = {"edp.*"})
@Configuration
@ConfigurationPropertiesScan(basePackages = "edp.*")
@EnableAutoConfiguration
public class TestConfiguration {

    @Getter
    @Autowired
    private EnvironmentConfig environmentConfig;

    @Getter
    @Value("${browser.type}")
    private String browserType;

    @Getter
    @Value("${browser.name}")
    private String browserName;

    public int getGridHubPort() {
        return 0;
    }

}
