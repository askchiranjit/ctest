package com.ensimtest.utils;

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


}
