package exemplo.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectSettingsPage extends BasePage {

    @FindBy(tagName = "h2")
    WebElement title;

    @FindBy(id = "project_name")
    WebElement name;

    @FindBy(id = "project_description")
    WebElement description;

    @FindBy(name = "commit")
    WebElement save_button;

    @FindBy(id = "flash_notice")
    WebElement alert_notice;

    public ProjectSettingsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public boolean isSavedSuccessfully() {
        return alert_notice.getText().contains("Successful creation");
    }

}
