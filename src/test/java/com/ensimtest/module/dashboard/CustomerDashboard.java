package com.ensimtest.module.dashboard;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class CustomerDashboard extends AppData
{
	public class CartLnk extends Element
	{
		public CartLnk()
		{
			setElement(readAppData(this));
		}
	}
	public CartLnk cartLnk = new CartLnk();
}
