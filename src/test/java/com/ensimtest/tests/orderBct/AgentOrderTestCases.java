//package com.ensimtest.tests.orderBct;
//
//import java.util.HashMap;
//
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.ensimtest.config.Browser;
//import com.ensimtest.module.authentication.LoginScreen;
//import com.ensimtest.module.entities.OrganizationDetailsButtons;
//import com.ensimtest.module.entities.SearchOrganization;
//import com.ensimtest.module.orders.CreateOrderMasterControl;
//import com.ensimtest.module.orders.CreateOrderProvisioningInfo;
//import com.ensimtest.module.orders.CreateOrderProvisioningInfo.CustomInfo;
//import com.ensimtest.module.orders.CreateOrderSelectCategory;
//import com.ensimtest.module.orders.CreateOrderSelectItems;
//import com.ensimtest.module.orders.CreateOrderSelectItems.ItemRow;
//import com.ensimtest.module.orders.CancelOrder;
//import com.ensimtest.module.orders.CreateOrderSummary;
//import com.ensimtest.module.orders.OrderDetails;
//import com.ensimtest.module.orders.CreateOrderSelectOffer;
//import com.ensimtest.module.orders.OrderList;
//import com.ensimtest.module.orders.UpgradeOrder;
//import com.ensimtest.module.orders.CreateOrderSelectOffer.Offer;
//import com.ensimtest.module.orders.OrderList.OrderRow;
//import com.ensimtest.module.orders.UpgradeOrder.OrderOption;
//import com.ensimtest.module.orders.OrderOptions;
//import com.ensimtest.module.orders.SearchOrder;
//import com.ensimtest.module.orders.SelectAcFromOrg;
//import com.ensimtest.module.userspace.LoggedInUser;
//import com.ensimtest.resource.TestDataProvider;
//import com.ensimtest.utils.TestUtils;
//
//public class AgentOrderTestCases
//{
//	private Browser browser;
//	
//	
//	@BeforeMethod
//	public void setUp()
//	{
//		browser = new Browser();
//	}
//	
//	@AfterMethod
//	public void tearDown()
//	{
//		browser.close();
//	}
//	
//	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
//	public void testPlaceOrder(HashMap<?, ?> data) throws InterruptedException
//    {
//		String userName = data.get("UserName").toString();
//		String password = data.get("Password").toString();
//		String orgName = data.get("OrgName").toString();
//		String category = data.get("category").toString();
//		String offerName = data.get("offerName").toString();
//		String orgID = data.get("orgID").toString();
//		
//		browser.navigateTo();
//
//		LoginScreen loginScreen = new LoginScreen();
//		
//		loginScreen.username.write(userName);
//		loginScreen.password.write(password);
//
//		// Click on login button
//		loginScreen.loginBtn.click();
//		
//		OrderOptions order = new OrderOptions();
//		order.orderMenu.mouseHover();
//		
//		order.createOrderLnk.click();
//		
//		SearchOrganization search = new SearchOrganization();
//		search.keywordTxt.write(orgName);
//		search.searchTypeContains.click();
//		
//		search.searchBtn.click();
//		
//		
//		TestUtils.delay(10000);
//		
//		OrganizationDetailsButtons button = new OrganizationDetailsButtons();
//		button.createOrderBtn.click();
//		
//		SelectAcFromOrg acc = new SelectAcFromOrg();
//		acc.selectAccountBtn.click();
//		TestUtils.delay(5000);
//		
//		CreateOrderSelectCategory cat = new CreateOrderSelectCategory();
//
//		cat.categories.selectCategory(category);
//		
//		TestUtils.delay(2000);
//		
//		CreateOrderSelectOffer offer = new CreateOrderSelectOffer();
//		Offer []offers = offer.getOffers();
//		Assert.assertEquals(offers[0].offerName, offerName);
//		 
//		offers[0].orderBtn.click();
//		TestUtils.delay(8000);
//
//		// TODO: CreateOrderSelectItems items = new CreateOrderSelectItems();
//		// TODO: ItemRow []rows =  items.getItemRows(browser);
//		
//		TestUtils.delay(3000);
//		CreateOrderMasterControl buttons = new CreateOrderMasterControl();
//		buttons.continueBtn.click();
//		TestUtils.delay(3000);
//		buttons.continueBtn.click();
//		
//		CreateOrderProvisioningInfo prov = new CreateOrderProvisioningInfo();
//		int x = prov.getCustomFields().length;
//		System.out.println(x);
//		
//		CustomInfo []info = prov.getCustomFields();
//		for(int i=0; i <info.length; i ++)
//		{
//			if(info[i].label!=null)
//			{
//				if(info[i].label.contains("Custom"))
//				{
//					info[i].elemenet.write("dfdf");
//				}
//			}
//			
//		}
//		buttons.continueBtn.click();
//		TestUtils.delay(6000);
//		buttons.placeOrderBtn.click();
//		TestUtils.delay(6000);
//		CreateOrderSummary summary = new CreateOrderSummary();
////		summary.iAgreeTC.click();
////		summary.internalNotesTC.write("test notes");
////		summary.submitTCBtn.click();
//		
//		summary.approveOrderApproveNowBtn.click();
//		
//		String refNo = summary.approveOrderMsgLbl.getRefNumber().trim();
//		System.out.println(refNo);
//		
//		order.orderMenu.mouseHover();
//		TestUtils.delay(2000);
//		order.listOrderLnk.click();
//		
//		SearchOrder searchOrder = new SearchOrder();
//		searchOrder.orderIdTxt.write(refNo);
//		searchOrder.searchBtn.click();
//		
//		OrderDetails details = new OrderDetails();
//		Assert.assertEquals(details.orderInfo.orgName, orgName);
//		Assert.assertEquals(details.orderInfo.orderId, refNo);
//		Assert.assertEquals(details.orderInfo.orgID, orgID);
//		
//		LoggedInUser user = new LoggedInUser();
//		Assert.assertEquals(true, user.userInfo.isDisplayed());
//		
//		// Mouse hover on user context
//		user.userInfo.mouseHover();
//		
//		// Click on log-out button
//		user.logOut.click();
//		
//		// Verify logged out and redirected to login page
//		Assert.assertEquals(loginScreen.username.isDisplayed(), true);
//		Assert.assertEquals(loginScreen.password.isDisplayed(), true);
//		Assert.assertEquals(loginScreen.loginBtn.isDisplayed(), true);
//	}
//
//	public void testPlaceOrderWithItems(HashMap<?, ?> data) throws InterruptedException
//    {
//		String userName = data.get("UserName").toString();
//		String password = data.get("Password").toString();
//		String orgName = data.get("OrgName").toString();
//		String category = data.get("category").toString();
//		String offerName = data.get("offerName").toString();
//		String orgID = data.get("orgID").toString();
//		
//		browser.navigateTo();
//
//		LoginScreen loginScreen = new LoginScreen();
//		
//		loginScreen.username.write(userName);
//		loginScreen.password.write(password);
//
//		// Click on login button
//		loginScreen.loginBtn.click();
//		
//		OrderOptions order = new OrderOptions();
//		order.orderMenu.mouseHover();
//		
//		order.createOrderLnk.click();
//		
//		SearchOrganization search = new SearchOrganization();
//		search.keywordTxt.write(orgName);
//		search.searchTypeContains.click();
//		
//		search.searchBtn.click();
//		
//		
//		TestUtils.delay(10000);
//		
//		OrganizationDetailsButtons button = new OrganizationDetailsButtons();
//		button.createOrderBtn.click();
//		
//		SelectAcFromOrg acc = new SelectAcFromOrg();
//		acc.selectAccountBtn.click();
//		TestUtils.delay(5000);
//		
//		CreateOrderSelectCategory cat = new CreateOrderSelectCategory();
//
//		cat.categories.selectCategory(category);
//		
//		TestUtils.delay(2000);
//		
//		CreateOrderSelectOffer offer = new CreateOrderSelectOffer();
//		Offer []offers = offer.getOffers();
//		Assert.assertEquals(offers[0].offerName, offerName);
//		 
//		offers[0].orderBtn.click();
//		TestUtils.delay(8000);
//
//		CreateOrderSelectItems items = new CreateOrderSelectItems();
//		ItemRow []rows =  items.getItemRows(browser);
//		
//		TestUtils.delay(3000);
//		CreateOrderMasterControl buttons = new CreateOrderMasterControl();
//		buttons.continueBtn.click();
//		TestUtils.delay(3000);
//		buttons.continueBtn.click();
//		
//		CreateOrderProvisioningInfo prov = new CreateOrderProvisioningInfo();
//		int x = prov.getCustomFields().length;
//		System.out.println(x);
//		
//		CustomInfo []info = prov.getCustomFields();
//		for(int i=0; i <info.length; i ++)
//		{
//			if(info[i].label!=null)
//			{
//				if(info[i].label.contains("Custom"))
//				{
//					info[i].elemenet.write("dfdf");
//				}
//			}
//			
//		}
//		buttons.continueBtn.click();
//		TestUtils.delay(6000);
//		buttons.placeOrderBtn.click();
//		TestUtils.delay(6000);
//		CreateOrderSummary summary = new CreateOrderSummary();
////		summary.iAgreeTC.click();
////		summary.internalNotesTC.write("test notes");
////		summary.submitTCBtn.click();
//		
//		summary.approveOrderApproveNowBtn.click();
//		
//		String refNo = summary.approveOrderMsgLbl.getRefNumber().trim();
//		System.out.println(refNo);
//		
//		order.orderMenu.mouseHover();
//		TestUtils.delay(2000);
//		order.listOrderLnk.click();
//		
//		SearchOrder searchOrder = new SearchOrder();
//		searchOrder.orderIdTxt.write(refNo);
//		searchOrder.searchBtn.click();
//		
//		OrderDetails details = new OrderDetails();
//		Assert.assertEquals(details.orderInfo.orgName, orgName);
//		Assert.assertEquals(details.orderInfo.orderId, refNo);
//		Assert.assertEquals(details.orderInfo.orgID, orgID);
//		
//		LoggedInUser user = new LoggedInUser();
//		Assert.assertEquals(true, user.userInfo.isDisplayed());
//		
//		// Mouse hover on user context
//		user.userInfo.mouseHover();
//		
//		// Click on log-out button
//		user.logOut.click();
//		
//		// Verify logged out and redirected to login page
//		Assert.assertEquals(loginScreen.username.isDisplayed(), true);
//		Assert.assertEquals(loginScreen.password.isDisplayed(), true);
//		Assert.assertEquals(loginScreen.loginBtn.isDisplayed(), true);
//	}
//	
//	@Test
//	public void testUpsizingOrder2()
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
//		search.orderIdTxt.write("2015-06-09-000015");
//		search.searchBtn.click();
//		
//		// Select the offer
//		OrderList listOfOrder = new OrderList();
//		OrderRow []rows = listOfOrder.getOrderResultRows("Recent");
//		Assert.assertEquals(rows.length, 1);
//		rows[0].link.click();
//		
//		// Click on Cancel
//		OrderDetails details = new OrderDetails();
//		Assert.assertEquals(details.buttons.cancel.isEnabled(), true);
//		details.buttons.cancel.click();
//		
//		// Enter details
//		CancelOrder cancel = new CancelOrder();
//		cancel.endOfCurrentMonthChk.click();
//		cancel.reasonLst.selectVisibleText("For some other reason");
//		cancel.commentsTxt.write("Sample message");
//		
//		// Click on Ok btn
//		cancel.okBtn.click();
//		
//		// Verify the status
//		Assert.assertEquals(details.orderInfo.status, "To be cancelled");
//		
//		// Wait for 2-min
//		TestUtils.delay(2 * 1000 * 60);
//		
//		// Verify the status
//		Assert.assertEquals(details.orderInfo.status, "Cancelling");
//		
//		// Click on Confirm order fulfillment
//		details.confirmOrderFulfillment.click();
//		
//		// Click on Ok btn
//		cancel.popUpOkBtn.click();
//		
//		// Check status
//		TestUtils.delay(1000);
//		Assert.assertEquals(details.orderInfo.status, "Suspended for Cancellation");
//		
//	}
//	
//	@Test
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
//		OrderDetails details = new OrderDetails();
//		// System.out.println(" :: " + details.buttons.upgrade.isEnabled());
//		//Assert.assertEquals(details.buttons.upgrade.isEnabled(), true);
//		details.buttons.upgrade.click();
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
//	// Abort
//}
