package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class AddOrgWizardOrgDetails extends AppData
{
	public class OrganizationIDTxt extends Element
	{
		public OrganizationIDTxt()
		{
			setElement(readAppData(this));
		}
	}
	public OrganizationIDTxt organizationIDTxt = new OrganizationIDTxt();
	
	public class OrganizationNameTxt extends Element
	{
		public OrganizationNameTxt()
		{
			setElement(readAppData(this));
		}
	}
	public OrganizationNameTxt organizationNameTxt = new OrganizationNameTxt();
	
	public class VatNumberTxt extends Element
	{
		public VatNumberTxt()
		{
			setElement(readAppData(this));
		}
	}
	public VatNumberTxt vatNumberTxt = new VatNumberTxt();
	
	public class MacroSegmentList extends Element
	{
		public MacroSegmentList()
		{
			setElement(readAppData(this));
		}
		public void selectMacroSegment(String info)
		{
			super.selectVisibleText(info);
		}
	}
	public MacroSegmentList macroSegmentList = new MacroSegmentList();
	
	public class EmailAddessTxt extends Element
	{
		public EmailAddessTxt()
		{
			setElement(readAppData(this));
		}
	}
	public EmailAddessTxt emailAddessTxt = new EmailAddessTxt();
	
	public class DomainNamesTxt extends Element
	{
		public DomainNamesTxt()
		{
			setElement(readAppData(this));
		}
	}
	public DomainNamesTxt domainNamesTxt = new DomainNamesTxt();

	public class DomainNameCheckLbl extends Element
	{
		public DomainNameCheckLbl()
		{
			setElement(readAppData(this));
		}
	}

	public class CommunicationLanguageList extends Element
	{
		public CommunicationLanguageList()
		{
			setElement(readAppData(this));
		}
		public void selectLanguage(String language)
		{
			super.selectVisibleText(language);
		}
	}
	public CommunicationLanguageList communicationLanguageList = new CommunicationLanguageList();
	
	public class BillingLanguageList extends Element
	{
		public BillingLanguageList()
		{
			setElement(readAppData(this));
		}
		public void selectLanguage(String language)
		{
			super.selectVisibleText(language);
		}
	}
	public BillingLanguageList billingLanguageList = new BillingLanguageList();

	public class DateTimeFormatList extends Element
	{
		public DateTimeFormatList()
		{
			setElement(readAppData(this));
		}
		public void selectFormat(String dateTimeFormat)
		{
			super.selectVisibleText(dateTimeFormat);
		}
	}
	public DateTimeFormatList dateTimeFormatList = new DateTimeFormatList();

	public class EnableGlobalDiscountChckBox extends Element
	{
		public EnableGlobalDiscountChckBox()
		{
			setElement(readAppData(this));
		}
	}
	public EnableGlobalDiscountChckBox enableGlobalDiscountChckBox = new EnableGlobalDiscountChckBox();
	
	public class CustomField1Txt extends Element
	{
		public CustomField1Txt()
		{
			setElement(readAppData(this));
		}
	}
	public CustomField1Txt customField1Txt = new CustomField1Txt();
	
	public class CustomField2Txt extends Element
	{
		public CustomField2Txt()
		{
			setElement(readAppData(this));
		}
	}
	public CustomField2Txt customField2Txt = new CustomField2Txt();
	
	public class CustomField3Txt extends Element
	{
		public CustomField3Txt()
		{
			setElement(readAppData(this));
		}
	}
	public CustomField3Txt customField3Txt = new CustomField3Txt();
	
	public class CustomField4Txt extends Element
	{
		public CustomField4Txt()
		{
			setElement(readAppData(this));
		}
	}
	public CustomField4Txt customField4Txt = new CustomField4Txt();
	
	public class CustomField5Txt extends Element
	{
		public CustomField5Txt()
		{
			setElement(readAppData(this));
		}
	}
	public CustomField5Txt customField5Txt = new CustomField5Txt();
	
	public class CustomField6Txt extends Element
	{
		public CustomField6Txt()
		{
			setElement(readAppData(this));
		}
	}
	public CustomField6Txt customField6Txt = new CustomField6Txt();
	
	public class CustomField7Txt extends Element
	{
		public CustomField7Txt()
		{
			setElement(readAppData(this));
		}
	}
	public CustomField7Txt customField7Txt = new CustomField7Txt();
	
	public class CustomField8Txt extends Element
	{
		public CustomField8Txt()
		{
			setElement(readAppData(this));
		}
	}
	public CustomField8Txt customField8Txt = new CustomField8Txt();
	
	public class CustomField9Txt extends Element
	{
		public CustomField9Txt()
		{
			setElement(readAppData(this));
		}
	}
	public CustomField9Txt customField9Txt = new CustomField9Txt();
	
	public class CustomField10Txt extends Element
	{
		public CustomField10Txt()
		{
			setElement(readAppData(this));
		}
	}
	public CustomField10Txt customField10Txt = new CustomField10Txt();
	
	public class CustomField11Txt extends Element
	{
		public CustomField11Txt()
		{
			setElement(readAppData(this));
		}
	}
	public CustomField11Txt customField11Txt = new CustomField11Txt();
	
	public class CustomField12Txt extends Element
	{
		public CustomField12Txt()
		{
			setElement(readAppData(this));
		}
	}
	public CustomField12Txt customField12Txt = new CustomField12Txt();
	
	public class AddressLine1Txt extends Element
	{
		public AddressLine1Txt()
		{
			setElement(readAppData(this));
		}
	}
	public AddressLine1Txt addressLine1Txt = new AddressLine1Txt();
	
	public class AddressLine2Txt extends Element
	{
		public AddressLine2Txt()
		{
			setElement(readAppData(this));
		}
	}
	public AddressLine2Txt addressLine2Txt = new AddressLine2Txt();
	
	public class CityNameTxt extends Element
	{
		public CityNameTxt()
		{
			setElement(readAppData(this));
		}
	}
	public CityNameTxt cityNameTxt = new CityNameTxt();
	
	public class CityCodeTxt extends Element
	{
		public CityCodeTxt()
		{
			setElement(readAppData(this));
		}
	}
	public CityCodeTxt cityCodeTxt = new CityCodeTxt();
	
	public class StateProvinceTxt extends Element
	{
		public StateProvinceTxt()
		{
			setElement(readAppData(this));
		}
	}
	public StateProvinceTxt stateProvinceTxt = new StateProvinceTxt();
	
	public class ZipCodeTxt extends Element
	{
		public ZipCodeTxt()
		{
			setElement(readAppData(this));
		}
	}
	public ZipCodeTxt zipCodeTxt = new ZipCodeTxt();
	
	public class CountryList extends Element
	{
		public CountryList()
		{
			setElement(readAppData(this));
		}
		public void selectCountry(String countryName)
		{
			super.selectVisibleText(countryName);
		}
	}
	public CountryList countryList = new CountryList();
}
