package exemplo.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/h1")
    WebElement title;
    
    public HelpPage(WebDriver driver) {
        super(driver);
    }
    
    public String getTitle() {
        return title.getText();
    }
    
}
