package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class CreateOrderProvisioningInfo extends AppData
{
	public class PurchaseOrderNumberTxt extends Element
	{
		public PurchaseOrderNumberTxt()
		{
			setElement("ID", "purchaseOrdNo");
		}
	}
	public PurchaseOrderNumberTxt purchaseOrderNumberTxt = new PurchaseOrderNumberTxt();
	
	//purchaseOrdNo
	
	private class CustomTable extends Element
	{
		public CustomTable()
		{
			setElement("ID", "purchaseOrdNo");
		}
	}
	
	public class CustomInfo
	{
		public String label = null;
		public Element elemenet;
		
		public CustomInfo(Element element)
		{
			ElementSet set = new ElementSet();
			Element []list = set.getSubElementSet(element, "Xpath", "td");
			
			System.out.println("Length : " + list.length);
			
			if(list.length > 1)
			{
				label = list[0].read();
				System.out.println(label);
				this.elemenet = list[1];
			}
		}
	}
	
	public CustomInfo[] getCustomFields()
	{
		CustomTable custTable = new CustomTable();
		ElementSet set = new ElementSet();
		Element []elements = set.getSubElementSet(custTable, "Xpath", "//*[@id=\"copy_width_from\"]/tbody/tr");
		System.out.println("Element length : " + elements.length);
		CustomInfo []custFields = new CustomInfo[elements.length];
		for(int i=0; i<custFields.length; i++)
		{
			custFields[i] = new CustomInfo(elements[i]);
		}
		return custFields;
	}
}
