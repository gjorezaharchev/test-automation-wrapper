package com.taw.common.elements;

import com.taw.common.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * @author gjore.zaharchev
 */
class ElementBase extends Global {

    /**
     * @param by provide locator
     * @return single WebElement
     */
    WebElement getElement(final By by) {
        try {
            return waitElement.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param by provide locator
     * @return list of WebElement
     */
    List<WebElement> getAllElements(final By by) {
        try {
            return waitElement.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((by)));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        }
    }
}
