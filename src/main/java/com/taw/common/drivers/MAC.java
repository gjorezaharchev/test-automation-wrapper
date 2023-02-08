package com.taw.common.drivers;

import com.taw.common.Global;
import com.taw.common.utility.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MAC extends Global {
    public static URL url;

    public DesiredCapabilities desiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Mac");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Mac");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, $sys("platformVersion"));
        desiredCapabilities.setCapability(MobileCapabilityType.APP, app);

        return desiredCapabilities;
    }

    public void macDriver() {

        try {
            url = new URL(Constants.APPIUM_SERVER);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //appiumDriver = new AppiumDriver(url, desiredCapabilities());
    }
}
