package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class AddResellerWizardAdminUser extends AppData
{
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

	public class UserNameTxt extends Element
	{
		public UserNameTxt()
		{
			setElement(readAppData(this));
		}
	}
	public UserNameTxt userNameTxt = new UserNameTxt();

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

	public class LanguageLst extends Element
	{
		public LanguageLst()
		{
			setElement(readAppData(this));
		}
	}
	public LanguageLst languageLst = new LanguageLst();

	public class PrimaryRoleLbl extends Element
	{
		public PrimaryRoleLbl()
		{
			setElement(readAppData(this));
		}
	}
	public PrimaryRoleLbl primaryRoleLbl = new PrimaryRoleLbl();

	public class AssignAsMemberChk extends Element
	{
		public AssignAsMemberChk()
		{
			setElement(readAppData(this));
		}
	}
	public AssignAsMemberChk assignAsMemberChk = new AssignAsMemberChk();
}
