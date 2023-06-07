package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static testdata.TestData.*;


public class RegistrationFormTest extends TestBase {


    @Test
    void fillRegistrationForm() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        registrationPage.openPage()
                .removeFooter()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubject(subject)
                .setHobbies(hobbies)
                .setPicture()
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        
        registrationPage.verifyRegistrationResultModalAppears()
                        .verifyResult("Student Name", firstName + " " + lastName)
                        .verifyResult("Student Email", userEmail)
                        .verifyResult("Gender", gender)
                        .verifyResult("Mobile", userNumber)
                        .verifyResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                        .verifyResult("Subjects", subject)
                        .verifyResult("Hobbies", hobbies)
                        .verifyResult("Picture", "cats.jpg")
                        .verifyResult("Address", address)
                        .verifyResult("State and City", state + " " + city);


    }
}
