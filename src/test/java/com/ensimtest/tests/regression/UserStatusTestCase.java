package com.ensimtest.tests.regression;

import java.io.IOException;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ensimtest.config.Browser;
import com.ensimtest.module.authentication.LoginScreen;
import com.ensimtest.module.entities.EntityOptions;
import com.ensimtest.module.entities.SearchUser;
import com.ensimtest.module.entities.UserSearchResults;
import com.ensimtest.module.entities.UserSearchResults.UserRow;
import com.ensimtest.module.userspace.LoggedInUser;
import com.ensimtest.module.utility.PopUPHandler;
import com.ensimtest.resource.PropertyReader;
import com.ensimtest.resource.TestDataProvider;
import com.ensimtest.utils.TestUtils;

public class UserStatusTestCase
{
	private Browser browser;
	private static String baseURL;
	private static String browserName;

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
		browser = new Browser(browserName);
	}

	@AfterMethod
	public void tearDown()
	{
		browser.closeBrowser();
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void deactivateUser(HashMap<?, ?> testData)
	{
		// Get the data
		String username = testData.get("username").toString();
		String password = testData.get("password").toString();
		String loginname = testData.get("loginname").toString();
		String btnStatus = testData.get("btnStatus").toString();
		String msg = testData.get("msg").toString();

		browser.navigateTo(baseURL);
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write(username);
		loginScreen.password.write(password);
		loginScreen.loginBtn.click();
		
		EntityOptions entity = new EntityOptions();
		entity.menuBtn.mouseHover();
		entity.usersLnk.click();
		
		SearchUser user = new SearchUser();
		user.searchBtn.click();
		
		TestUtils.delay(3000);
		
		UserSearchResults results = new UserSearchResults();
		
		boolean isFound = false;
		while(true)
		{
			UserRow []rows = results.getUserResultRows();
			for(int i= 0; i<rows.length; i++)
			{
				if(rows[i].loginName.contains(loginname))
				{
					isFound = true;
					Assert.assertEquals(rows[i].actionButtonStatus, btnStatus);
					rows[i].actionButton.click();
					
					PopUPHandler popUp = new PopUPHandler();
					Assert.assertEquals(popUp.getPopUPData.read(), msg);
					
					popUp.acceptPopUP.click();
					
					break;
				}
			}
			if(isFound) break;
			if(results.nextPageBtn.isEnabled()==true)
				results.nextPageBtn.click();
		}
		Assert.assertEquals(isFound, true);
		// Logged out
		LoggedInUser userLogg = new LoggedInUser();
		userLogg.userInfo.mouseHover();
		userLogg.logOut.click();
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData", dependsOnMethods = { "deactivateUser" })
	public void deactivatedUserLogin(HashMap<?, ?> testData)
	{
		// Get the data
		String username = testData.get("username").toString();
		String password = testData.get("password").toString();
		String msg = testData.get("msg").toString();
		
		browser.navigateTo(baseURL);
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write(username);
		loginScreen.password.write(password);
		loginScreen.loginBtn.click();
		TestUtils.delay(1000);
		Assert.assertEquals(loginScreen.errorMsg.read(), msg);
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData", dependsOnMethods = { "deactivatedUserLogin" })
	public void reactivateUser(HashMap<?, ?> testData)
	{
		// Get the data
		String username = testData.get("username").toString();
		String password = testData.get("password").toString();
		String loginname = testData.get("loginname").toString();
		String btnStatus = testData.get("btnStatus").toString();
		String msg = testData.get("msg").toString();
		
		browser.navigateTo(baseURL);
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write(username);
		loginScreen.password.write(password);
		loginScreen.loginBtn.click();
		
		EntityOptions entity = new EntityOptions();
		entity.menuBtn.mouseHover();
		entity.usersLnk.click();
		
		SearchUser user = new SearchUser();
		user.searchBtn.click();
		
		TestUtils.delay(3000);
		
		UserSearchResults results = new UserSearchResults();
		
		boolean isFound = false;
		while(true)
		{
			UserRow []rows = results.getUserResultRows();
			for(int i= 0; i<rows.length; i++)
			{
				if(rows[i].loginName.contains(loginname))
				{
					isFound = true;
					Assert.assertEquals(rows[i].actionButtonStatus, btnStatus);
					rows[i].actionButton.click();
					
					PopUPHandler popUp = new PopUPHandler();
					Assert.assertEquals(popUp.getPopUPData.read(), msg);
					
					popUp.acceptPopUP.click();
					
					break;
				}
			}
			if(isFound) break;
			if(results.nextPageBtn.isEnabled()==true)
				results.nextPageBtn.click();
		}
		Assert.assertEquals(isFound, true);
		// Logged out
		LoggedInUser userLogg = new LoggedInUser();
		userLogg.userInfo.mouseHover();
		userLogg.logOut.click();
		Assert.assertEquals(loginScreen.username.isExists(), true);
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData", dependsOnMethods = { "reactivateUser" })
	public void testActivatedUser(HashMap<?, ?> testData)
	{
		// Get the data
		String username = testData.get("username").toString();
		String password = testData.get("password").toString();
				
		browser.navigateTo(baseURL);
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write(username);
		loginScreen.password.write(password);
		loginScreen.loginBtn.click();
		TestUtils.delay(1000);
		// Logged out
		LoggedInUser user = new LoggedInUser();
		user.userInfo.mouseHover();
		user.logOut.click();
		Assert.assertEquals(loginScreen.username.isExists(), true);
	}
}
