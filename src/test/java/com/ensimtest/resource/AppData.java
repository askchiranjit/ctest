package com.ensimtest.resource;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.ensimtest.utils.FileHandling;

public class AppData
{
	private String resFilePath = "resources\\strings\\";
	
	public String[] readAppData(Object className)
	{
		String fullName = className.getClass().getCanonicalName().toString();
		String packageName = className.getClass().getPackage().toString().replace("package", "").trim();
		String subClassName = className.getClass().getSimpleName().toString();
		String parentClassName = fullName.replace(packageName, "").replace(subClassName, "").replace(".", "").trim();
		FileHandling file = new FileHandling();
		Document document = null;
		try
		{
			document = file.getXmlDocument(resFilePath + parentClassName + ".xml");
		} 
		catch (ParserConfigurationException | SAXException | IOException e)
		{
			System.out.println(e);
		}
		return file.getXmlNodeKeyValuePair(document, subClassName);	
	}
}
