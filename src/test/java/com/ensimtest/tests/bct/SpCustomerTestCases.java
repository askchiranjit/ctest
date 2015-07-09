package com.ensimtest.tests.bct;


import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ensimtest.config.Browser;
import com.ensimtest.module.authentication.LoginScreen;
import com.ensimtest.module.custAccount.AccountScreen;
import com.ensimtest.module.custAccount.CustUserSearchResult;
import com.ensimtest.module.custAccount.CustUserSearchResult.CustUserRow;
import com.ensimtest.module.utility.PopUPHandler;
//import com.sun.scenario.Settings;
import com.ensimtest.utils.TestUtils;

public class SpCustomerTestCases {
	private Browser browser= new Browser();

	/**
	 * This method is use to add a new user form customer login.
	 */
	
	@AfterMethod
	public void tearDown()
	{
		//browser.close();
	}
	
	@Test
	public void verifyOrgDetails()
	{
		String userName = "autocustomersuperadmin@10023.escm.local";
		String passWord = "Independent12#";
		// New User Creation Inputs
		String username="autoUser3";
		String password="Independent12#";
		String account="Master Account For autoCustomerOrg1";
		String language="English (US)";
		String primaryRole="Organization Service User";
		String firstname="autofirstname";
		String lastname="autolastname";
		String emailaddress="emailaddress@auto.test";
		
		// Navigate to ENSIM site
		browser.navigateTo("https://10.10.3.51:8443/escm/login/auth");
		// Verify user-name, password, login button are displayed
		LoginScreen loginScreen = new LoginScreen();
		AccountScreen accountScreen = new AccountScreen();
		
		Assert.assertEquals(true, loginScreen.username.isDisplayed());
		Assert.assertEquals(true, loginScreen.password.isDisplayed());
		Assert.assertEquals(true, loginScreen.loginBtn.isDisplayed());

		loginScreen.username.write(userName);
		loginScreen.password.write(passWord);

		// Click on login button
		loginScreen.loginBtn.click();
		
		Assert.assertEquals(true, accountScreen.accountMenu.isDisplayed());
		TestUtils.delay(3000);
		accountScreen.accountMenu.click();
		TestUtils.delay(3000);
		
		Assert.assertEquals(true, accountScreen.userBtn.isDisplayed());
		accountScreen.userBtn.click();
		TestUtils.delay(3000);
		
		Assert.assertEquals(true, accountScreen.addUserBtn.isDisplayed());
		accountScreen.addUserBtn.click();
		TestUtils.delay(3000);
		
		Assert.assertEquals(true, accountScreen.userNameInNewUserPageTxt.isDisplayed());
		Assert.assertEquals(true, accountScreen.passwordInNewUserPageTxt.isDisplayed());
		Assert.assertEquals(true, accountScreen.verifyPasswordInNewUserPageTxt.isDisplayed());
		
		accountScreen.userNameInNewUserPageTxt.write(username);
		accountScreen.passwordInNewUserPageTxt.write(password);
		accountScreen.verifyPasswordInNewUserPageTxt.write(password);
		accountScreen.accountInNewUserPage.write(account);
		accountScreen.languageInNewUserPage.write(language);
		accountScreen.primaryRoleInNewUserPage.write(primaryRole);
		accountScreen.firstNameInNewUserPage.write(firstname);
		accountScreen.lastNameInNewUserPage.write(lastname);
		accountScreen.emailAddressInNewUserPage.write(emailaddress);
		accountScreen.createUserBtnInNewUserPage.click();
		
		PopUPHandler popUPHandler = new PopUPHandler();
		
		popUPHandler.acceptPopUP.click();
		
	}
	
