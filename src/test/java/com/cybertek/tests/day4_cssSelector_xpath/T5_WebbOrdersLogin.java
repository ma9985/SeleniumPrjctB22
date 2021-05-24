package com.cybertek.tests.day4_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 TC #5: Basic login authentication
 1- Open a chrome browser
 2- Go to:
 http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
 3- Verify title equals:
 Expected: Web Orders Login
 4- Enter username: Tester
 5- Enter password: test
 6- Click “Sign In” button
 7- Verify title equals:
 Expected: Web Orders
 */
public class T5_WebbOrdersLogin {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        String expectedTitle = "Web Orders Login";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)) {
            System.out.println("VERIFICATION PASSED!");
        } else {
            System.out.println("VERIFICATION FAILED!");
        }
        // Enter user name - TESTER
        WebElement inputUsername = driver.findElement(By.id("ctl00_MainContent_username"));
        inputUsername.sendKeys("Tester");

        // 5- Enter password: test
        WebElement inputPassword = driver.findElement(By.id("ctl00_MainContent_password"));
        inputPassword.sendKeys("test");

        // 6- Click “Sign In” button
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_password"));
        loginButton.click();

        // 7- Verify title equals:
        //Expected: Web Orders
        String expectedHomePageTitle = "Web Orders";
        String actualHomePageTitle = driver.getTitle();
        if(actualHomePageTitle.equals(expectedHomePageTitle)) {
            System.out.println("Home page title verification PASSED!");
        }else{
            System.out.println("Home page title verification FAILED!!!");
        }




    }

}
