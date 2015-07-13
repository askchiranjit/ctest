package com.ensimtest.tests.orderBct;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ensimtest.config.Browser;
import com.ensimtest.module.authentication.LoginScreen;
import com.ensimtest.module.catalog.CatalogOptions;
import com.ensimtest.module.orders.CreateOrderCart;
import com.ensimtest.module.orders.CreateOrderCart.CartOrderDetails;
import com.ensimtest.module.orders.CreateOrderMasterControl;
import com.ensimtest.module.orders.CreateOrderSelectItems;
import com.ensimtest.module.orders.CreateOrderSummary;
import com.ensimtest.module.orders.OfferUpgradableTo;
import com.ensimtest.module.orders.OrderAdvSearch;
import com.ensimtest.module.orders.OrderISPButtons;
import com.ensimtest.module.orders.OrderList;
import com.ensimtest.module.orders.OrderOptions;
import com.ensimtest.module.orders.OrderSearch;
import com.ensimtest.module.orders.OfferUpgradableTo.UpgradeOffersDetails;
import com.ensimtest.module.orders.OrderActionCustomer;
import com.ensimtest.module.orders.OrderAndSubscription;
import com.ensimtest.module.orders.OrderAndSubscription.SubsribedOrderDetails;
import com.ensimtest.module.orders.OrderCancelPopUP;
import com.ensimtest.module.orders.CreateOrderSelectItems.ItemRow;
import com.ensimtest.module.orders.OrderProvisioningInfo;
import com.ensimtest.module.orders.OrderList.OrderRow;
import com.ensimtest.module.orders.OrderProvisioningInfo.ProvItemLst;
import com.ensimtest.module.orders.SelectCategoryCustomer;
import com.ensimtest.module.orders.SelectOfferCustomer;
import com.ensimtest.module.orders.SelectOfferCustomer.OfferDetails;
import com.ensimtest.module.orders.UpsizeOrderSelectItems;
import com.ensimtest.module.orders.UpsizeOrderSelectItems.UpsizeItemRow;
import com.ensimtest.module.utility.OrderUtility;
import com.ensimtest.module.utility.PerformAction;
import com.ensimtest.module.utility.PopUPHandler;
import com.ensimtest.resource.GetEASMessages;
import com.ensimtest.resource.TestDataProvider;
import com.ensimtest.utils.OrderItemJsonHandler;
import com.ensimtest.utils.OrderItemJsonHandler.ItemDetails;
import com.ensimtest.utils.OrderProvInfoJsonHandler;
import com.ensimtest.utils.OrderProvInfoJsonHandler.ProvInfoDetails;
import com.ensimtest.utils.RandomData;
import com.ensimtest.utils.TestUtils;

public class OrderCustomerBCT 

