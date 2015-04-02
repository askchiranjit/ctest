package com.ensimtest.tests;

import org.testng.annotations.*;

import com.ensimtest.config.Browser;
import com.ensimtest.config.DriverSettings;
import com.ensimtest.module.authentication.LoginScreen;
import com.ensimtest.utils.TestUtils;

public class SampleTest {

	private DriverSettings settings;
	private Browser browser;
	public SampleTest()
	{
		settings = new DriverSettings();
		browser = new Browser();
	}
	
	@BeforeMethod
	public void setUp()
	{
		settings.setUpDriver("firefox", 10);
	}
	
	@AfterMethod
	public void tearDown()
	{
		settings.closeDriver();
	}
	
	@Test
	public void sampleTest()
	{
		browser.GoTo("https://10.10.3.14:8443/escm/login/auth");
		TestUtils.Delay(2000);
		
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write("sddsd");
		loginScreen.password.write("ssads");
		//loginScreen.getLogin().loginBtn.click();
		loginScreen.forgotPassword.click();
		
		
		TestUtils.Delay(2000);
	}
}
