package exemplo.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigninPage extends BasePage {

    @FindBy(xpath = "/html/body/div/div/div[1]/div[3]/div[2]/div[1]/form/table/tbody/tr[1]/td[1]/label")
    WebElement title;
    
    public SigninPage(WebDriver driver) {
        super(driver);
    }
    
    public String getTitle() {
        return title.getText();
    }
    
}
