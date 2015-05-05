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
import com.ensimtest.module.entities.AddAgentWizardDetails;
import com.ensimtest.module.entities.AgentHomePage;
import com.ensimtest.module.entities.EntityOptions;
import com.ensimtest.module.utility.PopUPHandler;
import com.ensimtest.resource.GetEASMessages;
import com.ensimtest.resource.PropertyReader;
import com.ensimtest.resource.TestDataProvider;
import com.ensimtest.utils.RandomData;
import com.ensimtest.utils.TestUtils;

public class AgentTestCases 
{
	private DriverSettings settings;
	private Browser browser;
	private static String baseURL;
	private static String browserName;
	private GetEASMessages getMessage=new GetEASMessages(); 
	private RandomData Rd=new RandomData();
	public AgentTestCases()
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
	public void addAgentUserGivenUPN(HashMap<?, ?> testData)
	{
		// Get data from test-data (XLS based)
		String userName=testData.get("userName").toString();
		String password=testData.get("password").toString();
		String agentName=testData.get("agentName").toString();
		String vatNumber=testData.get("vatNumber").toString();
		String userNameSuffix=testData.get("userNameSuffix").toString();
		String comunicationLanguage=testData.get("comunicationLanguage").toString();
		String billingLanguage=testData.get("billingLanguage").toString();
		String dataTimeFormat=testData.get("dataTimeFormat").toString();
		String boxNumber=testData.get("boxNumber").toString();
		String streetName=testData.get("streetName").toString();
		String cityName=testData.get("cityName").toString();
		String addressNumber=testData.get("addressNumber").toString();
		String postalCode=testData.get("postalCode").toString();
		String countryName=testData.get("countryName").toString();
		//Get Random data
		String email=Rd.getRandomEmailID();
		
		// Navigate to ENSIM site
		browser.navigateTo(baseURL);
		// Verify user-name, password, login button are displayed
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write(userName);
		loginScreen.password.write(password);

		// Click on login button
		loginScreen.loginBtn.click();
		
		//Click on agent link
		EntityOptions entityOption=new EntityOptions();
		entityOption.menuBtn.mouseHover();
		TestUtils.delay(2000);
		entityOption.agentlink.click();
		
		//Click on agent button
		
		AgentHomePage agentHome=new AgentHomePage();
		agentHome.addAgentBtn.click();
		
		AddAgentWizardDetails addAgentWizard=new AddAgentWizardDetails();
		
		//Agent Details fill up
		
		addAgentWizard.AgentNameTxt.write(agentName);
		addAgentWizard.VATNumberText.write(vatNumber);
		addAgentWizard.UsernameSuffixTxt.write(userNameSuffix);
		addAgentWizard.communicationLanguageLst.selectComunicationLanguage(comunicationLanguage);
		addAgentWizard.billingLanguageLst.selectBillingLanguage(billingLanguage);
		addAgentWizard.dateTimeLst.selectDateTimeFormat(dataTimeFormat);
		addAgentWizard.emailaddressTxt.write(email);
		
		//Address Details fill up
		
		addAgentWizard.boxNumberTxt.write(boxNumber);
		addAgentWizard.streetTxt.write(streetName);
		addAgentWizard.cityTxt.write(cityName);
		addAgentWizard.addressNumberTxt.write(addressNumber);
		addAgentWizard.postalCodeTxt.write(postalCode);
		addAgentWizard.countryLst.selectCountry(countryName);
		addAgentWizard.saveBtn.click();
		
		//check successfull agent creation
		PopUPHandler popUPHandler=new PopUPHandler();
		String message = popUPHandler.getPopUPData.read().trim();
		popUPHandler.acceptPopUP.click();
		Assert.assertEquals(message, getMessage.getProperty("agent_successfull_creation"));
	}
	
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void addAgentAutogenUPN(HashMap<?, ?> testData)
	{
		       // Get data from test-data (XLS based)
				String userName=testData.get("userName").toString();
				String password=testData.get("password").toString();
				String agentName=testData.get("agentName").toString();
				String vatNumber=testData.get("vatNumber").toString();
				String comunicationLanguage=testData.get("comunicationLanguage").toString();
				String billingLanguage=testData.get("billingLanguage").toString();
				String dataTimeFormat=testData.get("dataTimeFormat").toString();
				String boxNumber=testData.get("boxNumber").toString();
				String streetName=testData.get("streetName").toString();
				String cityName=testData.get("cityName").toString();
				String addressNumber=testData.get("addressNumber").toString();
				String postalCode=testData.get("postalCode").toString();
				String countryName=testData.get("countryName").toString();
				//Get Random data
				String email=Rd.getRandomEmailID();
				
				// Navigate to ENSIM site
				browser.navigateTo(baseURL);
				// Verify user-name, password, login button are displayed
				LoginScreen loginScreen = new LoginScreen();
				loginScreen.username.write(userName);
				loginScreen.password.write(password);

				// Click on login button
				loginScreen.loginBtn.click();
				
				//Click on agent link
				EntityOptions entityOption=new EntityOptions();
				entityOption.menuBtn.mouseHover();
				TestUtils.delay(2000);
				entityOption.agentlink.click();
				
				//Click on agent button
				
				AgentHomePage agentHome=new AgentHomePage();
				agentHome.addAgentBtn.click();
				
				AddAgentWizardDetails addAgentWizard=new AddAgentWizardDetails();
				
				//Agent Details fill up
				
				addAgentWizard.AgentNameTxt.write(agentName);
				addAgentWizard.VATNumberText.write(vatNumber);
			    addAgentWizard.communicationLanguageLst.selectComunicationLanguage(comunicationLanguage);
				addAgentWizard.billingLanguageLst.selectBillingLanguage(billingLanguage);
				addAgentWizard.dateTimeLst.selectDateTimeFormat(dataTimeFormat);
				addAgentWizard.emailaddressTxt.write(email);
				
				//Address Details fill up
				
				addAgentWizard.boxNumberTxt.write(boxNumber);
				addAgentWizard.streetTxt.write(streetName);
				addAgentWizard.cityTxt.write(cityName);
				addAgentWizard.addressNumberTxt.write(addressNumber);
				addAgentWizard.postalCodeTxt.write(postalCode);
				addAgentWizard.countryLst.selectCountry(countryName);
				addAgentWizard.saveBtn.click();
				
				//check successfull agent creation
				PopUPHandler popUPHandler=new PopUPHandler();
				String message = popUPHandler.getPopUPData.read().trim();
				popUPHandler.acceptPopUP.click();
				Assert.assertEquals(message, getMessage.getProperty("agent_successfull_creation"));
	}
	
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void checkUPN(HashMap<?, ?> testData)
	{
		 // Get data from test-data (XLS based)
		String userName=testData.get("userName").toString();
		String password=testData.get("password").toString();
		String userNameSuffix=testData.get("userNameSuffix").toString();
		//Ramdom data
		String correctUserNameSuffix=Rd.getRandomString(5)+"."+Rd.getRandomString(3);
		// Navigate to ENSIM site
		browser.navigateTo(baseURL);
		// Verify user-name, password, login button are displayed
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write(userName);
		loginScreen.password.write(password);

		// Click on login button
		loginScreen.loginBtn.click();
		
		//Click on agent link
		EntityOptions entityOption=new EntityOptions();
		entityOption.menuBtn.mouseHover();
		TestUtils.delay(2000);
		entityOption.agentlink.click();
		
		//Click on agent button
		
		AgentHomePage agentHome=new AgentHomePage();
		agentHome.addAgentBtn.click();
		
		AddAgentWizardDetails addAgentWizard=new AddAgentWizardDetails();
		addAgentWizard.UsernameSuffixTxt.write(userNameSuffix);
		addAgentWizard.addressNumberTxt.click();
	    TestUtils.delay(2000);
	    PopUPHandler popUPHandler=new PopUPHandler();
	    Assert.assertEquals(popUPHandler.getPopUPData.read().trim(), getMessage.getProperty("agent_duplicate_upn"));
	    popUPHandler.acceptPopUP.click();
	    TestUtils.delay(2000);
	    Assert.assertEquals(addAgentWizard.upnErrorImage.isExists(),true);
	    Assert.assertEquals(addAgentWizard.upnErrorImage.isDisplayed(),true);
	    addAgentWizard.UsernameSuffixTxt.clear();
	    addAgentWizard.UsernameSuffixTxt.write(correctUserNameSuffix);
	    addAgentWizard.addressNumberTxt.click();
	    TestUtils.delay(2000);
	    Assert.assertEquals(addAgentWizard.upnExistsImage.isExists(),true);
	    Assert.assertEquals(addAgentWizard.upnExistsImage.isDisplayed(),true);
	    
	}
	
	
	
	}
	
	

