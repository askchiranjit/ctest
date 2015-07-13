package com.ensimtest.tests.orderBct;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.*;

import com.ensimtest.config.Browser;
import com.ensimtest.module.authentication.LoginScreen;
import com.ensimtest.module.catalog.AddNewCategory;
import com.ensimtest.module.catalog.AddPriceForItemInOffer;
import com.ensimtest.module.catalog.CatalogOptions;
import com.ensimtest.module.catalog.OfferCategoryMainControls;
import com.ensimtest.module.catalog.OfferGeneralProperties;
import com.ensimtest.module.catalog.OfferItemConfigurationDetails;
import com.ensimtest.module.catalog.OfferMainController;
import com.ensimtest.module.catalog.OfferProvisioningInformationLst;
import com.ensimtest.module.catalog.OfferProvisioningWorkflow;
import com.ensimtest.module.catalog.OfferSubscriptionProperties;
import com.ensimtest.module.catalog.SearchCategory;
import com.ensimtest.module.catalog.SelectCurrenciesForOffer;
import com.ensimtest.module.catalog.SelectServiceForOfferCreation;
import com.ensimtest.module.utility.PopUPHandler;
import com.ensimtest.resource.TestDataProvider;
import com.ensimtest.utils.RandomData;
import com.ensimtest.utils.TestUtils;

public class OfferTestCases {

