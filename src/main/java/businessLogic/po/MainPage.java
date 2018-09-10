package businessLogic.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MainPage extends PageObject {

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

}
