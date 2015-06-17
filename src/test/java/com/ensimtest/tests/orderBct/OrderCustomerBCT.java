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
import com.ensimtest.module.dashboard.CustomerDashboard;
import com.ensimtest.module.orders.CreateOrderCart;
import com.ensimtest.module.orders.CreateOrderCart.CartOrderDetails;
import com.ensimtest.module.orders.CreateOrderMasterControl;
import com.ensimtest.module.orders.CreateOrderProvisioningInfo;
import com.ensimtest.module.orders.CreateOrderSelectCategory;
import com.ensimtest.module.orders.CreateOrderSelectItems;
import com.ensimtest.module.orders.CreateOrderSummary;
import com.ensimtest.module.orders.OrderActionCustomer;
import com.ensimtest.module.orders.OrderAndSubscription;
import com.ensimtest.module.orders.OrderAndSubscription.SubsribedOrderDetails;
import com.ensimtest.module.orders.OrderDetails;
import com.ensimtest.module.orders.SearchOrder;
import com.ensimtest.module.orders.CreateOrderSelectItems.ItemRow;
import com.ensimtest.module.orders.OrderProvisioningInfo;
import com.ensimtest.module.orders.OrderProvisioningInfo.ProvItemLst;
import com.ensimtest.module.orders.SelectCategoryCustomer;
import com.ensimtest.module.orders.SelectOfferCustomer;
import com.ensimtest.module.orders.SelectOfferCustomer.OfferDetails;
import com.ensimtest.module.utility.PerformAction;
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


