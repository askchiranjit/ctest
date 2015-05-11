package com.ensimtest.tests;

import java.io.IOException;

import org.testng.annotations.*;

import com.ensimtest.config.Browser;
import com.ensimtest.config.DriverSettings;
import com.ensimtest.module.authentication.LoginScreen;
import com.ensimtest.module.entities.EntityOptions;
import com.ensimtest.module.entities.SearchAgent;
import com.ensimtest.module.entities.SearchOrganization;
import com.ensimtest.module.entities.SearchResults;
import com.ensimtest.module.entities.SearchResults.OrgAgent;
import com.ensimtest.module.entities.SearchResults.OrgRow;
import com.ensimtest.module.entities.SearchMyOrganization;
import com.ensimtest.resource.GetEASMessages;
import com.ensimtest.resource.PropertyReader;
import com.ensimtest.utils.TestUtils;

public class CopyOfLoginTestCases
{
	private DriverSettings settings;
	private Browser browser;
	private static String baseURL;
	private static String browserName;
	private GetEASMessages getMessage=new GetEASMessages(); 
	public CopyOfLoginTestCases()
	{
		settings = new DriverSettings();
		browser = new Browser();
	}
	
	@BeforeClass
	public void checkSuiteRunmode() throws IOException
	{
		//TestUtils.checkSuitRunnable(this);
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
	
	/*
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
		Assert.assertEquals(true, loginScreen.username.isDisplayed());
		Assert.assertEquals(true, loginScreen.password.isDisplayed());
		Assert.assertEquals(true, loginScreen.loginBtn.isDisplayed());
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
		
		Assert.assertEquals(true, loginScreen.username.isDisplayed());
		Assert.assertEquals(true, loginScreen.password.isDisplayed());
		Assert.assertEquals(true, loginScreen.loginBtn.isDisplayed());
		
		// Enter user credentials
		loginScreen.username.write(userName);
		loginScreen.password.write(passWord);
		
		// Click on login button
		loginScreen.loginBtn.click();
		
		// Verify error is displayed
		String errorMsg = "User '" + h.get("UserName") + "' "+getMessage.getProperty("wrong_username_password");
		Assert.assertEquals(loginScreen.errorMsg.read(), errorMsg);
	}
	
	@Test
	public void NoCredentialAtLogin()
	{
			
		// Navigate to ENSIM site
		browser.navigateTo(baseURL);
		
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
	*/
	@Test
	public void NoddCredentialAtLogin()
	{
		browser.navigateTo(baseURL);
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write("admin");
		loginScreen.password.write("123qwe");
		loginScreen.loginBtn.click();
		
		EntityOptions entity = new EntityOptions();
		entity.menuBtn.mouseHover();
		entity.orglink.click();
		
		SearchOrganization searchOrg =new SearchOrganization();
		searchOrg.searchBtn.click();
		
		
		TestUtils.delay(3000);
		SearchResults searchResults = new SearchResults();

		OrgRow rows[] = searchResults.getOrgResultRows();
		System.out.println(rows[1].getOrgName());
		System.out.println(rows[1].getOrgID());
		rows[1].link.click();
		
		TestUtils.delay(1000);
		System.out.println(searchResults.previousPageBtn.isEnabled());
		//searchResults.nextPageBtn.click();
		TestUtils.delay(1000);
		
		entity.menuBtn.mouseHover();
		entity.agentlink.click();
		
		SearchAgent agent = new SearchAgent();
		agent.searchBtn.click();
		
		OrgAgent orgAgent[] = searchResults.getAgentResultRows();
		System.out.println(orgAgent[1].getOrgName());
		System.out.println(orgAgent[1].getOrgID());
		orgAgent[1].link.click();
		
		TestUtils.delay(1000);
		
	}
	
	@Test
	public void testLogin()
	{
		
		LoginScreen login = new LoginScreen();
		login.username.write("admin");
		login.password.write("123qwe");
		
		login.loginBtn.click();
		
		
		
		
		
		
	}
	
}
