package com.ensimtest.resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetEASMessages 
{
	private static String propertyFile="resources\\strings\\easmessage.properties"; 
	private static Properties prop;
	private static FileInputStream fis;
	
	public GetEASMessages() 
	{
		try{
		prop=new Properties();
		fis=new FileInputStream(propertyFile);
		prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace().toString());
		}
	}
	
	public String getProperty(String propertName)
	{
		return prop.getProperty(propertName).trim();
	}
}
