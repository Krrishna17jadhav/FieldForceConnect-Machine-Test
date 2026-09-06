package com.feildforce.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LunchURl_Test {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://test.fieldforceconnect.com/");

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("username")
        ));
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return new Object[][] {
            {"abc@123gmail.com", "Dnyanesh@123"},
            {"abc@123gmail.com", "123456"},
            {"", "Dnyanesh@123"},
            {"abc@123gmail.com", ""},
            {"", ""}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {

        
        driver.findElement(By.name("username"))
                .sendKeys(username);

        
        driver.findElement(By.name("password"))
                .sendKeys(password);

        driver.findElement(By.xpath("//button[@type='submit']"))
                .click();

        
        if (username.equals("abc@123gmail.com")
                && password.equals("Dnyanesh@123")) {

          
            wait.until(ExpectedConditions.urlContains("dashboard"));

            String currentUrl = driver.getCurrentUrl();

            Assert.assertTrue(
                    currentUrl.contains("dashboard"),
                    "Login failed. Current URL: " + currentUrl
            );

            System.out.println("PASS: Login successful");
        }

       
        else {

           
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("errorMessage")
            ));

            String errorMessage = driver.findElement(
                    By.id("errorMessage")
            ).getText();

            Assert.assertTrue(
                    errorMessage.length() > 0,
                    "Expected error message was not displayed"
            );

            System.out.println(
                    "PASS: Error message displayed - " + errorMessage
            );
        }
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}