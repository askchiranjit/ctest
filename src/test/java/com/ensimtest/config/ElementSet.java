package com.ensimtest.config;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.ensimtest.base.ElementType;

public class ElementSet
{
	public Element[] getElementSet(String elementType, String elementName)
	{
		ElementHandler handler = new ElementHandler();
		ElementType typeOfElement = handler.getElementType(elementType);
		List<WebElement> list = handler.getElements(elementName, typeOfElement);
		Element []elements = new Element[list.size()];
		for(int i=0; i<elements.length; i++)
		{
			elements[i] = new Element();
			elements[i].setElement(list.get(i));
		}
		return elements;
	}
	public Element[] getSubElementSet(Element element, String elementType, String elementName)
	{
		boolean isExistingElement = element.isExists();
		if(!isExistingElement)
			return null;
		ElementHandler handler = new ElementHandler();
		ElementType typeOfElement = handler.getElementType(elementType);
		List<WebElement> list = handler.getElements(element, elementName, typeOfElement);
		Element []elements = new Element[list.size()];
		for(int i=0; i<elements.length; i++)
		{
			elements[i] = new Element();
			elements[i].setElement(list.get(i));
		}
		return elements;
	}
}