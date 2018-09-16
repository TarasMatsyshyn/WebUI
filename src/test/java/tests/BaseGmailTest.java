package tests;

import org.testng.annotations.AfterTest;

import static core.chromeDriver.SingletonChromeConnection.quitDriver;

public class BaseGmailTest {

    @AfterTest
    public void closeDriver() {
        quitDriver();
    }


}
