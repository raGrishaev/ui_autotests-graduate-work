package beeline.utils;

import com.github.javafaker.Faker;

public class RandomUtils {
    Faker faker = new Faker();

    public String fakerEmail() {

        return faker.internet().emailAddress();
    }

}



