package org.example.pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainPage {

    protected static WebDriver driver;

    // Ссылка на главную страницу сайта
    private final String URL = "https://stellarburgers.nomoreparties.site/";

    // Локатор кнопки "Войти в аккаунт"
    private final By BUTTON_SIGN_IN = By.xpath(".//button[@class='button_button__33qZ0 " +
            "button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");


    // Локатор кнопки "Личный кабинет"
    private final By BUTTON_PERSONAL_AREA = By.xpath("//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");


    // Локатор кнопки "Оформить заказ"
    private final By BUTTON_CHECKOUT = By.xpath(".//button[text()='Оформить заказ']");


    // Локатор кнопки "Булки"
    private final By ROLLS = By.xpath(".//span[@class='text text_type_main-default' and text()='Булки']");

    // Локтор кнопки "Соусы"
    private final By SAUCES = By.xpath(".//span[@class='text text_type_main-default' and text()='Соусы']");

    // Локатор кнопки "Начинки"
    private final By TOPPINGS = By.xpath(".//span[@class='text text_type_main-default' and text()='Начинки']");

    // Локатор того, что кнопка "Соусы" активна
    private final By ACTIVE_SAUCE = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");

    // Локатор того, что кнопка "Начинки" активна
    private final By ACTIVE_TOPPINGS = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");

    // Локатор того, что кнопка "Булки" активна
    private final By ACTIVE_ROLL = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }


    // Открыть главную страницу сайт
    public void openPage(){
        driver.get(URL);
    }

    // Клик на кнопку "Булки"
    public void clickButtonRolls() {
        driver.findElement(ROLLS).click();
    }

    // Клик на кнопку "Соусы"
    public void clickButtonSauces() {
        driver.findElement(SAUCES).click();
    }

    // Клик на кнопку "Начинки"
    public void clickButtonToppings() {
        driver.findElement(TOPPINGS).click();
    }

    // Клик на кнопку "Войти в аккаунт"
    public void clickButtonSignIn(){
        driver.findElement(BUTTON_SIGN_IN).click();
    }


    // Клик на кнопку "Личный кабинет"
    public void clickButtonPersonalArea(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(BUTTON_PERSONAL_AREA));
        driver.findElement(BUTTON_PERSONAL_AREA).click();
    }

    // Проверям появилась ли кнопка "Оформить заказ", кнопка появляется только у авторизованного пользователя
    public void checkSuccessfulAuthorization(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(BUTTON_CHECKOUT));
        String text = driver.findElement(BUTTON_CHECKOUT).getText();
        boolean isTextVisible = driver.findElement(BUTTON_CHECKOUT).isDisplayed();
            assertEquals("Оформить заказ", text);
            assertTrue(isTextVisible);
    }

    // Ожидаение элемента на страницу
    public void waitingElement(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(BUTTON_CHECKOUT));
    }

    // Метод проверят успешный переход в раздел конструктора "Соусы"
    public void successfulSwitchSectionSauces(){
        boolean isTextVisible = driver.findElement(ACTIVE_SAUCE).isDisplayed();
        Assert.assertTrue(isTextVisible);
    }

    // Метод проверяет успешный переход в раздел констуктора "Начинка"
    public void successfulSwitchSectionToppings() {
        boolean isTextVisible = driver.findElement(ACTIVE_TOPPINGS).isDisplayed();
        Assert.assertTrue(isTextVisible);
    }

    // Метод проверяет успешный переход в раздел констурктора "Булки"
    public void successfulSwitchSectionRolls() {
        boolean isTextVisible = driver.findElement(ACTIVE_ROLL).isDisplayed();
        Assert.assertTrue(isTextVisible);
    }
}
