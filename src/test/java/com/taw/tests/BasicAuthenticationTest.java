package com.taw.tests;

import com.taw.common.elements.Actions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAuthenticationTest extends Actions {

    @BeforeMethod
    public void before_method(){
        browser.open();
        browser.maximize();
        browser.basic_authentication("gjore.zaharchev", "Kavadarci06!");
        navigate.to("https://seavuslife.com/DesktopModules/AuthenticationServices/ActiveDirectory/WindowsSignin.aspx?portalid=0");

    }

    @Test
    public void test1(){
        wait.sleep(1000);
        String title = extract.elementValue(By.xpath("(//*[@class='mng-text-theme'])[1]/div"));
        Assert.assertEquals(title, "eds_largeText" );
    }

    @AfterMethod
    public void after_method(){
        browser.close();
    }
}
