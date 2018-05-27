package pages.helpers;

import org.openqa.selenium.support.PageFactory;

public class PageObject {

    protected PageObject() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
