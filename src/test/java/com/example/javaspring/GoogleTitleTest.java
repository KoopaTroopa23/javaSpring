package com.example.javaspring;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;


class GoogleTitleTest {
    WebDriver driver;

    @BeforeEach void setUp()    { driver = new ChromeDriver(); }
    @AfterEach  void tearDown() { driver.quit(); }

    @Test
    void searchWorks() {
        driver.get("https://www.saucedemo.com");               // free practice site
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
}