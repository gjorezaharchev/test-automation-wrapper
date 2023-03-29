package com.taw.tests;

import com.taw.common.elements.Actions;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCon extends Actions {

    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.id("loginBtn");
    By loginMsg = By.id("loginMsg");

    @BeforeMethod(onlyForGroups = "regression", alwaysRun = true)
    public void setup() {
        browser.open();
        browser.maximize();
        navigate.to($("URL"));

    }


    @Test(groups = "regression")
    private void seetest() {
        browser.open();
        browser.maximize();
        navigate.to($("URL"));
        //System.out.println("TEST");
       // Utils.setValueFromPropertyFile("src/test/resources/Environments/", "TEST", "some.key", "some value");
        //wait.sleep(3000);
        //input.type(username, "gjore");
        //input.type(password, "MyP@$$w0rd");
       // button.click(loginBtn);
       // assertThat(extract.elementValue(loginMsg)).isEqualTo("Login Successfull!");
        System.out.println("-------------------------------------");
       // System.out.println(driver.getWindowHandles());
        input.type(By.name("qa"), "topka");
        wait.sleep(2000);

    }

    @AfterMethod(onlyForGroups = "regression", alwaysRun = true)
    public void tear_down() {
        browser.close();
    }

}
