package com.ensimtest.module.catalog;

import com.ensimtest.config.Browser;
import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

/**
 * To select currencies for an offer
 * @author Dip
 *
 */
public class SelectCurrenciesForOffer extends AppData{
	
	/*
	 * select more than one currency
	 */
	public class SelectCurrencyRow
	{
		public String currencyName;
		public Element currencyChk;
		ElementSet set = new ElementSet();
		

		public SelectCurrencyRow(Element element)
		{

			// Currency Check box
			currencyChk = set.getSubElementSet(element, "Xpath", "td[1]//input")[0];
			//System.out.println(currencyChk);
			
			// Currency Name
			currencyName = set.getSubElement(element, "Xpath", "td[2]").read().trim();
			//System.out.println(currencyName);
			int lastIndexOfCurrencyName = currencyName.lastIndexOf("(");
			currencyName = currencyName.substring(0, lastIndexOfCurrencyName);
			//System.out.println(currencyName);
			
		}
	}
	private class CurrencyInfoTable extends Element
	{
		public CurrencyInfoTable()
		{
			setElement(readAppData(this));
		}
	}

	private class CurrencyRowFinder extends Element
	{
		public String []info;
		public CurrencyRowFinder()
		{
			info = readAppData(this);
		}
	}

	public SelectCurrencyRow[] getCurrenciesRows(Browser browser)
	{
		try
		{
			browser.setWait(1);
			CurrencyInfoTable table = new CurrencyInfoTable();
			//System.out.println(table.read());
			CurrencyRowFinder currencyRowFinder = new CurrencyRowFinder();
			ElementSet set = new ElementSet();
			Element elements[] = set.getSubElementSet(table, currencyRowFinder.info[0], currencyRowFinder.info[1]);
			//System.out.println(elements.length);
			SelectCurrencyRow []rows = new SelectCurrencyRow[elements.length];
			for(int i=0;i<rows.length; i++)
			{
				//System.out.println("Row no:- "+i);
				rows[i] = new SelectCurrencyRow(elements[i]);
			}
			return rows;
		}
		finally
		{
			browser.setDefaultWait();
		}
	}
	
	/*
	 * click on OK button
	 */
	public class OkButtonToSaveCurrency extends Element{
		public OkButtonToSaveCurrency(){
			setElement(readAppData(this));
		}
	}
	
	public OkButtonToSaveCurrency okButtonToSaveCurrency = new OkButtonToSaveCurrency();
	/*
	 * click on Cancel button
	 */
	public class CancelButtonToDiscardCurrencyChanges extends Element{
		public CancelButtonToDiscardCurrencyChanges(){
			setElement(readAppData(this));
		}
	}
	
	public CancelButtonToDiscardCurrencyChanges cancelButtonToDiscardCurrencyChanges = new CancelButtonToDiscardCurrencyChanges();

}
