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
import com.ensimtest.module.catalog.AddService;
import com.ensimtest.module.catalog.CatalogOptions;
import com.ensimtest.module.catalog.ImportService;
import com.ensimtest.module.catalog.ListOfSuggestedServices;
import com.ensimtest.module.catalog.ServiceHome;
import com.ensimtest.module.utility.PopUPHandler;
import com.ensimtest.resource.GetEASMessages;
import com.ensimtest.resource.PropertyReader;
import com.ensimtest.resource.TestDataProvider;
import com.ensimtest.utils.RandomData;
import com.ensimtest.utils.TestUtils;

public class ItemModuleBCT 
{
	private DriverSettings settings;
	private Browser browser;
	private static String baseURL;
	private static String browserName;
	private GetEASMessages getMessage=new GetEASMessages(); 
	private RandomData Rd=new RandomData();
	public ItemModuleBCT()
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
	
//	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
//	public void addService(HashMap<?, ?> testData)
//	{
//		RandomData Rd=new RandomData();
//		//Get Data From XLS file
//		String username = testData.get("UserName").toString();
//		String password = testData.get("password").toString();
//		String serviceName=testData.get("serviceName").toString();
//		String serviceID=testData.get("serviceID").toString();
//		String subscriptionType=testData.get("subscriptionType").toString();
//		String vendorName=testData.get("vendorName").toString();
//		String searchtags=testData.get("searchtags").toString();
//		String prosysID=testData.get("prosysID").toString();
//		String embeddedMessage=testData.get("embeddedMessage").toString();
//		String suggestedServices=testData.get("suggestedServices").toString();
//		String provDelayIn=testData.get("provDelayIn").toString();
//		String accessInformation=testData.get("accessInformation").toString();
//		String privateDNSRequired=testData.get("privateDNSRequired").toString();
//		String allowOnsameDNS=testData.get("allowOnsameDNS").toString();
//		String usageColRequired=testData.get("usageColRequired").toString();
//		String ADdomain=testData.get("ADdomain").toString();
//		String userManagement=testData.get("userManagement").toString();
//		String bulkAssignment=testData.get("bulkAssignment").toString();
//		String phoneNO=testData.get("phoneNO").toString();
//		String associateSameDomain=testData.get("associateSameDomain").toString();
//		String neverAssociateOrder=testData.get("neverAssociateOrder").toString();
//		String alwaysAssociateOrder=testData.get("alwaysAssociateOrder").toString();
//		String trackChangeSalesAgent=testData.get("trackChangeSalesAgent").toString();
//		String trackChangeTechnicalContact=testData.get("trackChangeTechnicalContact").toString();
//		String trackChangePI=testData.get("trackChangePI").toString();
//		String oneTimeProvision=testData.get("oneTimeProvision").toString();
//		String hostedService=testData.get("hostedService").toString();
//		String manualProvisioning=testData.get("manualProvisioning").toString();
//		String automaticProvisioning=testData.get("automaticProvisioning").toString();
//		String provisioningSystem=testData.get("provisioningSystem").toString();
//		String resellerCanConfig=testData.get("resellerCanConfig").toString();
//		String agentCanConfig=testData.get("agentCanConfig").toString();
//		String useEASCP=testData.get("useEASCP").toString();
//		String credentialstoTC=testData.get("credentialstoTC").toString();
//		//Random Generated Data
//		serviceName=serviceName+" "+Rd.getRandomNum(6);
//		serviceID=serviceID+" "+Rd.getRandomNum(6);
//		String provDelayTime=Rd.getRandomNum(3);
//		// Navigate to ENSIM site
//		browser.navigateTo(baseURL);
//		//Navigate to login screen 
//		LoginScreen loginScreen = new LoginScreen();
//		// Enter ISP credentials
//		loginScreen.username.write(username);
//		loginScreen.password.write(password);
//		
//		// Click Login button
//		loginScreen.loginBtn.click();
//		
//		//Click Service link
//		CatalogOptions catOptions=new CatalogOptions();
//		catOptions.catalogMenu.mouseHover();
//		catOptions.serviceslnk.click();
//		
//		//Click Add service button
//		ServiceHome serviceHome=new ServiceHome();
//		serviceHome.addServiceBtn.click();
//		
//		//Providing service Details
//		AddService addService=new AddService();
//		addService.serviceNameTxt.write(serviceName);
//		addService.internalServiceIDTxt.write(serviceID);
//		Assert.assertEquals(addService.subscriptionTypeTxt.read().trim(),"Default");
//		addService.subscriptionTypeTxt.clear();
//		addService.subscriptionTypeTxt.write(subscriptionType);
//		addService.vendorNameTxt.write(vendorName);
//		addService.searchTagTxt.write(searchtags);
//		addService.provSystemIdTxt.write(prosysID);
//		addService.embeddedMessageTxt.write(embeddedMessage);
//		addService.suggestedServiceBtn.click();
//		//Handle list of suggested services
//		ListOfSuggestedServices listServices=new ListOfSuggestedServices();
//		listServices.servicesList.selectServices(suggestedServices);
//		listServices.okBtn.click();
//		//Proving rest of the fields
//		addService.provisioningDelayTxt.write(provDelayTime);
//		addService.provisioningDelayLst.selectDelayType(provDelayIn);
//		
//		
//		if(privateDNSRequired.equalsIgnoreCase("Y"))
//		{
//		addService.dNSRequireChk.click();
//		}
//		
//		if(allowOnsameDNS.equalsIgnoreCase("Y"))
//		{
//		addService.multipleOrdersOnSameDNSChk.click();
//		}
//		
//		if(usageColRequired.equalsIgnoreCase("Y"))
//		{
//		addService.usageCollectionRequireChk.click();
//		}
//		
//		if(ADdomain.equalsIgnoreCase("Y"))
//		{
//			addService.requireActiveDirectoryDomainChk.click();
//		}
//		
//		if(userManagement.equalsIgnoreCase("Y"))
//		{
//			addService.hasUserManagementChk.click();
//		}
//		
//		if(bulkAssignment.equalsIgnoreCase("Y"))
//		{
//			addService.bulkAssignment.click();
//		}
//	    
//		if(phoneNO.equalsIgnoreCase("Y"))
//		{
//		addService.needPhNoChk.click();
//		}
//		
//		if(associateSameDomain.equalsIgnoreCase("Y"))
//		{
//			addService.associateifSamePrivateDomainRdo.click();
//		}
//		
//		if(neverAssociateOrder.equalsIgnoreCase("Y"))
//		{
//		    addService.neverAssociateOrderRdo.click();	
//		}
//		
//		if(alwaysAssociateOrder.equalsIgnoreCase("Y"))
//		{
//			addService.alwaysAssociateOrderRdo.click();
//		}
//		
//		if(trackChangeSalesAgent.equalsIgnoreCase("Y"))
//		{
//			addService.trackChangeOfSalesAgentChk.click();
//		}
//		
//		if(trackChangeTechnicalContact.equalsIgnoreCase("Y"))
//		{
//			addService.trackChangeOfTechnicalContactChk.click();
//		}
//		
//		if(trackChangePI.equalsIgnoreCase("Y"))
//		{
//			addService.trackChangeOfProvisioningInformationChk.click();	
//		}
//		
//		if(oneTimeProvision.equalsIgnoreCase("Y"))
//		{
//			addService.oneTimeProvisioningRdo.click();
//		}
//		
//		if(hostedService.equalsIgnoreCase("Y"))
//		{
//		addService.hostedServiceRdo.click();
//		}
//		
//		if(manualProvisioning.equalsIgnoreCase("Y"))
//		{
//		addService.manualProvisioningRdo.click();
//		}
//		
//		if(automaticProvisioning.equalsIgnoreCase("Y"))
//		{
//			addService.automaticProvisioningRdo.click();
//			addService.provisioningSystemLst.selectProvisioningSystem(provisioningSystem);
//		}
//		
//		if(resellerCanConfig.equalsIgnoreCase("Y"))
//		{
//			addService.resellerCanConfigureChk.click();
//		}
//		
//		if(agentCanConfig.equalsIgnoreCase("Y"))
//		{
//			addService.agentCanConfigureChk.click();
//		}
//		
//		if(useEASCP.equalsIgnoreCase("Y"))
//		{
//			addService.useEASControlPanel.click();
//		}
//		
//		if(credentialstoTC.equalsIgnoreCase("Y"))
//		{
//		addService.sendAccessCredentialsChk.click();
//		addService.accessInformationTxt.write(accessInformation);
//		}
//		
//		addService.saveBtn.click();
//		PopUPHandler popUP=new PopUPHandler();
//		Assert.assertEquals(popUP.getPopUPData.read().trim(), getMessage.getProperty("service_successful_creation"));
//		popUP.acceptPopUP.click();
//		serviceHome.editServiceBtn.click();
//		Assert.assertEquals(addService.serviceNameTxt.read(),serviceName);
//		Assert.assertEquals(addService.internalServiceIDTxt.read(),serviceID);
//		Assert.assertEquals(addService.subscriptionTypeTxt.read(),subscriptionType);
//		Assert.assertEquals(addService.vendorNameTxt.read(),vendorName);
//		Assert.assertEquals(addService.searchTagTxt.read(),searchtags);
//		Assert.assertEquals(addService.provSystemIdTxt.read(), prosysID);
//		Assert.assertEquals(addService.embeddedMessageTxt.read(), embeddedMessage);
//		addService.suggestedServiceBtn.click();
//		Assert.assertEquals(listServices.servicesList.isServicesSelected(suggestedServices), true);
//		listServices.okBtn.click();
//		Assert.assertEquals(addService.provisioningDelayTxt.read(),provDelayTime);
//		Assert.assertEquals(addService.provisioningDelayLst.getSelectedType(), provDelayIn);
//		
//		if(privateDNSRequired.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.dNSRequireChk.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.dNSRequireChk.isSelecetd(), false);
//		}
//		
//		
//		if(allowOnsameDNS.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.multipleOrdersOnSameDNSChk.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.multipleOrdersOnSameDNSChk.isSelecetd(), false);
//		}
//		
//		if(usageColRequired.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.usageCollectionRequireChk.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.usageCollectionRequireChk.isSelecetd(), false);	
//		}
//
//		if(ADdomain.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.requireActiveDirectoryDomainChk.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.requireActiveDirectoryDomainChk.isSelecetd(), false);
//		}
//		
//		if(userManagement.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.hasUserManagementChk.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.hasUserManagementChk.isSelecetd(), false);
//		}
//		
//		if(phoneNO.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.needPhNoChk.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.needPhNoChk.isSelecetd(), false);
//		}
//		
//		if(bulkAssignment.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.bulkAssignment.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.bulkAssignment.isSelecetd(), false);
//		}
//		
//		if(associateSameDomain.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.associateifSamePrivateDomainRdo.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.associateifSamePrivateDomainRdo.isSelecetd(), false);
//		}
//
//		if(neverAssociateOrder.equalsIgnoreCase("Y"))
//		{
//		    Assert.assertEquals(addService.neverAssociateOrderRdo.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.neverAssociateOrderRdo.isSelecetd(), false);
//		}
//		
//		if(alwaysAssociateOrder.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.alwaysAssociateOrderRdo.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.alwaysAssociateOrderRdo.isSelecetd(), false);
//		}
//
//		if(trackChangeSalesAgent.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.trackChangeOfSalesAgentChk.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.trackChangeOfSalesAgentChk.isSelecetd(), false);
//		}
//
//		if(trackChangeTechnicalContact.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.trackChangeOfTechnicalContactChk.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.trackChangeOfTechnicalContactChk.isSelecetd(), false);
//		}
//
//		if(trackChangePI.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.trackChangeOfProvisioningInformationChk.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.trackChangeOfProvisioningInformationChk.isSelecetd(), false);
//		}
//		
//		if(oneTimeProvision.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.oneTimeProvisioningRdo.isSelecetd(),true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.oneTimeProvisioningRdo.isSelecetd(),false);
//		}
//		
//		if(hostedService.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.hostedServiceRdo.isSelecetd(),true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.hostedServiceRdo.isSelecetd(),false);
//		}
//		
//		if(manualProvisioning.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.manualProvisioningRdo.isSelecetd(),true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.manualProvisioningRdo.isSelecetd(),false);
//		}
//
//		if(automaticProvisioning.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.automaticProvisioningRdo.isSelecetd(),true);
//			Assert.assertEquals(addService.provisioningSystemLst.getSelectedProvisioningSystem(), provisioningSystem);
//			
//			if(resellerCanConfig.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.resellerCanConfigureChk.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.resellerCanConfigureChk.isSelecetd(), false);
//			}
//			
//			if(agentCanConfig.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.agentCanConfigureChk.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.agentCanConfigureChk.isSelecetd(), false);
//			}
//			
//
//			if(useEASCP.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.useEASControlPanel.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.useEASControlPanel.isSelecetd(), true);
//			}
//			
//			
//			
//		}
//		else
//		{
//			Assert.assertEquals(addService.automaticProvisioningRdo.isSelecetd(),false);
//		}
//		
//		if(credentialstoTC.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.sendAccessCredentialsChk.isSelecetd(),true);
//			Assert.assertEquals(addService.accessInformationTxt.read(),accessInformation);
//		}
//		else
//		{
//			Assert.assertEquals(addService.sendAccessCredentialsChk.isSelecetd(),false);
//		}
//	    
//	}
	
//	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
//	public void importService(HashMap<?, ?> testData)
//	{
//		//Get Data From XLS file
//		String username = testData.get("UserName").toString();
//		String password = testData.get("password").toString();
//		String serviceXMLPath=testData.get("serviceXMLPath").toString();
//		String serviceSuccessMessage=testData.get("serviceSuccessMessage").toString();
//		String searchtags=testData.get("searchtags").toString();
//		String serviceName=testData.get("serviceName").toString();
//		String serviceID=testData.get("serviceID").toString();
//		String subscriptionType=testData.get("subscriptionType").toString();
//		String vendorName=testData.get("vendorName").toString();
//		String prosysID=testData.get("prosysID").toString();
//		String embeddedMessage=testData.get("embeddedMessage").toString();
//		String proviDelayTime=testData.get("proviDelayTime").toString();
//		String provDelayIn=testData.get("provDelayIn").toString();
//		String privateDNSRequired=testData.get("privateDNSRequired").toString();
//		String allowOnsameDNS=testData.get("allowOnsameDNS").toString();
//		String usageColRequired=testData.get("usageColRequired").toString();
//		String ADdomain=testData.get("ADdomain").toString();
//		String userManagement=testData.get("userManagement").toString();
//		String phoneNO=testData.get("phoneNO").toString();
//		String bulkAssignment=testData.get("bulkAssignment").toString();
//		String associateSameDomain=testData.get("associateSameDomain").toString();
//		String neverAssociateOrder=testData.get("neverAssociateOrder").toString();
//		String alwaysAssociateOrder=testData.get("alwaysAssociateOrder").toString();
//		String trackChangeSalesAgent=testData.get("trackChangeSalesAgent").toString();
//		String trackChangeTechnicalContact=testData.get("trackChangeTechnicalContact").toString();
//		String trackChangePI=testData.get("trackChangePI").toString();
//		String oneTimeProvision=testData.get("oneTimeProvision").toString();
//		String hostedService=testData.get("hostedService").toString();
//		String manualProvisioning=testData.get("manualProvisioning").toString();
//		String automaticProvisioning=testData.get("automaticProvisioning").toString();
//		String provisioningSystem=testData.get("provisioningSystem").toString();
//		String resellerCanConfig=testData.get("resellerCanConfig").toString();
//		String agentCanConfig=testData.get("agentCanConfig").toString();
//		String useEASCP=testData.get("useEASCP").toString();
//		String credentialstoTC=testData.get("credentialstoTC").toString();
//		String accessInformation=testData.get("accessInformation").toString();
//		// Navigate to ENSIM site
//		browser.navigateTo(baseURL);
//		
//		//Navigate to login screen 
//		LoginScreen loginScreen = new LoginScreen();
//		
//		// Enter ISP credentials
//		loginScreen.username.write(username);
//		loginScreen.password.write(password);
//		
//		// Click Login button
//		loginScreen.loginBtn.click();
//		
//		//Click Service link
//		CatalogOptions catOptions=new CatalogOptions();
//		catOptions.catalogMenu.mouseHover();
//		catOptions.serviceslnk.click();
//		
//		//Click Add service button
//		ServiceHome serviceHome=new ServiceHome();
//		serviceHome.importServiceBtn.click();
//		//
//		ImportService importService=new ImportService();
//		importService.browseBtn.write(serviceXMLPath);
//		importService.importBtn.click();
//		PopUPHandler popUP=new PopUPHandler();
//		Assert.assertEquals(popUP.getPopUPData.read(),serviceSuccessMessage);
//		popUP.acceptPopUP.click();
//		serviceHome.editServiceBtn.click();
//		AddService addService=new AddService();
//		Assert.assertEquals(addService.serviceNameTxt.read(), serviceName);
//		Assert.assertEquals(addService.internalServiceIDTxt.read(), serviceID);
//		Assert.assertEquals(addService.subscriptionTypeTxt.read(), subscriptionType);
//		Assert.assertEquals(addService.vendorNameTxt.read(), vendorName);
//		Assert.assertEquals(addService.provSystemIdTxt.read(), prosysID);
//		Assert.assertEquals(addService.embeddedMessageTxt.read(), embeddedMessage);
//		Assert.assertEquals(addService.searchTagTxt.read(),searchtags);
//		Assert.assertEquals(addService.provisioningDelayTxt.read(), proviDelayTime);
//		Assert.assertEquals(addService.provisioningDelayLst.getSelectedType(), provDelayIn);
//		
//		if(privateDNSRequired.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.dNSRequireChk.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.dNSRequireChk.isSelecetd(), false);
//		}
//		
//		if(allowOnsameDNS.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.multipleOrdersOnSameDNSChk.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.multipleOrdersOnSameDNSChk.isSelecetd(), false);
//		}
//		
//		if(usageColRequired.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.usageCollectionRequireChk.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.usageCollectionRequireChk.isSelecetd(), false);
//		}
//		if(ADdomain.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.requireActiveDirectoryDomainChk.isSelecetd(), true);	
//		}
//		else
//		{
//			Assert.assertEquals(addService.requireActiveDirectoryDomainChk.isSelecetd(), false);
//		}
//		if(userManagement.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.hasUserManagementChk.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.hasUserManagementChk.isSelecetd(), false);
//		}
//		if(phoneNO.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.needPhNoChk.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.needPhNoChk.isSelecetd(), false);
//		}
//		if(bulkAssignment.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.bulkAssignment.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.bulkAssignment.isSelecetd(), false);
//		}
//		if(associateSameDomain.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.associateifSamePrivateDomainRdo.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.associateifSamePrivateDomainRdo.isSelecetd(), false);
//		}
//		if(neverAssociateOrder.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.neverAssociateOrderRdo.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.neverAssociateOrderRdo.isSelecetd(), false);
//		}
//		if(alwaysAssociateOrder.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.alwaysAssociateOrderRdo.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.alwaysAssociateOrderRdo.isSelecetd(), false);
//		}
//		if(trackChangeSalesAgent.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.trackChangeOfSalesAgentChk.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.trackChangeOfSalesAgentChk.isSelecetd(), false);
//		}
//		if(trackChangeTechnicalContact.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.trackChangeOfTechnicalContactChk.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.trackChangeOfTechnicalContactChk.isSelecetd(), false);
//		}
//		if(trackChangePI.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.trackChangeOfProvisioningInformationChk.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.trackChangeOfProvisioningInformationChk.isSelecetd(), false);
//		}
//		if(oneTimeProvision.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.oneTimeProvisioningRdo.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.oneTimeProvisioningRdo.isSelecetd(), false);
//		}
//		if(hostedService.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.hostedServiceRdo.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.hostedServiceRdo.isSelecetd(), false);
//		}
//		if(manualProvisioning.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.manualProvisioningRdo.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.manualProvisioningRdo.isSelecetd(), false);
//		}
//		if(automaticProvisioning.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.automaticProvisioningRdo.isSelecetd(), true);
//			Assert.assertEquals(addService.provisioningSystemLst.getSelectedProvisioningSystem(), provisioningSystem);
//		}
//		else
//		{
//			Assert.assertEquals(addService.automaticProvisioningRdo.isSelecetd(), false);
//		}
//		if(resellerCanConfig.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.resellerCanConfigureChk.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.resellerCanConfigureChk.isSelecetd(), false);
//		}
//		if(agentCanConfig.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.agentCanConfigureChk.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.agentCanConfigureChk.isSelecetd(), false);
//		}
//		if(useEASCP.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.useEASControlPanel.isSelecetd(), true);
//		}
//		else
//		{
//			Assert.assertEquals(addService.useEASControlPanel.isSelecetd(), false);
//		}
//		if(credentialstoTC.equalsIgnoreCase("Y"))
//		{
//			Assert.assertEquals(addService.sendAccessCredentialsChk.isSelecetd(), true);
//			Assert.assertEquals(addService.accessInformationTxt.read(), accessInformation);
//		}
//		else
//		{
//			Assert.assertEquals(addService.sendAccessCredentialsChk.isSelecetd(), false);
//		}
//		
//	}
	
	
	@Test
	public void deleteServiceWithItem()
	{
		
	}

	

}
