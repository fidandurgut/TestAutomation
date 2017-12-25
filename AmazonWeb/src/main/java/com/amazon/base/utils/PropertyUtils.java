package com.amazon.base.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
	private static PropertyUtils instance= new PropertyUtils();
	private Properties properties = new Properties();
	private String propFilePath = ".\\amazon.properties";
	
	private PropertyUtils() {
		try {
			properties.load(new FileInputStream(propFilePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String readProperty(String key) throws Exception {
		try {
			return properties.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static PropertyUtils getInstance(){
		return instance;
	}
}