package businessLogic.businessLogic.bo;

import businessLogic.models.MailModel;
import businessLogic.po.EmailPage;
import businessLogic.po.MainPage;
import businessLogic.po.PasswordPage;


public class BaseGmailBO {

    private EmailPage emailPage = new EmailPage();
    private PasswordPage passwordPage = new PasswordPage();
    private MainPage mainPage = new MainPage();

    public BaseGmailBO act_login(String email, String password) {
        emailPage
                .setLogin(email)
                .clickNextBtn();
        passwordPage
                .setPassword(password)
                .clickNextBtn();
        return this;
    }

    public BaseGmailBO act_createMsg(MailModel mail){
        mainPage
                .act_clickCompose()
                .act_fillReceivers(mail.getRecipientsString())
                .act_fillSubject(mail.getSubject())
                .act_fillMsgBody(mail.getMessageBody());
        return this;
    }

    public BaseGmailBO act_sendMsg(){
        mainPage.act_clickSendMsg();
        return this;
    }

    public BaseGmailBO ver_msgBody(){

        return this;
    }






}
