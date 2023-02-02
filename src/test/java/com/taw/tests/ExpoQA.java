package com.taw.tests;

import com.taw.common.elements.Actions;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpoQA extends Actions {
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
        input.type(username, "gjore");
        input.type(password, "MyP@$$w0rd");
        button.click(loginBtn);
        assertThat(extract.elementValue(loginMsg)).isEqualTo("Login Successfull!");
    }
    @AfterMethod(onlyForGroups = "regression", alwaysRun = true)
    public void tear_down() {
        browser.close();
    }
}
