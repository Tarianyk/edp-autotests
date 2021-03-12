package edp.core.driver.providers.capabilities.factory;

import edp.core.annotations.DriverCapabilities;
import edp.core.annotations.Factory;
import edp.core.config.MoonConfig;
import edp.core.driver.interfaces.ICapabilitiesFactory;
import edp.core.driver.interfaces.ICapabilitiesProvider;
import edp.core.exceptions.TAFRuntimeException;
import org.openqa.selenium.Capabilities;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Factory
public class CapabilitiesFactory implements ICapabilitiesFactory {

    @Autowired
    private MoonConfig moonConfig;

    @Autowired
    @DriverCapabilities(identifier = "capabilities")
    private Map<String, ICapabilitiesProvider> capabilities;

    @Override
    public Capabilities getCapabilities() {
        return capabilities.entrySet().stream().filter(entry -> entry.getKey().toLowerCase().contains(moonConfig.getBrowserName())).
                map(entry -> entry.getValue().provideCapabilities()).findFirst().orElseThrow(() -> new TAFRuntimeException(
                String.format("Capabilities are empty for browser %s", moonConfig.getBrowserName())));
    }
}
