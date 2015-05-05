package com.ensimtest.module.utility;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class PopUPHandler extends AppData
{

	public class GetPopUPData extends Element
	{
		public GetPopUPData()
		{
			setElement(readAppData(this));
		}
	}
	public GetPopUPData getPopUPData=new GetPopUPData();

	public class AcceptPopUP extends Element
	{
		public AcceptPopUP()
		{
			setElement(readAppData(this));
		}
	}
	public AcceptPopUP acceptPopUP=new AcceptPopUP();
	
	
	public class CanclePopUP extends Element
	{
		public CanclePopUP()
		{
			setElement(readAppData(this));
		}
	}
	public CanclePopUP canclePopUP=new CanclePopUP();

}
