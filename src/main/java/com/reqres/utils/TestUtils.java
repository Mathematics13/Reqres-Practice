package com.reqres.utils;

import java.util.Random;

public class TestUtils {

    public static String getRandomValue()                            //returns String value
    {
        Random random = new Random();                             //Random is a class that has various methods to generate random values
        int randomInt = random.nextInt(100000);           //at the time of execution
        return Integer.toString(randomInt);                    //Converts integer to String
    }
}
