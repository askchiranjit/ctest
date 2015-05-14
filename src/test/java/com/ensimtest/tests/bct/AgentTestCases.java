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
		settings.setUpDriver(browserName, 10);
	}

	@AfterClass
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
		String agentName=testData.get("agentName").toString() + Rd.getRandomString(2);
		String vatNumber=testData.get("vatNumber").toString();
		String userNameSuffix=Rd.getRandomString(3) + "." + Rd.getRandomString(3);
		String comunicationLanguage=testData.get("comunicationLanguage").toString();
		String billingLanguage=testData.get("billingLanguage").toString();
		String dataTimeFormat=testData.get("dataTimeFormat").toString();
		String boxNumber=testData.get("boxNumber").toString();
		String streetName=testData.get("streetName").toString();
		String cityName=testData.get("cityName").toString();
		String addressNumber=testData.get("addressNumber").toString();
		String postalCode=testData.get("postalCode").toString();
		String countryName=testData.get("countryName").toString();
		String email=Rd.getRandomEmailID();
		
		// Navigate to ENSIM site
		browser.navigateTo(baseURL);
		
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write(userName);
		loginScreen.password.write(password);

		// Click on login button
		loginScreen.loginBtn.click();
		
		//Click on agent link
		EntityOptions entityOption=new EntityOptions();
		entityOption.menuBtn.mouseHover();
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
		
		//check successful agent creation
		PopUPHandler popUPHandler=new PopUPHandler();
		String message = popUPHandler.getPopUPData.read().trim();
		popUPHandler.acceptPopUP.click();
		Assert.assertEquals(message, getMessage.getProperty("agent_successfull_creation"));
	}
	
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData", dependsOnMethods = { "addAgentUserGivenUPN" })
	public void addAgentAutogenUPN(HashMap<?, ?> testData)
	{
		       // Get data from test-data (XLS based)
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
				
				//Click on agent link
				EntityOptions entityOption=new EntityOptions();
				entityOption.menuBtn.mouseHover();
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
				
				//check successful agent creation
				PopUPHandler popUPHandler=new PopUPHandler();
				String message = popUPHandler.getPopUPData.read().trim();
				popUPHandler.acceptPopUP.click();
				Assert.assertEquals(message, getMessage.getProperty("agent_successfull_creation"));
	}
	
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData", dependsOnMethods = { "addAgentAutogenUPN" })
	public void checkUPN(HashMap<?, ?> testData)
	{
		 // Get data from test-data (XLS based)
		String userNameSuffix=testData.get("userNameSuffix").toString();
		// generate random data
		String correctUserNameSuffix=Rd.getRandomString(5)+"."+Rd.getRandomString(3);
		
		//Click on agent link
		EntityOptions entityOption=new EntityOptions();
		entityOption.menuBtn.mouseHover();
		entityOption.agentlink.click();
		
		//Click on agent button
		AgentHomePage agentHome=new AgentHomePage();
		agentHome.addAgentBtn.click();
		
		AddAgentWizardDetails addAgentWizard=new AddAgentWizardDetails();
		addAgentWizard.UsernameSuffixTxt.write(userNameSuffix);
		addAgentWizard.addressNumberTxt.click();
	    PopUPHandler popUPHandler=new PopUPHandler();
	    Assert.assertEquals(popUPHandler.getPopUPData.read().trim(), getMessage.getProperty("agent_duplicate_upn"));
	    popUPHandler.acceptPopUP.click();
	    Assert.assertEquals(addAgentWizard.upnErrorImage.isExists(),true);
	    Assert.assertEquals(addAgentWizard.upnErrorImage.isDisplayed(),true);
	    addAgentWizard.UsernameSuffixTxt.clear();
	    addAgentWizard.UsernameSuffixTxt.write(correctUserNameSuffix);
	    addAgentWizard.addressNumberTxt.click();
	    Assert.assertEquals(addAgentWizard.upnExistsImage.isExists(),true);
	    Assert.assertEquals(addAgentWizard.upnExistsImage.isDisplayed(),true);
	    }
}