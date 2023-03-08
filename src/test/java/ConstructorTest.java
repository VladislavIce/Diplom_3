import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.checkerframework.checker.units.qual.A;
import org.example.browser.ChooseBrowser;
import org.example.pom.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConstructorTest {
    protected static WebDriver driver;

    @Before
    public void setUp() {
        // Для браузера Яндекс использовать "Yandex"
        // Для браузера Хром использовтаь "Chrome"
        driver = ChooseBrowser.getBrowser("Chrome");
    }

    @DisplayName("Проверить переход к разделу \"Соусы\"")
    @Description("На главной странице сайта, в конструкторе проверяем переход между разделами \"Булки\", \"Соусы\", \"Начинки\"")
    @Test
    public void switchSectionSaucesTest() {
        MainPage mainPage = new MainPage(driver);
            mainPage.openPage();
            mainPage.clickButtonSauces();
            mainPage.successfulSwitchSectionSauces();
    }

    @DisplayName("Проверить переход к разделу \"Начинки\"")
    @Description("На главной странице сайта, в конструкторе проверяем переход между разделами \"Булки\", \"Соусы\", \"Начинки\"")
    @Test
    public void switchSectionTopping() {
        MainPage mainPage = new MainPage(driver);
            mainPage.openPage();
            mainPage.clickButtonToppings();
            mainPage.successfulSwitchSectionToppings();
    }

    @DisplayName("Проверить переход к разделу \"Булки\"")
    @Description("На главной странице сайта, в конструкторе проверяем переход между разделами \"Булки\", \"Соусы\", \"Начинки\"")
    @Step("Сперва переключаемся на раздел \"Начинки\" после чего переходим в раздел \"Булки\"")
    @Test
    public void switchSectionRolls() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickButtonToppings();
        mainPage.clickButtonRolls();
        mainPage.successfulSwitchSectionRolls();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
