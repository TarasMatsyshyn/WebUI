package businessLogic.po;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenMailPO extends BasePageObject {

    private final static Logger logger = Logger.getLogger(OpenMailPO.class);

    @FindBy(xpath = "//div[@class='ha']")
    private WebElement lblSubject;
    @FindBy(xpath = "//div[@class='ii gt']//div[@dir='ltr']")
    private WebElement lblText;

    public String get_mailSubject(){
        return lblSubject.getText();
    }

    public String get_mailBody(){
        return lblText.getText();
    }


}
