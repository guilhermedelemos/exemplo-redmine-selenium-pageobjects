package exemplo.po;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigninPage extends BasePage {

    @FindBy(xpath = "/html/body/div/div/div[1]/div[3]/div[2]/div[1]/form/table/tbody/tr[1]/td[1]/label")
    WebElement title;
    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(name = "login")
    WebElement loginButton;
    
    public SigninPage(WebDriver driver) {
        super(driver);
    }
    
    public String getTitle() {
        return title.getText();
    }
    
    public PrivateRedminePage validLogin() {
        this.username.clear();
        this.username.sendKeys("utfpr");
        this.password.clear();
        this.password.sendKeys("g4WMrPfWn2tk3mL");
        this.loginButton.click();
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until( (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.xpath("/html/body")).isDisplayed() );
        return new PrivateRedminePage(driver);
    }
    
    public SigninPage invalidLogin() {
        this.username.clear();
        this.username.sendKeys("utfpr");
        this.password.clear();
        this.password.sendKeys("123");
        this.loginButton.click();
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until( (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.xpath("/html/body")).isDisplayed() );
        return this;
    }
    
    public String getErrorMessage() {
        try {
            WebElement error = driver.findElement(By.id("flash_error"));
            return error.getText();
        } catch(NoSuchElementException e) {
            return "";
        }
    }
        
}
