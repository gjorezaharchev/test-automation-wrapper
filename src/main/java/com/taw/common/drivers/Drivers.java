package com.taw.common.drivers;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

/**
 * @author gjore.zaharchev
 */
interface Drivers {
    WebDriver browser() throws MalformedURLException;
}
