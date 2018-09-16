package tests;

import businessLogic.businessLogic.bo.BaseGmailBO;
import businessLogic.models.MailModel;
import businessLogic.po.EmailPage;
import businessLogic.po.MainPage;
import businessLogic.po.PasswordPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static core.chromeDriver.SingletonChromeConnection.getDriver;
import static core.propertiesParser.PropertiesParser.getProperty;

public class TestFirstRun extends BaseGmailTest {

    private EmailPage emailPage = new EmailPage();
    private PasswordPage passwordPage = new PasswordPage();
    private MainPage mainPage = new MainPage();
    private BaseGmailBO baseGmailBO = new BaseGmailBO();

    private MailModel mail;

    @BeforeTest
    public void login() {
        getDriver().navigate().to(getProperty("base.url"));
        baseGmailBO.act_login(getProperty("base.login"), getProperty("base.password"));
        mail = new MailModel(new String [] {"taras.matsyshyn@gmail.com"}, "Test", "Test");
     }

    @Test
    public void sendTestMsg() {
        baseGmailBO
                .act_createMsg(mail)
                .act_sendMsg();
    }

}
