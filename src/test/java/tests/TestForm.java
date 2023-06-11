package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

public class TestForm extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void firstTest() {
        step("Open form", () -> {
            registrationPage.openPage()
                    .removeFooter();
        });
        step("Fill form", () -> {
            registrationPage.setFirstName("Veronika")
                    .setLastName("Iatckaia")
                    .setUserEmail("neznatnov@gmail.com")
                    .setGender("Female")
                    .setUserNumber("0123456789")
                    .setBirthDate("17", "April", "1995")
                    .setSubject("Computer Science")
                    .setHobbies("Reading")
                    .setPicture("cats.jpg")
                    .setAddress("Street 1")
                    .setState("Uttar Pradesh")
                    .setCity("Agra")
                    .clickSubmit();
        });
        step("Verify results", () -> {
            registrationPage.verifyRegistrationResultModalAppears()
                    .verifyResult("Student Name", "Veronika Iatckaia")
                    .verifyResult("Student Email", "neznatnov@gmail.com")
                    .verifyResult("Gender", "Female")
                    .verifyResult("Mobile", "0123456789")
                    .verifyResult("Date of Birth", "17 April,1995")
                    .verifyResult("Subjects", "Computer Science")
                    .verifyResult("Hobbies", "Reading")
                    .verifyResult("Picture", "cats.jpg")
                    .verifyResult("Address", "Street 1")
                    .verifyResult("State and City", "Uttar Pradesh Agra");
        });
    }
}
