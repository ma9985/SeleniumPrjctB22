package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownPractices {

    WebDriver driver;

    @BeforeClass
    public void setupClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void tc1_simple_dropdown_test() {

        //3. Verify “Simple dropdown” default selected value is correct
        //      Expected: “Please select an option”
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        WebElement currentlySelectedOption = simpleDropdown.getFirstSelectedOption();
        String actualTextOfCurrentOption = currentlySelectedOption.getText();
        String expectedTextOfCurrentOption = "Please select an option";

        Assert.assertTrue(actualTextOfCurrentOption.equals(expectedTextOfCurrentOption));

        //4. Verify “State selection” default selected value is correct
        //      Expected: “Select a State”
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String actualStateDropdownText = stateDropdown.getFirstSelectedOption().getText();
        String expectedStateDropdownText = "Select a State";

        Assert.assertTrue(actualStateDropdownText.equals(expectedStateDropdownText));

    }

    @Test
    public void tc2_state_dropdown_test() throws InterruptedException {
        //LOCATING STATE DROPDOWN
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //3. Select Illinois
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");
        //4. Select Virginia
        Thread.sleep(1000);
        stateDropdown.selectByValue("VA");
        //5. Select California
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);
        //stateDropdown.selectByVisibleText("California");

        //6. Verify final selected option is California.
        //Use all Select options. (visible text, value, index)

        String expectedOptionText = "California";
        String actualOptionText = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOptionText, expectedOptionText);

    }

    @Test
    public void yearTest() throws InterruptedException {
        WebElement yearLocator = driver.findElement(By.xpath("//select[@id='year']"));
        Select selectYear = new Select(yearLocator);
        selectYear.selectByVisibleText("1922");
        String actualYear = selectYear.getFirstSelectedOption().getText();
        //String expectedYear = "1922";
        Assert.assertEquals(actualYear, "1922");

    }

    @Test
    public void monthTest() throws InterruptedException {

        WebElement monthLocator = driver.findElement(By.xpath("//select[@id='month']"));
        Select selectMonth = new Select(monthLocator);
        selectMonth.selectByValue("11");
        String actualMonth = selectMonth.getFirstSelectedOption().getText();
        Assert.assertEquals(actualMonth, "December");
    }

    @Test
    public void dayTest() throws InterruptedException {

        WebElement dayLocator = driver.findElement(By.xpath("//select[@id='day']"));
        Select selectDay = new Select(dayLocator);
        selectDay.selectByIndex(0);
        String actualDay = selectDay.getFirstSelectedOption().getText();
        String expectedDay = "1";
        Assert.assertEquals(actualDay, expectedDay);
        System.out.println(actualDay);
    }

@Test
public void allValuesSelection () {
   WebElement languagesDropdown = driver.findElement(By.xpath("//select[@name='Languages']"));
    Select select = new Select(languagesDropdown);
    List<WebElement> allOptions = select.getOptions();

    for (int i = 0; i < allOptions.size(); i++) {
        select.selectByIndex(i);
        System.out.println(select.getAllSelectedOptions().get(i).getText());
    }
    select.deselectAll();

}

@Test
    public void NonSelectDropdown() {
        WebElement nonDropdown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        nonDropdown.click();

        WebElement facebook = driver.findElement(By.xpath("//a[.='Facebook']"));
        facebook.click();

        String expectedDropdown = "Facebook - Log In or Sign Up";
        String actualDropdown = driver.getTitle();

        Assert.assertEquals(expectedDropdown, actualDropdown);


}
    @AfterClass
    public void teardownClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }
}
