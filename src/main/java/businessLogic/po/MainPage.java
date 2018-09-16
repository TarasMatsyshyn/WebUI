package businessLogic.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MainPage extends PageObject {

    //Buttons
    @FindBy(xpath = "//div[text()='COMPOSE']")
    private WebElement btnCompose;
    @FindBy(xpath = "//div[text()='Send']")
    private WebElement btnSend;
    //Msg creation
    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement ipfTo;
    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement ipfSubject;
    @FindBy(xpath = "//div[@aria-label='Message Body']")
    private WebElement ipfMsgBody;

    //TRASH
    @FindBy(xpath = "//div[@class='AO']")
    private WebElement divMails;
    @FindAll(@FindBy(xpath = "//div[@class='AO']//tr"))
    private List<WebElement> mails;
    @FindAll(@FindBy(xpath = "//div[@class = 'yW']//span[@name = 'Команда Gmail']"))
    private List<WebElement> namedMails;

    public MainPage printAllSubjects(){
        mails.forEach(item -> System.out.println(item.getText()));
        return this;
    }

    public MainPage act_clickCompose(){
        btnCompose.click();
        return this;
    }

    public MainPage act_fillReceivers(String receivers){
        ipfTo.sendKeys(receivers);
        return this;
    }

    public MainPage act_fillSubject(String subject){
        ipfSubject.sendKeys(subject);
        return this;
    }

    public MainPage act_fillMsgBody(String msgBody){
        ipfMsgBody.sendKeys(msgBody);
        return this;
    }

    public MainPage act_clickSendMsg(){
        btnSend.click();
        return this;
    }


}
