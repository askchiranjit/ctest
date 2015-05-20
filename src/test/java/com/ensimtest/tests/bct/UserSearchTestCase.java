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
		TestUtils.checkSuitRunnable(this);
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
			if(results.nextPageBtn.isEnabled()==false)
				break;
		}
		Assert.assertEquals(isFound, true);
		// Logged out
		LoggedInUser userLogg = new LoggedInUser();
		userLogg.userInfo.mouseHover();
		userLogg.logOut.click();
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void searchLoginName(HashMap<?, ?> testData)
	{
		// Getting the values
		String _username = (String)testData.get("username");
		String _password = (String)testData.get("password");
		String _loginName = (String)testData.get("loginName");
		String _firstName = (String)testData.get("firstName");
		String _lastName = (String)testData.get("lastName");
		String _email = (String)testData.get("email");
		String _btnStatus = (String)testData.get("buttonStatus");
		String _shortLoginName = (String)testData.get("shortLoginName");
				
		browser.navigateTo(baseURL);
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write(_username);
		loginScreen.password.write(_password);
		loginScreen.loginBtn.click();
		EntityOptions entity = new EntityOptions();
		entity.menuBtn.mouseHover();
		entity.usersLnk.click();
		SearchUser user = new SearchUser();
		user.logInNameTxt.write(_shortLoginName);
		user.searchBtn.click();
		TestUtils.delay(3000);
		UserSearchResults results = new UserSearchResults();
		boolean isFound = false;
		while(true)
		{
			UserRow []rows = results.getUserResultRows();
			for(int i= 0; i<rows.length; i++)
			{
				if(rows[i].loginName.contains(_shortLoginName))
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
			if(results.nextPageBtn.isEnabled()==false)
				break;
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
	public void searchFirstName(HashMap<?, ?> testData)
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
		user.firstNameTxt.write(_firstName);
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
			if(results.nextPageBtn.isEnabled()==false)
				break;
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
	public void searchLastName(HashMap<?, ?> testData)
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
		user.lastNameTxt.write(_lastName);
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
			if(results.nextPageBtn.isEnabled()==false)
				break;
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
	public void searchEmail(HashMap<?, ?> testData)
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
			if(results.nextPageBtn.isEnabled()==false)
				break;
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
	public void searchAll(HashMap<?, ?> testData)
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
		user.logInNameTxt.write(_loginName);
		user.firstNameTxt.write(_firstName);
		user.lastNameTxt.write(_lastName);
		user.emailAddressTxt.write(_email);
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
			if(results.nextPageBtn.isEnabled()==false)
				break;
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
	public void testResetWithAllData(HashMap<?, ?> testData)
	{
		// Getting the values
		String _username = (String)testData.get("username");
		String _password = (String)testData.get("password");
		String _loginName = (String)testData.get("loginName");
		String _firstName = (String)testData.get("firstName");
		String _lastName = (String)testData.get("lastName");
		String _email = (String)testData.get("email");
				
		browser.navigateTo(baseURL);
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write(_username);
		loginScreen.password.write(_password);
		loginScreen.loginBtn.click();
		EntityOptions entity = new EntityOptions();
		entity.menuBtn.mouseHover();
		entity.usersLnk.click();
		SearchUser user = new SearchUser();
		user.logInNameTxt.write(_loginName);
		user.firstNameTxt.write(_firstName);
		user.lastNameTxt.write(_lastName);
		user.emailAddressTxt.write(_email);
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
