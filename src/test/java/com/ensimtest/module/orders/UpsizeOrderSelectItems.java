package com.ensimtest.module.orders;

import com.ensimtest.config.Browser;
import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class UpsizeOrderSelectItems extends AppData
{
	
	public class UpsizeItemRow
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
//			Element div = new ElementSet().getSubElementSet(element, "Xpath", "./div")[0];
			
			ElementSet set = new ElementSet();
			
			// Checking for checkedMark
			checkedMark = setElement(set.getSubElementSet(element, "Xpath", "table//tbody//tr//td[1]//img"));
			
			// Checking for Text-box
			textBox  = setElement(set.getSubElementSet(element, "Xpath", "table//tbody//tr//td[1]//input[@type='text']"));
			if(textBox==null)
			{
				textBox  = setElement(set.getSubElementSet(element, "Xpath", "input[@type='text']"));
			}
			
			// Checking for List-Box
			listBox = setElement(set.getSubElementSet(element, "Xpath", "table//tbody//tr//td[1]//select"));
			
			// Checking for Check-Box
			checkBox = setElement(set.getSubElementSet(element, "Xpath", "table//tbody//tr//td[1]//input[@type='checkbox']"));
			if(checkBox==null)
			{
				checkBox  = setElement(set.getSubElementSet(element, "Xpath", "input[@type='checkbox']"));
			}
			return;
		}
		
		public UpsizeItemRow(Element element)
		{
			System.out.println(">> " + element);
			itemName = new ElementSet().getSubElementSet(element, "Xpath", "td[1]")[0].read().trim();
			Element elements = new ElementSet().getSubElementSet(element, "Xpath", "td[3]")[0];
//			System.out.println("length : " + elements.length);
//			if(elements.length==3)
//			{
//				priceInfo = elements[0].read();
//				orgDiscount = elements[1].read();
//				itemSubtotal = elements[2].read();
//			}
//			
//			
			setQuantity(elements);
	
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
		
		
		public UpsizeItemRow[] getItemRows(Browser browser)
		{
			try
			{
				browser.setWait(1);
				ItemTable table = new ItemTable();
				ItemRowFinder itemFinder = new ItemRowFinder();
				ElementSet set = new ElementSet();
				Element elements[] = set.getSubElementSet(table, itemFinder.info[0], itemFinder.info[1]);
				UpsizeItemRow []rows = new UpsizeItemRow[elements.length-1];
				for(int i=0;i<rows.length; i++)
				{
					rows[i] = new UpsizeItemRow(elements[i+1]);
				}
				return rows;
			}
			finally
			{
				browser.setDefaultWait();
			}
		}

}
