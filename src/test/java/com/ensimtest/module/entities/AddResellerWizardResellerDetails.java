package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * This is for Add reseller screen's Resellers wizards
 * @author Pratap
 *
 */

public class AddResellerWizardResellerDetails extends AppData
{
	public class ResellerTypeLst extends Element
	{
		public ResellerTypeLst()
		{
			setElement(readAppData(this));
		}
		public void select(String data)
		{
			super.selectVisibleText(data);
		}
	}
	public ResellerTypeLst resellerTypeLst = new ResellerTypeLst();
	
	public class ResellerID extends Element
	{
		public ResellerID()
		{
			setElement(readAppData(this));
		}
	}
	public ResellerID resellerID = new ResellerID();
	
	public class ResellerNameTxt extends Element
	{
		public ResellerNameTxt()
		{
			setElement(readAppData(this));
		}
	}
	public ResellerNameTxt resellerNameTxt = new ResellerNameTxt();

	public class VATNumberTxt extends Element
	{
		public VATNumberTxt()
		{
			setElement(readAppData(this));
		}
	}
	public VATNumberTxt vATNumberTxt = new VATNumberTxt();

	public class EmailCorrespondenceTxt extends Element
	{
		public EmailCorrespondenceTxt()
		{
			setElement(readAppData(this));
		}
	}
	public EmailCorrespondenceTxt emailCorrespondenceTxt = new EmailCorrespondenceTxt();

	public class EmaiReceiveFinancialDocumentsTxt extends Element
	{
		public EmaiReceiveFinancialDocumentsTxt()
		{
			setElement(readAppData(this));
		}
	}
	public EmaiReceiveFinancialDocumentsTxt emaiReceiveFinancialDocumentsTxt = new EmaiReceiveFinancialDocumentsTxt();

	public class DomainNamesTxt extends Element
	{
		public DomainNamesTxt()
		{
			setElement(readAppData(this));
		}
	}
	public DomainNamesTxt domainNamesTxt = new DomainNamesTxt();

	public class UsernameSuffixTxt extends Element
	{
		public UsernameSuffixTxt()
		{
			setElement(readAppData(this));
		}
	}
	public UsernameSuffixTxt usernameSuffixTxt = new UsernameSuffixTxt();

	public class ConfirmUsernameSuffixTxt extends Element
	{
		public ConfirmUsernameSuffixTxt()
		{
			setElement(readAppData(this));
		}
	}
	public ConfirmUsernameSuffixTxt confirmUsernameSuffixTxt = new ConfirmUsernameSuffixTxt();

	public class CustomizedLoginURLTxt extends Element
	{
		public CustomizedLoginURLTxt()
		{
			setElement(readAppData(this));
		}
	}
	public CustomizedLoginURLTxt customizedLoginURLTxt = new CustomizedLoginURLTxt();

	public class CommunicationLanguageLst extends Element
	{
		public CommunicationLanguageLst()
		{
			setElement(readAppData(this));
		}
		public void selectCommunicationLanguage(String comLanguage)
		{
			super.selectVisibleText(comLanguage);
		}
	}
	public CommunicationLanguageLst communicationLanguageLst = new CommunicationLanguageLst();

	public class BillingLanguageLst extends Element
	{
		public BillingLanguageLst()
		{
			setElement(readAppData(this));
		}
		public void selectBillingLanguage(String billingLanguage)
		{
			super.selectVisibleText(billingLanguage);
		}
	}
	public BillingLanguageLst billingLanguageLst = new BillingLanguageLst();

	public class DateTimeFormatLst extends Element
	{
		public DateTimeFormatLst()
		{
			setElement(readAppData(this));
		}
		public void selectDateTimeFormat(String format)
		{
			super.selectVisibleText(format);
		}
		
	}
	public DateTimeFormatLst dateTimeFormatLst = new DateTimeFormatLst();	

	public class LoginContentURLTxt extends Element
	{
		public LoginContentURLTxt()
		{
			setElement(readAppData(this));
		}
	}
	public LoginContentURLTxt loginContentURLTxt = new LoginContentURLTxt();

	public class PortalURLTxt extends Element
	{
		public PortalURLTxt()
		{
			setElement(readAppData(this));
		}
	}
	public PortalURLTxt portalURLTxt = new PortalURLTxt();

	public class HomeURLTxt extends Element
	{
		public HomeURLTxt()
		{
			setElement(readAppData(this));
		}
	}
	public HomeURLTxt homeURLTxt = new HomeURLTxt();

	public class SupportURLTxt extends Element
	{
		public SupportURLTxt()
		{
			setElement(readAppData(this));
		}
	}
	public SupportURLTxt supportURLTxt = new SupportURLTxt();

	public class NewsURLTxt extends Element
	{
		public NewsURLTxt()
		{
			setElement(readAppData(this));
		}
	}
	public NewsURLTxt newsURLTxt = new NewsURLTxt();

	public class PhoneNumberTxt extends Element
	{
		public PhoneNumberTxt()
		{
			setElement(readAppData(this));
		}
	}
	public PhoneNumberTxt phoneNumberTxt = new PhoneNumberTxt();

	public class FaxTxt extends Element
	{
		public FaxTxt()
		{
			setElement(readAppData(this));
		}
	}
	public FaxTxt faxTxt = new FaxTxt();

	public class Address1Txt extends Element
	{
		public Address1Txt()
		{
			setElement(readAppData(this));
		}
	}
	public Address1Txt address1Txt = new Address1Txt();

	public class Address2Txt extends Element
	{
		public Address2Txt()
		{
			setElement(readAppData(this));
		}
	}
	public Address2Txt address2Txt = new Address2Txt();

	public class StateProvinceTxt extends Element
	{
		public StateProvinceTxt()
		{
			setElement(readAppData(this));
		}
	}
	public StateProvinceTxt stateProvinceTxt = new StateProvinceTxt();

	public class PostalCodeTxt extends Element
	{
		public PostalCodeTxt()
		{
			setElement(readAppData(this));
		}
	}
	public PostalCodeTxt postalCodeTxt = new PostalCodeTxt();

	public class CityTxt extends Element
	{
		public CityTxt()
		{
			setElement(readAppData(this));
		}
	}
	public CityTxt cityTxt = new CityTxt();

	public class CountryLst extends Element
	{
		public CountryLst()
		{
			setElement(readAppData(this));
		}
		public void select(String data)
		{
			super.selectVisibleText(data);
		}
	}
	public CountryLst countryLst = new CountryLst();
}
