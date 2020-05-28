package com.automation.tests.review;

import com.automation.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
public class Feb5Review {
    /**Before static import
     * Utils.revert(var);
     * boolean var=false
     * public boolean returnSomething(){
     * return var;
     * }
     * public boolean returnSomething(){
     *     boolean var=false;
     *     if(var==false){
     *         return false
     *     }else{
     *         return true;
     *     }
     * }
     * after static import
     * revert(var)
     */

    @BeforeAll
    public static void setup() {
        baseURI = ConfigurationReader.getProperty("omdb.uri");
    }
    @Test
    @DisplayName("Find movie by title")
    public void search_test(){
      Response response= given().
                accept(ContentType.JSON).
                queryParam("s","Terminator").
                queryParam("apikey","9f94d4d0").
                when().
                get().prettyPeek();
        /**
         *given().
         *     content type:JSON, XML, TEXT..
         *     QUERY PARAMETRS:API KEY, QUERIES: q=I need this&b=and_thos_as_well
         *     authentication:auth().basic("username","password")
         *     header:Authorization:Type encypted_string
         *     cookies
         * when().
         * Http verb/method,request:
         * get,put(),post(),delete(),patch()
         * we an specify request with or without path:
         * get()
         */

    }

}
