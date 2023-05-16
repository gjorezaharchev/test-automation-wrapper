package com.taw.common.drivers;

import com.taw.common.Global;
import com.taw.common.utility.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author gjore.zaharchev
 */
public class Firefox extends Global implements Drivers {

    public WebDriver browser() {
        /*if (OSValidator.isWindows(OS)) {
            System.setProperty("webdriver.gecko.driver", drivers + "geckodriver.exe");
            System.out.println("This is Windows");
        } else if (OSValidator.isMac(OS)) {
            System.setProperty("webdriver.gecko.driver", drivers + "geckodriverMac");
            System.out.println("This is Mac");
        } else if (OSValidator.isUnix(OS)) {
            System.setProperty("webdriver.gecko.driver", drivers + "geckodriver64");
            System.out.println("This is Unix or Linux");
        } else {
            System.out.println("Your OS is not support!!");
        }*/

        if (System.getProperty("remote", "false").equalsIgnoreCase("true")) {
            /*FirefoxOptions firefoxOptions = new FirefoxOptions();
            String headless = System.getProperty("headless","false");
            String headlessGlobals = Constants.getGlobalProperty("headless");
            if (headless.equalsIgnoreCase("true") || headlessGlobals.equalsIgnoreCase("true")) {
                firefoxOptions.addArguments("--headless");
            }*/
            try {
                driver = new RemoteWebDriver(new URL(nodeURL), firefoxOptions());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            driver = new FirefoxDriver(firefoxOptions());
        }
        return driver;
    }

    private FirefoxOptions firefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        String headless = System.getProperty("headless", "false");
        String headlessGlobals = Constants.$string("headless");
        if (headless.equalsIgnoreCase("true") || headlessGlobals.equalsIgnoreCase("true")) {
            firefoxOptions.addArguments("--headless");
        }
        return firefoxOptions;
    }

    @SuppressWarnings("unused")
    private FirefoxProfile getFirefoxProfile() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("app.update.auto", false);
        firefoxProfile.setPreference("app.update.enabled", false);
        firefoxProfile.setPreference("app.update.silent", false);
        firefoxProfile.setPreference("browser.formfill.enable", false);
        firefoxProfile.setPreference("browser.tabs.warnOnClose", false);
        firefoxProfile.setPreference("browser.tabs.warnOnOpen", false);
        firefoxProfile.setPreference("browser.startup.page", 0);
        firefoxProfile.setPreference("browser.sessionstore.resume_from_crash", false);
        firefoxProfile.setPreference("browser.shell.checkDefaultBrowser", false);
        firefoxProfile.setPreference("browser.cache.disk.enable", false);
        firefoxProfile.setPreference("browser.cache.memory.enable", false);
        firefoxProfile.setPreference("browser.cache.offline.enable", false);
        firefoxProfile.setPreference("network.http.use-cache", false);
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
        firefoxProfile.setPreference("browser.download.dir", "c:\\");
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv,application/pdf");
        firefoxProfile.setPreference("extensions.update.enabled", false);
        firefoxProfile.setPreference("security.warn_submit_insecure", false);
        firefoxProfile.setPreference("security.warn_viewing_mixed", false);
        firefoxProfile.setPreference("security.warn_leaving_secure", false);
        firefoxProfile.setPreference("security.warn_entering_weak", false);
        firefoxProfile.setPreference("security.warn_entering_secure", false);
        firefoxProfile.setPreference("signon.autofillForms", false);
        firefoxProfile.setPreference("signon.rememberSignons", false);
        return firefoxProfile;
    }
}
