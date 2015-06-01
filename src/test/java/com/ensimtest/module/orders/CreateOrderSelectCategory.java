package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class CreateOrderSelectCategory extends AppData
{
	public class Categories extends Element
	{
		public void SetCategory(String categoryname)
		{
			String info[] = readAppData(this);
			info[1] = info[1].replace("$$$$", "'" + categoryname + "'");
			setElement(info);
		}
	}
	public Categories categories = new Categories();
}
