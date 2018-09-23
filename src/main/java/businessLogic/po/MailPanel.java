package businessLogic.po;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static core.chromeDriver.SingletonChromeConnection.getDriver;

public class MailPanel extends BasePageObject {

    private final static Logger logger = Logger.getLogger(MainBasePagePO.class);

    public MailPanel act_openMailBySubject(String subject) {
        getDriver().findElement(By.xpath(String.format("//span[text()='%s']", subject))).click();
        logger.info(String.format("Was clicked on %s subject", subject));
        return this;
    }

}
