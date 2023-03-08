import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.browser.ChooseBrowser;
import org.example.pom.MainPage;
import org.example.pom.PersonalAreaPage;
import org.example.userdata.UserSteps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class TransitionToConstructorTest {
    protected static WebDriver driver;

    @Before
    public void setUp() {
        // Для браузера Яндекс использовать "Yandex"
        // Для браузера Хром использовтаь "Chrome"
        driver = ChooseBrowser.getBrowser("Chrome");
    }

    @DisplayName("Проверить переход из ЛК в конструктор по клику на кнопку \"Конструктор\"")
    @Description("Проверяем переход из личного кабинета в конструктор")
    @Test
    public void transitionToConstructorButtonConstructorTest() {
        UserSteps userSteps = new UserSteps(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        MainPage mainPage = new MainPage(driver);
            userSteps.loginPersonalAccount();
            personalAreaPage.clickButtonConstructor();
            mainPage.checkSuccessfulAuthorization();
    }

    @DisplayName("Проверить переход из ЛК в конструктор по клику на логотип \"Stellar Burgers\"")
    @Description("Проверяем переход из личного кабинета в конструктор")
    @Test
    public void transitionToConstructorLogoTest() {
        UserSteps userSteps = new UserSteps(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        MainPage mainPage = new MainPage(driver);
            userSteps.loginPersonalAccount();
            personalAreaPage.clickLogoStellarBurger();
            mainPage.checkSuccessfulAuthorization();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
