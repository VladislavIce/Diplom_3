import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.browser.ChooseBrowser;
import org.example.pom.LoginPage;
import org.example.pom.MainPage;
import org.example.pom.RecoveryPasswordPage;
import org.example.pom.RegistrationPage;
import org.example.userdata.UserSteps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class UserAuthorizationTest {
    protected static WebDriver driver;

    @Before
    public void setUp(){
        // Для браузера Яндекс использовать "Yandex"
        // Для браузера Хром использовтаь "Chrome"
        driver = ChooseBrowser.getBrowser("Chrome");
    }

    @DisplayName("Проверить авторизацию по кнопке \"Войти в аккаунт\"")
    @Description("Проверяем вход по кнопке \"Войти в аккаунт\" на главной странице сайта")
    @Test
    public void authorizationButtonEnterAccountTest(){
        UserSteps userSteps = new UserSteps(driver);
        MainPage mainPage = new MainPage(driver);
            mainPage.openPage();
            mainPage.clickButtonSignIn();
            userSteps.authorizationUser();
            mainPage.checkSuccessfulAuthorization();
    }

    @DisplayName("Проверить авторизацию через личный кабинет")
    @Description("Проверяем вход через кнопку «Личный кабинет»")
    @Test
    public void authorizationPersonalAccountTest(){
        UserSteps userSteps = new UserSteps(driver);
        MainPage mainPage = new MainPage(driver);
            mainPage.openPage();
            mainPage.clickButtonPersonalArea();
            userSteps.authorizationUser();
            mainPage.checkSuccessfulAuthorization();
    }


    @DisplayName("Проверить авторизацию через форму регистрации")
    @Description("Проверяем авторизацию через кнопку \"Вход\" в форме регистрации")
    @Test
    public void authorizationButtonRegistrationFormTest(){
        UserSteps userSteps = new UserSteps(driver);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
            mainPage.openPage();
            mainPage.clickButtonSignIn();
            loginPage.clickButtonRegister();
            registrationPage.clickButtonLogin();
            userSteps.authorizationUser();
            mainPage.checkSuccessfulAuthorization();
    }

    @DisplayName("Проверить авторизацию через форму восстановления пароля")
    @Description("Проверяем авторизацию через кнопку \"Вход\" в форме восстановления пароля")
    @Test
    public void authorizationTheFormRecoveryPasswordTest() {
        UserSteps userSteps = new UserSteps(driver);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RecoveryPasswordPage recoveryPasswordPage = new RecoveryPasswordPage(driver);
            mainPage.openPage();
            mainPage.clickButtonSignIn();
            loginPage.clickButtonRecoveryPassword();
            recoveryPasswordPage.clickButtonLogin();
            userSteps.authorizationUser();
            mainPage.checkSuccessfulAuthorization();
    }

    @After
    public void tearDown(){
        driver.quit();
    }



}
