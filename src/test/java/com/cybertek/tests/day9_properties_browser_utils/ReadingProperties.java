package com.cybertek.tests.day9_properties_browser_utils;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_file() throws IOException {

        //1. create object of properties class
        Properties properties = new Properties();

        //2. open the file using FileInputStream
        FileInputStream file = new FileInputStream("configuration.properties");

        //3.load the properties objects with our files
        properties.load(file);

        //reading from configuration.properties
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
    }

    @Test
    public void using_properties_methods(){

    }
}
