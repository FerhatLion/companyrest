package com.companyrest.tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestWithJsonPath {

    @BeforeAll
    public static void init(){

    baseURI = "http://44.201.152.160:8000";


    }


    @DisplayName("GET one spartan with jsonPath")
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .pathParam("id",10)
                .when().get("/api/spartans/{id}");

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());

        System.out.println("response.path(\"name\").toString() = " + response.path("name").toString());
        JsonPath jsonpath = response.jsonPath();

        int id = jsonpath.getInt("id");
        String name = jsonpath.getString("name");
        String gender =jsonpath.getString("gender");
        long phone = jsonpath.getLong("phone");

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);



    }


}
