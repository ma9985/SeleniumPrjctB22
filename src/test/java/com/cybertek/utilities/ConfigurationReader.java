package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1.create properties object
   private static Properties properties = new Properties();

   static {
       //2. load the file into FileInputStream
       try {
           FileInputStream file = new FileInputStream("configuration.properties");
           //3. load properties with the file (configuration.properties)
           properties.load(file);

           //close the file
           file.close();

       } catch (IOException e) {

           System.out.println("File not found in configuration properties.");
       }
   }
   //USE THE ABOVE CREATED LOGIC TO CREATE A RE-USABLE STATIC METHOD
    public static String getProperty(String keyWord){
        return properties.getProperty("keyWord");
    }

}
