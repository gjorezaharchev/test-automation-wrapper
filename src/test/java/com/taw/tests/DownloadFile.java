package com.taw.tests;

import com.taw.common.elements.Actions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DownloadFile extends Actions {

    @Test(groups = {"regression"})
    public void test1(){
        browser.open();
        browser.maximize();
        navigate.to("https://demoqa.com/upload-download");
        wait.sleep_in_seconds(3);
        button.click(By.id("downloadButton"));

        wait.sleep_in_seconds(20);
        browser.close();


    }
}
