package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class CreateOrderContactDetails extends AppData
{
	public class ServiceAccountLst extends Element
	{
		public ServiceAccountLst()
		{
			setElement(readAppData(this));
		}
	}
	public ServiceAccountLst serviceAccountLst = new ServiceAccountLst();

	public class BillingAddressLbl extends Element
	{
		public BillingAddressLbl()
		{
			setElement(readAppData(this));
		}
	}
	public BillingAddressLbl billingAddressLbl = new BillingAddressLbl();

	public class AgentIdTxt extends Element
	{
		public AgentIdTxt()
		{
			setElement(readAppData(this));
		}
	}
	public AgentIdTxt agentIdTxt = new AgentIdTxt();

	public class CommentTxt extends Element
	{
		public CommentTxt()
		{
			setElement(readAppData(this));
		}
	}
	public CommentTxt commentTxt = new CommentTxt();

	public class BusinessContactDetailsLbl extends Element
	{
		public BusinessContactDetailsLbl()
		{
			setElement(readAppData(this));
		}
	}
	public BusinessContactDetailsLbl businessContactDetailsLbl = new BusinessContactDetailsLbl();

	public class TechnicalContactDetailsLbl extends Element
	{
		public TechnicalContactDetailsLbl()
		{
			setElement(readAppData(this));
		}
	}
	public TechnicalContactDetailsLbl technicalContactDetailsLbl = new TechnicalContactDetailsLbl();
}
