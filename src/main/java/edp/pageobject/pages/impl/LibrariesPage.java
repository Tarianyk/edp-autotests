package edp.pageobject.pages.impl;

import edp.core.annotations.Page;
import edp.pageobject.pages.interfaces.ILibrariesPage;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Lazy
@Page
@Scope("prototype")
public class LibrariesPage extends AbstractBasePage implements ILibrariesPage {

}
