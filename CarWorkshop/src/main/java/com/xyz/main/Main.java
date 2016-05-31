package com.xyz.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.xyz.com.xyz.processes.EmployeeTaskManager;
import com.xyz.com.xyz.processes.WorkshopScheduler;

/**
 * Created by raj on 24/3/16.
 */
public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class);
	private static Integer SCHEDULER_POOL_SIZE;
	private static Integer START_HOUR_OF_DAY;
	private static String PRIORITIZATION_STRATEGY;

	public static void main(String[] args) {
		if (args.length > 0) {
			logger.info("Starting the car workshop app.");
			// Initialize App with config.
			initializeApp();

			logger.info("App Initialized");
			EmployeeTaskManager.start(START_HOUR_OF_DAY);
		} else {
			logger.fatal("Please specify action 'start' as command line argument");
		}
	}

	private static void initializeApp() {
		loadProperties();
		WorkshopScheduler.initializeScheduler(SCHEDULER_POOL_SIZE, PRIORITIZATION_STRATEGY);
	}

	private static void loadProperties() {
		Properties prop = new Properties();
		String propFileName = "config.properties";

		try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(propFileName)) {
			if (inputStream != null) {
				prop.load(inputStream);
				SCHEDULER_POOL_SIZE = Integer.parseInt(Optional.ofNullable(prop.getProperty("SCHEDULER_POOL_SIZE")).orElse("10"));
				START_HOUR_OF_DAY = Integer.parseInt(Optional.ofNullable(prop.getProperty("START_HOUR_OF_DAY")).orElse("9"));
				PRIORITIZATION_STRATEGY = Optional.ofNullable(prop.getProperty("PRIORITIZATION_STRATEGY")).orElse("BY_FEE");
			}
			logger.info("Properties loaded");
		} catch (IOException e) {
			logger.error("Config file not found.");
		}
	}
}
