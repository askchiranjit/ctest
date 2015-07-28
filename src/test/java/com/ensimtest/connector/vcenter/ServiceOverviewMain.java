package com.ensimtest.connector.vcenter;

import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class ServiceOverviewMain extends AppData
{

	public class VirtualDataCenterTab extends Element
	{
		public VirtualDataCenterTab()
		{
			setElement(readAppData(this));
		}
		
		public void expand()
		{
		 Element SuperElement=super.getParentElement();
		 String attributevalue= SuperElement.getAttributeValue("class");
		 if(attributevalue.contains("ui-state-active"))
		 {
			 System.out.println("Already Expanded");
		 }
		 else
		 {
			super.click();
		 }
		 
		}
		
		public void close()
		{
		 Element SuperElement=super.getParentElement();
		 String attributevalue= SuperElement.getAttributeValue("class");
		 if(attributevalue.contains("ui-state-active"))
		 {
			 super.click();
			 
		 }
		 else
		 {
			 System.out.println("Already closed");
		 }
		 
		}
		
	}
	public VirtualDataCenterTab virtualDataCenterTab = new VirtualDataCenterTab();

	public class VirtualServersTab extends Element
	{
		public VirtualServersTab()
		{
			setElement(readAppData(this));
		}
		public void expand()
		{
		 Element SuperElement=super.getParentElement();
		 String attributevalue= SuperElement.getAttributeValue("class");
		 if(attributevalue.contains("ui-state-active"))
		 {
			 System.out.println("Already Expanded");
		 }
		 else
		 {
			super.click();
		 }
		 
		}
		public void close()
		{
		 Element SuperElement=super.getParentElement();
		 String attributevalue= SuperElement.getAttributeValue("class");
		 if(attributevalue.contains("ui-state-active"))
		 {
			 super.click();
			 
		 }
		 else
		 {
			 System.out.println("Already closed");
		 }
		 
		}
	}
	public VirtualServersTab virtualServersTab = new VirtualServersTab();

	public class NetworkTab extends Element
	{
		public NetworkTab()
		{
			setElement(readAppData(this));
		}
		public void expand()
		{
		 Element SuperElement=super.getParentElement();
		 String attributevalue= SuperElement.getAttributeValue("class");
		 if(attributevalue.contains("ui-state-active"))
		 {
			 System.out.println("Already Expanded");
		 }
		 else
		 {
			super.click();
		 }
		 
		}
		public void close()
		{
		 Element SuperElement=super.getParentElement();
		 String attributevalue= SuperElement.getAttributeValue("class");
		 if(attributevalue.contains("ui-state-active"))
		 {
			 super.click();
			 
		 }
		 else
		 {
			 System.out.println("Already closed");
		 }
		 
		}
	}
	public NetworkTab networkTab = new NetworkTab();

	public class TemplatesTab extends Element
	{
		public TemplatesTab()
		{
			setElement(readAppData(this));
		}
		public void expand()
		{
		 Element SuperElement=super.getParentElement();
		 String attributevalue= SuperElement.getAttributeValue("class");
		 if(attributevalue.contains("ui-state-active"))
		 {
			 System.out.println("Already Expanded");
		 }
		 else
		 {
			super.click();
		 }
		 
		}
		public void close()
		{
		 Element SuperElement=super.getParentElement();
		 String attributevalue= SuperElement.getAttributeValue("class");
		 if(attributevalue.contains("ui-state-active"))
		 {
			 super.click();
			 
		 }
		 else
		 {
			 System.out.println("Already closed");
		 }
		 
		}
	}
	public TemplatesTab templatesTab = new TemplatesTab();

	public class UsersTab extends Element
	{
		public UsersTab()
		{
			setElement(readAppData(this));
		}
		public void expand()
		{
		 Element SuperElement=super.getParentElement();
		 String attributevalue= SuperElement.getAttributeValue("class");
		 if(attributevalue.contains("ui-state-active"))
		 {
			 System.out.println("Already Expanded");
		 }
		 else
		 {
			super.click();
		 }
		 
		}
		public void close()
		{
		 Element SuperElement=super.getParentElement();
		 String attributevalue= SuperElement.getAttributeValue("class");
		 if(attributevalue.contains("ui-state-active"))
		 {
			 super.click();
			 
		 }
		 else
		 {
			 System.out.println("Already closed");
		 }
		 
		}
	}
	public UsersTab usersTab = new UsersTab();

	public class ActionLogsTab extends Element
	{
		public ActionLogsTab()
		{
			setElement(readAppData(this));
		}
		public void expand()
		{
		 Element SuperElement=super.getParentElement();
		 String attributevalue= SuperElement.getAttributeValue("class");
		 if(attributevalue.contains("ui-state-active"))
		 {
			 System.out.println("Already Expanded");
		 }
		 else
		 {
			super.click();
		 }
		 
		}
		public void close()
		{
		 Element SuperElement=super.getParentElement();
		 String attributevalue= SuperElement.getAttributeValue("class");
		 if(attributevalue.contains("ui-state-active"))
		 {
			 super.click();
			 
		 }
		 else
		 {
			 System.out.println("Already closed");
		 }
		 
		}
	}
	public ActionLogsTab actionLogsTab = new ActionLogsTab();

	public class VDCInformationTab extends Element
	{
		public VDCInformationTab()
		{
			setElement(readAppData(this));
		}
		public void expand()
		{
		 Element SuperElement=super.getParentElement();
		 String attributevalue= SuperElement.getAttributeValue("class");
		 if(attributevalue.contains("ui-state-active"))
		 {
			 System.out.println("Already Expanded");
		 }
		 else
		 {
			super.click();
		 }
		 
		}
		public void close()
		{
		 Element SuperElement=super.getParentElement();
		 String attributevalue= SuperElement.getAttributeValue("class");
		 if(attributevalue.contains("ui-state-active"))
		 {
			 super.click();
			 
		 }
		 else
		 {
			 System.out.println("Already closed");
		 }
		 
		}
	}
	public VDCInformationTab vDCInformationTab = new VDCInformationTab();
	
	
}
