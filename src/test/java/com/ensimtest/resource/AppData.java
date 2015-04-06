package com.ensimtest.resource;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.ensimtest.utils.FileHandling;
public class AppData
{
	private String resFilePath = "resources\\strings\\";
	
	public String[] readAppData(Object className) throws ParserConfigurationException, SAXException, IOException
	{
		String fullName = className.getClass().getCanonicalName().toString();
		String packageName = className.getClass().getPackage().toString().replace("package", "").trim();
		String subClassName = className.getClass().getSimpleName().toString();
		String parentClassName = fullName.replace(packageName, "").replace(subClassName, "").replace(".", "").trim();

		String fileName = resFilePath + parentClassName + ".xml";
		FileHandling file = new FileHandling();
		Document document = file.getXmlDocument(fileName);
		
		return file.getXmlNodeKeyValuePair(document, subClassName);	
	}
}
