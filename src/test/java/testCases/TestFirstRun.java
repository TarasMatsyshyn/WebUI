package testCases;

import businessLogic.po.EmailPage;
import businessLogic.po.MainPage;
import businessLogic.po.PasswordPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static core.chromeDriver.SingletonChromeConnection.getDriver;
import static core.chromeDriver.SingletonChromeConnection.quitDriver;
import static core.propertiesParser.PropertiesParser.getProperty;
public class TestFirstRun {

    private EmailPage emailPage = new EmailPage();
    private PasswordPage passwordPage = new PasswordPage();
    private MainPage mainPage = new MainPage();

    @Test
    public void firstRun() {
        getDriver().navigate().to(getProperty("base.url"));
        emailPage
                .setLogin(getProperty("base.login"))
                .clickNextBtn();
        passwordPage
                .setPassword(getProperty("base.password"))
                .clickNextBtn();
        mainPage
                .printAllSubjects();

    }

    @AfterTest
    public void closeDriver() {
        quitDriver();
    }

}
