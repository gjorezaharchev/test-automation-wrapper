package com.taw.tests.nasdaq;

import com.taw.common.elements.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Actions {

    @BeforeMethod
    public void beforeLoginAsAdmin(){
        browser.open();
        navigate.to($("URL"));
        input.type(LoginPage.username, $("ADMIN_USERNAME"));
    }
}
