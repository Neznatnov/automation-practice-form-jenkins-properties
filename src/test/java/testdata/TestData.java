package testdata;

import com.github.javafaker.Faker;

public class TestData {
    public static Faker faker = new Faker();


    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = String.valueOf(faker.options().option(Gender.class).getValue()),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            birthDay = String.format("%02d", faker.number().numberBetween(1, 25)),
            birthYear = String.valueOf(faker.number().numberBetween(1900, 2100)),
            birthMonth = String.valueOf(faker.options().option(Month.class).getValue()),
            subject = String.valueOf(faker.options().option(Subject.class)),
            hobbies = String.valueOf(faker.options().option(Hobbies.class).getValue()),
            address = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = cityUser(),
            picture = "cats.jpg";

    public static String cityUser() {
        String varCity;
        switch (state) {
            case "NCR":
                varCity = faker.options().option("Delhi", "Gurgaon", "Noida");
                return varCity;


            case "Uttar Pradesh":
                varCity = faker.options().option("Agra", "Lucknow", "Merrut");
                return varCity;


            case "Haryana":
                varCity = faker.options().option("Karnal", "Panipat");
                return varCity;

            case "Rajasthan":
                varCity = faker.options().option("Jaipur", "Jaiselmer");
                return varCity;


            default:
                return "";
        }
    }
    public enum Gender {
        MALE("Male"),
        FEMALE("Female"),
        OTHER("Other");

        private final String value;

        Gender(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public enum Month {
        JANUARY("January"),
        FEBRUARY("February"),
        MARCH("March"),
        APRIL("April"),
        MAY("May"),
        JUNE("June"),
        JULY("July"),
        AUGUST("August"),
        SEPTEMBER("September"),
        NOVEMBER("November"),
        OCTOBER("October"),
        DECEMBER("December");
        private final String value;

        Month(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public enum Subject {
        MATHS,
        HINDI,
        ACCOUNTING,
        ARTS,
        BIOLOGY,
        PHYSICS,
        CHEMISTRY,
        COMMERCE,
        ECONOMICS,
        CIVICS,
        ENGLISH,
        HISTORY;

    }
    public enum Hobbies {
        SPORTS("Sports"),
        READING("Reading"),
        MUSIC("Music");
        private final String value;

        Hobbies(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
