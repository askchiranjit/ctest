package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class AddOrgWizardSummary extends AppData
{
	public class OrgNameLbl extends Element
	{
		public OrgNameLbl()
		{
			setElement(readAppData(this));
		}
	}
	public OrgNameLbl orgNameLbl = new OrgNameLbl();

	public class EmailAddrForCorrespondanceLbl extends Element
	{
		public EmailAddrForCorrespondanceLbl()
		{
			setElement(readAppData(this));
		}
	}
	public EmailAddrForCorrespondanceLbl emailAddrForCorrespondanceLbl = new EmailAddrForCorrespondanceLbl();

	public class DomainNamesLbl extends Element
	{
		public DomainNamesLbl()
		{
			setElement(readAppData(this));
		}
	}
	public DomainNamesLbl domainNamesLbl = new DomainNamesLbl();

	public class CommunicationLanguageLbl extends Element
	{
		public CommunicationLanguageLbl()
		{
			setElement(readAppData(this));
		}
	}
	public CommunicationLanguageLbl communicationLanguageLbl = new CommunicationLanguageLbl();

	public class BillingLanguageLbl extends Element
	{
		public BillingLanguageLbl()
		{
			setElement(readAppData(this));
		}
	}
	public BillingLanguageLbl billingLanguageLbl = new BillingLanguageLbl();

	public class MasterAccountNameLbl extends Element
	{
		public MasterAccountNameLbl()
		{
			setElement(readAppData(this));
		}
	}
	public MasterAccountNameLbl masterAccountNameLbl = new MasterAccountNameLbl();

	public class PaymentAgreementLbl extends Element
	{
		public PaymentAgreementLbl()
		{
			setElement(readAppData(this));
		}
	}
	public PaymentAgreementLbl paymentAgreementLbl = new PaymentAgreementLbl();

	public class EmailAddrToReceiveFinnDocLbl extends Element
	{
		public EmailAddrToReceiveFinnDocLbl()
		{
			setElement(readAppData(this));
		}
	}
	public EmailAddrToReceiveFinnDocLbl emailAddrToReceiveFinnDocLbl = new EmailAddrToReceiveFinnDocLbl();

	public class UsernameSuffixLbl extends Element
	{
		public UsernameSuffixLbl()
		{
			setElement(readAppData(this));
		}
	}
	public UsernameSuffixLbl usernameSuffixLbl = new UsernameSuffixLbl();

	public class CreateSuccessAlert extends Element
	{
		public CreateSuccessAlert()
		{
			setElement(readAppData(this));
		}
	}
	public CreateSuccessAlert createSuccessAlert = new CreateSuccessAlert();
	
	public class CreateSuccessAlertOkBtn extends Element
	{
		public CreateSuccessAlertOkBtn()
		{
			setElement(readAppData(this));
		}
	}
	public CreateSuccessAlertOkBtn createSuccessAlertOkBtn = new CreateSuccessAlertOkBtn();
}
