package businessLogic.po;

import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationPanel extends BasePO {

    private final static Logger logger = Logger.getLogger(LoginPagePO.class);

    @FindBy(xpath = "//div[text()='Compose']")
    private WebElement btnCompose;
    @FindBy(xpath = "//a[contains(text(),'Inbox')]")
    private WebElement btnInbox;
    @FindBy(xpath = "//a[text()='Sent']")
    private WebElement btnSentMail;
    @FindBy(xpath = "//div[@data-tooltip='Drafts']")
    private WebElement btnDrafts;

    public NavigationPanel act_clickComposeBtn(){
        btnCompose.click();
        logger.info("Was clicked on 'Compose' button");
        return this;
    }

    public NavigationPanel act_clickInboxBtn(){
        btnInbox.click();
        logger.info("Was clicked on 'Inbox' button");
        return this;
    }

    public NavigationPanel act_clickSentMailBtn(){
        boolean staleElement = true;
        while (staleElement) {
            try {
                btnSentMail.click();
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                logger.warn("Caught 'Stale Element Reference exception'");
                staleElement = true;
            }
        }
        logger.info("Was clicked on 'Sent mail' button");
        return this;
    }

    public NavigationPanel act_clickDraftsBtn(){
        btnDrafts.click();
        logger.info("Was clicked on 'Drafts' button");
        return this;
    }






}
