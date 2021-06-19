package com.cybertek.tests.day12_actions_upload_jsexecutor;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
TC	#15:	Hover	Test
1. Go	to	http://practice.cybertekschool.com/hovers
2. Hover	over	to	first	image
3. Assert:
a. “name:	user1”	is	displayed
4. Hover	over	to	second	image
5. Assert:
a. “name:	user2”	is	displayed
6. Hover	over	to	third	image
7. Confirm:
a. “name:	user3”	is	displayed
 */
public class ActionsPractices {

    @Test
    public void TC15_actions_hover() {
//        TC	#15:	Hover	Test
//        1. Go	to	http://practice.cybertekschool.com/hovers
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

        //Locating all the images here
        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        //Locating all "user" text
        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        //we must create object of Actions class to be able to use methods coming from there
        Actions actions = new Actions(Driver.getDriver());

        BrowserUtils.sleep(2);
//        2. Hover	over	to	first	image
        actions.moveToElement(img1).perform();

//        3. Assert:
//        a. “name:	user1”	is	displayed
        Assert.assertTrue(user1.isDisplayed(), "user1 text is not displayed...FAIL!! ");

//        4. Hover	over	to	second	image
        actions.moveToElement(img2).perform();

//        5. Assert:
//        a. “name:	user2”	is	displayed
        Assert.assertTrue(user2.isDisplayed(), "user2 text is not displayed... FAIL!!");

//        6. Hover	over	to	third	image
        actions.moveToElement(img3).perform();

//        7. Confirm:
//        a. “name:	user3”	is	displayed
        Assert.assertTrue(user3.isDisplayed(), "user3 text is not displayed... FAIL!!");

//    }
    }

    @Test
    public void scrolling_test(){
        // Go to http://practice.cybertekschool.com/
        Driver.getDriver().get("http://practice.cybertekschool.com/");

        // Scroll down to "Powered By Cybertek School"
        Actions actions = new Actions(Driver.getDriver());

        //Locate "Powered By Cybertek School"
        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));

        //Scroll using actions object
        BrowserUtils.sleep(2);
        actions.moveToElement(cybertekSchoolLink).perform();

        //Scrolling up using Keys.Page_UP button
        BrowserUtils.sleep(2);
        actions.sendKeys(Keys.PAGE_UP).perform();

        BrowserUtils.sleep(2);
        actions.sendKeys(Keys.PAGE_UP).perform();

        BrowserUtils.sleep(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();



    }

}