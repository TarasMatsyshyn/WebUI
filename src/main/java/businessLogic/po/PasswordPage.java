package businessLogic.po;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class PasswordPage extends PageObject {

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
        return this;
    }

    public PasswordPage clickNextBtn() {
        btnNext.click();
        return this;
    }

}
