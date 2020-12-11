package edp.core.driver.providers.capabilities.factory;

import edp.core.annotations.CapabilitiesProvider;
import edp.core.annotations.DriverCapabilities;
import edp.core.config.TestConfiguration;
import edp.core.driver.interfaces.ICapabilitiesProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

@CapabilitiesProvider
@DriverCapabilities(identifier = "capabilities")
public class ChromeCapabilitiesProvider implements ICapabilitiesProvider {

    @Autowired
    protected TestConfiguration config;

    @Override
    public Capabilities provideCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions chromeOptions = new ChromeOptions();
        capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        capabilities.setCapability("enableVNC", true);
        chromeOptions.addArguments(Arrays.asList("--allow-running-insecure-content", "--ignore-certificate-errors",
                "--disable-popup-blocking", "--disable-dev-shm-usage", "--no-sandbox", "--disable-gpu"));
        chromeOptions.addArguments("--test-type");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        return capabilities;
    }
}
