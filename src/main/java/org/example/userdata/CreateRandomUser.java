package org.example.userdata;
import org.apache.commons.lang3.RandomStringUtils;

public class CreateRandomUser {

    public  User random() {
        return new User(RandomStringUtils.randomAlphanumeric(8) + "@yandex.ru",
                RandomStringUtils.randomAlphanumeric(10),
                RandomStringUtils.randomAlphanumeric(10));
    }
}


