package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class ExportOrders extends AppData
{

	public class ChooseServiceLst extends Element
	{
		public ChooseServiceLst()
		{
			setElement(readAppData(this));
		}
		public void select(String data)
		{
			super.selectVisibleText(data);
		}
	}
	public ChooseServiceLst chooseServiceLst = new ChooseServiceLst();

	public class ChooseOfferLst extends Element
	{
		public ChooseOfferLst()
		{
			setElement(readAppData(this));
		}
		public void select(String data)
		{
			super.selectVisibleText(data);
		}
	}
	public ChooseOfferLst chooseOfferLst = new ChooseOfferLst();

	public class ExportNowBtn extends Element
	{
		public ExportNowBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ExportNowBtn exportNowBtn = new ExportNowBtn();
}
