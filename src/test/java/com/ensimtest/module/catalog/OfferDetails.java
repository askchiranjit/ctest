package com.ensimtest.module.catalog;

import com.ensimtest.config.Browser;
import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

/**
 * All controls of offer details page
 * @author Dip
 *
 */
public class OfferDetails extends AppData{

	/*
	 * Offer details information
	 */
	public class OfferDetailsInfo {
		
		public String guidLbl, guidValue, subscriptionPeriodLbl, subscriptionPeriodValue, serviceNameLbl, serviceNameValue,
		catalogIDLbl, catalogIDValue, tariffCodeLbl, tariffCodeValue, availabilityLbl, availabilityValue,
		provWorkFlowLbl, provWorkFlowValue, approvalWorkFlowLbl, approvalWorkFlowValue;
		
		ElementSet set = new ElementSet();
		
		public OfferDetailsInfo(Element element)
		{

			//offer GUID
			guidLbl = set.getSubElement(element, "Xpath", "td[1]").read().trim();
			System.out.println(guidLbl);
			guidValue = set.getSubElement(element, "Xpath", "t2[2]").read().trim();
			System.out.println(guidValue);
			
			//Subscription Period
			subscriptionPeriodLbl = set.getSubElement(element, "Xpath", "td[1]").read().trim();
			System.out.println(subscriptionPeriodLbl);
			subscriptionPeriodValue = set.getSubElement(element, "Xpath", "td[2]").read().trim();
			System.out.println(subscriptionPeriodValue);
			
			//Service Name
			serviceNameLbl = set.getSubElement(element, "Xpath", "td[1]").read().trim();
			System.out.println(serviceNameLbl);
			serviceNameValue = set.getSubElement(element, "Xpath", "td[2]").read().trim();
			System.out.println(serviceNameValue);
			
			//Catalog ID
			catalogIDLbl = set.getSubElement(element, "Xpath", "td[1]").read().trim();
			System.out.println(catalogIDLbl);
			catalogIDValue = set.getSubElement(element, "Xpath", "td[2]").read().trim();
			System.out.println(catalogIDValue);
			
			//Tariff Code
			tariffCodeLbl = set.getSubElement(element, "Xpath", "td[1]").read().trim();
			System.out.println(tariffCodeLbl);
			tariffCodeValue = set.getSubElement(element, "Xpath", "td[2]").read().trim();
			System.out.println(tariffCodeValue);
			
			//Availability
			availabilityLbl = set.getSubElement(element, "Xpath", "td[1]").read().trim();
			System.out.println(availabilityLbl);
			availabilityValue = set.getSubElement(element, "Xpath", "td[2]").read().trim();
			System.out.println(availabilityValue);
			
			//Provisioning Work-Flow
			provWorkFlowLbl = set.getSubElement(element, "Xpath", "td[1]").read().trim();
			System.out.println(provWorkFlowLbl);
			provWorkFlowValue = set.getSubElement(element, "Xpath", "td[2]").read().trim();
			System.out.println(provWorkFlowValue);
			
			//Approval Work-Flow
			approvalWorkFlowLbl = set.getSubElement(element, "Xpath", "td[1]").read().trim();
			System.out.println(approvalWorkFlowLbl);
			approvalWorkFlowValue = set.getSubElement(element, "Xpath", "td[2]").read().trim();
			System.out.println(approvalWorkFlowValue);
		}
	}
	private class OfferDetailsTable extends Element
	{
		public OfferDetailsTable()
		{
			setElement(readAppData(this));
		}
	}
	
	private class OfferDetailsRowFinder extends Element
	{
		public String []info;
		public OfferDetailsRowFinder()
		{
			info = readAppData(this);
		}
	}
	
	public OfferDetailsInfo[] getOfferDeatilsRow(Browser browser)
	{
		try
		{
			browser.setWait(1);
			OfferDetailsTable table = new OfferDetailsTable();
			System.out.println(table.read());
			OfferDetailsRowFinder offerDetailsRowFinder = new OfferDetailsRowFinder();
			ElementSet set = new ElementSet();
			Element elements[] = set.getSubElementSet(table, offerDetailsRowFinder.info[0], offerDetailsRowFinder.info[1]);
			System.out.println(elements.length);
			OfferDetailsInfo []rows = new OfferDetailsInfo[elements.length];
			for(int i=0;i<rows.length; i++)
			{
				System.out.println("Row no:- "+i);
				rows[i] = new OfferDetailsInfo(elements[i]);
			}
			return rows;
		}
		finally
		{
			browser.setDefaultWait();
		}
	}
//----------------------------END of offer details part-----------------------------------------------------
	
	//Promotion details link
	public class PromoDetailsLnk extends Element{
		public PromoDetailsLnk(){
			setElement(readAppData(this));
		}
	}
	
	public PromoDetailsLnk promoDetailsLnk = new PromoDetailsLnk();
	
