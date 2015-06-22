package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class ResourcesHome extends AppData 
{
	public class ResourcesHeadingTxt extends Element
	{
		public ResourcesHeadingTxt()
		{
			setElement(readAppData(this));
		}
	}
	public ResourcesHeadingTxt resourcesHeadingTxt = new ResourcesHeadingTxt(); 
	
	public class AddResourcesBtn extends Element
	{
		public AddResourcesBtn()
		{
			setElement(readAppData(this));
		}
	}
	public AddResourcesBtn addResourcesBtn = new AddResourcesBtn();
	
	public class EditResourcesBtn extends Element
	{
		public EditResourcesBtn()
		{
			setElement(readAppData(this));
		}
	}
	public EditResourcesBtn editResourcesBtn = new EditResourcesBtn();

}
