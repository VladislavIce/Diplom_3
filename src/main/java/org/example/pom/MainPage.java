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
    private final By buttonSugnIn = By.xpath(".//button[@class='button_button__33qZ0 " +
            "button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");


    // Локатор кнопки "Личный кабинет"
    private final By buttonPersonalArea = By.xpath("//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");


    // Локатор кнопки "Оформить заказ"
    private final By  buttonCheckout  = By.xpath(".//button[text()='Оформить заказ']");


    // Локатор кнопки "Булки"
    private final By rolls  = By.xpath(".//span[@class='text text_type_main-default' and text()='Булки']");

    // Локтор кнопки "Соусы"
    private final By  sauces = By.xpath(".//span[@class='text text_type_main-default' and text()='Соусы']");

    // Локатор кнопки "Начинки"
    private final By toppings = By.xpath(".//span[@class='text text_type_main-default' and text()='Начинки']");

    // Локатор того, что кнопка "Соусы" активна
    private final By  activeButton = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc " +
            "pt-4 pr-10 pb-4 pl-10 noselect']");



    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    // Открыть главную страницу сайт
    public void openPage() {
        driver.get(URL);
    }

    // Клик на кнопку "Булки"
    public void clickButtonRolls() {
        driver.findElement(rolls).click();
    }

    // Клик на кнопку "Соусы"
    public void clickButtonSauces() {
        driver.findElement(sauces).click();
    }

    // Клик на кнопку "Начинки"
    public void clickButtonToppings() {
        driver.findElement(toppings).click();
    }

    // Клик на кнопку "Войти в аккаунт"
    public void clickButtonSignIn() {
        driver.findElement(buttonSugnIn).click();
    }


    // Клик на кнопку "Личный кабинет"
    public void clickButtonPersonalArea() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(buttonPersonalArea ));
        driver.findElement(buttonPersonalArea ).click();
    }

    // Проверям появилась ли кнопка "Оформить заказ", кнопка появляется только у авторизованного пользователя
    public void checkSuccessfulAuthorization() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(buttonCheckout));
        String text = driver.findElement(buttonCheckout).getText();
        boolean isTextVisible = driver.findElement(buttonCheckout).isDisplayed();
        assertEquals("Оформить заказ", text);
        assertTrue(isTextVisible);
    }

    // Метод проверят успешный переход в разделе конструктор между Соусом, Начинкой, Булкой
    public void successfulSwitchSectionDesigner() {
        boolean isTextVisible = driver.findElement(activeButton).isDisplayed();
        Assert.assertTrue(isTextVisible);
    }

}
