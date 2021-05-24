package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// TASK: NEW METHOD CREATION
// Method name : getDriver
// Static method
// Accepts String arg: browserType
//   - This arg will determine what type of browser is opened
//   - if "chrome" passed --> it will open chrome browser
//   - if "firefox" passed --> it will open firefox browser
// RETURN TYPE: "WebDriver"

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType) {

        if(browserType.equals("chrome")) {
            WebDriverManager.chromedriver().setup();

            return new ChromeDriver();

        } else if (browserType.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();

            return new FirefoxDriver();
        }else {
            System.out.println("Given browser type doe not exit. Driver = null");
            return null;
        }



    }
}
