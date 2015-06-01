package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class CreateOrderSelectItems extends AppData
{
	public class ItemRow
	{
		public String itemName, priceInfo, orgDiscount, promo, itemSubtotal;
		public Element quantity;
		public ItemRow(Element element)
		{
			//System.out.println(element.read());
			
			itemName = new ElementSet().getSubElementSet(element, "ClassName", "padding_15")[0].read().trim();
			
			Element []elements = new ElementSet().getSubElementSet(element, "ClassName", "padding_3");
			priceInfo = elements[0].read();
			quantity = elements[1];
			orgDiscount = elements[2].read();
			itemSubtotal = elements[3].read();
			
			System.out.println("\n >>>> " + itemName + "..." + priceInfo + "..." + itemSubtotal);
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
	
	public ItemRow[] getItemRows()
	{
		ItemTable table = new ItemTable();
		ItemRowFinder itemFinder = new ItemRowFinder();
		ElementSet set = new ElementSet();
		Element elements[] = set.getSubElementSet(table, itemFinder.info[0], itemFinder.info[1]);
		System.out.println(elements.length);
		ItemRow []rows = new ItemRow[elements.length-1];
		for(int i=0;i<rows.length; i++)
		{
			rows[i] = new ItemRow(elements[i+1]);
		}
		return rows;
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
