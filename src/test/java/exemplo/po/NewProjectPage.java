package exemplo.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewProjectPage extends BasePage {

    @FindBy(tagName = "h2")
    WebElement title;
    
    @FindBy(id = "project_name")
    WebElement name;
    
    @FindBy(id = "project_description")
    WebElement description;
    
    @FindBy(name = "commit")
    WebElement save_button;
    
    public NewProjectPage(WebDriver driver) {
        super(driver);
    }
    
    public String getTitle() {
        return title.getText();
    }
    
    public ProjectSettingsPage fillInputDataAndSave(String name, String description) {
        
        this.name.sendKeys(name);
        this.description.sendKeys(description);
        
        this.save_button.click();
        
        return new ProjectSettingsPage(driver);
    }
    
}
