package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class AddAgentWizardDetails extends AppData 
{
	public class AgentNameTxt extends Element
	{
		public AgentNameTxt()
		{
			setElement(readAppData(this));
		}
	}
	public AgentNameTxt AgentNameTxt = new AgentNameTxt();

	public class VATNumberTxt extends Element
	{
		public VATNumberTxt()
		{
			setElement(readAppData(this));
		}
	}
	public VATNumberTxt VATNumberText = new VATNumberTxt();

	public class UsernameSuffixTxt extends Element
	{
		public UsernameSuffixTxt()
		{
			setElement(readAppData(this));
		}
	}
	public UsernameSuffixTxt UsernameSuffixTxt = new UsernameSuffixTxt();

	public class ConfUsernameSuffixTxt extends Element
	{
		public ConfUsernameSuffixTxt()
		{
			setElement(readAppData(this));
		}
	}
	public ConfUsernameSuffixTxt ConfUsernameSuffixTxt = new ConfUsernameSuffixTxt();
	
	public class CommunicationLanguageLst extends Element
	{
		public CommunicationLanguageLst()
		{
			setElement(readAppData(this));
		}
		
		public void selectComunicationLanguage(String comunicationLanguage)
		{
			super.selectVisibleText(comunicationLanguage);
		}
	}
	public CommunicationLanguageLst communicationLanguageLst = new CommunicationLanguageLst();

	public class BillingLanguageLst extends Element
	{
		public BillingLanguageLst()
		{
			setElement(readAppData(this));
		}
		
		public void selectBillingLanguage(String language)
		{
			super.selectVisibleText(language);
		}
	}
	public BillingLanguageLst billingLanguageLst = new BillingLanguageLst();

	public class EmailaddressTxt extends Element
	{
		public EmailaddressTxt()
		{
			setElement(readAppData(this));
		}
	}
	public EmailaddressTxt emailaddressTxt = new EmailaddressTxt();

	public class DateTimeLst extends Element
	{
		public DateTimeLst()
		{
			setElement(readAppData(this));
		}
		
		public void selectDateTimeFormat(String dateTimeFormat)
		{
			super.selectVisibleText(dateTimeFormat);
		}
	}
	public DateTimeLst dateTimeLst = new DateTimeLst();

}
