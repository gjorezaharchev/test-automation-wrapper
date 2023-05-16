package com.taw.tests;

import com.taw.common.elements.Actions;
import com.taw.common.locators.L;
import org.testng.annotations.Test;

public class TestGjore extends Actions {

    @Test
    public void test1(){
        /*browser.open();
        navigate.to("https://webmail.t.mk/cp/ps/main/login/Login?d=t.mk");
        input.type(L.l("email"), "gjoretest");
        wait.sleep(5000);
        browser.close();*/
        System.out.println(L.l("email"));
    }
}
