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
import com.ensimtest.module.entities.AddResellerBtnControl;
import com.ensimtest.module.entities.AddResellerWizardAdminUser;
import com.ensimtest.module.entities.AddResellerWizardBizModel;
import com.ensimtest.module.entities.AddResellerWizardResellerDetails;
import com.ensimtest.module.entities.AddResellerWizardSummary;
import com.ensimtest.module.entities.EntityOptions;
import com.ensimtest.module.entities.ResellersHomePage;
import com.ensimtest.module.entities.SearchReseller;
import com.ensimtest.module.entities.SearchResults;
import com.ensimtest.module.entities.SearchResults.OrgReseller;
import com.ensimtest.module.userspace.LoggedInUser;
import com.ensimtest.resource.PropertyReader;
import com.ensimtest.resource.TestDataProvider;
import com.ensimtest.utils.RandomData;
import com.ensimtest.utils.TestUtils;

public class ResellerTests
{
	private DriverSettings settings;
	private Browser browser;
	private static String baseURL;
	private static String browserName;
	//private GetEASMessages getMessage=new GetEASMessages(); 
	public ResellerTests()
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
	public void setup()
	{
		settings.setUpDriver(browserName, 10);
	}

	@AfterMethod
	public void tearDown()
	{
		settings.closeDriver();
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void addReseller(HashMap<?, ?> testData)
	{
		RandomData rData = new RandomData();
		String _userName = (String) testData.get("userName");
		String _passWord = (String) testData.get("password");
		String _type = (String) testData.get("type");
		String _resellerName = rData.getRandomString(8);
		String _vatNo = rData.getRandomString(8);
		String _email = rData.getRandomEmailID();
		String commLang = (String) testData.get("commLang");
		String billLang = (String) testData.get("billLang");
		String dateTimeFormat = (String) testData.get("dateTimeFormat");
		String country = (String) testData.get("country");
		String payment = (String) testData.get("payment");
		String firstName = rData.getRandomString(8);
		String lastName = rData.getRandomString(8);
		String resUserEmail = rData.getRandomEmailID();
		String resNameSuf = (String) testData.get("resNameSuf");
		String resUserName = rData.getRandomAlfaNumeric(4) + resNameSuf;
		String userSuffix = (String) testData.get("userSuffix");
		String currency = (String) testData.get("currency");
		String userIDMPassword = (String) testData.get("userIDMPassword");
		
				
		browser.navigateTo(baseURL);
		
		LoginScreen loginScreen = new LoginScreen();
		Assert.assertEquals(loginScreen.username.isDisplayed(), true);
		Assert.assertEquals(loginScreen.password.isDisplayed(), true);
		Assert.assertEquals(loginScreen.loginBtn.isDisplayed(), true);
		
		loginScreen.username.write(_userName);
		loginScreen.password.write(_passWord);

		// Click on login button
		loginScreen.loginBtn.click();
		
		EntityOptions entity = new EntityOptions();
		entity.menuBtn.mouseHover();
		entity.resellersLnk.click();
		
		ResellersHomePage home = new ResellersHomePage();
		home.addResellerBtn.click();
		
		AddResellerWizardResellerDetails resellerDetails = new AddResellerWizardResellerDetails();
		resellerDetails.resellerTypeLst.select(_type);
		resellerDetails.resellerNameTxt.write(_resellerName);
		resellerDetails.vATNumberTxt.write(_vatNo);
		resellerDetails.emailCorrespondenceTxt.write(_email);
		resellerDetails.emaiReceiveFinancialDocumentsTxt.write(_email);
		resellerDetails.communicationLanguageLst.selectCommunicationLanguage(commLang);
		resellerDetails.billingLanguageLst.selectBillingLanguage(billLang);
		resellerDetails.dateTimeFormatLst.selectDateTimeFormat(dateTimeFormat);
		resellerDetails.countryLst.select(country);
		
		AddResellerBtnControl btns = new AddResellerBtnControl();
		Assert.assertEquals(btns.cancelBtn.isExists(), true);
		Assert.assertEquals(btns.continueBtn.isExists(), true);
		Assert.assertEquals(btns.goBackBtn.isExists(), false);
		Assert.assertEquals(btns.saveBtn.isExists(), false);
		
		btns.continueBtn.click();
		
		AddResellerWizardBizModel bizModel = new AddResellerWizardBizModel();
		bizModel.currencyLst.select(currency);
		bizModel.paymentAgreementLst.select(payment);
		
		Assert.assertEquals(btns.cancelBtn.isExists(), true);
		Assert.assertEquals(btns.continueBtn.isExists(), true);
		Assert.assertEquals(btns.goBackBtn.isExists(), true);
		Assert.assertEquals(btns.saveBtn.isExists(), false);
		
		btns.continueBtn.click();
		
		AddResellerWizardAdminUser admin = new AddResellerWizardAdminUser();
		admin.firstNameTxt.write(firstName);
		admin.lastNameTxt.write(lastName);
		admin.emailAddressTxt.write(resUserEmail);
		admin.userNameTxt.write(resUserName);
		TestUtils.delay(2000);
		admin.passwordTxt.click();
		TestUtils.delay(2000);
		System.out.println(userIDMPassword);
		admin.passwordTxt.write(userIDMPassword);
		admin.verifyPasswordTxt.click();
		TestUtils.delay(1000);
		admin.verifyPasswordTxt.write(userIDMPassword);
		//TestUtils.delay(1000);
		Assert.assertEquals(btns.cancelBtn.isExists(), true);
		Assert.assertEquals(btns.continueBtn.isExists(), true);
		Assert.assertEquals(btns.goBackBtn.isExists(), true);
		Assert.assertEquals(btns.saveBtn.isExists(), false);
		
		btns.continueBtn.click();
		
		AddResellerWizardSummary summary = new AddResellerWizardSummary();
		System.out.println(summary.resellerNameLbl.read());
		Assert.assertEquals(summary.resellerNameLbl.read(), _resellerName);
		
		Assert.assertEquals(summary.usernameSuffixLbl.read(), userSuffix);
		Assert.assertEquals(summary.adminNameLbl.read(), firstName + " " + lastName);
		Assert.assertEquals(summary.currencyLbl.read(), currency);
		Assert.assertEquals(summary.paymentAgreementLbl.read(), payment);
		
		Assert.assertEquals(btns.cancelBtn.isExists(), true);
		Assert.assertEquals(btns.continueBtn.isExists(), false);
		Assert.assertEquals(btns.goBackBtn.isExists(), true);
		Assert.assertEquals(btns.saveBtn.isExists(), true);
		
		btns.saveBtn.click();
		
		TestUtils.delay(10 * 1000);
		Assert.assertEquals(summary.createStatus.read(), "Completed");
		
		// Click on log-out button
		LoggedInUser user = new LoggedInUser();
		user.userInfo.mouseHover();
		user.logOut.click();
		
		// Verify in login page
		Assert.assertEquals(loginScreen.username.isDisplayed(), true);
		Assert.assertEquals(loginScreen.password.isDisplayed(), true);
		Assert.assertEquals(loginScreen.loginBtn.isDisplayed(), true);
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void searchReseller(HashMap<?, ?> testData)
	{
		String userName = (String) testData.get("userName");
		String password = (String) testData.get("password");
		String resName = (String) testData.get("resName");
		browser.navigateTo(baseURL);
		
		LoginScreen loginScreen = new LoginScreen();
		Assert.assertEquals(loginScreen.username.isDisplayed(), true);
		Assert.assertEquals(loginScreen.password.isDisplayed(), true);
		Assert.assertEquals(loginScreen.loginBtn.isDisplayed(), true);
		
		loginScreen.username.write(userName);
		loginScreen.password.write(password);

		// Click on login button
		loginScreen.loginBtn.click();
		
		EntityOptions entity = new EntityOptions();
		entity.menuBtn.mouseHover();
		entity.resellersLnk.click();
		
		SearchReseller search = new SearchReseller();
		search.keywordTxt.write(resName);
		search.searchBtn.click();
		
		SearchResults results = new SearchResults();
		OrgReseller[] rows = results.getResellerResultRows();
		
		boolean isFound = false;
		for(int i=0; i<rows.length; i++)
		{
			if(rows[i].getResellerName().trim().equals(resName));
				{
					isFound = true;
					break;
				}
		}
		Assert.assertEquals(isFound, true);
		
		// Click on log-out button
		LoggedInUser user = new LoggedInUser();
		user.userInfo.mouseHover();
		user.logOut.click();
				
		// Verify in login page
		Assert.assertEquals(loginScreen.username.isDisplayed(), true);
		Assert.assertEquals(loginScreen.password.isDisplayed(), true);
		Assert.assertEquals(loginScreen.loginBtn.isDisplayed(), true);
	}
	
}
