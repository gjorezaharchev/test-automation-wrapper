package com.taw.objects;

public class Web {
    public HomePage homePage = new HomePage();

    public void test() {
        System.out.println(homePage.a);
    }
}

class HomePage {
    int a = 1;
}
