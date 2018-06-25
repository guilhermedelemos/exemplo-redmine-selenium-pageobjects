package exemplo.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrivateRedminePage extends BasePage {

    private PrivateMenu menu;
    @FindBy(tagName = "h2")
    WebElement title;
    @FindBy(css = "#loggedas > a:nth-child(1)")
    WebElement username;

    public PrivateRedminePage(WebDriver driver) {
        super(driver);
        menu = new PrivateMenu(driver);
    }
    
    public PrivateRedminePage goTo() {
        driver.get("http://demo.redmine.org");
        return this;
    }

    public PrivateMenu getMenu() {
        return menu;
    }

    public String getTitle() {
        return title.getText();
    }
    
    public String getUsername() {
        return username.getText();
    }

}
