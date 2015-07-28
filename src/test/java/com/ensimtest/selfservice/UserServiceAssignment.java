package com.ensimtest.selfservice;

import com.ensimtest.config.Browser;
import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class UserServiceAssignment extends AppData
{

	public class ServiceDetails
	{
		public String ServiceName;
		public Element assignLnk;
		
		public ServiceDetails(Element element)
		{
			ElementSet elementset=new ElementSet();
			ServiceName=elementset.getSubElement(element, "ClassName", "service-name").read();
			assignLnk=elementset.getSubElement(element, "Xpath", "div//a[contains(@class,'assign')]");
		}
		
	}
	
	public ServiceDetails[] getServicesDetails(Browser browser)
	{
		try
		{
			
		browser.setWait(1);
		ElementSet elementSet=new ElementSet();
		Element services[]=elementSet.getElementSet("Xpath", "//ul[@id='available-services-ol']//li");
		ServiceDetails serviceDetail[]=new ServiceDetails[services.length];
		for(int i=0;i<services.length;i++)
		{
			serviceDetail[i]=new ServiceDetails(services[i]);
		}
        
		return serviceDetail;
		}
		finally
		{
			browser.setDefaultWait();
		}
	}
	
}
