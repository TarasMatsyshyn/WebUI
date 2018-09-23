package tests;

import businessLogic.businessLogic.bo.BaseGmailBO;
import businessLogic.models.MailModel;
import businessLogic.po.MainBasePagePO;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendMessageTest extends BaseGmailTest {

    private final static Logger logger = Logger.getLogger(SendMessageTest.class);
    private BaseGmailBO baseGmailBO = new BaseGmailBO();
    private MailModel mail;
    private String subject = String.format("@%s %s", this.getClass().getName(), super.timeStamp);


    @Test
    public void sendTestMsg() {
        mail = new MailModel(new String[]{"taras.matsyshyn@gmail.com"}, subject, "Test");

        baseGmailBO
                .act_createMsg(mail)
                .act_sendMsg()
                .act_openSentMail(subject)
        ;

        Assert.assertEquals(mail.getMessageBody(), baseGmailBO.get_currentMailModel().getMessageBody());
        Assert.assertEquals(mail.getSubject(), baseGmailBO.get_currentMailModel().getSubject());
    }

}
