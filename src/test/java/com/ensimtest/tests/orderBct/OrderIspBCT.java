package com.ensimtest.tests.orderBct;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
import com.ensimtest.module.orders.OrderDetails;
import com.ensimtest.module.orders.CreateOrderSelectOffer;
import com.ensimtest.module.orders.OrderISPButtons;
import com.ensimtest.module.orders.OrderList;
import com.ensimtest.module.orders.OrderProvisioningInfo;
import com.ensimtest.module.orders.OrderSearch;
import com.ensimtest.module.orders.UpgradeOrder;
import com.ensimtest.module.orders.CreateOrderSelectOffer.Offer;
import com.ensimtest.module.orders.OrderList.OrderRow;
import com.ensimtest.module.orders.OrderProvisioningInfo.ProvItemLst;
import com.ensimtest.module.orders.UpgradeOrder.OrderOption;
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
	
	
	@BeforeMethod
	public void setUp()
	{
		browser = new Browser();
	}
	
	@AfterMethod
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
		String orgID = data.get("orgID").toString();
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
		
		TestUtils.delay(8000);
		
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
		CreateOrderMasterControl buttons = new CreateOrderMasterControl();
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
		TestUtils.delay(6000);
		CreateOrderSummary summary = new CreateOrderSummary();
//		summary.iAgreeTC.click();
//		summary.internalNotesTC.write("test notes");
//		summary.submitTCBtn.click();
		
		summary.approveOrderApproveNowBtn.click();
		
		String refNo = summary.approveOrderMsgLbl.getRefNumber().trim();
		System.out.println(refNo);
		
		order.orderMenu.mouseHover();
		TestUtils.delay(2000);
		order.listOrderLnk.click();
		
		
		SearchOrder searchOrder = new SearchOrder();
		searchOrder.orderIdTxt.write(refNo);
		searchOrder.searchBtn.click();
		
		OrderDetails details = new OrderDetails();
		Assert.assertEquals(details.orderInfo.orgName, orgName);
		Assert.assertEquals(details.orderInfo.orderId, refNo);
		Assert.assertEquals(details.orderInfo.orgID, orgID);
		
		LoggedInUser user = new LoggedInUser();
		Assert.assertEquals(true, user.userInfo.isDisplayed());
		
		// Mouse hover on user context
		user.userInfo.mouseHover();
		
		// Click on log-out button
		user.logOut.click();
		
		// Verify logged out and redirected to login page
		Assert.assertEquals(loginScreen.username.isDisplayed(), true);
		Assert.assertEquals(loginScreen.password.isDisplayed(), true);
		Assert.assertEquals(loginScreen.loginBtn.isDisplayed(), true);
	}
	
	@Test
	public void searchOrderByOrgID()
	{
		String orgID = "10006";
		String username = "admin";
		String password = "123qwe";
		browser.navigateTo();

		LoginScreen loginScreen = new LoginScreen();
		
		loginScreen.username.write(username);
		loginScreen.password.write(password);

		// Click on login button
		loginScreen.loginBtn.click();
		
		OrderOptions order = new OrderOptions();
		order.orderMenu.mouseHover();
		
		// Click on list order option
		order.listOrderLnk.click();
		TestUtils.delay(5000);
		
		// Search for the offer
		SearchOrder search = new SearchOrder();
		search.organizationIDTxt.write(orgID);
		search.searchBtn.click();
		TestUtils.delay(5000);
		
		// Verify results
		OrderList listOfOrder = new OrderList();
		OrderRow []rows = null;
		boolean shouldProceed = true;
		while(shouldProceed)
		{
			rows = listOfOrder.getOrderResultRows("recent");
			
			// Check in each row for same org-Id
			for(int i=0; i<rows.length; i++)
			{
				Assert.assertEquals(rows[i].orgID, orgID);
			}
			
			// Check enable next button
			if(search.nextBtn.isEnabled())
			{
				search.nextBtn.click();
				TestUtils.delay(5000);
			}
			else
			{
				shouldProceed = false;
			}
		}
		
		// Log out
		LoggedInUser user = new LoggedInUser();
		user.userInfo.mouseHover();
		user.logOut.click();
		
		// Verify login screen is displayed
		Assert.assertEquals(loginScreen.username.isDisplayed(), true);
		Assert.assertEquals(loginScreen.password.isDisplayed(), true);
		Assert.assertEquals(loginScreen.loginBtn.isDisplayed(), true);

	}
	
	@Test
	public void testUpsizingOrder2()
	{
		browser.navigateTo();

		LoginScreen loginScreen = new LoginScreen();
		
		loginScreen.username.write("admin");
		loginScreen.password.write("123qwe");

		// Click on login button
		loginScreen.loginBtn.click();
		
		OrderOptions order = new OrderOptions();
		order.orderMenu.mouseHover();
		
		order.listOrderLnk.click();
		TestUtils.delay(5000);
		
		// Search for the offer
		SearchOrder search = new SearchOrder();
		search.orderIdTxt.write("2015-06-09-000015");
		search.searchBtn.click();
		
		// Select the offer
		OrderList listOfOrder = new OrderList();
		OrderRow []rows = listOfOrder.getOrderResultRows("Recent");
		Assert.assertEquals(rows.length, 1);
		rows[0].link.click();
		
		// Click on Cancel
		OrderDetails details = new OrderDetails();
		OrderISPButtons ispButtons = new OrderISPButtons();
		Assert.assertEquals(ispButtons.cancelBtn.isEnabled(), true);
		ispButtons.cancelBtn.click();
		
		// Enter details
		CancelOrder cancel = new CancelOrder();
		cancel.endOfCurrentMonthChk.click();
		cancel.reasonLst.selectVisibleText("For some other reason");
		cancel.commentsTxt.write("Sample message");
		
		// Click on Ok btn
		cancel.okBtn.click();
		
		// Verify the status
		Assert.assertEquals(details.orderInfo.status, "To be cancelled");
		
		// Wait for 2-min
		TestUtils.delay(2 * 1000 * 60);
		
		// Verify the status
		Assert.assertEquals(details.orderInfo.status, "Cancelling");
		
		// Click on Confirm order fulfillment
		details.confirmOrderFulfillment.click();
		
		// Click on Ok btn
		cancel.popUpOkBtn.click();
		
		// Check status
		TestUtils.delay(1000);
		Assert.assertEquals(details.orderInfo.status, "Suspended for Cancellation");
		
	}
	
	@Test
	public void testUpgrade()
	{
		browser.navigateTo();

		LoginScreen loginScreen = new LoginScreen();
		
		loginScreen.username.write("admin");
		loginScreen.password.write("123qwe");

		// Click on login button
		loginScreen.loginBtn.click();
		
		OrderOptions order = new OrderOptions();
		order.orderMenu.mouseHover();
		
		order.listOrderLnk.click();
		TestUtils.delay(5000);
		
		// Search for the offer
		SearchOrder search = new SearchOrder();
		search.orderIdTxt.write("2015-06-09-000001");
		search.searchBtn.click();
		
		
		TestUtils.delay(3000);
		
		// Click on Upgrade
		OrderISPButtons ispButtons = new OrderISPButtons();
		// System.out.println(" :: " + details.buttons.upgrade.isEnabled());
		//Assert.assertEquals(details.buttons.upgrade.isEnabled(), true);111
		ispButtons.upgradeBtn.click();
		
		UpgradeOrder upgrade = new UpgradeOrder();
		OrderOption []options = upgrade.getAvailableOrderOptions();
		
		for(int i=0; i<options.length; i++)
		{
			System.out.println(options[i].orderName);
			if(options[i].orderName.contains("Automation Order three"))
			{
				System.out.println("Matched");
				options[i].showElementBtn.click();
				break;
			}
		}
		
		
		upgrade.placeUpdatedOrder.click();
		TestUtils.delay(5000);
	}
	
	// Down-sizing
	
	// Upgrade
	
	// Down-grade
	
	// Cancel
	
	// Resume
	
	// Cancel - Cancel
	@Test
	public void testCancelCancelOrder()
	{
		String orderId = "2015-06-18-000038";
		String orgId = "10017";
		String reason = "For some other reason";
		String cancelMsg = "Test message";
		
		// Select the order
		SearchOrder search = new SearchOrder();
		search.orderIdTxt.write(orderId);
		search.searchBtn.click();
		
		// Verify results
		OrderList listOfOrder = new OrderList();
		OrderRow []rows = listOfOrder.getOrderResultRows("recent");
		Assert.assertEquals(rows.length, 1);
		
		// Select the order
		Assert.assertEquals(rows[0].orgID, orgId);
		Assert.assertEquals(rows[0].orderID, orderId);
		rows[0].link.click();
		TestUtils.delay(3000);
		
		// Click on Cancel
		OrderISPButtons ispButtons = new OrderISPButtons();
		Assert.assertEquals(ispButtons.cancelBtn.isEnabled(), true);
		ispButtons.cancelBtn.click();
		
		// Verify org id in the message lbl.
		CancelOrder cancelOrder = new CancelOrder();
		Assert.assertEquals(cancelOrder.warningMsgLbl.read().contains(orgId), true);
		
		// Select reason
		cancelOrder.reasonLst.selectVisibleText(reason);
		
		// Add comments
		cancelOrder.commentsTxt.write(cancelMsg);
		
		// Click on cancel
		cancelOrder.cancelBtn.click();
		
		// Search for the order again
		search.orderIdTxt.clear();
		search.orderIdTxt.write(orderId);
		search.searchBtn.click();
		
		// Verify result
		listOfOrder = new OrderList();
		rows = listOfOrder.getOrderResultRows("recent");
		Assert.assertEquals(rows.length, 1);
		
		// Select the order
		Assert.assertEquals(rows[0].orgID, orgId);
		Assert.assertEquals(rows[0].orderID, orderId);
		rows[0].link.click();
		TestUtils.delay(3000);
		
		// Verify cancel button is enabled
		ispButtons = new OrderISPButtons();
		Assert.assertEquals(ispButtons.cancelBtn.isEnabled(), true);
	}
	
	// TODO
	// Cancel - Ok
	@Test
	public void testCancelOkOrder()
	{
		String orderId = "2015-06-18-000038";
		String orgId = "10017";
		String reason = "For some other reason";
		String cancelMsg = "Test message";
		
		// Select the order
		SearchOrder search = new SearchOrder();
		search.orderIdTxt.write(orderId);
		search.searchBtn.click();
		
		// Verify results
		OrderList listOfOrder = new OrderList();
		OrderRow []rows = listOfOrder.getOrderResultRows("recent");
		Assert.assertEquals(rows.length, 1);
		
		// Select the order
		Assert.assertEquals(rows[0].orgID, orgId);
		Assert.assertEquals(rows[0].orderID, orderId);
		rows[0].link.click();
		TestUtils.delay(3000);
		
		// Click on Cancel
		OrderISPButtons ispButtons = new OrderISPButtons();
		Assert.assertEquals(ispButtons.cancelBtn.isEnabled(), true);
		ispButtons.cancelBtn.click();
		
		// Verify org id in the message lbl.
		CancelOrder cancelOrder = new CancelOrder();
		Assert.assertEquals(cancelOrder.warningMsgLbl.read().contains(orgId), true);
		
		// Select reason
		cancelOrder.reasonLst.selectVisibleText(reason);
		
		// Add comments
		cancelOrder.commentsTxt.write(cancelMsg);
		
		// Click on cancel
		cancelOrder.okBtn.click();
		
		// TODO: check for next steps
		
		
		// Search for the order again
		search.orderIdTxt.clear();
		search.orderIdTxt.write(orderId);
		search.searchBtn.click();
		
		// Verify result
		listOfOrder = new OrderList();
		rows = listOfOrder.getOrderResultRows("recent");
		Assert.assertEquals(rows.length, 1);
		
		// Select the order
		Assert.assertEquals(rows[0].orgID, orgId);
		Assert.assertEquals(rows[0].orderID, orderId);
		rows[0].link.click();
		TestUtils.delay(3000);
		
		// Verify cancel button is enabled
		ispButtons = new OrderISPButtons();
		Assert.assertEquals(ispButtons.cancelBtn.isEnabled(), true);
		
		// Click on cancel button
		ispButtons.cancelBtn.click();
		
		
	}

	@Test
	public void testSuspendOrder()
	{
		String orderId = "2015-06-18-000038";
		String orgId = "10017";
		String reason = "For some other reason";
		String cancelMsg = "Test message";
		
		// Select the order
		SearchOrder search = new SearchOrder();
		search.orderIdTxt.write(orderId);
		search.searchBtn.click();
		
		// Verify results
		OrderList listOfOrder = new OrderList();
		OrderRow []rows = listOfOrder.getOrderResultRows("recent");
		Assert.assertEquals(rows.length, 1);
		
		// Select the order
		Assert.assertEquals(rows[0].orgID, orgId);
		Assert.assertEquals(rows[0].orderID, orderId);
		rows[0].link.click();
		TestUtils.delay(3000);
		
		// Suspend the offer
		OrderISPButtons ispButtons = new OrderISPButtons();
		Assert.assertEquals(ispButtons.suspendBtn.isEnabled(), true);
		ispButtons.suspendBtn.click();
		
		// TODO: handle pop-up
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData", dependsOnMethods = { "placeOrder" })
	public void TestForOrderProvisioned(HashMap<?, ?> data) throws Exception
	{
		String username = data.get("username").toString();
		String password = data.get("password").toString();
		String purchesOrderNo =data.get("purchesOrderNo").toString() ;
		
		loginAndListOrder(username, password);
		
		// Search by purchase Order Number
		OrderSearch orderSearch = new OrderSearch();
		orderSearch.advSearchBtn.click();
		OrderAdvSearch advanceSearch = new OrderAdvSearch();
		advanceSearch.purchaseOrderNum.write(purchesOrderNo);
		advanceSearch.searchBtn.click();
		TestUtils.delay(3000);
		
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
	
	private void loginAndListOrder(String username, String password)
	{
		browser.navigateTo();

		LoginScreen loginScreen = new LoginScreen();
		
		loginScreen.username.write(username);
		loginScreen.password.write(password);

		// Click on login button
		loginScreen.loginBtn.click();
		
		OrderOptions order = new OrderOptions();
		order.orderMenu.mouseHover();
		
		// Click on list order option
		order.listOrderLnk.click();
		TestUtils.delay(5000);
	}
}
