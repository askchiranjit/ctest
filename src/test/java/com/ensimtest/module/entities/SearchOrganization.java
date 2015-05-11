package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class SearchOrganization extends AppData
{
	public class OrganizationOfList extends Element
	{
		public OrganizationOfList()
		{
			setElement(readAppData(this));
		}
		public void select(String data)
		{
			super.selectVisibleText(data);
		}
	}
	public OrganizationOfList organizationOfList = new OrganizationOfList();
	
	public class SearchByLst extends Element
	{
		public SearchByLst()
		{
			setElement(readAppData(this));
		}
		public void select(String data)
		{
			super.selectVisibleText(data);
		}
	}
	public SearchByLst searchByLst = new SearchByLst();
	
	public class KeywordTxt extends Element
	{
		public KeywordTxt()
		{
			setElement(readAppData(this));
		}
	}
	public KeywordTxt keywordTxt = new KeywordTxt();
	
	public class StreetName extends Element
	{
		public StreetName()
		{
			setElement(readAppData(this));
		}
	}
	public StreetName streetName = new StreetName();
	
	public class CityName extends Element
	{
		public CityName()
		{
			setElement(readAppData(this));
		}
	}
	public CityName cityName = new CityName();
	
	public class ZipCode extends Element
	{
		public ZipCode()
		{
			setElement(readAppData(this));
		}
	}
	public ZipCode zipCode = new ZipCode();
	
	public class ResellerNameOrVatTxt extends Element
	{
		public ResellerNameOrVatTxt()
		{
			setElement(readAppData(this));
		}
	}
	public ResellerNameOrVatTxt resellerNameOrVatTxt = new ResellerNameOrVatTxt();
	
	public class SearchBtn extends Element
	{
		public SearchBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SearchBtn searchBtn = new SearchBtn();
	
	public class ResetBtn extends Element
	{
		public ResetBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ResetBtn resetBtn = new ResetBtn();
}
