package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class CreateOrderSelectOffer extends AppData
{
	private class OfferLet
	{
		public String []info;
		public OfferLet()
		{
			info = readAppData(this);
		}
	}
	
	private class OrderButtons
	{
		public String []info;
		public OrderButtons()
		{
			info = readAppData(this);
		}
	}
	
	public class Offer
	{
		public String offerName, offerDescription;
		public Element orderBtn, tryBtn;
		
		public Offer(Element element)
		{
			String []info = new OrderButtons().info;
			ElementSet set = new ElementSet();
			Element[] buttons = set.getSubElementSet(element, info[0], info[1]);
			
			// Setting up buttons
			orderBtn = buttons[0];
			tryBtn = buttons.length==2 ? buttons[1] : null;
			
			// Setting up labels
			String []data = element.read().trim().split("\n");
			offerName = data[0];
			offerDescription = (data.length - buttons.length) == 2 ? data[1] : "";			
		}
	}
	
	public Offer[] getOffers()
	{
		ElementSet set = new ElementSet();
		String []info = new OfferLet().info;
		Element[] elements = set.getElementSet(info[0], info[1]);
		Offer []listOfOffer = new Offer[elements.length];
		for(int i=0; i<listOfOffer.length; i++)
		{
			listOfOffer[i]=new Offer(elements[i]);
		}
		return listOfOffer;
	}
}
