package com.ensimtest.connector.vcenter34;

import com.ensimtest.config.Browser;
import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class Network34 extends AppData
{

	public class NetworkDetail
	{
		public String vmName,ipAddress,vLan,networkAdapter;
		public Element pubIPLnk;
		
		
		private Element setElement(Element innerElements[])
		{
			if(innerElements == null)
			{
				return null;
			}
			else
			{
				if(innerElements.length == 0)
				{
					return null;
				}
				else
				{
					return innerElements[0];
				}
			
			}
		}
		
		public NetworkDetail(Element element)
		{
			ElementSet elementSet=new ElementSet();
			vmName=setElement(elementSet.getSubElementSet(element, "Xpath", "td[1]")).read().trim();
			ipAddress=setElement(elementSet.getSubElementSet(element, "Xpath", "td[3]")).read().trim();
			vLan=setElement(elementSet.getSubElementSet(element, "Xpath", "td[4]")).read().split(":")[0].trim();
			networkAdapter=setElement(elementSet.getSubElementSet(element, "Xpath", "td[4]")).read().split(":")[1].trim();
			pubIPLnk=setElement(elementSet.getSubElementSet(element, "Xpath", "td[5]//a"));
		}
		
	}

	public NetworkDetail[] getNetworks(Browser browser)
	{
		try
		{
		browser.setWait(1);	
		ElementSet elementSet=new ElementSet();
		Element element[]=elementSet.getElementSet("Xpath", "//table[@id='example']/tbody/tr");
		NetworkDetail networkdetais[]=new NetworkDetail[element.length];
		for(int i=0;i<element.length;i++)
		{
			networkdetais[i]=new NetworkDetail(element[i]);
		}
		return networkdetais;
		
		}
		finally
		{
			browser.setDefaultWait();
		}
		

	}



}
