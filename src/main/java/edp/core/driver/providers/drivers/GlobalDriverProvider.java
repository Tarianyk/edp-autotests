package edp.core.driver.providers.drivers;

import edp.core.annotations.DriverProvider;
import edp.core.config.TestConfiguration;
import edp.core.driver.interfaces.ICapabilitiesFactory;
import edp.core.driver.interfaces.IWebDriverProvider;
import edp.core.exceptions.TAFRuntimeException;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.vavr.control.Try;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.Objects;

import static io.vavr.API.*;

@DriverProvider
public class GlobalDriverProvider implements IWebDriverProvider {

    @Autowired
    private ICapabilitiesFactory factory;

    @Autowired
    private TestConfiguration config;

    @Override
    public WebDriver createWebDriver() {
        if (Objects.isNull(config.getBrowserName())) {
            throw new TAFRuntimeException("Browser isn't selected. Add step 'Configure 'browserName' for opening page'");
        }

        return Match(config.getBrowserType()).of(
                Case($("local"), this::getLocalDriverByBrowserName),
                Case($("remote"), () -> Try.of(
                        () -> new RemoteWebDriver(new URL(System.getProperty("hub.host")+ ':' +
                                config.getGridHubPort() + "/wd/hub"), createCapabilities()))
                        .getOrElseThrow(exception -> new TAFRuntimeException("Unable to create remote web driver", exception)))
        );
    }
    private WebDriver getLocalDriverByBrowserName() {
        return Match(config.getBrowserName()).of(
                Case($("chrome"), () -> {
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver(new ChromeOptions().merge(createCapabilities()));
                }),
                Case($("firefox"), () -> {
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver(new FirefoxOptions().merge(createCapabilities()));
                }),
                Case($("ie"), () -> {
                    WebDriverManager.iedriver().setup();
                    return new InternetExplorerDriver(new InternetExplorerOptions().merge(createCapabilities()));
                })

        );
    }

    private Capabilities createCapabilities() {
        DesiredCapabilities capabilities = (DesiredCapabilities) factory.getCapabilities();
        return capabilities;
    }
}
