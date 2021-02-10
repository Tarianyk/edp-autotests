package edp.core.config.interfaces;

import edp.core.config.EnvironmentConfig;
import edp.core.config.SecretsConfig;
import edp.core.config.TestConfiguration;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public interface ITestConfigurationSupplier {

    static EnvironmentConfig getEnvironment() {
        return TestConfigurationInitialization.getTestConfiguration().getEnvironmentConfig();
    }

    static SecretsConfig getSecretsConfig() {
        return TestConfigurationInitialization.getTestConfiguration().getSecretsConfig();
    }


    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    class TestConfigurationInitialization {
        @Getter
        @Setter
        protected static TestConfiguration testConfiguration;
    }

}
