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
    private final By buttonExit = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");

    // Локатор кнопки "Конструктор"
    private final By buttonConstructor = By.xpath("//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");                              //p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']


    // Локатор логотипа Stellar Burger
    private final By  logoStellaBurger = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");

    public PersonalAreaPage(WebDriver driver) {
        this.driver = driver;
    }


    // Метод кликает по кнопке "Конструктор"
    public void clickButtonConstructor(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(buttonConstructor));
        driver.findElement(buttonConstructor).click();
    }

    // Метод кликает по логотипу Stellar Burger
    public void clickLogoStellarBurger(){
        driver.findElement(logoStellaBurger).click();
    }

    // Метод кликает на кнопку Выход
    public void clickButtonExit(){
       new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(buttonExit));
        driver.findElement(buttonExit).click();
    }

    // Проверяем успешный ввход в личный кабинет
    public void successfulLoginPersonalArea(){
       new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(buttonExit));
        String text = driver.findElement(buttonExit).getText();
        boolean isTextVisible = driver.findElement(buttonExit).isDisplayed();
        Assert.assertEquals("Выход", text);
        Assert.assertTrue(isTextVisible);
        }
}
