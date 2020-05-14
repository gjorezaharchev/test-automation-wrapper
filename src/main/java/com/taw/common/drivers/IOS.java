package com.taw.common.drivers;

import com.taw.common.Global;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * @author gjore.zaharchev
 */
public class IOS extends Global {
    public static URL url;

    public DesiredCapabilities desiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, app);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        desiredCapabilities.setCapability("useNewWDA", false);

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, System.getProperty("iosPlatformVersion"));
        desiredCapabilities.setCapability("xcodeOrgId", System.getProperty("xcodeOrgId"));
        desiredCapabilities.setCapability("xcodeSigningId", System.getProperty("xcodeSigningId"));
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, System.getProperty("udid"));
        desiredCapabilities.setCapability("updatedWDABundleId", System.getProperty("updatedWDABundleId"));

        return desiredCapabilities;
    }

    public IOSDriver<IOSElement> iosDriver() {
        iosDriver = new IOSDriver<IOSElement>(url, desiredCapabilities());
        driver = iosDriver;
        return iosDriver;
    }
}
