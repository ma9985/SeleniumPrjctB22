package com.cybertek.tests.PracticeFolder;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumEasyCheckboxVerification2 {
    public static void main(String[] args) {
        //1.Open Chrome browser
        //2.Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(" https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //3. Verify “Check All” button text is “Check All”
        WebElement checkAllButton = driver.findElement(By.xpath("//input[@id='check1']"));
        String actualText = checkAllButton.getAttribute("value");
        String expectedText = "Check All";
                if(actualText.equals(expectedText)) {
                    System.out.println("Text button verification PASSED!");
                } else {
                    System.out.println("Text button verification FAILED!");
                }

        //4.Click to “Check All” button
        checkAllButton.click();


        //5.Verify all check boxes are checked
        List<WebElement> checkBoxList = driver.findElements(By.xpath("//input[@class='cb1-element']"));
        for (WebElement checkbox : checkBoxList) {
            if(checkbox.isSelected()) {
                System.out.println("checkbox is selected is PASSED!");
            } else {
                System.out.println("Check box is selected is FAILED!");
            }

        }
        //6.Verify button text changed to “Uncheck All”
        String actualButtonTextAfterClick = checkAllButton.getAttribute("value");
        String expectedValueAfterClick = "Uncheck All";

        if(actualButtonTextAfterClick.equals(expectedValueAfterClick)) {
            System.out.println("Final verification PASSED!");
        } else {
            System.out.println("Final verification FAILED!");
        }
    }
}
