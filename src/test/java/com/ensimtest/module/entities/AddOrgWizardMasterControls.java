package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class AddOrgWizardMasterControls extends AppData 
{
		public class OrderDetailsBrdCrmb extends Element
		{
			public OrderDetailsBrdCrmb()
			{
				setElement(readAppData(this));
			}
		}
		public OrderDetailsBrdCrmb orderDetailsBrdCrmb = new OrderDetailsBrdCrmb();
		
		public class MasterAccountDetailsBrdCrmb extends Element
		{
			public MasterAccountDetailsBrdCrmb()
			{
				setElement(readAppData(this));
			}
		}
		public MasterAccountDetailsBrdCrmb masterAccountDetailsBrdCrmb = new MasterAccountDetailsBrdCrmb();
	
		public class SummaryBrdCrmb extends Element
		{
			public SummaryBrdCrmb()
			{
				setElement(readAppData(this));
			}
		}
		public SummaryBrdCrmb summaryBrdCrmb = new SummaryBrdCrmb();
	
	public class CancelBtn extends Element
	{
		public CancelBtn()
		{
			setElement(readAppData(this));
		}
	}
	public CancelBtn cancelBtn = new CancelBtn();
	
	public class ContinueBtn extends Element
	{
		public ContinueBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ContinueBtn continueBtn = new ContinueBtn();
	
	public class GoBackBtn extends Element
	{
		public GoBackBtn()
		{
			setElement(readAppData(this));
		}
	}
	public GoBackBtn goBackBtn = new GoBackBtn();
	
	public class SaveBtn extends Element
	{
		public SaveBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SaveBtn saveBtn = new SaveBtn();
}
