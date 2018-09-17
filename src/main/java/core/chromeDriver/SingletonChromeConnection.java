package core.chromeDriver;

import businessLogic.po.MainPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static core.propertiesParser.PropertiesParser.getProperty;

public class SingletonChromeConnection {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private final static Logger logger = Logger.getLogger(MainPage.class);


    public static ChromeDriver getDriver() {
        if (webDriverThreadLocal.get() != null) {
            return (ChromeDriver) webDriverThreadLocal.get();
        }
        System.setProperty("webdriver.chrome.driver", getProperty("driver.path"));
        WebDriver instance = new ChromeDriver() {
            {
                manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            }
        };
        webDriverThreadLocal.set(instance);
        return (ChromeDriver) webDriverThreadLocal.get();
    }

    public static void quitDriver() {
        logger.info("Try quit driver");
        try {
            webDriverThreadLocal.get().quit();
        } finally {
            webDriverThreadLocal.remove();
        }
        logger.info("Driver closed successfully");
    }

}
