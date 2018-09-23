package tests;

import businessLogic.businessLogic.bo.BaseGmailBO;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Calendar;

import static core.chromeDriver.SingletonChromeConnection.getDriver;
import static core.chromeDriver.SingletonChromeConnection.quitDriver;
import static core.propertiesParser.PropertiesParser.getProperty;

public class BaseGmailTest {

    protected String timeStamp = String.valueOf(Calendar.getInstance().getTimeInMillis());
    private BaseGmailBO baseGmailBO = new BaseGmailBO();
    private boolean event = false;

//    @BeforeTest
//    public void login() {
//        getDriver().navigate().to(getProperty("base.url"));
//    }

    @AfterTest
    public void closeDriver() {
        quitDriver();
    }

    protected void waitForEvent(){
        while (!event){}
    }

    protected void publishEvent(){
        event = true;
    }

}
