package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class OrderList extends AppData
{
	private class RowInfo
	{
		public String []info;
		public RowInfo()
		{
			info = readAppData(this);
		}
	}
	
	private class RecentTab
	{
		public String []info;
		public RecentTab()
		{
			info = readAppData(this);
		}
	}
	
	private class FailedTab
	{
		public String []info;
		public FailedTab()
		{
			info = readAppData(this);
		}
	}
	
	private class PendingTab
	{
		public String []info;
		public PendingTab()
		{
			info = readAppData(this);
		}
	}
	
	private class CancelledTab
	{
		public String []info;
		public CancelledTab()
		{
			info = readAppData(this);
		}
	}
	
	protected class CommonResultRows extends Element
	{
		public CommonResultRows(String []info)
		{
			setElement(info);
		}
		public Element[] getResultRow(String childType, String childValue)
		{
			System.out.println(childType + " : " + childValue);
			ElementSet set = new ElementSet();
			Element []elements = set.getSubElementSet(super.getElement(), childType, childValue);
			return elements;
		}
	}
	
	public class OrderRow
	{
		public Element link;
		public String orderID, orgID, orderState, offerName;
		
		public OrderRow(Element link)
		{
			this.link = link;
			String []data = link.read().trim().split("\n");
			data[0] = data[0].replaceAll("ID", "");
			data[0] = data[0].replaceAll("Organization", "");
			data[0] = data[0].replaceAll(" ", "");
			String []firstRow = data[0].split(":");
			orderID = firstRow[1].trim();
			orgID = firstRow[2].trim();
			orderState = data[1].trim();
			offerName = data[3].replaceAll("Offer : ", "").trim();
		}
	}
	
	public OrderRow[] getOrderResultRows(String tabname)
	{
		
		String []info = null;
		switch(tabname.trim().toLowerCase())
		{
		case "recent" :
			RecentTab tab1 = new RecentTab();
			info = tab1.info;
			break;
		case "failed" :
			FailedTab tab2 = new FailedTab();
			info = tab2.info;
			break;
		case "pending" :
			PendingTab tab3 = new PendingTab();
			info = tab3.info;
			break;
		case "cancelled" :
			CancelledTab tab4 = new CancelledTab();
			info = tab4.info;
			break;
		}
		CommonResultRows resultRows = new CommonResultRows(info);
		
		System.out.println("CommonResultRows : "  + info[0] + info[1]);
		
		RowInfo rowInfo = new RowInfo();
		Element[] elements = resultRows.getResultRow(rowInfo.info[0], rowInfo.info[1]);

		System.out.println("Row " + elements);
		OrderRow []row = new OrderRow[elements.length];
		for(int i=0; i<elements.length; i++)
		{
			row[i] = new OrderRow(elements[i]);
		}
		return row;
	}
}
