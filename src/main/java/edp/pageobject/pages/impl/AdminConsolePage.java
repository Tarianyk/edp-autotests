package edp.pageobject.pages.impl;

import com.codeborne.selenide.Condition;
import edp.core.annotations.CurrentUrl;
import edp.core.annotations.Page;
import edp.pageobject.pages.interfaces.IAdminConsolePage;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import static com.codeborne.selenide.Selenide.$x;

@Lazy
@Page
@Scope("prototype")
@CurrentUrl("/admin/edp/overview")
public class AdminConsolePage extends AbstractBasePage implements IAdminConsolePage {
    private static final String APPLICATION_TAB = "//i[@class='icon-apps']//following-sibling::span";
    private static final String LIBRARIES_TAB = "//span[text()='LIBRARIES']";
    private static final String CONTINUOUS_DELIVERY_TAB = "//span[text()='CONTINUOUS DELIVERY']";
    private static final String OVERVIEW_TAB = "//i[@class='icon-dashboard']//following-sibling::span";
    private static final String AUTOTESTS_TAB = "//span[text()='AUTOTESTS']";


    @Override
    public void clickOnContinuousDeliveryTab() {
        $x(CONTINUOUS_DELIVERY_TAB).scrollIntoView(false).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickOnLibrariesTab() {
        $x(LIBRARIES_TAB).click();
    }

    @Override
    public void clickOnApplicationTab() {
        $x(APPLICATION_TAB).click();
    }

    @Override
    public void clickOnOverviewTab() {
        $x(OVERVIEW_TAB).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickOnAutotestsTab() {
        $x(AUTOTESTS_TAB).shouldBe(Condition.visible).click();
    }
}
