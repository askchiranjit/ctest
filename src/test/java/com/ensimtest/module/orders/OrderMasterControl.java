package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class OrderMasterControl extends AppData
{
	public class RecentTab extends Element
	{
		public RecentTab()
		{
			setElement(readAppData(this));
		}
	}
	public RecentTab recentTab = new RecentTab();
	
	public class FailedTab extends Element
	{
		public FailedTab()
		{
			setElement(readAppData(this));
		}
	}
	public FailedTab failedTab = new FailedTab();
	
	public class PendingTab extends Element
	{
		public PendingTab()
		{
			setElement(readAppData(this));
		}
	}
	public PendingTab pendingTab = new PendingTab();
	
	public class CancelledTab extends Element
	{
		public CancelledTab()
		{
			setElement(readAppData(this));
		}
	}
	public CancelledTab cancelledTab = new CancelledTab();
	
	public class NextBtn extends Element
	{
		public NextBtn()
		{
			setElement(readAppData(this));
		}
		@Override
		public boolean isEnabled()
		{
			try
			{
				String info = super.getAttributeValue("class");
				if(info.equals("disabledImage"))
				{
					return false;
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return true;
		}
	}
	public NextBtn nextBtn = new NextBtn();
	
	public class PreviousBtn extends Element
	{
		public PreviousBtn()
		{
			setElement(readAppData(this));
		}
		@Override
		public boolean isEnabled()
		{
			try
			{
				String info = super.getAttributeValue("class");
				if(info.equals("disabledImage"))
				{
					return false;
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return true;
		}
	}
	public PreviousBtn previousBtn = new PreviousBtn();
}
