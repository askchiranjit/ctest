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
import com.ensimtest.module.authentication.SignUpScreen;
import com.ensimtest.resource.TestDataProvider;

public class LoginScreenBugVerification
{
	private Browser browser;

	@BeforeClass
	public void checkSuiteRunmode() throws IOException
	{
		//TestUtils.checkSuitRunnable(this);
		
	}

	@BeforeMethod
	public void setUp()
	{
		browser = new Browser();
		browser.navigateTo();
	}

	@AfterMethod
	public void tearDown()
	{
		browser.close();
	}

	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void verifyDefaultLanguage(HashMap<?, ?> data)
	{
		String expected = data.get("expected").toString();
		LoginScreen login = new LoginScreen();
		Assert.assertEquals(login.languageLst.getSelectedText(), expected);
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void verifyForgotPasswordText(HashMap<?, ?> data)
	{
		String expected = data.get("expected").toString();
		LoginScreen login = new LoginScreen();
		Assert.assertEquals(login.forgotPassword.read(), expected);
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void verifyResettingPassword(HashMap<?, ?> data)
	{
		String user = data.get("username").toString();
		String rpLabel = data.get("rpLabel").toString();
		String rpButton = data.get("rpButton").toString();
		LoginScreen login = new LoginScreen();
		login.forgotPassword.click();
		Assert.assertEquals(login.recoverUsernameTxt.readDefaultString(), user);
		Assert.assertEquals(login.resetPasswordHeadingLbl.read(), rpLabel);
		Assert.assertEquals(login.resetPasswordBtn.read(), rpButton);
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void verifyAgreeTermsText(HashMap<?, ?> data)
	{
		String expected = data.get("expected").toString();
		LoginScreen login = new LoginScreen();
		login.signUpBtn.click();
		SignUpScreen signUp = new SignUpScreen();
		Assert.assertEquals(signUp.agreeTermsAndConditionTxt.read().trim(), expected);
	}
	
}
