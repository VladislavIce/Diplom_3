package org.example.pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    protected static WebDriver driver;

    // Локатор поля ввода Email
    private final By fieldEmail = By.xpath(".//input[@name='name']");

    // Локатор поля ввода пароля
    private final By fieldPassword = By.xpath(".//input[@name='Пароль']");

    // Локатор кнопки войти
    private final By buttonLogin = By.xpath(".//button[text()='Войти']");

    // Локатор кнопки "Зарегистрироваться"
    private final By buttonRegister = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Зарегистрироваться']");

    // Локатор кнопки "Восстановить пароль"
    private final By buttonRecoveryPassword = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод вводит почту для входа
    public void enterEmail(String emailValue) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(fieldEmail));
        driver.findElement(fieldEmail).sendKeys(emailValue);
    }

    // Метод вводит пароль для входа
    public void enterPassword(String passwordValue) {
        driver.findElement(fieldPassword).sendKeys(passwordValue);
    }

    // Метод кликает на кнопку войти
    public void clickButtonLogin() {
        driver.findElement(buttonLogin).click();
    }

    // Метод кликает по кнопке "Зарегистрироваться"
    public void clickButtonRegister() {
        driver.findElement(buttonRegister).click();
    }

    // Метод кликает по кнопке "Восстановить пароль"
    public void clickButtonRecoveryPassword() {
        driver.findElement(buttonRecoveryPassword).click();
    }

    public void successExitAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(buttonLogin));
        String text = driver.findElement(buttonLogin).getText();
        boolean isVisableText = driver.findElement(buttonLogin).isDisplayed();
        Assert.assertEquals("Войти", text);
        Assert.assertTrue(isVisableText);
    }


}
