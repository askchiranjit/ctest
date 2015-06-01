package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class ResourcesHome extends AppData 
{
	public class AddResourcesBtn extends Element
	{
		public AddResourcesBtn()
		{
			setElement(readAppData(this));
		}
	}
	public AddResourcesBtn addResourcesBtn = new AddResourcesBtn();

}
