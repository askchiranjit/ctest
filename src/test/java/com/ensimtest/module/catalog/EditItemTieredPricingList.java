package com.ensimtest.module.catalog;

import com.ensimtest.config.Browser;
import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;
import com.ensimtest.utils.TestUtils;

/**
 * To find out the list of tired price and also add tired price
 * @author Dip
 *
 */
public class EditItemTieredPricingList extends AppData{
	
	public class TieredItemPriceInfoRow extends Element
	{
		public String billingName, rangeMin, rangeMax, unitPrice, minDisocunt, maxDisocunt;
		public Element billingNameTxt, rangeMinTxt, rangeMaxTxt, unitPriceTxt, minDisocuntTxt, maxDisocuntTxt, removeBtn, addBtn;
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
		
		public TieredItemPriceInfoRow(Element element)
		{
			
			// Checking for billingNameTxt
			billingNameTxt = set.getSubElementSet(element, "Xpath", "td[2]//input")[0];
			billingName = billingNameTxt.getAttributeValue("value");
			System.out.println(billingName);
			
			// Checking for rangeMinTxt
			rangeMinTxt = setElement(set.getSubElementSet(element, "Xpath", "td[3]//input[contains(@id,'min')]"));
			rangeMin = rangeMinTxt.getAttributeValue("value");
			System.out.println(rangeMin);
			
			// Checking for rangeMaxTxt
			rangeMaxTxt = setElement(set.getSubElementSet(element, "Xpath", "td[4]//input[contains(@id,'max')]"));
			rangeMax = rangeMaxTxt.getAttributeValue("value");
			System.out.println(rangeMax);
			
			// Checking for unitPriceTxt
			unitPriceTxt = set.getSubElementSet(element, "Xpath", "td[5]//input[contains(@id,'baserate')]")[0];
			unitPrice = unitPriceTxt.getAttributeValue("value");
			System.out.println(unitPrice);
			
			// Checking for minDisocuntTxt
			minDisocuntTxt = set.getSubElementSet(element, "Xpath", "td[6]//input[contains(@id,'minDiscDB')]")[0];
			minDisocunt = minDisocuntTxt.getAttributeValue("value");
			System.out.println(minDisocunt);
			
			// Checking for minDisocuntTxt
			maxDisocuntTxt = set.getSubElementSet(element, "Xpath", "td[8]//input[contains(@id,'maxDiscDB')]")[0];
			maxDisocunt = maxDisocuntTxt.getAttributeValue("value");
			System.out.println(maxDisocunt);
			
			// Checking for removeBtn
			removeBtn = set.getSubElementSet(element, "Xpath", "td[1]//input")[0];
			System.out.println(removeBtn);
			
			// Checking for addBtn
			addBtn = set.getSubElementSet(element, "Xpath", "td[1]//input")[0];
			System.out.println(addBtn);
		}
	}
	private class TieredItemPriceTable extends Element
	{
		public TieredItemPriceTable()
		{
			setElement(readAppData(this));
		}
	}
	
	private class TieredItemPriceInfoRowFinder extends Element
	{
		public String []info;
		public TieredItemPriceInfoRowFinder()
		{
			info = readAppData(this);
		}
	}
	
