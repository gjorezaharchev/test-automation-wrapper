package com.taw.common.elements;

import com.taw.common.utility.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author gjore.zaharchev
 */
public class Wait extends ElementBase {

    /**
     * @param by locator
     * @return element
     */
    public boolean presenceOfElement(final By by) {
        try {
            waitElement.until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param by      locator
     * @param timeout timeout
     * @return element
     */
    public boolean presenceOfElement(final By by, final long timeout) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param by locator
     * @return element
     */
    public boolean presenceOfElements(final By by) {
        try {
            waitElement.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param by      locator
     * @param timeout timeout
     * @return element
     */
    public boolean presenceOfElements(final By by, final long timeout) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Investigate

    /**
     * @param by locator
     * @return element
     */
    public boolean visibilityOfElement(final By by) {
        try {
            waitElement.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Investigate

    /**
     * @param by      locator
     * @param timeout timeout
     * @return element
     */
    public boolean visibilityOfElement(final By by, final long timeout) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param by locator
     * @return element
     */
    public boolean visibilityOfElements(final By by) {
        try {
            waitElement.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param by      locator
     * @param timeout timeout
     * @return element
     */
    public boolean visibilityOfElements(final By by, final long timeout) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param by locator
     * @return element
     */
    public boolean toBecomeInvisible(final By by) {
        try {
            getElement(by);
            waitElement.until(ExpectedConditions.invisibilityOfElementLocated(by));
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param by      locator
     * @param timeout timeout
     * @return element
     */
    public boolean toBecomeInvisible(final By by, final long timeout) {
        try {
            getElement(by);
            new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOfElementLocated(by));
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param by    locator
     * @param index element order
     */
    public boolean toBecomeInvisible(final By by, final int index, final long timeout) {
        getElement(by);
        waitElement.until(ExpectedConditions.invisibilityOfAllElements(getAllElements(by)));
        return true;
    }

    public boolean toBeClickable(final By by) {
        waitElement.until(ExpectedConditions.elementToBeClickable(by));
        return true;
    }

    public boolean toBeClickable(final By by, final long timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(by));
        return true;
    }

    public boolean toBeSelectable(final By by) {
        waitElement.until(ExpectedConditions.elementToBeSelected(by));
        return true;
    }

    public boolean toBeSelectable(final By by, final long timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeSelected(by));
        return true;
    }
    /**
     * @param by   locator
     * @param text text to be
     */
    public boolean textToBe(final By by, final String text) {
        return waitElement.until(ExpectedConditions.textToBe(by, text));
    }

    /**
     * @param by   locator
     * @param text text
     */
    public boolean textToBe(final By by, final long timeout, final String text) {
        return new WebDriverWait(driver, timeout).until(ExpectedConditions.textToBe(by, text));
    }

    /**
     * @param timeout timeout
     */
    public void forAsynchronousRequest(final long timeout) {
        driver.manage().timeouts().setScriptTimeout(timeout, TimeUnit.MILLISECONDS);
    }

    /**
     * @param timeout timeout
     */
    public void sleep(final long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void page_load_timeout(){
        driver.manage().timeouts().implicitlyWait(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }

    public void page_load_timeout(final long timeout){
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }
}
