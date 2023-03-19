import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.example.browser.ChooseBrowser;
import org.example.userdata.CreateRandomUser;
import org.example.pom.RegistrationPage;
import org.example.userdata.AuthorizationUser;
import org.example.userdata.User;
import org.example.userdata.UserCreate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class RegisteringNewUserTest {
    private static WebDriver driver;
    CreateRandomUser createRandomUser = new CreateRandomUser();
    User user = createRandomUser.random();
    UserCreate userCreate = new UserCreate();
    private String accessToken;

    boolean isUserActive;
    @Before
    public void setUp() {
        // Для браузера Яндекс использовать "Yandex"
        // Для браузера Хром использовтаь "Chrome"
        driver = ChooseBrowser.getBrowser("Yandex");
    }

    @DisplayName("Проверить успешную регистрацию")
    @Description("Проверяем успешную регистрацию нового пользователя")
    @Test
    public void successfulRegistrationTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openPage();
        registrationPage.fillTheNameField(user.getName());
        registrationPage.fillTheEmailField(user.getEmail());
        registrationPage.fillThePasswordField(user.getPassword());
        registrationPage.clickButtonRegister();
        registrationPage.checkRegistration();
            AuthorizationUser authorizationUser = new AuthorizationUser(user.getEmail(), user.getPassword());
            ValidatableResponse response = userCreate.successfulAuthorization(authorizationUser);
            accessToken = userCreate.successfulAuthorization(response);
            userCreate.deleteUser(accessToken);
    }

    @DisplayName("Проверить регистрация с неккоректным паролем")
    @Description("Проверяем регистрацию нового пользователя с неккоретным паролем, длина пароля 5 символов")
    @Test
    public void registrationWithIncorrectPasswordTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openPage();
        registrationPage.fillTheNameField(user.getName());
        registrationPage.fillTheEmailField(user.getEmail());
        registrationPage.fillThePasswordField(user.getInvalidRandomPassword());
        registrationPage.clickButtonRegister();
        isUserActive = registrationPage.checkRegistrationNotRegistering();
        if(isUserActive != true) {
            AuthorizationUser incompleteUser = new AuthorizationUser(user.getEmail(), user.getInvalidRandomPassword());
            ValidatableResponse responseIncompleteUser = userCreate.successfulAuthorization(incompleteUser);
            accessToken = userCreate.successfulAuthorization(responseIncompleteUser);
            userCreate.deleteUser(accessToken);
        }
        }


     @After
    public void tearDown() {
        driver.quit();

    }
}


