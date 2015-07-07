package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class UpgradeOrder extends AppData
{
	public class OrderOption
	{
		public String orderName = "";
		public Element showElementBtn;
		public OrderOption(Element element)
		{
			orderName = element.read().trim();
			ElementSet set = new ElementSet();
			showElementBtn = set.getSubElement(element, "Xpath", "//table//tbody//tr//td[contains(text(),'Show Details')]");
		}
	}
	public OrderOption[] getAvailableOrderOptions()
	{
		ElementSet set = new ElementSet();
		Element []element = set.getElementSet("ClassName", "pOfferList");
		OrderOption []options = new OrderOption[element.length];
		
		for(int i=0; i<options.length; i++)
		{
			options[i] = new OrderOption(element[i]);
		}
		
		return options;
	}
	
	public class PlaceUpdatedOrder extends Element
	{
		public PlaceUpdatedOrder()
		{
			setElement(readAppData(this));
		}
	}
	public PlaceUpdatedOrder placeUpdatedOrder = new PlaceUpdatedOrder();
}