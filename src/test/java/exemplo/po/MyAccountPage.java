package exemplo.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy(tagName = "h2")
    WebElement title;

    @FindBy(id = "user_firstname")
    WebElement name;

    @FindBy(id = "user_lastname")
    WebElement lastname;

    @FindBy(name = "commit")
    WebElement save_button;

    @FindBy(id = "flash_notice")
    WebElement alert_notice;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public MyAccountPage clearAndFillInputDataAndSave(String name, String lastname) {

        this.name.clear();
        this.name.sendKeys(name);
        this.lastname.clear();
        this.lastname.sendKeys(lastname);

        this.save_button.click();

        return this;
    }

    public boolean isSavedSuccessfully() {
        return alert_notice.getText().contains("Account was successfully updated.");
    }

}
