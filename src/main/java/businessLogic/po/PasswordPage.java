package businessLogic.po;

import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class PasswordPage extends PageObject {

    private final static Logger logger = Logger.getLogger(PasswordPage.class);

    @FindBy(xpath = "//input[@type='password']")
    private WebElement ipfPassword;
    @FindBy(id = "passwordNext")
    private WebElement btnNext;

    public PasswordPage setPassword(String login) {
        boolean staleElement = true;
        while (staleElement) {
            try {
                ipfPassword.sendKeys(login);
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
        }
        logger.info(String.format("%s typed to 'Password' input field", login));
        return this;
    }

    public PasswordPage clickNextBtn() {
        btnNext.click();
        logger.info("Was clicked on 'Next' button");
        return this;
    }

}
