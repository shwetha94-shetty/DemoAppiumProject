package com.jch.rac.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropertiesFile {
	
	public static String singlePropertiesUtils(String keyName) throws IOException {
		Properties property = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");
		property.load(objfile);
		String keyValue = property.getProperty(keyName);
		System.out.println("Value: " +keyValue);
		return keyValue;
	}
}
