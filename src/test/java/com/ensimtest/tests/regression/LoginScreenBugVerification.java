package com.ensimtest.tests.regression;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ensimtest.config.Browser;
import com.ensimtest.module.authentication.LoginScreen;
import com.ensimtest.module.authentication.SignUpScreen;

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

	@Test
	public void verifyDefaultLanguage()
	{
		LoginScreen login = new LoginScreen();
		Assert.assertEquals(login.languageLst.getSelectedText(), "Default Language");
	}
	
	@Test
	public void verifyForgotPasswordText()
	{
		LoginScreen login = new LoginScreen();
		Assert.assertEquals(login.forgotPassword.read(), "Forgot Password?");
	}
	
	@Test
	public void verifyResettingPassword()
	{
		LoginScreen login = new LoginScreen();
		login.forgotPassword.click();
		Assert.assertEquals(login.recoverUsernameTxt.readDefaultString(), "Username");
		Assert.assertEquals(login.resetPasswordHeadingLbl.read(), "Reset Password");
		Assert.assertEquals(login.resetPasswordBtn.read(), "Reset Password");
	}
	
	@Test
	public void verifyAgreeTermsText()
	{
		LoginScreen login = new LoginScreen();
		login.signUpBtn.click();
		SignUpScreen signUp = new SignUpScreen();
		Assert.assertEquals(signUp.agreeTermsAndConditionTxt.read().trim(), "I agree to the Terms & Conditions");
	}
	
}
