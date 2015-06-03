package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class CreateOrderSummary extends AppData
{
	public class EmailBCLbl extends Element
	{
		public EmailBCLbl()
		{
			setElement(readAppData(this));
		}
	}
	public EmailBCLbl emailBCLbl = new EmailBCLbl();

	public class EmailTCLbl extends Element
	{
		public EmailTCLbl()
		{
			setElement(readAppData(this));
		}
	}
	public EmailTCLbl emailTCLbl = new EmailTCLbl();

	public class ServiceAccountLbl extends Element
	{
		public ServiceAccountLbl()
		{
			setElement(readAppData(this));
		}
	}
	public ServiceAccountLbl serviceAccountLbl = new ServiceAccountLbl();

	public class BillableAccountLbl extends Element
	{
		public BillableAccountLbl()
		{
			setElement(readAppData(this));
		}
	}
	public BillableAccountLbl billableAccountLbl = new BillableAccountLbl();
	
	public class IAgreeTC extends Element
	{
		public IAgreeTC()
		{
			setElement(readAppData(this));
		}
	}
	public IAgreeTC iAgreeTC = new IAgreeTC();
	
	public class IDisagreeTC extends Element
	{
		public IDisagreeTC()
		{
			setElement(readAppData(this));
		}
	}
	public IDisagreeTC iDisagreeTC = new IDisagreeTC();
	
	public class InternalNotesTC extends Element
	{
		public InternalNotesTC()
		{
			setElement(readAppData(this));
		}
	}
	public InternalNotesTC internalNotesTC = new InternalNotesTC();
	
	public class CloseTCBtn extends Element
	{
		public CloseTCBtn()
		{
			setElement(readAppData(this));
		}
	}
	public CloseTCBtn closeTCBtn = new CloseTCBtn();
	
	public class SubmitTCBtn extends Element
	{
		public SubmitTCBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SubmitTCBtn submitTCBtn = new SubmitTCBtn();
}
