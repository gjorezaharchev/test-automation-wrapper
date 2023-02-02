package com.taw.tests;

import com.taw.common.elements.Actions;

import org.openqa.selenium.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SEAQTest extends Actions {

    By passedPools = By.xpath("//*[text()='Passed Polls ']");
    By passedPoolsScrool = By.className("poll-content");

    org.openqa.selenium.interactions.Actions act = new org.openqa.selenium.interactions.Actions(driver);

    @Test
    public void test1(){
        browser.open();
        browser.maximize();
        navigate.to("https://seaq-test.seavus.com/login");
        link.click(passedPools);
       /* navigate.scroll(0,400);
        navigate.scrollToElement(By.xpath("//hr"), 4);
        wait.sleep(6000);
        navigate.scrollToElement(By.className("//hr"), 8);
        wait.sleep(6000);*/
        /*
        wait.sleep(6000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",getElement(passedPoolsScrool));
        wait.sleep(3000);
        String script = "document.getElementsByClassName('poll-content').scrollTop=6000;";
        js.executeScript(script);
        wait.sleep(6000);*/
//scrollHeight
        /*JavascriptExecutor js = (JavascriptExecutor)driver;
        String script2 = "window.scrollTo(0,document.getElementsByClassName('poll-content').scrollHeight)";
        String script3 = "arguments[0].scrollIntoView();";
        String script = "document.getElementsByClassName('poll-content').scrollHeight;";
        String script4 = "document.querySelector('#root > div > div.container.login > div:nth-child(2) > div.col-md-8 > div.right-boxes.poll-list-box > div').scrollTop=500";
       */ //js.executeScript(script3, getElement(passedPoolsScrool));
        //js.executeScript(script4);
        //WebElement el = getElement(passedPoolsScrool);
       /* js.executeScript(
                "scroll(" + el.getLocation().getX() + "," + el.getLocation().getY() + ")");
       */

    }

    @AfterMethod
    public void tear_down(){
        browser.close();
    }
}