	public TieredItemPriceInfoRow[] getProvisioningInfoRows(Browser browser)
	{
		try
		{
			browser.setWait(1);
			TieredItemPriceTable table = new TieredItemPriceTable();
			System.out.println(table.read());
			TieredItemPriceInfoRowFinder tieredItemPriceInfoRowFinder = new TieredItemPriceInfoRowFinder();
			ElementSet set = new ElementSet();
			Element elements[] = set.getSubElementSet(table, tieredItemPriceInfoRowFinder.info[0], tieredItemPriceInfoRowFinder.info[1]);
			System.out.println(elements.length);
			TieredItemPriceInfoRow []rows = new TieredItemPriceInfoRow[elements.length];
			for(int i=0;i<rows.length; i++)
			{
				System.out.println("Row no:- "+i);
				rows[i] = new TieredItemPriceInfoRow(elements[i]);
			}
			
			return rows;
		}
		finally
		{
			browser.setDefaultWait();
		}
	}

	
	/**
	 * To edit value of tiered price where set as Ends with
	 * @param billingNameList
	 * @param minRangeList
	 * @param unitPriceList
	 * @param minDiscountList
	 * @param maxDiscountList
	 * @param br
	 */
	public void editTieredValueForStartsWith(String[] billingNameList, String[] minRangeList, String[] unitPriceList, String[] minDiscountList, String[] maxDiscountList, Browser br){
		TieredItemPriceInfoRow []tieredItemPriceInfoRow = getProvisioningInfoRows(br);
		TestUtils.delay(20000);
		
        for(int i=0; i<billingNameList.length; i++){  //user input billing name list read
			
			for(int j=0; j<tieredItemPriceInfoRow.length; j++){ //element rows
				
				if(tieredItemPriceInfoRow[j].billingName.equalsIgnoreCase(billingNameList[i])){
					
					//To check min range is provided or not if present then write that value
					if(!minRangeList[i].equals(" ")){
						tieredItemPriceInfoRow[j].rangeMinTxt.clearAllChars(tieredItemPriceInfoRow[j].rangeMinTxt.getAttributeValue("value").length());
						tieredItemPriceInfoRow[j].rangeMinTxt.write(minRangeList[i]);
					}
					
					//To check unit price is provided or not if present then write that value
					if(!unitPriceList[i].equals(" ")){
						tieredItemPriceInfoRow[j].unitPriceTxt.clearAllChars(tieredItemPriceInfoRow[j].unitPriceTxt.getAttributeValue("value").length());
						tieredItemPriceInfoRow[j].unitPriceTxt.write(unitPriceList[i]);
					}
					
					//To check min discount is provided or not if present then write that value
					if(!minDiscountList[i].equals(" ")){
						tieredItemPriceInfoRow[j].minDisocuntTxt.clearAllChars(tieredItemPriceInfoRow[j].minDisocuntTxt.getAttributeValue("value").length());
						tieredItemPriceInfoRow[j].minDisocuntTxt.write(minDiscountList[i]);
					}
					
					//To check max discount is provided or not if present then write that value
					if(!maxDiscountList[i].equals(" ")){
						tieredItemPriceInfoRow[j].maxDisocuntTxt.clearAllChars(tieredItemPriceInfoRow[j].maxDisocuntTxt.getAttributeValue("value").length());
						tieredItemPriceInfoRow[j].maxDisocuntTxt.write(maxDiscountList[i]);
					}
					break;
				}
			}
		}
	}
	
	/**
	 * To edit value of tiered price where set as Ends with
	 * @param billingNameList
	 * @param maxRangeList
	 * @param unitPriceList
	 * @param minDiscountList
	 * @param maxDiscountList
	 * @param br
	 */
	public void editTieredValueForEndsWith(String[] billingNameList, String[] maxRangeList, String[] unitPriceList, String[] minDiscountList, String[] maxDiscountList, Browser br){
		TieredItemPriceInfoRow []tieredItemPriceInfoRow = getProvisioningInfoRows(br);
		TestUtils.delay(20000);
		
        for(int i=0; i<billingNameList.length; i++){  //user input billing name list read
			
			for(int j=0; j<tieredItemPriceInfoRow.length; j++){ //element rows
				
				if(tieredItemPriceInfoRow[j].billingName.equalsIgnoreCase(billingNameList[i])){
					//To check max range is provided or not if present then write that value
					if(!maxDiscountList[i].equals(" ")){
						tieredItemPriceInfoRow[j].rangeMinTxt.clearAllChars(tieredItemPriceInfoRow[j].rangeMinTxt.getAttributeValue("value").length());
						tieredItemPriceInfoRow[j].rangeMinTxt.write(maxDiscountList[i]);
					}
					
					//To check unit price is provided or not if present then write that value
					if(!unitPriceList[i].equals(" ")){
						tieredItemPriceInfoRow[j].unitPriceTxt.clearAllChars(tieredItemPriceInfoRow[j].unitPriceTxt.getAttributeValue("value").length());
						tieredItemPriceInfoRow[j].unitPriceTxt.write(unitPriceList[i]);
					}
					
					//To check min discount is provided or not if present then write that value
					if(!minDiscountList[i].equals(" ")){
						tieredItemPriceInfoRow[j].minDisocuntTxt.clearAllChars(tieredItemPriceInfoRow[j].minDisocuntTxt.getAttributeValue("value").length());
						tieredItemPriceInfoRow[j].minDisocuntTxt.write(minDiscountList[i]);
					}
					
					//To check max discount is provided or not if present then write that value
					if(!maxDiscountList[i].equals(" ")){
						tieredItemPriceInfoRow[j].maxDisocuntTxt.clearAllChars(tieredItemPriceInfoRow[j].maxDisocuntTxt.getAttributeValue("value").length());
						tieredItemPriceInfoRow[j].maxDisocuntTxt.write(maxDiscountList[i]);
					}
					break;
				}
			}
		}
	}

}
