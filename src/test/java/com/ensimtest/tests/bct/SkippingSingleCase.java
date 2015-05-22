package com.ensimtest.tests.bct;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.ensimtest.utils.TestUtils;

public class SkippingSingleCase 
{
	
	@BeforeClass
	public void checkSuiteRunmode() throws IOException
	{
		TestUtils.checkSuitRunnable(this);
	}
	
	@Test
	public void sampleTest1()
	{
		System.out.println("sampleTest1");
	}
	
	@Test
	public void sampleTest2()
	{
		System.out.println("sampleTest2");
	}
}