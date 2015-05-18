package com.ensimtest.tests.regression;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ensimtest.config.Browser;
import com.ensimtest.config.DriverSettings;
import com.ensimtest.module.authentication.LoginScreen;
import com.ensimtest.module.entities.EntityOptions;
import com.ensimtest.module.entities.SearchUser;
import com.ensimtest.module.entities.UserSearchResults;
import com.ensimtest.module.entities.UserSearchResults.UserRow;
import com.ensimtest.module.userspace.LoggedInUser;
import com.ensimtest.module.utility.PopUPHandler;
import com.ensimtest.resource.PropertyReader;
import com.ensimtest.utils.TestUtils;

public class UserStatusTestCase
{
	private DriverSettings settings;
	private Browser browser;
	private static String baseURL;
	private static String browserName;

	public UserStatusTestCase()
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
		settings.setUpDriver(browserName, 30);
	}

	@AfterMethod
	public void tearDown()
	{
		settings.closeDriver();
	}
	
	@Test
	public void deactivateUser()
	{
		browser.navigateTo(baseURL);
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write("admin");
		loginScreen.password.write("123qwe");
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
				if(rows[i].loginName.contains("autotestuser1"))
				{
					isFound = true;
					Assert.assertEquals(rows[i].actionButtonStatus, "Deactivate");
					rows[i].actionButton.click();
					
					PopUPHandler popUp = new PopUPHandler();
					Assert.assertEquals(popUp.getPopUPData.read(), "Are you sure you want to deactivate this user globally?");
					
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
	
	@Test(dependsOnMethods = { "deactivateUser" })
	public void deactivatedUserLogin()
	{
		browser.navigateTo(baseURL);
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write("autotestuser1@10000.escm.local");
		loginScreen.password.write("Independent23#");
		loginScreen.loginBtn.click();
		TestUtils.delay(1000);
		Assert.assertEquals(loginScreen.errorMsg.read(), "User autotestuser1@10000.escm.local is deactivated globally. Contact your Service Provider.");
	}
	
	@Test(dependsOnMethods = { "deactivatedUserLogin" })
	public void reactivateUser()
	{
		browser.navigateTo(baseURL);
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write("admin");
		loginScreen.password.write("123qwe");
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
				if(rows[i].loginName.contains("autotestuser1"))
				{
					isFound = true;
					Assert.assertEquals(rows[i].actionButtonStatus, "Activate");
					rows[i].actionButton.click();
					
					PopUPHandler popUp = new PopUPHandler();
					Assert.assertEquals(popUp.getPopUPData.read(), "Are you sure you want to activate this user globally?");
					
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
	
	@Test(dependsOnMethods = { "reactivateUser" })
	public void testActivatedUser()
	{
		browser.navigateTo(baseURL);
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write("autotestuser1@10000.escm.local");
		loginScreen.password.write("Independent23#");
		loginScreen.loginBtn.click();
		TestUtils.delay(1000);
		// Logged out
		LoggedInUser user = new LoggedInUser();
		user.userInfo.mouseHover();
		user.logOut.click();
		Assert.assertEquals(loginScreen.username.isExists(), true);
	}
}
