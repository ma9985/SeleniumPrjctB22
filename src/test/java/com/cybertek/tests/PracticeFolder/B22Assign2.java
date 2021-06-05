package com.cybertek.tests.PracticeFolder;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class B22Assign2 {
    WebDriver driver;

    @BeforeClass
    public void Group() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://qa3.vytrack.com/user/login");
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("user15");

        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.sendKeys("UserUser123" + Keys.ENTER);
    }

    @Test
    public void ac1_2() throws InterruptedException {
        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleet.click();
        Thread.sleep(1000);
        WebElement vehicleOption = driver.findElement(By.xpath("//span[.='Vehicles']"));
        Assert.assertTrue(vehicleOption.getText().equals("Vehicles"));
        vehicleOption.click();

        Assert.assertEquals(driver.getTitle(), "Dashboard");

        driver.findElement(By.xpath("(//td[@data-column-label='License Plate'])[1]")).click();
        WebElement carInfo = driver.findElement(By.xpath("//h1[@class='user-name']"));
        Assert.assertEquals(carInfo.getText(), "Cybertek123 Spartan Alaska 2019 Black");
    }

    @Test
    public void ac3() throws InterruptedException {
        driver.findElement(By.xpath("(//li[@class='dropdown dropdown-level-1'])[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[.='Calendar Events']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        WebElement titleBox = driver.findElement(By.xpath("//input[contains(@id,'oro_calendar_event_form_title-uid')]"));
        titleBox.sendKeys("Java Truck driver");

        WebElement secondFrame = driver.findElement(By.xpath("//iframe[contains(@id,'oro_calendar_event_form_description-uid-60b')]"));
        driver.switchTo().frame(secondFrame);
        WebElement descriptionBox = driver.findElement(By.xpath("//body[@id='tinymce']/p"));
        descriptionBox.sendKeys("Picking up load of wooden spoons");
        driver.switchTo().parentFrame();

        driver.findElement(By.xpath("//span[@title='#46D6DB']")).click();

        driver.findElement(By.xpath("(//input[@placeholder='Choose a date'])[1]")).click();
        WebElement monthOptions = driver.findElement(By.xpath("//select[@data-handler='selectMonth']"));
        Select selectMonth = new Select(monthOptions);
        selectMonth.selectByIndex(9);

        WebElement yearOptions = driver.findElement(By.xpath("//select[@data-handler='selectYear']"));
        Select selectYear = new Select(yearOptions);
        selectYear.selectByValue("2022");

        driver.findElement(By.xpath("(//td[@data-month='9'])[8]")).click();

        driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h1[.='Java Truck driver']")).getText().equals("Java Truck driver"));

    }

    @Test
    public void ts4() throws InterruptedException {
        driver.findElement(By.xpath("(//span[@class='title title-level-1'])[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[.='Calendar Events']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//i[@class='fa-refresh'])[2]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//td[.='Java Truck driver']"))
                .getText().equals("Java Truck driver"));

    }
}
