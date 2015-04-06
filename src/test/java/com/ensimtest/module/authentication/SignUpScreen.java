package com.ensimtest.module.authentication;

import com.ensimtest.base.ElementType;
import com.ensimtest.config.Element;

public class SignUpScreen {

	public class OrgName extends Element
	{
		public OrgName()
		{
			setElement("orgName", ElementType.ID);
		}
		public boolean IsErrorDisplayed()
		{
			return IsError();
		}
	}
	public OrgName orgNameTxt = new OrgName();
	
	public class Email extends Element
	{
		public Email()
		{
			setElement("email", ElementType.ID);
		}
		public boolean IsErrorDisplayed()
		{
			return IsError();
		}
	}
	public Email Email = new Email();
	
	public class ConfirmEmail extends Element
	{
		public ConfirmEmail()
		{
			setElement("cemail", ElementType.ID);
		}
		public boolean IsErrorDisplayed()
		{
			return IsError();
		}
	}
	public ConfirmEmail confirmEmailTxt = new ConfirmEmail();
	
	public class PhoneNo extends Element
	{
		public PhoneNo()
		{
			setElement("phNo", ElementType.ID);
		}
		public boolean IsErrorDisplayed()
		{
			return IsError();
		}
	}
	public PhoneNo phoneNoTxt = new PhoneNo();
	
	public class Country extends Element
	{
		public Country()
		{
			setElement("contact_countryCode", ElementType.ID);
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
			setElement("orgName", ElementType.ID);
		}
		public boolean IsErrorDisplayed()
		{
			return IsError();
		}
	}
	public StateProvince stateProvinceTxt = new StateProvince();
	
	public class PreferredLanguage extends Element
	{
		public PreferredLanguage()
		{
			setElement("user.languageId", ElementType.ID);
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
			setElement("zip", ElementType.ID);
		}
		public boolean IsErrorDisplayed()
		{
			return IsError();
		}
	}
	public ZipCode zipCodeTxt = new ZipCode();
	
	public class City extends Element
	{
		public City()
		{
			setElement("city", ElementType.ID);
		}
		public boolean IsErrorDisplayed()
		{
			return IsError();
		}
	}
	public City cityTxt = new City();
	
	public class CorporateId extends Element
	{
		public CorporateId()
		{
			setElement("corporate_id", ElementType.ID);
		}
	}
	public CorporateId corporateIdTxt = new CorporateId();
	
	public class AgreeTermsAndConditionChkBox extends Element
	{
		public AgreeTermsAndConditionChkBox()
		{
			setElement("acceptTerms", ElementType.ID);
		}
	}
	public AgreeTermsAndConditionChkBox agreeTermsCondChkBox = new AgreeTermsAndConditionChkBox();
	
	public class RegisterBtn extends Element
	{
		public RegisterBtn()
		{
			setElement("save", ElementType.ID);
		}
	}
	public RegisterBtn registerBtn = new RegisterBtn();
	
	//xyz
	}
