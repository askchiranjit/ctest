package com.ensimtest.connector.vcenter34;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class AddVM34 extends AppData
{

	public class LinuxOSTab extends Element
	{
		public LinuxOSTab()
		{
			setElement(readAppData(this));
		}

		public void expand()
		{
			String value=super.getAttributeValue("class");
			if(value.contains("ui-state-active"))
			{
				System.out.println("Already Expanded");
			}
			else
			{
				super.click();
			}
		}
	}

	public  LinuxOSTab linuxOSTab=new LinuxOSTab();

	public class OthersTab extends Element
	{

		public OthersTab()
		{
			setElement(readAppData(this));
		}

		public void expand()
		{
			String value=super.getAttributeValue("class");
			if(value.contains("ui-state-active"))
			{
				System.out.println("Already Expanded");
			}
			else
			{
				super.click();
			}
		}
	}

	public  OthersTab othersTab=new OthersTab();

	public class WindowsOSTab extends Element
	{

		public WindowsOSTab()
		{
			setElement(readAppData(this));
		}

		public void expand()
		{
			String value=super.getAttributeValue("class");
			if(value.contains("ui-state-active"))
			{
				System.out.println("Already Expanded");
			}
			else
			{
				super.click();
			}
		}
	}
	public  WindowsOSTab windowsOSTab=new WindowsOSTab();


	public class SelectTemplate extends Element
	{
		public SelectTemplate()
		{

		}

		private void setPath(String templateName)
		{
			setElement("Xpath","//tr//td[2][contains(text(),'"+templateName+"')]//following-sibling::td//a[contains(@id,'templateSelectButton')]");
		}

		public void choseTemplate(String templateName)
		{
			setPath(templateName);
			click();
		}

	}

	public SelectTemplate selectTemplate=new SelectTemplate(); 


	public class NextBtn extends Element

	{
		public NextBtn()
		{
			setElement(readAppData(this));
		}
	}

	public NextBtn nextBtn=new NextBtn();


	public class DisplayNameTxt extends Element

	{
		public DisplayNameTxt()
		{
			setElement(readAppData(this));
		}
	}

	public DisplayNameTxt displayNameTxt=new DisplayNameTxt();


	public class VmOwnerLst extends Element

	{
		public VmOwnerLst()
		{
			setElement(readAppData(this));
		}

		public void selectOwner(String ownerID)
		{
			super.selectVisibleText(ownerID);
		}

	}

	public VmOwnerLst vmOwnerLst=new VmOwnerLst();

	public class CPUTxt extends Element

	{
		public CPUTxt()
		{
			setElement(readAppData(this));
		}
		
		@Override
		public void write(String msg) {
			super.clear();
			super.write(msg);
		}
		
	}

	public CPUTxt cPUTxt=new CPUTxt();

	public class RAMTxt extends Element

	{
		public RAMTxt()
		{
			setElement(readAppData(this));
		}
		
		@Override
		public void write(String msg) {
			super.clear();
			super.write(msg);
		}
		
	}

	public RAMTxt rAMTxt=new RAMTxt();



	public class PrimaryDiskLst extends Element
	{
		public PrimaryDiskLst()
		{
			setElement(readAppData(this));
		}

		public void selectPrimaryDiskType(String diskType)
		{
			super.selectVisibleText(diskType);
		}
	}
	public PrimaryDiskLst primaryDiskLst=new PrimaryDiskLst();


	public class PrimaryDiskTxt extends Element
	{
		public PrimaryDiskTxt()
		{
			setElement(readAppData(this));
		}

	}
	public PrimaryDiskTxt primaryDiskTxt=new PrimaryDiskTxt();

	public class NetworkAdapterLst extends Element
	{
		public NetworkAdapterLst()
		{
			setElement(readAppData(this));
		}

		public void selectNetworkAdapter(String adapterName)
		{
			super.selectVisibleText(adapterName);
		}
	}
	public NetworkAdapterLst networkAdapterLst=new NetworkAdapterLst();

	
	public class AdminNoteTxt extends Element
	{
		public AdminNoteTxt()
		{
			setElement(readAppData(this));
		}

	}
	public AdminNoteTxt adminNoteTxt=new AdminNoteTxt();
	
	public class CreateVMBtn extends Element
	{
		public CreateVMBtn()
		{
			setElement(readAppData(this));
		}

	}
	public CreateVMBtn createVMBtn=new CreateVMBtn();
	
	

}
