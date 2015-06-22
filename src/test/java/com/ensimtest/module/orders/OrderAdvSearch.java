package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;
/**
 * Order Advance Search
 * @author Karabi
 *
 */
public class OrderAdvSearch extends AppData{
	/**
	 * Orders search for ISP and different reseller and agents
	 */
	
	public class OwnOrderChk extends Element{
		public OwnOrderChk()
		{
			setElement(readAppData(this));
		}
	}
	public OwnOrderChk ownOrderChk = new OwnOrderChk();

	
	public class AllResellerChk extends Element{
		public AllResellerChk()
		{
			setElement(readAppData(this));
		}
	}
	public AllResellerChk allResellerChk = new AllResellerChk();

	public class SpecificResellerChk extends Element{
		public SpecificResellerChk()
		{
			setElement(readAppData(this));
		}
	}
	public SpecificResellerChk specificResellerChk = new SpecificResellerChk();

	
	public class AllOrderChk extends Element{
		public AllOrderChk()
		{
			setElement(readAppData(this));
		}
	}
	public AllOrderChk allOrderChk = new AllOrderChk();

	
	public class AllAgentChk extends Element{
		public AllAgentChk()
		{
			setElement(readAppData(this));
		}
	}
	public AllAgentChk allAgentChk = new AllAgentChk();

	
	public class SpecificAgentChk extends Element{
		public SpecificAgentChk()
		{
			setElement(readAppData(this));
		}
	}
	public SpecificAgentChk specificAgentChk = new SpecificAgentChk();

	public class OrderID extends Element{
		public OrderID()
		{
			setElement(readAppData(this));
		}
	}
	public OrderID orderID = new OrderID();

	
	public class OrganizationID extends Element{
		public OrganizationID()
		{
			setElement(readAppData(this));
		}
	}
	public OrganizationID organizationID = new OrganizationID();
	
	public class SubscriptionID extends Element{
		public SubscriptionID()
		{
			setElement(readAppData(this));
		}
	}
	public SubscriptionID subscriptionID = new SubscriptionID();

	public class SalesRepresentativeID extends Element{
		public SalesRepresentativeID()
		{
			setElement(readAppData(this));
		}
	}
	public SalesRepresentativeID salesRepresentativeID = new SalesRepresentativeID();

	public class OfferName extends Element{
		public OfferName()
		{
			setElement(readAppData(this));
		}
	}
	public OfferName offerName = new OfferName();

	public class StatusLst extends Element{
		public StatusLst()
		{
			setElement(readAppData(this));
		}
	}
	public StatusLst statusLst = new StatusLst();

	public class ProvisioningSysID extends Element{
		public ProvisioningSysID()
		{
			setElement(readAppData(this));
		}
	}
	public ProvisioningSysID provisioningSysID = new ProvisioningSysID();

	public class PurchaseOrderNum extends Element{
		public PurchaseOrderNum()
		{
			setElement(readAppData(this));
		}
	}
	public PurchaseOrderNum purchaseOrderNum = new PurchaseOrderNum();

	public class WorkflowLst extends Element{
		public WorkflowLst()
		{
			setElement(readAppData(this));
		}
	}
	public WorkflowLst WorkflowLst = new WorkflowLst();

	public class ServiceName extends Element{
		public ServiceName()
		{
			setElement(readAppData(this));
		}
	}
	public ServiceName serviceName = new ServiceName();

	/**
	 * Search by Date and Relevance
	 */
	public class DateOfApproval extends Element{
		public DateOfApproval()
		{
			setElement(readAppData(this));
		}
	}
	public DateOfApproval dateOfApproval = new DateOfApproval();

	public class BillingStartDate extends Element{
		public BillingStartDate()
		{
			setElement(readAppData(this));
		}
	}
	public BillingStartDate BillingStartDate = new BillingStartDate();

	public class ProvisionedDate extends Element{
		public ProvisionedDate()
		{
			setElement(readAppData(this));
		}
	}
	public ProvisionedDate provisionedDate = new ProvisionedDate();

	public class CancellationDate extends Element{
		public CancellationDate()
		{
			setElement(readAppData(this));
		}
	}
	public CancellationDate cancellationDate = new CancellationDate();

	public class CreationDate extends Element{
		public CreationDate()
		{
			setElement(readAppData(this));
		}
	}
	public CreationDate creationDate = new CreationDate();

	public class MigrationDate extends Element{
		public MigrationDate()
		{
			setElement(readAppData(this));
		}
	}
	public MigrationDate migrationDate = new MigrationDate();

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

	public class MigratedOrder extends Element{
		public MigratedOrder()
		{
			setElement(readAppData(this));
		}
	}
	public MigratedOrder migratedOrder = new MigratedOrder();

	public class HiddenOrder extends Element{
		public HiddenOrder()
		{
			setElement(readAppData(this));
		}
	}
	public HiddenOrder hiddenOrder = new HiddenOrder();

	public class TrialOrder extends Element{
		public TrialOrder()
		{
			setElement(readAppData(this));
		}
	}
	public TrialOrder trialOrder = new TrialOrder();

	public class CancelBtn extends Element{
		public CancelBtn()
		{
			setElement(readAppData(this));
		}
	}
	public CancelBtn cancelBtn = new CancelBtn();

	public class ResetBtn extends Element{
		public ResetBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ResetBtn refreshBtn = new ResetBtn();

	public class SearchBtn extends Element{
		public SearchBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SearchBtn searchBtn = new SearchBtn();

}
