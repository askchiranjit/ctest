package com.ensimtest.utils;

import org.testng.SkipException;

import com.ensimtest.resource.TestConfigHandler;
import com.ensimtest.resource.XLSFileReader;

public class TestUtils
{
	/**
	 * This gives a delay for milisec
	 * @param milisec : time unit in milisec
	 */
	public static void delay(int milisec)
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

	public static void checkSuitRunnable(Object className)
	{
		String suiteFilePath = "resources\\testdata\\TestSuite.xlsx";
		XLSFileReader xlsFileReader=new XLSFileReader(suiteFilePath);
		TestConfigHandler testConfigHandler=new TestConfigHandler();
		if( testConfigHandler.isSuiteRunnable(xlsFileReader, className.getClass().getSimpleName())==false)
		{
			xlsFileReader=null;
			testConfigHandler=null;
			throw new SkipException("Test Suite "+className.getClass().getSimpleName()+" is runnable for this build/test cycle");
		}
	}

}
