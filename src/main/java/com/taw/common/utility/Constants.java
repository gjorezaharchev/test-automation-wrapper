package com.taw.common.utility;

/**
 * @author gjore.zaharchev
 */
public class Constants {


    public static final int ELEMENT_LOAD_TIMEOUTS = Integer.parseInt(getGlobalProperty("ELEMENT_LOAD_TIMEOUTS"));
    public static final int REST_TIMEOUT = Integer.parseInt(getGlobalProperty("REST_TIMEOUT"));


    private static String getGlobalProperty(final String globalPropertyName) {
        return Utils.getValueFromPropertyFile("/GlobalProperties/", "global", globalPropertyName);
    }
}
