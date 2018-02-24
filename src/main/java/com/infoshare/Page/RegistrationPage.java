package com.infoshare.Page;

import com.infoshare.Page.utilities.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;

    @FindBy(id = "gender-male")
    WebElement genderMaleButton;
    @FindBy(id = "gender-female")
    WebElement genderFemaleButton;
    @FindBy(name = "FirstName")
    WebElement firstNameInput;
    @FindBy(name = "LastName")
    WebElement lastNameInput;
    @FindBy(name = "DateOfBirthDay")
    WebElement setDay;
    @FindBy(name = "DateOfBirthMonth")
    WebElement setMonth;
    @FindBy(name = "DateOfBirthYear")
    WebElement setYear;
    @FindBy(name = "Email")
    WebElement emailInput;
    @FindBy(name = "Company")
    WebElement companyInput;
    @FindBy(name = "Newsletter")
    WebElement selectNewsletter;
    @FindBy(name = "Password")
    WebElement passwordInput;
    @FindBy(name = "ConfirmPassword")
    WebElement confirmPasswordInput;
    @FindBy(name = "register-button")
    WebElement registerButtonClick;
    @FindBy(className = "result") WebElement registrationResult;

    private WebDriverWait wait;



    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }


    public void selectGender(String gender) {
        if (gender.equals("male")) {
            genderMaleButton.click();

        } else if (gender.equals("female")) {
            genderFemaleButton.click();
        }
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void selectDate(Date date) {
        new Select(setDay).selectByValue(date.getDay());
        new Select(setMonth).selectByValue(date.getMonth());
        new Select(setYear).selectByValue(date.getYear());
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterCompany(String company) {
        companyInput.sendKeys(company);
    }

    public void uncheckNewsletter() {
        selectNewsletter.click();
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void clickRegisterButton(){
        registerButtonClick.click();
    }

    public String getResultText(){
        wait.until(ExpectedConditions.visibilityOf(registrationResult));
        return registrationResult.getText();

    }
}
