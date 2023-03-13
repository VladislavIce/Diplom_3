package org.example.userdata;

import io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.example.pom.LoginPage;
import org.example.pom.MainPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CustomSteps {
    protected static WebDriver driver;


    public CustomSteps(WebDriver driver){
        this.driver = driver;
    }

    // Вход в личный кабинет
   /* public void loginPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.openPage();
        mainPage.clickButtonPersonalArea();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickButtonLogin();
        mainPage.clickButtonPersonalArea();
    }

    // Авторизация пользователя
    public void authorizationUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickButtonLogin();
    }*/
}
