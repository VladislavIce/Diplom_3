package org.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage {
    protected static WebDriver driver;


    // Локатор кнопки "Войти"
    private final By BUTTON_LOGIN = By.xpath(".//a[@class='Auth_link__1fOlj']");

    public RecoveryPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    // Метод кликает на кнопку "Войти"
    public void clickButtonLogin(){
        driver.findElement(BUTTON_LOGIN).click();
    }


}
