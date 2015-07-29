package com.ensimtest.connector.vcenter34;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class VDCVirtualServerMain34 extends AppData
{

	public class LinuxOSTab extends Element
	{
		public LinuxOSTab()
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
	
	public LinuxOSTab linuxOS=new LinuxOSTab();
	
	
	
	public class OthersTab extends Element
	{
		public OthersTab()
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
	
	public OthersTab othersTab=new OthersTab();
	
	
	public class WindowsOSTab extends Element
	{
		public WindowsOSTab()
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
	
	public WindowsOSTab windowsOSTab=new WindowsOSTab();
	
	
	
}
