package com.ensimtest.module.utility;

import com.ensimtest.utils.TestUtils;

public class CalenderHandler
{
	enum Months	{January,February,March,April,May,June,July,August,September,October,November,December}
	public void selectDate(String date)
	{
		CalenderElements calenderElement=new CalenderElements();
		String Eliment[]=new String[2];
		Eliment[0]="Xpath";
		String s[]=date.split("/");
		int expYear=Integer.parseInt(s[2]);
		int expMonth=Integer.parseInt(s[0]);
		int expDate=Integer.parseInt(s[1]);
		int curYear=Integer.parseInt(calenderElement.yearTxt.read().trim());
		String pathDate="//table[@class='ui-datepicker-calendar']//tr//td//a[text()='";
		//year section	
		while(curYear>expYear)
		{
			calenderElement.previousMonth.click();
			TestUtils.delay(1000);
			curYear=Integer.parseInt(calenderElement.yearTxt.read().trim());
		}
		while(curYear<expYear)
		{
			calenderElement.nextMonth.click();
			TestUtils.delay(1000);
			curYear=Integer.parseInt(calenderElement.yearTxt.read().trim());
		}

		//Month section
		int curMonth=getMonthsNumericValue(calenderElement.monthTxt.read().trim());
		while(curMonth>expMonth)
		{
			calenderElement.previousMonth.click();
			TestUtils.delay(1000);
			curMonth=getMonthsNumericValue(calenderElement.monthTxt.read().trim());
		}
		while(curMonth<expMonth)
		{
			calenderElement.nextMonth.click();
			TestUtils.delay(1000);
			curMonth=getMonthsNumericValue(calenderElement.monthTxt.read().trim());
		}

		pathDate=pathDate+expDate+"']";
		Eliment[1]=pathDate;
		CalenderClickAction calenderAction=new CalenderClickAction(Eliment);
		calenderAction.click();
	}

	private int getMonthsNumericValue(String curentMont)
	{
		return  (Months.valueOf(curentMont).ordinal()+1);
	}
}
