package exemplo;

import exemplo.po.HelpPage;
import exemplo.po.PrivateRedminePage;
import exemplo.po.ProjectsPage;
import exemplo.po.PublicMenu;
import exemplo.po.PublicRedminePage;
import exemplo.po.RegisterPage;
import exemplo.po.SigninPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NavegationTest {

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
    public void publicNavegationTest() {
        PublicRedminePage pagina = new PublicRedminePage(driver);
        PublicMenu menu = pagina.getMenu();

        PublicRedminePage home = menu.goToHome();
        assertEquals("Página inicial", home.getTitle());

        ProjectsPage projects = menu.goToProjects();
        assertEquals("Projetos", projects.getTitle());

        HelpPage help = menu.goToHelp();
        assertEquals("Redmine guide", help.getTitle());
        menu.goToHome();

        SigninPage signin = menu.goToSigninPage();
        assertEquals("Usuário:", signin.getTitle());

        RegisterPage register = menu.goToRegisterPage();
        assertEquals("Cadastre-se", register.getTitle());
    }

    @Test
    public void privateNavegationTest() {
        PublicRedminePage pagina = new PublicRedminePage(driver);
        PublicMenu menu = pagina.getMenu();

        SigninPage signin = menu.goToSigninPage();
        assertEquals("Usuário:", signin.getTitle());

        PrivateRedminePage home = signin.validLogin();
        assertEquals("Página inicial", home.getMenu().goToHome().getTitle());
        assertEquals("Minha página", home.getMenu().goToMyPage().getTitle());
        assertEquals("Projetos", home.getMenu().goToProjects().getTitle());
        assertEquals("Redmine guide", home.getMenu().goToHelp().getTitle());
        // volta para o DEMO.redmine.org, o help é centralizado no redmine.org
        home.goTo();
        assertEquals("Minha conta", home.getMenu().goToMyAccount().getTitle());
        assertEquals("Página inicial", home.getMenu().goToSignOut().getTitle());
    }

}
