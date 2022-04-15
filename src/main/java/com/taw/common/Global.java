package com.taw.common;

import com.taw.common.drivers.enums.Drivers;
import com.taw.common.utility.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

/**
 * @author Gjore.Zaharchev
 */
public class Global {

    protected static WebDriver driver = null;
    protected static AndroidDriver androidDriver = null;
    protected static IOSDriver iosDriver = null;
    protected static WindowsDriver winDriver = null;
    protected static AppiumDriver appiumDriver = null;
    protected static WebDriverWait waitElement = null;
    protected final String environment = $sys("environment", getFiles());
    protected final String nodeURL = $sys("node");

    protected static final String OS = $sys("os.name").toLowerCase();
    protected final String app = $sys("app");
    protected final String drivers = "src/test/resources/Drivers/";
    protected final String device = $sys("device");
    //Android
    protected final static String appPackage = $sys("appPackage");
    protected final static String appActivity = $sys("appActivity");
    protected final static Drivers browser = Drivers.valueOf($sys("browser", "chrome").toUpperCase());

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
    protected static String $sys(final String systemProperty) {
        if (System.getProperty(systemProperty) != null) {
            return System.getProperty(systemProperty);
        }
        return null;
    }

    protected static String $sys(final String systemProperty, final String defVal) {
            return System.getProperty(systemProperty, defVal);
    }

    private String getFiles() {
        File folder = new File("src/test/resources/Environments");
        File[] listOfFiles = folder.listFiles();
        String defaultEnvironment = listOfFiles[0].getName().replace(".properties", "");
        return defaultEnvironment;
    }

    protected static String $string(final String globalPropertyName) {
        return Utils.getValueFromPropertyFile("/GlobalProperties/", "global", globalPropertyName);
    }

    protected static int $int(final String globalPropertyName) {
        return Integer.parseInt(Utils.getValueFromPropertyFile("/GlobalProperties/", "global", globalPropertyName));
    }

    protected static boolean $boolean(final String globalPropertyName) {
        return Boolean.parseBoolean(Utils.getValueFromPropertyFile("/GlobalProperties/", "global", globalPropertyName));
    }

    protected static Double $double(final String globalPropertyName) {
        return Double.parseDouble(Utils.getValueFromPropertyFile("/GlobalProperties/", "global", globalPropertyName));
    }
}
