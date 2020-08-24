package com.taw.tests;

import com.taw.common.elements.Elements;
import com.taw.objects.Home;
import com.taw.objects.Web;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

class TestMe extends Elements {

    private final Home home = new Home();
    public final Web web = new Web();


    @BeforeMethod
    public void set_up() {
        browser.open();
        //browser.maximize();
        browser.resize(500, 500);
        //browser.move(50,50);
        //browser.minimize();
        //browser.fullScreen();
        navigate.to($("URL"));

    }

    /*@DataProvider(name = "testprv")
    public Object[][] testprv() {
        return dataSources.excel("src/test/resources/data/data.xlsx", "Sheet1", 1, 3);
    }*/

    //@Test(dataProvider = "testprv")
    public void some_test(String a, String b, String c) {
        System.out.println("-------------------------" + a + b.substring(0, b.length() - 2) + c);
        //System.out.println("-------------------------" + a[1][0] + a[1][1] + a[1][2]);

        //System.out.println("-------------------" + Arrays.deepToString(dataSources.excel("src/test/resources/data/data.xlsx", "Sheet1", 1, 1)));
        //homepage
        //input.type(home.searchText, $("TERM") + Keys.ENTER.toString());
        // System.out.println(environment);
        wait.sleep(5000);


    }

    @Test
    public void testx() {
        System.out.println("sadasdsdas");
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
