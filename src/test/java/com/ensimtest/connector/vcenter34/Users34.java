package com.ensimtest.connector.vcenter34;

import com.ensimtest.config.Browser;
import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class Users34 extends AppData
{

	public class UsersDetail
	{
		public String userName,role,ownerVms;
		public Element selectRdo;
		
		
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
		
		public UsersDetail(Element element)
		{
			ElementSet elementSet=new ElementSet();
			userName=setElement(elementSet.getSubElementSet(element, "Xpath", "td[2]")).read().trim();
			role=setElement(elementSet.getSubElementSet(element, "Xpath", "td[4]")).read().trim();
			ownerVms=setElement(elementSet.getSubElementSet(element, "Xpath", "td[5]")).read().trim();
			selectRdo=setElement(elementSet.getSubElementSet(element, "Xpath", "*//input[@type='radio']"));
		}
		
		
	}
	
	public UsersDetail[] getUsers(Browser browser)
	{
		try
		{
		browser.setWait(1);
		ElementSet elementSet=new ElementSet();
		Element element[]=elementSet.getElementSet("Xpath", "//table[@id='example2']//tbody//tr");
		UsersDetail userDetl[]=new UsersDetail[element.length];
		for(int i=0;i<element.length;i++)
		{
			userDetl[i]=new UsersDetail(element[i]);
		}
		return userDetl;
		}
		finally
		{
			browser.setDefaultWait();
		}
	}
	
}
