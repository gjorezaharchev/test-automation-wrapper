package com.taw.objects.api.petstore.pet;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.taw.common.Global;
import com.taw.objects.api.petstore.pet.pet.Pet;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;

public class Test1 extends Global {


    private RequestSpecification httpRequest;
    private JsonPath jsonPathEvaluator;
    private Faker faker;

    @BeforeMethod
    public void set_up() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        RestAssured.port = 443;
        httpRequest = RestAssured.given().urlEncodingEnabled(true);

    }

    @Test
    public void test1() {

        Pet pet = new Pet(1L, new Pet.Category(1L, "Torko"), "Torce", new String[]{"A.jpg", "B.jpg"}, Collections.singletonList(new Pet.Tags(1L, "Torko")), "available");

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(new Gson().toJson(pet));
        httpRequest.log().body();
        Response response = httpRequest.post("pet");

        System.out.println(response.statusCode());

        response.prettyPrint();
    }
}
