package com.taw.common.elements;

import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class JSONUtils {


    public JSONObject convertResponseToJSONObject(String responseString) {
        try {
            JSONObject jsonObj = new JSONObject(responseString);
            return jsonObj;
        } catch (JSONException e) {
            System.err.println(
                    "It is not possible to create a JSONObject from the input string, returning null. Exception:");
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void convert(){
        String a = "{  \n" +
                "\"name\" : \"Ronaldo\",  \n" +
                "\"nickname\" : \"Sam\",  \n" +
                "\"id\" : 312,  \n" +
                "\"age\" : 21,    \n" +
                "\"height\" : 163,    \n" +
                "\"lastOverScore\" : [4, 1, 6, 6, 2, 1]  \n" +
                "}  ";
        Gson g = new Gson();
        String pr = g.toJson(g);
        System.out.println(pr);
    }
}
