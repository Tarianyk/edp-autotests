package edp.core.utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.support.ui.WebDriverWait;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WaitingUtils {
    public static void waitForAjaxToComplete() {
        new WebDriverWait(WebDriverRunner.getWebDriver(), 30).until(driver ->
                Selenide.executeJavaScript("return window.jQuery != undefined && jQuery.active == 0"));
    }
    public static void waitForPageReadyState() {
        new WebDriverWait(WebDriverRunner.getWebDriver(), 30).until(driver ->
                "complete".equals(Selenide.executeJavaScript("return document.readyState")));
    }
    public static boolean waitForUrlContainsLink(final String link) {
        return new WebDriverWait(WebDriverRunner.getWebDriver(), 30).until(driver ->
                driver.getCurrentUrl().contains(link));
    }
}
