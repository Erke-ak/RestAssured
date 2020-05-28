package com.automation.tests.day5;

import com.automation.pojos.Job;
import com.automation.pojos.Location;
import com.automation.utilities.ConfigurationReader;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.baseURI;

public class POJOTesting {
    @BeforeAll
    public static void setup() {
        baseURI = ConfigurationReader.getProperty("ords.uri");

    }
    @Test
    @DisplayName("Get job info from JSON and convert it into POJO")
    public void test1(){
        Response response=given().
                accept(ContentType.JSON).
                when().
                get("/jobs").prettyPeek();
        JsonPath jsonPath=response.jsonPath();
        //this is deserialization
        //from JSON tO POJO(java object)
        Job job =jsonPath.getObject("items[0]",Job.class);

        System.out.println(job);
        System.out.println("Job id: "+job.getJob_id());
    }
    @Test
    @DisplayName("Convert from POJO to JSON")
    public void test2(){
        Job sdet=new Job("SDET","Software Develpoment Engineer in Test",5000,20000);
        Gson gson=new Gson();
        String json=gson.toJson(sdet);//convert POJO to JSON: serialization
        System.out.println("JSON file"+json);
        System.out.println("From toString(): "+sdet);
    }
    @Test
    @DisplayName("Convert JSON into collection of POJO's")
    public void test3(){
        Response response=given().
                accept(ContentType.JSON).
                when().
                get("/jobs");
        JsonPath jsonPath=response.jsonPath();
        List<Job> jobs=jsonPath.getList("items",Job.class);
        for (Job job:jobs){
            System.out.println(job.getJob_title());
        }
        for(Job job: jobs){
            System.out.println(job);
        }
    }
    @Test
    @DisplayName("Convert from JSON to Location POJO")
    public void test4(){
        Response response=given().
                accept(ContentType.JSON).
                when().
                get("/locations/{location_id}",2500);
        Location location=response.jsonPath().getObject("",Location.class);

        System.out.println(location);
        Response response2=given().
                accept(ContentType.JSON).
                when().
                get("/locations/{location_id}",2500);
       List<Location>locations=response2.jsonPath().getList("items",Location.class);
       for(Location l:locations){
           System.out.println(l);

       }
    }
}
