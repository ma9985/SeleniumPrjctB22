package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

        //1-setup the browser driver

        WebDriverManager.chromedriver().setup();


        //2-create instance of selenium web driver
        // this line opens a browser
        WebDriver driver= new ChromeDriver();

        //this line will basically maximize the browser size
        driver.manage().window().maximize();


        //3- get the page for Tesla.com

        driver.get("https://www.tesla.com");

        System.out.println("current title : " + driver.getTitle());

        String currentUrl =  driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);


                // putting 3 seconds of wait /stops code for 3 secs.
        Thread.sleep(3000);  // hover over and add exception for not being red underline

        //going back using navigations
        driver.navigate().back();

        Thread.sleep(3000);

        //going forward using navigations
        driver.navigate().forward();

        Thread.sleep(3000);

        //refreshing the page using navigations
        driver.navigate().refresh();

        Thread.sleep(3000);

        //going to another url using .to() method
        driver.navigate().to("https://www.google.com");

        System.out.println("current title : " + driver.getTitle());
        currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //this method will close the currently opened browser
        //it will only close 1 browser
        driver.close();

    }
}
