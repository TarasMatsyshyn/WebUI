package businessLogic.po;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class LoginPagePO extends BasePageObject {

    private final static Logger logger = Logger.getLogger(LoginPagePO.class);

    @FindBy(xpath = "//input[@type='email']")
    private WebElement ipfLogin;
    @FindBy(id = "identifierNext")
    private WebElement btnNext;

    public LoginPagePO setLogin(String login) {
        ipfLogin.sendKeys(login);
        logger.info(String.format("%s typed to 'Email' input field", login));
        return this;
    }

    public LoginPagePO clickNextBtn() {
        btnNext.click();
        logger.info("Was clicked on 'Next' button");
        return this;
    }


}
