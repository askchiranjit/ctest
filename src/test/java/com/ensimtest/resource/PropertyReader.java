package com.ensimtest.resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	private static String propertyFile="resources\\testprop\\framework.properties"; 
	private static Properties prop;
	private static FileInputStream fis;
	
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
