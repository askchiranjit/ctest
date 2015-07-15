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
	
//	public class OrderDetailsButtons extends Element
//	{
//		public Element edit, approve, submitForApproval, abort, cancel, viewHistory,
//		suspend, resume, discardDraft, configure, upgrade, downgrade, upsize, downsize,
//		retry, rectifyFailure;
//		
//		public OrderDetailsButtons()
//		{
//			setElement(readAppData(this));
//			
//			ElementSet set = new ElementSet();
//			edit = set.getSubElement(this, "ID", "edit");
//			approve = set.getSubElement(this, "ID", "approved");
//			submitForApproval = set.getSubElement(this, "ID", "seekapproval");
//			abort = set.getSubElement(this, "ID", "abort");
//			cancel = set.getSubElement(this, "ID", "cancel");
//			viewHistory = set.getSubElement(this, "ID", "orderhistory");
//			suspend = set.getSubElement(this, "ID", "suspend");
//			resume = set.getSubElement(this, "ID", "resume");
//			discardDraft = set.getSubElement(this, "ID", "undo");
//			System.out.println("Inside");
//			configure = set.getSubElement(this, "Xpath", "//input[@type='button' and @id='configure'] | //input[@type='button' and @id='logintocontrolpanel']");
//			System.out.println("Outside");
//			upgrade = set.getSubElement(this, "ID", "upgrade");
//			downgrade = set.getSubElement(this, "ID", "downgrade");
//			upsize = set.getSubElement(this, "ID", "upsize");
//			downsize = set.getSubElement(this, "ID", "downsize");
//			retry = set.getSubElement(this, "ID", "retry");
//			rectifyFailure = set.getSubElement(this, "ID", "undonew");
//		}
//	}
//	public OrderDetailsButtons buttons = new OrderDetailsButtons();
	
	public class ViewNotification extends Element
	{
		public ViewNotification()
		{
			setElement(readAppData(this));
		}
	}
	public ViewNotification viewNotification = new ViewNotification();

	public class GenerateQuote extends Element
	{
		public GenerateQuote()
		{
			setElement(readAppData(this));
		}
	}
	public GenerateQuote generateQuote = new GenerateQuote();

	public class ManageInstallments extends Element
	{
		public ManageInstallments()
		{
			setElement(readAppData(this));
		}
	}
	public ManageInstallments manageInstallments = new ManageInstallments();

	public class ConfirmOrderFulfillment extends Element
	{
		public ConfirmOrderFulfillment()
		{
			setElement(readAppData(this));
		}
	}
	public ConfirmOrderFulfillment confirmOrderFulfillment = new ConfirmOrderFulfillment();

	public class InitiateBilling extends Element
	{
		public InitiateBilling()
		{
			setElement(readAppData(this));
		}
	}
	public InitiateBilling initiateBilling = new InitiateBilling();

	public class ManageRenewal extends Element
	{
		public ManageRenewal()
		{
			setElement(readAppData(this));
		}
	}
	public ManageRenewal manageRenewal = new ManageRenewal();

	public class AdjustOrderData extends Element
	{
		public AdjustOrderData()
		{
			setElement(readAppData(this));
		}
	}
	public AdjustOrderData adjustOrderData = new AdjustOrderData();
}
