package edp.core.config.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import edp.core.config.TestConfiguration;

@Component
public class TestConfigurationSupplier {

    @Autowired
    private TestConfiguration testConfiguration;

    @PostConstruct
    public void init() {ITestConfigurationSupplier.TestConfigurationInitialization.setTestConfiguration(testConfiguration);}
}
