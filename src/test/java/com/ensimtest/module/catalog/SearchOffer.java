package com.ensimtest.module.catalog;

import com.ensimtest.config.Browser;
import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

/**
 * To list out all the Offers under a categories
 * @author Dip
 *
 */
public class SearchOffer extends AppData{
	
	public class OfferRow
	{
		public String offerName, rank, subscription;
		public Element rankTxt, offerNameLnk, activeStatusLnk, deactiveStatusLnk, P2OofferType,
		P2RofferType, ENTofferType, conflictBtn, weightBtn, groupBtn;
		ElementSet set = new ElementSet();
		
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
		
				
		public OfferRow(Element element)
		{
			
			// Checking for rank text box
			rankTxt = setElement(set.getSubElementSet(element, "Xpath", "td[1]//div//div//div[@id='display_order_offer']//input"));
			System.out.println(rankTxt);
			
			//Checking for rank of offer
			rank = setElement(set.getSubElementSet(element, "Xpath", "td[1]//div//div//div[@id='display_order_offer1']//strong")).read().trim();
			System.out.println(rank);
			
			//Offer Name and link
			offerNameLnk = set.getSubElementSet(element, "Xpath", "td[2]//a")[0];
			offerName = offerNameLnk.read().split("\n")[0].trim();
			System.out.println(offerNameLnk);
			System.out.println(offerName);
			
			//Subscription
			subscription = set.getSubElement(element, "Xpath", "td[3]").read().trim();
			System.out.println(subscription);
			
			//Offer Active status
			activeStatusLnk = setElement(set.getSubElementSet(element, "Xpath", "td[4]//a//img[contains(@src,'icon20.gif')]"));
			System.out.println(activeStatusLnk);
			
			//Offer de-active status
			deactiveStatusLnk = setElement(set.getSubElementSet(element, "Xpath", "td[4]//a//img[contains(@src,'icon38.gif')]"));
			System.out.println(deactiveStatusLnk);
			
			// Checking for P2O offer type
			P2OofferType  = setElement(set.getSubElementSet(element, "Xpath", "td[4]//a//img[contains(@src,'doller.png')]"));
			System.out.println(P2OofferType);
			
			// Checking for P2R offer type
			P2RofferType  = setElement(set.getSubElementSet(element, "Xpath", "td[4]//a//img[contains(@src,'rpp_discount_cofigure.png')]"));
			System.out.println(P2RofferType);
			
			// Checking for ENT offer type
			ENTofferType  = setElement(set.getSubElementSet(element, "Xpath", "td[4]//a//img[contains(@src,'type3.png')]"));
			System.out.println(ENTofferType);
			
			// Checking for Conflict button
			conflictBtn = setElement(set.getSubElementSet(element, "Xpath", "td[5]//input[@id='cofigureConflictOffer']"));
			System.out.println(conflictBtn);
			
			// Checking for weight button
			weightBtn = set.getSubElementSet(element, "Xpath", "td[6]//input[@id='configureWeight']")[0];
			System.out.println(weightBtn);
			
			// Checking for group button
			groupBtn = set.getSubElementSet(element, "Xpath", "td[7]//input[@id='configureGroup']")[0];
			System.out.println(groupBtn);
		}
	}
	private class OfferTable extends Element
	{
		public OfferTable()
		{
			setElement(readAppData(this));
		}
	}
	
	private class OfferRowFinder extends Element
	{
		public String []info;
		public OfferRowFinder()
		{
			info = readAppData(this);
		}
	}
	
	public OfferRow[] getOfferRows(Browser browser)
	{
		try
		{
			browser.setWait(1);
			OfferTable table = new OfferTable();
			System.out.println(table.read());
			OfferRowFinder offerRowFinder = new OfferRowFinder();
			ElementSet set = new ElementSet();
			Element elements[] = set.getSubElementSet(table, offerRowFinder.info[0], offerRowFinder.info[1]);
			System.out.println(elements.length);
			OfferRow []rows = new OfferRow[elements.length];
			for(int i=0;i<rows.length; i++)
			{
				System.out.println("Row no:- "+i);
				rows[i] = new OfferRow(elements[i]);
			}
			return rows;
		}
		finally
		{
			browser.setDefaultWait();
		}
	}

	
}
