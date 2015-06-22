package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class SelectCategoryCustomer extends AppData
{

	public class CategoryList extends Element
	{
		private String info[];
		public CategoryList()
		{
			this.info=readAppData(this);
		}

		public void selectCategory(String categoryName) throws Exception
		{
			boolean flag=false;
			ElementSet elementSet=new ElementSet();
			Element elementList[]=elementSet.getElementSet(info[0],info[1]);
			for(int i=0;i<elementList.length;i++)
			{
				if(elementList[i].read().trim().equalsIgnoreCase(categoryName))
				{
					elementList[i].click();
					flag=true;
					break;
				}
			}
			if(flag==false)
			{
				throw new Exception("Category :-   "+categoryName+"    Does not exists");
			}
		}

	}
	public CategoryList categoryList=new CategoryList();

}
