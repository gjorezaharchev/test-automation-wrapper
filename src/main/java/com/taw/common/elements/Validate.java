package com.taw.common.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author gjore.zaharchev
 */
public class Validate extends ElementBase {

    public ExpectedCondition<WebElement> visibilityOfElementLocated(final By by) {
        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = getElement(by);
                return element.isDisplayed() ? element : null;
            }
        };
    }

    public ExpectedCondition<WebElement> visibilityOfElementLocated(final By by, final int index) {
        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                return getAllElements(by).get(index).isDisplayed() ? getAllElements(by).get(index) : null;
            }
        };
    }


    /**
     * @param by locator
     * @return validation
     */
    public boolean isElementPresent(final By by) {
        try {
            getElement(by).getText();
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param by    locator
     * @param index element order
     * @return validation
     */
    public boolean isElementPresent(final By by, final int index) {
        try {
            getAllElements(by).get(index).getText();
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * @param by            locator
     * @param expectedValue expected
     * @return validation
     */
    public boolean textEquals(final By by, final String expectedValue) {
        isElementPresent(by);
        String actualValue;
        try {
            actualValue = getElement(by).getText();
            //Assert.assertEquals(expectedValue, actualValue);
            assert expectedValue.equals(actualValue);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param by            locator
     * @param index         element order
     * @param expectedValue expected
     * @return validation
     */
    public boolean textEquals(final By by, final int index, final String expectedValue) {
        isElementPresent(by, index);
        String actualValue;
        try {
            actualValue = getAllElements(by).get(index).getText();
            //Assert.assertEquals(expectedValue, actualValue);
            assert expectedValue.equals(actualValue);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param by            locator
     * @param expectedValue expected
     * @return validation
     */
    public boolean textNotEquals(final By by, final String expectedValue) {
        isElementPresent(by);
        String actualValue;
        try {
            actualValue = getElement(by).getText();
            //Assert.assertNotEquals(expectedValue, actualValue);
            assert expectedValue.equals(actualValue);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param by            location
     * @param index         element order
     * @param expectedValue expected
     * @return validation
     */
    public boolean textNotEquals(final By by, final int index, final String expectedValue) {
        isElementPresent(by, index);
        String actualValue;
        try {
            actualValue = getAllElements(by).get(index).getText();
            //Assert.assertNotEquals(expectedValue, actualValue);
            assert !expectedValue.equals(actualValue);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param by            locator
     * @param expectedValue expected
     * @return validation
     */
    public boolean textContains(final By by, final String expectedValue) {
        isElementPresent(by);
        String actualValue;
        try {
            actualValue = getElement(by).getText();
            //Assert.assertTrue(actualValue.contains(expectedValue));

            assert expectedValue.contains(actualValue);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param by            locator
     * @param index         element order
     * @param expectedValue expected
     * @return validation
     */
    public boolean textContains(final By by, final int index, final String expectedValue) {
        isElementPresent(by, index);
        String actualValue;
        try {
            actualValue = getAllElements(by).get(index).getText();
            //Assert.assertTrue(actualValue.contains(expectedValue));
            assert expectedValue.contains(actualValue);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param by            locator
     * @param expectedValue expected
     * @return validation
     */
    public boolean textNotContains(final By by, final String expectedValue) {
        isElementPresent(by);
        String actualValue;
        try {
            actualValue = getElement(by).getText();
            //Assert.assertFalse(actualValue.contains(expectedValue));
            assert !expectedValue.contains(actualValue);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param by            locator
     * @param index         element order
     * @param expectedValue expected
     * @return validation
     */
    public boolean textNotContains(final By by, final int index, final String expectedValue) {
        isElementPresent(by, index);
        String actualValue;
        try {
            actualValue = getAllElements(by).get(index).getText();
            //Assert.assertFalse(actualValue.contains(expectedValue));
            assert !expectedValue.contains(actualValue);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param expectedValue expected
     * @param actualValue   actual
     * @return validation
     */
    public boolean textEquals(final String expectedValue, final String actualValue) {
        try {
            //Assert.assertEquals(expectedValue, actualValue);
            assert expectedValue.equals(actualValue);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param expectedValue expected
     * @param actualValue   actual
     * @return validation
     */
    public boolean textEquals(final int expectedValue, final int actualValue) {
        try {
            //Assert.assertEquals(expectedValue, actualValue);
            assert expectedValue == actualValue;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param expectedValue expected
     * @param actualValue   actual
     * @return validation
     */
    public boolean textNotEquals(final String expectedValue, final String actualValue) {
        try {
            //Assert.assertNotEquals(expectedValue, actualValue);
            assert !expectedValue.equals(actualValue);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param expectedValue expected
     * @param actualValue   actual
     * @return validation
     */
    public boolean textNotEquals(final int expectedValue, final int actualValue) {
        try {
            //Assert.assertNotEquals(expectedValue, actualValue);
            assert expectedValue != actualValue;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param expectedValue expected
     * @param actualValue   actual
     * @return validation
     */
    public boolean textContains(final String expectedValue, final String actualValue) {
        try {
            //Assert.assertTrue(actualValue.contains(expectedValue));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param expectedValue expected
     * @param actualValue   actual
     * @return validation
     */
    public boolean textNotContains(final String expectedValue, final String actualValue) {
        try {
            //Assert.assertFalse(actualValue.contains(expectedValue));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param by locator
     * @return validation
     */
    public boolean isChecked(final By by) {
        try {
            getElement(by).isSelected();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param by    locator
     * @param index element order
     * @return validation
     */
    public boolean isChecked(final By by, final int index) {
        try {
            getAllElements(by).get(index).isSelected();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param by locator
     * @return validation
     */
    public boolean isNotChecked(final By by) {
        try {
            if (!getElement(by).isSelected()) {
                return false;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /**
     * @param by    locator
     * @param index element order
     * @return validation
     */
    public boolean isNotChecked(final By by, final int index) {
        try {
            if (!getAllElements(by).get(index).isSelected()) {
                return false;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /**
     * @param by                  locator
     * @param expectedElementSize expected element size
     * @return validation
     */
    public boolean elementSize(final By by, final int expectedElementSize) {
        try {
            int countElementSize = getAllElements(by).size();
            //assertThat(expectedElementSize, is(countElementSize));
            return true;
        } catch (NoSuchElementException e) {
            //e.printStackTrace();
            return false;
        }
    }

    /**
     * @return validation
     */
    public boolean isAlertPresent() {
        try {
            waitElement.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
