package edp.stepdefs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import edp.core.config.TestConfiguration;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;

import static edp.core.cache.TestCache.initializeTestCache;
import static edp.engine.httpclient.SecureClientInitializer.setDefaultSecureHttpClient;

@Slf4j
@DirtiesContext
@SpringBootTest
@ContextConfiguration(classes = TestConfiguration.class)
public class CucumberHook extends AbstractJUnit4SpringContextTests {

    @Autowired
    private TestConfiguration testConfiguration;

    @Before(order = 1)
    public void preSetUp() {
        initializeTestCache(testConfiguration);
        Configuration.timeout=30_000;
        Configuration.fastSetValue = true;
        Configuration.screenshots = false;
        Configuration.savePageSource = false;
        Configuration.pageLoadStrategy = "eager";
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(false));
        setDefaultSecureHttpClient();
    }

}
