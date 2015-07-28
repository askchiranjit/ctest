package com.ensimtest.module.entities;

import com.ensimtest.config.Browser;
import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class OrganizationUserISP extends AppData
{
    public class userOptions
    {
    	public Element checkbox,userLink,adduser;
    	public boolean active;
    	public String adStatus;
    	
    	public userOptions(Element e)
    	{
    		
    		active=false;
    		adStatus="Ad not applicable for this setup";
    		ElementSet elementSet=new ElementSet();
    		int noOfTd=elementSet.getSubElementSet(e, "Xpath","td").length;
    		System.out.println("no of element " +noOfTd);
    		checkbox=elementSet.getSubElement(e, "Xpath","td[@id='removalServicestdId']//input[@type='checkbox']");
    		userLink=elementSet.getSubElement(e, "Xpath", "td[2]//a");
    		Element activeImg=elementSet.getSubElement(e, "Xpath", "td[3]//a//img");
    		if(activeImg.getAttributeValue("title").equalsIgnoreCase("Active"))
    		{
    			active=true;
    		}
    		userLink=elementSet.getSubElement(e, "Xpath", "td["+noOfTd+"]//a[1]|td["+noOfTd+"]//img");
    		
    		if(noOfTd>=5)
    		{
    			adStatus=elementSet.getSubElement(e, "Xpath", "td[4]//img").getAttributeValue("title");
    		}
    	}
    	
    }
	
	public userOptions[] getUserDetails(Browser browser)
	{
		try
		{
			browser.setWait(1);
			ElementSet elementSet=new ElementSet();
			Element userRow[]=elementSet.getElementSet("Xpath", "//table[@id='users']//tbody//tr");
			userOptions userOptions[]=new userOptions[userRow.length];
			System.out.println(userRow.length);
			for(int i=0;i<userRow.length;i++)
			{
				userOptions[i]=new userOptions(userRow[i]);
			}
			return userOptions;
			
		}
		finally
		{
			browser.setWait(30);
		}

	}

	
	
}
