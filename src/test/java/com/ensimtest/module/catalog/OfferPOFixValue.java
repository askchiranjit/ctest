package com.ensimtest.module.catalog;

import com.ensimtest.config.Browser;
import com.ensimtest.config.Element;
import com.ensimtest.config.ElementHandler;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

/**
 * To get the list of Item Added in offer
 * @author Dip
 *
 */
public class OfferPOFixValue extends AppData{

	public class POFixValueRow
	{
		public String resourceName, resourceID;
		public Element quantityTxt;
		ElementSet set = new ElementSet();
		

		public POFixValueRow(Element element)
		{

			// Resource Name
			resourceName = set.getSubElement(element, "Xpath", "td[1]").read().trim();
			//System.out.println(resourceName);

			// Resource ID
			resourceID = set.getSubElement(element, "Xpath", "td[2]").read().trim();
			//System.out.println(resourceID);
			
			// PO fix quantity
			quantityTxt = set.getSubElementSet(element, "Xpath", "td[3]//input")[0];
			//System.out.println(quantityTxt);
			
			
			try{
				ElementHandler elementHandler=new ElementHandler();
				String scrlXpath = "(//div[contains(@class,'slimScrollBar ui-draggable')])[1]";
				elementHandler.scrollDown(scrlXpath);
			}catch(Exception e){
				System.out.println(e);
			}
			
		}
	}
	private class POFixValueTable extends Element
	{
		public POFixValueTable()
		{
			setElement(readAppData(this));
		}
	}

	private class POFixValueRowFinder extends Element
	{
		public String []info;
		public POFixValueRowFinder()
		{
			info = readAppData(this);
		}
	}

	public POFixValueRow[] getPOFixValueRows(Browser browser)
	{
		try
		{
			browser.setWait(1);
			POFixValueTable table = new POFixValueTable();
			//System.out.println(table.read());
			POFixValueRowFinder poFixValueRowFinder = new POFixValueRowFinder();
			ElementSet set = new ElementSet();
			Element elements[] = set.getSubElementSet(table, poFixValueRowFinder.info[0], poFixValueRowFinder.info[1]);
			//System.out.println(elements.length);
			POFixValueRow []rows = new POFixValueRow[elements.length];
			for(int i=0;i<rows.length; i++)
			{
				//System.out.println("Row no:- "+i);
				rows[i] = new POFixValueRow(elements[i]);
			}
			try{
				ElementHandler elementHandler=new ElementHandler();
				String scrlXpath = "(//div[contains(@class,'slimScrollBar ui-draggable')])[1]";
				elementHandler.scrollUp(scrlXpath);;
			}catch(Exception e){
				System.out.println(e);
			}
			return rows;
		}
		finally
		{
			browser.setDefaultWait();
		}
	}
}

