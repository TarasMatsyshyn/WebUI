package tests;

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

    @BeforeTest
    public void firstRun() {
        getDriver().navigate().to(getProperty("base.url"));
        emailPage
                .setLogin(getProperty("base.login"))
                .clickNextBtn();
        passwordPage
                .setPassword(getProperty("base.password"))
                .clickNextBtn();
     }

    @Test
    public void sendTestMsg() {
//        mainPage
//                .act_clickCompose()
//                .act_fillReceivers("qwertyu");
    }

}
