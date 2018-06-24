package exemplo.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PublicMenu extends BasePage {

    @FindBy(css = ".home")
    WebElement home;
    @FindBy(css = "a.projects")
    WebElement projects;
    @FindBy(css = ".help")
    WebElement help;
    @FindBy(css = ".login")
    WebElement signin;
    @FindBy(css = ".register")
    WebElement register;

    public PublicMenu(WebDriver driver) {
        super(driver);
    }
    
    private void clickMenuOption(WebElement menuOption) {
        menuOption.click();
    }
    
    public PublicRedminePage goToHome() {
        clickMenuOption(home);
        return new PublicRedminePage(driver);
    }
    
    public ProjectsPage goToProjects() {
        clickMenuOption(projects);
        return new ProjectsPage(driver);
    }
    
    public HelpPage goToHelp() {
        clickMenuOption(help);
        return new HelpPage(driver);
    }
    
    public SigninPage goToSigninPage() {
        clickMenuOption(signin);
        return new SigninPage(driver);
    }
    
    public RegisterPage goToRegisterPage() {
        clickMenuOption(register);
        return new RegisterPage(driver);
    }
    
}
