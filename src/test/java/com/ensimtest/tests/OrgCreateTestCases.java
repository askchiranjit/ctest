package com.ensimtest.tests;

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
import com.ensimtest.module.entities.AddOrgWizardMasterAccountDetails;
import com.ensimtest.module.entities.AddOrgWizardMasterControls;
import com.ensimtest.module.entities.AddOrgWizardOrgDetails;
import com.ensimtest.module.entities.AddOrgWizardSummary;
import com.ensimtest.module.entities.EntityOptions;
import com.ensimtest.module.entities.OrganizationHomePage;
import com.ensimtest.module.userspace.LoggedInUser;
import com.ensimtest.resource.PropertyReader;
import com.ensimtest.resource.TestDataProvider;
import com.ensimtest.utils.RandomData;
import com.ensimtest.utils.TestUtils;

public class OrgCreateTestCases 
{
	
	private DriverSettings settings;
	private Browser browser;
	private static String baseURL;
	private static String browserName;
	RandomData Rd=new RandomData();

	public OrgCreateTestCases()
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
	public void createOrgTest1(HashMap<?, ?> testData)
	{
		// Test pre-requisite data setting up
		RandomData rData = new RandomData();
		String _orgName = rData.getRandomString(6);
		String _emailAddress = rData.getRandomEmailID();
		String _masterAcName = rData.getRandomString(5);
		String _custField4 = rData.getRandomAlfaNumeric(5);
		String commLanguage = testData.get("commLanguage").toString();
		String billLanguage = testData.get("billLanguage").toString();
		String paymentAgreement = testData.get("paymentAgreement").toString();
		String macroSeg = testData.get("macroSeg").toString();
		String dateTimeFormat = testData.get("dateTimeFormat").toString();
		String country = testData.get("country").toString();
				
		// Go to the site
		browser.navigateTo(baseURL);
		
		// Verify in login page
		LoginScreen loginScreen = new LoginScreen();
		Assert.assertEquals(true, loginScreen.username.isDisplayed());
		Assert.assertEquals(true, loginScreen.password.isDisplayed());
		Assert.assertEquals(true, loginScreen.loginBtn.isDisplayed());
		
		// Enter ISP credentials
		String username = testData.get("UserName").toString();
		String password = testData.get("password").toString();
		
		loginScreen.username.write(username);
		loginScreen.password.write(password);
		
		// Click Login button
		loginScreen.loginBtn.click();

		// Select Organizations from Entity
		EntityOptions entity = new EntityOptions();
		entity.menuBtn.mouseHover();
		entity.orglink.click();
		
		// Verify add Org. button exists
		OrganizationHomePage orgHome = new OrganizationHomePage();
		Assert.assertEquals(orgHome.addOrgBtn.isExists(), true);
		
		// Click on Add Organization button
		orgHome.addOrgBtn.click();
		
		// Enter details in Details page
		AddOrgWizardOrgDetails details = new AddOrgWizardOrgDetails();
		details.organizationNameTxt.write(_orgName);
		details.vatNumberTxt.write(rData.getRandomString(4));
		details.macroSegmentList.selectMacroSegment(macroSeg);
		details.emailAddessTxt.write(_emailAddress);
		details.communicationLanguageList.selectLanguage(commLanguage);
		details.billingLanguageList.selectLanguage(billLanguage);
		details.dateTimeFormatList.selectFormat(dateTimeFormat);
		details.customField4Txt.write(_custField4);
		details.countryList.selectCountry(country);
		
		// Verify buttons available
		AddOrgWizardMasterControls controls = new AddOrgWizardMasterControls();
		Assert.assertEquals(controls.continueBtn.isExists(), true);
		Assert.assertEquals(controls.cancelBtn.isExists(), true);
		
		// Click on Continue
		controls.continueBtn.click();
		
		// Enter Master-Account details
		AddOrgWizardMasterAccountDetails masterAc = new AddOrgWizardMasterAccountDetails();
		masterAc.masterAccountNameTxt.write(_masterAcName);
		masterAc.paymentAgreementList.selectAgreement(paymentAgreement);
		
		// Verify buttons are displayed
		Assert.assertEquals(controls.goBackBtn.isExists(), true);
		Assert.assertEquals(controls.continueBtn.isExists(), true);
		Assert.assertEquals(controls.cancelBtn.isExists(), true);
		
		// Click on Continue
		Assert.assertEquals(controls.continueBtn.isExists(), true);
		controls.continueBtn.click();
		TestUtils.delay(5000);
		
		// Verify details in summary page
		AddOrgWizardSummary summary = new AddOrgWizardSummary();
		Assert.assertEquals(summary.orgNameLbl.read(), _orgName);
		Assert.assertEquals(summary.emailAddrForCorrespondanceLbl.read(), _emailAddress);
		Assert.assertEquals(summary.communicationLanguageLbl.read(), commLanguage);
		Assert.assertEquals(summary.billingLanguageLbl.read(), billLanguage);
		Assert.assertEquals(summary.masterAccountNameLbl.read(), _masterAcName);
		Assert.assertEquals(summary.paymentAgreementLbl.read(), paymentAgreement);
		
		// Verify buttons are displayed
		Assert.assertEquals(controls.goBackBtn.isExists(), true);
		Assert.assertEquals(controls.saveBtn.isExists(), true);
		Assert.assertEquals(controls.cancelBtn.isExists(), true);
		
		// Click on Save
		controls.saveBtn.click();
		TestUtils.delay(3000);
		
		// Verify the alert message
		// TODO : GRAMMER ERROR
		// String s = summary.createSuccessAlert.read();
		//Assert.assertEquals(s, "Organization " + _orgName + " created successfully.");
		summary.createSuccessAlertOkBtn.click();
		
		// Logout
		LoggedInUser user = new LoggedInUser();
		user.userInfo.mouseHover();
		user.logOut.click();
		
		// Verify login page is displayed
		Assert.assertEquals(true, loginScreen.username.isDisplayed());
		Assert.assertEquals(true, loginScreen.password.isDisplayed());
		Assert.assertEquals(true, loginScreen.loginBtn.isDisplayed());
	}
	

}
