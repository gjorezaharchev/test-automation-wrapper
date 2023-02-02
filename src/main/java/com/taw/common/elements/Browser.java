package com.taw.common.elements;

import com.taw.common.drivers.SetUp;
import com.taw.common.utility.Constants;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

    public void page_load_timeout(){
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

    private void setExplicitWait() {

        try {
            waitElement = new WebDriverWait(driver, Duration.ofSeconds(Constants.ELEMENT_LOAD_TIMEOUTS));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
