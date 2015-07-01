package com.ensimtest.module.catalog;

import com.ensimtest.config.Browser;
import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

/**
 * To get the list of Provisioning Information of offer
 * @author Dip
 *
 */
public class OfferProvisioningInformationLst extends AppData{
	
	public class ProvisioningInfoRow
	{
		public String resourceName, resourceID, mandetory;
		public Element rankTxt, visibilityInOrderLst, defaultTxt, defaultChk, exportChk;
		
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
			Element td = new ElementSet().getSubElementSet(element, "Xpath", "./td")[0];
			
			ElementSet set = new ElementSet();
			
			// Checking for checkedMark
			rankTxt = set.getSubElementSet(td, "Xpath", "./input[@type='text']")[0];
			
			// Checking for Text-box
			visibilityInOrderLst  = set.getSubElementSet(td, "Xpath", "./select")[0];
			
			// Checking for List-Box
			defaultTxt = setElement(set.getSubElementSet(td, "Xpath", "./input[@type='text']"));
			
			// Checking for Check-Box
			defaultChk = setElement(set.getSubElementSet(td, "Xpath", "./input[@type='checkbox']"));
			
			// Checking for Check-Box
			exportChk = set.getSubElementSet(td, "Xpath", "./input[@type='checkbox']")[0];
			return;
		}
		
		public ProvisioningInfoRow(Element element)
		{
			System.out.println(">> " + element.read());
		
			//
			
			setQuantity(element);
	
		}
	}
	private class ProvisioningInfoTable extends Element
	{
		public ProvisioningInfoTable()
		{
			setElement(readAppData(this));
		}
	}
	
	private class ProvisioningInfoRowFinder extends Element
	{
		public String []info;
		public ProvisioningInfoRowFinder()
		{
			info = readAppData(this);
		}
	}
	
	public ProvisioningInfoRow[] getItemRows(Browser browser)
	{
		try
		{
			browser.setWait(1);
			ProvisioningInfoTable table = new ProvisioningInfoTable();
			ProvisioningInfoRowFinder provisioningInfoRowFinder = new ProvisioningInfoRowFinder();
			ElementSet set = new ElementSet();
			Element elements[] = set.getSubElementSet(table, provisioningInfoRowFinder.info[0], provisioningInfoRowFinder.info[1]);
			ProvisioningInfoRow []rows = new ProvisioningInfoRow[elements.length-1];
			for(int i=0;i<rows.length; i++)
			{
				rows[i] = new ProvisioningInfoRow(elements[i+1]);
			}
			return rows;
		}
		finally
		{
			browser.setDefaultWait();
		}
	}
}
