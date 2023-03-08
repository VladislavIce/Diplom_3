package org.example.pom;
import org.apache.commons.lang3.RandomStringUtils;

public class CreateRandomUser {
    // Генерим рандомное имя
    public String getRandomName() {
            return (RandomStringUtils.randomAlphanumeric(10));
    }

    // Генерим рандомный Email
    public String getRandomEmail() {
        return (RandomStringUtils.randomAlphanumeric(10) + "@yandex.ru");
    }

    // Генерим рандомный пароль
    public String getRandomPassword() {
        return (RandomStringUtils.randomAlphanumeric(6));
    }

    // Генерим невалидный пароль
    public String getInvalidRandomPassword() {
        return (RandomStringUtils.randomAlphanumeric(5));
    }
}

