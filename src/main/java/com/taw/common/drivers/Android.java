package com.taw.common.drivers;

import com.taw.common.Global;
import com.taw.common.utility.Constants;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Gjore.Zaharchev
 */
public class Android extends Global {

    public static URL url;

    public DesiredCapabilities desiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        desiredCapabilities.setCapability("appPackage", appPackage);

        if ($$("app") != null) {
            desiredCapabilities.setCapability(MobileCapabilityType.APP, app);
        } else if (System.getProperty("appActivity") != null) {
            desiredCapabilities.setCapability("appActivity", appActivity);
        } else if ($$("browserName") != null) {
            desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, $$("browserName"));
        } else {
            System.out.println("Please specify Android application location to be installed or existing android app and activity to be opened!");
        }

        desiredCapabilities.setCapability("autoGrantPermissions", "true");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        return desiredCapabilities;
    }

    public AndroidDriver<MobileElement> android() {
        try {
            url = new URL(Constants.APPIUM_SERVER);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        androidDriver = new AndroidDriver<MobileElement>(url, desiredCapabilities());
        driver = androidDriver;
        return androidDriver;
    }

}
