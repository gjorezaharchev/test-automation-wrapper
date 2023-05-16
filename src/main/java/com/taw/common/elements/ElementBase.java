package com.taw.common.elements;

import com.taw.common.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * @author gjore.zaharchev
 */
public class ElementBase extends Global {

    /**
     * @param by provide locator
     * @return single WebElement
     */
    public WebElement getElement(final By by) {
        return waitElement.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * @param by provide locator
     * @return list of WebElement
     */
    public List<WebElement> getAllElements(final By by) {
        return waitElement.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((by)));
    }
}
