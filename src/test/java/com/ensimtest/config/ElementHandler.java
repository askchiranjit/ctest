package com.ensimtest.config;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.ensimtest.base.ElementType;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.ensimtest.base.Driver;

public class ElementHandler
{
	protected WebElement reloadElement(String elementName, ElementType type)
	{
		return getElement(elementName, type);
	}
	
	public ElementType getElementType(String elementType)
	{
		ElementType type = null;
		switch(elementType)
		{
		case "ClassName":
			type = ElementType.ClassName;
			break;
		case "ID":
			type = ElementType.ID;
			break;
		case "Xpath":
			type = ElementType.Xpath;
			break;
		case "Name":
			type = ElementType.Name;
			break;
		case "TagName":
			type = ElementType.TagName;
			break;
		}
		return type;
	}
	
	protected List<WebElement> getElements(String elementName, ElementType type)
	{
		List<WebElement> list = null;
		switch(type)
		{
		case ClassName:
			list = Driver.driver.findElements(By.className(elementName));
			break;
		case ID:
			list = Driver.driver.findElements(By.id(elementName));
			break;
		case Xpath:
			list = Driver.driver.findElements(By.xpath(elementName));
			break;
		case Name:
			list = Driver.driver.findElements(By.name(elementName));
			break;
		case TagName:
			list = Driver.driver.findElements(By.tagName(elementName));
			break;
			
		default:
			break;
		}
		return list;
	}
	
	protected WebElement getElement(String elementName, ElementType type)
	{
		List<WebElement> list = getElements(elementName, type);
		if(list.size()==0)
			throw new ElementNotFoundException(elementName, type.toString(), elementName);
		else
		{
			return list.get(0);
		}
	}
	
	/**
	 * this is used for moving the cursor on the element
	 * @param element Web-Element on which cursor will move
	 */
	protected void moveMouseToElement(WebElement element)
	{
		Actions action = new Actions(Driver.driver);
		action.moveToElement(element).build().perform();
	}
}
