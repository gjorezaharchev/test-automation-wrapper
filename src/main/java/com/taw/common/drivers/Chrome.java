package com.taw.common.drivers;

import com.taw.common.Global;
import com.taw.common.utility.Constants;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


/**
 * @author gjore.zaharchev
 */
public class Chrome extends Global implements Drivers {

    public WebDriver browser() {
        if (OSValidator.isWindows(OS)) {
            System.setProperty("webdriver.chrome.driver", drivers + "chromedriver.exe");
        } else if (OSValidator.isMac(OS)) {
            System.setProperty("webdriver.chrome.driver", drivers + "chromedriverMac");
        } else if (OSValidator.isUnix(OS)) {
            System.setProperty("webdriver.chrome.driver", drivers + "chromedriver64");
        } else {
            System.out.println("Your OS is not support!!");
        }

        if (System.getProperty("remote", "false").equalsIgnoreCase("true")) {
            /*ChromeOptions chromeOptions = new ChromeOptions();
            //chromeOptions.setCapability("browserName", "chrome");
            //chromeOptions.setCapability("version", "89.0");
            //chromeOptions.setCapability("platform", "Windows");
            String headless = System.getProperty("headless","false");
            String headlessGlobals = Constants.getGlobalProperty("headless");
            if (headless.equalsIgnoreCase("true") || headlessGlobals.equalsIgnoreCase("true")) {
                chromeOptions.addArguments("--headless");
            }*/
            try {
                driver = new RemoteWebDriver(new URL(nodeURL), options());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            driver = new ChromeDriver(options());
        }

        return driver;
    }

    private ChromeOptions options() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--enable-application-cache");
        chromeOptions.addArguments("--allow-running-insecure-content");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--enable-automation");
        String headless = System.getProperty("headless", "false");
        String headlessGlobals = Constants.$string("headless");
        if (headless.equalsIgnoreCase("true") || headlessGlobals.equalsIgnoreCase("true")) {
            chromeOptions.addArguments("--headless");
        }

        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        if (System.getProperty("project", "").equalsIgnoreCase("sidel")) {
            String pathToDownload = System.getProperty("user.home") + Constants.$string("download.location");
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("plugins.always_open_pdf_externally", Constants.$boolean("plugins.always_open_pdf_externally"));
            chromePrefs.put("download.prompt_for_download", Constants.$boolean("download.prompt_for_download"));
            chromePrefs.put("profile.default_content_settings.popups", Constants.$int("profile.default_content_settings.popups"));
            chromePrefs.put("download.default_directory", pathToDownload);
            chromePrefs.put("browser.set_download_behavior", "{ behavior: 'allow', downloadPath: '" + pathToDownload + "'}");
            chromeOptions.setExperimentalOption("prefs", chromePrefs);

            chromeOptions.setCapability("browserName", Constants.$string("browserName"));
            chromeOptions.setCapability("version", Constants.$string("version"));
            chromeOptions.setCapability("platform", Constants.$string("platform"));
            chromeOptions.setCapability("enableVNC", Constants.$boolean("enableVNC"));
            chromeOptions.setCapability("enableVideo", Constants.$boolean("enableVideo"));
            //chromeOptions.setCapability("screenResolution", "1920x1080x24");

            if($sys("selenoid", "false").equalsIgnoreCase("true")){
                Map<String, Object> selenoidOptions = new HashMap<>();
                selenoidOptions.put("enableVNC", Constants.$boolean("enableVNC"));
                selenoidOptions.put("enableVideo", Constants.$boolean("enableVideo"));
                chromeOptions.setCapability("selenoid:options", selenoidOptions);

            }
        }

        return chromeOptions;
    }


}
