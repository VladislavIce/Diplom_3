package org.example.userdata;

import org.example.pom.LoginPage;
import org.example.pom.MainPage;
import org.openqa.selenium.WebDriver;

public class UserSteps {
    protected static WebDriver driver;

    private final String EMAIL = "Gdkmnvc@yandex.ru";
    private final String PASSWORD = "Adfdsfew";

    public UserSteps(WebDriver driver) {
        this.driver = driver;
    }

    // Вход в личный кабинет
    public void loginPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.openPage();
        mainPage.clickButtonPersonalArea();
        loginPage.enterEmail(EMAIL);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickButtonLogin();
        mainPage.clickButtonPersonalArea();
    }

    // Авторизация пользователя
    public void authorizationUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(EMAIL);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickButtonLogin();
    }
}
