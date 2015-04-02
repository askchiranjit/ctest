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
}
