import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.example.browser.ChooseBrowser;
import org.example.pom.LoginPage;
import org.example.pom.MainPage;
import org.example.pom.PersonalAreaPage;
import org.example.userdata.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class TransitionToConstructorTest {
    private static WebDriver driver;
    UserCreate userCreate = new UserCreate();
    CreateRandomUser userRandom = new CreateRandomUser();
    User user = userRandom.random();
    private  String accessToken;

    @Before
    public void setUp() {
        // Для браузера Яндекс использовать "Yandex"
        // Для браузера Хром использовтаь "Chrome"
        driver = ChooseBrowser.getBrowser("Chrome");
        ValidatableResponse response = userCreate.createUser(user);
        accessToken = userCreate.successCreate(response);
    }

    @DisplayName("Проверить переход из ЛК в конструктор по клику на кнопку \"Конструктор\"")
    @Description("Проверяем переход из личного кабинета в конструктор")
    @Test
    public void transitionToConstructorButtonConstructorTest() {
        LoginPage loginPage = new LoginPage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickButtonPersonalArea();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickButtonLogin();
        mainPage.clickButtonPersonalArea();
        personalAreaPage.clickButtonConstructor();
        mainPage.checkSuccessfulAuthorization();
    }

    @DisplayName("Проверить переход из ЛК в конструктор по клику на логотип \"Stellar Burgers\"")
    @Description("Проверяем переход из личного кабинета в конструктор")
    @Test
    public void transitionToConstructorLogoTest() {
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.openPage();
        mainPage.clickButtonPersonalArea();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickButtonLogin();
        mainPage.clickButtonPersonalArea();
        personalAreaPage.clickLogoStellarBurger();
        mainPage.checkSuccessfulAuthorization();
    }

    @After
    public void tearDown() {
        driver.quit();
        if(accessToken != null) {
            userCreate.deleteUser(accessToken);
        }
    }
}
