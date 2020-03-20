package com.taw.common.drivers;

import com.taw.common.Global;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author gjore.zaharchev
 */
public class Safari extends Global implements Drivers {

    public WebDriver browser() {
        System.setProperty("webdriver.safari.noinstall", "true");
        driver = new SafariDriver();
        return driver;
    }
}
