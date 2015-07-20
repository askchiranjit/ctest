package com.ensimtest.tests.orderBct;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ensimtest.config.Browser;
import com.ensimtest.module.authentication.LoginScreen;
import com.ensimtest.module.entities.OrganizationDetailsButtons;
import com.ensimtest.module.entities.SearchOrganization;
import com.ensimtest.module.orders.CreateOrderMasterControl;
import com.ensimtest.module.orders.CreateOrderSelectCategory;
import com.ensimtest.module.orders.CreateOrderSelectItems;
import com.ensimtest.module.orders.CreateOrderSelectItems.ItemRow;
import com.ensimtest.module.orders.CancelOrder;
import com.ensimtest.module.orders.CreateOrderSummary;
import com.ensimtest.module.orders.OrderAdvSearch;
import com.ensimtest.module.orders.CreateOrderSelectOffer;
import com.ensimtest.module.orders.OrderISPButtons;
import com.ensimtest.module.orders.OrderList;
import com.ensimtest.module.orders.OrderProvisioningInfo;
import com.ensimtest.module.orders.OrderSearch;
import com.ensimtest.module.orders.UpgradeOrder;
import com.ensimtest.module.orders.UpsizeOrderSelectItems;
import com.ensimtest.module.orders.CreateOrderSelectOffer.Offer;
import com.ensimtest.module.orders.OrderList.OrderRow;
import com.ensimtest.module.orders.OrderProvisioningInfo.ProvItemLst;
import com.ensimtest.module.orders.UpgradeOrder.OrderOption;
import com.ensimtest.module.orders.UpsizeOrderSelectItems.UpsizeItemRow;
import com.ensimtest.module.orders.OrderOptions;
import com.ensimtest.module.orders.SearchOrder;
import com.ensimtest.module.orders.SelectAcFromOrg;
import com.ensimtest.module.userspace.LoggedInUser;
import com.ensimtest.module.utility.OrderUtility;
import com.ensimtest.module.utility.PerformAction;
import com.ensimtest.resource.TestDataProvider;
import com.ensimtest.utils.OrderItemJsonHandler;
import com.ensimtest.utils.OrderProvInfoJsonHandler;
import com.ensimtest.utils.TestUtils;
import com.ensimtest.utils.OrderItemJsonHandler.ItemDetails;
import com.ensimtest.utils.OrderProvInfoJsonHandler.ProvInfoDetails;

public class OrderIspBCT
{
	private Browser browser;
	private String refNo="";
	
	@BeforeClass
	public void setUp()
	{
		browser = new Browser();
	}
	
