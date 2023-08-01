package com.companyrest.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class TestwithPath {

    @BeforeAll
    public static void init(){

        baseURI = "http://44.201.152.160:1000/ords/hr";

    }

    @DisplayName("GET Request Method with Path() Method")
    @Test
    public void test1(){

        Response response =
                given().accept(ContentType.JSON)
                        .queryParam("q", "{\"region_id\":2}")
                        .when().get("/countries");

        assertEquals(200, response.statusCode());
        System.out.println("response.path(\"limit\") = " + response.path("limit"));
        System.out.println("response.path(\"hasMore\") = " + response.path("hasMore"));
        System.out.println("response.path(\"items[0].country_id\") = " + response.path("items[0].country_id"));
        System.out.println("response.path(\"items[1].country_name\") = " + response.path("items[1].country_name"));
        System.out.println("response.path(\"items[2].links[0].href\") = " + response.path("items[2].links[0].href"));
        List<String> countryNames = response.path("items.country_name");
        System.out.println("countryNames = " + countryNames);
        List<Integer> allRegionsID = response.path("items.region_id");
        for (Integer regionID : allRegionsID){
            System.out.println("regionID = " + regionID);
            assertEquals(2,regionID);
        }




    }




}
