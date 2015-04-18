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

}
