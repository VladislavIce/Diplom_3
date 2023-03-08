import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.browser.ChooseBrowser;
import org.example.pom.LoginPage;
import org.example.pom.MainPage;
import org.example.pom.PersonalAreaPage;
import org.example.userdata.UserSteps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class LogoutAccountTest {

    protected  static WebDriver driver;

    @Before
    public void setUp() {
        // Для браузера Яндекс использовать "Yandex"
        // Для браузера Хром использовтаь "Chrome"
        driver = ChooseBrowser.getBrowser("Chrome");
    }



    @DisplayName("Проверить выход из аккаунта")
    @Description("Проверьям выход по кнопке \"Выйти\" в личном кабинете")
    @Test
    public void logoutTest() {
        UserSteps userSteps = new UserSteps(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
            userSteps.loginPersonalAccount();
            personalAreaPage.clickButtonExit();
            loginPage.successLogout();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
