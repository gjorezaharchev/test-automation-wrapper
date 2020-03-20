package com.taw.common.drivers;

import com.taw.common.Global;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author gjore.zaharchev
 */
public class PhantomJS extends Global implements Drivers {

    public WebDriver browser() {
        // TODO find compatible PhantomJS version which will not make issues
        // with chrome driver
        System.setProperty("phantomjs.binary.path", drivers + "phantomjs.exe");
        DesiredCapabilities dCaps;
        dCaps = new DesiredCapabilities();
        dCaps.setJavascriptEnabled(true);
        dCaps.setCapability("takesScreenshot", false);
        // driver = new PhantomJSDriver(dCaps);
        return driver;
    }
}
