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

	protected void setElement(String elementName, ElementType type)
	{
		handler = new ElementHandler();
		this.elementName = elementName;
		this.type = type;
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
	
	protected boolean IsError()
	{
		if(getAttributeValue("class").equals("field required eas-error-msg"))
			return true;
		else
			return false;
	}
	
	protected void mouseHover()
	{
		handler.moveMouseToElement(webElement);
	}

}