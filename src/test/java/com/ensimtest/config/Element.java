package com.ensimtest.config;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import com.ensimtest.base.ElementType;
import com.ensimtest.base.IElement;

public class Element implements IElement
{
	private WebElement webElement;
	private String elementName;
	private ElementType type;
	private ElementHandler handler;

	public Element()
	{
		handler = new ElementHandler();
	}
	
	protected void setElement(String elementType, String elementName)
	{
		this.elementName = elementName;
		this.type = handler.getElementType(elementType);;
	}
	
	protected void setElement(ElementType elementType, String elementName)
	{
		this.elementName = elementName;
		this.type = elementType;
	}
	
	protected void setElement(String []elementInfo)
	{
		setElement(elementInfo[0], elementInfo[1]);
	}
	
	@Override
	public void click() {
		webElement = handler.reloadElement(elementName, type);
		webElement.click();
	}

	@Override
	public boolean isExists() {
		webElement = handler.reloadElement(elementName, type);
		return webElement.isDisplayed() && webElement.isEnabled();
	}

	@Override
	public boolean isDisplayed() {
		webElement = handler.reloadElement(elementName, type);
		return webElement.isDisplayed();
	}

	@Override
	public String read() {
		webElement = handler.reloadElement(elementName, type);
		return webElement.getText();
	}

	@Override
	public void write(String msg) {
		webElement = handler.reloadElement(elementName, type);
		webElement.sendKeys(msg);
	}
	
	protected String getAttributeValue(String attributeName)
	{
		webElement = handler.reloadElement(elementName, type);
		String s = webElement.getAttribute(attributeName);
		System.out.println("Attribute >> " + s);
		return s;
	}
	
	protected void selectValue(String data)
	{
		Select select = new Select(webElement);
		select.selectByValue(data);
	}
	
	protected boolean isError()
	{
		if(getAttributeValue("class").equals("field required eas-error-msg"))
			return true;
		else
			return false;
	}
	
	protected void mouseHover()
	{
		webElement = handler.reloadElement(elementName, type);
		handler.moveMouseToElement(webElement);
	}

}