package com.ensimtest.utils;

public class TestUtils
{
	public static void Delay(int milisec)
	{
		try
		{
			Thread.sleep(milisec);
		}
		catch (InterruptedException e)
		{
			System.out.println(e);
		}
	}

	//to check if the suite is runnable or not

	public boolean isSuiteRunnable(Xls_Reader xr,String SuiteName)
	{
		boolean flag=false;

		for(int i=2;i<=xr.getRowCount("TestSuites");i++)      //strting from two as 1st row only contains column names
		{
			if(xr.getCellData("TestSuites","TSID",i).trim().equals(SuiteName.trim()))
			{
				if(xr.getCellData("TestSuites","Runmode",i).trim().equalsIgnoreCase("Y"))
				{
					flag=true;
					break;
				}
			}
		}
		xr=null;               //to release the memory 
		return flag;

	}	
	
	
	public static boolean isTestCaseRunnable(Xls_Reader xr,String TestCaseName)
	{

		boolean flag=false;

		for(int i=2;i<=xr.getRowCount("TestCases");i++)
		{

			if(xr.getCellData("TestCases","TCID",i).trim().equals(TestCaseName.trim()))
			{
				if(xr.getCellData("TestCases","Runmode",i).trim().equalsIgnoreCase("Y"))
				{
					flag=true;
					break;
				}
			}
		}
		xr=null;               //to release the memory 
		return flag;
	}

}
