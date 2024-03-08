package com.taw.tests;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.taw.common.Global;
import com.taw.objects.api.UserCreateWithList;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RestUserCreateWithList extends Global {
    private RequestSpecification httpRequest;
    private Response response;
    private JsonPath jsonPathEvaluator;
    Faker faker;

    @BeforeMethod
    public void set_up(){
        RestAssured.baseURI =$("RESTURI");
        RestAssured.port = Integer.valueOf($("PORT"));
        httpRequest = RestAssured.given();
    }

    @Test
    public void getTest(){
        response = httpRequest.get("/pet/5");
        response = httpRequest.param("search", "gjore").param("search", "zaharchev").get("/pet/5");
        jsonPathEvaluator = response.jsonPath();

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.header("Content-Type")).isEqualTo("application/json");
        assertThat(response.time()).isLessThan(10000);
        assertThat(jsonPathEvaluator.get("id").toString()).isEqualTo(5);
    }

    @Test
    public void postTest(){
        UserCreateWithList userCreateWithList = new UserCreateWithList("Gjore.Zaharchev", "Gjore","Zaharchev", "gjore.zaharchev@seavus.com","P@$$w0rd","+38970743742",1);
        httpRequest.post("user/createWithList");
        httpRequest.header("ContentType", "json");
        httpRequest.body(new Gson().toJson(userCreateWithList));
        response.prettyPrint();
    }


}
