package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class SelectAcFromOrg extends AppData
{
	public class AccountIDTxt extends Element
	{
		public AccountIDTxt()
		{
			setElement(readAppData(this));
		}
	}
	public AccountIDTxt accountIDTxt = new AccountIDTxt();

	public class AccountNameTxt extends Element
	{
		public AccountNameTxt()
		{
			setElement(readAppData(this));
		}
	}
	public AccountNameTxt accountNameTxt = new AccountNameTxt();

	public class SearchBtn extends Element
	{
		public SearchBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SearchBtn searchBtn = new SearchBtn();

	public class SelectAccountBtn extends Element
	{
		public SelectAccountBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SelectAccountBtn selectAccountBtn = new SelectAccountBtn();

	public class AccountRow extends Element
	{
		public AccountRow()
		{
			setElement(readAppData(this));
		}
	}
	public AccountRow accountRow = new AccountRow();
}
