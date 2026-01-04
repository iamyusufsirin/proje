package com.example;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AppTest {

    @Test
    public void getRequestTest() {
        given()
            .baseUri("https://jsonplaceholder.typicode.com") 
        .when()
            .get("/posts/1") 
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .time(lessThan(2L));
    }

   @Test
    public void postRequestTest() {
        String jsonBody = "{ \"title\": \"deneme\", \"body\": \"icerik\", \"userId\": 1 }";

        given()
            .contentType("application/json") 
            .body(jsonBody)
        .when()
            .post("https://jsonplaceholder.typicode.com/posts") 
        .then()
            .statusCode(201)        
            .body("title", equalTo("deneme")); 
    }
}