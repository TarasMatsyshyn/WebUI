package tests;

import businessLogic.businessLogic.bo.BaseGmailBO;
import businessLogic.models.MailModel;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static core.chromeDriver.SingletonChromeConnection.getDriver;
import static core.propertiesParser.PropertiesParser.getProperty;

public class SendMessageTest extends BaseGmailTest {

    private final static Logger logger = Logger.getLogger(SendMessageTest.class);
    private BaseGmailBO baseGmailBO = new BaseGmailBO();
    private MailModel mail;
    private String subject = String.format("@%s %s", this.getClass().getName(), super.timeStamp);


    @Test
    public void sendTestMsg() {
        getDriver().navigate().to(getProperty("base.url"));
        mail = new MailModel(new String[]{"taras.matsyshyn@gmail.com"}, subject, "Test");
        baseGmailBO
                .act_login(getProperty("base.login"), getProperty("base.password"))
                .act_createMsg(mail)
                .act_sendMsg();
        publishEvent();
        baseGmailBO
                .act_openSentMail(subject);

        Assert.assertEquals(mail.getMessageBody(), baseGmailBO.get_currentMailModel().getMessageBody());
        Assert.assertEquals(mail.getSubject(), baseGmailBO.get_currentMailModel().getSubject());
    }

    @Test
    public void readTestMsg(){
        getDriver().navigate().to(getProperty("base.url"));
        baseGmailBO
                .act_login(getProperty("addition.login"), getProperty("addition.password"));
        waitForEvent();

    }

}
