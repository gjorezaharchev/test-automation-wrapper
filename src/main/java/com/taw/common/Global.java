package com.taw.common;

import com.taw.common.drivers.enums.Drivers;
import com.taw.common.utility.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Gjore.Zaharchev
 */
public class Global {

    protected static WebDriver driver = null;
    protected static AndroidDriver<MobileElement> androidDriver = null;
    protected static IOSDriver<IOSElement> iosDriver = null;
    protected static WindowsDriver<WindowsElement> winDriver = null;
    protected static AppiumDriver appiumDriver = null;
    protected static WebDriverWait waitElement = null;
    protected final String environment =$$("environment", "TEST");

    protected final String OS = $$("os.name").toLowerCase();
    protected final String app = $$("app");
    protected final String drivers = "src/test/resources/Drivers/";
    protected final String device = $$("device");
    //Android
    protected final String appPackage = $$("appPackage");
    protected final String appActivity = $$("appActivity");
    protected Drivers browser = Drivers.valueOf($$("browser", "chrome").toUpperCase());

    /**
     * Used for reading environment variable value by specifying environment
     * variable name
     *
     * @param environmentVariableName specify which key from the properties file to be read
     * @return environment variable value
     */
    protected String $(final String environmentVariableName) {
        if (environment != null) {
            return Utils.getValueFromPropertyFile("/Environments/", environment, environmentVariableName);
        }
        return null;
    }

    /**
     * @param systemProperty
     * @return System property value
     */
    protected String $$(final String systemProperty) {
        if (System.getProperty(systemProperty) != null) {
            return System.getProperty(systemProperty);
        }
        return null;
    }

    protected String $$(final String systemProperty, final String defVal) {
            return System.getProperty(systemProperty, defVal);
    }
}
