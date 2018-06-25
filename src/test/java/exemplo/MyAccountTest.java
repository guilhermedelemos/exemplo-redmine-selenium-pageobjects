package exemplo;

import exemplo.po.MyAccountPage;
import exemplo.po.NewProjectPage;
import exemplo.po.PrivateRedminePage;
import exemplo.po.ProjectSettingsPage;
import exemplo.po.ProjectsPage;
import exemplo.po.PublicMenu;
import exemplo.po.PublicRedminePage;
import exemplo.po.SigninPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyAccountTest {

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
    public void updateNameTest() {
        PublicRedminePage pagina = new PublicRedminePage(driver);
        PublicMenu menu = pagina.getMenu();

        SigninPage signin = menu.goToSigninPage();
        //assertEquals("Usuário:", signin.getTitle());
        assertEquals("Login:", signin.getTitle());

        PrivateRedminePage home = signin.validLogin();
        assertEquals("Página inicial", home.getMenu().goToHome().getTitle());
        
        MyAccountPage myaccount = home.getMenu().goToMyAccount();
        assertEquals("Minha conta", myaccount.getTitle());
        
        myaccount = myaccount.clearAndFillInputDataAndSave("Andre", "Endo");

        assertTrue(myaccount.isSavedSuccessfully());
        
    }

}
