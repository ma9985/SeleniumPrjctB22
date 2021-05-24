package com.cybertek.tests.day6_testing_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestNG_Intro {
    @BeforeMethod
    public void setupMethod (){
        System.out.println("--> Before method is running....");
    }
    @AfterMethod
public void after1Method() {
        System.out.println("--> After Method is running...");
}
    public void teardownMethod() {
        System.out.println("--> After method is running....");
    }
    @Test
    public void test1() {
        System.out.println("Running test 1....");
        String actual = "apple";
        String expected = "apple";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test2() {
        System.out.println("Running test 2....");
    }

}
