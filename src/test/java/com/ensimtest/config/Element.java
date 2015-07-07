package com.ensimtest.config;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.ensimtest.base.Driver;
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
		type = null;
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

	protected void setElement(WebElement element)
	{
		this.webElement = element;
	}

	protected WebElement getWebElement()
	{
		return webElement;
	}

	protected Element getElement()
	{
		return this;
	}

	@Override
	public void click() {
		webElement = getReloadedElement(elementName, type);
		webElement.click();
	}

	@Override
	public boolean isExists() {
		try
		{
			webElement = getReloadedElement(elementName, type);
			return webElement.isDisplayed() && webElement.isEnabled();
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean isDisplayed() {
		try
		{
			webElement = getReloadedElement(elementName, type);
			if(webElement == null)
			{
				System.out.println("null element");
				return false;
			}
			else
			{
				return webElement.isDisplayed();
			}
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public String read() {
		webElement = getReloadedElement(elementName, type);
		return webElement.getText();
	}

	@Override
	public void write(String msg) {
		webElement = getReloadedElement(elementName, type);
		webElement.sendKeys(msg);
	}





	/**
	 * Returns attribute value based on the attribute name of the element
	 * @param attributeName : name of the attribute associated with the element
	 * @return : returns the value as String
	 */
	public String getAttributeValue(String attributeName)
	{
		webElement = getReloadedElement(elementName, type);
		String s = webElement.getAttribute(attributeName);
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
	public void selectVisibleText(String data)
	{
		webElement = getReloadedElement(elementName, type);
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
		webElement = getReloadedElement(elementName, type);
		handler.moveMouseToElement(webElement);
	}

	@Override
	public boolean isEnabled() {
		webElement = getReloadedElement(elementName, type);
		if(webElement == null)
			return false;
		else
			return webElement.isEnabled();
	}

	protected boolean isSelected()
	{
		webElement = getReloadedElement(elementName, type);
		return webElement.isSelected();
	}

	@Override
	public void clear()
	{
		webElement = getReloadedElement(elementName, type);
		webElement.clear();
	}



	private WebElement getReloadedElement(String elementName, ElementType type)
	{
		if(type==null)
		{
			return webElement;
		}
		else
		{
			try
			{
				return handler.reloadElement(elementName, type);
			}
			catch(Exception e)
			{
				System.out.println(e);
				throw e;
			}
		}
	}


	protected void check()
	{
		webElement = handler.reloadElement(elementName, type);
		if(webElement.isSelected()==false)
		{
			webElement.click();
		}
	}

	protected void unCheck()
	{
		webElement = handler.reloadElement(elementName, type);
		if(webElement.isSelected()==true)
		{
			webElement.click();
		}
	}

	protected boolean isEntityPresent(String entity_name)
	{

		List<WebElement> webElements=handler.getElements(elementName, type);

		for(int i=0;i<webElements.size();i++)
		{
			String s[]=webElements.get(i).getText().split("\n");
			if(entity_name.equals(s[0].trim()))
			{
				return true;
			}

		}
		return false;

	}

	protected String getSelectedType()
	{
		webElement = getReloadedElement(elementName, type);
		Select selectElement=new Select(webElement);
		return selectElement.getFirstSelectedOption().getText();
	}


	protected String[] getSelectedTypes()
	{
		String [] selectedElements=null;
		webElement = getReloadedElement(elementName, type);
		Select selectElement=new Select(webElement);
		List<WebElement> subElements= selectElement.getAllSelectedOptions();
		selectedElements = new String[subElements.size()];
		for(int i=0;i<subElements.size();i++)
		{
			selectedElements[i]=subElements.get(i).getText();

		}
		return selectedElements;
	}

	protected String selectedText()
	{
		webElement = handler.reloadElement(elementName, type);
		Select select = new Select(webElement);
		return select.getFirstSelectedOption().getText();
	}
	
	/**
	 * @author Dip
	 * @param length
	 */
	public void clearAllChars(int length)
	{		
		click();
		Actions action = new Actions(Driver.driver);
		
		for(int i=0; i<length; i++)
		{
			action.sendKeys(Keys.BACK_SPACE).build().perform();
		}
	}
	

}
