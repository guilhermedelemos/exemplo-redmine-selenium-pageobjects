package exemplo;

import exemplo.po.PrivateRedminePage;
import exemplo.po.PublicMenu;
import exemplo.po.PublicRedminePage;
import exemplo.po.SigninPage;
import exemplo.util.WebDriverBuilder;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class SigninTest {

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
    public void loginTest() {
        PublicRedminePage pagina = new PublicRedminePage(driver);
        PublicMenu menu = pagina.getMenu();

        SigninPage signin = menu.goToSigninPage();
        assertEquals("Login:", signin.getTitle());

        PrivateRedminePage home = signin.validLogin();
        assertEquals("utfpr", home.getUsername());
    }

    @Test
    public void loginErrorTest() {
        PublicRedminePage pagina = new PublicRedminePage(driver);
        PublicMenu menu = pagina.getMenu();

        SigninPage signin = menu.goToSigninPage();
        assertEquals("Login:", signin.getTitle());
        assertEquals("", signin.getErrorMessage());

        SigninPage result = signin.invalidLogin();
        assertEquals("Invalid user or password", result.getErrorMessage());
    }
}
