package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class SearchOrder extends AppData
{
	public class OrderIdTxt extends Element
	{
		public OrderIdTxt()
		{
			setElement(readAppData(this));
		}
	}
	public OrderIdTxt orderIdTxt = new OrderIdTxt();

	public class SubscriptionIDTxt extends Element
	{
		public SubscriptionIDTxt()
		{
			setElement(readAppData(this));
		}
	}
	public SubscriptionIDTxt subscriptionIDTxt = new SubscriptionIDTxt();

	public class OrganizationIDTxt extends Element
	{
		public OrganizationIDTxt()
		{
			setElement(readAppData(this));
		}
	}
	public OrganizationIDTxt organizationIDTxt = new OrganizationIDTxt();

	public class StatusLst extends Element
	{
		public StatusLst()
		{
			setElement(readAppData(this));
		}
		public void select(String data)
		{
			super.selectVisibleText(data);
		}
	}
	public StatusLst statusLst = new StatusLst();

	public class OfferNameTxt extends Element
	{
		public OfferNameTxt()
		{
			setElement(readAppData(this));
		}
	}
	public OfferNameTxt offerNameTxt = new OfferNameTxt();

	public class StartDateTxt extends Element
	{
		public StartDateTxt()
		{
			setElement(readAppData(this));
		}
	}
	public StartDateTxt startDateTxt = new StartDateTxt();

	public class EndDateTxt extends Element
	{
		public EndDateTxt()
		{
			setElement(readAppData(this));
		}
	}
	public EndDateTxt endDateTxt = new EndDateTxt();

	public class SearchBtn extends Element
	{
		public SearchBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SearchBtn searchBtn = new SearchBtn();

	public class ResetBtn extends Element
	{
		public ResetBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ResetBtn resetBtn = new ResetBtn();
}
