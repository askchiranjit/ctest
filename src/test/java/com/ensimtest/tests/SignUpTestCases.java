package com.ensimtest.tests;

import java.io.IOException;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ensimtest.config.AlertHandler;
import com.ensimtest.config.Browser;
import com.ensimtest.config.DriverSettings;
import com.ensimtest.module.authentication.LoginScreen;
import com.ensimtest.module.authentication.SignUpScreen;
import com.ensimtest.resource.PropertyReader;
import com.ensimtest.resource.TestDataProvider;
import com.ensimtest.utils.RandomData;
import com.ensimtest.utils.TestUtils;

public class SignUpTestCases 
{
	
	private DriverSettings settings;
	private Browser browser;
	private static String baseURL;
	private static String browserName;
	RandomData Rd=new RandomData();

	public SignUpTestCases()
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
	public void selfRegistration(HashMap<?, ?> testData)
	{
		// Get data from test-data (XLS based)
		String countyName=testData.get("countyName").toString();
		String orgName=testData.get("orgName").toString();
		String stateName=testData.get("stateName").toString();
		String language=testData.get("language").toString();
		String cityName=testData.get("cityName").toString();
		
		// Generating random values
		String Email=Rd.getRandomEmailID();
		String phno=Rd.getRandomNum(11);
		String zipCode=Rd.getRandomNum(6);
		String corporateID=Rd.getRandomAlfaNumeric(6);
		
		// Open the browser and goto site
		browser.navigateTo(baseURL);
		
		// Click on sign up link
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.signUpBtn.click();
		
		// Enter details
		SignUpScreen signUpScreen=new SignUpScreen();
		TestUtils.delay(2000);
		signUpScreen.orgNameTxt.write(orgName);
		signUpScreen.Email.write(Email);
		signUpScreen.confirmEmailTxt.write(Email);
		signUpScreen.phoneNoTxt.write(phno);
		signUpScreen.countryList.selectCountryName(countyName);
		signUpScreen.stateProvinceTxt.write(stateName);
		signUpScreen.preferredLanguageList.selectLanguage(language);
		signUpScreen.zipCodeTxt.write(zipCode);
		signUpScreen.cityTxt.write(cityName);
		signUpScreen.corporateIdTxt.write(corporateID);
		signUpScreen.agreeTermsCondChkBox.click();
		TestUtils.delay(2000);
		
		// Verify register btn exists
		Assert.assertEquals(signUpScreen.registerBtn.isEnabled(),true);
		
		// Click sign up
		signUpScreen.registerBtn.click();
		TestUtils.delay(5000);
		
		// Verify alert for successful sign up
		AlertHandler alert = new AlertHandler();
		String alertMessage = alert.getTextInAlert();
		alert.dismissAlert();
		Assert.assertEquals(alertMessage,"You have successfully registered in EAS portal. Please check your inbox for account activation link.");
		
		// Verify in Login page
		LoginScreen loginPage = new LoginScreen();
		Assert.assertEquals(loginPage.username.isExists(), true);
	}

}
