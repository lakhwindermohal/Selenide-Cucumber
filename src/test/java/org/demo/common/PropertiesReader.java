package org.demo.common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


/**
 * Reads the contents of a Properties file.
 */
public class PropertiesReader {

    /**
     * Stores the file path to the properties file.
     */
    private final String configFilePath;


    /**
     * Reads properties from a given properties file.
     *
     * @param propertiesFile The file path for the properties file.
     */
    public PropertiesReader(String propertiesFile) {
        this.configFilePath = propertiesFile;
    }


    /**
     * Gets the given value from the properties file.
     *
     * @param key The name of the property to retrieve.
     * @return the value of the given property.
     */
    public String getValue(String key) throws Exception {
        // Read the properties file.
        File file = new File(this.configFilePath);
        FileInputStream fileInputStream = new FileInputStream(file);

        // Create a properties object from the file.
        Properties properties = new Properties();
        properties.load(fileInputStream);

        // Get the property.
        String property = properties.getProperty(key);

        // Make sure the property is NOT null.
        if (property == null) {
            throw new Exception(String.format(Formats.PROPERTY_NOT_FOUND, key));
        }

        // Return the property.
        return property;
    }
}