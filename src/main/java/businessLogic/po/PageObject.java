package businessLogic.po;

import core.chromeDriver.SingletonChromeConnection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    public PageObject(WebDriver driver) {
        WebDriver instance = SingletonChromeConnection.getDriver();
        PageFactory.initElements(instance, this);
    }

    public PageObject() {
        this(SingletonChromeConnection.getDriver());
    }
}
