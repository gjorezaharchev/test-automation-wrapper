package com.taw.common.utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * @author gjore.zaharchev
 */
public class Utils {

    /**
     * @param path         path to file
     * @param fileName     file name
     * @param propertyName property name
     * @return property vale
     */
    public static String getValueFromPropertyFile(final String path, final String fileName,
                                                  final String propertyName) {
        Properties properties = new Properties();
        InputStream stream = null;
        try {
            stream = Utils.class.getResourceAsStream(String.format("%s%s.properties", path, fileName));
            properties.load(stream);
            return properties.getProperty(propertyName, "");
        } catch (final IOException e) {
            return null;
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void setValueFromPropertyFile(final String path, final String fileName,
                                                  final String propertyName, final String propertyValue) {
        Properties properties = new Properties();
        OutputStream outputStream = null;
        try{
            outputStream = new FileOutputStream(String.format("%s%s.properties", path, fileName), true);
            properties.remove(propertyName);
           /* properties.store(outputStream, null);
            outputStream = new FileOutputStream(String.format("%s%s.properties", path, fileName), true);
            */properties.setProperty(propertyName, propertyValue);
            properties.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
