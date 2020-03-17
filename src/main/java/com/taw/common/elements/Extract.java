package com.taw.common.elements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * @author gjore.zaharchev
 */
public class Extract extends ElementBase {

    /**
     * Return current URL in a string format
     *
     * @return current URL
     */
    public String currentURL() {
        return driver.getCurrentUrl();
    }

    /**
     * Return page title in a string format
     *
     * @return page title
     */
    public String pageTitle() {
        return driver.getTitle();
    }

    /**
     * @param by locator
     * @return element text
     */
    public String elementValue(final By by) {
        return getElement(by).getText();
    }

    /**
     * @param by         locator
     * @param textBefore text before extraction
     * @param textAfter  text after extraction
     * @return text
     */
    public String elementValue(final By by, final String textBefore, final String textAfter) {
        return getElement(by).getText().replace(textBefore, "").replace(textAfter, "");
    }

    /**
     * @param by    locator
     * @param index element order
     * @return element text
     */
    public String elementValue(final By by, final int index) {
        return getAllElements(by).get(index).getText();
    }

    /**
     * @param by         locator
     * @param index      element order
     * @param textBefore text before extraction
     * @param textAfter  text after extraction
     * @return element text
     */
    public String elementValue(final By by, final int index, final String textBefore, final String textAfter) {
        return getAllElements(by).get(index).getText().replace(textBefore, "").replace(textAfter, "");
    }

    /**
     * @param by locator
     * @return element size
     */
    public int elementSize(final By by) {
        return getAllElements(by).size();
    }

    /**
     * @param by        locator
     * @param attribute attribute name
     * @return attribute value
     */
    public String attributeValue(final By by, final String attribute) {
        try {
            return getElement(by).getAttribute(attribute);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param by        locator
     * @param index     element order
     * @param attribute attribute name
     * @return attribute value
     */
    public String attributeValue(final By by, final int index, final String attribute) {
        return getAllElements(by).get(index).getAttribute(attribute);
    }

    /**
     * @param by element locator
     * @return web element
     */
    public WebElement element(final By by) {
        return waitElement.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * @param by element locator
     * @return list of elements
     */
    public List<WebElement> allElements(final By by) {
        return waitElement.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((by)));
    }

    /**
     * Returns text from the alert.
     *
     * @return alert text
     */
    public String alertText() {
        waitElement.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
}
