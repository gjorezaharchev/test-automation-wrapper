package com.taw.common.elements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Gjore.Zaharchev
 */
public class Alerts extends ElementBase {

    /**
     * Accepts the alert.
     */
    public void accept() {
        waitElement.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    /**
     * Dismiss the alert.
     */
    public void dismiss() {
        waitElement.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    /**
     * Types text in the alert.
     *
     * @param value String accepted
     */
    public void type(final String value) {
        waitElement.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
    }

    //TODO implement more methods if missing

}
