package com.ensimtest.config;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ensimtest.base.ElementType;
import com.ensimtest.base.IElement;

/**
 * This implements IElements along with some additional methods
 * @author Chiranjit
 *
 */
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
	
	/**
	 * This sets the elements with element types(ID, XPath, etc.) and elements names
	 * @param elementType : Type of element to identify the element as string
	 * @param elementName : Value related to the type
	 */
	protected void setElement(String elementType, String elementName)
	{
		this.elementName = elementName;
		this.type = handler.getElementType(elementType);;
	}
	
	/**
	 * This sets the elements with element types(ID, XPath, etc.) and elements names
	 * @param elementType : Type of element to identify the element
	 * @param elementName : Value related to the type
	 */
	protected void setElement(ElementType elementType, String elementName)
	{
		this.elementName = elementName;
		this.type = elementType;
	}
	
	/**
	 * This sets the elements with String array data
	 * @param elementInfo : String(0) contains key, String(1) contains value 
	 */
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
		try
		{
			return webElement.isDisplayed() && webElement.isEnabled();
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean isDisplayed() {
		webElement = handler.reloadElement(elementName, type);
		try
		{
			return webElement.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
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
	
	/**
	 * Returns attribute value based on the attribute name of the element
	 * @param attributeName : name of the attribute associated with the element
	 * @return : returns the value as String
	 */
	protected String getAttributeValue(String attributeName)
	{
		webElement = handler.reloadElement(elementName, type);
		String s = webElement.getAttribute(attributeName);
		System.out.println("Attribute >> " + s);
		return s;
	}
	
	/**
	 * Selects value from the drop-down/list box
	 * @param data : the value to be selected
	 */
	protected void selectValue(String data)
	{
		webElement = handler.reloadElement(elementName, type);
		Select select = new Select(webElement);
		select.selectByValue(data);
	}
	
	/**
	 * Selects visible value from the drop-down/list box
	 * @param data : the value to be selected
	 */
	protected void selectVisibleText(String data)
	{
		webElement = handler.reloadElement(elementName, type);
		Select select = new Select(webElement);
		select.selectByVisibleText(data);
	}
	
	protected boolean isError()
	{
		if(getAttributeValue("class").equals("field required eas-error-msg"))
			return true;
		else
			return false;
	}
	
	/**
	 * Move the cursor on the element
	 */
	protected void mouseHover()
	{
		webElement = handler.reloadElement(elementName, type);
		handler.moveMouseToElement(webElement);
	}

	@Override
	public boolean isEnabled() {
		webElement = handler.reloadElement(elementName, type);
		return webElement.isEnabled();
	}
	
	protected boolean isSelected()
	{
		webElement = handler.reloadElement(elementName, type);
		return webElement.isSelected();
		
	}

}
