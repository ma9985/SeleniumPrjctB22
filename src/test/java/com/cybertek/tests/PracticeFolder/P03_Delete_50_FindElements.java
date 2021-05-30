package com.cybertek.tests.PracticeFolder;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class P03_Delete_50_FindElements {
    public static void main(String[] args) throws InterruptedException {
        // TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/add_remove_elements
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        // 3. Click to “Add Element” button 50 times
        for (int i = 0; i < 50; i++) {
            WebElement addElement = driver.findElement(By.xpath("//button[.='Add Element']"));
            Thread.sleep(1000);
            addElement.click();

        }

        // 4. Verify 50 “Delete” button is displayed after clicking.
       List<WebElement> listDeleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));
        System.out.println("number of delete buttons on the page: " + listDeleteButtons);

        // 5. Click to ALL “Delete” buttons to delete them.
        for( WebElement button : listDeleteButtons) {
            button.click();
        }

        // 6. Verify “Delete” button is NOT displayed after clicking.
        if(!deleteButton.isDisplayed()) {
            System.out.println("Delete button is Not displayed after  PASS!");
        } else{
            System.out.println("Delete button is displayed after FAILED! ");

        }
//        catch (StaleElementReferenceException exception) {
//            System.out.println("StaleElementException has been thrown.");
//            System.out.println("It means element has been completely deleted from the HTML.");
//            System.out.println("Delete button is not displayed. Verification PASSED!");
        }


}
