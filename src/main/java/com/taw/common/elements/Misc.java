package com.taw.common.elements;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;

/**
 * @author gjore.zaharchev
 */
public class Misc extends ElementBase {

    private final File autoitScriptsPath = new File("src/main/resources/autoit/executable");

    /**
     * Clear all cookies one by one
     */
    public void clearCookies() {
        Set<Cookie> cookies = driver.manage().getCookies();
        driver.manage().deleteAllCookies();
        if (!cookies.isEmpty()) {
            cookies.clear();
        }
    }

    /**
     * @param by   locator
     * @param path relative path
     * @param file filename
     */
    public void uploadFile(final By by, final String path, final String file) {
        String autoItUpload = String.format("%s\\uploadFiles.exe", autoitScriptsPath.getAbsolutePath());
        String winName = null;
        File uploadFile = new File("src/test/resources");
        String url = String.format("%s\\%s\\", uploadFile.getAbsolutePath(), path);

        String fileName = String.format("\"%s\"", file);

        try {
            getElement(by).click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        switch (browser) {
            case CHROME:
            case FIREFOX:
                winName = "Open";
                break;
            case IE:
                winName = "Choose File to Upload";
                break;
            default:
                break;
        }

        try {
            Runtime.getRuntime().exec(String.format("%s %s %s %s", autoItUpload, url, fileName, winName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param by    locator
     * @param index element order
     * @param path  relative path
     * @param file  filename
     */
    public void uploadFile(final By by, final int index, final String path, final String file) {
        String autoItUpload = String.format("%s\\uploadFiles.exe", autoitScriptsPath.getAbsolutePath());
        String winName = null;
        File uploadFile = new File("src/test/resources");
        String url = String.format("%s\\%s\\", uploadFile.getAbsolutePath(), path);

        String fileName = String.format("\"%s\"", file);

        try {
            getAllElements(by).get(index).click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        switch (browser) {
            case CHROME:
                winName = "File Upload";
                break;
            case IE:
                winName = "Choose File to Upload";
                break;
            case FIREFOX:
                winName = "Open";
                break;
            default:
                break;
        }

        try {
            Runtime.getRuntime().exec(String.format("%s %s %s %s", autoItUpload, url, fileName, winName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Drag and Drop and item.
     *
     * @param sourceLocator      locator of the source element
     * @param destinationLocator locator of the destination element
     */
    public void dragDrop(final By sourceLocator, final By destinationLocator) {
        try {
            (new Actions(driver)).dragAndDrop(getElement(sourceLocator), getElement(destinationLocator)).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Drag and Drop and item.
     *
     * @param sourceLocator      locator of the source element
     * @param sourceIndex        element order of the source
     * @param destinationLocator locator of the destination element
     * @param destinationIndex   element order of the destination
     */
    public void dragDrop(final By sourceLocator, final int sourceIndex, final By destinationLocator,
                         final int destinationIndex) {
        try {
            (new Actions(driver)).dragAndDrop(getAllElements(sourceLocator).get(sourceIndex),
                    getAllElements(destinationLocator).get(destinationIndex)).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void captureScreenShot() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File uploadFile = new File("target/screenshots");
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String fileName = String.format("%s/%s.png", uploadFile.getAbsolutePath(), timeStamp);
        try {
            FileUtils.copyFile(scrFile, new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void captureScreenShot(final String screenShotName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File uploadFile = new File("target/screenshots");
        //String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String fileName = String.format("%s/%s.png", uploadFile.getAbsolutePath(), screenShotName);
        try {
            FileUtils.copyFile(scrFile, new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