	@AfterClass
	public void tearDown()
	{
		browser.close();
	}
	

	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void placeOrder(HashMap<?, ?> data) throws Exception
    {
		String userName = data.get("UserName").toString();
		String password = data.get("Password").toString();
		String orgName = data.get("OrgName").toString();
		String category = data.get("category").toString();
		String offerName = data.get("offerName").toString();
		//String orgID = data.get("orgID").toString();
		String itemDetails = data.get("itemDetails").toString();
		String provInfo = data.get("provInfoDetails").toString();
		
		browser.navigateTo();

		LoginScreen loginScreen = new LoginScreen();
		
		loginScreen.username.write(userName);
		loginScreen.password.write(password);

		// Click on login button
		loginScreen.loginBtn.click();
		
		OrderOptions order = new OrderOptions();
		order.orderMenu.mouseHover();
		
		order.createOrderLnk.click();
		
		SearchOrganization search = new SearchOrganization();
		search.keywordTxt.write(orgName);
		TestUtils.delay(2000);
		System.out.println("Clicking...");
		search.searchTypeContains.click();
		TestUtils.delay(2000);
		search.searchBtn.click();
		
		TestUtils.delay(10000);
		
		OrganizationDetailsButtons button = new OrganizationDetailsButtons();
		button.createOrderBtn.click();
		
		SelectAcFromOrg acc = new SelectAcFromOrg();
		acc.selectAccountBtn.click();
		TestUtils.delay(5000);
		
		CreateOrderSelectCategory cat = new CreateOrderSelectCategory();
		System.out.println("category : " + category);
		cat.categories.selectCategory(category);
		
		TestUtils.delay(2000);
		
		CreateOrderSelectOffer offer = new CreateOrderSelectOffer();
		Offer []offers = offer.getOffers();
		
		for(int i=0; i<offers.length; i++)
		{
			if(offers[i].offerName.equals(offerName))
			{
				offers[i].orderBtn.click();
				break;
			}
		}
		
		CreateOrderMasterControl buttons = new CreateOrderMasterControl();
		browser.waitForElement(buttons.continueBtn, 60*1000);
		
		PerformAction performActn=new PerformAction();
		CreateOrderSelectItems items = new CreateOrderSelectItems();
		ItemRow itemr[]=items.getItemRows(browser);
		OrderItemJsonHandler orderItems=new OrderItemJsonHandler();
		ItemDetails itemdetailslst[]= orderItems.itemDetails(itemDetails);
		for(int i=0;i<itemdetailslst.length;i++)
		{
			for(int j=0;j<itemr.length;j++)
			{
				if(itemdetailslst[i].itemName.equalsIgnoreCase(itemr[j].itemName))
				{
					if(itemdetailslst[i].operation==true)
					{
						if(itemdetailslst[i].checkbox==true)
						{
							performActn.doActionOnElement(itemr[j].checkBox, "checkbox", itemdetailslst[i].value);
						}

						if(itemdetailslst[i].textbox==true)
						{
							performActn.doActionOnElement(itemr[j].textBox, "textbox", itemdetailslst[i].value);
						}
						if(itemdetailslst[i].dropdown==true)
						{
							performActn.doActionOnElement(itemr[j].listBox, "dropdown", itemdetailslst[i].value);
						}
					}

					break;
				}
			}
		}
		
		
		TestUtils.delay(3000);
		
		buttons.continueBtn.click();
		TestUtils.delay(3000);
		buttons.continueBtn.click();
		
		OrderProvisioningInfo prov = new OrderProvisioningInfo();
		ProvItemLst provItemLst[]=prov.provInfoLst.getProvInfos(browser);

		OrderProvInfoJsonHandler orderProvInfoJsonHandler=new OrderProvInfoJsonHandler();
		ProvInfoDetails provInfoDetails[]=orderProvInfoJsonHandler.provInfoLst(provInfo);


		for(int i=0;i<provInfoDetails.length;i++)
		{
			for(int j=0;j<provItemLst.length;j++)
			{
				if(provInfoDetails[i].itemName.equalsIgnoreCase(provItemLst[j].itemName))
				{
					System.out.println("Inside");
					if(provInfoDetails[i].operation==true)
					{
						if(provInfoDetails[i].checkbox==true)
						{
							performActn.doActionOnElement(provItemLst[j].textbox, "checkbox", provInfoDetails[i].value);
						}

						if(provInfoDetails[i].textbox==true)
						{
							performActn.doActionOnElement(provItemLst[j].textbox, "textbox", provInfoDetails[i].value);
						}
						if(provInfoDetails[i].dropdown==true)
						{
							performActn.doActionOnElement(provItemLst[j].dropDown, "dropdown", provInfoDetails[i].value);
						}
					}

					break;
				}
			}
		}
		
		buttons.continueBtn.click();
		TestUtils.delay(6000);
		buttons.placeOrderBtn.click();
		TestUtils.delay(20000);
		
		// Approve order
		CreateOrderSummary summary = new CreateOrderSummary();
		summary.approveOrderApproveNowBtn.click();
		
		// Read the order number
		refNo = summary.approveOrderMsgLbl.getRefNumber().trim();
		System.out.println(refNo);
		
		order.orderMenu.mouseHover();
		TestUtils.delay(2000);
		order.listOrderLnk.click();
		
		// Search for the order
		SearchOrder searchOrder = new SearchOrder();
		searchOrder.orderIdTxt.write(refNo);
		searchOrder.searchBtn.click();
		TestUtils.delay(20000);
		// Verify in result
		OrderList listOfOrder = new OrderList();
		OrderRow []rows = listOfOrder.getOrderResultRows("recent");
		
		// Verify only one result is found
		Assert.assertEquals(rows.length, 1);
		
		// Click on the offer
		rows[0].link.click();
		TestUtils.delay(3000);
		
//		// Verify order information
//		OrderDetails details = new OrderDetails();
//		Assert.assertEquals(details.orderInfo.orgName, orgName);
//		Assert.assertEquals(details.orderInfo.orderId, refNo);
//		Assert.assertEquals(details.orderInfo.orgID, orgID);
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData", dependsOnMethods = { "placeOrder" })
	public void verifyOrderProvisioned(HashMap<?, ?> data) throws Exception
	{
		String purchesOrderNo =data.get("purchesOrderNo").toString() ;
		
		listOrder();
		
		// Search by purchase Order Number
		OrderSearch orderSearch = new OrderSearch();
		orderSearch.advSearchBtn.click();
		OrderAdvSearch advanceSearch = new OrderAdvSearch();
		advanceSearch.purchaseOrderNum.write(purchesOrderNo);
		advanceSearch.searchBtn.click();
		TestUtils.delay(20000);
		
		// Verify in result
		OrderList listOfOrder = new OrderList();
		OrderRow []rows = listOfOrder.getOrderResultRows("recent");
		
		// Verify only one result is found
		Assert.assertEquals(rows.length, 1);
		
		// Verify provisioned
		OrderUtility orderUtility = new OrderUtility();
		boolean updateInfo = orderUtility.waitForStatusUpdate(rows[0], "Provisioned", 5 * 60);
		Assert.assertEquals(updateInfo, true);
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData", dependsOnMethods = { "verifyOrderProvisioned" })
	public void upsizeOrder(HashMap<?, ?> data) throws Exception
	{
		String itemDetails=data.get("itemDetails").toString();
		
		// Click on Up-size
		OrderISPButtons ispButtons = new OrderISPButtons();
		Assert.assertEquals(ispButtons.upsizeBtn.isEnabled(), true);
		ispButtons.upsizeBtn.click();
		
		
		CreateOrderMasterControl buttons = new CreateOrderMasterControl();
		browser.waitForElement(buttons.continueBtn, 60*1000);
		// Update items
		PerformAction performActn=new PerformAction();
		UpsizeOrderSelectItems items = new UpsizeOrderSelectItems();
		UpsizeItemRow itemr[]=items.getItemRows(browser);
		OrderItemJsonHandler orderItems=new OrderItemJsonHandler();
		ItemDetails itemdetailslst[]=orderItems.itemDetails(itemDetails);
		
		
		for(int i=0;i<itemr.length;i++)
		{
			System.out.println(itemr[i].itemName);
			System.out.println(itemr[i].checkBox);
			System.out.println(itemr[i].checkedMark);
			System.out.println(itemr[i].listBox);
			System.out.println(itemr[i].textBox);
		}
		
		for(int i=0;i<itemdetailslst.length;i++)
		{
			for(int j=0;j<itemr.length;j++)
			{
				if(itemdetailslst[i].itemName.equalsIgnoreCase(itemr[j].itemName))
				{
					if(itemdetailslst[i].operation==true)
					{
						if(itemdetailslst[i].checkbox==true)
						{
							performActn.doActionOnElement(itemr[j].checkBox, "checkbox", itemdetailslst[i].value);
						}

						if(itemdetailslst[i].textbox==true)
						{
							performActn.doActionOnElement(itemr[j].textBox, "textbox", itemdetailslst[i].value);
						}
						if(itemdetailslst[i].dropdown==true)
						{
							performActn.doActionOnElement(itemr[j].listBox, "dropdown", itemdetailslst[i].value);
						}
					}

					break;
				}
			}
		}
		
		// Updated the data
		
		// click on Continue
		buttons.continueBtn.click();
		TestUtils.delay(3000);
		
		// Contact details
		buttons.continueBtn.click();
		TestUtils.delay(3000);
		
		// Provisioning info.
		buttons.continueBtn.click();
		TestUtils.delay(3000);
		
		// Summary
		buttons.placeOrderBtn.click();
		TestUtils.delay(20000);
		
		// Approve now
		CreateOrderSummary summary = new CreateOrderSummary();
		summary.approveOrderApproveNowBtn.click();
		
		// Get the order number
		String upsizedOrderNumber = summary.approveOrderMsgLbl.getRefNumber().trim();
		Assert.assertEquals(upsizedOrderNumber, refNo);
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData", dependsOnMethods = { "upsizeOrder" })
	public void verifyOrderUpsized(HashMap<?, ?> data) throws Exception
	{
		String purchesOrderNo =data.get("purchesOrderNo").toString() ;
		
		listOrder();
		
		// Search by purchase Order Number
		OrderSearch orderSearch = new OrderSearch();
		orderSearch.advSearchBtn.click();
		OrderAdvSearch advanceSearch = new OrderAdvSearch();
		advanceSearch.purchaseOrderNum.write(purchesOrderNo);
		advanceSearch.searchBtn.click();
		TestUtils.delay(20000);
		
		// Verify in result
		OrderList listOfOrder = new OrderList();
		OrderRow []rows = listOfOrder.getOrderResultRows("recent");
		
		// Verify only one result is found
		Assert.assertEquals(rows.length, 1);
		
		// Verify provisioned
		OrderUtility orderUtility = new OrderUtility();
		boolean updateInfo = orderUtility.waitForStatusUpdate(rows[0], "Upsized", 5 * 60);
		Assert.assertEquals(updateInfo, true);
	}
	//
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData", dependsOnMethods = { "verifyOrderUpsized" })
	public void downsizeOrder(HashMap<?, ?> data) throws Exception
	{
		String itemDetails=data.get("itemDetails").toString();
		
		// Click on Up-size
		OrderISPButtons ispButtons = new OrderISPButtons();
		Assert.assertEquals(ispButtons.downsizeBtn.isEnabled(), true);
		ispButtons.downsizeBtn.click();
		
		CreateOrderMasterControl buttons = new CreateOrderMasterControl();
		browser.waitForElement(buttons.continueBtn, 60*1000);
		// Update items
		PerformAction performActn=new PerformAction();
		UpsizeOrderSelectItems items = new UpsizeOrderSelectItems();
		UpsizeItemRow itemr[]=items.getItemRows(browser);
		OrderItemJsonHandler orderItems=new OrderItemJsonHandler();
		ItemDetails itemdetailslst[]=orderItems.itemDetails(itemDetails);
		
		
		for(int i=0;i<itemr.length;i++)
		{
			System.out.println(itemr[i].itemName);
			System.out.println(itemr[i].checkBox);
			System.out.println(itemr[i].checkedMark);
			System.out.println(itemr[i].listBox);
			System.out.println(itemr[i].textBox);
		}
		
		for(int i=0;i<itemdetailslst.length;i++)
		{
			for(int j=0;j<itemr.length;j++)
			{
				if(itemdetailslst[i].itemName.equalsIgnoreCase(itemr[j].itemName))
				{
					if(itemdetailslst[i].operation==true)
					{
						if(itemdetailslst[i].checkbox==true)
						{
							performActn.doActionOnElement(itemr[j].checkBox, "checkbox", itemdetailslst[i].value);
						}

						if(itemdetailslst[i].textbox==true)
						{
							performActn.doActionOnElement(itemr[j].textBox, "textbox", itemdetailslst[i].value);
						}
						if(itemdetailslst[i].dropdown==true)
						{
							performActn.doActionOnElement(itemr[j].listBox, "dropdown", itemdetailslst[i].value);
						}
					}

					break;
				}
			}
		}
		
		// Updated the data
		
		// click on Continue

		buttons.continueBtn.click();
		TestUtils.delay(3000);
		
		// Contact details
		buttons.continueBtn.click();
		TestUtils.delay(3000);
		
		// Provisioning info.
		buttons.continueBtn.click();
		TestUtils.delay(3000);
		
		// Summary
		buttons.placeOrderBtn.click();
		TestUtils.delay(20000);
		
		// Approve now
		CreateOrderSummary summary = new CreateOrderSummary();
		summary.approveOrderApproveNowBtn.click();
		
		// Get the order number
		String upsizedOrderNumber = summary.approveOrderMsgLbl.getRefNumber().trim();
		Assert.assertEquals(upsizedOrderNumber, refNo);
	}

	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData", dependsOnMethods = { "downsizeOrder" })
	public void verifyOrderDownsized(HashMap<?, ?> data) throws Exception
	{
		String purchesOrderNo =data.get("purchesOrderNo").toString() ;
		
		listOrder();
		
		// Search by purchase Order Number
		OrderSearch orderSearch = new OrderSearch();
		orderSearch.advSearchBtn.click();
		OrderAdvSearch advanceSearch = new OrderAdvSearch();
		advanceSearch.purchaseOrderNum.write(purchesOrderNo);
		advanceSearch.searchBtn.click();
		TestUtils.delay(20000);
		
		// Verify in result
		OrderList listOfOrder = new OrderList();
		OrderRow []rows = listOfOrder.getOrderResultRows("recent");
		
		// Verify only one result is found
		Assert.assertEquals(rows.length, 1);
		
		// Verify provisioned
		OrderUtility orderUtility = new OrderUtility();
		boolean updateInfo = orderUtility.waitForStatusUpdate(rows[0], "Downsized", 5 * 60);
		Assert.assertEquals(updateInfo, true);
	}
//	
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData",dependsOnMethods = { "verifyOrderDownsized" })
	public void upgradeOrder(HashMap<?, ?> testData) throws Exception
	{
    	// Get data from test-data (XLS based)	
		String upgradeOfferName=testData.get("upgradeOfferName").toString();
		String itemDetails=testData.get("itemDetails").toString();
		String provInfo=testData.get("provInfoDetails").toString();
		
		// Click on upgrade buttons
		OrderISPButtons ispButtons = new OrderISPButtons();
		Assert.assertEquals(ispButtons.upgradeBtn.isEnabled(), true);
		ispButtons.upgradeBtn.click();
		
		// Get the options
		UpgradeOrder upgrade = new UpgradeOrder();
		OrderOption []orderOptions =  upgrade.getAvailableOrderOptions();
		
		// Select the order
		System.out.println(upgradeOfferName);
		for(int i=0; i<orderOptions.length; i++)
		{
			if(orderOptions[i].orderName.equals(upgradeOfferName))
			{
				orderOptions[i].showElementBtn.click();
				break;
			}
		}
		
		// Place the order
		upgrade.placeUpdatedOrder.click();
	
		CreateOrderMasterControl buttons = new CreateOrderMasterControl();
		browser.waitForElement(buttons.continueBtn, 60*1000);
		
		PerformAction performActn=new PerformAction();
		UpsizeOrderSelectItems items = new UpsizeOrderSelectItems();
		UpsizeItemRow itemr[]=items.getItemRows(browser);
		OrderItemJsonHandler orderItems=new OrderItemJsonHandler();
		ItemDetails itemdetailslst[]=orderItems.itemDetails(itemDetails);
		
		for(int i=0;i<itemdetailslst.length;i++)
		{
			for(int j=0;j<itemr.length;j++)
			{
				if(itemdetailslst[i].itemName.equalsIgnoreCase(itemr[j].itemName))
				{
					if(itemdetailslst[i].operation==true)
					{
						if(itemdetailslst[i].checkbox==true)
						{
							performActn.doActionOnElement(itemr[j].checkBox, "checkbox", itemdetailslst[i].value);
						}

						if(itemdetailslst[i].textbox==true)
						{
							performActn.doActionOnElement(itemr[j].textBox, "textbox", itemdetailslst[i].value);
						}
						if(itemdetailslst[i].dropdown==true)
						{
							performActn.doActionOnElement(itemr[j].listBox, "dropdown", itemdetailslst[i].value);
						}
					}

					break;
				}
			}
		}
		
		
		TestUtils.delay(6000);
		
		buttons.continueBtn.click();
		TestUtils.delay(3000);
		buttons.continueBtn.click();

		OrderProvisioningInfo prov = new OrderProvisioningInfo();
		ProvItemLst provItemLst[]=prov.provInfoLst.getProvInfos(browser);

		OrderProvInfoJsonHandler orderProvInfoJsonHandler=new OrderProvInfoJsonHandler();
		ProvInfoDetails provInfoDetails[]=orderProvInfoJsonHandler.provInfoLst(provInfo);


		for(int i=0;i<provInfoDetails.length;i++)
		{
			for(int j=0;j<provItemLst.length;j++)
			{
				if(provInfoDetails[i].itemName.equalsIgnoreCase(provItemLst[j].itemName))
				{
					System.out.println("Inside");
					if(provInfoDetails[i].operation==true)
					{
						if(provInfoDetails[i].checkbox==true)
						{
							performActn.doActionOnElement(provItemLst[j].textbox, "checkbox", provInfoDetails[i].value);
						}

						if(provInfoDetails[i].textbox==true)
						{
							performActn.doActionOnElement(provItemLst[j].textbox, "textbox", provInfoDetails[i].value);
						}
						if(provInfoDetails[i].dropdown==true)
						{
							performActn.doActionOnElement(provItemLst[j].dropDown, "dropdown", provInfoDetails[i].value);
						}
					}

					break;
				}
			}
		}

		TestUtils.delay(3000);
		buttons.continueBtn.click();
		browser.waitForElement(buttons.placeOrderBtn, 10*1000);
		buttons.placeOrderBtn.click();
		
		TestUtils.delay(20000);
		
		CreateOrderSummary summary = new CreateOrderSummary();
		summary.approveOrderApproveNowBtn.click();
		TestUtils.delay(5000);

		//Assert.assertEquals(createOrderCart.orderSuccessMsg.read(),getMessage.getProperty("order_cust_upsize_success"));
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData", dependsOnMethods = { "upgradeOrder" })
	public void verifyOrderUpgraded(HashMap<?, ?> data) throws Exception
	{
		String purchesOrderNo =data.get("purchesOrderNo").toString() ;
		
		listOrder();
		
		// Search by purchase Order Number
		OrderSearch orderSearch = new OrderSearch();
		orderSearch.advSearchBtn.click();
		OrderAdvSearch advanceSearch = new OrderAdvSearch();
		advanceSearch.purchaseOrderNum.write(purchesOrderNo);
		advanceSearch.searchBtn.click();
		TestUtils.delay(20000);
		
		// Verify in result
		OrderList listOfOrder = new OrderList();
		OrderRow []rows = listOfOrder.getOrderResultRows("recent");
		
		// Verify only one result is found
		Assert.assertEquals(rows.length, 1);
		
		// Verify provisioned
		OrderUtility orderUtility = new OrderUtility();
		boolean updateInfo = orderUtility.waitForStatusUpdate(rows[0], "Upgraded", 5 * 60);
		Assert.assertEquals(updateInfo, true);
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData",dependsOnMethods = { "verifyOrderUpgraded" })
	public void downgradeOrder(HashMap<?, ?> testData) throws Exception
	{
		
		// Get data from test-data (XLS based)	
		String downgradeOfferName=testData.get("downgradeOfferName").toString();
		String itemDetails=testData.get("itemDetails").toString();
		String provInfo=testData.get("provInfoDetails").toString();
		
		// Click on upgrade buttons
		OrderISPButtons ispButtons = new OrderISPButtons();
		Assert.assertEquals(ispButtons.downgradeBtn.isEnabled(), true);
		ispButtons.downgradeBtn.click();
		
	
		
		// Get the options
		UpgradeOrder upgrade = new UpgradeOrder();
		OrderOption []orderOptions =  upgrade.getAvailableOrderOptions();
		
		// Select the order
		for(int i=0; i<orderOptions.length; i++)
		{
			if(orderOptions[i].orderName.equals(downgradeOfferName))
			{
				System.out.println(orderOptions[i].orderName);
				orderOptions[i].showElementBtn.click();
				TestUtils.delay(5000);
				break;
			}
		}
		
		// Place the order
		upgrade.placeUpdatedOrder.click();
	
		CreateOrderMasterControl buttons = new CreateOrderMasterControl();
		browser.waitForElement(buttons.continueBtn, 60*1000);
		
		
		PerformAction performActn=new PerformAction();
		UpsizeOrderSelectItems items = new UpsizeOrderSelectItems();
		UpsizeItemRow itemr[]=items.getItemRows(browser);
		OrderItemJsonHandler orderItems=new OrderItemJsonHandler();
		ItemDetails itemdetailslst[]=orderItems.itemDetails(itemDetails);
		
		for(int i=0;i<itemdetailslst.length;i++)
		{
			for(int j=0;j<itemr.length;j++)
			{
				if(itemdetailslst[i].itemName.equalsIgnoreCase(itemr[j].itemName))
				{
					if(itemdetailslst[i].operation==true)
					{
						if(itemdetailslst[i].checkbox==true)
						{
							performActn.doActionOnElement(itemr[j].checkBox, "checkbox", itemdetailslst[i].value);
						}

						if(itemdetailslst[i].textbox==true)
						{
							performActn.doActionOnElement(itemr[j].textBox, "textbox", itemdetailslst[i].value);
						}
						if(itemdetailslst[i].dropdown==true)
						{
							performActn.doActionOnElement(itemr[j].listBox, "dropdown", itemdetailslst[i].value);
						}
					}

					break;
				}
			}
		}
		
		
		TestUtils.delay(6000);
		
		buttons.continueBtn.click();
		TestUtils.delay(3000);
		buttons.continueBtn.click();

		OrderProvisioningInfo prov = new OrderProvisioningInfo();
		ProvItemLst provItemLst[]=prov.provInfoLst.getProvInfos(browser);

		OrderProvInfoJsonHandler orderProvInfoJsonHandler=new OrderProvInfoJsonHandler();
		ProvInfoDetails provInfoDetails[]=orderProvInfoJsonHandler.provInfoLst(provInfo);


		for(int i=0;i<provInfoDetails.length;i++)
		{
			for(int j=0;j<provItemLst.length;j++)
			{
				if(provInfoDetails[i].itemName.equalsIgnoreCase(provItemLst[j].itemName))
				{
					System.out.println("Inside");
					if(provInfoDetails[i].operation==true)
					{
						if(provInfoDetails[i].checkbox==true)
						{
							performActn.doActionOnElement(provItemLst[j].textbox, "checkbox", provInfoDetails[i].value);
						}

						if(provInfoDetails[i].textbox==true)
						{
							performActn.doActionOnElement(provItemLst[j].textbox, "textbox", provInfoDetails[i].value);
						}
						if(provInfoDetails[i].dropdown==true)
						{
							performActn.doActionOnElement(provItemLst[j].dropDown, "dropdown", provInfoDetails[i].value);
						}
					}

					break;
				}
			}
		}

		TestUtils.delay(2000);
		buttons.continueBtn.click();
		browser.waitForElement(buttons.placeOrderBtn, 10*1000);
		buttons.placeOrderBtn.click();
		
		TestUtils.delay(20000);
		
		CreateOrderSummary summary = new CreateOrderSummary();
		summary.approveOrderApproveNowBtn.click();
		TestUtils.delay(5000);

		//Assert.assertEquals(createOrderCart.orderSuccessMsg.read(),getMessage.getProperty("order_cust_upsize_success"));
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData", dependsOnMethods = { "downgradeOrder" })
	public void verifyOrderDowngraded(HashMap<?, ?> data) throws Exception
	{
		String purchesOrderNo =data.get("purchesOrderNo").toString() ;
		
		listOrder();
		
		// Search by purchase Order Number
		OrderSearch orderSearch = new OrderSearch();
		orderSearch.advSearchBtn.click();
		OrderAdvSearch advanceSearch = new OrderAdvSearch();
		advanceSearch.purchaseOrderNum.write(purchesOrderNo);
		advanceSearch.searchBtn.click();
		TestUtils.delay(20000);
		
		// Verify in result
		OrderList listOfOrder = new OrderList();
		OrderRow []rows = listOfOrder.getOrderResultRows("recent");
		
		// Verify only one result is found
		Assert.assertEquals(rows.length, 1);
		
		// Verify provisioned
		OrderUtility orderUtility = new OrderUtility();
		boolean updateInfo = orderUtility.waitForStatusUpdate(rows[0], "Downgraded", 5 * 60);
		Assert.assertEquals(updateInfo, true);
	}
//	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData", dependsOnMethods = { "verifyOrderDowngraded" })
	public void cancelOrder(HashMap<?, ?> data) throws Exception
	{
		TestUtils.delay(30000);
		String purchesOrderNo =data.get("purchesOrderNo").toString() ;
		
		listOrder();
		
		// Search by purchase Order Number
		OrderSearch orderSearch = new OrderSearch();
		orderSearch.advSearchBtn.click();
		OrderAdvSearch advanceSearch = new OrderAdvSearch();
		advanceSearch.purchaseOrderNum.write(purchesOrderNo);
		advanceSearch.searchBtn.click();
		TestUtils.delay(20000);
		
		// Verify in result
		OrderList listOfOrder = new OrderList();
		OrderRow []rows = listOfOrder.getOrderResultRows("recent");
		
		// Verify only one result is found
		Assert.assertEquals(rows.length, 1);
		
		// Click on row
		rows[0].link.click();
		
		// Click on cancel button
		OrderISPButtons ispButtons = new OrderISPButtons();
		Assert.assertEquals(ispButtons.cancelBtn.isEnabled(), true);
		ispButtons.cancelBtn.click();
		
		TestUtils.delay(10000);
		// Cancel pop-up handler
		CancelOrder cancelOrder = new CancelOrder();
		cancelOrder.asSoonAsPossibleChk.click();
		TestUtils.delay(5000);
		// TODO : bug filed as no reason list is populated
//		cancelOrder.reasonLst.selectVisibleText("For some other reason");
//		cancelOrder.commentsTxt.write("Sample Comment");
		cancelOrder.okBtn.click();
		
	}
//	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData", dependsOnMethods = { "cancelOrder" })
	public void verifyOrderCancel(HashMap<?, ?> data) throws Exception
	{
		String purchesOrderNo =data.get("purchesOrderNo").toString() ;
		
		listOrder();
		
		// Search by purchase Order Number
		OrderSearch orderSearch = new OrderSearch();
		orderSearch.advSearchBtn.click();
		OrderAdvSearch advanceSearch = new OrderAdvSearch();
		advanceSearch.purchaseOrderNum.write(purchesOrderNo);
		advanceSearch.searchBtn.click();
		TestUtils.delay(20000);
		
		// Verify in result
		OrderList listOfOrder = new OrderList();
		OrderRow []rows = listOfOrder.getOrderResultRows("recent");
		
		// Verify only one result is found
		Assert.assertEquals(rows.length, 1);
		
		// Verify provisioned
		OrderUtility orderUtility = new OrderUtility();
		boolean updateInfo = orderUtility.waitForStatusUpdate(rows[0], "Suspended for Cancellation", 5 * 60);
		Assert.assertEquals(updateInfo, true);
	}
//	
//	//@Test
//	public void searchOrderByOrgID()
//	{
//		String orgID = "10006";
//		String username = "admin";
//		String password = "123qwe";
//		browser.navigateTo();
//
//		LoginScreen loginScreen = new LoginScreen();
//		
//		loginScreen.username.write(username);
//		loginScreen.password.write(password);
//
//		// Click on login button
//		loginScreen.loginBtn.click();
//		
//		OrderOptions order = new OrderOptions();
//		order.orderMenu.mouseHover();
//		
//		// Click on list order option
//		order.listOrderLnk.click();
//		TestUtils.delay(5000);
//		
//		// Search for the offer
//		SearchOrder search = new SearchOrder();
//		search.organizationIDTxt.write(orgID);
//		search.searchBtn.click();
//		TestUtils.delay(5000);
//		
//		// Verify results
//		OrderList listOfOrder = new OrderList();
//		OrderRow []rows = null;
//		boolean shouldProceed = true;
//		while(shouldProceed)
//		{
//			rows = listOfOrder.getOrderResultRows("recent");
//			
//			// Check in each row for same org-Id
//			for(int i=0; i<rows.length; i++)
//			{
//				Assert.assertEquals(rows[i].orgID, orgID);
//			}
//			
//			// Check enable next button
//			if(search.nextBtn.isEnabled())
//			{
//				search.nextBtn.click();
//				TestUtils.delay(5000);
//			}
//			else
//			{
//				shouldProceed = false;
//			}
//		}
//		
//		// Log out
//		LoggedInUser user = new LoggedInUser();
//		user.userInfo.mouseHover();
//		user.logOut.click();
//		
//		// Verify login screen is displayed
//		Assert.assertEquals(loginScreen.username.isDisplayed(), true);
//		Assert.assertEquals(loginScreen.password.isDisplayed(), true);
//		Assert.assertEquals(loginScreen.loginBtn.isDisplayed(), true);
//
//	}
//	
//	
//	
//	//@Test
//	public void testUpgrade()
//	{
//		browser.navigateTo();
//
//		LoginScreen loginScreen = new LoginScreen();
//		
//		loginScreen.username.write("admin");
//		loginScreen.password.write("123qwe");
//
//		// Click on login button
//		loginScreen.loginBtn.click();
//		
//		OrderOptions order = new OrderOptions();
//		order.orderMenu.mouseHover();
//		
//		order.listOrderLnk.click();
//		TestUtils.delay(5000);
//		
//		// Search for the offer
//		SearchOrder search = new SearchOrder();
//		search.orderIdTxt.write("2015-06-09-000001");
//		search.searchBtn.click();
//		
//		
//		TestUtils.delay(3000);
//		
//		// Click on Upgrade
//		OrderISPButtons ispButtons = new OrderISPButtons();
//		// System.out.println(" :: " + details.buttons.upgrade.isEnabled());
//		//Assert.assertEquals(details.buttons.upgrade.isEnabled(), true);111
//		ispButtons.upgradeBtn.click();
//		
//		UpgradeOrder upgrade = new UpgradeOrder();
//		OrderOption []options = upgrade.getAvailableOrderOptions();
//		
//		for(int i=0; i<options.length; i++)
//		{
//			System.out.println(options[i].orderName);
//			if(options[i].orderName.contains("Automation Order three"))
//			{
//				System.out.println("Matched");
//				options[i].showElementBtn.click();
//				break;
//			}
//		}
//		
//		
//		upgrade.placeUpdatedOrder.click();
//		TestUtils.delay(5000);
//	}
//	
//	// Down-sizing
//	
//	// Upgrade
//	
//	// Down-grade
//	
//	// Cancel
//	
//	// Resume
//	
//	// Cancel - Cancel
//	//@Test
//	public void testCancelCancelOrder()
//	{
//		String orderId = "2015-06-18-000038";
//		String orgId = "10017";
//		String reason = "For some other reason";
//		String cancelMsg = "Test message";
//		
//		// Select the order
//		SearchOrder search = new SearchOrder();
//		search.orderIdTxt.write(orderId);
//		search.searchBtn.click();
//		
//		// Verify results
//		OrderList listOfOrder = new OrderList();
//		OrderRow []rows = listOfOrder.getOrderResultRows("recent");
//		Assert.assertEquals(rows.length, 1);
//		
//		// Select the order
//		Assert.assertEquals(rows[0].orgID, orgId);
//		Assert.assertEquals(rows[0].orderID, orderId);
//		rows[0].link.click();
//		TestUtils.delay(3000);
//		
//		// Click on Cancel
//		OrderISPButtons ispButtons = new OrderISPButtons();
//		Assert.assertEquals(ispButtons.cancelBtn.isEnabled(), true);
//		ispButtons.cancelBtn.click();
//		
//		// Verify org id in the message lbl.
//		CancelOrder cancelOrder = new CancelOrder();
//		Assert.assertEquals(cancelOrder.warningMsgLbl.read().contains(orgId), true);
//		
//		// Select reason
//		cancelOrder.reasonLst.selectVisibleText(reason);
//		
//		// Add comments
//		cancelOrder.commentsTxt.write(cancelMsg);
//		
//		// Click on cancel
//		cancelOrder.cancelBtn.click();
//		
//		// Search for the order again
//		search.orderIdTxt.clear();
//		search.orderIdTxt.write(orderId);
//		search.searchBtn.click();
//		
//		// Verify result
//		listOfOrder = new OrderList();
//		rows = listOfOrder.getOrderResultRows("recent");
//		Assert.assertEquals(rows.length, 1);
//		
//		// Select the order
//		Assert.assertEquals(rows[0].orgID, orgId);
//		Assert.assertEquals(rows[0].orderID, orderId);
//		rows[0].link.click();
//		TestUtils.delay(3000);
//		
//		// Verify cancel button is enabled
//		ispButtons = new OrderISPButtons();
//		Assert.assertEquals(ispButtons.cancelBtn.isEnabled(), true);
//	}
//	
//	// TODO
//	// Cancel - Ok
//	//@Test
//	public void testCancelOkOrder()
//	{
//		String orderId = "2015-06-18-000038";
//		String orgId = "10017";
//		String reason = "For some other reason";
//		String cancelMsg = "Test message";
//		
//		// Select the order
//		SearchOrder search = new SearchOrder();
//		search.orderIdTxt.write(orderId);
//		search.searchBtn.click();
//		
//		// Verify results
//		OrderList listOfOrder = new OrderList();
//		OrderRow []rows = listOfOrder.getOrderResultRows("recent");
//		Assert.assertEquals(rows.length, 1);
//		
//		// Select the order
//		Assert.assertEquals(rows[0].orgID, orgId);
//		Assert.assertEquals(rows[0].orderID, orderId);
//		rows[0].link.click();
//		TestUtils.delay(3000);
//		
//		// Click on Cancel
//		OrderISPButtons ispButtons = new OrderISPButtons();
//		Assert.assertEquals(ispButtons.cancelBtn.isEnabled(), true);
//		ispButtons.cancelBtn.click();
//		
//		// Verify org id in the message lbl.
//		CancelOrder cancelOrder = new CancelOrder();
//		Assert.assertEquals(cancelOrder.warningMsgLbl.read().contains(orgId), true);
//		
//		// Select reason
//		cancelOrder.reasonLst.selectVisibleText(reason);
//		
//		// Add comments
//		cancelOrder.commentsTxt.write(cancelMsg);
//		
//		// Click on cancel
//		cancelOrder.okBtn.click();
//		
//		// TODO: check for next steps
//		
//		
//		// Search for the order again
//		search.orderIdTxt.clear();
//		search.orderIdTxt.write(orderId);
//		search.searchBtn.click();
//		
//		// Verify result
//		listOfOrder = new OrderList();
//		rows = listOfOrder.getOrderResultRows("recent");
//		Assert.assertEquals(rows.length, 1);
//		
//		// Select the order
//		Assert.assertEquals(rows[0].orgID, orgId);
//		Assert.assertEquals(rows[0].orderID, orderId);
//		rows[0].link.click();
//		TestUtils.delay(3000);
//		
//		// Verify cancel button is enabled
//		ispButtons = new OrderISPButtons();
//		Assert.assertEquals(ispButtons.cancelBtn.isEnabled(), true);
//		
//		// Click on cancel button
//		ispButtons.cancelBtn.click();
//		
//		
//	}
//
//	//@Test
//	public void testSuspendOrder()
//	{
//		String orderId = "2015-06-18-000038";
//		String orgId = "10017";
//		//String reason = "For some other reason";
//		//String cancelMsg = "Test message";
//		
//		// Select the order
//		SearchOrder search = new SearchOrder();
//		search.orderIdTxt.write(orderId);
//		search.searchBtn.click();
//		
//		// Verify results
//		OrderList listOfOrder = new OrderList();
//		OrderRow []rows = listOfOrder.getOrderResultRows("recent");
//		Assert.assertEquals(rows.length, 1);
//		
//		// Select the order
//		Assert.assertEquals(rows[0].orgID, orgId);
//		Assert.assertEquals(rows[0].orderID, orderId);
//		rows[0].link.click();
//		TestUtils.delay(3000);
//		
//		// Suspend the offer
//		OrderISPButtons ispButtons = new OrderISPButtons();
//		Assert.assertEquals(ispButtons.suspendBtn.isEnabled(), true);
//		ispButtons.suspendBtn.click();
//		
//		// TODO: handle pop-up
//	}
//	
	private void listOrder()
	{
		OrderOptions order = new OrderOptions();
		order.orderMenu.mouseHover();
		
		// Click on list order option
		order.listOrderLnk.click();
		TestUtils.delay(5000);
	}
}


//// Verify the status
//Assert.assertEquals(details.orderInfo.status, "To be cancelled");
//
//// Wait for 2-min
//TestUtils.delay(2 * 1000 * 60);
//
//// Verify the status
//Assert.assertEquals(details.orderInfo.status, "Cancelling");
//
//// Click on Confirm order fulfillment
//details.confirmOrderFulfillment.click();
//
//// Click on Ok btn
//cancel.popUpOkBtn.click();
//
//// Check status
//TestUtils.delay(1000);
//Assert.assertEquals(details.orderInfo.status, "Suspended for Cancellation");
