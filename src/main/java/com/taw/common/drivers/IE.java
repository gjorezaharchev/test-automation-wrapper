package com.taw.common.drivers;

import com.taw.common.Global;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

/**
 * @author gjore.zaharchev
 */
public class IE extends Global implements Drivers {

    public WebDriver browser() {

        if (System.getProperty("os.arch").equals("x86")) {
            System.setProperty("webdriver.ie.driver", drivers + "IEDriverServer32.exe");
        } else {
            System.setProperty("webdriver.ie.driver", System.getProperty(
                    "webdriver.ie.driver", drivers + "IEDriverServer64.exe"));
        }
        driver = new InternetExplorerDriver(ieo());
        driver.manage().deleteAllCookies();
        return null;
    }


    private InternetExplorerOptions ieo() {
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
        internetExplorerOptions.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
        internetExplorerOptions.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "");
        internetExplorerOptions.setCapability("ignoreProtectedModeSettings", true);
        internetExplorerOptions.setCapability("ie.ensureCleanSession", true);
        internetExplorerOptions.setCapability("acceptSslCerts", true);
        //internetExplorerOptions.setCapability("acceptSslCerts", true);
        //internetExplorerOptions.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        //internetExplorerOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return internetExplorerOptions;
    }
}
