package com.cybertek.tests.day10_webtable_properties_practices;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TableUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Table_Task3 {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        String browser = ConfigurationReader.getProperty("browser");
        //This line returns String : chrome
        String url = ConfigurationReader.getProperty("dataTablesUrl");
        //This line returns String : http://practice.cybertekschool.com/tables#edit
        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // below code is same as above
        //driver.get(ConfigurationReader.getProperty("dataTablesUrl"));
    }
    @Test
    public void task3_return_tims_due_amount(){
        String url = ConfigurationReader.getProperty("browser");
        driver.get(url);

        WebElement timsDueAmountCell = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']/../td[4]"));

        System.out.println("timsDueAmountCell = " + timsDueAmountCell.getText());
        String actualTimResult = timsDueAmountCell.getText();
        String expectedTimResult = "$50.00";
        Assert.assertEquals(actualTimResult, expectedTimResult, "Tim's cell is not returning as expected.");
        //Note: Create locator for Tim that will be dynamic and doesn’t care in which row Tim is.
    }
    @Test
    public void task4_verify_order_method(){

        TableUtils.verifyOrder(driver, "random");
        TableUtils.verifyOrder(driver, "Tim");

    }

}