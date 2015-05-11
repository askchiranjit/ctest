package com.ensimtest.module.utility;

/**
 * This is use to handle calendar
 * @author Pratap
 *
 */

public class CalenderHandler
{
	enum Months	{January,February,March,April,May,June,July,August,September,October,November,December}
	
	public void selectDate(String date)
	{
		int temp=0;
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
		int curMonth=getMonthsNumericValue(calenderElement.monthTxt.read().trim());
		while(curYear>expYear)
		{
			temp=curMonth;
			calenderElement.previousMonth.click();
			while(temp==getMonthsNumericValue(calenderElement.monthTxt.read().trim()));
			curYear=Integer.parseInt(calenderElement.yearTxt.read().trim());
			
		}
		while(curYear<expYear)
		{
			temp=curMonth;
			calenderElement.nextMonth.click();
			while(temp==getMonthsNumericValue(calenderElement.monthTxt.read().trim()));
			curYear=Integer.parseInt(calenderElement.yearTxt.read().trim());
						
		}

		//Month section
		curMonth=getMonthsNumericValue(calenderElement.monthTxt.read().trim());
		while(curMonth>expMonth)
		{
			temp=curMonth;
			calenderElement.previousMonth.click();
			while(temp==(curMonth=getMonthsNumericValue(calenderElement.monthTxt.read().trim())));
		}
		while(curMonth<expMonth)
		{
			temp=curMonth;
			calenderElement.nextMonth.click();
			while(temp==(curMonth=getMonthsNumericValue(calenderElement.monthTxt.read().trim())));
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
