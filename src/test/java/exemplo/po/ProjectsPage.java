package exemplo.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends BasePage {

    @FindBy(tagName = "h2")
    WebElement title;
    
    @FindBy(css = "#content > div.contextual > a.icon.icon-add")
    WebElement newProject;
    
    public ProjectsPage(WebDriver driver) {
        super(driver);
    }
    
    public String getTitle() {
        return title.getText();
    }
    
    public NewProjectPage clickNewProject() {
        newProject.click();
        return new NewProjectPage(driver);
    }
    
}
