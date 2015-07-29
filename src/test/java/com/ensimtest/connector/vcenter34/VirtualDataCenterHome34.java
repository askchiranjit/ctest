package com.ensimtest.connector.vcenter34;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class VirtualDataCenterHome34 extends AppData
{

	public class AddVMBtn extends Element
	{
		public AddVMBtn()
		{
			setElement(readAppData(this));
		}
	}
	
	public AddVMBtn addVMBtn=new AddVMBtn();
	
	public class UpsizeVDCBtn extends Element
	{
		public UpsizeVDCBtn()
		{
			setElement(readAppData(this));
		}
	}
	
	public UpsizeVDCBtn upsizeVDCBtn=new UpsizeVDCBtn();
	
	
	
}
