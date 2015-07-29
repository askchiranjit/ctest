package com.ensimtest.connector.vcenter34;

import com.ensimtest.config.Browser;
import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class VirtualServers34 extends AppData
{

	
	public class VmDetails extends Element
	{
		public String vmName,template,ownerName,ipAddress,publicIP,noCPU,storageGB,vmStatus,ramGB;
		public Element cloneVmBtn,editPropertyBtn,deleteVM,startVM,stopVM,suspendVM,resumeVM,restartVM;
		
		
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
		public VmDetails(Element e)
		{
			
			ElementSet elementSet=new ElementSet();
			vmName=elementSet.getSubElement(e, "Xpath", "*//h3").read().trim();
			template=elementSet.getSubElement(e, "Xpath", "*//b//parent::td").read().split(":")[1].trim();
			cloneVmBtn=setElement(elementSet.getSubElementSet(e, "Xpath", "*//a[contains(@onclick,'openCloneVMDialogue')]"));
			System.out.println(cloneVmBtn);
			editPropertyBtn=setElement(elementSet.getSubElementSet(e, "Xpath","*//a[contains(@onclick,'openVMDetailsDialogue')]"));
			deleteVM=setElement(elementSet.getSubElementSet(e, "Xpath", "*//a[contains(@onclick,'showRemoveVMConfirm')]"));
			startVM=setElement(elementSet.getSubElementSet(e, "Xpath", "*//img[@title='Start']//parent::a"));
			stopVM=setElement(elementSet.getSubElementSet(e, "Xpath", "*//img[@title='Stop']//parent::a"));
			suspendVM=setElement(elementSet.getSubElementSet(e, "Xpath", "*//img[@title='Suspend']//parent::a"));
			resumeVM=setElement(elementSet.getSubElementSet(e, "Xpath", "*//img[@title='Resume']//parent::a"));
			restartVM=setElement(elementSet.getSubElementSet(e, "Xpath", "*//img[@title='Restart']//parent::a"));
			ownerName=setElement(elementSet.getSubElementSet(e, "Xpath", "*//span[contains(@id,'vmownertdmain')]")).read().trim();
			ipAddress=setElement(elementSet.getSubElementSet(e, "Xpath", "*//span[contains(@id,'vmipaddress')]")).read().trim();
			publicIP=setElement(elementSet.getSubElementSet(e, "Xpath", "*//span[contains(@id,'vmextipaddress')]")).read().trim();
			noCPU=setElement(elementSet.getSubElementSet(e, "Xpath", "*//span[contains(@id,'vmnoOfCPUCore')]")).read().trim();
			storageGB=setElement(elementSet.getSubElementSet(e, "Xpath", "*//span[contains(@id,'vmdiskSpaceInGB')]")).read().trim();
			vmStatus=setElement(elementSet.getSubElementSet(e, "Xpath", "*//span[contains(@id,'vm_status')]")).read().trim();
			ramGB=setElement(elementSet.getSubElementSet(e, "Xpath", "*//span[contains(@id,'vmmemoryInGB')]")).read().trim();
		}
		
		
	}
	
	
public VmDetails[] getVmsDetails(Browser browser)
{
	try
	{
	
	browser.setWait(1);
	ElementSet noOfVM=new ElementSet();
	Element[] novm=noOfVM.getElementSet("Xpath", "//div[contains(@class,'ui-accordion-content-active')]//table[@id='vm']");
	System.out.println(novm.length);
	VmDetails[] vmdetails=new VmDetails[novm.length];
	for(int i=0;i<novm.length;i++)
	{
		vmdetails[i]=new VmDetails(novm[i]);
	}
	return vmdetails;
	
	}
	finally
	{
		browser.setDefaultWait();
	}
}
	
	
	
}
