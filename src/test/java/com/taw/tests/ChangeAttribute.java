package com.taw.tests;

import com.taw.common.elements.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ChangeAttribute extends Actions {

    @Test
    public void test1(){
        browser.open();
        navigate.to("https://demoqa.com/dragabble");
        navigate.scroll(0, 400);

        button.click(By.id("draggableExample-tab-containerRestriction"));

        wait.sleep_in_seconds(4);
        interactions.changeAttributeValue("querySelector('#containmentWrapper > div')", "style", "position: relative; left: 100px; top: 90px;");
        wait.sleep_in_seconds(3);
        browser.close();
    }

    @Test
    public void test2(){
        browser.open();
        navigate.to("https://demoqa.com/slider");
        navigate.scroll(0, 300);
        wait.sleep_in_seconds(5);
        WebElement slider = driver.findElement(By.cssSelector("#sliderContainer > div.col-9 > span > input"));
        org.openqa.selenium.interactions.Actions move = new org.openqa.selenium.interactions.Actions(driver);
        org.openqa.selenium.interactions.Action action = (org.openqa.selenium.interactions.Action) move.dragAndDropBy(slider, 200, 30).build();
        action.perform();
        //interactions.changeAttributeValue("querySelector('#sliderContainer > div.col-9 > span > input')", "value", "53");
        wait.sleep_in_seconds(5);
        browser.close();
    }
}
