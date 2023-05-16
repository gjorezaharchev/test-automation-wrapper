package com.taw.common.locators;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class L {
    private static String xpath;
    private static String identifier;
    private static String locator;


    public static By l(String jsonObject) {

        InputStream is = null;
        try {
            is = new FileInputStream("src/test/resources/Locators/Locators.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String jsonTxt = null;
        try {
            jsonTxt = IOUtils.toString(is, "UTF_8");
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        JSONObject json = new JSONObject(jsonTxt);
        Iterator iterator = json.keys();
        int i = 0;

        while (iterator.hasNext()) {

            System.out.println(String.valueOf(json.keys().next()) + i++);
            String pageStr = (String) iterator.next();
            JSONObject page = json.getJSONObject(pageStr);

            JSONArray loc = page.getJSONArray(jsonObject);
            JSONObject element = loc.getJSONObject(0);
            identifier = element.getString("identifier");
            locator = element.getString("locator");
            System.out.println(identifier + locator);
            if (locator != null) {
                break;
            }

        }

        String locators = locator;
        Locators locatorsEnum = Locators.valueOf(identifier);

        switch (locatorsEnum) {
            case ID:
                xpath = "//*[@id='" + locators + "']";
                break;
            case TAG:
                xpath = "//" + locators + "";
                break;
            case NAME:
                xpath = "//*[@name='" + locators + "']";
                break;
            case TEXT:
                xpath = "//*[contains(text(),'" + locators + "')]";
                break;
            case CLASS:
                xpath = "//*[contains(@class,'" + locators + "')]";
                break;
            case VALUE:
                xpath = "//*[@value='" + locators + "']";
                break;
            case XPATH:
                xpath = String.valueOf(locators);
                break;
            case CONTAINSTEXT:
                xpath = "//*[contains(text(),'" + locators + "')]";
                break;
            case DATA:
                xpath = "//*[@data='" + locators + "']";
                break;
        }


        // returned the xpath formed along with By
        return By.xpath(xpath);
    }


}
