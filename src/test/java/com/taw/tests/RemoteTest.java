package com.taw.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteTest {
    ChromeOptions options = new ChromeOptions();
    WebDriver dr1;

    @Test
    public void test1(){
        //options.addArguments("-incognito");
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("-headless");
        try {
            dr1 = new RemoteWebDriver(new URL("http://localhost:4444"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        dr1.navigate().to("https://google.com");
        Assert.assertEquals(dr1.getTitle(), "Google");
        dr1.quit();
    }
}
