package com.cybertek.utilities;

public class BrowserUtils {
    /*
    method that willa accept in
    wait for given second duration
     */


        public static void sleep(int second) {

            second*=1000;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("something happened in the sleep method");
            }

        }


}
