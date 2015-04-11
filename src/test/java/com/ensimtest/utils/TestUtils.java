package com.ensimtest.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

	//return data to a two dimentional array
	public  Object[][] getData(Xls_Reader xr,String TestCaseName)
	{
		ArrayList<String> lst=new ArrayList<String>();
		//if the sheet is not present
		if(!xr.isSheetExist(TestCaseName))
		{
			xr=null;                     //cleanup object
			return new Object[1][0];     //hypothetical object array one row no column
		}
		int row=xr.getRowCount(TestCaseName);
		int col=xr.getColumnCount(TestCaseName);
		lst=getParam(xr, TestCaseName, col);
		Object[][] data=new Object[row-1][1];
		System.out.println("3");
		for(int RowNum=2;RowNum<=row;RowNum++)
		{
			HashMap h = new HashMap();	
			for(int ColNum=1;ColNum<=col;ColNum++)
			{
				h.put(lst.get(ColNum-1),xr.getCellData(TestCaseName, ColNum, RowNum));
				//					data[RowNum-2][ColNum-1]=xr.getCellData(TestCaseName, ColNum, RowNum);
			}
			data[RowNum-2][0]=h;

		}
		lst=null;
		return data;

	}

	public ArrayList<String> getParam(Xls_Reader xr,String TestCaseName,int column_count)
	{
		ArrayList<String> lst=new ArrayList<String>();
		for(int i=1;i<=column_count;i++)
		{
			lst.add(xr.getCellData(TestCaseName,i,1));
		}
		return lst;

	}

	public  Object[][] getData1(Xls_Reader xr,String TestCaseName)
	{
		//if the sheet is not present
		if(!xr.isSheetExist(TestCaseName))
		{
			xr=null;                     //cleanup object
			return new Object[1][0];     //hypothetical object array one row no column
		}

		int row=xr.getRowCount(TestCaseName);
		int col=xr.getColumnCount(TestCaseName);
		System.out.println("2");
		Object[][] data=new Object[row-1][col];
		System.out.println("3");
		for(int RowNum=2;RowNum<=row;RowNum++)
		{
			for(int ColNum=1;ColNum<=col;ColNum++)
			{
				data[RowNum-2][ColNum-1]=xr.getCellData(TestCaseName, ColNum, RowNum);
			}

		}
		return data;	
	}




}
