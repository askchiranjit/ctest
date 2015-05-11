package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class SearchAgent extends AppData
{
	public class SearchByLst extends Element
	{
		public SearchByLst()
		{
			setElement(readAppData(this));
		}
	}
	public SearchByLst searchByLst = new SearchByLst();
	
	public class KeyworkTxt extends Element
	{
		public KeyworkTxt()
		{
			setElement(readAppData(this));
		}
	}
	public KeyworkTxt keyworkTxt = new KeyworkTxt();
	
	public class DeactivatedBtn extends Element
	{
		public DeactivatedBtn()
		{
			setElement(readAppData(this));
		}
	}
	public DeactivatedBtn deactivatedBtn = new DeactivatedBtn();
	
	public class SearchBtn extends Element
	{
		public SearchBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SearchBtn searchBtn = new SearchBtn();
	
}
