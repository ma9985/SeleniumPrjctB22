package com.cybertek.CybertekOfficeHours.Day02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
1. The user navigates to the login page: http://zero.webappsecurity.com/login.html
2. The user logs in with the user "username" and the password "password"
3. The user navigates to Account Activity page
4. Then The page should have the title "Zero - Account Activity"
5. Then Account drop down should have the following options :
(Savings, Checking, Savings, Loan, Credit Card, Brokerage)
6. Brokerage option should have "No results."
 */
public class ZeroBankAccountActivity1 {

    WebDriver driver;

    @BeforeClass
    public void setupClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/login.html");

        //login
        driver.findElement(By.cssSelector("[id*='user_log']")).sendKeys("username");
        driver.findElement(By.cssSelector("[id*='user_pass']")).sendKeys("password");
        driver.findElement(By.cssSelector("[type*='sub']")).click();
        driver.findElement(By.cssSelector("[id*='primary']")).click();
    }

        @Test
        public void accountActivity() {
        driver.findElement(By.cssSelector("[id*='acco']")).click();
        String expectedTitle = "Zero - Account Activity";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "verify title");

        // 5. Then Account drop down should have the following options :
        // (Savings, Checking, Savings, Loan, Credit Card, Brokerage)
            List<String> expectedOptions = new ArrayList<>(Arrays.asList("Savings", "Checking", "Savings",
                    "Loan", "Credit Card", "Brokerage"));

            Select accountDropdown = new Select(driver.findElement(By.cssSelector("[id*='aa']")));

            List<WebElement> actualOptions = accountDropdown.getOptions();

            List<String> actualOptionsTexts = new ArrayList<>();

            for (WebElement actualOption : actualOptions) {
                actualOptionsTexts.add(actualOption.getText());


            }
            System.out.println("actualOptionsTexts = " + actualOptionsTexts);
            System.out.println("actual Options = " + actualOptions);
            System.out.println("expected options = " + expectedOptions);
            Assert.assertEquals(actualOptionsTexts,expectedOptions, "verify dropdowns");

            //6. Brokerage option should have "No results."
            accountDropdown.selectByVisibleText("Brokerage");
            String expectedText = " No results.";
            String actualText = driver.findElement(By.cssSelector("[class*='well']")).getText();

        }
    @AfterClass
    public void tearDownClass(){
        driver.quit();
    }
    }

