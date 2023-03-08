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
import org.openqa.selenium.chrome.ChromeDriver;

public class PersonalAreaTest {
    protected static WebDriver driver;

    @Before
    public void setUp() {
        // Для браузера Яндекс использовать "Yandex"
        // Для браузера Хром использовтаь "Chrome"
        driver = ChooseBrowser.getBrowser("Chrome");
    }

    @DisplayName("Проверить переход в личный кабинет")
    @Description("Проверяем переход в личный кабинет пользователя по клику на \"Личный кабинет\"")
    @Test
    public void loginPersonalAccountTest() {
        UserSteps userSteps = new UserSteps(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
            userSteps.loginPersonalAccount();
            personalAreaPage.successfulLoginPersonalArea();

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
