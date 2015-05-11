package com.ensimtest.module.entities;

import com.ensimtest.resource.AppData;
import com.ensimtest.config.Element;

public class NewUser extends AppData
{
	public class UsernameTxt extends Element
	{
		public UsernameTxt()
		{
			setElement(readAppData(this));
		}
	}
	public UsernameTxt usernameTxt = new UsernameTxt();

	public class PasswordTxt extends Element
	{
		public PasswordTxt()
		{
			setElement(readAppData(this));
		}
	}
	public PasswordTxt passwordTxt = new PasswordTxt();

	public class VerifyPasswordTxt extends Element
	{
		public VerifyPasswordTxt()
		{
			setElement(readAppData(this));
		}
	}
	public VerifyPasswordTxt verifyPasswordTxt = new VerifyPasswordTxt();

	public class AccountLst extends Element
	{
		public AccountLst()
		{
			setElement(readAppData(this));
		}
	}
	public AccountLst accountLst = new AccountLst();

	public class LanguageLst extends Element
	{
		public LanguageLst()
		{
			setElement(readAppData(this));
		}
		public void select(String data)
		{
			super.selectVisibleText(data);
		}
	}
	public LanguageLst languageLst = new LanguageLst();

	public class PrimaryRoleLst extends Element
	{
		public PrimaryRoleLst()
		{
			setElement(readAppData(this));
		}
		public void select(String data)
		{
			super.selectVisibleText(data);
		}
	}
	public PrimaryRoleLst primaryRoleLst = new PrimaryRoleLst();

	public class SecondaryRolesLst extends Element
	{
		public SecondaryRolesLst()
		{
			setElement(readAppData(this));
		}
	}
	public SecondaryRolesLst secondaryRolesLst = new SecondaryRolesLst();

	public class IsdefaultBusinessContactChk extends Element
	{
		public IsdefaultBusinessContactChk()
		{
			setElement(readAppData(this));
		}
	}
	public IsdefaultBusinessContactChk isdefaultBusinessContactChk = new IsdefaultBusinessContactChk();

	public class IsdefaultTechnicalContactChk extends Element
	{
		public IsdefaultTechnicalContactChk()
		{
			setElement(readAppData(this));
		}
	}
	public IsdefaultTechnicalContactChk isdefaultTechnicalContactChk = new IsdefaultTechnicalContactChk();

	public class FirstNameTxt extends Element
	{
		public FirstNameTxt()
		{
			setElement(readAppData(this));
		}
	}
	public FirstNameTxt firstNameTxt = new FirstNameTxt();

	public class LastNameTxt extends Element
	{
		public LastNameTxt()
		{
			setElement(readAppData(this));
		}
	}
	public LastNameTxt lastNameTxt = new LastNameTxt();

	public class EmailAddressTxt extends Element
	{
		public EmailAddressTxt()
		{
			setElement(readAppData(this));
		}
	}
	public EmailAddressTxt emailAddressTxt = new EmailAddressTxt();

	public class SecondaryEmailAddressTxt extends Element
	{
		public SecondaryEmailAddressTxt()
		{
			setElement(readAppData(this));
		}
	}
	public SecondaryEmailAddressTxt secondaryEmailAddressTxt = new SecondaryEmailAddressTxt();

	public class PhoneNumberTxt extends Element
	{
		public PhoneNumberTxt()
		{
			setElement(readAppData(this));
		}
	}
	public PhoneNumberTxt phoneNumberTxt = new PhoneNumberTxt();

	public class MobileTxt extends Element
	{
		public MobileTxt()
		{
			setElement(readAppData(this));
		}
	}
	public MobileTxt mobileTxt = new MobileTxt();

	public class FaxCountryCodeTxt extends Element
	{
		public FaxCountryCodeTxt()
		{
			setElement(readAppData(this));
		}
	}
	public FaxCountryCodeTxt faxCountryCodeTxt = new FaxCountryCodeTxt();

	public class FaxAreaCodeTxt extends Element
	{
		public FaxAreaCodeTxt()
		{
			setElement(readAppData(this));
		}
	}
	public FaxAreaCodeTxt faxAreaCodeTxt = new FaxAreaCodeTxt();

	public class FaxNumberTxt extends Element
	{
		public FaxNumberTxt()
		{
			setElement(readAppData(this));
		}
	}
	public FaxNumberTxt faxNumberTxt = new FaxNumberTxt();

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

	public class CityTxt extends Element
	{
		public CityTxt()
		{
			setElement(readAppData(this));
		}
	}
	public CityTxt cityTxt = new CityTxt();

	public class StateProvinceTxt extends Element
	{
		public StateProvinceTxt()
		{
			setElement(readAppData(this));
		}
	}
	public StateProvinceTxt stateProvinceTxt = new StateProvinceTxt();

	public class ZipPostalCodeTxt extends Element
	{
		public ZipPostalCodeTxt()
		{
			setElement(readAppData(this));
		}
	}
	public ZipPostalCodeTxt zipPostalCodeTxt = new ZipPostalCodeTxt();

	public class CountryLst extends Element
	{
		public CountryLst()
		{
			setElement(readAppData(this));
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

	public class CreateUserBtn extends Element
	{
		public CreateUserBtn()
		{
			setElement(readAppData(this));
		}
	}
	public CreateUserBtn createUserBtn = new CreateUserBtn();
	
	public class UserCreatePopupText extends Element
	{
		public UserCreatePopupText()
		{
			setElement(readAppData(this));
		}
	}
	public UserCreatePopupText userCreatePopupText = new UserCreatePopupText();
	
	public class UserCreatePopupOKBtn extends Element
	{
		public UserCreatePopupOKBtn()
		{
			setElement(readAppData(this));
		}
	}
	public UserCreatePopupOKBtn userCreatePopupOKBtn = new UserCreatePopupOKBtn();
}
