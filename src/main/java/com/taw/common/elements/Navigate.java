package com.taw.common.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

/**
 * @author gjore.zaharchev
 */
public class Navigate extends ElementBase {


    /**
     * scrolls to a particular element
     *
     * @param by locator
     */
    public void scrollToElement(final By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(by));
        actions.perform();
    }

    /**
     * scrolls to a particular element
     *
     * @param by    locator
     * @param index element order
     */
    public void scrollToElement(final By by, final int index) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getAllElements(by).get(index));
        actions.perform();
    }

    /**
     * Used for navigating to a URL
     *
     * @param url url
     */
    public void to(final String url) {
        try {
            driver.get(url);

        } catch (Exception e) {
            e.printStackTrace();
            driver.quit();
        }
    }

    /**
     * Navigate one level Back
     */
    public void back() {
        try {
            driver.navigate().back();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Navigate Forward.
     */
    public void forward() {
        try {
            driver.navigate().forward();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Refresh page
     */
    public void refresh() {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param frame frame to switch
     */
    public void switchToFrame(final String frame) {
        driver.switchTo().frame(frame);
    }

    /**
     * @param frame frame to switch
     */
    public void switchToFrame(final int frame) {
        driver.switchTo().frame(frame);
    }

    /**
     * @param by locator
     */
    public void switchToFrame(final By by) {
        driver.switchTo().frame(getElement(by));
    }

    /**
     * @param by    locator
     * @param index element order
     */
    public void switchToFrame(final By by, final int index) {
        driver.switchTo().frame(getAllElements(by).get(index));
    }

    /**
     * Switch to parent frame
     */
    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    /**
     * Switch to parent Window
     */
    public void switchToParentWindow() {
        driver.switchTo().defaultContent();
    }

    /**
     * @param handle window id
     */
    public void switchToWindow(final int handle) {
        driver.switchTo().window(getWindowHandle().get(handle));
    }

    /**
     * @param windowName window name
     */
    public void switchToWindow(final String windowName) {
        driver.switchTo().window(windowName);
    }

    // TODO Implement better logic for switch / close window since the logic bellow is not good
    public void closeWindow(final int handle) {
        driver.switchTo().window(getWindowHandle().get(handle));
        driver.close();
    }

    /**
     * @param windowName window name
     */
    public void closeWindow(final String windowName) {
        driver.switchTo().window(windowName);
        driver.close();
    }

    /**
     * Used to Switch between windows using Handle
     *
     * @return list of all active windows
     */
    private ArrayList<String> getWindowHandle() {
        return new ArrayList<String>(driver.getWindowHandles());
    }
}
