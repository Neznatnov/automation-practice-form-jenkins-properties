package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static testdata.TestData.*;


public class RegistrationFormTest extends TestBase {

    @Tag("registration")
    @Test
    @DisplayName("Successful registration")
    void fillRegistrationForm() {
        //SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open form", () -> {
            registrationPage.openPage()
                    .removeFooter();
        });
        step("Fill form", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserEmail(userEmail)
                    .setGender(gender)
                    .setUserNumber(userNumber)
                    .setBirthDate(birthDay, birthMonth, birthYear)
                    .setSubject(subject)
                    .setHobbies(hobbies)
                    .setPicture(picture)
                    .setAddress(address)
                    .setState(state)
                    .setCity(city)
                    .clickSubmit();
        });
        step("Verify results", () -> {
            registrationPage.verifyRegistrationResultModalAppears()
                    .verifyResult("Student Name", firstName + " " + lastName)
                    .verifyResult("Student Email", userEmail)
                    .verifyResult("Gender", gender)
                    .verifyResult("Mobile", userNumber)
                    .verifyResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                    .verifyResult("Subjects", subject)
                    .verifyResult("Hobbies", hobbies)
                    .verifyResult("Picture", picture)
                    .verifyResult("Address", address)
                    .verifyResult("State and City", state + " " + city);
        });

    }

}

