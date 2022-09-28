package com.reusablecomponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class Properties_Operation {

	static Properties prop = new Properties();
	
	
	
	public static String getPropertyValueByKey(String key) throws Exception {
		//load data from property file
		//read data
		
		String propfile= "C:\\Users\\admin\\eclipse-workspace\\Training.insuranceCalculator\\src\\test\\resources\\configuration1.properties";
		//String propfile= System.getProperty("user.dir")+"src/test/resources/configuration1.properties";
		FileInputStream fis = new FileInputStream(propfile);
		prop.load(fis);
		
		String value=prop.getProperty(key).toString();
		
		if(StringUtils.isEmpty(value)) {
			throw new Exception("value is not specified for key"+ key +"in properties file");
		}
		
		
		return value;
	}
	
	
}
