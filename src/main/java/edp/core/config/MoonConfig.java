package edp.core.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@EnableAutoConfiguration
public class MoonConfig {

    @Getter
    @Value("${browser.type:remote}")
    private String browserType;

    @Getter
    @Value("${browser.name}")
    private String browserName;

    @Getter
    @Value("${version}")
    private String version;

    @Getter
    @Value("${moon.url}")
    private String moonUrl;

}
