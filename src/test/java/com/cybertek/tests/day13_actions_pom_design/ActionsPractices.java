package com.cybertek.tests.day13_actions_pom_design;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 1.Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
 * 2.Switch to iframe.
 * 3.Double click on the text “Double-click me to change my text color.”
 * 4.Assert: Text’s “style” attribute value contains “red
 */

public class ActionsPractices {

    @Test
    public void p2_double_click_test(){
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        //2.Switch to iframe
        Driver.getDriver().switchTo().frame("iframeResult");

        //Locate the text to double click
        WebElement textToDoubleClick = Driver.getDriver().findElement(By.id("demo"));

        // 3.Double click on the text “Double-click me to change my text color.”
        Actions actions = new Actions(Driver.getDriver());

        // use the actions object to double click to already located web element
        BrowserUtils.sleep(2);
        actions.doubleClick(textToDoubleClick);
       // actions.perform();

        // 4.Assert: Text’s “style” attribute value contains “red
        String expectedInStyle = "red";
        String actualInStyle = textToDoubleClick.getAttribute("style");

        Assert.assertTrue(actualInStyle.contains(expectedInStyle));
    }

}
