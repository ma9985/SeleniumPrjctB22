package com.cybertek.tests.day3_reviews_practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class F2_IncorrectTitleLogInTitleVerification {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        WebElement inputUsername = driver.findElement(By.id("email"));
        inputUsername.sendKeys("moeq24@yahoo.com");
        WebElement inputPassword = driver.findElement(By.id("pass"));
        inputPassword.sendKeys("some wrong password" + Keys.ENTER);

        String expectedTitle = "Log into Facebook";
        System.out.println("expectedTitle = " + expectedTitle);
        Thread.sleep(5000);

        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        if(actualTitle.equals(expectedTitle)) {
            System.out.println("Pass!");
        } else {
            System.out.println("FAIL!");
        }



    }
}
