package com.ensimtest.module.orders;
import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;
/**
 * Order Advance Search
 * @author Karabi
 *
 */
public class OrderSearch extends AppData{
	
	public class AdvSearchBtn extends Element{
		public AdvSearchBtn()
		{
			setElement(readAppData(this));
		}
	}
	public AdvSearchBtn advSearchBtn = new AdvSearchBtn();

	public class OrderID extends Element{
		public OrderID()
		{
			setElement(readAppData(this));
		}
	}
	public OrderID orderID = new OrderID();

	public class SubscriptionID extends Element{
		public SubscriptionID()
		{
			setElement(readAppData(this));
		}
	}
	public SubscriptionID subscriptionID = new SubscriptionID();

	public class OrganizationID extends Element{
		public OrganizationID()
		{
			setElement(readAppData(this));
		}
	}
	public OrganizationID organizationID = new OrganizationID();

	public class StatusLst extends Element{
		public StatusLst()
		{
			setElement(readAppData(this));
		}
	}
	public StatusLst statusLst = new StatusLst();

	public class OfferName extends Element{
		public OfferName()
		{
			setElement(readAppData(this));
		}
	}
	public OfferName offerName = new OfferName();

	public class StartDate extends Element{
		public StartDate()
		{
			setElement(readAppData(this));
		}
	}
	public StartDate startDate = new StartDate();

	public class EndDate extends Element{
		public EndDate()
		{
			setElement(readAppData(this));
		}
	}
	public EndDate endDate = new EndDate();

	public class SearchBtn extends Element{
		public SearchBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SearchBtn searchBtn = new SearchBtn();

	public class ResetBtn extends Element{
		public ResetBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ResetBtn resetBtn = new ResetBtn();


}
