package com.ensimtest.tests.bct;

import java.io.IOException;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.ensimtest.config.Browser;
import com.ensimtest.config.DriverSettings;
import com.ensimtest.module.authentication.LoginScreen;
import com.ensimtest.module.entities.AddAgentWizardDetails;
import com.ensimtest.module.entities.AgentHomePage;
import com.ensimtest.module.entities.EntityOptions;
import com.ensimtest.module.utility.PopUPHandler;
import com.ensimtest.resource.GetEASMessages;
import com.ensimtest.resource.PropertyReader;
import com.ensimtest.resource.TestDataProvider;
import com.ensimtest.utils.RandomData;
import com.ensimtest.utils.TestUtils;

public class SkippingTestCases 
{
	private DriverSettings settings;

	public SkippingTestCases()
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
		System.out.println("To be executed");
	}
	
	@Test
	public void sampleTest2()
	{
		System.out.println("Should not be executed");
	}
}