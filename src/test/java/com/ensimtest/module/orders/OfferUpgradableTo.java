package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class OfferUpgradableTo extends AppData
{
	
	public class UpgradableOffers extends Element
	{
	    public String info[];
		public UpgradableOffers()
		{
			info=readAppData(this);
		}
		
		public UpgradeOffersDetails[] getOfferLst()
		{
			ElementSet elementset=new ElementSet();
			Element elements[]=elementset.getElementSet(info[0], info[1]);
			UpgradeOffersDetails upgradeOffersDetails[]= new UpgradeOffersDetails[elements.length];
			for(int i=0;i<elements.length;i++)
			{
				upgradeOffersDetails[i]=new UpgradeOffersDetails(elements[i]);
			}
			return upgradeOffersDetails;
		}
		
	}
	
	public UpgradableOffers upgradableOffers=new UpgradableOffers();
	
	
	public class UpgradeOffersDetails
	{
		public String offerName;
		public Element offerLink;
		
		public UpgradeOffersDetails(Element e)
		{
			ElementSet elementSet=new ElementSet();
			this.offerLink=e;
			this.offerName=elementSet.getSubElement(e, "Xpath", "div[2]//strong").read();
		}
	}
	

}
