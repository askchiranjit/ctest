package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class AddOrgWizardMasterAccountDetails extends AppData
{
	public class MasterAccountIDTxt extends Element
	{
		public MasterAccountIDTxt()
		{
			setElement(readAppData(this));
		}
	}
	public MasterAccountIDTxt masterAccountIDTxt = new MasterAccountIDTxt();
	
	public class MasterAccountNameTxt extends Element
	{
		public MasterAccountNameTxt()
		{
			setElement(readAppData(this));
		}
	}
	public MasterAccountNameTxt masterAccountNameTxt = new MasterAccountNameTxt();
	
	public class PaymentAgreementList extends Element
	{
		public PaymentAgreementList()
		{
			setElement(readAppData(this));
		}
		public void selectAgreement(String data)
		{
			super.selectVisibleText(data);
		}
	}
	public PaymentAgreementList paymentAgreementList = new PaymentAgreementList();
	
	public class EmailToReceiveFinancialDocTxt extends Element
	{
		public EmailToReceiveFinancialDocTxt()
		{
			setElement(readAppData(this));
		}
	}
	public EmailToReceiveFinancialDocTxt emailToReceiveFinancialDocTxt = new EmailToReceiveFinancialDocTxt();
	
	public class ADOUCreationList extends Element
	{
		public ADOUCreationList()
		{
			setElement(readAppData(this));
		}
		public void SelectCreationMethod(String method)
		{
			super.selectVisibleText(method);
		}
	}
	public ADOUCreationList adouCreationList = new ADOUCreationList();
	
	public class UsernameSuffixTxt extends Element
	{
		public UsernameSuffixTxt()
		{
			setElement(readAppData(this));
		}
	}
	public UsernameSuffixTxt usernameSuffixTxt = new UsernameSuffixTxt();

	public class UsernameSuffixLst extends Element
	{
		public UsernameSuffixLst()
		{
			setElement(readAppData(this));
		}
		public void selectSuffix(String method)
		{
			super.selectVisibleText(method);
		}
	}
	public UsernameSuffixLst usernameSuffixLst = new UsernameSuffixLst();

	public class ConfirmUsernameSuffixTxt extends Element
	{
		public ConfirmUsernameSuffixTxt()
		{
			setElement(readAppData(this));
		}
	}
	public ConfirmUsernameSuffixTxt confirmUsernameSuffixTxt = new ConfirmUsernameSuffixTxt();

	public class EnableDirSyncChk extends Element
	{
		public EnableDirSyncChk()
		{
			setElement(readAppData(this));
		}
	}
	public EnableDirSyncChk enableDirSyncChk = new EnableDirSyncChk();

	public class CorporateIdTxt extends Element
	{
		public CorporateIdTxt()
		{
			setElement(readAppData(this));
		}
	}
	public CorporateIdTxt corporateIdTxt = new CorporateIdTxt();

	public class UseOrgAddrAsAcAddrChck extends Element
	{
		public UseOrgAddrAsAcAddrChck()
		{
			setElement(readAppData(this));
		}
	}
	public UseOrgAddrAsAcAddrChck useOrgAddrAsAcAddrChck = new UseOrgAddrAsAcAddrChck();

}
