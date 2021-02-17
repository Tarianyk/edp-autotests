package edp.pageobject.pages.impl;

import com.codeborne.selenide.Condition;
import edp.core.annotations.Page;
import edp.pageobject.pages.interfaces.IAutotestsPage;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import static com.codeborne.selenide.Selenide.$x;

@Lazy
@Page
@Scope("prototype")

public class AutotestsPage extends AbstractBasePage implements IAutotestsPage {
    private static final String AUTOTESTS_DESCRIPTION_FIELD = "//input[@id='description']";
    private static final String TEST_REPORT_FRAMEWORK = "//select[@name='testReportFramework']";

    @Override
    public void enterAutotestDescription(String autotestDescription) {
        $x(AUTOTESTS_DESCRIPTION_FIELD).shouldBe(Condition.visible).sendKeys(autotestDescription);
    }

    @Override
    public void selectTestReportFramework(String testReportFramework) {
        $x(TEST_REPORT_FRAMEWORK).shouldBe(Condition.visible).selectOptionByValue(testReportFramework);
        $x(TEST_REPORT_FRAMEWORK).shouldHave(Condition.exactValue(testReportFramework));
    }
}
