package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class OrderDetails extends AppData
{
	public class OrderInfo extends Element
	{
		public String orderId, subscriptionId, provisioningSystemId, orgName, orgID, agentName, salesRepresentative, OrgAcName, creationDate, status;
		
		public OrderInfo()
		{
			setElement(readAppData(this));
			String str = super.read();
			String []data = str.split("\n");
			orderId = data[0].substring(data[0].indexOf(":")+1).trim();
			subscriptionId = data[1].substring(data[1].indexOf(":")+1).trim();
			provisioningSystemId = data[2].substring(data[2].indexOf(":")+1).trim();
			
			String orgInfo = data[3].substring(data[3].indexOf(":")+1).trim();
			
			orgName = orgInfo.substring(0, orgInfo.indexOf(' ')).trim();
			orgID = orgInfo.split(":")[1].replace(")", "").trim();
			agentName = data[4].substring(data[4].indexOf(":")+1).trim();
			salesRepresentative = data[5].substring(data[5].indexOf(":")+1).trim();
			OrgAcName = data[6].substring(data[6].indexOf(":")+1).trim();
			creationDate = data[7].substring(data[7].indexOf(":")+1).trim();
			status = data[8].substring(data[8].indexOf(":")+1).trim();
		}
	}
	public OrderInfo orderInfo = new OrderInfo();
	
	
}
