package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class AddResellerBtnControl extends AppData
{
	public class CancelBtn extends Element
	{
		public CancelBtn()
		{
			setElement(readAppData(this));
		}
	}
	public CancelBtn cancelBtn=new CancelBtn();
   
	public class ContinueBtn extends Element
	{
		public ContinueBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ContinueBtn continueBtn=new ContinueBtn();
  
	public class GoBackBtn extends Element
	{
		public GoBackBtn()
		{
			setElement(readAppData(this));
		}
	}
	public GoBackBtn goBackBtn=new GoBackBtn();
	
	public class SaveBtn extends Element
	{
		public SaveBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SaveBtn saveBtn=new SaveBtn();
}
