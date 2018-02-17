package com.infoshare;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class test_3 {


    private WebDriver driver;




    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openPage() {
        driver.get("http://demoqa.com/registration/");

        // fill data
        driver.findElement(By.xpath("//*[@id=\"name_3_firstname\"]")).sendKeys("Tomasz");
        driver.findElement(By.xpath("//*[@id=\"name_3_lastname\"]")).sendKeys("Sikorski");

   //ratio

        driver.findElement(By.xpath("//input[@value='single']")).click();

    //checkbox

        driver.findElement(By.xpath("//input[@value='dance']")).click();
        driver.findElement(By.xpath("//input[@value='reading']")).click();
        driver.findElement(By.xpath("//input[@value='cricket ']")).click();

       // country

//        Select chooseCountry = new Select(driver.findElement(By.xpath("//*[@id=\"dropdown_7\"]")));
//        chooseCountry.selectByValue("Poland");


        selectFromDropdown("//*[@id=\"dropdown_7\"]", "Poland");




//birth date

//        driver.findElement(By.xpath("//*[@id=\"mm_date_8\"]")).sendKeys("9");
//        driver.findElement(By.xpath("//*[@id=\"dd_date_8\"]")).sendKeys("22");
//        driver.findElement(By.xpath("//*[@id=\"yy_date_8\"]")).sendKeys("1981");

        selectFromDropdown("//*[@id=\"mm_date_8\"]", "9");
        selectFromDropdown("//*[@id=\"dd_date_8\"]", "22");
        selectFromDropdown("//*[@id=\"yy_date_8\"]", "1981");


        driver.findElement(By.xpath("//*[@id=\"phone_9\"]")).sendKeys("0507787366");

        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("tomasz");
        driver.findElement(By.xpath("//*[@id=\"email_1\"]")).sendKeys("tsikorski@outlook.com");



        driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys("bla bla bla bla");

        driver.findElement(By.xpath("//*[@id=\"password_2\"]")).sendKeys("!QAZxsw2");
                driver.findElement(By.xpath("//*[@id=\"confirm_password_password_2\"]")).sendKeys("!QAZxsw2");


       // driver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[14]/div/input")).click();

        // set timeout
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//
//    @After
//    public void closeWindow() {
//        driver.close();
  }

    private void selectFromDropdown(String xpath, String value) {
        Select chooseCountry = new Select(driver.findElement(By.xpath(xpath)));
        chooseCountry.selectByValue(value);

    }
}