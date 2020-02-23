package com.svr.kafkasample.app.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    FileReader reader;
    Properties properties;
    Logger LOGGER = LoggerFactory.getLogger(PropertyLoader.class.getName());

    public Properties loadProperty(String propertiesFileName) {
        try {
            new FileReader(propertiesFileName);
            new Properties();
            properties.load(reader);
        } catch (FileNotFoundException fe) {
            LOGGER.error("Properties file not Found " + fe.getLocalizedMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
