package com.taw.common;

import com.taw.common.drivers.enums.Drivers;
import com.taw.common.utility.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Gjore.Zaharchev
 */
public class Global {

    protected static WebDriver driver = null;
    protected static AndroidDriver<MobileElement> androidDriver = null;
    protected static WebDriverWait waitElement = null;

    protected Drivers browser = Drivers.valueOf(System.getProperty("browser").toUpperCase());
    protected final String environment = System.getProperty("environment");
    protected final String OS = System.getProperty("os.name").toLowerCase();
    protected final String drivers = "src/test/resources/Drivers/";
    protected final String app = System.getProperty("app");
    protected final String device = System.getProperty("device");

    /**
     * Used for reading environment variable value by specifying environment
     * variable name
     *
     * @param envVarName specify which key from the properties file to be read
     * @return environment variable value
     */
    protected String $(final String envVarName) {
        if (environment != null) {
            return Utils.getValueFromPropertyFile("/Environments/", environment, envVarName);
        }
        return null;
    }
}
