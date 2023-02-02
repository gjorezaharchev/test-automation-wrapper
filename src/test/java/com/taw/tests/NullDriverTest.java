package com.taw.tests;

import com.taw.common.elements.Actions;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NullDriverTest extends Actions {

    @Test(groups = {"abc"})
    public void test(){
       // browser.open();
        System.out.println(driver);
        assertThat("A").isEqualTo("Login Successfull!");

    }
}
