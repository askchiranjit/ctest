package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;
/**
 * This is for Agent creation page
 * @author Pratap
 *
 */
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

	public class BoxNumberTxt extends Element
	{
		public BoxNumberTxt()
		{
			setElement(readAppData(this));
		}
	}
	public BoxNumberTxt boxNumberTxt = new BoxNumberTxt();

	public class StreetTxt extends Element
	{
		public StreetTxt()
		{
			setElement(readAppData(this));
		}
	}
	public StreetTxt streetTxt = new StreetTxt();

	public class CityTxt extends Element
	{
		public CityTxt()
		{
			setElement(readAppData(this));
		}
	}
	public CityTxt cityTxt = new CityTxt();

	public class AddressNumberTxt extends Element
	{
		public AddressNumberTxt()
		{
			setElement(readAppData(this));
		}
	}
	public AddressNumberTxt addressNumberTxt = new AddressNumberTxt();

	public class PostalCodeTxt extends Element
	{
		public PostalCodeTxt()
		{
			setElement(readAppData(this));
		}
	}
	public PostalCodeTxt postalCodeTxt = new PostalCodeTxt();

	public class CountryLst extends Element
	{
		public CountryLst()
		{
			setElement(readAppData(this));
		}

		public void selectCountry(String countryName)
		{
			super.selectVisibleText(countryName);
		}
	}
	public CountryLst countryLst = new CountryLst();

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

	public class UPNErrorImage extends Element
	{
		public UPNErrorImage()
		{
			setElement(readAppData(this));
		}
	}
	public UPNErrorImage upnErrorImage = new UPNErrorImage();

	public class UPNExistsImage extends Element
	{
		public UPNExistsImage()
		{
			setElement(readAppData(this));
		}
	}
	public UPNExistsImage upnExistsImage = new UPNExistsImage();


}
