package com.taw.common.drivers;

import com.taw.common.Global;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * @author Gjore.Zaharchev
 */
public class Edge extends Global implements Drivers {

    public WebDriver browser() {
       // System.setProperty("webdriver.edge.driver", drivers + "msedgedriver.exe");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        return driver;
    }
}
