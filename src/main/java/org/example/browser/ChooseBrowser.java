package org.example.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChooseBrowser {
    private static String pathToDriverChrome = "C:\\WebDriver\\bin\\chromedriver.exe";
    private static String pathToDriverYandex = "C:\\WebDriver\\bin\\yandexdriver.exe";

    private static String pathToBinaryFile = "C:\\Users\\Pc\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";

    private static String driver = "webdriver.chrome.driver";

    public static WebDriver getBrowser(String browserName) {
        if (browserName.equals("Yandex")) {
            System.setProperty(driver, pathToDriverYandex);
            ChromeOptions options = new ChromeOptions();
            options.setBinary(pathToBinaryFile);
            return new ChromeDriver(options);
        } else if (browserName.equals("Chrome")) {
            System.setProperty(driver, pathToDriverChrome);
            return new ChromeDriver();
        } else {
            throw new RuntimeException("Введите имя браузера корректно!");
        }
    }
}


