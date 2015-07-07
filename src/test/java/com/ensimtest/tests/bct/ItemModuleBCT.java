package com.ensimtest.tests.bct;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ensimtest.config.Browser;
import com.ensimtest.config.Element;
import com.ensimtest.module.authentication.LoginScreen;
import com.ensimtest.module.catalog.AddBaseItem;
import com.ensimtest.module.catalog.AddResources;
import com.ensimtest.module.catalog.AddService;
import com.ensimtest.module.catalog.CatalogOptions;
import com.ensimtest.module.catalog.ItemLandingPage;
import com.ensimtest.module.catalog.ItemList;
import com.ensimtest.module.catalog.ListOfSuggestedServices;
import com.ensimtest.module.catalog.ResourcesHome;
import com.ensimtest.module.catalog.ServiceHome;
import com.ensimtest.module.catalog.ServiceSearchInItemHome;
import com.ensimtest.module.catalog.ServiceSearchInItemHome.ServiceRowInItemHome;
import com.ensimtest.module.catalog.ServiceSearchResult;
import com.ensimtest.module.catalog.ServiceSearchResult.ServiceRow;
import com.ensimtest.module.utility.PopUPHandler;
import com.ensimtest.resource.GetEASMessages;
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
//
//		@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
//		public void importService(HashMap<?, ?> testData)
//		{
//			//Get Data From XLS file
//			String username = testData.get("UserName").toString();
//			String password = testData.get("password").toString();
//			String serviceXMLPath=testData.get("serviceXMLPath").toString();
//			String serviceSuccessMessage=testData.get("serviceSuccessMessage").toString();
//			String searchtags=testData.get("searchtags").toString();
//			String serviceName=testData.get("serviceName").toString();
//			String serviceID=testData.get("serviceID").toString();
//			String subscriptionType=testData.get("subscriptionType").toString();
//			String vendorName=testData.get("vendorName").toString();
//			String prosysID=testData.get("prosysID").toString();
//			String embeddedMessage=testData.get("embeddedMessage").toString();
//			String proviDelayTime=testData.get("proviDelayTime").toString();
//			String provDelayIn=testData.get("provDelayIn").toString();
//			String privateDNSRequired=testData.get("privateDNSRequired").toString();
//			String allowOnsameDNS=testData.get("allowOnsameDNS").toString();
//			String usageColRequired=testData.get("usageColRequired").toString();
//			String ADdomain=testData.get("ADdomain").toString();
//			String userManagement=testData.get("userManagement").toString();
//			String phoneNO=testData.get("phoneNO").toString();
//			String bulkAssignment=testData.get("bulkAssignment").toString();
//			String associateSameDomain=testData.get("associateSameDomain").toString();
//			String neverAssociateOrder=testData.get("neverAssociateOrder").toString();
//			String alwaysAssociateOrder=testData.get("alwaysAssociateOrder").toString();
//			String trackChangeSalesAgent=testData.get("trackChangeSalesAgent").toString();
//			String trackChangeTechnicalContact=testData.get("trackChangeTechnicalContact").toString();
//			String trackChangePI=testData.get("trackChangePI").toString();
//			String oneTimeProvision=testData.get("oneTimeProvision").toString();
//			String hostedService=testData.get("hostedService").toString();
//			String manualProvisioning=testData.get("manualProvisioning").toString();
//			String automaticProvisioning=testData.get("automaticProvisioning").toString();
//			String provisioningSystem=testData.get("provisioningSystem").toString();
//			String resellerCanConfig=testData.get("resellerCanConfig").toString();
//			String agentCanConfig=testData.get("agentCanConfig").toString();
//			String useEASCP=testData.get("useEASCP").toString();
//			String credentialstoTC=testData.get("credentialstoTC").toString();
//			String accessInformation=testData.get("accessInformation").toString();
//			// Navigate to ENSIM site
//			browser.navigateTo();
//			
//			//Navigate to login screen 
//			LoginScreen loginScreen = new LoginScreen();
//			
//			// Enter ISP credentials
//			loginScreen.username.write(username);
//			loginScreen.password.write(password);
//			
//			// Click Login button
//			loginScreen.loginBtn.click();
//			
//			//Click Service link
//			CatalogOptions catOptions=new CatalogOptions();
//			catOptions.catalogMenu.mouseHover();
//			catOptions.serviceslnk.click();
//			
//			//Click Add service button
//			ServiceHome serviceHome=new ServiceHome();
//			serviceHome.importServiceBtn.click();
//			//
//			ImportService importService=new ImportService();
//			importService.browseBtn.write(serviceXMLPath);
//			importService.importBtn.click();
//			PopUPHandler popUP=new PopUPHandler();
//			Assert.assertEquals(popUP.getPopUPData.read(),serviceSuccessMessage);
//			popUP.acceptPopUP.click();
//			serviceHome.editServiceBtn.click();
//			AddService addService=new AddService();
//			Assert.assertEquals(addService.serviceNameTxt.read(), serviceName);
//			Assert.assertEquals(addService.internalServiceIDTxt.read(), serviceID);
//			Assert.assertEquals(addService.subscriptionTypeTxt.read(), subscriptionType);
//			Assert.assertEquals(addService.vendorNameTxt.read(), vendorName);
//			Assert.assertEquals(addService.provSystemIdTxt.read(), prosysID);
//			Assert.assertEquals(addService.embeddedMessageTxt.read(), embeddedMessage);
//			Assert.assertEquals(addService.searchTagTxt.read(),searchtags);
//			Assert.assertEquals(addService.provisioningDelayTxt.read(), proviDelayTime);
//			Assert.assertEquals(addService.provisioningDelayLst.getSelectedType(), provDelayIn);
//			
//			if(privateDNSRequired.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.dNSRequireChk.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.dNSRequireChk.isSelecetd(), false);
//			}
//			
//			if(allowOnsameDNS.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.multipleOrdersOnSameDNSChk.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.multipleOrdersOnSameDNSChk.isSelecetd(), false);
//			}
//			
//			if(usageColRequired.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.usageCollectionRequireChk.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.usageCollectionRequireChk.isSelecetd(), false);
//			}
//			if(ADdomain.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.requireActiveDirectoryDomainChk.isSelecetd(), true);	
//			}
//			else
//			{
//				Assert.assertEquals(addService.requireActiveDirectoryDomainChk.isSelecetd(), false);
//			}
//			if(userManagement.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.hasUserManagementChk.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.hasUserManagementChk.isSelecetd(), false);
//			}
//			if(phoneNO.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.needPhNoChk.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.needPhNoChk.isSelecetd(), false);
//			}
//			if(bulkAssignment.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.bulkAssignment.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.bulkAssignment.isSelecetd(), false);
//			}
//			if(associateSameDomain.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.associateifSamePrivateDomainRdo.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.associateifSamePrivateDomainRdo.isSelecetd(), false);
//			}
//			if(neverAssociateOrder.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.neverAssociateOrderRdo.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.neverAssociateOrderRdo.isSelecetd(), false);
//			}
//			if(alwaysAssociateOrder.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.alwaysAssociateOrderRdo.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.alwaysAssociateOrderRdo.isSelecetd(), false);
//			}
//			if(trackChangeSalesAgent.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.trackChangeOfSalesAgentChk.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.trackChangeOfSalesAgentChk.isSelecetd(), false);
//			}
//			if(trackChangeTechnicalContact.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.trackChangeOfTechnicalContactChk.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.trackChangeOfTechnicalContactChk.isSelecetd(), false);
//			}
//			if(trackChangePI.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.trackChangeOfProvisioningInformationChk.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.trackChangeOfProvisioningInformationChk.isSelecetd(), false);
//			}
//			if(oneTimeProvision.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.oneTimeProvisioningRdo.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.oneTimeProvisioningRdo.isSelecetd(), false);
//			}
//			if(hostedService.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.hostedServiceRdo.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.hostedServiceRdo.isSelecetd(), false);
//			}
//			if(manualProvisioning.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.manualProvisioningRdo.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.manualProvisioningRdo.isSelecetd(), false);
//			}
//			if(automaticProvisioning.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.automaticProvisioningRdo.isSelecetd(), true);
//				Assert.assertEquals(addService.provisioningSystemLst.getSelectedProvisioningSystem(), provisioningSystem);
//			}
//			else
//			{
//				Assert.assertEquals(addService.automaticProvisioningRdo.isSelecetd(), false);
//			}
//			if(resellerCanConfig.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.resellerCanConfigureChk.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.resellerCanConfigureChk.isSelecetd(), false);
//			}
//			if(agentCanConfig.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.agentCanConfigureChk.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.agentCanConfigureChk.isSelecetd(), false);
//			}
//			if(useEASCP.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.useEASControlPanel.isSelecetd(), true);
//			}
//			else
//			{
//				Assert.assertEquals(addService.useEASControlPanel.isSelecetd(), false);
//			}
//			if(credentialstoTC.equalsIgnoreCase("Y"))
//			{
//				Assert.assertEquals(addService.sendAccessCredentialsChk.isSelecetd(), true);
//				Assert.assertEquals(addService.accessInformationTxt.read(), accessInformation);
//			}
//			else
//			{
//				Assert.assertEquals(addService.sendAccessCredentialsChk.isSelecetd(), false);
//			}
//			
//		}
//

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

		Assert.assertEquals(flag, true, "Service not present");

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

		Assert.assertEquals(flag, true, "Service not present");
		
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

	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void AddResource(HashMap<?, ?> testData)
	{
		boolean flag=false;

		String serviceName=testData.get("serviceName").toString();
		String username = testData.get("UserName").toString();
		String password = testData.get("password").toString();
		String resourceName=testData.get("resourceName").toString();
		String resourceID=testData.get("resourceID").toString();
		boolean provisioningInfo=Boolean.valueOf(testData.get("provisioningInfo").toString());
		boolean askInFstOrdrOnly=Boolean.valueOf(testData.get("askInFstOrdrOnly").toString());
		boolean askInEveryOrdr=Boolean.valueOf(testData.get("askInEveryOrdr").toString());
		boolean unique=Boolean.valueOf(testData.get("unique").toString());
		boolean mandatory=Boolean.valueOf(testData.get("mandatory").toString());
		boolean editable=Boolean.valueOf(testData.get("editable").toString());
		String resourceType=testData.get("resourceType").toString();
		String inputType=testData.get("inputType").toString();
		String defaultValue=testData.get("defaultValue").toString();
		boolean orderItem=Boolean.valueOf(testData.get("orderItem").toString());
		boolean payPerUseTrue=Boolean.valueOf(testData.get("payPerUseTrue").toString());
		boolean payPerUseFalse=Boolean.valueOf(testData.get("payPerUseFalse").toString());
		String reportedValPer=testData.get("reportedValPer").toString();
		String defaultQuantity=testData.get("defaultQuantity").toString();
		String resouceCat=testData.get("resouceCat").toString();
		boolean availableForUser=Boolean.valueOf(testData.get("availableForUser").toString());
		String reservationUnit=testData.get("reservationUnit").toString();
		String provsysunit=testData.get("provsysunit").toString();
		String resCovFactor=testData.get("resCovFactor").toString();
		String resCovOperation=testData.get("resCovOperation").toString();
		String ppuUnit=testData.get("ppuUnit").toString();
		String ppuProvSysUnit=testData.get("ppuProvSysUnit").toString();
		String ppuConvFactor=testData.get("ppuConvFactor").toString();
		String ppuConvOperation=testData.get("ppuConvOperation").toString();
		String meteringRule=testData.get("meteringRule").toString();
		String ppuReportingMechanishm=testData.get("ppuReportingMechanishm").toString();
		//Random data
		
		resourceName=resourceName+" "+randomdata.getRandomNum(6);
		resourceID=resourceID+" "+randomdata.getRandomNum(6);
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
		TestUtils.delay(5000);
		serviceHome.searchServiceTxt.write(serviceName);
		serviceHome.searchServiceImg.click();
		TestUtils.delay(2000);

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

		if(flag==false)
		{
			Assert.fail("Service not present");
		}
		
		//Click on the resource button
		TestUtils.delay(5000);
		
		serviceHome.configurResourceBtn.click();
		
		TestUtils.delay(5000);
		
		ResourcesHome resourceHome=new ResourcesHome();
		//Click on Add Resource Button
		resourceHome.addResourcesBtn.click();
		
		AddResources addResource=new AddResources();
		//input to the fields
		addResource.resourceNameTxt.write(resourceName);
		addResource.resourceIDTxt.write(resourceID);
		
		if(provisioningInfo)
		{
			addResource.provisioningInformationRdo.click();
			click(addResource.askInFirstOrderRdo, askInFstOrdrOnly);
			click(addResource.askInEveryOrderRdo, askInEveryOrdr);
			click(addResource.uniqueChk, unique);
			click(addResource.mandetoryChk, mandatory);
			click(addResource.editableAfterProvisioningChk, editable);
			addResource.pIFResourceTypeLst.selectResourceType(resourceType);
			addResource.pIFInputTypeLst.selectInputType(inputType);
			addResource.defaultValueTxt.write(defaultValue);
		}
		
		if(orderItem)
		{
			addResource.orderItemRdo.click();
			if(payPerUseTrue)
			{
				addResource.payPerUseTrueRdo.click();
				addResource.reportedValuePerTxt.clear();
				addResource.reportedValuePerTxt.write(reportedValPer);
			}
			click(addResource.payPerUseFalseRdo, payPerUseFalse);
			addResource.dafaultQuantityTxt.clear();
			addResource.dafaultQuantityTxt.write(defaultQuantity);
			addResource.resourceCategoryTxt.write(resouceCat);
			click(addResource.availableForUserChk, availableForUser);
			addResource.reservationUnitLst.selectReservationUnit(reservationUnit);
			addResource.reservProvisioningSystemUnitTxt.clear();
			addResource.reservProvisioningSystemUnitTxt.write(provsysunit);
			addResource.reservConvertionFactorTxt.clear();
			addResource.reservConvertionFactorTxt.write(resCovFactor);
			addResource.reservConversionOperationLst.selectReservConversionOperation(resCovOperation);
			addResource.pPUUnitLst.selectPPUUnit(ppuUnit);
			addResource.pPUProvisioningSystemUnitTxt.clear();
			addResource.pPUProvisioningSystemUnitTxt.write(ppuProvSysUnit);
			addResource.pPUConvertionFactorTxt.clear();
			addResource.pPUConvertionFactorTxt.write(ppuConvFactor);
			addResource.pPUConversionOperationLst.selectPPUConversion(ppuConvOperation);
			addResource.meteringRuleLst.selectMeteringRule(meteringRule);
			addResource.pPUReportingMechanismLst.selectPPUReportingMechanism(ppuReportingMechanishm);
			
		}
		
		addResource.saveBtn.click();
		PopUPHandler popUpHandler=new PopUPHandler();
		Assert.assertEquals(getMessage.getProperty("resource_add_successful"), popUpHandler.getPopUPData.read());
		popUpHandler.acceptPopUP.click();
		
		//clicking edit resource button
		resourceHome.editResourcesBtn.click();
		
		//Verifications
		Assert.assertEquals(addResource.resourceNameTxt.read(), resourceName);
		Assert.assertEquals(addResource.resourceIDTxt.read(), resourceID);
		
		if(provisioningInfo)
		{
			Assert.assertEquals(addResource.provisioningInformationRdo.isSelected(), provisioningInfo);
			Assert.assertEquals(addResource.askInFirstOrderRdo.isSelected(), askInFstOrdrOnly);
			Assert.assertEquals(addResource.askInEveryOrderRdo.isSelected(), askInEveryOrdr);
			Assert.assertEquals(addResource.uniqueChk.isSelected(), unique);
			Assert.assertEquals(addResource.mandetoryChk.isSelected(), mandatory);
			Assert.assertEquals(addResource.editableAfterProvisioningChk.isSelected(), editable);
			Assert.assertEquals(addResource.pIFResourceTypeLst.getSelectedType(), resourceType);
			Assert.assertEquals(addResource.pIFInputTypeLst.getSelectedType(), inputType);
			Assert.assertEquals(addResource.defaultValueTxt.read(), defaultValue);
		}
		if(orderItem)
		{
			Assert.assertEquals(addResource.orderItemRdo.isSelected(), orderItem);
			Assert.assertEquals(addResource.payPerUseTrueRdo.isSelected(), payPerUseTrue);
			if(payPerUseTrue)
			{
				if(!ppuReportingMechanishm.equalsIgnoreCase("No PPU"))
				{
					System.out.println("Insideeeee");
				Assert.assertEquals(addResource.reportedValuePerTxt.read(), reportedValPer);
				}
			}
			Assert.assertEquals(addResource.payPerUseFalseRdo.isSelected(), payPerUseFalse);
			Assert.assertEquals(addResource.dafaultQuantityTxt.read().toString(),defaultQuantity);
			Assert.assertEquals(addResource.resourceCategoryTxt.read(), resouceCat);
			Assert.assertEquals(addResource.availableForUserChk.isSelected(), availableForUser);
			Assert.assertEquals(addResource.reservationUnitLst.getSelectedType(), reservationUnit);
			Assert.assertEquals(addResource.reservProvisioningSystemUnitTxt.read(), provsysunit);
			Assert.assertEquals(addResource.reservConvertionFactorTxt.read(), resCovFactor);
			Assert.assertEquals(addResource.reservConversionOperationLst.getSelectedType(), resCovOperation);
			Assert.assertEquals(addResource.pPUUnitLst.getSelectedType(), ppuUnit);
			Assert.assertEquals(addResource.pPUProvisioningSystemUnitTxt.read(), ppuProvSysUnit);
			Assert.assertEquals(addResource.pPUConvertionFactorTxt.read(), ppuConvFactor);
			Assert.assertEquals(addResource.pPUConversionOperationLst.getSelectedType(), ppuConvOperation);
			Assert.assertEquals(addResource.meteringRuleLst.getSelectedType(), meteringRule);
			Assert.assertEquals(addResource.pPUReportingMechanismLst.getSelectedType(), ppuReportingMechanishm);
			
		}
		
		addResource.cancelBtn.click();
		
		Assert.assertEquals(resourceHome.resourcesHeadingTxt.isExists(), true,"Not return to Resource Home Page");
			
}
    
 @Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
 public void addBaseItem(HashMap<?, ?> testData)
 {
	 boolean flag=false;
	 boolean flag1=true;
	 String username = testData.get("UserName").toString();
	 String password = testData.get("password").toString();
	 String serviceName=testData.get("serviceName").toString();
	 String itemCode=testData.get("itemCode").toString();
	 String itemName=testData.get("itemName").toString();
	 String uniqueIdentifier=testData.get("uniqueIdentifier").toString();
	 String description=testData.get("description").toString();
	 String reqProvInfos=testData.get("reqProvInfos").toString();
	 String custom1=testData.get("custom1").toString();
	 String custom2=testData.get("custom2").toString();
	 String custom3=testData.get("custom3").toString();
	 String custom4=testData.get("custom4").toString();
	 String custom5=testData.get("custom5").toString();
	 String custom6=testData.get("custom6").toString();
	 String custom7=testData.get("custom7").toString();
	 String custom8=testData.get("custom8").toString();
	 String custom9=testData.get("custom9").toString();
	 String custom10=testData.get("custom10").toString();
	 String custom11=testData.get("custom11").toString();
	 String custom12=testData.get("custom12").toString();
	 String billOfMat=testData.get("billOfMat").toString();
	 String primaryvenCost=testData.get("primaryvenCost").toString();
	 String resourceRef=testData.get("resourceRef").toString();
	 String itemType=testData.get("itemType").toString();
	 
			 
		//Random data
		
	 itemCode=itemCode+" "+randomdata.getRandomNum(5);
	 itemName=itemName+" "+randomdata.getRandomNum(6);
	 uniqueIdentifier=uniqueIdentifier+"_"+randomdata.getRandomNum(6);

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
	 catOptions.itemsAndRPPLnk.click();
	 //
	 ItemLandingPage itemLandingPage=new ItemLandingPage();
	 ServiceSearchInItemHome servSerchItem=new ServiceSearchInItemHome();
	
	 ServiceRowInItemHome[] ser;
	 while(flag==false)
	 {
		 
		 ser=servSerchItem.serviceResultRow.getServiceRows();

		 for(int i=0;i<ser.length;i++)
		 {
			 if(ser[i].serviceName.read().equalsIgnoreCase(serviceName))
			 {
				 ser[i].serviceName.click();
				 TestUtils.delay(2000);
				 flag=true;
				 break;
			 }


		 }
		 if(flag==false)
		 {
			 if(itemLandingPage.nextImg.isEnabled()==true)
			 {
				 itemLandingPage.nextImg.click();
				 TestUtils.delay(2000);
			 }
			 else
			 {
				 break;
			 }
		 }

	 }

	 Assert.assertEquals(flag,true,"Service not present");
	 
	 //click on base item button
	 itemLandingPage=new ItemLandingPage();
	 itemLandingPage.baseItemBtn.click();
	 
	 AddBaseItem addBaseItem=new AddBaseItem();
	 
	 //putting value to item fields
	 addBaseItem.itemCodeTxt.write(itemCode);
	 
	 if(!uniqueIdentifier.startsWith("_"))
	 {
		 addBaseItem.uniqueIdentifierTxt.write(uniqueIdentifier);
		 addBaseItem.itemNameTxt.click();
		 TestUtils.delay(5000);
		 Assert.assertEquals(addBaseItem.guidAvailable.read(), getMessage.getProperty("guid_available"));
	 }
	 addBaseItem.itemNameTxt.write(itemName);
	 addBaseItem.descriptionTxt.write(description);
	 addBaseItem.customField1.write(custom1);
	 addBaseItem.customField2.write(custom2);
	 addBaseItem.customField3.write(custom3);
	 addBaseItem.customField4.write(custom4);
	 addBaseItem.customField5.write(custom5);
	 addBaseItem.customField6.write(custom6);
	 addBaseItem.customField7.write(custom7);
	 addBaseItem.customField8.write(custom8);
	 addBaseItem.customField9.write(custom9);
	 addBaseItem.customField10.write(custom10);
	 addBaseItem.customField11.write(custom11);
	 addBaseItem.customField12.write(custom12);
	 addBaseItem.billOfMaterialCostTxt.clear();
	 addBaseItem.billOfMaterialCostTxt.write(billOfMat);
	 addBaseItem.primaryVendorCostTxt.write(primaryvenCost);
	 addBaseItem.resourceRefLst.selectResourceRef(resourceRef);
	 addBaseItem.itemTypeLst.selectItemType(itemType);
	 
	 String provinfos[]=reqProvInfos.split(";");
	 for(int i=0;i<provinfos.length;i++)
	 {
		 addBaseItem.provInfoReq.selectProvInfo(provinfos[i].toString().trim());
	 }
	 
	 addBaseItem.saveBtn.click();
	 
	 
	 //Verify add item msg
	 ItemList itemList=new ItemList();
	 
	 Assert.assertEquals(itemList.itemSuccessMsg.read(), getMessage.getProperty("add_base_item_success"));
	 
	 //verifying every field for base item
	 
	 itemList.editItemBtn.click();
	 Assert.assertEquals(addBaseItem.itemNameTxt.read(), itemName);
	 Assert.assertEquals(addBaseItem.itemCodeTxt.read(), itemCode);
	 if(!uniqueIdentifier.startsWith("_"))
	 {
		 Assert.assertEquals(addBaseItem.uniqueIdentifierTxt.read(), uniqueIdentifier);
	 }
	 Assert.assertEquals(addBaseItem.descriptionTxt.read(), description);
	 Assert.assertEquals(addBaseItem.billOfMaterialCostTxt.read(), billOfMat);
	 Assert.assertEquals(addBaseItem.primaryVendorCostTxt.read(), primaryvenCost);
	 Assert.assertEquals(addBaseItem.customField1.read(),custom1);
	 Assert.assertEquals(addBaseItem.customField2.read(),custom2);
	 Assert.assertEquals(addBaseItem.customField3.read(),custom3);
	 Assert.assertEquals(addBaseItem.customField4.read(),custom4);
	 Assert.assertEquals(addBaseItem.customField5.read(),custom5);
	 Assert.assertEquals(addBaseItem.customField6.read(),custom6);
	 Assert.assertEquals(addBaseItem.customField7.read(),custom7);
	 Assert.assertEquals(addBaseItem.customField8.read(),custom8);
	 Assert.assertEquals(addBaseItem.customField9.read(),custom9);
	 Assert.assertEquals(addBaseItem.customField10.read(),custom10);
	 Assert.assertEquals(addBaseItem.customField11.read(),custom11);
	 Assert.assertEquals(addBaseItem.customField12.read(),custom12);
	 Assert.assertEquals(addBaseItem.resourceRefLst.getSelectedType(), resourceRef);
	 Assert.assertEquals(addBaseItem.itemTypeLst.getSelectedType(), itemType);
	 
	 String gete[]=addBaseItem.provInfoReq.getAllSelectedIdfrs();
	 
	 for(int i=0;i<provinfos.length;i++)
	 {
		boolean contains=false; 
		for(int j=0;j<gete.length;j++)
		{
			if(provinfos[i].equalsIgnoreCase(gete[j]))
			{
				contains=true;
				break;
			}
		}
		if(contains==false)
		{
			flag1=false;
			break;
		}
	 }
	 
	 Assert.assertEquals(flag1, true,"Provisioning information's not selected properly");
	
	 addBaseItem.cancleBtn.click();
	 
	 Assert.assertEquals(itemLandingPage.headingTxt.read(), getMessage.getProperty("item_landing_page_heading"));

	 
 
 }
 

}
