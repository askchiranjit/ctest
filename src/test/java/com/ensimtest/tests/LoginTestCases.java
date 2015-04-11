package com.ensimtest.tests;

import java.util.HashMap;

import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.SkipException;

import com.ensimtest.config.Browser;
import com.ensimtest.config.DriverSettings;
import com.ensimtest.module.authentication.LoginScreen;
import com.ensimtest.module.userspace.LoggedInUser;
import com.ensimtest.resource.TestData;
import com.ensimtest.utils.TestUtils;
import com.ensimtest.utils.Xls_Reader;
import com.ensimtest.utils.TestDataProvider;

public class LoginTestCases {
	private String suiteFilePath = "resources\\testdata\\TestSuite.xlsx";
	private DriverSettings settings;
	private Browser browser;
	public LoginTestCases()
	{
		settings = new DriverSettings();
		browser = new Browser();
	}
	
	@BeforeClass
	public void checkSuiteRunmode()
	{
		Xls_Reader xr=new Xls_Reader(suiteFilePath);
		TestUtils tu=new TestUtils();
		System.out.println("this.getClass().getSimpleName()");
		if(tu.isSuiteRunnable(xr,this.getClass().getSimpleName())==false)
		{
			xr=null;
			tu=null;
			throw new SkipException("Test Suite "+this.getClass().getSimpleName()+" is runnable for this build/test cycle");
		}
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
	
	@Test(dataProviderClass = com.ensimtest.utils.TestDataProvider.class, dataProvider="TestData")
	public void verifyISPUserSuccessfulLogin(HashMap h) throws InterruptedException
    {
		System.out.println(h.get("Name"));
		System.out.println(h.get("Roll"));
		System.out.println(h.get("Div"));
    	TestData testData = new TestData();
		
		// Navigate to ENSIM site
		browser.GoTo(testData.getISPInfo().URL);
		Thread.sleep(10000);
		System.out.println(testData.getISPInfo().URL);
		// Verify user-name, password, login button are displayed
		LoginScreen loginScreen = new LoginScreen();
		
		Assert.assertEquals(true, loginScreen.username.isDisplayed());
		Assert.assertEquals(true, loginScreen.password.isDisplayed());
//		Assert.assertEquals(true, loginScreen.loginBtn.isDisplayed());
		

		loginScreen.username.write(testData.getISPInfo().username);
		loginScreen.password.write(testData.getISPInfo().password);
		
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
		Assert.assertEquals(true, loginScreen.username.isDisplayed());
		Assert.assertEquals(true, loginScreen.password.isDisplayed());
		Assert.assertEquals(true, loginScreen.loginBtn.isDisplayed());
	}
	
	@Test(dataProviderClass = com.ensimtest.utils.TestDataProvider.class, dataProvider="TestData")
	public void verifyISPUserfailLoginWithInvalidPswd()
	{
		TestData testData = new TestData();
		
		// Navigate to ENSIM site
		browser.GoTo(testData.getISPInfo().URL);
		
		// Verify user-name, password, login button are displayed
		LoginScreen loginScreen = new LoginScreen();
		
		Assert.assertEquals(true, loginScreen.username.isDisplayed());
		Assert.assertEquals(true, loginScreen.password.isDisplayed());
		Assert.assertEquals(true, loginScreen.loginBtn.isDisplayed());
		
		// Enter user credentials
		loginScreen.username.write(testData.getISPInfo().username);
		loginScreen.password.write("testpassword");
		
		// Click on login button
		loginScreen.loginBtn.click();
		
		// Verify error is displayed
		String errorMsg = "User '" + testData.getISPInfo().username + "' does not exist or the entered password is incorrect.";
		Assert.assertEquals(loginScreen.errorMsg.read(), errorMsg);
	}
	
	@Test
	public void verifyNoCredentialAtLoginError()
	{
		TestData testData = new TestData();
	
		// Navigate to ENSIM site
		browser.GoTo(testData.getISPInfo().URL);
		
		// Verify user-name, password, login button are displayed
		LoginScreen loginScreen = new LoginScreen();
		
		Assert.assertEquals(true, loginScreen.username.isDisplayed());
		Assert.assertEquals(true, loginScreen.password.isDisplayed());
		Assert.assertEquals(true, loginScreen.loginBtn.isDisplayed());
		
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
