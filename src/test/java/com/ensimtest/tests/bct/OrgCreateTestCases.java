package com.ensimtest.tests.bct;

import java.io.IOException;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.ensimtest.config.Browser;
import com.ensimtest.config.DriverSettings;
import com.ensimtest.module.authentication.LoginScreen;
import com.ensimtest.module.entities.AddOrgWizardMasterAccountDetails;
import com.ensimtest.module.entities.AddOrgWizardMasterControls;
import com.ensimtest.module.entities.AddOrgWizardOrgDetails;
import com.ensimtest.module.entities.AddOrgWizardSummary;
import com.ensimtest.module.entities.EntityOptions;
import com.ensimtest.module.entities.NewUser;
import com.ensimtest.module.entities.OrganizationDetailsButtons;
import com.ensimtest.module.entities.OrganizationHomePage;
import com.ensimtest.module.entities.SearchOrganization;
import com.ensimtest.module.entities.SearchResults;
import com.ensimtest.module.entities.SearchResults.OrgRow;
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
	String _orgName = "";

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
		settings.setUpDriver(browserName, 30);
	}

	@AfterClass
	public void tearDown()
	{
		settings.closeDriver();
	}


	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void createOrgTest1(HashMap<?, ?> testData)
	{
		// Test pre-requisite data setting up
		RandomData rData = new RandomData();
		_orgName = rData.getRandomString(6);
		String _emailAddress = rData.getRandomEmailID();
		String _masterAcName = rData.getRandomString(5);
		String _customFieldData = rData.getRandomAlfaNumeric(5);
		String _vatNumber = rData.getRandomString(4);
		String commLanguage = testData.get("commLanguage").toString();
		String billLanguage = testData.get("billLanguage").toString();
		String paymentAgreement = testData.get("paymentAgreement").toString();
		String macroSeg = testData.get("macroSeg").toString();
		String dateTimeFormat = testData.get("dateTimeFormat").toString();
		String country = testData.get("country").toString();
		String username = testData.get("UserName").toString();
		String password = testData.get("password").toString();
		String _userSuffix = rData.getRandomString(3) + "." + rData.getRandomString(3);
				
		// Go to the site
		browser.navigateTo(baseURL);
		
		// Verify in login page
		LoginScreen loginScreen = new LoginScreen();
		Assert.assertEquals(true, loginScreen.username.isDisplayed());
		Assert.assertEquals(true, loginScreen.password.isDisplayed());
		Assert.assertEquals(true, loginScreen.loginBtn.isDisplayed());
		
		// Enter ISP credentials
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
		details.vatNumberTxt.write(_vatNumber);
		details.macroSegmentList.selectMacroSegment(macroSeg);
		details.emailAddessTxt.write(_emailAddress);
		details.communicationLanguageList.selectLanguage(commLanguage);
		details.billingLanguageList.selectLanguage(billLanguage);
		details.dateTimeFormatList.selectFormat(dateTimeFormat);
		details.customField1Txt.write(_customFieldData);
		details.customField2Txt.write(_customFieldData);
		details.customField3Txt.write(_customFieldData);
		details.customField4Txt.write(_customFieldData);
		details.customField5Txt.write(_customFieldData);
		details.customField6Txt.write(_customFieldData);
		details.customField7Txt.write(_customFieldData);
		details.customField8Txt.write(_customFieldData);
		details.customField9Txt.write(_customFieldData);
		details.customField10Txt.write(_customFieldData);
		details.customField11Txt.write(_customFieldData);
		details.customField12Txt.write(_customFieldData);
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
		masterAc.usernameSuffixTxt.write(_userSuffix);
		TestUtils.delay(1000);
//		masterAc.confirmUsernameSuffixTxt.click();
//		masterAc.confirmUsernameSuffixTxt.write(_userSuffix);
		
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
		boolean isExists = summary.createSuccessAlert.isExists();
		summary.createSuccessAlertOkBtn.click();
		Assert.assertEquals(isExists, true);
	}
	
	@Test(dependsOnMethods = { "createOrgTest1" })
	public void editOrgTest()
	{
		RandomData rData = new RandomData();
		_orgName = rData.getRandomString(6);
		String _emailAddress = rData.getRandomEmailID();
		
		// Click the edit button
		OrganizationDetailsButtons buttons = new OrganizationDetailsButtons();
		buttons.editBtn.click();
		
		// Change the data
		// Edit details in Details page
		AddOrgWizardOrgDetails details = new AddOrgWizardOrgDetails();
		details.organizationNameTxt.clear();
		details.organizationNameTxt.write(_orgName);
		details.emailAddessTxt.clear();
		details.emailAddessTxt.write(_emailAddress);
		
		// Goto next button
		AddOrgWizardMasterControls controls = new AddOrgWizardMasterControls();
		controls.continueBtn.click();
		TestUtils.delay(3000);
		
		// Goto summary page
		controls.continueBtn.click();
		TestUtils.delay(3000);
		
		// Verify in summary page
		AddOrgWizardSummary summary = new AddOrgWizardSummary();
		Assert.assertEquals(summary.orgNameLbl.read(), _orgName);
		Assert.assertEquals(summary.emailAddrForCorrespondanceLbl.read(), _emailAddress);
		
		// Save
		controls.saveBtn.click();
		TestUtils.delay(3000);
		boolean isPopUp = summary.createSuccessAlert.isDisplayed();
		summary.createSuccessAlertOkBtn.click();
		Assert.assertEquals(isPopUp, true);
	}
	
	@Test(dependsOnMethods = { "editOrgTest" })
	public void addOrgUserTest()
	{
		RandomData rData = new RandomData();
		String _username = rData.getRandomString(5);
		String _password = "P@" + rData.getRandomAlfaNumeric(4);
		// String role = "Organization Super Admin";
		String _firstName = rData.getRandomString(5);
		String _lastName = rData.getRandomString(5);
		String _email = rData.getRandomEmailID();
		
		OrganizationDetailsButtons buttons = new OrganizationDetailsButtons();
		buttons.addUserBtn.click();
		TestUtils.delay(3000);	
		NewUser newUser = new NewUser();
		
		Assert.assertEquals(newUser.usernameTxt.isExists(), true);
		newUser.usernameTxt.write(_username);
		newUser.passwordTxt.write(_password);
		newUser.verifyPasswordTxt.write(_password);
		newUser.languageLst.select("English (US)");
		newUser.primaryRoleLst.select("Organization Business & Technical Contact");
		
		newUser.firstNameTxt.write(_firstName);
		newUser.lastNameTxt.write(_lastName);
		newUser.emailAddressTxt.write(_email);
		
		newUser.createUserBtn.click();
		
		TestUtils.delay(3000);
		
		Assert.assertEquals(newUser.userCreatePopupText.isExists(), true);
		Assert.assertEquals(newUser.userCreatePopupOKBtn.isExists(), true);
		
		newUser.userCreatePopupOKBtn.click();
		
		LoggedInUser user = new LoggedInUser();
		Assert.assertEquals(true, user.userInfo.isDisplayed());
	}
	
	@Test(dependsOnMethods = { "addOrgUserTest" })
	public void testSearchByOrg()
	{
		// Select Organizations from Entity
		EntityOptions entity = new EntityOptions();
		entity.menuBtn.mouseHover();
		entity.orglink.click();
		
		SearchOrganization searchOrg = new SearchOrganization();
		searchOrg.searchBtn.click();
		
		TestUtils.delay(3000);
		SearchResults searchResults = new SearchResults();
		OrgRow rows[] = null;
		
		boolean isOrgNameFound = false;
		while(true)
		{
			searchResults = new SearchResults();
			rows = searchResults.getOrgResultRows();
			Assert.assertEquals(rows.length <= 10, true);
			for(int i=0; i<rows.length; i++)
			{
				if(rows[i].getOrgName().equals(_orgName))
				{
					isOrgNameFound = true;
				}
			}
			if(searchResults.nextPageBtn.isEnabled()==false)
			{
				break;
			}
			else
			{
				searchResults.nextPageBtn.click();
				TestUtils.delay(2000);
			}
		}
		Assert.assertEquals(isOrgNameFound, true);
	}
	
	@Test(dependsOnMethods = { "addOrgUserTest" })
	public void testSearchByOrgKeyword()
	{
		// Select Organizations from Entity
		EntityOptions entity = new EntityOptions();
		entity.menuBtn.mouseHover();
		entity.orglink.click();
		
		SearchOrganization searchOrg = new SearchOrganization();
		searchOrg.keywordTxt.write(_orgName);
		
		searchOrg.searchBtn.click();
		
		TestUtils.delay(3000);
		SearchResults searchResults = new SearchResults();
		OrgRow rows[] = null;
		
		boolean isOrgNameFound = false;
		while(true)
		{
			searchResults = new SearchResults();
			rows = searchResults.getOrgResultRows();
			Assert.assertEquals(rows.length <= 10, true);
			for(int i=0; i<rows.length; i++)
			{
				if(rows[i].getOrgName().equals(_orgName))
				{
					isOrgNameFound = true;
				}
			}
			if(searchResults.nextPageBtn.isEnabled()==false)
			{
				break;
			}
			else
			{
				searchResults.nextPageBtn.click();
				TestUtils.delay(2000);
			}
		}
		Assert.assertEquals(isOrgNameFound, true);
	}

}
