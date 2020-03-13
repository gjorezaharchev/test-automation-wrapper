package com.taw.common.drivers;

import com.taw.common.Global;
import com.taw.common.utility.Constants;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Gjore.Zaharchev
 */
public class SetUp extends Global {


    public void setBrowser() {
        switch (browser) {
            case CHROME:
                new Chrome().browser();
                break;
            case IE:
                new IE().browser();
                break;
            case FIREFOX:
                if (OSValidator.isWindows(OS)) {
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
                }


                driver = new FirefoxDriver();
                //driver = new FirefoxDriver();
                break;
            case OPERA:
                // TODO add location to the opera driver
                driver = new OperaDriver();
                break;
            case SAFARI:
                System.setProperty("webdriver.safari.noinstall", "true");
                driver = new SafariDriver();
                break;
            case PHANTOMJS:
                // TODO find compatible PhantomJS version which will not make issues
                // with chrome driver
                System.setProperty("phantomjs.binary.path", drivers + "phantomjs.exe");
                DesiredCapabilities dCaps;
                dCaps = new DesiredCapabilities();
                dCaps.setJavascriptEnabled(true);
                dCaps.setCapability("takesScreenshot", false);
                // driver = new PhantomJSDriver(dCaps);
                break;
            case EDGE:
                System.setProperty("webdriver.edge.driver", drivers + "MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                break;
        }
    }

    public void setExplicitWait() {

        try {
            waitElement = new WebDriverWait(driver, Constants.ELEMENT_LOAD_TIMEOUTS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void driverQuit() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
