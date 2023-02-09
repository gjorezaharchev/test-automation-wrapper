package com.taw.common.elements;

import com.taw.common.Global;
import org.openqa.selenium.Cookie;

import java.time.LocalDate;

public class Cookies extends Global {

    public void deleteCookie(String cookie){
        driver.manage().deleteCookieNamed (cookie);
    }

    public void addCookie(String cookieName, String cookieValue){
        driver.manage().addCookie(new Cookie(cookieName, cookieValue));
    }

    public void googleConsentCookie(){
        driver.manage().deleteCookieNamed ("CONSENT");
        driver.manage().addCookie(new Cookie("CONSENT","YES+shp.gws-"+ LocalDate.now().toString().replace("-","")+"-0-RC2.en+FX+374"));

    }
}
