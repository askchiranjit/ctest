package com.ensimtest.tests.bct;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ensimtest.config.Browser;
import com.ensimtest.config.DriverSettings;
import com.ensimtest.config.Element;
import com.ensimtest.module.authentication.LoginScreen;
import com.ensimtest.module.catalog.AddService;
import com.ensimtest.module.catalog.CatalogOptions;
import com.ensimtest.module.catalog.ImportService;
import com.ensimtest.module.catalog.ListOfSuggestedServices;
import com.ensimtest.module.catalog.ServiceHome;
import com.ensimtest.module.catalog.ServiceSearchResult;
import com.ensimtest.module.catalog.ServiceSearchResult.ServiceRow;
import com.ensimtest.module.utility.PopUPHandler;
import com.ensimtest.resource.GetEASMessages;
import com.ensimtest.resource.PropertyReader;
import com.ensimtest.resource.TestDataProvider;
import com.ensimtest.utils.RandomData;
import com.ensimtest.utils.TestUtils;

public class ItemModuleBCT 
{
	private Browser browser=null;
	private GetEASMessages getMessage=new GetEASMessages(); 
	private RandomData randomdata=new RandomData();


	@BeforeClass
	public void checkSuiteRunmode() throws IOException
	{
		TestUtils.checkSuitRunnable(this);
		browser = new Browser();
	}

	@AfterClass
	public void tearDown()
	{
		browser.close();
	}

	
    private void  click(Element e, boolean b)
    {
         if(b) e.click();
    }


