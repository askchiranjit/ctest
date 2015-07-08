package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class SelectOfferCustomer extends AppData
{
	public class OfferDetails
	{
		public String offerDescription,offerName;
		public Element orderButton,tryButton;
		
		public  OfferDetails(Element e)
		{
			orderButton=null;
			tryButton=null;
			ElementSet elementSet=new ElementSet();
			
			offerDescription=elementSet.getSubElement(e, "Xpath","div[1]").read().trim();
			offerName=elementSet.getSubElement(e, "Xpath","div[@class='black_background']//div//div[@class='uniform_header_font_size']").read();
			Element buttonLst[]=elementSet.getSubElementSet(e, "Xpath", "div[@class='black_background']//div[@class='black-button-shade']");
			for(int i=0;i<buttonLst.length;i++)
			{
				if(buttonLst[i].read().trim().contains("Try"))
				{
					tryButton=buttonLst[i];
				}
				if(buttonLst[i].read().trim().contains("Order"))
				{
					orderButton=buttonLst[i];
				}
				
			}
		}
	}
	
	public class OfferList extends Element

	{
		private String info[];

		public OfferList()
		{
			this.info=readAppData(this);
		}
		
		public OfferDetails[] selectOfferForOrder()
		{
			ElementSet elementSet=new ElementSet();
			Element elementLst[]=elementSet.getElementSet(this.info[0], this.info[1]);
			OfferDetails offerDetails[]=new OfferDetails[elementLst.length];
			for(int i=0;i<elementLst.length;i++)
			{
				offerDetails[i]=new OfferDetails(elementLst[i]);
			}
			return offerDetails;
		}
		

	}
  
	public OfferList offerList=new OfferList();

}
