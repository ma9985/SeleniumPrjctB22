package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC3_Date_Selection {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
}
@Test
public void yearTest () throws InterruptedException{
    WebElement yearLocator = driver.findElement(By.xpath("//select[@id='year']"));
    Select selectYear = new Select(yearLocator);
    selectYear.selectByVisibleText("1922");
    String actualYear = selectYear.getFirstSelectedOption().getText();
    //String expectedYear = "1922";
    Assert.assertEquals(actualYear, "1922");

    }
    @Test
    public void monthTest() throws InterruptedException{

        WebElement monthLocator = driver.findElement(By.xpath("//select[@id='month']"));
        Select selectMonth = new Select(monthLocator);
        selectMonth.selectByValue("December");
        String actualMonth = selectMonth.getFirstSelectedOption().getText();
        Assert.assertEquals(actualMonth, "December");
    }

    @Test
    public void dayTest() throws InterruptedException {

        WebElement dayLocator = driver.findElement(By.xpath("//select[@id='day']"));
        Select selectDay = new Select(dayLocator);
        selectDay.selectByIndex(0);
        String actualDay = selectDay.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDay, 0);
        System.out.println(actualDay);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
}
}