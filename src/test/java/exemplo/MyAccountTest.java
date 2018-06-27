package exemplo;

import exemplo.po.MyAccountPage;
import exemplo.po.PrivateRedminePage;
import exemplo.po.PublicMenu;
import exemplo.po.PublicRedminePage;
import exemplo.po.SigninPage;
import exemplo.util.WebDriverBuilder;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class MyAccountTest {

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
    public void updateNameTest() {
        PublicRedminePage pagina = new PublicRedminePage(driver);
        PublicMenu menu = pagina.getMenu();

        SigninPage signin = menu.goToSigninPage();
        //assertEquals("Usuário:", signin.getTitle());
        assertEquals("Login:", signin.getTitle());

        PrivateRedminePage home = signin.validLogin();
        assertEquals("Home", home.getMenu().goToHome().getTitle());

        MyAccountPage myaccount = home.getMenu().goToMyAccount();
        assertEquals("My account", myaccount.getTitle());

        String nome = "Andre " + ThreadLocalRandom.current().nextInt(1, 1000);
        String sobrenome = "Endo " + ThreadLocalRandom.current().nextInt(1, 1000);
        myaccount = myaccount.clearAndFillInputDataAndSave(nome, sobrenome);

        assertTrue(myaccount.isSavedSuccessfully());
    }

}
