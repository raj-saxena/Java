package com.xyz;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.xyz.helper.StationManager;

/**
 * Metro Smart Card System
 *
 */
public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        startMetroCardSystem();

    }

    public static void startMetroCardSystem() {
        initializeFareStrategy();
        initializeStations();
    }

    private static void initializeStations() {
        StationManager.initializeStations();
    }

    private static void initializeFareStrategy() {
        Properties props = new Properties();
        String propFileName = "config.properties";

        try (InputStream inputStream = App.class.getClassLoader().getResourceAsStream(propFileName)) {
            if (inputStream != null) {
                props.load(inputStream);
            }
            FareStrategy.initialize(props);
            logger.info("Fare strategy initialized successfully.");
        } catch (IOException e) {
            logger.error("Exception occurred ", e);
        }
    }
}