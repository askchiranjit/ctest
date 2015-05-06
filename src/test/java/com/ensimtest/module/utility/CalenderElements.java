package com.ensimtest.module.utility;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class CalenderElements extends AppData
{
	public class NextMonthBtn extends Element
	{
		public NextMonthBtn()
		{
			setElement(readAppData(this));
		}
	}
	public NextMonthBtn nextMonth = new NextMonthBtn();

	public class PreviousMonthBtn extends Element
	{
		public PreviousMonthBtn()
		{
			setElement(readAppData(this));
		}
	}
	public PreviousMonthBtn previousMonth = new PreviousMonthBtn();

	public class MonthTxt extends Element
	{
		public MonthTxt()
		{
			setElement(readAppData(this));
		}
	}
	public MonthTxt monthTxt = new MonthTxt();

	public class YearTxt extends Element
	{
		public YearTxt()
		{
			setElement(readAppData(this));
		}
	}
	public YearTxt yearTxt = new YearTxt();

}
