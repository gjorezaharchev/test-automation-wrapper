package com.taw.common.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 * @author gjore.zaharchev
 */
public class DropDown extends ElementBase {

    private Select select = null;

    /**
     * @param by     locator
     * @param option order number
     */
    public void select(final By by, final int option) {
        select = new Select(getElement(by));
        select.selectByIndex(option);
    }

    /**
     * @param by     locator
     * @param option order number
     * @param index  element order
     */
    public void select(final By by, final int option, final int index) {
        select = new Select(getAllElements(by).get(index));
        select.selectByIndex(option);
    }

    /**
     * @param by          locator
     * @param visibleText displayed text
     */
    public void select(final By by, final String visibleText) {
        select = new Select(getElement(by));
        select.selectByVisibleText(visibleText);
    }

    /**
     * @param by          locator
     * @param visibleText displayed text
     * @param index       element order
     */
    public void select(final By by, final String visibleText, final int index) {
        select = new Select(getAllElements(by).get(index));
        select.selectByVisibleText(visibleText);

    }
}
