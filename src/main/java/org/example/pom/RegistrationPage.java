package org.example.pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationPage {

    protected static WebDriver driver;

    // Ссылка на страницу регистрации
    private final String  URL = "https://stellarburgers.nomoreparties.site/register";


    // Локатор для поля ввода Имя

    private final By fieldName  = By.xpath(".//fieldset[1]//input[@name='name']");

    // Локатор для поля ввода Email
    private final By  fieldEmail = By.xpath(".//fieldset[2]//input[@name='name']");

    // Локатор для поля ввода пароля
    private final By fieldPassword = By.xpath("//input[@name='Пароль']");

    // Локатор для кнопки Зарегистрироваться
    private final By registerButton  = By.xpath("//button[text()='Зарегистрироваться']");

    // Локатор сообщения "Неккоректный пароль"
    private final By errorDuringRegistration  = By.xpath(".//p[@class='input__error text_type_main-default']");

    // Локатор сообщения "Неккоректный пароль"
    private final By buttonLogin  = By.xpath(".//button[@class='button_button__33qZ0 " +
            "button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");


    // Локатор кнопки "Войти"
    private final By BUTTON_LOGIN = By.xpath(".//a[@class='Auth_link__1fOlj']");


    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }


    // Ожидание... Нужно ли?

    // Открыть страницу регистрации
    public void openPage(){
        driver.get(URL);
    }


    // Метод вводит в поле имя для регистрации
    public void fillTheNameField(String nameValue){
        driver.findElement(fieldName ).sendKeys(nameValue);
    }

    // Метод вводит в поле Email почту для регистрации
    public void fillTheEmailField(String emailValue){
        driver.findElement(fieldEmail).sendKeys(emailValue);
    }


    // Метод вводит в поле пароль для регистрации
    public void fillThePasswordField(String passValue){
        driver.findElement(fieldPassword).sendKeys(passValue);
    }

    // Метод кликает на кнопку Зарегистрироваться
    public void clickButtonRegister(){
        driver.findElement(registerButton).click();
    }

    // Метод кликает на кнопку Войти
    public void clickButtonLogin(){
        driver.findElement(BUTTON_LOGIN).click();
    }


    // Проверяем что пользователь зарегистровался
    public void checkRegistration(){
        boolean isTextVisible = driver.findElement(buttonLogin).isDisplayed();
        assertTrue(isTextVisible);
    }

    // Проверяем что пользователь не смог зарегистрироваться
    public void checkRegistrationNotRegistering(){
        String text = driver.findElement(errorDuringRegistration).getText();
        boolean isTextVisible = driver.findElement(errorDuringRegistration).isDisplayed();
        assertEquals("Некорректный пароль", text);
        assertTrue(isTextVisible);
    }
}
