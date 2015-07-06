package com.ensimtest.module.catalog;

import com.ensimtest.config.Browser;
import com.ensimtest.config.Element;
import com.ensimtest.config.ElementHandler;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;
import com.ensimtest.utils.TestUtils;

/**
 * To get the list of Provisioning Information of offer
 * @author Dip
 *
 */
public class OfferProvisioningInformationLst extends AppData{
	
	public class ProvisioningInfoRow
	{
		public String resourceName, resourceID, mandatory;
		public Element rankTxt, visibilityInOrderLst, defaultTxt, defaultChk, exportChk;
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
		
				
		public ProvisioningInfoRow(Element element)
		{
			
			// Checking for checkedMark
			rankTxt = set.getSubElementSet(element, "Xpath", "td[1]//input")[0];
			//System.out.println(rankTxt);
			
			//Resource Name
			resourceName = set.getSubElement(element, "Xpath", "td[2]").read().trim();
			//System.out.println(resourceName);
			
			//Resource ID
			resourceID = set.getSubElement(element, "Xpath", "td[3]").read().trim();
			//System.out.println(resourceID);
			
			//is mandatory or not
			mandatory = set.getSubElement(element, "Xpath", "td[4]").read().trim();
			//System.out.println(mandatory);
			
			// Checking for List-box
			visibilityInOrderLst  = set.getSubElementSet(element, "Xpath", "td[5]//select")[0];
			//System.out.println(visibilityInOrderLst);
			
			// Checking for Text-Box
			defaultTxt = setElement(set.getSubElementSet(element, "Xpath", "td[6]//input"));
			//System.out.println(defaultTxt);
			
			// Checking for Check-Box
			defaultChk = setElement(set.getSubElementSet(element, "Xpath", "td[6]//input"));
			//System.out.println(defaultChk);
			
			// Checking for Check-Box
			exportChk = set.getSubElementSet(element, "Xpath", "td[7]//input")[0];
			//System.out.println(exportChk);
			
			
			try{
				ElementHandler elementHandler=new ElementHandler();
				String scrlXpath = "(//div[contains(@class,'slimScrollBar ui-draggable')])[2]";
				elementHandler.scrollDown(scrlXpath);
			}catch(Exception e){
				System.out.println(e);
			}
			
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
	
	public ProvisioningInfoRow[] getProvisioningInfoRows(Browser browser)
	{
		try
		{
			browser.setWait(1);
			ProvisioningInfoTable table = new ProvisioningInfoTable();
			//System.out.println(table.read());
			ProvisioningInfoRowFinder provisioningInfoRowFinder = new ProvisioningInfoRowFinder();
			ElementSet set = new ElementSet();
			Element elements[] = set.getSubElementSet(table, provisioningInfoRowFinder.info[0], provisioningInfoRowFinder.info[1]);
			//System.out.println(elements.length);
			ProvisioningInfoRow []rows = new ProvisioningInfoRow[elements.length];
			for(int i=0;i<rows.length; i++)
			{
				//System.out.println("Row no:- "+i);
				rows[i] = new ProvisioningInfoRow(elements[i]);
			}
			try{
				ElementHandler elementHandler=new ElementHandler();
				String scrlXpath = "(//div[contains(@class,'slimScrollBar ui-draggable')])[2]";
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
	
	/**
	 * To Provide values in Provisioning Informations
	 * @param provisioningInfoList
	 * @param defaultValueList
	 * @param br
	 */
	public void writeProvisioningInfo(String[] provisioningInfoList, String[] defaultValueList, Browser br){
		ProvisioningInfoRow []provInfoRow = getProvisioningInfoRows(br);
		TestUtils.delay(20000);
		ElementHandler elementHandler=new ElementHandler();
		
        for(int i=0; i<provisioningInfoList.length; i++){  //user input Provisioning Information read
			
			for(int j=0; j<provInfoRow.length; j++){ //element rows
				
				if(provInfoRow[j].resourceName.equalsIgnoreCase(provisioningInfoList[i])){
					provInfoRow[j].defaultTxt.write(defaultValueList[i]);
					try{
						String scrlXpath = "(//div[contains(@class,'slimScrollBar ui-draggable')])[2]";
						elementHandler.scrollUp(scrlXpath);;
					}catch(Exception e){
						System.out.println(e);
					}
					break;
				}
				
				try{
					String scrlXpath = "(//div[contains(@class,'slimScrollBar ui-draggable')])[2]";
					elementHandler.scrollDown(scrlXpath);
				}catch(Exception e){
					System.out.println(e);
				}
			}
		}
	}
}
