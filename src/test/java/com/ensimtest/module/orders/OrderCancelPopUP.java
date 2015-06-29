package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class OrderCancelPopUP extends AppData

{
 
	public class CancelBtn extends Element
	{
		public CancelBtn()
		{
			setElement(readAppData(this));
		}
	}
	
	public CancelBtn cancelBtn=new CancelBtn();
	
	public class OKBtn extends Element
	{
		public OKBtn()
		{
			setElement(readAppData(this));
		}
	}
	
	public OKBtn oKBtn=new OKBtn();
	
	public class ReasonLst extends Element
	{
		public ReasonLst()
		{
			setElement(readAppData(this));
		}
		
		public void selectReason(String reason)
		{
			super.selectVisibleText(reason);
		}
		
	}
	
	public ReasonLst reasonLst=new ReasonLst();
	
	
	public class CommentTxt extends Element
	{
		public CommentTxt()
		{
			setElement(readAppData(this));
		}
	}
	
	public CommentTxt commentTxt=new CommentTxt();

}
