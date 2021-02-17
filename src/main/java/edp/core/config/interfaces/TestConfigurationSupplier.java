package edp.core.config.interfaces;

import edp.core.config.TestConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestConfigurationSupplier {

    @Autowired
    private TestConfiguration testConfiguration;

    @PostConstruct
    public void init() {ITestConfigurationSupplier.TestConfigurationInitialization.setTestConfiguration(testConfiguration);}
}
