package exemplo;

import exemplo.po.PrivateRedminePage;
import exemplo.po.PublicMenu;
import exemplo.po.PublicRedminePage;
import exemplo.po.SigninPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SigninTest {
    
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        // Se usar headless, usar versão inglês da página nos asserts
        //chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        assertEquals("Usuário:", signin.getTitle());
        
        PrivateRedminePage home = signin.validLogin();
        assertEquals("utfpr", home.getUsername());
    }
    
    @Test
    public void loginErrorTest() {
        PublicRedminePage pagina = new PublicRedminePage(driver);
        PublicMenu menu = pagina.getMenu();
        
        SigninPage signin = menu.goToSigninPage();
        assertEquals("Usuário:", signin.getTitle());
        assertEquals("", signin.getErrorMessage());
        
        
        SigninPage result = signin.invalidLogin();
        assertEquals("Usuário ou senha inválido.", result.getErrorMessage());
    }
}
