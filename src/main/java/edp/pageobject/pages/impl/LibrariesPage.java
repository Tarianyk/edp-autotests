package edp.pageobject.pages.impl;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import edp.core.annotations.Page;
import edp.pageobject.pages.interfaces.ILibrariesPage;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import static com.codeborne.selenide.Selenide.$x;

@Lazy
@Page
@Scope("prototype")
public class LibrariesPage extends AbstractBasePage implements ILibrariesPage {

}