	private Browser browser;
	private RandomData randomData = new RandomData();
	private String categoryName;
	private String offerDisplayName;
	
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
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void createCategory(HashMap<?, ?> testData) throws Exception{
		
		//To get data from Test-Data (XLS based)
		String userName = testData.get("UserName").toString();
		String password = testData.get("password").toString();
		String categoryCode = randomData.getRandomAlfaNumeric(6);
		categoryName = "Automation Test Cat " + randomData.getRandomNum(3);
		String categoryDescription = categoryName + " Description";
		String addCategorySuccessMessage = "Offer category " + categoryName + " saved successfully.";
		
		//Navigate to ENSIM site
		browser.navigateTo();
		
		//To provide login screen values
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write(userName);
		loginScreen.password.write(password);
		
		//To click on login button
		loginScreen.loginBtn.click();
		
		//Go to catalog menu and click on offer option
		CatalogOptions catalogOptions = new CatalogOptions();
		catalogOptions.catalogMenu.mouseHover();
		catalogOptions.offersLnk.click();
		
		//To click on add category button
		OfferCategoryMainControls offerCategoryMainControls = new OfferCategoryMainControls();
		offerCategoryMainControls.offerAddCategoryBtn.click();
		
		//To provide category name and ID and description
		AddNewCategory addNewCategory = new AddNewCategory();
		addNewCategory.offerCategoryCodeTxt.write(categoryCode);
		addNewCategory.offerCategoryNameTxt.write(categoryName);
		addNewCategory.offerCategoryDescriptionTxt.write(categoryDescription);
		
		//To click on save button
		addNewCategory.offerCategorySaveBtn.click();
		
		//Success message checking and pop-up handle
		PopUPHandler popUPHandler = new PopUPHandler();
		Assert.assertEquals(addCategorySuccessMessage,popUPHandler.getPopUPData.read().trim());
		popUPHandler.acceptPopUP.click();
		
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData", dependsOnMethods={"createCategory"})
	public void createP2OSubscriptionOffer(HashMap<?, ?> testData) throws Exception{
		
		//To get data from Test-Data (XLS based)
		String userName = testData.get("UserName").toString();
		String password = testData.get("password").toString();
		String offerSaleType = testData.get("OfferSaleType").toString();
		String serviceName = testData.get("ServiceName").toString();
		String catalogID = "CatID" + randomData.getRandomNum(4);
		String tariffCode = "TCode" + randomData.getRandomNum(3);
		offerDisplayName = "Automation Test Offer" + randomData.getRandomNum(2);
		String offerDescription = offerDisplayName + "Description";
		String offerStatus = testData.get("OfferStatus").toString();
		String upgradeOffers = testData.get("UpgradeOffers").toString();
		String upgradeWeight = testData.get("UpgradeWeight").toString();
		String upsizeAllowed = testData.get("UpsizeAllowed").toString();
		String downsizeAllowed = testData.get("DownsizeAllowed").toString();
		String msgDuringUpgrade = testData.get("MessageDuringUpgrade").toString();
		String contractPeriodValue = testData.get("ContractPeriodValue").toString();
		String contractPeriodType = testData.get("contractPeriodType").toString();
		String maxNoOrdrPerOrg = testData.get("MaxNoOrdrPerOrg").toString();
		String dataRetentionPeriodType = testData.get("dataRetentionPeriodType").toString();
		String dataRetentionPeriodValue = testData.get("dataRetentionPeriodValue").toString();
		String custFld1 = randomData.getRandomAlfaNumeric(4);
		String subscriptionType = testData.get("SubscriptionType").toString();
		String subscriptionValue = testData.get("SubscriptionVlaue").toString();
		String subscriptionCode = testData.get("SubscriptionCode").toString();
		String renewalType = testData.get("RenewalType").toString();
		String upgradeWithinSub = testData.get("UpgradeWithinSub").toString();
		String renewActiveUser = testData.get("RenewActiveUser").toString();
		String currencies = testData.get("Currencies").toString();
		String itemNames = testData.get("ItemNames").toString();
		String purchaseOptions = testData.get("PurchaseOptions").toString();
		String unitPrices = testData.get("UnitPrices").toString();
		String minDiscountPrices = testData.get("MinDiscountPrices").toString();
		String maxDiscountPrices = testData.get("MaxDiscountPrices").toString();
		String provInfoNames = testData.get("ProvInfoNames").toString();
		String provVisibilities = testData.get("ProvVisibilities").toString();
		String provInfoDefaultValues = testData.get("ProvInfoDefaultValues").toString();
		String provWorkFlow = testData.get("ProvWorkFlow").toString();
		String orgApprove = testData.get("OrgApprove").toString();
		String providerApprove = testData.get("ProviderApprove").toString();
		String orderApproveTime = testData.get("OrderApproveTime").toString();
		String approveToEmail = testData.get("ApproveToEmail").toString();
		String approveCCEmail = testData.get("ApproveCCEmail").toString();
		
		//Navigate to ENSIM site
		browser.navigateTo();
		
		//To provide login screen values
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write(userName);
		loginScreen.password.write(password);
		
		//To click on login button
		loginScreen.loginBtn.click();
		
		//Go to catalog menu and click on offer option
		CatalogOptions catalogOptions = new CatalogOptions();
		catalogOptions.catalogMenu.mouseHover();
		catalogOptions.offersLnk.click();
		
		//To search provided category
		SearchCategory searchCategory = new SearchCategory();
		searchCategory.searchAndClickOnCategory(categoryName);
		TestUtils.delay(5000);
		
		//To click on Add offer button
		OfferCategoryMainControls offerCategoryMainControls = new OfferCategoryMainControls();
		offerCategoryMainControls.addOfferBtn.click();
		TestUtils.delay(5000);
		
		//To select offer selling type i.e. sale direct to Organization
		SelectServiceForOfferCreation selectServiceForOfferCreation = new SelectServiceForOfferCreation();
		
		if(offerSaleType.equalsIgnoreCase("P2O")){
			selectServiceForOfferCreation.froDirectOrganizationsRdo.click();
		}
		
		//To select a service under which want to create an offer
		selectServiceForOfferCreation.selectAServiceToCreateOfferRdo.select(serviceName);
		
		//To click on continue button
		selectServiceForOfferCreation.offerServiceSelectionContinueBtn.click();
		
//--------------offer page main controller--------------------------------------------------------------------------
		OfferMainController offerMainController = new OfferMainController();
		
//------------------To provide details in Offer's general properties section----------------------------------------
		OfferGeneralProperties offerGeneralProperties = new OfferGeneralProperties();
		
		//Check for category name
		Assert.assertEquals(categoryName, offerGeneralProperties.offerCategoryNameLst.read());
		
		//To provide catalog ID
		offerGeneralProperties.offerCatalogIDTxt.write(catalogID);
		
		//To provide tariff code
		offerGeneralProperties.offerTariffCodeTxt.write(tariffCode);
		
		//To provide offer name
		offerGeneralProperties.offerDisplayNameTxt.write(offerDisplayName);
		
		//To provide offer description
		offerGeneralProperties.offerDescriptionTxt.write(offerDescription);
		
		//To set offer status
		offerGeneralProperties.offerActivationStatusLst.select(offerStatus);
		
		//To set upgrade path
		TestUtils.delay(40000);
		String upgradeableToOfferLst[] = upgradeOffers.split(";");
		offerGeneralProperties.offerUpgradableToLst.select(upgradeableToOfferLst);
		
		//To set upgrade weight
		offerGeneralProperties.offerUpgradeWeightTxt.clear();
		offerGeneralProperties.offerUpgradeWeightTxt.write(upgradeWeight);
		
		//To un-check up-size allowed
		if(upsizeAllowed.equalsIgnoreCase("No")){
			offerGeneralProperties.offerUpsizeAllowedChk.click();
		}
		
		//To check or un-check down-size allowed
		if(downsizeAllowed.equalsIgnoreCase("Yes")){
			offerGeneralProperties.offerDownsizeAllowedChk.click();
		}
		
		//To check or un-check message during upgrade
		if(msgDuringUpgrade.equalsIgnoreCase("Yes")){
			offerGeneralProperties.offerMessageDuringUpgradeChk.click();
		}
		
		//To set contract period
		offerGeneralProperties.offerContractPeriodTypeLst.select(contractPeriodType);
		offerGeneralProperties.offerContractPeriodValueTxt.write(contractPeriodValue);
		
		//To maximum number of order per organization
		offerGeneralProperties.offerMaxOrderQtyPerOrgTxt.write(maxNoOrdrPerOrg);
		
		//To set contract period
		offerGeneralProperties.offerDataRetentionPeriodTypeLst.select(dataRetentionPeriodType);
		offerGeneralProperties.offerDataRetentionPeriodValueTxt.write(dataRetentionPeriodValue);
		
		//To set value for Custom Field 1
		offerGeneralProperties.offerCustomField1Txt.write(custFld1);
		
//----------------------------------Offer Subscription Properties---------------------------------------------------
		//To click on subscription properties link
		offerMainController.offerSubscriptionPropertiesLnk.click();
		
		OfferSubscriptionProperties offerSubscriptionProperties = new OfferSubscriptionProperties();
		
		//To select termed subscription
		offerSubscriptionProperties.offerTermedSubscriptionRdo.click();
		
		//To set value for subscription period
		offerSubscriptionProperties.offerSubscriptionPeriodTypeLst.select(subscriptionType);
		offerSubscriptionProperties.offerSubscriptionPeriodValueTxt.write(subscriptionValue);
		
		//To provide subscription code
		offerSubscriptionProperties.offerSubscriptionCodeTxt.write(subscriptionCode);
		
		//To set either auto renew or auto cancel
		if(renewalType.equalsIgnoreCase("Auto Cancel")){
			offerSubscriptionProperties.offerAutoCancelSubscriptionRdo.click();
		}
		
		//To check or un-check upgrade allowed during subscription
		if(upgradeWithinSub.equalsIgnoreCase("Yes")){
			offerSubscriptionProperties.offerAllowUpgradeDuringSubscriptionChk.click();
		}
		
		//To check or un-check renew with active user
		if(renewActiveUser.equalsIgnoreCase("Yes")){
			offerSubscriptionProperties.offerRenewSubscriptionWithActiveUserChk.click();
		}
		
//-----------------------------------Offer Item Configuration Link--------------------------------------------------
		//To click on Item configuration link
		offerMainController.offerItemConfigurationDetailsLnk.click();
		
		OfferItemConfigurationDetails offerItemConfigurationDetails = new OfferItemConfigurationDetails();
		
		//To select multiple currency
		offerItemConfigurationDetails.offerAvailableCurrenciesSelectBtn.click();
		String currencyList[] = currencies.split(";");
		SelectCurrenciesForOffer selectCurrenciesForOffer = new SelectCurrenciesForOffer();
		selectCurrenciesForOffer.selectCurrencies(currencyList, browser);
		selectCurrenciesForOffer.okButtonToSaveCurrency.click();
		TestUtils.delay(5000);
		
		//To add multiple items
		String itemNameList[] = itemNames.split(";");
		String purchaseOptionList[] = purchaseOptions.split(";");
		String unitPriceList[] = unitPrices.split(";");
		String minDisPriceList[] = minDiscountPrices.split(";");
		String maxDisPriceList[] = maxDiscountPrices.split(";");
		boolean priceBtn;
		AddPriceForItemInOffer addPriceForItemInOffer = new AddPriceForItemInOffer();
		
		for(int i=0;i<itemNameList.length;i++){
			offerItemConfigurationDetails.offerItemNameLst.select(itemNameList[i]);
			TestUtils.delay(5000);
			offerItemConfigurationDetails.offerPurchaseOptionsOfItemLst.select(purchaseOptionList[i]);
			
			priceBtn = offerItemConfigurationDetails.offerItemPriceBtn.isExists();
			
			if(priceBtn){
				offerItemConfigurationDetails.offerItemPriceBtn.click();
			}else{
				offerItemConfigurationDetails.offerPriceSelectLst.select("create another PricePlan");
			}
			
			//To provide values for price plan
			addPriceForItemInOffer.billingNameForItemTxt.write(itemNameList[i]);
			addPriceForItemInOffer.unitPriceForItemTxt.write(unitPriceList[i]);
			addPriceForItemInOffer.minDiscountPercentageTxt.write(minDisPriceList[i]);
			addPriceForItemInOffer.maxDiscountPercentageTxt.write(maxDisPriceList[i]);
			
			//To click on OK button
			addPriceForItemInOffer.pricePlanOKBtn.click(i);
			TestUtils.delay(10000);
			
			//To click on add button to add an item in offer
			offerItemConfigurationDetails.offerAddItemBtn.click();
			TestUtils.delay(15000);
		}
		
		//To set default values for provisioning Info and change visibility
		String provInfoNameList[] = provInfoNames.split(";");
		String provInfoVisibilityList[] = provVisibilities.split(";");
		String provInfoDefaultValueList[] = provInfoDefaultValues.split(";");
		
		OfferProvisioningInformationLst offerProvisioningInformationLst = new OfferProvisioningInformationLst();
		
		offerProvisioningInformationLst.writeProvisioningInfo(provInfoNameList, provInfoVisibilityList, provInfoDefaultValueList, browser);
		
//---------------------------------------Provisioning Work-Flow-------------------------------------------------------------------------
		
		//To click on Provisioning Work-flow link
		offerMainController.offerProvisioningWorkflowLnk.click();
		
		OfferProvisioningWorkflow offerProvisioningWorkflow = new OfferProvisioningWorkflow();
		
		//To set provisioning work flow
		offerProvisioningWorkflow.provisioningWorkflowLst.select(provWorkFlow);
		
		//To check organization must approve option
		if(orgApprove.equalsIgnoreCase("Yes")){
			offerProvisioningWorkflow.organizationMustApproveChk.click();
		}
		
		//To un-check provider must approve option
		if(providerApprove.equalsIgnoreCase("No")){
			offerProvisioningWorkflow.providerMustApproveChk.click();
		}
		
		//To provide value for order must approve time
		offerProvisioningWorkflow.orderMustApproveTimeTxt.write(orderApproveTime);
		
		//To set approve TO email id
		offerProvisioningWorkflow.toMailIDTxt.write(approveToEmail);
		
		//To set approve CC email id
		offerProvisioningWorkflow.cCMailIDTxt.write(approveCCEmail);
		
//------------------------------------------------To save offer------------------------------------------------------
		offerMainController.offerSaveBtn.click();
	}
	
}
