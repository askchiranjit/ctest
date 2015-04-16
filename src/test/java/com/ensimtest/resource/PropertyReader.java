package com.ensimtest.resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	public static String propertyFile="resources\\testprop\\framework.properties"; 
	public static Properties prop;
	public static FileInputStream fis;
	
	public PropertyReader() throws IOException
	{
		prop=new Properties();
		fis=new FileInputStream(propertyFile);
		prop.load(fis);
	}

	public String getURL() throws IOException
	{

		return prop.getProperty("URL").trim();			
	}
	public String getBrowserName() throws IOException
	{

		return prop.getProperty("BrowserName").trim();			
	}

}
