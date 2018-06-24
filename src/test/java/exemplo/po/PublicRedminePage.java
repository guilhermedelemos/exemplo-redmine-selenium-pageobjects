package exemplo.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PublicRedminePage extends BasePage {

    private PublicMenu menu;
    @FindBy(tagName = "h2")
    WebElement title;

    public PublicRedminePage(WebDriver driver) {
        super(driver);
        menu = new PublicMenu(driver);
        driver.get("http://demo.redmine.org");
    }

    public PublicMenu getMenu() {
        return menu;
    }

    public String getTitle() {
        return title.getText();
    }

}
