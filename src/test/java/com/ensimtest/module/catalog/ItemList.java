package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class ItemList extends AppData 
{

	public class ItemSuccessMsg extends Element
	{
		public ItemSuccessMsg()
		{
			setElement(readAppData(this));
		}
	}
	
	public ItemSuccessMsg itemSuccessMsg=new ItemSuccessMsg();
	
	
	public class EditItemBtn extends Element
	{
		public EditItemBtn()
		{
			setElement(readAppData(this));
		}
	}
	
	public EditItemBtn editItemBtn=new EditItemBtn();
	
	
	
}