	//Delete button
	public class DeleteOfferBtn extends Element{
		public DeleteOfferBtn(){
			setElement(readAppData(this));
		}
	}
	
	public DeleteOfferBtn deleteOfferBtn = new DeleteOfferBtn();
	
	//Deactivate button
	public class DeactivateOfferBtn extends Element{
		public DeactivateOfferBtn(){
			setElement(readAppData(this));
		}
	}
	
	public DeactivateOfferBtn deactivateOfferBtn = new DeactivateOfferBtn();
	
	//Edit button
	public class EditOfferBtn extends Element{
		public EditOfferBtn(){
			setElement(readAppData(this));
		}
	}
	
	public EditOfferBtn editOfferBtn = new EditOfferBtn();
	
	//Copy button
	public class CopyOfferBtn extends Element{
		public CopyOfferBtn(){
			setElement(readAppData(this));
		}
	}
	
	public CopyOfferBtn copyOfferBtn = new CopyOfferBtn();
	
	//Manage Version
	public class ManageVersionBtn extends Element{
		public ManageVersionBtn(){
			setElement(readAppData(this));
		}
	}
	
	public ManageVersionBtn manageVersionBtn = new ManageVersionBtn();
	
	//Export button
	public class ExportOfferBtn extends Element{
		public ExportOfferBtn(){
			setElement(readAppData(this));
		}
	}
	
	public ExportOfferBtn exportOfferBtn = new ExportOfferBtn();
	
	//Publish button
	public class PublishOfferBtn extends Element{
		public PublishOfferBtn(){
			setElement(readAppData(this));
		}
	}
	
	public PublishOfferBtn publishOfferBtn = new PublishOfferBtn();
	
	//Edit Reseller Discount Button
	public class EditResellerDiscountBtn extends Element{
		public EditResellerDiscountBtn(){
			setElement(readAppData(this));
		}
	}
	
	public EditResellerDiscountBtn editResellerDiscountBtn = new EditResellerDiscountBtn();
	
	//Deactivate All Copies Button
	public class DeactivateAllCopiesBtn extends Element{
		public DeactivateAllCopiesBtn(){
			setElement(readAppData(this));
		}
	}
	
	public DeactivateAllCopiesBtn deactivateAllCopiesBtn = new DeactivateAllCopiesBtn();
	
	//Activate button
	public class ActivateBtn extends Element{
		public ActivateBtn(){
			setElement(readAppData(this));
		}
	}
	
	public ActivateBtn activateBtn = new ActivateBtn();
	

//-------------------------------Start of Item details section of offer details page-------------------------------
	
	public class OfferItemDetailsInfo{
		
		public String rankLbl, itemName, itemType, pricingTxt;
		public Element rankTxt, pricingLnk;
		
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
		public OfferItemDetailsInfo(Element element)
		{
			
			// Checking for rank text box
			rankTxt = setElement(set.getSubElementSet(element, "Xpath", "td[1]"));
			System.out.println(rankTxt);
			
			//Checking for rank of Item
			rankLbl = setElement(set.getSubElementSet(element, "Xpath", "td[1]")).read().trim();
			System.out.println(rankLbl);
			
			//Item Name
			itemName = set.getSubElement(element, "Xpath", "td[2]").read().toString();
			System.out.println(itemName);
			
			//Item Type
			itemType = set.getSubElement(element, "Xpath", "td[3]").read().trim();
			System.out.println(itemType);
			
			//item Price
			pricingLnk = set.getSubElementSet(element, "Xpath", "td[4]//a")[0];
			pricingTxt = pricingLnk.read().toString();
			System.out.println(pricingLnk);
			System.out.println(pricingTxt);
			
		}
	}
	private class OfferItemDetailsTable extends Element
	{
		public OfferItemDetailsTable()
		{
			setElement(readAppData(this));
		}
	}
	
	private class OfferItemDetailsRowFinder extends Element
	{
		public String []info;
		public OfferItemDetailsRowFinder()
		{
			info = readAppData(this);
		}
	}
	
	public OfferItemDetailsInfo[] getOfferItemDetailsRows(Browser browser)
	{
		try
		{
			browser.setWait(1);
			OfferItemDetailsTable table = new OfferItemDetailsTable();
			System.out.println(table.read());
			OfferItemDetailsRowFinder offerItemDetailsRowFinder = new OfferItemDetailsRowFinder();
			ElementSet set = new ElementSet();
			Element elements[] = set.getSubElementSet(table, offerItemDetailsRowFinder.info[0], offerItemDetailsRowFinder.info[1]);
			System.out.println(elements.length);
			OfferItemDetailsInfo []rows = new OfferItemDetailsInfo[elements.length];
			for(int i=0;i<rows.length; i++)
			{
				System.out.println("Row no:- "+i);
				rows[i] = new OfferItemDetailsInfo(elements[i]);
			}
			return rows;
		}
		finally
		{
			browser.setDefaultWait();
		}

	}
//---------------------------END of Offer Item details part------------------------------------------------
}