	/**
	 * This function is user to edit an existing user from customer login.
	 * Incomplete
	 */
	@Test 
	public void EditUserFromCustomerLogin()
	{
		String userName = "autocustomersuperadmin@10023.escm.local";
		String passWord = "Independent12#";
		// New User Creation Inputs
		String username="autoUser2";
		String password="Independent12#";
		String account="Master Account For autoCustomerOrg1";
		String language="English (US)";
		String primaryRole="Organization Service User";
		String firstname="autofirstname";
		String lastname="autolastname";
		String emailaddress="emailaddress@auto.test";
		
		// Navigate to ENSIM site
		browser.navigateTo("https://10.10.3.51:8443/escm/login/auth");
		// Verify user-name, password, login button are displayed
		LoginScreen loginScreen = new LoginScreen();
		AccountScreen accountScreen = new AccountScreen();
		
		Assert.assertEquals(true, loginScreen.username.isDisplayed());
		Assert.assertEquals(true, loginScreen.password.isDisplayed());
		Assert.assertEquals(true, loginScreen.loginBtn.isDisplayed());

		loginScreen.username.write(userName);
		loginScreen.password.write(passWord);

		// Click on login button
		loginScreen.loginBtn.click();
		
		Assert.assertEquals(true, accountScreen.accountMenu.isDisplayed());
		TestUtils.delay(3000);
		accountScreen.accountMenu.click();
		TestUtils.delay(3000);
		
		Assert.assertEquals(true, accountScreen.userBtn.isDisplayed());
		accountScreen.userBtn.click();
		TestUtils.delay(6000);
		
		CustUserSearchResult userSearchResult = new CustUserSearchResult();
		CustUserRow []custRows = userSearchResult.getCustomerUserRows();
		System.out.println(custRows.length);
		
		custRows[0].selectThisChk.click();
		
		
		TestUtils.delay(10000);
				
	}
	
	@Test
	public void EditOrganizationDetailsFromCustomerLogin()
	{
		String userName = "autocustomersuperadmin@10023.escm.local";
		String passWord = "Independent12#";
		// New User Creation Inputs
		String username="autoUser2";
		String password="Independent12#";
		String account="Master Account For autoCustomerOrg1";
		String language="English (US)";
		String primaryRole="Organization Service User";
		String firstname="autofirstname";
		String lastname="autolastname";
		String emailaddress="emailaddress@auto.test";
		String dateTimeFormatValue="MM/DD/YYYY 12Hrs AM/PM";
		
		// Navigate to ENSIM site
		browser.navigateTo("https://10.10.3.51:8443/escm/login/auth");
		// Verify user-name, password, login button are displayed
		LoginScreen loginScreen = new LoginScreen();
		AccountScreen accountScreen = new AccountScreen();
		
		Assert.assertEquals(true, loginScreen.username.isDisplayed());
		Assert.assertEquals(true, loginScreen.password.isDisplayed());
		Assert.assertEquals(true, loginScreen.loginBtn.isDisplayed());

		loginScreen.username.write(userName);
		loginScreen.password.write(passWord);

		// Click on login button
		loginScreen.loginBtn.click();
		
		Assert.assertEquals(true, accountScreen.accountMenu.isDisplayed());
		TestUtils.delay(3000);
		accountScreen.accountMenu.click();
		TestUtils.delay(3000);
		
		Assert.assertEquals(true, accountScreen.organizationDetailsBtn.isDisplayed());
		accountScreen.organizationDetailsBtn.click();
//		TestUtils.delay(3000);
		
		Assert.assertEquals(true, accountScreen.editOrganizationDetailsBtn.isDisplayed());
		accountScreen.editOrganizationDetailsBtn.click();
		
		Assert.assertEquals(true, accountScreen.emailAddressInEditOrgPage.isDisplayed());
		Assert.assertEquals(true, accountScreen.communicationLanguageInEditOrgPage.isDisplayed());
		Assert.assertEquals(true, accountScreen.billingLanguageInEditOrgPage.isDisplayed());
		Assert.assertEquals(true, accountScreen.dateTimeFormatInEditOrgPage.isDisplayed());
		Assert.assertEquals(true, accountScreen.saveOrgDetailsBtnInEditOrgPage.isDisplayed());
		
		accountScreen.emailAddressInEditOrgPage.clear();
		accountScreen.emailAddressInEditOrgPage.write("ensimautotest@outlook.com");
		accountScreen.communicationLanguageInEditOrgPage.write(language);
		accountScreen.billingLanguageInEditOrgPage.write(language);
		accountScreen.dateTimeFormatInEditOrgPage.write(dateTimeFormatValue);
		accountScreen.saveOrgDetailsBtnInEditOrgPage.click();
						
	}
}
