package com.companyrest.tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class HrJsonPath {


    @BeforeAll
    public static void init(){
        baseURI = "http://44.201.152.160:1000/ords/hr";

    }

    @DisplayName("hr-jsonpath")
    @Test
    public void test1(){

        Response response = get("/countries");
        JsonPath jsonpath = response.jsonPath();
       String secondCountryName = jsonpath.getString("items[1].country_name");
        System.out.println("secondCountryName = " + secondCountryName);
    }

    @Test
    public void test2(){

        Response response = get("/countries");
        JsonPath jsonpath = response.jsonPath();
        List<String> countryIds = jsonpath.getList("items.country_id");
        System.out.println(countryIds);
    }
    @Test
    public void test3(){

        Response response = get("/countries");
        JsonPath jsonpath = response.jsonPath();
        List<String> regionIds = jsonpath.getList("items.findAll{it.region_id==2}.country_name");
        System.out.println(regionIds);
    }

    @Test
    public void test4(){

        Response response = given().accept(ContentType.JSON)
                        .queryParam("limit", 107)
                           .when().get("/employees");


      JsonPath jsonpath = response.jsonPath();
      List<String> emails = jsonpath.getList("items.findAll{it.job_id==\"IT_PROG\"}.email");
        System.out.println(emails);
    }

    @Test
    public void test5(){

        Response response = given().accept(ContentType.JSON)
                .queryParam("limit", 107)
                .when().get("/employees");


        JsonPath jsonpath = response.jsonPath();
        List<String> salaries = jsonpath.getList("items.findAll{it.salary>10000}.first_name");
        System.out.println(salaries);
    }



    @Test
    public void test6(){

        Response response = given().accept(ContentType.JSON)
                .queryParam("limit", 107)
                .when().get("/employees");


        JsonPath jsonpath = response.jsonPath();
        String maxsalary = jsonpath.getString("items.max {it.salary}.first_name");
        System.out.println(maxsalary);
    }

}
