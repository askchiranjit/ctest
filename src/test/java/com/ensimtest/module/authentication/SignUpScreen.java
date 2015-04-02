package com.ensimtest.module.authentication;

import com.ensimtest.base.ElementType;
import com.ensimtest.config.Element;

public class SignUpScreen {

	public class OrgName extends Element
	{
		public OrgName()
		{
			super("orgName", ElementType.ID);
		}
	}
	public OrgName orgNameTxt = new OrgName();
	
	public class Email extends Element
	{
		public Email()
		{
			super("email", ElementType.ID);
		}
	}
	public Email Email = new Email();
	
	public class ConfirmEmail extends Element
	{
		public ConfirmEmail()
		{
			super("cemail", ElementType.ID);
		}
	}
	public ConfirmEmail confirmEmailTxt = new ConfirmEmail();
	
	public class PhoneNo extends Element
	{
		public PhoneNo()
		{
			super("phNo", ElementType.ID);
		}
	}
	public PhoneNo phoneNoTxt = new PhoneNo();
	
	public class Country extends Element
	{
		public Country()
		{
			super("contact_countryCode", ElementType.ID);
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
			super("orgName", ElementType.ID);
		}
	}
	public StateProvince stateProvinceTxt = new StateProvince();
	
	public class PreferredLanguage extends Element
	{
		public PreferredLanguage()
		{
			super("user.languageId", ElementType.ID);
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
			super("zip", ElementType.ID);
		}
	}
	public ZipCode zipCodeTxt = new ZipCode();
	
	public class City extends Element
	{
		public City()
		{
			super("city", ElementType.ID);
		}
	}
	public City cityTxt = new City();
	
	public class CorporateId extends Element
	{
		public CorporateId()
		{
			super("corporate_id", ElementType.ID);
		}
	}
	public CorporateId corporateIdTxt = new CorporateId();
	
	public class AgreeTermsAndConditionChkBox extends Element
	{
		public AgreeTermsAndConditionChkBox()
		{
			super("acceptTerms", ElementType.ID);
		}
	}
	public AgreeTermsAndConditionChkBox agreeTermsCondChkBox = new AgreeTermsAndConditionChkBox();
	
	public class RegisterBtn extends Element
	{
		public RegisterBtn()
		{
			super("save", ElementType.ID);
		}
	}
	public RegisterBtn registerBtn = new RegisterBtn();
}