//	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
//	public void createOrder(HashMap<?, ?> testData) throws Exception
//	{
//		// Get data from test-data (XLS based)
//		String userName=testData.get("UserName").toString();
//		String password=testData.get("password").toString();
//		String categoryName=testData.get("categoryName").toString();
//		String offerName=testData.get("offerName").toString();
//		String orderType=testData.get("orderType").toString();
//		String itemDetails=testData.get("itemDetails").toString();
//		String provInfo=testData.get("provInfoDetails").toString();
//
//		// Navigate to ENSIM site
//		browser.navigateTo();
//
//		LoginScreen loginScreen = new LoginScreen();
//		loginScreen.username.write(userName);
//		loginScreen.password.write(password);
//
//		// Click on login button
//		loginScreen.loginBtn.click();
//
//		//Click on agent link
//		CatalogOptions catalogOption=new CatalogOptions();
//		catalogOption.catalogMenu.click();
//
//		SelectCategoryCustomer selCatCustomer=new SelectCategoryCustomer();
//		selCatCustomer.categoryList.selectCategory(categoryName);
//		TestUtils.delay(10000);
//		SelectOfferCustomer selectOfferCustomer=new SelectOfferCustomer();
//		OfferDetails offerDetlsLst[]=selectOfferCustomer.offerList.selectOfferForOrder();
//		for(int i=0;i<offerDetlsLst.length;i++)
//		{
//			if(offerDetlsLst[i].offerName.equalsIgnoreCase(offerName))
//			{
//				if(orderType.equalsIgnoreCase("NormalOrder"))
//				{
//					if(offerDetlsLst[i].orderButton==null)
//					{
//						Assert.fail("Order Button not present for this offer");
//					}
//					else
//					{
//						offerDetlsLst[i].orderButton.click();
//					}
//				}
//
//				if(orderType.equalsIgnoreCase("TrialOrder"))
//				{
//					if(offerDetlsLst[i].tryButton==null)
//					{
//						Assert.fail("Try Order Button not present for this offer");
//					}
//					else
//					{
//						offerDetlsLst[i].tryButton.click();
//					}
//				}
//
//
//			}
//		}
//
//		TestUtils.delay(10000);
//		PerformAction performActn=new PerformAction();
//		CreateOrderSelectItems items = new CreateOrderSelectItems();
//		ItemRow itemr[]=items.getItemRows(browser);
//		OrderItemJsonHandler orderItems=new OrderItemJsonHandler();
//		ItemDetails itemdetailslst[]=orderItems.itemDetails(itemDetails);
//		for(int i=0;i<itemdetailslst.length;i++)
//		{
//			for(int j=0;j<itemr.length;j++)
//			{
//				if(itemdetailslst[i].itemName.equalsIgnoreCase(itemr[j].itemName))
//				{
//					if(itemdetailslst[i].operation==true)
//					{
//						if(itemdetailslst[i].checkbox==true)
//						{
//							performActn.doActionOnElement(itemr[j].checkBox, "checkbox", itemdetailslst[i].value);
//						}
//
//						if(itemdetailslst[i].textbox==true)
//						{
//							performActn.doActionOnElement(itemr[j].textBox, "textbox", itemdetailslst[i].value);
//						}
//						if(itemdetailslst[i].dropdown==true)
//						{
//							performActn.doActionOnElement(itemr[j].listBox, "dropdown", itemdetailslst[i].value);
//						}
//					}
//
//					break;
//				}
//			}
//		}
//
//
//		CreateOrderMasterControl buttons = new CreateOrderMasterControl();
//		buttons.continueBtn.click();
//		TestUtils.delay(3000);
//		buttons.continueBtn.click();
//
//		OrderProvisioningInfo prov = new OrderProvisioningInfo();
//		ProvItemLst provItemLst[]=prov.provInfoLst.getProvInfos(browser);
//
//		OrderProvInfoJsonHandler orderProvInfoJsonHandler=new OrderProvInfoJsonHandler();
//		ProvInfoDetails provInfoDetails[]=orderProvInfoJsonHandler.provInfoLst(provInfo);
//
//
//		for(int i=0;i<provInfoDetails.length;i++)
//		{
//			for(int j=0;j<provItemLst.length;j++)
//			{
//				if(provInfoDetails[i].itemName.equalsIgnoreCase(provItemLst[j].itemName))
//				{
//					System.out.println("Inside");
//					if(provInfoDetails[i].operation==true)
//					{
//						if(provInfoDetails[i].checkbox==true)
//						{
//							performActn.doActionOnElement(provItemLst[j].textbox, "checkbox", provInfoDetails[i].value);
//						}
//
//						if(provInfoDetails[i].textbox==true)
//						{
//							performActn.doActionOnElement(provItemLst[j].textbox, "textbox", provInfoDetails[i].value);
//						}
//						if(provInfoDetails[i].dropdown==true)
//						{
//							performActn.doActionOnElement(provItemLst[j].dropDown, "dropdown", provInfoDetails[i].value);
//						}
//					}
//
//					break;
//				}
//			}
//		}
//
//		TestUtils.delay(2000);
//		buttons.continueBtn.click();
//		TestUtils.delay(10000);
//
//		System.out.println("Clicking on add to cart");
//
//		buttons.addToCartBtn.click();
//		TestUtils.delay(10000);
//		CreateOrderSummary summary = new CreateOrderSummary();
//
//		String orderNo=summary.orderNOCustomer.read().trim();
//
//		summary.gotoCartBtn.click();
//
//		TestUtils.delay(5000);
//
//
//		CreateOrderCart createOrderCart=new CreateOrderCart();
//		CartOrderDetails cartOrderDetails[]=createOrderCart.cartDetails.getOrderList();
//
//		for(int i=0;i<cartOrderDetails.length;i++)
//		{
//			if(orderNo.equalsIgnoreCase(cartOrderDetails[i].orderNo.read()))
//			{
//				cartOrderDetails[i].checkBox.click();
//				break;
//			}
//		}
//
//		TestUtils.delay(5000);
//		createOrderCart.checkoutBtn.click();
//		TestUtils.delay(5000);
//		createOrderCart.yesBtn.click();
//		TestUtils.delay(5000);
//		Assert.assertEquals(createOrderCart.orderSuccessMsg.read(),getMessage.getProperty("order_cust_success_msg"));
//
//
//	}

	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
	public void upsizeOrder(HashMap<?, ?> testData) throws Exception
	{
		
		boolean flag=false;
		
		// Get data from test-data (XLS based)
		String userName=testData.get("UserName").toString();
		String password=testData.get("password").toString();
		String offerName=testData.get("offerName").toString();


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
		
		TestUtils.delay(10000);
		
		OrderActionCustomer orderActionCustomer=new OrderActionCustomer();
		orderActionCustomer.upgradeBtn.click();
		
	}
	
	
	
	}
	

