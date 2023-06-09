package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

	Properties properties = null;
	public void loadProperties() throws IOException {
		properties = new Properties();
		try {
		//String projectDirPath = System.getProperty("user.dir");
		String propFilePath = "C:\\Users\\Harshith kumar\\eclipse-workspace\\Appium\\AppiumExamples\\resources\\CapabilityProperties.properties";
		InputStream ins = new FileInputStream(propFilePath);
		properties.load(ins);

		} catch (Exception e) {
			System.err.println("An exception has occurred while reading the properties file");
			e.printStackTrace();
		}
	}
	
	public String get(String key) {
		return properties.getProperty(key);
	}
	
	public String getScreenshotDir() throws IOException {
		loadProperties();
		return properties.getProperty("screenshot.location");
	}
}


