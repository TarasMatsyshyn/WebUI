package businessLogic.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class EmailPage extends PageObject {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement ipfLogin;
    @FindBy(id = "identifierNext")
    private WebElement btnNext;

    public EmailPage setLogin(String login) {
        ipfLogin.sendKeys(login);
        return this;
    }

    public EmailPage clickNextBtn() {
        btnNext.click();
        return this;
    }


}
