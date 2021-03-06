package businessLogic.po;

import core.chromeDriver.SingletonChromeConnection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePO {

    public BasePO(WebDriver driver) {
        WebDriver instance = SingletonChromeConnection.getDriver();
        PageFactory.initElements(instance, this);
    }

    public BasePO() {
        this(SingletonChromeConnection.getDriver());
    }
}
