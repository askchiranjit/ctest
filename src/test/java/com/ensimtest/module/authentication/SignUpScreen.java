package com.ensimtest.module.authentication;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class SignUpScreen extends AppData
{
	public class OrgName extends Element
	{
		public OrgName()
		{
			setElement(readAppData(this));
		}
		public boolean IsErrorDisplayed()
		{
			return isError();
		}
	}
	public OrgName orgNameTxt = new OrgName();
	
	public class Email extends Element
	{
		public Email()
		{
			setElement(readAppData(this));
		}
		public boolean IsErrorDisplayed()
		{
			return isError();
		}
	}
	public Email Email = new Email();
	
	public class ConfirmEmail extends Element
	{
		public ConfirmEmail()
		{
			setElement(readAppData(this));
		}
		public boolean IsErrorDisplayed()
		{
			return isError();
		}
	}
	public ConfirmEmail confirmEmailTxt = new ConfirmEmail();
	
	public class PhoneNo extends Element
	{
		public PhoneNo()
		{
			setElement(readAppData(this));
		}
		public boolean IsErrorDisplayed()
		{
			return isError();
		}
	}
	public PhoneNo phoneNoTxt = new PhoneNo();
	
	public class Country extends Element
	{
		public Country()
		{
			setElement(readAppData(this));
		}
		
		public void selectCountryName(String countryName)
		{
			selectValue(countryName);
		}
	}
	public Country countryList = new Country();
	
	public class StateProvince extends Element
	{
		public StateProvince()
		{
			setElement(readAppData(this));
		}
		public boolean IsErrorDisplayed()
		{
			return isError();
		}
	}
	public StateProvince stateProvinceTxt = new StateProvince();
	
	public class PreferredLanguage extends Element
	{
		public PreferredLanguage()
		{
			setElement(readAppData(this));
		}
		public void selectLanguage(String language)
		{
			selectValue(language);
		}
	}
	public PreferredLanguage preferredLanguageList = new PreferredLanguage();
	
	public class ZipCode extends Element
	{
		public ZipCode()
		{
			setElement(readAppData(this));
		}
		public boolean IsErrorDisplayed()
		{
			return isError();
		}
	}
	public ZipCode zipCodeTxt = new ZipCode();
	
	public class City extends Element
	{
		public City()
		{
			setElement(readAppData(this));
		}
		public boolean IsErrorDisplayed()
		{
			return isError();
		}
	}
	public City cityTxt = new City();
	
	public class CorporateId extends Element
	{
		public CorporateId()
		{
			setElement(readAppData(this));
		}
	}
	public CorporateId corporateIdTxt = new CorporateId();
	
	public class AgreeTermsAndConditionChkBox extends Element
	{
		public AgreeTermsAndConditionChkBox()
		{
			setElement(readAppData(this));
		}
	}
	public AgreeTermsAndConditionChkBox agreeTermsCondChkBox = new AgreeTermsAndConditionChkBox();
	
	public class RegisterBtn extends Element
	{
		public RegisterBtn()
		{
			setElement(readAppData(this));
		}
	}
	public RegisterBtn registerBtn = new RegisterBtn();
}
