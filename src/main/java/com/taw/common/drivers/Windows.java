package com.taw.common.drivers;

import com.taw.common.Global;
import com.taw.common.utility.Constants;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author gjore.zaharchev
 */
public class Windows extends Global {

    public static URL url;

    public DesiredCapabilities desiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Windows");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, app);

        return desiredCapabilities;
    }

    public WindowsDriver windowsDriver() {

        try {
            url = new URL(Constants.APPIUM_SERVER);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //winDriver = new WindowsDriver (url, desiredCapabilities());
        driver = winDriver;
        return winDriver;
    }
}
