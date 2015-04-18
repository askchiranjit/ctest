package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * This is for Resellers Home page
 * @author Pratap
 *
 */
public class ResellersHomePage extends AppData
{
	public class AddResellerBtn extends Element
	{
		public AddResellerBtn()
		{
			setElement(readAppData(this));
		}
	}
   public AddResellerBtn addResellerBtn=new AddResellerBtn();
}
