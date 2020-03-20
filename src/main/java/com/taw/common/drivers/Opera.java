package com.taw.common.drivers;

import com.taw.common.Global;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

/**
 * @author gjore.zaharchev
 */
public class Opera extends Global implements Drivers {

    public WebDriver browser() {
        // TODO add location to the opera driver
        driver = new OperaDriver();
        return driver;
    }

}
