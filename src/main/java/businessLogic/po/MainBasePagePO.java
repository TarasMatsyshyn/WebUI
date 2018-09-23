package businessLogic.po;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class MainBasePagePO extends BasePageObject {

    private final static Logger logger = Logger.getLogger(MainBasePagePO.class);

    //Buttons
    @FindBy(xpath = "//div[text()='Send']")
    private WebElement btnSend;
    //Msg creation
    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement ipfTo;
    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement ipfSubject;
    @FindBy(xpath = "//div[@aria-label='Message Body']")
    private WebElement ipfMsgBody;

    public MainBasePagePO act_fillMailReceivers(String receivers) {
        ipfTo.sendKeys(receivers);
        logger.info(String.format("%s typed to 'Receivers' input field", receivers));
        return this;
    }

    public MainBasePagePO act_fillMailSubject(String subject) {
        ipfSubject.sendKeys(subject);
        logger.info(String.format("%s typed to 'Subject' input field", subject));
        return this;
    }

    public MainBasePagePO act_fillMailMsgBody(String msgBody) {
        ipfMsgBody.sendKeys(msgBody);
        logger.info(String.format("%s typed to 'Message body' input field", msgBody));
        return this;
    }

    public MainBasePagePO act_clickSendMailBtn() {
        btnSend.click();
        logger.info("Was clicked on 'Send' button");
        return this;
    }

}
