package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class AddService extends AppData
{
	public class ServiceNameTxt extends Element
	{
		public ServiceNameTxt()
		{
			setElement(readAppData(this));
		}
	}
	public ServiceNameTxt serviceNameTxt = new ServiceNameTxt();

	public class InternalServiceIDTxt extends Element
	{
		public InternalServiceIDTxt()
		{
			setElement(readAppData(this));
		}
	}
	public InternalServiceIDTxt internalServiceIDTxt = new InternalServiceIDTxt();

	public class SubscriptionTypeTxt extends Element
	{
		public SubscriptionTypeTxt()
		{
			setElement(readAppData(this));
		}
	}
	public SubscriptionTypeTxt subscriptionTypeTxt = new SubscriptionTypeTxt();

	public class VendorNameTxt extends Element
	{
		public VendorNameTxt()
		{
			setElement(readAppData(this));
		}
	}
	public VendorNameTxt vendorNameTxt = new VendorNameTxt();

	public class SearchTagTxt extends Element
	{
		public SearchTagTxt()
		{
			setElement(readAppData(this));
		}
	}
	public SearchTagTxt searchTagTxt = new SearchTagTxt();

	public class ProvSystemIdTxt extends Element
	{
		public ProvSystemIdTxt()
		{
			setElement(readAppData(this));
		}
	}
	public ProvSystemIdTxt provSystemIdTxt = new ProvSystemIdTxt();

	public class EmbeddedMessageTxt extends Element
	{
		public EmbeddedMessageTxt()
		{
			setElement(readAppData(this));
		}
	}
	public EmbeddedMessageTxt embeddedMessageTxt = new EmbeddedMessageTxt();

	public class SuggestedServiceBtn extends Element
	{
		public SuggestedServiceBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SuggestedServiceBtn suggestedServiceBtn = new SuggestedServiceBtn();

	public class ProvisioningDelayTxt extends Element
	{
		public ProvisioningDelayTxt()
		{
			setElement(readAppData(this));
		}
	}
	public ProvisioningDelayTxt provisioningDelayTxt = new ProvisioningDelayTxt();

	public class ProvisioningDelayLst extends Element
	{
		public ProvisioningDelayLst()
		{
			setElement(readAppData(this));
		}
	}
	public ProvisioningDelayLst provisioningDelayLst = new ProvisioningDelayLst();

	public class DNSRequireChk extends Element
	{
		public DNSRequireChk()
		{
			setElement(readAppData(this));
		}
	}
	public DNSRequireChk dNSRequireChk = new DNSRequireChk();

	public class MultipleOrdersOnSameDNSChk extends Element
	{
		public MultipleOrdersOnSameDNSChk()
		{
			setElement(readAppData(this));
		}
	}
	public MultipleOrdersOnSameDNSChk multipleOrdersOnSameDNSChk = new MultipleOrdersOnSameDNSChk();

	public class UsageCollectionRequireChk extends Element
	{
		public UsageCollectionRequireChk()
		{
			setElement(readAppData(this));
		}
	}
	public UsageCollectionRequireChk usageCollectionRequireChk = new UsageCollectionRequireChk();

	public class RequireActiveDirectoryDomainChk extends Element
	{
		public RequireActiveDirectoryDomainChk()
		{
			setElement(readAppData(this));
		}
	}
	public RequireActiveDirectoryDomainChk requireActiveDirectoryDomainChk = new RequireActiveDirectoryDomainChk();

	public class HasUserManagementChk extends Element
	{
		public HasUserManagementChk()
		{
			setElement(readAppData(this));
		}
	}
	public HasUserManagementChk hasUserManagementChk = new HasUserManagementChk();

	public class NeedPhNoChk extends Element
	{
		public NeedPhNoChk()
		{
			setElement(readAppData(this));
		}
	}
	public NeedPhNoChk needPhNoChk = new NeedPhNoChk();

	public class AssociateifSamePrivateDomainRdo extends Element
	{
		public AssociateifSamePrivateDomainRdo()
		{
			setElement(readAppData(this));
		}
	}
	public AssociateifSamePrivateDomainRdo associateifSamePrivateDomainRdo = new AssociateifSamePrivateDomainRdo();

	public class NeverAssociateOrderRdo extends Element
	{
		public NeverAssociateOrderRdo()
		{
			setElement(readAppData(this));
		}
	}
	public NeverAssociateOrderRdo neverAssociateOrderRdo = new NeverAssociateOrderRdo();

	public class AlwaysAssociateOrderRdo extends Element
	{
		public AlwaysAssociateOrderRdo()
		{
			setElement(readAppData(this));
		}
	}
	public AlwaysAssociateOrderRdo alwaysAssociateOrderRdo = new AlwaysAssociateOrderRdo();

	public class TrackChangeOfSalesAgentChk extends Element
	{
		public TrackChangeOfSalesAgentChk()
		{
			setElement(readAppData(this));
		}
	}
	public TrackChangeOfSalesAgentChk trackChangeOfSalesAgentChk = new TrackChangeOfSalesAgentChk();

	public class TrackChangeOfTechnicalContactChk extends Element
	{
		public TrackChangeOfTechnicalContactChk()
		{
			setElement(readAppData(this));
		}
	}
	public TrackChangeOfTechnicalContactChk trackChangeOfTechnicalContactChk = new TrackChangeOfTechnicalContactChk();

	public class TrackChangeOfProvisioningInformationChk extends Element
	{
		public TrackChangeOfProvisioningInformationChk()
		{
			setElement(readAppData(this));
		}
	}
	public TrackChangeOfProvisioningInformationChk trackChangeOfProvisioningInformationChk = new TrackChangeOfProvisioningInformationChk();

	public class OneTimeProvisioningRdo extends Element
	{
		public OneTimeProvisioningRdo()
		{
			setElement(readAppData(this));
		}
	}
	public OneTimeProvisioningRdo oneTimeProvisioningRdo = new OneTimeProvisioningRdo();

	public class HostedServiceRdo extends Element
	{
		public HostedServiceRdo()
		{
			setElement(readAppData(this));
		}
	}
	public HostedServiceRdo hostedServiceRdo = new HostedServiceRdo();

	public class ManualProvisioningRdo extends Element
	{
		public ManualProvisioningRdo()
		{
			setElement(readAppData(this));
		}
	}
	public ManualProvisioningRdo manualProvisioningRdo = new ManualProvisioningRdo();

	public class AutomaticProvisioningRdo extends Element
	{
		public AutomaticProvisioningRdo()
		{
			setElement(readAppData(this));
		}
	}
	public AutomaticProvisioningRdo automaticProvisioningRdo = new AutomaticProvisioningRdo();

	public class SendAccessCredentialsChk extends Element
	{
		public SendAccessCredentialsChk()
		{
			setElement(readAppData(this));
		}
	}
	public SendAccessCredentialsChk sendAccessCredentialsChk = new SendAccessCredentialsChk();

	public class NotificationTemplateLnk extends Element
	{
		public NotificationTemplateLnk()
		{
			setElement(readAppData(this));
		}
	}
	public NotificationTemplateLnk notificationTemplateLnk = new NotificationTemplateLnk();

	public class AccessInformationTxt extends Element
	{
		public AccessInformationTxt()
		{
			setElement(readAppData(this));
		}
	}
	public AccessInformationTxt accessInformationTxt = new AccessInformationTxt();

	public class ResellerCanConfigureChk extends Element
	{
		public ResellerCanConfigureChk()
		{
			setElement(readAppData(this));
		}
	}
	public ResellerCanConfigureChk resellerCanConfigureChk = new ResellerCanConfigureChk();

	public class AgentCanConfigureChk extends Element
	{
		public AgentCanConfigureChk()
		{
			setElement(readAppData(this));
		}
	}
	public AgentCanConfigureChk agentCanConfigureChk = new AgentCanConfigureChk();

	public class UseEASControlPanel extends Element
	{
		public UseEASControlPanel()
		{
			setElement(readAppData(this));
		}
	}
	public UseEASControlPanel useEASControlPanel = new UseEASControlPanel();

	public class CancelBtn extends Element
	{
		public CancelBtn()
		{
			setElement(readAppData(this));
		}
	}
	public CancelBtn cancelBtn = new CancelBtn();

	public class SaveBtn extends Element
	{
		public SaveBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SaveBtn saveBtn = new SaveBtn();
}
