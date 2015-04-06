package com.ensimtest.tests;

import org.testng.annotations.*;
import org.testng.Assert;
import com.ensimtest.config.Browser;
import com.ensimtest.config.DriverSettings;
import com.ensimtest.module.authentication.LoginScreen;
import com.ensimtest.module.userspace.LoggedInUser;
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
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write("admin");
		loginScreen.password.write("123qwe");
		loginScreen.loginBtn.click();
		LoggedInUser user = new LoggedInUser();
		Assert.assertEquals(true, user.userInfo.isDisplayed());
		user.userInfo.mouseHover();
		TestUtils.Delay(2000);
	}
}
