package com.ensimtest.module.orders;

import com.ensimtest.config.Browser;
import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class CreateOrderSelectItems extends AppData
{
	public class ItemRow
	{
		public String itemName, priceInfo, orgDiscount, promo, itemSubtotal;
		public Element checkedMark, textBox, listBox, checkBox;
		
		private Element setElement(Element []innerElements)
		{
			if(innerElements == null)
			{
				return null;
			}
			else
			{
				if(innerElements.length == 0)
				{
					return null;
				}
				else
				{
					return innerElements[0];
				}
			}
		}
		
		private void setQuantity(Element element)
		{
			Element div = new ElementSet().getSubElementSet(element, "Xpath", "./div")[0];
			
			ElementSet set = new ElementSet();
			
			// Checking for checkedMark
			checkedMark = setElement(set.getSubElementSet(div, "Xpath", "./img"));
			
			// Checking for Text-box
			textBox  = setElement(set.getSubElementSet(div, "Xpath", "./input[@type='text']"));
			
			// Checking for List-Box
			listBox = setElement(set.getSubElementSet(div, "Xpath", "./select"));
			
			// Checking for Check-Box
			checkBox = setElement(set.getSubElementSet(div, "Xpath", "./input[@type='checkbox']"));
			return;
		}
		
		public ItemRow(Element element)
		{
			System.out.println(">> " + element);
			itemName = new ElementSet().getSubElementSet(element, "ClassName", "padding_15")[0].read().trim();
			Element []elements = new ElementSet().getSubElementSet(element, "ClassName", "padding_3");
			System.out.println("length : " + elements.length);
			if(elements.length==3)
			{
				priceInfo = elements[0].read();
				orgDiscount = elements[1].read();
				itemSubtotal = elements[2].read();
			}
			
			
			setQuantity(elements[1]);
	
		}
	}
	private class ItemTable extends Element
	{
		public ItemTable()
		{
			setElement(readAppData(this));
		}
	}
	
	private class ItemRowFinder extends Element
	{
		public String []info;
		public ItemRowFinder()
		{
			info = readAppData(this);
		}
	}
	
	public ItemRow[] getItemRows(Browser browser)
	{
		try
		{
			browser.setWait(1);
			ItemTable table = new ItemTable();
			ItemRowFinder itemFinder = new ItemRowFinder();
			ElementSet set = new ElementSet();
			Element elements[] = set.getSubElementSet(table, itemFinder.info[0], itemFinder.info[1]);
			ItemRow []rows = new ItemRow[elements.length-1];
			for(int i=0;i<rows.length; i++)
			{
				rows[i] = new ItemRow(elements[i+1]);
			}
			return rows;
		}
		finally
		{
			browser.setDefaultWait();
		}
	}

	public class MonthlySubtotal extends Element
	{
		public MonthlySubtotal()
		{
			setElement(readAppData(this));
		}
	}
	public MonthlySubtotal monthlySubtotal = new MonthlySubtotal();
	
	public class OneTimeSubtotal extends Element
	{
		public OneTimeSubtotal()
		{
			setElement(readAppData(this));
		}
	}
	public OneTimeSubtotal oneTimeSubtotal = new OneTimeSubtotal();
	
	public class GrossTotal extends Element
	{
		public GrossTotal()
		{
			setElement(readAppData(this));
		}
	}
	public GrossTotal grossTotal = new GrossTotal();

}
