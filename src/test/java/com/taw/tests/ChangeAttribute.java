package com.taw.tests;

import com.taw.common.elements.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
}
