package com.infoshare;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class test_4 {

    private WebDriver driver;




    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openPageDnd() {
        driver.get("http://demoqa.com/droppable/");

        //drag an object
        WebElement boxOne = driver.findElement(By.id("draggableview"));

        WebElement boxTwo = driver.findElement(By.id("droppableview"));

        Actions moveIt = new Actions(driver);
        moveIt.dragAndDrop(boxOne, boxTwo).perform();
        assertThat(boxTwo.getText()).isEqualToIgnoringCase("Dropped!");
    }

    @Test
    public void openPageDateCheck() {




        driver.get("http://demoqa.com/datepicker/");

        WebElement datePicker = driver.findElement(By.id("datepicker1"));
        datePicker.click();

        String insertDate = getDate("November",11,1911);
        datePicker.sendKeys(insertDate);




        Actions inputDate = new Actions(driver);
        inputDate.click();

        WebElement checkDay = driver.findElement(By.className("ui-datepicker-current-day"));
        assertThat(checkDay.getText()).isEqualToIgnoringCase("11");

        WebElement checkMonth = driver.findElement(By.className("ui-datepicker-month"));
        assertThat(checkMonth.getText()).isEqualToIgnoringCase("November");

        WebElement checkYear = driver.findElement(By.className("ui-datepicker-year"));
        assertThat(checkYear.getText()).isEqualToIgnoringCase("1911");


    }

    private String getDate (String month, int day, int year) {
        return month + " " + day + ", " + year;



    }

}
