package com.reqres.testbase;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase
{
    @BeforeClass
    public void inIt()
    {
        RestAssured.baseURI = "https://reqres.in/";                         //RestAssured is a class
        RestAssured.basePath = "/api/users";

    }
}

// RestAssured.baseURI = PropertyReader.getInstance().getProperty("baseURI");
//Inside PropertyReader class
// inside getInstance() method
//then go to getProperty() method
//inside that config.properties path given
//inside baseURI


