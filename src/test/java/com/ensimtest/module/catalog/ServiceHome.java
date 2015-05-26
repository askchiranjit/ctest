package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class ServiceHome extends AppData
{
	public class AddServiceBtn extends Element
	{
		public AddServiceBtn()
		{
			setElement(readAppData(this));
		}
	}
	public AddServiceBtn addServiceBtn = new AddServiceBtn();

	public class ImportServiceBtn extends Element
	{
		public ImportServiceBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ImportServiceBtn importServiceBtn = new ImportServiceBtn();
	
	public class EditServiceBtn extends Element
	{
		public EditServiceBtn()
		{
			setElement(readAppData(this));
		}
	}
	public EditServiceBtn editServiceBtn = new EditServiceBtn();
}
