package com.automation.tests.day7;
import com.automation.pojos.Job;
import com.automation.pojos.Location;
import com.automation.pojos.Spartan;
import com.automation.utilities.ConfigurationReader;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
public class SpartansTestsDay7 {
    @BeforeAll
    public static void setup() {
        baseURI = ConfigurationReader.getProperty("spartan.uri");
    }
//add new spartan from the external JSON file
@Test
@DisplayName("Add new user by using external JSON file")
public void test1(){
        File file =new File(System.getProperty("user.dir")+"/spartan.json");
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(file).
                when().
                post("/spartans").
                then().assertThat().
                statusCode(201).
                body("success",is("A Spartan is Born!"));

    }
@Test
@DisplayName("Add new user by using map")
public void test2(){
        Map<String, Object>spartan=new HashMap<>();
        spartan.put("phone", 12888888888L);
        spartan.put("gender","Male");
        spartan.put("name","John Doe");
        //you must specify content type, whenever you POST
    //contentType(ContentType.Json)
    given().
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(spartan).
            when().
            post("/spartans").prettyPeek().
            then().assertThat().
            statusCode(201).
            body("success", is("A Spartan is Born")).
            body("data.name",is("John Deer")).
            body("data.gender",is("Male"));



}

}
