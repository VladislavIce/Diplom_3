import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.browser.ChooseBrowser;
import org.example.userdata.CreateRandomUser;
import org.example.pom.RegistrationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisteringNewUserTest {
    protected static WebDriver driver;

    @Before
    public void setUp() {
        // Для браузера Яндекс использовать "Yandex"
        // Для браузера Хром использовтаь "Chrome"
        driver = ChooseBrowser.getBrowser("Chrome");
    }

    @DisplayName("Проверить успешную регистрацию")
    @Description("Проверяем успешную регистрацию нового пользователя")
    @Test
    public void successfulRegistrationTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        CreateRandomUser user = new CreateRandomUser();
         registrationPage.openPage();
         registrationPage.fillTheNameField(user.getRandomName());
         registrationPage.fillTheEmailField(user.getRandomEmail());
         registrationPage.fillThePasswordField(user.getRandomPassword());
         registrationPage.clickButtonRegister();
         registrationPage.checkRegistration();
    }

    @DisplayName("Проверить регистрация с неккоректным паролем")
    @Description("Проверяем регистрацию нового пользователя с неккоретным паролем, длина пароля 5 символов")
    @Test
    public void registrationWithIncorrectPasswordTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        CreateRandomUser user = new CreateRandomUser();
        registrationPage.openPage();
        registrationPage.fillTheNameField(user.getRandomName());
        registrationPage.fillTheEmailField(user.getRandomEmail());
        registrationPage.fillThePasswordField(user.getInvalidRandomPassword());
        registrationPage.clickButtonRegister();
        registrationPage.checkRegistrationNotRegistering();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
