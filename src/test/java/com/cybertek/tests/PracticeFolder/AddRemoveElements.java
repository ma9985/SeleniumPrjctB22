package com.cybertek.tests.PracticeFolder;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements/
3. Click to “Add Element” button
//tagName[.='text']
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button
6. Verify “Delete” button is NOT displayed after clicking.
 */
public class AddRemoveElements {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        WebElement addElementButton = driver.findElement(By.xpath("//button[.='Add Element']"));
        Thread.sleep(1000);
        addElementButton.click();

        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));
        if(deleteButton.isDisplayed()) {
            System.out.println("Yes delete button displayed PASSED!");
        }else {
            System.out.println("No it is not displayed FAILED!");
        }

        //5. Click to “Delete” button
        deleteButton.click();

        //6. Verify “Delete” button is NOT displayed after clicking.
        if(!deleteButton.isDisplayed()) {
            System.out.println("Delete button is Not displayed after  PASS!");
        } else{
            System.out.println("Delete button is displayed after FAILED! ");
        }

    }
}
