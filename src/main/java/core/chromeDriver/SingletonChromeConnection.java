package core.chromeDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static core.propertiesParser.PropertiesParser.getProperty;

public class SingletonChromeConnection {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

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
        try {
            webDriverThreadLocal.get().quit();
        } finally {
            webDriverThreadLocal.remove();
        }
    }

}
