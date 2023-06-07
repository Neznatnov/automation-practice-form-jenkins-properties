package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import components.ResultsModalComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModalComponent resultsModal = new ResultsModalComponent();



    //Elements
    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city");


    //Actions
    public RegistrationPage openPage(){
        open("https://demoqa.com/automation-practice-form");


        return this;
    }
    public RegistrationPage removeFooter(){
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;

    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setUserEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }
    public RegistrationPage setGender(String value){
        gender.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);

        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year){
        calendarComponent.setDate(day,month,year);

        return this;
    }

    public RegistrationPage setSubject(String value){
        subjectInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage setHobbies(String value){
        hobbiesInput.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setPicture(){
        uploadPicture.uploadFromClasspath("cats.jpg");

        return this;
    }
    public RegistrationPage setAddress(String value){
        currentAddressInput.setValue(value);

        return this;
    }
    public RegistrationPage setState(String value){
        stateInput.click();
        stateInput.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setCity(String value){
        cityInput.click();
        cityInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage clickSubmit(){
        $("#submit").click();
        return this;
    }

    public RegistrationPage verifyRegistrationResultModalAppears(){
        resultsModal.verifyModalAppears();

        return this;
    }


    public RegistrationPage verifyResult(String key, String value){
        resultsModal.verifyResult(key, value);

        return this;
    }
}
