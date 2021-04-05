package com.taw.tests;

import com.taw.common.elements.Elements;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCon extends Elements {

    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.id("loginBtn");
    By loginMsg = By.id("loginMsg");

    @BeforeMethod
    public void setup() {
        browser.open();
        navigate.to($("URL"));
        browser.maximize();
    }

    @Test
    private void seetest() {
       /* input.type(username, "gjore");
        input.type(password, "MyP@$$w0rd");
        button.click(loginBtn);
        assertThat(extract.elementValue(loginMsg)).isEqualTo("Login Successfull!");
*/    }

    @AfterMethod
    public void tear_down() {
        browser.close();
    }

}
