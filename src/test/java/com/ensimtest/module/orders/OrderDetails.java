package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class OrderDetails extends AppData
{
	public class OrderInfo extends Element
	{
		public String orderId, subscriptionId, provisioningSystemId, orgName, orgID, agentName, salesRepresentative, OrgAcName, creationDate, status;
		
		private String []data = null;
		
		private String getValue(String attribute)
		{
			for(int i=0; i<data.length; i++)
			{
				if(data[i].startsWith(attribute))
				{
					return data[i].substring(data[i].indexOf(":")+1).trim();
				}
			}
			return null;
		}
		
		public OrderInfo()
		{
			setElement(readAppData(this));
			String str = super.read();
			data = str.split("\n");
			
			//if(data[0].startsWith(prefix))
			
			orderId = getValue("Order ID");
			subscriptionId = getValue("Subscription ID");
			provisioningSystemId = getValue("Provisioning System ID");
			String orgInfo = getValue("Organization Name");
			
			orgName = orgInfo.substring(0, orgInfo.indexOf(' ')).trim();
			orgID = orgInfo.split(":")[1].replace(")", "").trim();
			
			agentName = getValue("Agent name");
			//salesRepresentative = data[5].substring(data[5].indexOf(":")+1).trim();
			OrgAcName = getValue("Organization account name");
			creationDate = getValue("Creation Date");
			status = getValue("Status");
		}
	}
	public OrderInfo orderInfo = new OrderInfo();
	
	private class OrderInfoCustomField extends Element
	{
		public OrderInfoCustomField()
		{
			setElement("Xpath", "//[@id=\"tblCustomFldData\"]/tbody/tr[1]/td[3]");
		}
	}
	
	public String[] getCustomFields()
	{
		OrderInfoCustomField orderInfoCustomField = new OrderInfoCustomField();
		System.out.println(" << " + orderInfoCustomField.read());
		return null;
	}
}
