package com.infoshare;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class test_2 {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openAndLogin() {
        driver.get("https://www.phptravels.net/admin");


// inputs data to login

        driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/input[1]")).sendKeys("admin@phptravels.com");
        driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/input[2]")).sendKeys("demoadmin");

// set timeout
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//click button
        driver.findElement(By.xpath("/html/body/div[1]/form[1]/button")).click();

    }




}