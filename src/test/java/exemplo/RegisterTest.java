package exemplo;

import exemplo.po.MyAccountPage;
import exemplo.po.PublicRedminePage;
import exemplo.po.RegisterPage;
import exemplo.util.WebDriverBuilder;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class RegisterTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setUp() {
        driver = WebDriverBuilder.buildChromeDriver(false, "en-US");
    }

    @After
    public void after() {
        driver.close();
    }

    @Test
    public void registerTest() {
        PublicRedminePage pagina = new PublicRedminePage(driver);
        RegisterPage register = pagina.getMenu().goToRegisterPage();
        assertEquals("Register", register.getTitle());

        MyAccountPage myAccount = register.registerWithValidData();
        assertEquals("Your account has been activated. You can now log in.", myAccount.getAlertNotice());
    }

}
