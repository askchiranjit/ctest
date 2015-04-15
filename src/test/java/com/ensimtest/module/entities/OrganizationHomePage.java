package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class OrganizationHomePage extends AppData
{
	public class AddOrgBtn extends Element
	{
		public AddOrgBtn()
		{
			setElement(readAppData(this));
		}
	}
	public AddOrgBtn addOrgBtn = new AddOrgBtn();
}
