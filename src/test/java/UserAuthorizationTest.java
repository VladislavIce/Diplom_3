import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.example.browser.ChooseBrowser;
import org.example.pom.LoginPage;
import org.example.pom.MainPage;
import org.example.pom.RecoveryPasswordPage;
import org.example.pom.RegistrationPage;
import org.example.userdata.CreateRandomUser;
import org.example.userdata.CustomSteps;
import org.example.userdata.User;
import org.example.userdata.UserCreate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class UserAuthorizationTest {
    private static WebDriver driver;

    UserCreate userCreate = new UserCreate();
    CreateRandomUser userRandom = new CreateRandomUser();
    User user = userRandom.random();
    private  String accessToken;

    @Before
    public void setUp(){
        // Для браузера Яндекс использовать "Yandex"
        // Для браузера Хром использовтаь "Chrome"
        driver = ChooseBrowser.getBrowser("Chrome");
        ValidatableResponse response = userCreate.createUser(user);
        accessToken = userCreate.successCreate(response);

    }

    @DisplayName("Проверить авторизацию по кнопке \"Войти в аккаунт\"")
    @Description("Проверяем вход по кнопке \"Войти в аккаунт\" на главной странице сайта")
    @Test
    public void authorizationButtonEnterAccountTest(){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
            mainPage.openPage();
            mainPage.clickButtonSignIn();
            loginPage.enterEmail(user.getEmail());
            loginPage.enterPassword(user.getPassword());
            loginPage.clickButtonLogin();
            mainPage.checkSuccessfulAuthorization();
    }


    @DisplayName("Проверить авторизацию через личный кабинет")
    @Description("Проверяем вход через кнопку «Личный кабинет»")
    @Test
    public void authorizationPersonalAccountTest(){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
            mainPage.openPage();
            mainPage.clickButtonPersonalArea();
             loginPage.enterEmail(user.getEmail());
             loginPage.enterPassword(user.getPassword());
             loginPage.clickButtonLogin();
            mainPage.checkSuccessfulAuthorization();
    }


    @DisplayName("Проверить авторизацию через форму регистрации")
    @Description("Проверяем авторизацию через кнопку \"Вход\" в форме регистрации")
    @Test
    public void authorizationButtonRegistrationFormTest(){
        CustomSteps userSteps = new CustomSteps(driver);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.openPage();
        mainPage.clickButtonSignIn();
        loginPage.clickButtonRegister();
        registrationPage.clickButtonLogin();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickButtonLogin();
        mainPage.checkSuccessfulAuthorization();
    }

    @DisplayName("Проверить авторизацию через форму восстановления пароля")
    @Description("Проверяем авторизацию через кнопку \"Вход\" в форме восстановления пароля")
    @Test
    public void authorizationTheFormRecoveryPasswordTest() {
        CustomSteps userSteps = new CustomSteps(driver);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RecoveryPasswordPage recoveryPasswordPage = new RecoveryPasswordPage(driver);
        mainPage.openPage();
        mainPage.clickButtonSignIn();
        loginPage.clickButtonRecoveryPassword();
        recoveryPasswordPage.clickButtonLogin();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickButtonLogin();
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
