package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class CancelOrder extends AppData
{
	public class EndOfCurrentMonthChk extends Element
	{
		public EndOfCurrentMonthChk()
		{
			setElement(readAppData(this));
		}
	}
	public EndOfCurrentMonthChk endOfCurrentMonthChk = new EndOfCurrentMonthChk();

	public class AsSoonAsPossibleChk extends Element
	{
		public AsSoonAsPossibleChk()
		{
			setElement(readAppData(this));
		}
	}
	public AsSoonAsPossibleChk asSoonAsPossibleChk = new AsSoonAsPossibleChk();

	public class ReasonLst extends Element
	{
		public ReasonLst()
		{
			setElement(readAppData(this));
		}
	}
	public ReasonLst reasonLst = new ReasonLst();

	public class CommentsTxt extends Element
	{
		public CommentsTxt()
		{
			setElement(readAppData(this));
		}
	}
	public CommentsTxt commentsTxt = new CommentsTxt();

	public class WarningMsgLbl extends Element
	{
		public WarningMsgLbl()
		{
			setElement(readAppData(this));
		}
	}
	public WarningMsgLbl warningMsgLbl = new WarningMsgLbl();

	public class CancelBtn extends Element
	{
		public CancelBtn()
		{
			setElement(readAppData(this));
		}
	}
	public CancelBtn cancelBtn = new CancelBtn();

	public class OkBtn extends Element
	{
		public OkBtn()
		{
			setElement(readAppData(this));
		}
	}
	public OkBtn okBtn = new OkBtn();
	
	public class PopUpMsg extends Element
	{
		public PopUpMsg()
		{
			setElement(readAppData(this));
		}
	}
	public PopUpMsg popUpMsg = new PopUpMsg();
	
	public class PopUpOkBtn extends Element
	{
		public PopUpOkBtn()
		{
			setElement(readAppData(this));
		}
	}
	public PopUpOkBtn popUpOkBtn = new PopUpOkBtn();
	
	public class PopUpCancelBtn extends Element
	{
		public PopUpCancelBtn()
		{
			setElement(readAppData(this));
		}
	}
	public PopUpCancelBtn popUpCancelBtn = new PopUpCancelBtn();
}
