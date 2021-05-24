package com.cybertek.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google
 */
public class P3_BackForth_Google {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://google.com");
       // driver.get("https://mail.google.com/mail/u/0/");
        driver.findElement(By.linkText("Gmail")).click();
        String expectedName = "Gmail";
        String actualName = driver.getTitle();

        if(actualName.contains(expectedName)) {
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        driver.navigate().back();

        if(actualName.equals(expectedName)) {
            System.out.println("PASS");
        } else{
            System.out.println("FAIL");
        }
        driver.close();
    }
}