		@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
		public void addService(HashMap<?, ?> testData)
		{
			
			//Get Data From XLS file
			String username = testData.get("UserName").toString();
			String password = testData.get("password").toString();
			String serviceName=testData.get("serviceName").toString();
			String serviceID=testData.get("serviceID").toString();
			String subscriptionType=testData.get("subscriptionType").toString();
			String vendorName=testData.get("vendorName").toString();
			String searchtags=testData.get("searchtags").toString();
			String prosysID=testData.get("prosysID").toString();
			String embeddedMessage=testData.get("embeddedMessage").toString();
			String suggestedServices=testData.get("suggestedServices").toString();
			String provDelayIn=testData.get("provDelayIn").toString();
			String accessInformation=testData.get("accessInformation").toString();
			boolean privateDNSRequired=Boolean.valueOf(testData.get("privateDNSRequired").toString());
			boolean allowOnsameDNS=Boolean.valueOf(testData.get("allowOnsameDNS").toString());
			boolean usageColRequired=Boolean.valueOf(testData.get("usageColRequired").toString());
			boolean ADdomain=Boolean.valueOf(testData.get("ADdomain").toString());
			boolean userManagement=Boolean.valueOf(testData.get("userManagement").toString());
			boolean bulkAssignment=Boolean.valueOf(testData.get("bulkAssignment").toString());
			boolean phoneNO=Boolean.valueOf(testData.get("phoneNO").toString());
			boolean associateSameDomain=Boolean.valueOf(testData.get("associateSameDomain").toString());
			boolean neverAssociateOrder=Boolean.valueOf(testData.get("neverAssociateOrder").toString());
			boolean alwaysAssociateOrder=Boolean.valueOf(testData.get("alwaysAssociateOrder").toString());
			boolean trackChangeSalesAgent=Boolean.valueOf(testData.get("trackChangeSalesAgent").toString());
			boolean trackChangeTechnicalContact=Boolean.valueOf(testData.get("trackChangeTechnicalContact").toString());
			boolean trackChangePI=Boolean.valueOf(testData.get("trackChangePI").toString());
			boolean oneTimeProvision=Boolean.valueOf(testData.get("oneTimeProvision").toString());
			boolean hostedService=Boolean.valueOf(testData.get("hostedService").toString());
			boolean manualProvisioning=Boolean.valueOf(testData.get("manualProvisioning").toString());
			boolean automaticProvisioning=Boolean.valueOf(testData.get("automaticProvisioning").toString());
			String provisioningSystem=testData.get("provisioningSystem").toString();
			boolean resellerCanConfig=Boolean.valueOf(testData.get("resellerCanConfig").toString());
			boolean agentCanConfig=Boolean.valueOf(testData.get("agentCanConfig").toString());
			boolean useEASCP=Boolean.valueOf(testData.get("useEASCP").toString());
			boolean credentialstoTC=Boolean.valueOf(testData.get("credentialstoTC").toString());
			//Random Generated Data
			serviceName=serviceName+" "+randomdata.getRandomNum(6);
			serviceID=serviceID+" "+randomdata.getRandomNum(6);
			String provDelayTime=randomdata.getRandomNum(3);
			
			// Navigate to ENSIM site
			browser.navigateTo();
			//Navigate to login screen 
			LoginScreen loginScreen = new LoginScreen();
			// Enter ISP credentials
			loginScreen.username.write(username);
			loginScreen.password.write(password);
			
			// Click Login button
			loginScreen.loginBtn.click();
			
			//Click Service link
			CatalogOptions catOptions=new CatalogOptions();
			catOptions.catalogMenu.mouseHover();
			catOptions.serviceslnk.click();
			
			//Click Add service button
			ServiceHome serviceHome=new ServiceHome();
			serviceHome.addServiceBtn.click();
			
			//Providing service Details
			AddService addService=new AddService();
			addService.serviceNameTxt.write(serviceName);
			addService.internalServiceIDTxt.write(serviceID);
			Assert.assertEquals(addService.subscriptionTypeTxt.read().trim(),"Default");
			addService.subscriptionTypeTxt.clear();
			addService.subscriptionTypeTxt.write(subscriptionType);
			addService.vendorNameTxt.write(vendorName);
			addService.searchTagTxt.write(searchtags);
			addService.provSystemIdTxt.write(prosysID);
			addService.embeddedMessageTxt.write(embeddedMessage);
			addService.suggestedServiceBtn.click();
			//Handle list of suggested services
			ListOfSuggestedServices listServices=new ListOfSuggestedServices();
			listServices.servicesList.selectServices(suggestedServices);
			listServices.okBtn.click();
			//Proving rest of the fields
			addService.provisioningDelayTxt.write(provDelayTime);
			addService.provisioningDelayLst.selectDelayType(provDelayIn);
			
			click(addService.dNSRequireChk,privateDNSRequired);
			click(addService.multipleOrdersOnSameDNSChk,allowOnsameDNS);
			click(addService.usageCollectionRequireChk, usageColRequired);
			click(addService.requireActiveDirectoryDomainChk, ADdomain);
			click(addService.hasUserManagementChk, userManagement);
			click(addService.bulkAssignment, bulkAssignment);
			click(addService.needPhNoChk, phoneNO);		    
			click(addService.associateifSamePrivateDomainRdo, associateSameDomain);
			click(addService.neverAssociateOrderRdo, neverAssociateOrder);
			click(addService.alwaysAssociateOrderRdo, alwaysAssociateOrder);
			click(addService.trackChangeOfSalesAgentChk, trackChangeSalesAgent);
			click(addService.trackChangeOfTechnicalContactChk,trackChangeTechnicalContact);
			click(addService.trackChangeOfProvisioningInformationChk, trackChangePI);			
			click(addService.oneTimeProvisioningRdo, oneTimeProvision);
			click(addService.hostedServiceRdo, hostedService);
			click(addService.manualProvisioningRdo, manualProvisioning);			
						
			if(automaticProvisioning)
			{
				addService.automaticProvisioningRdo.click();
				addService.provisioningSystemLst.selectProvisioningSystem(provisioningSystem);
			}
			
			click(addService.resellerCanConfigureChk, resellerCanConfig);
			click(addService.agentCanConfigureChk, agentCanConfig);
			click(addService.useEASControlPanel, useEASCP);
								
			if(credentialstoTC)
			{
			addService.sendAccessCredentialsChk.click();
			addService.accessInformationTxt.write(accessInformation);
			}
			
			addService.saveBtn.click();
			PopUPHandler popUP=new PopUPHandler();
			Assert.assertEquals(popUP.getPopUPData.read().trim(), getMessage.getProperty("service_successful_creation"));
			popUP.acceptPopUP.click();
			serviceHome.editServiceBtn.click();
			Assert.assertEquals(addService.serviceNameTxt.read(),serviceName);
			Assert.assertEquals(addService.internalServiceIDTxt.read(),serviceID);
			Assert.assertEquals(addService.subscriptionTypeTxt.read(),subscriptionType);
			Assert.assertEquals(addService.vendorNameTxt.read(),vendorName);
			Assert.assertEquals(addService.searchTagTxt.read(),searchtags);
			Assert.assertEquals(addService.provSystemIdTxt.read(), prosysID);
			Assert.assertEquals(addService.embeddedMessageTxt.read(), embeddedMessage);
			addService.suggestedServiceBtn.click();
			Assert.assertEquals(listServices.servicesList.isServicesSelected(suggestedServices), true);
			listServices.okBtn.click();
			
			Assert.assertEquals(addService.provisioningDelayTxt.read(),provDelayTime);
			
			Assert.assertEquals(addService.provisioningDelayLst.getSelectedType(), provDelayIn);
						
			Assert.assertEquals(addService.dNSRequireChk.isSelecetd(), privateDNSRequired);			
			
			Assert.assertEquals(addService.multipleOrdersOnSameDNSChk.isSelecetd(), allowOnsameDNS);			

			Assert.assertEquals(addService.usageCollectionRequireChk.isSelecetd(), usageColRequired);	

			Assert.assertEquals(addService.requireActiveDirectoryDomainChk.isSelecetd(), ADdomain);			

			Assert.assertEquals(addService.hasUserManagementChk.isSelecetd(), userManagement);

			Assert.assertEquals(addService.needPhNoChk.isSelecetd(), phoneNO);		

			Assert.assertEquals(addService.bulkAssignment.isSelecetd(), bulkAssignment);
			
        	Assert.assertEquals(addService.associateifSamePrivateDomainRdo.isSelecetd(), associateSameDomain);
			
		    Assert.assertEquals(addService.neverAssociateOrderRdo.isSelecetd(), neverAssociateOrder);
			
			Assert.assertEquals(addService.alwaysAssociateOrderRdo.isSelecetd(), alwaysAssociateOrder);
	
			Assert.assertEquals(addService.trackChangeOfSalesAgentChk.isSelecetd(), trackChangeSalesAgent);
			
			Assert.assertEquals(addService.trackChangeOfTechnicalContactChk.isSelecetd(), trackChangeTechnicalContact);
	
     		Assert.assertEquals(addService.trackChangeOfProvisioningInformationChk.isSelecetd(), trackChangePI);
				
			Assert.assertEquals(addService.oneTimeProvisioningRdo.isSelecetd(),oneTimeProvision);

			Assert.assertEquals(addService.hostedServiceRdo.isSelecetd(),hostedService);
		
            Assert.assertEquals(addService.manualProvisioningRdo.isSelecetd(),manualProvisioning);
			
			if(automaticProvisioning)
			{
				Assert.assertEquals(addService.automaticProvisioningRdo.isSelecetd(),true);
				
				Assert.assertEquals(addService.provisioningSystemLst.getSelectedProvisioningSystem(), provisioningSystem);
				
				Assert.assertEquals(addService.resellerCanConfigureChk.isSelecetd(), resellerCanConfig);
				
				Assert.assertEquals(addService.agentCanConfigureChk.isSelecetd(), agentCanConfig);
				
				Assert.assertEquals(addService.useEASControlPanel.isSelecetd(), useEASCP);
			}
			else
			{
				Assert.assertEquals(addService.automaticProvisioningRdo.isSelecetd(),automaticProvisioning);
			}
			
			if(credentialstoTC)
			{				
				Assert.assertEquals(addService.accessInformationTxt.read(),accessInformation);
			}

			Assert.assertEquals(addService.sendAccessCredentialsChk.isSelecetd(),credentialstoTC);
		    
		}

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


	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void deleteServiceWithItem(HashMap<?, ?> testData)
	{
		boolean flag=false;

		String serviceName=testData.get("serviceName").toString();
		String username = testData.get("UserName").toString();
		String password = testData.get("password").toString();

		browser.navigateTo();

		//Navigate to login screen 
		LoginScreen loginScreen = new LoginScreen();

		// Enter credentials

		loginScreen.username.write(username);
		loginScreen.password.write(password);

		// Click Login button
		loginScreen.loginBtn.click();

		//Click Service link
		CatalogOptions catOptions=new CatalogOptions();
		catOptions.catalogMenu.mouseHover();
		catOptions.serviceslnk.click();
		ServiceHome serviceHome=new ServiceHome();
		
		serviceHome.searchServiceTxt.write(serviceName);
		serviceHome.searchServiceImg.click();
		TestUtils.delay(5000);

		ServiceSearchResult serv=new ServiceSearchResult();
		ServiceRow ser[];
		while(flag==false)
		{
			ser=serv.servic.getServiceRows();

			for(int i=0;i<ser.length;i++)
			{
				if(ser[i].serviceName.read().equalsIgnoreCase(serviceName))
				{
					ser[i].serviceName.click();
					flag=true;
					break;
				}


			}
			if(flag==false)
			{
				if(serviceHome.nextImg.isEnabled()==true)
				{
					serviceHome.nextImg.click();
				}
				else
				{
					break;
				}
			}

		}

		Assert.assertEquals(flag, false, "Service got present");

		serviceHome.deleteServiceBtn.click();
		
		PopUPHandler popUpHandler=new PopUPHandler();
		Assert.assertEquals(getMessage.getProperty("service_delete_confirmation"), popUpHandler.getPopUPData.read());
		popUpHandler.acceptPopUP.click();
		Assert.assertEquals(getMessage.getProperty("service_withitem_delete"), popUpHandler.getPopUPData.read());
		popUpHandler.acceptPopUP.click();

		serviceHome.searchServiceTxt.write(serviceName);
		serviceHome.searchServiceImg.click();
		TestUtils.delay(5000);
		
		flag=false;
		
		while(flag==false)
		{
			ser=serv.servic.getServiceRows();

			for(int i=0;i<ser.length;i++)
			{
				if(ser[i].serviceName.read().equalsIgnoreCase(serviceName))
				{
					flag=true;
					break;
				}


			}
			if(flag==false)
			{
				if(serviceHome.nextImg.isEnabled()==true)
				{
					serviceHome.nextImg.click();
				}
				else
				{
					break;
				}
			}

		}
		
		Assert.assertEquals(flag, false, "Service got deleted");


	}
	
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void deleteServiceWithoutItem(HashMap<?, ?> testData)
	{
		boolean flag=false;

		String serviceName=testData.get("serviceName").toString();
		String username = testData.get("UserName").toString();
		String password = testData.get("password").toString();

		browser.navigateTo();

		//Navigate to login screen 
		LoginScreen loginScreen = new LoginScreen();

		// Enter credentials

		loginScreen.username.write(username);
		loginScreen.password.write(password);

		// Click Login button
		loginScreen.loginBtn.click();

		//Click Service link
		CatalogOptions catOptions=new CatalogOptions();
		catOptions.catalogMenu.mouseHover();
		catOptions.serviceslnk.click();
		ServiceHome serviceHome=new ServiceHome();
		
		serviceHome.searchServiceTxt.write(serviceName);
		serviceHome.searchServiceImg.click();
		TestUtils.delay(5000);

		ServiceSearchResult serv=new ServiceSearchResult();
		ServiceRow ser[];
		while(flag==false)
		{
			ser=serv.servic.getServiceRows();

			for(int i=0;i<ser.length;i++)
			{
				if(ser[i].serviceName.read().equalsIgnoreCase(serviceName))
				{
					ser[i].serviceName.click();
					flag=true;
					break;
				}


			}
			if(flag==false)
			{
				if(serviceHome.nextImg.isEnabled()==true)
				{
					serviceHome.nextImg.click();
				}
				else
				{
					break;
				}
			}

		}

		Assert.assertEquals(flag, false, "Service not present");
		
		serviceHome.deleteServiceBtn.click();
		
		PopUPHandler popUpHandler=new PopUPHandler();
		Assert.assertEquals(getMessage.getProperty("service_delete_confirmation"), popUpHandler.getPopUPData.read());
		popUpHandler.acceptPopUP.click();
		Assert.assertEquals(getMessage.getProperty("service_withoutitem_delete"), popUpHandler.getPopUPData.read());
		popUpHandler.acceptPopUP.click();

		serviceHome.searchServiceTxt.write(serviceName);
		serviceHome.searchServiceImg.click();
		TestUtils.delay(5000);
		
		flag=false;
		
		while(flag==false)
		{
			ser=serv.servic.getServiceRows();

			for(int i=0;i<ser.length;i++)
			{
				if(ser[i].serviceName.read().equalsIgnoreCase(serviceName))
				{
					flag=true;
					break;
				}


			}
			if(flag==false)
			{
				if(serviceHome.nextImg.isEnabled()==true)
				{
					serviceHome.nextImg.click();
				}
				else
				{
					break;
				}
			}

		}
		
		Assert.assertEquals(flag, false, "Service not deleted properly");
	}

//	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
//	public void AddResource(HashMap<?, ?> testData)
//	{
//		boolean flag=false;
//
//		String serviceName=testData.get("serviceName").toString();
//		String username = testData.get("UserName").toString();
//		String password = testData.get("password").toString();
//
//		browser.navigateTo();
//
//		//Navigate to login screen 
//		LoginScreen loginScreen = new LoginScreen();
//
//		// Enter credentials
//
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
//		ServiceHome serviceHome=new ServiceHome();
//		
//		serviceHome.searchServiceTxt.write(serviceName);
//		serviceHome.searchServiceImg.click();
//		TestUtils.delay(5000);
//
//		ServiceSearchResult serv=new ServiceSearchResult();
//		ServiceRow ser[];
//		while(flag==false)
//		{
//			ser=serv.servic.getServiceRows();
//
//			for(int i=0;i<ser.length;i++)
//			{
//				if(ser[i].serviceName.read().equalsIgnoreCase(serviceName))
//				{
//					ser[i].serviceName.click();
//					flag=true;
//					break;
//				}
//
//
//			}
//			if(flag==false)
//			{
//				if(serviceHome.nextImg.isEnabled()==true)
//				{
//					serviceHome.nextImg.click();
//				}
//				else
//				{
//					break;
//				}
//			}
//
//		}
//
//		if(flag==false)
//		{
//			Assert.fail("Service not present");
//		}
//		
//		//Click on the resource button
//		
//		serviceHome.configurResourceBtn.click();
//}

}