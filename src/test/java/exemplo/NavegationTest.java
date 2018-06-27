package exemplo;

import exemplo.po.HelpPage;
import exemplo.po.PrivateRedminePage;
import exemplo.po.ProjectsPage;
import exemplo.po.PublicMenu;
import exemplo.po.PublicRedminePage;
import exemplo.po.RegisterPage;
import exemplo.po.SigninPage;
import exemplo.util.WebDriverBuilder;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class NavegationTest {

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
    public void publicNavegationTest() {
        PublicRedminePage pagina = new PublicRedminePage(driver);
        PublicMenu menu = pagina.getMenu();

        PublicRedminePage home = menu.goToHome();
        assertEquals("Home", home.getTitle());

        ProjectsPage projects = menu.goToProjects();
        assertEquals("Projects", projects.getTitle());

        HelpPage help = menu.goToHelp();
        assertTrue(help.getTitle().contains("Redmine guide"));
        menu.goToHome();

        SigninPage signin = menu.goToSigninPage();
        assertEquals("Login:", signin.getTitle());

        RegisterPage register = menu.goToRegisterPage();
        assertEquals("Register", register.getTitle());
    }

    @Test
    public void privateNavegationTest() {
        PublicRedminePage pagina = new PublicRedminePage(driver);
        PublicMenu menu = pagina.getMenu();

        SigninPage signin = menu.goToSigninPage();
        assertEquals("Login:", signin.getTitle());

        PrivateRedminePage home = signin.validLogin();
        assertEquals("Home", home.getMenu().goToHome().getTitle());
        assertEquals("My page", home.getMenu().goToMyPage().getTitle());
        assertEquals("Projects", home.getMenu().goToProjects().getTitle());
        assertTrue(home.getMenu().goToHelp().getTitle().contains("Redmine guide"));

        // volta para o DEMO.redmine.org, o help é centralizado no redmine.org
        home.goTo();
        assertEquals("My account", home.getMenu().goToMyAccount().getTitle());
    }

}
