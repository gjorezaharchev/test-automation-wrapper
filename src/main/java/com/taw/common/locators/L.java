package com.taw.common.locators;

import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class L {
    private static String xpath;
    public static By jsonObj(String jsonObject)
    {

        Locators locators = Locators.valueOf("ID");
        switch (locators){
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
            default:
                System.out.println("unsupported locator");
                break;

        }


        // returned the xpath formed along with By Class
        return By.xpath(xpath);
    }

    public static void main(String[] args){
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/locators/HomePage.json"));

            // convert JSON file to map
            Map<?, ?> map = gson.fromJson(reader, Map.class);

            // print map entries
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
