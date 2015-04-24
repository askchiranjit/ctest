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
import com.ensimtest.resource.GetEASMessages;
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
	private RandomData Rd=new RandomData();
	private GetEASMessages getMessage=new GetEASMessages();

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
		Assert.assertEquals(alertMessage,getMessage.getProperty("sucessful_selfregistration_message"));
		
		// Verify in Login page
		LoginScreen loginPage = new LoginScreen();
		Assert.assertEquals(loginPage.username.isExists(), true);
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void selfRegWithDuplicateEmail(HashMap<?, ?> testData)
	{
		// Generating random values
		String orgName=Rd.getRandomAlfaNumeric(6);
		//Get test data from data provider
		String duplicateEmail=testData.get("duplicateEmail").toString();
	   // Open the browser and goto site
		browser.navigateTo(baseURL);
		
		// Click on sign up link
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.signUpBtn.click();
		
		// Enter details
		SignUpScreen signUpScreen=new SignUpScreen();
		TestUtils.delay(2000);
		signUpScreen.orgNameTxt.write(orgName);
		signUpScreen.Email.write(duplicateEmail);
		signUpScreen.confirmEmailTxt.click();
		TestUtils.delay(5000);
		Assert.assertEquals(signUpScreen.popupMessage.read().trim(),getMessage.getProperty("duplicate_email_selfristration"));
		
	}
	
	@Test
	public void signupValidations()
	{
		browser.navigateTo(baseURL);
		// Generating random values
		String orgName=Rd.getRandomString(4);
		String email=Rd.getRandomEmailID();
		String phNo=Rd.getRandomNum(12);
		String zipCode=Rd.getRandomNum(6);
		String state=Rd.getRandomString(3);
		String city=Rd.getRandomString(3);
		// Click on sign up link
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.signUpBtn.click();
		
		// Enter details
		SignUpScreen signUpScreen=new SignUpScreen();
		TestUtils.delay(2000);
		signUpScreen.agreeTermsCondChkBox.click();
		signUpScreen.registerBtn.click();
		TestUtils.delay(2000);
		Assert.assertEquals(signUpScreen.orgNameTxt.IsErrorDisplayed(),true);
		Assert.assertEquals(signUpScreen.Email.IsErrorDisplayed(),true);
		Assert.assertEquals(signUpScreen.confirmEmailTxt.IsErrorDisplayed(),true);
		Assert.assertEquals(signUpScreen.phoneNoTxt.IsErrorDisplayed(),true);
		Assert.assertEquals(signUpScreen.stateProvinceTxt.IsErrorDisplayed(),true);
		Assert.assertEquals(signUpScreen.zipCodeTxt.IsErrorDisplayed(),true);
		Assert.assertEquals(signUpScreen.cityTxt.IsErrorDisplayed(),true);
		signUpScreen.orgNameTxt.write(orgName);
		Assert.assertEquals(signUpScreen.orgNameTxt.IsErrorDisplayed(),false);
		signUpScreen.Email.write(email);
		Assert.assertEquals(signUpScreen.Email.IsErrorDisplayed(),false);
		signUpScreen.Email.clear();
		TestUtils.delay(5000);
		signUpScreen.Email.write("xyzabc");
		signUpScreen.confirmEmailTxt.click();
		Assert.assertEquals(signUpScreen.popupMessage.read().trim(),getMessage.getProperty("invalide_email_format"));
		signUpScreen.popupOkBtn.click();
		Assert.assertEquals(signUpScreen.Email.IsErrorDisplayed(),false);
		signUpScreen.Email.write(email);
		signUpScreen.confirmEmailTxt.write("a@gmail.com");
		signUpScreen.phoneNoTxt.click();
		Assert.assertEquals(signUpScreen.popupMessage.read().trim(),getMessage.getProperty("conferm_email_message"));
		signUpScreen.popupOkBtn.click();
		signUpScreen.confirmEmailTxt.write(email);
		Assert.assertEquals(signUpScreen.confirmEmailTxt.IsErrorDisplayed(),false);
		signUpScreen.phoneNoTxt.write(phNo);
//		Assert.assertEquals(signUpScreen.confirmEmailTxt.IsErrorDisplayed(),false);
		signUpScreen.stateProvinceTxt.write(state);
		Assert.assertEquals(signUpScreen.stateProvinceTxt.IsErrorDisplayed(),false);
		signUpScreen.zipCodeTxt.write(zipCode);
		Assert.assertEquals(signUpScreen.zipCodeTxt.IsErrorDisplayed(),false);
		signUpScreen.cityTxt.write(city);
		Assert.assertEquals(signUpScreen.cityTxt.IsErrorDisplayed(),false);
	}

}
