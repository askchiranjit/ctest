package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class ImportService extends AppData
{
	public class BrowseBtn extends Element
	{
		public BrowseBtn()
		{
			setElement(readAppData(this));
		}
		
	}
	public BrowseBtn browseBtn = new BrowseBtn();
	
	public class ImportBtn extends Element
	{
		public ImportBtn()
		{
			setElement(readAppData(this));
		}
		
	}
	public ImportBtn importBtn = new ImportBtn();
}
