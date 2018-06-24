package exemplo.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends BasePage {

    @FindBy(tagName = "h2")
    WebElement title;
    
    public ProjectsPage(WebDriver driver) {
        super(driver);
    }
    
    public String getTitle() {
        return title.getText();
    }
    
}
