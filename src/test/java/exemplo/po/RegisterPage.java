package exemplo.po;

import java.util.concurrent.ThreadLocalRandom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {

    @FindBy(tagName = "h2")
    WebElement title;
    @FindBy(id = "user_login")
    WebElement login;
    @FindBy(id = "user_password")
    WebElement password;
    @FindBy(id = "user_password_confirmation")
    WebElement confirmation;
    @FindBy(id = "user_firstname")
    WebElement firstName;
    @FindBy(id = "user_lastname")
    WebElement lastName;
    @FindBy(id = "user_mail")
    WebElement email;
    @FindBy(id = "user_language")
    WebElement language;
    @FindBy(xpath = "/html/body/div/div/div[1]/div[3]/div[2]/form/input[3]")
    WebElement submitButton;

    public static final String LANGUAGE_VALUE_AUTO = "";
    public static final String LANGUAGE_VALUE_PT_BR = "pt-BR";
    public static final String LANGUAGE_VALUE_EN = "en";

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getConfirmation() {
        return confirmation.getText();
    }

    public String getLogin() {
        return login.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public String getFirstName() {
        return firstName.getText();
    }

    public String getLastName() {
        return lastName.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getLanguage() {
        return language.getText();
    }

    public void setLanguage(String language) {
        Select selectLanguage = new Select(this.language);
        selectLanguage.selectByValue(language);
    }

    public MyAccountPage registerWithValidData() {
        this.login.clear();
        this.login.sendKeys("asdfg" + ThreadLocalRandom.current().nextInt(0, 1000));
        this.password.clear();
        this.password.sendKeys("123456");
        this.confirmation.clear();
        this.confirmation.sendKeys("123456");
        this.firstName.clear();
        this.firstName.sendKeys("Asd");
        this.lastName.clear();
        this.lastName.sendKeys("Fgh");
        this.email.clear();
        this.email.sendKeys("fake@mail.com");
        this.setLanguage(LANGUAGE_VALUE_EN);
        this.submitButton.click();
        return new MyAccountPage(driver);
    }

}
