package com.reqres.crudtest;

import com.reqres.model.UserPojo;
import com.reqres.testbase.TestBase;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase                                                         //All tests extends TestBase to fetch URL
{
    @Test(priority=-2)
    public void getListUsers()
    {
                given()                                                                             //static imports
                        .header("Content-Type" , "application/json; charset=utf-8")
                        .contentType(ContentType.JSON)
                                                                                                 //after ?  key , value
                .when()                                                                        //given includes when , then
                .get("/?page=2")                                                           //Endpoint


                     .then()
                     .statusCode(200)                                                 //validation
                                                                                       //displaying response in console window
                     .log().all() ;                                                   //Records all in console for reference, proof, evidence
    }

    @Test(priority=-1)
    public void postCreateUser()
    {
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Michael");
        userPojo.setJob("Dancer");

        given()
                .header("Content-Type" , "application/json; charset=utf-8")              //application/json not .
                .contentType(ContentType.JSON)
                .body(userPojo)                                                             //pre-requisite for creating new user

                .when()
                .post()                                                                 //already url is in TestBase, so empty

                .then()
                .statusCode(201)
                .log().all();                                              //printing the response
    }
    //Capture id from post and use for put /patch/delete

    @Test(priority=0)
    public void putUpdateUser()
    {
        UserPojo userPojo = new UserPojo();
        userPojo.setName("John");                                          //Can change everything
        userPojo.setJob("Pilot");

        given()
                .header("Content-Type" , "application/json")
                .contentType(ContentType.JSON)

                .when()
                .body(userPojo)
                .put("/id")

                .then()
                .statusCode(200)
                .log().all();                                          //Pretty Print is the method in Response
    }
    @Test(priority=1)
    public void patchUser()
    {
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Jamie");
        userPojo.setJob("Pilot");

        given()
                .header("Content-Type" , "application/json")

                .when()
                .body(userPojo)
                .patch("/id")                                            //path inside double quotes its a String

                .then()
                .statusCode(200)
                .log().all();
    }
    @Test(priority=2)
    public void deleteUser()
    {
        given()

                .when()
                .delete("/id")

                .then()
                .statusCode(204)                                         //No response body content
                .log().all();
    }
}
