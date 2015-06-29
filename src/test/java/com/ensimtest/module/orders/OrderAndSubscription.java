package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class OrderAndSubscription extends AppData
{
	
	public class SubsribedOrderDetails
	{
		public String offerName;
		public Element actionButton,historyButton;
		public SubsribedOrderDetails(Element e)
		{
			actionButton=null;
			historyButton=null;
			ElementSet elementSet=new ElementSet();
			offerName=elementSet.getSubElement(e, "Xpath","div[@class='black_background']//div//div[@class='white_font']").read();
			Element buttonLst[]=elementSet.getSubElementSet(e, "Xpath", "div[@class='black_background']//div[@class='black-button-shade']");
			for(int i=0;i<buttonLst.length;i++)
			{
				if(buttonLst[i].read().trim().contains("Actions"))
				{
					actionButton=buttonLst[i];
				}
				if(buttonLst[i].read().trim().contains("History"))
				{
					historyButton=buttonLst[i];
				}
				
			}
		}
		
		
	}
	
	

	public class OrderList extends Element
	{
		private String info[];

		public OrderList()
		{
			this.info=readAppData(this);
		}
		
		public SubsribedOrderDetails[] getOrders()
		{
			ElementSet elementSet=new ElementSet();
			Element elementLst[]=elementSet.getElementSet(this.info[0], this.info[1]);
			System.out.println("No of order is :-" +elementLst.length);
			SubsribedOrderDetails subscribedOrderDetails[]=new SubsribedOrderDetails[elementLst.length];
			for(int i=0;i<elementLst.length;i++)
			{
				subscribedOrderDetails[i]=new SubsribedOrderDetails(elementLst[i]);
			}
			return subscribedOrderDetails;
		}
		
	}
	public OrderList orderList=new OrderList();
}
