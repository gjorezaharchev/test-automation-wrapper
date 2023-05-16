package com.taw.common.drivers;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.taw.common.Global;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.net.MalformedURLException;

/**
 * @author gjore.zaharchev
 */
public class HTMLUnit extends Global implements Drivers{
    @Override
    public WebDriver browser()  {
        driver = new HtmlUnitDriver();
        return driver;
    }
}
