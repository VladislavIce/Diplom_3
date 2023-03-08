package org.example.pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAreaPage {


    protected static WebDriver driver;

    // Локатор кнопки "Выход"
    private final By BUTTON_EXIT = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");

    // Локатор кнопки "Конструктор"
    private final By BUTTON_CONSTRUCTOR = By.xpath("//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");                              //p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']


    // Локатор логотипа Stellar Burger
    private final By LOGO_STELLA_BURGER = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");

    public PersonalAreaPage(WebDriver driver) {
        this.driver = driver;
    }


    // Метод кликает по кнопке "Конструктор"
    public void clickButtonConstructor(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(BUTTON_CONSTRUCTOR));
        driver.findElement(BUTTON_CONSTRUCTOR).click();
    }

    // Метод кликает по логотипу Stellar Burger
    public void clickLogoStellarBurger(){
        driver.findElement(LOGO_STELLA_BURGER).click();
    }

    // Метод кликает на кнопку Выход
    public void clickButtonExit(){
       new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(BUTTON_EXIT));
        driver.findElement(BUTTON_EXIT).click();
    }

    // Проверяем успешный ввход в личный кабинет
    public void successfulLoginPersonalArea(){
       new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(BUTTON_EXIT));
        String text = driver.findElement(BUTTON_EXIT).getText();
        boolean isTextVisible = driver.findElement(BUTTON_EXIT).isDisplayed();
        Assert.assertEquals("Выход", text);
        Assert.assertTrue(isTextVisible);
        }
}
