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
			super.selectValue(method);
		}
	}
	public ADOUCreationList adouCreationList = new ADOUCreationList();
	
}
