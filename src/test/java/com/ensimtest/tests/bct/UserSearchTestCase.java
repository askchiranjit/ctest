package com.ensimtest.tests.bct;

import java.io.IOException;
import java.util.HashMap;

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
import com.ensimtest.resource.PropertyReader;
import com.ensimtest.resource.TestDataProvider;
import com.ensimtest.utils.TestUtils;

public class UserSearchTestCase
{
	private DriverSettings settings;
	private Browser browser;
	private static String baseURL;
	private static String browserName;

	public UserSearchTestCase()
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
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void lookforUser(HashMap<?, ?> testData)
	{
		// Getting the values
		String _username = (String)testData.get("username");
		String _password = (String)testData.get("password");
		String _loginName = (String)testData.get("loginName");
		String _firstName = (String)testData.get("firstName");
		String _lastName = (String)testData.get("lastName");
		String _email = (String)testData.get("email");
		String _btnStatus = (String)testData.get("buttonStatus");
		
		browser.navigateTo(baseURL);
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write(_username);
		loginScreen.password.write(_password);
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
				if(rows[i].loginName.contains(_loginName))
				{
					isFound = true;
					Assert.assertEquals(rows[i].loginName, _loginName);
					Assert.assertEquals(rows[i].name, _firstName + " " + _lastName);
					Assert.assertEquals(rows[i].primaryEmail, _email);
					Assert.assertEquals(rows[i].actionButtonStatus, _btnStatus);
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
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void searchLoginName()
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
		user.logInNameTxt.write("autotestuser1");
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
					Assert.assertEquals(rows[i].loginName, "autotestuser1@10000.escm.local");
					Assert.assertEquals(rows[i].name, "autoTestF1" + " " + "autoTestL1");
					Assert.assertEquals(rows[i].primaryEmail, "ensimautotest@outlook.com");
					Assert.assertEquals(rows[i].actionButtonStatus, "Deactivate");
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
		Assert.assertEquals(loginScreen.password.isExists(), true);
		Assert.assertEquals(loginScreen.loginBtn.isExists(), true);
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void searchFirstName()
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
		user.firstNameTxt.write("autoTestF1");
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
					Assert.assertEquals(rows[i].loginName, "autotestuser1@10000.escm.local");
					Assert.assertEquals(rows[i].name, "autoTestF1" + " " + "autoTestL1");
					Assert.assertEquals(rows[i].primaryEmail, "ensimautotest@outlook.com");
					Assert.assertEquals(rows[i].actionButtonStatus, "Deactivate");
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
		Assert.assertEquals(loginScreen.password.isExists(), true);
		Assert.assertEquals(loginScreen.loginBtn.isExists(), true);
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void searchLastName()
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
		user.lastNameTxt.write("autoTestL1");
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
					Assert.assertEquals(rows[i].loginName, "autotestuser1@10000.escm.local");
					Assert.assertEquals(rows[i].name, "autoTestF1" + " " + "autoTestL1");
					Assert.assertEquals(rows[i].primaryEmail, "ensimautotest@outlook.com");
					Assert.assertEquals(rows[i].actionButtonStatus, "Deactivate");
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
		Assert.assertEquals(loginScreen.password.isExists(), true);
		Assert.assertEquals(loginScreen.loginBtn.isExists(), true);
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void searchEmail()
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
		user.emailAddressTxt.write("ensimautotest@outlook.com");
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
					Assert.assertEquals(rows[i].loginName, "autotestuser1@10000.escm.local");
					Assert.assertEquals(rows[i].name, "autoTestF1" + " " + "autoTestL1");
					Assert.assertEquals(rows[i].primaryEmail, "ensimautotest@outlook.com");
					Assert.assertEquals(rows[i].actionButtonStatus, "Deactivate");
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
		Assert.assertEquals(loginScreen.password.isExists(), true);
		Assert.assertEquals(loginScreen.loginBtn.isExists(), true);
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void searchAll()
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
		user.logInNameTxt.write("autotestuser1");
		user.firstNameTxt.write("autoTestF1");
		user.lastNameTxt.write("autoTestL1");
		user.emailAddressTxt.write("ensimautotest@outlook.com");
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
					Assert.assertEquals(rows[i].loginName, "autotestuser1@10000.escm.local");
					Assert.assertEquals(rows[i].name, "autoTestF1" + " " + "autoTestL1");
					Assert.assertEquals(rows[i].primaryEmail, "ensimautotest@outlook.com");
					Assert.assertEquals(rows[i].actionButtonStatus, "Deactivate");
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
		Assert.assertEquals(loginScreen.password.isExists(), true);
		Assert.assertEquals(loginScreen.loginBtn.isExists(), true);
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void testResetWithAllData()
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
		user.logInNameTxt.write("autotestuser1");
		user.firstNameTxt.write("autoTestF1");
		user.lastNameTxt.write("autoTestL1");
		user.emailAddressTxt.write("ensimautotest@outlook.com");
		user.resetBtn.click();
		TestUtils.delay(1000);
		
		// Logged out
		LoggedInUser userLogg = new LoggedInUser();
		userLogg.userInfo.mouseHover();
		userLogg.logOut.click();
		Assert.assertEquals(loginScreen.username.isExists(), true);
		Assert.assertEquals(loginScreen.password.isExists(), true);
		Assert.assertEquals(loginScreen.loginBtn.isExists(), true);
	}
}
