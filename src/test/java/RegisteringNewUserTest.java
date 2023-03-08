import org.example.pom.CreateRandomUser;
import org.example.pom.RegistrationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisteringNewUser {

    protected static WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
    }


    // Успешная регистрация
    @Test
    public void SuccessfulRegistrationTest(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        CreateRandomUser user = new CreateRandomUser();
         registrationPage.openPage();
         registrationPage.fillTheNameField(user.getRandomName());
         registrationPage.fillTheEmailField(user.getRandomEmail());
         registrationPage.fillThePasswordField(user.getRandomPassword());
         registrationPage.clickButtonRegister();
         registrationPage.checkRegistration();
    }

    // Регистрация с неккоректным паролем
    @Test
    public void registrationWithIncorrectPasswordTest(){
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
        driver.close();
        driver.quit();
    }
}
