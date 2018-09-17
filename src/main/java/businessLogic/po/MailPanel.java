package businessLogic.po;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MailPanel extends PageObject{

    private final static Logger logger = Logger.getLogger(MainPage.class);

    @FindAll(@FindBy(xpath = "//div[@class='AO']//tr"))
    private List<WebElement> mails;

    public MailPanel act_openMailBySubject(String subject) {
        mails.forEach(item -> {
            if (item.getText().contains(subject)) item.click();
            return;
        });
        logger.info(String.format("Was clicked on %s subject", subject));
        return this;
    }

}
