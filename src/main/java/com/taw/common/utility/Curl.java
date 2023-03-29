package com.taw.common.utility;

import com.taw.common.Global;
import com.taw.common.elements.Actions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Curl extends Actions {
    public String curl(String command){

        //String command = String.format("curl -v -X 'GET' 'https://api.mailslurp.com/emails?page=0&size=20&sort=ASC&unreadOnly=false&apiKey=%s'",$string("mailSlurpAPIKey"));
        System.out.println(command);
        Process process;
        String response = null;
        try {
            process = Runtime.getRuntime().exec("curl " + command);
            StringBuilder sb = new StringBuilder();
            for (int ch; (ch = process.getInputStream().read()) != -1; ) {
                sb.append((char) ch);
            }
            response = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(response);
        return response;
    }

    @Test
    public void test1(){
        //String url = "https://kolomanrestaurant.com/";
        //String url = "https://www.lakoucafe.com/";
        String url = "https://www.xianfresh.com/";
        //String url = "https://darkroomseattle.com/";
        String result = curl(url);
        //System.out.println(result);
        /*Pattern pattern = Pattern.compile("<head>(.*?)</head>", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(result);
        if (matcher.find()) {
            //result = matcher.group(1);
            System.out.println(matcher.group(1));
        }*/
        String result1 = result.substring(result.indexOf("<html>") + 1, result.indexOf("</head>"));
        /*if((result1.substring(0, result1.indexOf("*")).equalsIgnoreCase(null))){
            result1 = result1.substring(result1.indexOf("."));
        }else{
            result1 = result1.substring(0, result1.indexOf("*"));
        }*/
        try {
            result1 = result1.substring(0, result1.indexOf("*"));
        } catch(StringIndexOutOfBoundsException e) {
            result1 = result1.substring(result1.indexOf("."));
        }

        if(result1.toLowerCase().contains(" bar ")&&result1.toLowerCase().contains("restaurant")){
            System.out.println("Check manually");
        }else if(result1.toLowerCase().contains(" bar ")||result1.toLowerCase().contains("restaurant")){
            if(result1.toLowerCase().contains(" bar ")){
                System.out.println("It is a bar");
            }else if (result1.toLowerCase().contains("restaurant")){
                System.out.println("it is a restsaurant");
            }
            if(result.toLowerCase().contains("reservation")){
                System.out.println("reservation is possible");
                browser.open();
                browser.maximize();
                navigate.to(url);
                try {
                    String a = extract.attributeValue(By.xpath("//*[contains(text(), 'Reservation')]|//*[contains(text(), 'reservation')]"), "href");
                    System.out.println(a);
                }catch(Exception e){
                    System.out.println("unable to find link");
                }

                browser.close();
            }else{
                System.out.println("check manually for reservations");
            }
        }
        else {
            System.out.println("venue type is unknown");
        }

        try {
            FileWriter myWriter = new FileWriter("src/test/resources/Data/filename.csv", true);
            myWriter.append("d, e, f\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
