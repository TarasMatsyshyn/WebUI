package businessLogic.businessLogic.bo;

import businessLogic.models.MailModel;
import businessLogic.po.*;


public class BaseGmailBO {

    private LoginPagePO loginPage = new LoginPagePO();
    private PasswordPagePO passwordPage = new PasswordPagePO();
    private MainBasePagePO mainPage = new MainBasePagePO();
    private OpenMailPO openMail = new OpenMailPO();
    private NavigationPanel navigationPanel = new NavigationPanel();
    private MailPanel messagePanel = new MailPanel();

    public BaseGmailBO act_login(String email, String password) {
        loginPage
                .setLogin(email)
                .clickNextBtn();
        passwordPage
                .setPassword(password)
                .clickNextBtn();
        return this;
    }

    public BaseGmailBO act_createMsg(MailModel mail){
        navigationPanel
                .act_clickComposeBtn();
        mainPage
                .act_fillMailReceivers(mail.getRecipientsString())
                .act_fillMailSubject(mail.getSubject())
                .act_fillMailMsgBody(mail.getMessageBody());
        return this;
    }

    public BaseGmailBO act_sendMsg(){
        mainPage.act_clickSendMailBtn();
        return this;
    }

    public BaseGmailBO act_openSentMail(String subject) {
        navigationPanel.act_clickSentMailBtn();
        messagePanel.act_openMailBySubject(subject);
        return this;
    }

    public MailModel get_currentMailModel(){
        return new MailModel(new String[]{}, openMail.get_mailSubject(), openMail.get_mailBody());
    }

}
