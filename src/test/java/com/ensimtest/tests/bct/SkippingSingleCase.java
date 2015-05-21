package com.ensimtest.tests.bct;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.ensimtest.config.DriverSettings;
import com.ensimtest.utils.TestUtils;

public class SkippingSingleCase 
{
	private DriverSettings settings;

	public SkippingSingleCase()
	{
		settings = new DriverSettings();
	}
	
	@BeforeClass
	public void checkSuiteRunmode() throws IOException
	{
		TestUtils.checkSuitRunnable(this);
		settings.setUpDriver();
	}

	@AfterClass
	public void tearDown()
	{
		settings.closeDriver();
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