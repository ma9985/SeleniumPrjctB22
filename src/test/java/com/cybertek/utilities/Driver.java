package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    /*
    creating the private constructor so this class object is not reachable from outside.
     */
    private Driver(){
        /*
        making our 'Driver' instance private so that it is not reachable from outside of the class.
        because we want it to run before everything else and also we will use it in static method.
         */
    }
    private static WebDriver driver;

    /*
    Creating re-usable utility method that will return same 'driver' instance everytime we call it.
     */
    private static WebDriver getDriver(){
        if(driver == null){

            String browserType = ConfigurationReader.getProperty("browser");

            switch(browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }
        /*
        same driver instance will be returned every time we call Driver.getDriver(); method
         */
        return  driver;

    }
}
