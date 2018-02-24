package com.infoshare;

import com.infoshare.Page.RegistrationPage;
import com.infoshare.Page.utilities.Date;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class test_5 {

    private WebDriver driver;
    private RegistrationPage registrationPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        registrationPage = new RegistrationPage(driver);
    }


    @Test
    public void registration() {
        driver.get("http://demo.nopcommerce.com/");
        WebElement register = driver.findElement(By.className("ico-register"));
        register.click();

        registrationPage.selectGender("male");
        registrationPage.enterFirstName("test");
        registrationPage.enterLastName("testowy");
        registrationPage.selectDate(new Date("11", "11", "1918"));
        registrationPage.enterEmail("test1@test.pl");
        registrationPage.enterCompany("test");
        registrationPage.uncheckNewsletter();
        registrationPage.enterPassword("testtesttest");
        registrationPage.enterConfirmPassword("testtesttest");
        registrationPage.clickRegisterButton();
        assertThat(registrationPage.getResultText()).contains("Your registration completed");

    }


}
