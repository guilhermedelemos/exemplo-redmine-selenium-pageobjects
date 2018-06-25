package exemplo.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrivateMenu extends BasePage {

    @FindBy(css = ".home")
    WebElement home;
    @FindBy(css = ".my-page")
    WebElement myPage;
    @FindBy(css = "a.projects")
    WebElement projects;
    @FindBy(css = ".help")
    WebElement help;
    @FindBy(css = ".my-account")
    WebElement myAccount;
    @FindBy(css = ".logout")
    WebElement signOut;

    public PrivateMenu(WebDriver driver) {
        super(driver);
    }

    private void clickMenuOption(WebElement menuOption) {
        if (menuOption.isDisplayed()) {
            menuOption.click();
        } else {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(menuOption));
            menuOption.click();
        }
        //wait.until( (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.xpath("/html/body")).isDisplayed() );
    }

    public PrivateRedminePage goToHome() {
        clickMenuOption(home);
        return new PrivateRedminePage(driver);
    }

    public MyPage goToMyPage() {
        clickMenuOption(myPage);
        return new MyPage(driver);
    }

    public ProjectsPage goToProjects() {
        clickMenuOption(projects);
        return new ProjectsPage(driver);
    }

    public HelpPage goToHelp() {
        clickMenuOption(help);
        return new HelpPage(driver);
    }

    public MyAccountPage goToMyAccount() {
        clickMenuOption(myAccount);
        return new MyAccountPage(driver);
    }

    public PublicRedminePage goToSignOut() {
        clickMenuOption(signOut);
        return new PublicRedminePage(driver);
    }

}
