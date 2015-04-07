
package com.ensimtest.utils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

//import java.io.*;


public class FileHandling
{
	public String ReadFileData(String filepath)
	{
		return "";
	}
	
	public Document getXmlDocument(String filename) throws ParserConfigurationException, SAXException, IOException
	{
		File fXmlFile = new File(filename);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		return doc;
	}
	
	public String[] getXmlNodeKeyValuePair(Document document, String nodeName)
	{
		Node node = document.getElementsByTagName(nodeName).item(0);
		Element element = (Element) node;
		String []pair = new String[2];
		pair[0] = element.getElementsByTagName("key").item(0).getTextContent().trim();
		pair[1] = element.getElementsByTagName("value").item(0).getTextContent().trim();
		return pair;
	}
}
