package com.taw.common.elements;

import com.taw.common.drivers.SetUp;
import com.taw.common.utility.Constants;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
/*import org.openqa.selenium.devtools.v115.network.Network;
import org.openqa.selenium.devtools.v115.network.model.Headers;*/
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Gjore.Zaharchev
 */
public class Browser extends ElementBase {

    //TODO implement method logic from SetUp class

    /**
     *
     */

    private final SetUp setUp = new SetUp();

    /**
     * Used to open browser and set Explicit wait
     */
    public void open() {
        setUp.setBrowser();
        setExplicitWait();
    }

    public void page_load_timeout() {
        driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT);
    }

    /**
     * Maximizes the browser
     */
    public void maximize() {
        try {
            driver.manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Set location of the browser
     *
     * @param x width
     * @param y height
     */
    public void move(final int x, final int y) {
        try {
            driver.manage().window().setPosition(new Point(x, y));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Maximize the browser
     *
     * @param x width
     * @param y height
     */
    public void resize(final int x, final int y) {
        Dimension dimension = new Dimension(x, y);
        try {
            driver.manage().window().setSize(dimension);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void minimize() {
        driver.manage().window().setPosition(new Point(-2000, 0));
    }

    public void fullScreen() {
        driver.manage().window().fullscreen();
    }

    /**
     * Close any instances of webdriver.
     */

    public void close() {
        driver.quit();
    }

    public void basic_authentication(String username, String password) {
        // Get the devtools from the running driver and create a session
       /* DevTools devTools;
        switch (browser){
            case CHROME:
                devTools =  driver.ge;
                break;
            case FIREFOX:
                devTools = ((FirefoxDriver) driver).getDevTools();
                break;
            case EDGE:
                devTools = ((EdgeDriver) driver).getDevTools();
                break;
            default:
                devTools = ((ChromeDriver) driver).getDevTools();
                break;
        }*/

     //   devTools.createSession();

        // Enable the Network domain of devtools


        //devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        String auth = username + ":" + password;

        // Encoding the username and password using Base64
        String encodeToString = Base64.getEncoder().encodeToString(auth.getBytes());
        System.out.println("Encoded String: " + encodeToString);

        // Pass the network header as Authorization : Basic <encoded String>
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", "Basic " + encodeToString);
        //devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
    }

    private void setExplicitWait() {
        int to = Constants.ELEMENT_LOAD_TIMEOUTS;
        try {
            waitElement = new WebDriverWait(driver, Duration.ofSeconds(to));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
