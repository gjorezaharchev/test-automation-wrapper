package com.taw.common.drivers;

import com.taw.common.Global;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * @author Gjore.Zaharchev
 */
public class Edge extends Global implements Drivers {

    public WebDriver browser() {
       // System.setProperty("webdriver.edge.driver", drivers + "msedgedriver.exe");

        driver = new EdgeDriver();
        return driver;
    }
}
