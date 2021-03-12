package edp.core.driver.providers.drivers;

import edp.core.annotations.DriverProvider;
import edp.core.config.MoonConfig;
import edp.core.driver.interfaces.ICapabilitiesFactory;
import edp.core.driver.interfaces.IWebDriverProvider;
import edp.core.exceptions.TAFRuntimeException;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;
import java.util.Objects;

import static io.vavr.API.*;

@Slf4j
@DriverProvider
public class GlobalDriverProvider implements IWebDriverProvider {

    @Autowired
    private ICapabilitiesFactory factory;

    @Autowired
    private MoonConfig moonConfig;

    @Override
    public WebDriver createWebDriver() {
        log.info("creating web driver");
        if (Objects.isNull(moonConfig.getBrowserName())) {
            throw new TAFRuntimeException("Browser isn't selected. Add step 'Configure 'browserName' for opening page'");
        }

        return Match(moonConfig.getBrowserType()).of(
                Case($("local"), this::getLocalDriverByBrowserName),
                Case($("remote"), () -> Try.of(
                        () -> new RemoteWebDriver(
                                URI.create(moonConfig.getMoonUrl()).toURL(),
                                createCapabilities()
                        ))
                        .getOrElseThrow(exception -> new TAFRuntimeException("Unable to create remote web driver", exception)))
        );
    }

    private WebDriver getLocalDriverByBrowserName() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(new ChromeOptions().merge(createCapabilities()));
    }

    private Capabilities createCapabilities() {
        DesiredCapabilities capabilities = (DesiredCapabilities) factory.getCapabilities();
        return capabilities;
    }
}