{
	private Browser browser;
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


	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void createOrder(HashMap<?, ?> testData) throws Exception
	{
		// Get data from test-data (XLS based)
		String userName=testData.get("UserName").toString();
		String password=testData.get("password").toString();
		String categoryName=testData.get("categoryName").toString();
		String offerName=testData.get("offerName").toString();
		String orderType=testData.get("orderType").toString();
		String itemDetails=testData.get("itemDetails").toString();
		String provInfo=testData.get("provInfoDetails").toString();

		// Navigate to ENSIM site
		browser.navigateTo();

		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write(userName);
		loginScreen.password.write(password);

		// Click on login button
		loginScreen.loginBtn.click();

		//Click on agent link
		CatalogOptions catalogOption=new CatalogOptions();
		catalogOption.catalogMenu.click();

		SelectCategoryCustomer selCatCustomer=new SelectCategoryCustomer();
		selCatCustomer.categoryList.selectCategory(categoryName);
		TestUtils.delay(10000);
		SelectOfferCustomer selectOfferCustomer=new SelectOfferCustomer();
		OfferDetails offerDetlsLst[]=selectOfferCustomer.offerList.selectOfferForOrder();
		for(int i=0;i<offerDetlsLst.length;i++)
		{
			if(offerDetlsLst[i].offerName.equalsIgnoreCase(offerName))
			{
				if(orderType.equalsIgnoreCase("NormalOrder"))
				{
					if(offerDetlsLst[i].orderButton==null)
					{
						Assert.fail("Order Button not present for this offer");
					}
					else
					{
						offerDetlsLst[i].orderButton.click();
						System.out.println("Clicked");
					}
				}

				if(orderType.equalsIgnoreCase("TrialOrder"))
				{
					if(offerDetlsLst[i].tryButton==null)
					{
						Assert.fail("Try Order Button not present for this offer");
					}
					else
					{
						offerDetlsLst[i].tryButton.click();
					}
				}


			}
		}

		TestUtils.delay(30000);
		PerformAction performActn=new PerformAction();
		CreateOrderSelectItems items = new CreateOrderSelectItems();
		ItemRow itemr[]=items.getItemRows(browser);
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

		TestUtils.delay(5000);
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

		TestUtils.delay(10000);
		buttons.continueBtn.click();
		TestUtils.delay(10000);

		System.out.println("Clicking on add to cart");

		buttons.addToCartBtn.click();
		TestUtils.delay(10000);
		CreateOrderSummary summary = new CreateOrderSummary();

		String orderNo=summary.orderNOCustomer.read().trim();

		summary.gotoCartBtn.click();

		TestUtils.delay(5000);


		CreateOrderCart createOrderCart=new CreateOrderCart();
		CartOrderDetails cartOrderDetails[]=createOrderCart.cartDetails.getOrderList();

		for(int i=0;i<cartOrderDetails.length;i++)
		{
			if(orderNo.equalsIgnoreCase(cartOrderDetails[i].orderNo.read()))
			{
				cartOrderDetails[i].checkBox.click();
				break;
			}
		}

		TestUtils.delay(5000);
		createOrderCart.checkoutBtn.click();
		TestUtils.delay(5000);
		createOrderCart.yesBtn.click();
		TestUtils.delay(5000);
		Assert.assertEquals(createOrderCart.orderSuccessMsg.read(),getMessage.getProperty("order_cust_success_msg"));


	}
	
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData",dependsOnMethods = { "createOrder" })
	public void approvedOrderFromISP(HashMap<?, ?> data) throws Exception
	{
		String username = data.get("UserName").toString();
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
		boolean updateInfo = orderUtility.waitForStatusUpdate(rows[0], "Pending Approval", 5 * 60);
		Assert.assertEquals(updateInfo, true);
		
		OrderISPButtons orderIspBtn=new OrderISPButtons();
		Assert.assertEquals(orderIspBtn.approveBtn.isEnabled(), true);
		orderIspBtn.approveBtn.click();
		System.out.println("Clicked");
		TestUtils.delay(5000);
		
		CreateOrderSummary summary = new CreateOrderSummary();
		summary.approveOrderApproveNowBtn.click();
		
		PopUPHandler popupHandel=new PopUPHandler();
		popupHandel.acceptPopUP.click();
		
		TestUtils.delay(10000);
		
		popupHandel.acceptPopUP.click();
		TestUtils.delay(5000);
		
}	
	
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData",dependsOnMethods = { "approvedOrderFromISP" })
	public void TestForOrderProvisioned(HashMap<?, ?> data) throws Exception
	{
		String username = data.get("UserName").toString();
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
	
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData",dependsOnMethods = { "TestForOrderProvisioned" })
	public void upsizeOrder(HashMap<?, ?> testData) throws Exception
	{
		
		boolean flag=false;
		
		// Get data from test-data (XLS based)
		String userName=testData.get("UserName").toString();
		String password=testData.get("password").toString();
		String offerName=testData.get("offerName").toString();
		String itemDetails=testData.get("itemDetails").toString();


		// Navigate to ENSIM site
		browser.navigateTo();

		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write(userName);
		loginScreen.password.write(password);

		// Click on login button
		loginScreen.loginBtn.click();
		
		OrderAndSubscription orderAndSubscription=new OrderAndSubscription();
		
		SubsribedOrderDetails orderDetails[]=orderAndSubscription.orderList.getOrders();
		
		for(int i=0;i<orderDetails.length;i++)
		{
			if(offerName.equalsIgnoreCase(orderDetails[i].offerName))
			{
				flag=true;
				orderDetails[i].actionButton.click();
			}
		}
		

		
		OrderActionCustomer orderActionCustomer=new OrderActionCustomer();
		orderActionCustomer.upsizeBtn.click();
		System.out.println("Clicked");
		
		TestUtils.delay(30000);
		
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
		
		

		CreateOrderMasterControl buttons = new CreateOrderMasterControl();
		buttons.continueBtn.click();
		TestUtils.delay(5000);
		buttons.continueBtn.click();
		TestUtils.delay(5000);
		buttons.continueBtn.click();
		TestUtils.delay(5000);
		buttons.saveToCartBtn.click();
		
		CreateOrderSummary summary = new CreateOrderSummary();

		String orderNo=summary.orderNOCustomer.read().trim();

		summary.gotoCartBtn.click();

		TestUtils.delay(5000);


		CreateOrderCart createOrderCart=new CreateOrderCart();
		CartOrderDetails cartOrderDetails[]=createOrderCart.cartDetails.getOrderList();

		for(int i=0;i<cartOrderDetails.length;i++)
		{
			if(orderNo.equalsIgnoreCase(cartOrderDetails[i].orderNo.read()))
			{
				cartOrderDetails[i].checkBox.click();
				break;
			}
		}
		TestUtils.delay(5000);
		createOrderCart.checkoutBtn.click();
		TestUtils.delay(5000);
		createOrderCart.yesBtn.click();
		TestUtils.delay(5000);
		Assert.assertEquals(createOrderCart.orderSuccessMsg.read(),getMessage.getProperty("order_cust_upsize_success"));
	}
	
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData",dependsOnMethods = { "upsizeOrder" })
	public void approvedUpsizeOrderFromISP(HashMap<?, ?> data) throws Exception
	{
		String username = data.get("UserName").toString();
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
		boolean updateInfo = orderUtility.waitForStatusUpdate(rows[0], "Update Pending Approval", 5 * 60);
		Assert.assertEquals(updateInfo, true);
		
		OrderISPButtons orderIspBtn=new OrderISPButtons();
		Assert.assertEquals(orderIspBtn.approveBtn.isEnabled(), true);
		orderIspBtn.approveBtn.click();
		System.out.println("Clicked");
		TestUtils.delay(5000);
		
		CreateOrderSummary summary = new CreateOrderSummary();
		summary.approveOrderApproveNowBtn.click();
		
		PopUPHandler popupHandel=new PopUPHandler();
		popupHandel.acceptPopUP.click();
		
		TestUtils.delay(10000);
		
		popupHandel.acceptPopUP.click();
		TestUtils.delay(5000);
		
}	
	
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData",dependsOnMethods = { "approvedUpsizeOrderFromISP" })
	public void TestForOrderUpsized(HashMap<?, ?> data) throws Exception
	{
		String username = data.get("UserName").toString();
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
		boolean updateInfo = orderUtility.waitForStatusUpdate(rows[0], "Upsized", 5 * 60);
		Assert.assertEquals(updateInfo, true);
	}	
	
	
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData",dependsOnMethods = { "TestForOrderUpsized" })
	public void downsizeOrder(HashMap<?, ?> testData) throws Exception
	{
		
		boolean flag=false;
		
		// Get data from test-data (XLS based)
		String userName=testData.get("UserName").toString();
		String password=testData.get("password").toString();
		String offerName=testData.get("offerName").toString();
		String itemDetails=testData.get("itemDetails").toString();


		// Navigate to ENSIM site
		browser.navigateTo();

		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write(userName);
		loginScreen.password.write(password);

		// Click on login button
		loginScreen.loginBtn.click();
		
		OrderAndSubscription orderAndSubscription=new OrderAndSubscription();
		
		SubsribedOrderDetails orderDetails[]=orderAndSubscription.orderList.getOrders();
		
		for(int i=0;i<orderDetails.length;i++)
		{
			if(offerName.equalsIgnoreCase(orderDetails[i].offerName))
			{
				flag=true;
				orderDetails[i].actionButton.click();
			}
		}
		

		
		OrderActionCustomer orderActionCustomer=new OrderActionCustomer();
		orderActionCustomer.downsizeBtn.click();
		System.out.println("Clicked");
		
		TestUtils.delay(30000);
		
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
		
		

		CreateOrderMasterControl buttons = new CreateOrderMasterControl();
		buttons.continueBtn.click();
		TestUtils.delay(5000);
		buttons.continueBtn.click();
		TestUtils.delay(5000);
		buttons.continueBtn.click();
		TestUtils.delay(5000);
		buttons.saveToCartBtn.click();
		
		CreateOrderSummary summary = new CreateOrderSummary();

		String orderNo=summary.orderNOCustomer.read().trim();

		summary.gotoCartBtn.click();

		TestUtils.delay(5000);


		CreateOrderCart createOrderCart=new CreateOrderCart();
		CartOrderDetails cartOrderDetails[]=createOrderCart.cartDetails.getOrderList();

		for(int i=0;i<cartOrderDetails.length;i++)
		{
			if(orderNo.equalsIgnoreCase(cartOrderDetails[i].orderNo.read()))
			{
				cartOrderDetails[i].checkBox.click();
				break;
			}
		}
		TestUtils.delay(5000);
		createOrderCart.checkoutBtn.click();
		TestUtils.delay(5000);
		createOrderCart.yesBtn.click();
		TestUtils.delay(5000);
		Assert.assertEquals(createOrderCart.orderSuccessMsg.read(),getMessage.getProperty("order_cust_upsize_success"));
	}
	
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData",dependsOnMethods = { "downsizeOrder" })
	public void approvedDownsizeOrderFromISP(HashMap<?, ?> data) throws Exception
	{
		String username = data.get("UserName").toString();
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
		boolean updateInfo = orderUtility.waitForStatusUpdate(rows[0], "Downsize pending approval", 5 * 60);
		Assert.assertEquals(updateInfo, true);
		
		OrderISPButtons orderIspBtn=new OrderISPButtons();
		Assert.assertEquals(orderIspBtn.approveBtn.isEnabled(), true);
		orderIspBtn.approveBtn.click();
		System.out.println("Clicked");
		TestUtils.delay(5000);
		
		CreateOrderSummary summary = new CreateOrderSummary();
		summary.approveOrderApproveNowBtn.click();
		
		PopUPHandler popupHandel=new PopUPHandler();
		popupHandel.acceptPopUP.click();
		
		TestUtils.delay(5000);
			
}	
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData",dependsOnMethods = { "approvedDownsizeOrderFromISP" })
	public void TestForOrderDownsized(HashMap<?, ?> data) throws Exception
	{
		String username = data.get("UserName").toString();
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
		boolean updateInfo = orderUtility.waitForStatusUpdate(rows[0], "Downsized", 5 * 60);
		Assert.assertEquals(updateInfo, true);
	}
	
	

	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData",dependsOnMethods = { "TestForOrderDownsized" })
	public void upgradeOrder(HashMap<?, ?> testData) throws Exception
	{
		
		boolean flag=false;
		
		// Get data from test-data (XLS based)
		String userName=testData.get("UserName").toString();
		String password=testData.get("password").toString();
		String offerName=testData.get("offerName").toString();	
		String upgradeOfferName=testData.get("upgradeOfferName").toString();
		String itemDetails=testData.get("itemDetails").toString();
		String provInfo=testData.get("provInfoDetails").toString();
		
		// Navigate to ENSIM site
		browser.navigateTo();

		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write(userName);
		loginScreen.password.write(password);

		// Click on login button
		loginScreen.loginBtn.click();
		
		OrderAndSubscription orderAndSubscription=new OrderAndSubscription();
		
		SubsribedOrderDetails orderDetails[]=orderAndSubscription.orderList.getOrders();
		
		for(int i=0;i<orderDetails.length;i++)
		{
			if(offerName.equalsIgnoreCase(orderDetails[i].offerName))
			{
				flag=true;
				orderDetails[i].actionButton.click();
			}
		}
		

		
		OrderActionCustomer orderActionCustomer=new OrderActionCustomer();
		orderActionCustomer.upgradeBtn.click();
		System.out.println("Clicked");
		
		
		
		OfferUpgradableTo offerUpTo=new OfferUpgradableTo();
		UpgradeOffersDetails upgradeOfferDetails[]=offerUpTo.upgradableOffers.getOfferLst();
		
		for(int i=0;i<upgradeOfferDetails.length;i++)
		{
			if(upgradeOfferDetails[i].offerName.equalsIgnoreCase(upgradeOfferName))
			{
				System.out.println("Inside");
				upgradeOfferDetails[i].offerLink.click();
				break;
			}
		}
		
	
		CreateOrderMasterControl createOrderMasterControl=new CreateOrderMasterControl();
		createOrderMasterControl.placeUpgradeBtn.click();
	
		TestUtils.delay(30000);
		
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
		
		
		createOrderMasterControl.continueBtn.click();
		TestUtils.delay(3000);
		createOrderMasterControl.continueBtn.click();

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
		createOrderMasterControl.continueBtn.click();
		TestUtils.delay(10000);
		createOrderMasterControl.saveAsDraftCusBtn.click();
		
		TestUtils.delay(10000);
		
		CreateOrderSummary summary = new CreateOrderSummary();

		
		String orderNo=summary.orderNOUpgradeCustomer.read().trim();
		System.out.println(orderNo);
		summary.gotoCartBtn.click();

		TestUtils.delay(5000);


		CreateOrderCart createOrderCart=new CreateOrderCart();
		CartOrderDetails cartOrderDetails[]=createOrderCart.cartDetails.getOrderList();

		for(int i=0;i<cartOrderDetails.length;i++)
		{
			if(orderNo.equalsIgnoreCase(cartOrderDetails[i].orderNo.read()))
			{
				cartOrderDetails[i].checkBox.click();
				break;
			}
		}
		TestUtils.delay(5000);
		createOrderCart.checkoutBtn.click();
		TestUtils.delay(5000);
		createOrderCart.yesBtn.click();
		TestUtils.delay(5000);
		Assert.assertEquals(createOrderCart.orderSuccessMsg.read(),getMessage.getProperty("order_cust_upsize_success"));
		
		
		
	}
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData",dependsOnMethods = { "upgradeOrder" })
	public void approvedUpgradeOrderFromISP(HashMap<?, ?> data) throws Exception
	{
		String username = data.get("UserName").toString();
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
		boolean updateInfo = orderUtility.waitForStatusUpdate(rows[0], "Upgrade Pending Approval", 5 * 60);
		Assert.assertEquals(updateInfo, true);
		
		OrderISPButtons orderIspBtn=new OrderISPButtons();
		Assert.assertEquals(orderIspBtn.approveBtn.isEnabled(), true);
		orderIspBtn.approveBtn.click();
		System.out.println("Clicked");
		TestUtils.delay(5000);
		
		CreateOrderSummary summary = new CreateOrderSummary();
		summary.approveOrderApproveNowBtn.click();
		
		PopUPHandler popupHandel=new PopUPHandler();
		popupHandel.acceptPopUP.click();
		
		TestUtils.delay(5000);
		
}	

	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData",dependsOnMethods = { "approvedUpgradeOrderFromISP" })
	public void TestForOrderUpgraded(HashMap<?, ?> data) throws Exception
	{
		String username = data.get("UserName").toString();
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
		boolean updateInfo = orderUtility.waitForStatusUpdate(rows[0], "Upgraded", 5 * 60);
		Assert.assertEquals(updateInfo, true);
	}
	
	
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData",dependsOnMethods = { "TestForOrderUpgraded" })
	public void downgradeOrder(HashMap<?, ?> testData) throws Exception
	{
		
		boolean flag=false;
		
		// Get data from test-data (XLS based)
		String userName=testData.get("UserName").toString();
		String password=testData.get("password").toString();
		String offerName=testData.get("offerName").toString();	
		String downgradeOfferName=testData.get("downgradeOfferName").toString();
		String itemDetails=testData.get("itemDetails").toString();
		String provInfo=testData.get("provInfoDetails").toString();
		
		// Navigate to ENSIM site
		browser.navigateTo();

		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write(userName);
		loginScreen.password.write(password);

		// Click on login button
		loginScreen.loginBtn.click();
		
		OrderAndSubscription orderAndSubscription=new OrderAndSubscription();
		
		SubsribedOrderDetails orderDetails[]=orderAndSubscription.orderList.getOrders();
		
		for(int i=0;i<orderDetails.length;i++)
		{
			if(offerName.equalsIgnoreCase(orderDetails[i].offerName))
			{
				flag=true;
				orderDetails[i].actionButton.click();
			}
		}
		

		
		OrderActionCustomer orderActionCustomer=new OrderActionCustomer();
		orderActionCustomer.downgradeBtn.click();
		System.out.println("Clicked");
		TestUtils.delay(10000);
		
		
		
		OfferUpgradableTo offerUpTo=new OfferUpgradableTo();
		UpgradeOffersDetails upgradeOfferDetails[]=offerUpTo.upgradableOffers.getOfferLst();
		
		for(int i=0;i<upgradeOfferDetails.length;i++)
		{
			if(upgradeOfferDetails[i].offerName.equalsIgnoreCase(downgradeOfferName))
			{
				System.out.println("Inside");
				upgradeOfferDetails[i].offerLink.click();
				break;
			}
		}
		
	
		CreateOrderMasterControl createOrderMasterControl=new CreateOrderMasterControl();
		createOrderMasterControl.placeUpgradeBtn.click();
	
		TestUtils.delay(30000);
		
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
							System.out.println(itemr[j].itemName);
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
		
		
		createOrderMasterControl.continueBtn.click();
		TestUtils.delay(3000);
		createOrderMasterControl.continueBtn.click();

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
		createOrderMasterControl.continueBtn.click();
		TestUtils.delay(10000);
		createOrderMasterControl.saveAsDraftCusBtn.click();
		
		TestUtils.delay(10000);
		
		CreateOrderSummary summary = new CreateOrderSummary();

		
		String orderNo=summary.orderNOUpgradeCustomer.read().trim();
		System.out.println(orderNo);
		summary.gotoCartBtn.click();

		TestUtils.delay(5000);


		CreateOrderCart createOrderCart=new CreateOrderCart();
		CartOrderDetails cartOrderDetails[]=createOrderCart.cartDetails.getOrderList();

		for(int i=0;i<cartOrderDetails.length;i++)
		{
			if(orderNo.equalsIgnoreCase(cartOrderDetails[i].orderNo.read()))
			{
				cartOrderDetails[i].checkBox.click();
				break;
			}
		}
		TestUtils.delay(5000);
		createOrderCart.checkoutBtn.click();
		TestUtils.delay(5000);
		createOrderCart.yesBtn.click();
		TestUtils.delay(5000);
		Assert.assertEquals(createOrderCart.orderSuccessMsg.read(),getMessage.getProperty("order_cust_upsize_success"));
		
		
		
	}
	
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData",dependsOnMethods = { "downgradeOrder" })
	public void approvedDowngradeOrderFromISP(HashMap<?, ?> data) throws Exception
	{
		String username = data.get("UserName").toString();
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
		boolean updateInfo = orderUtility.waitForStatusUpdate(rows[0], "Downgrade Pending Approval", 5 * 60);
		Assert.assertEquals(updateInfo, true);
		
		OrderISPButtons orderIspBtn=new OrderISPButtons();
		Assert.assertEquals(orderIspBtn.approveBtn.isEnabled(), true);
		orderIspBtn.approveBtn.click();
		System.out.println("Clicked");
		TestUtils.delay(5000);
		
		CreateOrderSummary summary = new CreateOrderSummary();
		summary.approveOrderApproveNowBtn.click();
		
		PopUPHandler popupHandel=new PopUPHandler();
		popupHandel.acceptPopUP.click();
		
		TestUtils.delay(5000);
			
}	
	
	
	
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData",dependsOnMethods = { "approvedDowngradeOrderFromISP" })
	public void TestForOrderDowngrade(HashMap<?, ?> data) throws Exception
	{
		String username = data.get("UserName").toString();
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
		boolean updateInfo = orderUtility.waitForStatusUpdate(rows[0], "Downgraded", 5 * 60);
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
	
	
	

	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData",dependsOnMethods = { "TestForOrderDowngrade" })
	public void cancleFromStableState(HashMap<?, ?> testData) throws Exception
	{
		
		boolean flag=false;
		boolean deleted=true;
		String userName=testData.get("UserName").toString();
		String password=testData.get("password").toString();
		String offerName=testData.get("offerName").toString();	
		String comment=testData.get("comment").toString();
		String resonForCancel=testData.get("resonForCancel").toString();
		
		
		// Navigate to ENSIM site
		browser.navigateTo();

		LoginScreen loginScreen = new LoginScreen();
		loginScreen.username.write(userName);
		loginScreen.password.write(password);

		// Click on login button
		loginScreen.loginBtn.click();
		
		OrderAndSubscription orderAndSubscription=new OrderAndSubscription();
		
		SubsribedOrderDetails orderDetails[]=orderAndSubscription.orderList.getOrders();
		
		for(int i=0;i<orderDetails.length;i++)
		{
			if(offerName.equalsIgnoreCase(orderDetails[i].offerName))
			{
				flag=true;
				orderDetails[i].actionButton.click();
			}
		}
		

		
		OrderActionCustomer orderActionCustomer=new OrderActionCustomer();
		orderActionCustomer.cancelBtn.click();
		
		OrderCancelPopUP orderCancelPopUP=new OrderCancelPopUP();
		orderCancelPopUP.reasonLst.selectReason(resonForCancel);
		orderCancelPopUP.commentTxt.write(comment);
		orderCancelPopUP.oKBtn.click();
	   
		TestUtils.delay(10000);
		
		SubsribedOrderDetails orderDetailsAfterCancle[]=orderAndSubscription.orderList.getOrders();
		
		for(int i=0;i<orderDetailsAfterCancle.length;i++)
		{
			if(offerName.equalsIgnoreCase(orderDetailsAfterCancle[i].offerName))
			{
				deleted=false;
				break;
			}
		}
		
		Assert.assertEquals(deleted, true);
		
    }
	

	
	}
	

