package com.it_academy.tests.framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static final String ENDPOINTS_FILE = "/endpoints.properties";
    private static final Properties ENDPOINTS_PROPERTIES = new Properties();

    static {
        initProperties(ENDPOINTS_PROPERTIES, ENDPOINTS_FILE);
    }

    /**
     * Returns value by key from file property
     *
     * @param property The key by which get the value
     * @return File property value
     */
    public static String getEndpointProperty(String property) {
        return ENDPOINTS_PROPERTIES.getProperty(property);
    }

    private static synchronized void initProperties(Properties properties, String fileName) {
        try (InputStream inputStream = PropertiesReader.class.getResourceAsStream(fileName)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to load properties from file: " + fileName);
        }
    }
}
