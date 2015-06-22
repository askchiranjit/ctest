package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class CreateOrderSelectCategory extends AppData
{
	private class TopSelectedCatagory
	{
		public String info[];
		public TopSelectedCatagory()
		{
			info = readAppData(this);
		}
	}
	
	public class Categories extends Element
	{
		public void selectCategory(String categoryname)
		{
			String info[] = readAppData(this);
			info[1] = info[1].replace("$$$$", "'" + categoryname + "'");
			setElement(info);
			try
			{
				click();
			}
			catch(Exception e)
			{
				System.out.println(e);
				TopSelectedCatagory selected = new TopSelectedCatagory();
				String []ei = {selected.info[0], selected.info[1]};
				setElement(ei);
				click();
			}
		}
	}
	public Categories categories = new Categories();
}
