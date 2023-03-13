import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.example.browser.ChooseBrowser;
import org.example.pom.LoginPage;
import org.example.pom.MainPage;
import org.example.pom.PersonalAreaPage;
import org.example.userdata.CreateRandomUser;
import org.example.userdata.User;
import org.example.userdata.UserCreate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class ExitAccountTest {

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

    @DisplayName("Проверить выход из аккаунта")
    @Description("Проверьям выход по кнопке \"Выйти\" в личном кабинете")
    @Test
    public void logoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickButtonPersonalArea();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickButtonLogin();
        mainPage.clickButtonPersonalArea();
        personalAreaPage.clickButtonExit();
        loginPage.successExitAccount();
    }

    @After
    public void tearDown() {
        driver.quit();
        if(accessToken != null) {
            userCreate.deleteUser(accessToken);
        }
    }
}
