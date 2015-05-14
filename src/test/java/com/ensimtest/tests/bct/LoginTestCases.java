package com.ensimtest.tests.bct;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.*;
import org.testng.Assert;

import com.ensimtest.config.Browser;
import com.ensimtest.config.DriverSettings;
import com.ensimtest.module.authentication.LoginScreen;
import com.ensimtest.module.userspace.LoggedInUser;
import com.ensimtest.resource.GetEASMessages;
import com.ensimtest.resource.PropertyReader;
import com.ensimtest.resource.TestDataProvider;
import com.ensimtest.utils.TestUtils;

public class LoginTestCases
{
	private DriverSettings settings;
	private Browser browser;
	private static String baseURL;
	private static String browserName;
	private GetEASMessages getMessage=new GetEASMessages(); 
	public LoginTestCases()
	{
		settings = new DriverSettings();
		browser = new Browser();
	}
	
	@BeforeClass
	public void checkSuiteRunmode() throws IOException
	{
		TestUtils.checkSuitRunnable(this);
		PropertyReader pr=new PropertyReader();
		baseURL=pr.getURL();
		browserName=pr.getBrowserName();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		settings.setUpDriver(browserName, 10);
	}
	
	@AfterMethod
	public void tearDown()
	{
		settings.closeDriver();
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void ISPUserSuccessfulLogin(HashMap<?, ?> h) throws InterruptedException
    {
		String userName = (String) h.get("UserName");
		String passWord = (String) h.get("Password");
		
		// Navigate to ENSIM site
		browser.navigateTo(baseURL);
		// Verify user-name, password, login button are displayed
		LoginScreen loginScreen = new LoginScreen();
		
		Assert.assertEquals(true, loginScreen.username.isDisplayed());
		Assert.assertEquals(true, loginScreen.password.isDisplayed());
		Assert.assertEquals(true, loginScreen.loginBtn.isDisplayed());

		loginScreen.username.write(userName);
		loginScreen.password.write(passWord);

		// Click on login button
		loginScreen.loginBtn.click();
		
		// Verify User is logged in by viewing user context is displayed
		LoggedInUser user = new LoggedInUser();
		Assert.assertEquals(true, user.userInfo.isDisplayed());
		
		// Mouse hover on user context
		user.userInfo.mouseHover();
		
		// Click on log-out button
		user.logOut.click();
		
		// Verify logged out and redirected to login page
		Assert.assertEquals(loginScreen.username.isDisplayed(), true);
		Assert.assertEquals(loginScreen.password.isDisplayed(), true);
		Assert.assertEquals(loginScreen.loginBtn.isDisplayed(), true);
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void ISPLoginWithInvalidPswd(HashMap<?, ?> h)
	{
		String userName = (String) h.get("UserName");
		String passWord = (String) h.get("Password");
		
		// Navigate to ENSIM site
		browser.navigateTo(baseURL);
		
		// Verify user-name, password, login button are displayed
		LoginScreen loginScreen = new LoginScreen();
		Assert.assertEquals(loginScreen.username.isDisplayed(), true);
		Assert.assertEquals(loginScreen.password.isDisplayed(), true);
		Assert.assertEquals(loginScreen.loginBtn.isDisplayed(), true);
		
		// Enter user credentials
		loginScreen.username.write(userName);
		loginScreen.password.write(passWord);
		
		// Click on login button
		loginScreen.loginBtn.click();
		
		// Verify error is displayed
		String errorMsg = "User '" + userName + "' "+getMessage.getProperty("wrong_username_password");
		Assert.assertEquals(loginScreen.errorMsg.read(), errorMsg);
	}
	
	@Test
	public void NoCredentialAtLogin()
	{
		// Navigate to ENSIM site
		browser.navigateTo(baseURL);
		
		// Verify user-name, password, login button are displayed
		LoginScreen loginScreen = new LoginScreen();
		Assert.assertEquals(loginScreen.username.isDisplayed(), true);
		Assert.assertEquals(loginScreen.password.isDisplayed(), true);
		Assert.assertEquals(loginScreen.loginBtn.isDisplayed(), true);
		
		// Enter user credentials
		loginScreen.username.write("");
		loginScreen.password.write("");
		
		// Click on login button
		loginScreen.loginBtn.click();
		
		// Verify error is displayed
		Assert.assertEquals(loginScreen.username.IsErrorDisplayed(), true);
		Assert.assertEquals(loginScreen.password.IsErrorDisplayed(), true);
	}
}
