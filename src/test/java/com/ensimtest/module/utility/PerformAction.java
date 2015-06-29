package com.ensimtest.module.utility;

import com.ensimtest.config.Element;
import com.ensimtest.utils.TestUtils;

public class PerformAction 
{

	public void doActionOnElement(Element e,String type,String value)
	{

		switch(type)
		{
		case "textbox":
			e.clear();
			e.write(value);
			break;

		case "checkbox":
			e.click();
			break;

		case "dropdown":
			e.selectVisibleText(value);

		}


	}


	
}
