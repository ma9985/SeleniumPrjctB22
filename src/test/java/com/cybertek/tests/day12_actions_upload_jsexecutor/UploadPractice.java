package com.cybertek.tests.day12_actions_upload_jsexecutor;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
TC #14: Upload Test
1. Go to http://practice.cybertekschool.com/upload
2. Find some small file from your computer, and get the path of it.
3. Upload the file.
4. Assert:
-File uploaded text is displayed on the page
 */
public class UploadPractice {

    @Test
    public void UploadTest() {
//        1. Go to
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");

//        2. Find some small file from your computer, and get the path of it.
        String path = "C:/Users/moeq2/Desktop/thumbnail.jfif";

//        3. Upload the file.
        WebElement chooseFile = Driver.getDriver().findElement(By.id("file-upload"));

        WebElement uploadButton  = Driver.getDriver().findElement(By.id("file-submit"));

        BrowserUtils.sleep(1);
        // sending the file path to the chooseFile WebElement
        chooseFile.sendKeys(path);

        //click to upload button

        uploadButton.click();
//        4. Assert:
//        -File uploaded text is displayed on the page
        WebElement fileUploadedMessage = Driver.getDriver().findElement(By.tagName("h3"));

        Assert.assertTrue(fileUploadedMessage.isDisplayed());

        Driver.closeDriver();
    }
}
