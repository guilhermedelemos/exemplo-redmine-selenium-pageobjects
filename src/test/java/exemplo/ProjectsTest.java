package exemplo;

import exemplo.po.NewProjectPage;
import exemplo.po.PrivateRedminePage;
import exemplo.po.ProjectSettingsPage;
import exemplo.po.ProjectsPage;
import exemplo.po.PublicMenu;
import exemplo.po.PublicRedminePage;
import exemplo.po.SigninPage;
import exemplo.util.WebDriverBuilder;
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

public class ProjectsTest {

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
    public void newProjectTest() {
        PublicRedminePage pagina = new PublicRedminePage(driver);
        PublicMenu menu = pagina.getMenu();

        SigninPage signin = menu.goToSigninPage();
        //assertEquals("Usuário:", signin.getTitle());
        assertEquals("Login:", signin.getTitle());

        PrivateRedminePage home = signin.validLogin();
        assertEquals("Home", home.getMenu().goToHome().getTitle());

        ProjectsPage projects = home.getMenu().goToProjects();
        assertEquals("Projects", home.getMenu().goToProjects().getTitle());

        NewProjectPage newproject = projects.clickNewProject();

        ProjectSettingsPage projectsettings = newproject.fillInputDataAndSave("Projeto " + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()), "Projeto teste");

        assertTrue(projectsettings.isSavedSuccessfully());
    }

}
