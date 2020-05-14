package com.taw.common.utility;

/**
 * @author gjore.zaharchev
 */
public class Constants {


    public static final int ELEMENT_LOAD_TIMEOUTS = Integer.parseInt(getGlobalProperty("ELEMENT_LOAD_TIMEOUTS"));
    public static final String APPIUM_SERVER = String.valueOf(getGlobalProperty("APPIUM_SERVER"));

    private static String getGlobalProperty(final String globalPropertyName) {
        return Utils.getValueFromPropertyFile("/GlobalProperties/", "global", globalPropertyName);
    }
}
