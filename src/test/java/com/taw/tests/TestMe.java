package com.taw.tests;

import com.taw.common.elements.Elements;
import com.taw.objects.Home;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

class TestMe extends Elements {

    private final Home home = new Home();


    @BeforeMethod
    public void set_up() {
        browser.open();
        browser.maximize();
        //browser.resize(500,500);
        //browser.move(50,50);
        //browser.minimize();
        //browser.fullScreen();
        navigate.to($("URL"));
    }

    @Test
    public void some_test() {

        //homepage
        input.type(home.searchText, $("TERM") + Keys.ENTER.toString());
        System.out.println(environment);
        wait.sleep(5000);


    }

    @AfterMethod
    public void tear_down() {
        browser.close();
    }


    /*public static void main(String[] args) throws Exception {
        System.out.println(Arrays.deepToString(excel("C:\\Users\\gjore.zaharchev\\Desktop\\a.xlsx", "Sheet1", 2, 4)));
        //excel("C:\\Users\\gjore.zaharchev\\Desktop\\a.xlsx", "Sheet1");
    }*/
}
