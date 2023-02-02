package com.taw.common.utility;

import com.taw.common.Global;

import java.time.Duration;

/**
 * @author gjore.zaharchev
 */
public class Constants extends Global {


    public static final int ELEMENT_LOAD_TIMEOUTS = $int("ELEMENT_LOAD_TIMEOUTS");
    public static final String APPIUM_SERVER = $string("APPIUM_SERVER");
    public static final Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds($int("PAGE_LOAD_TIMEOUT"));

}
