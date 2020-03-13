package com.taw.common.elements;

import com.taw.common.utility.Utils;

/**
 * @author gjore.zaharchev
 */
public class Files extends ElementBase {

    /**
     * Read properties file Value
     *
     * @param path     path to file
     * @param fileName name of the file
     * @param property property name
     * @return property value
     */
    public String propertyFileValue(final String path, final String fileName, final String property) {
        return Utils.getValueFromPropertyFile(path, fileName, property);
    }

    //TODO Read Text file
    //TODO Write to Text file
}
