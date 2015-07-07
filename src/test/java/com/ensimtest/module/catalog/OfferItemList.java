package com.ensimtest.module.catalog;

import com.ensimtest.config.Browser;
import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

/**
 * To get the list of Item Added in offer
 * @author Dip
 *
 */
public class OfferItemList extends AppData{

	public class ItemListRow
	{
		public String itemName, pricePlanName;
		public Element rankTxt, itemNameTxt, itemNameEditLnk, nameEditSaveIcon, nameEditCancelIcon, itemNameMultiLangLnk, exclusiveChk,
		billableChk, ppuLimitTxt, purchasseOptionLst, viewDetailsLnk, trialQuantityChk, trialQuantityTxt,
		pricingTxt, priceEditLnk, lockItemLnk, unLockItem, removeItemLnk;
		ElementSet set = new ElementSet();
		

		public ItemListRow(Element element)
		{

			// Item display rank
			rankTxt = set.getSubElementSet(element, "Xpath", "div[1]//div//div//input")[0];
			//System.out.println(rankTxt);

			// Item Name
			itemNameTxt = set.getSubElementSet(element, "Xpath", "div[2]//div//div//input")[0];
			itemName = itemNameTxt.getAttributeValue("value");
			//System.out.println(itemName);
			
			// Item Name Edit icon
			itemNameEditLnk = set.getSubElementSet(element, "Xpath", "div[3]//a")[0];
			//System.out.println(itemNameEditLnk);
			
			//Item Name Edit Save Icon
			nameEditSaveIcon = set.getSubElementSet(element, "Xpath", "div[3]//div[contains(@id,'_edit_item_name_confirm')]//a")[0];
			//System.out.println(nameEditSaveIcon);
			
			//Item Name Edit Cancel Icon
			nameEditCancelIcon = set.getSubElementSet(element, "Xpath", "div[3]//div[contains(@id,'_edit_item_name_cancel')]//a")[0];
			System.out.println(nameEditCancelIcon);
			
			// Item Name multi-lang icon 
			itemNameMultiLangLnk = set.getSubElementSet(element, "Xpath", "div[3]//div[contains(@id,'_edit_item_multilang')]//a")[0];
			//System.out.println(itemNameMultiLangLnk);
			
			// Exclusive Item Check 
			exclusiveChk = set.getSubElementSet(element, "Xpath", "div[4]//input")[0];
			//System.out.println(exclusiveChk);
			
			// Billable Item Check 
			billableChk = set.getSubElementSet(element, "Xpath", "div[5]//input")[0];
			//System.out.println(billableChk);
			
			//PPU max limit
			ppuLimitTxt = set.getSubElementSet(element, "Xpath", "div[6]//input")[0];
			//System.out.println(ppuLimitTxt);
			
			//Purchase option
			purchasseOptionLst = set.getSubElementSet(element, "Xpath", "div[7]//div//div//select")[0];
			//System.out.println(purchasseOptionLst);
			
			//View details for Custom Purchase option
			viewDetailsLnk = set.getSubElementSet(element, "Xpath", "div[7]//a")[0];
			//System.out.println(viewDetailsLnk);
			
			//Trail Quantity check box
			trialQuantityChk = set.getSubElementSet(element, "Xpath", "div[8]//input[contains(@id,'availablefortrial')]")[0];
			//System.out.println(trialQuantityChk);
			
			//Trail Quantity Text box
			trialQuantityTxt = set.getSubElementSet(element, "Xpath", "div[8]//input[contains(@id,'trialquantity')]")[0];
			//System.out.println(trialQuantityTxt);
			
			//Item Price box
			pricingTxt = set.getSubElementSet(element, "Xpath", "div[9]//div//div//input")[0];
			pricePlanName = pricingTxt.getAttributeValue("Value");
			//System.out.println(pricePlanName);
			
			//Item Price edit link
			priceEditLnk = set.getSubElementSet(element, "Xpath", "div[9]//div//div//a")[0];
			//System.out.println(priceEditLnk);
			
			//Item edit lock
			lockItemLnk = set.getSubElementSet(element, "Xpath", "div[10]//a")[0];
			//System.out.println(lockItemLnk);
			
			//Item remove lock
			unLockItem = set.getSubElementSet(element, "Xpath", "div[11]//a")[0];
			//System.out.println(unLockItem);
			
			//Item remove link
			removeItemLnk = set.getSubElementSet(element, "Xpath", "div[12]//div//div//a")[0];
			//System.out.println(removeItemLnk);
		}
	}
	private class ItemListTable extends Element
	{
		public ItemListTable()
		{
			setElement(readAppData(this));
		}
	}

	private class ItemListRowFinder extends Element
	{
		public String []info;
		public ItemListRowFinder()
		{
			info = readAppData(this);
		}
	}

	public ItemListRow[] getItemRows(Browser browser)
	{
		try
		{
			browser.setWait(1);
			ItemListTable table = new ItemListTable();
			//System.out.println(table.read());
			ItemListRowFinder itemListRowFinder = new ItemListRowFinder();
			ElementSet set = new ElementSet();
			Element elements[] = set.getSubElementSet(table, itemListRowFinder.info[0], itemListRowFinder.info[1]);
			//System.out.println(elements.length);
			ItemListRow []rows = new ItemListRow[elements.length];
			for(int i=0;i<rows.length; i++)
			{
				//System.out.println("Row no:- "+i);
				rows[i] = new ItemListRow(elements[i]);
			}
			return rows;
		}
		finally
		{
			browser.setDefaultWait();
		}
	}
}

