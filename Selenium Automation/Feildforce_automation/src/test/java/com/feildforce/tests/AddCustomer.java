package com.feildforce.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddCustomer{

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://test.fieldforceconnect.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("username")
        ));

        driver.findElement(By.name("username"))
        .sendKeys("abc@123gmail.com");


         driver.findElement(By.name("password"))
        .sendKeys("Dnyanesh@123");

         driver.findElement(By.xpath("//button[@type='submit']"))
        .click();
        Thread.sleep(3000);
    }

    @DataProvider(name = "customerData")
    public Object[][] customerData() {

        return new Object[][] {
          {"Amit Patil", "9820123456", "amit.patil@gmail.com", "Mahindra"},

          {"Sneha Kulkarni", "9765432108", "sneha.kulkarni@gmail.com", "Honda"},
        
        };
    }

    @Test(dataProvider = "customerData")
    public void addCustomer(String name, String mobile,
                             String email, String LeaderName)
                             throws InterruptedException {

       
        driver.findElement(
            By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[2]/div[2]/a/span")
        ).click();

        Thread.sleep(2000);

     
        driver.findElement(
            By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[2]/div[2]/div/div[1]/a/span")
        ).click();

        Thread.sleep(2000);

        driver.findElement(
            By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/button")
        ).click();

        Thread.sleep(2000);

        driver.findElement(
            By.xpath("/html/body/div[2]/div[3]/ul/li[1]/span[1]/span[2]")
        ).click();

        Thread.sleep(2000);

     
        driver.findElement(By.name("PersonName"))
                .sendKeys(name);

        driver.findElement(By.name("MobileNo"))
                .sendKeys(mobile);

        driver.findElement(By.name("Email"))
                .sendKeys(email);

        driver.findElement(By.name("LeadName"))
                .sendKeys(LeaderName);

      
        driver.findElement(
            By.xpath("//button[.//span[normalize-space()='Save']]")
        ).click();

       
        String toastMessage = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-rht-toaster] div"))).getText();

        System.out.println("Toast Message: " + toastMessage);
 
        Assert.assertTrue(
                toastMessage.toLowerCase().contains("success"),
                "Customer was not added successfully. Toast: " + toastMessage
        );

        System.out.println("Customer added successfully: " + name);

    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
    
    
