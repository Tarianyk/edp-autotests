package edp.core.driver;

import com.codeborne.selenide.WebDriverRunner;
import edp.core.annotations.DriverService;
import edp.core.driver.interfaces.IWebDriverProvider;
import edp.core.driver.interfaces.IWebDriverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

@Lazy
@Slf4j
@DriverService
public class WebDriverService implements IWebDriverService, DisposableBean, InitializingBean {

    @Autowired
    private IWebDriverProvider driverProvider;

    private boolean isFirstInitialize = true;

    @Override
    public void initWebDriver() {log.info("WebDriver has been initialized");}

    private void destroyWebDriver() { WebDriverRunner.getWebDriver().quit();}

    private void maximizeBrowser() {WebDriverRunner.getWebDriver().manage().window().maximize();}

    @Override
    public void destroy() {destroyWebDriver();}

    @Override
    public void afterPropertiesSet() {
        if (isFirstInitialize) {
           WebDriverRunner.setWebDriver(driverProvider.createWebDriver());
           maximizeBrowser();
           WebDriverRunner.getWebDriver().manage().deleteAllCookies();
           WebDriverRunner.clearBrowserCache();
           isFirstInitialize = false;
        }
    }
}
