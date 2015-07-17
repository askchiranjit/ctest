//package com.ensimtest.tests.orderRegression;
//
//import java.io.IOException;
//import java.util.HashMap;
//
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
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
////import com.ensimtest.module.orders.CreateOrderSelectItems;
////import com.ensimtest.module.orders.CreateOrderSelectItems.ItemRow;
//import com.ensimtest.module.orders.CreateOrderSummary;
//import com.ensimtest.module.orders.OrderDetails;
//import com.ensimtest.module.orders.CreateOrderSelectOffer;
//import com.ensimtest.module.orders.OrderISPButtons;
//import com.ensimtest.module.orders.OrderList;
//import com.ensimtest.module.orders.UpsizeOrderSelectItems;
//import com.ensimtest.module.orders.CreateOrderSelectOffer.Offer;
//import com.ensimtest.module.orders.OrderList.OrderRow;
//import com.ensimtest.module.orders.OrderOptions;
//import com.ensimtest.module.orders.SearchOrder;
//import com.ensimtest.module.orders.SelectAcFromOrg;
//import com.ensimtest.module.orders.UpsizeOrderSelectItems.UpsizeItemRow;
//import com.ensimtest.module.userspace.LoggedInUser;
//import com.ensimtest.module.utility.PerformAction;
//import com.ensimtest.module.utility.PopUPHandler;
//import com.ensimtest.resource.GetEASMessages;
//import com.ensimtest.resource.TestDataProvider;
//import com.ensimtest.utils.OrderItemJsonHandler;
//import com.ensimtest.utils.RandomData;
//import com.ensimtest.utils.TestUtils;
//import com.ensimtest.utils.OrderItemJsonHandler.ItemDetails;
//
//public class OrderRegTestCases
//{
//	private Browser browser;
//	private GetEASMessages getMessage=new GetEASMessages(); 
//	private RandomData randomdata=new RandomData();
//
//	@BeforeClass
//	public void checkSuiteRunmode() throws IOException
//	{
//		TestUtils.checkSuitRunnable(this);
//		browser = new Browser();
//	}
//
//	@AfterClass
//	public void tearDown()
//	{
//		browser.close();
//	}
////	
////	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
////	public void upsizeNOItemChange(HashMap<?, ?> data) throws Exception
////	{
////		
////		String username = data.get("UserName").toString();
////		String password = data.get("password").toString();
////		String OrderID =data.get("OrderID").toString() ;
////		
////		loginAndListOrder(username, password);
////		
////		SearchOrder searchOrder=new SearchOrder();
////		searchOrder.orderIdTxt.write(OrderID);
////		searchOrder.searchBtn.click();
////		
////		TestUtils.delay(20000);
////		// Verify in result
////		OrderList listOfOrder = new OrderList();
////		OrderRow []rows = listOfOrder.getOrderResultRows("recent");
////				
////		// Verify only one result is found
////		Assert.assertEquals(rows.length, 1);
////		OrderISPButtons orderIspBtn=new OrderISPButtons();
////		orderIspBtn.upsizeBtn.click();
////		
////		CreateOrderMasterControl createOrderMC=new CreateOrderMasterControl();
////		browser.waitForElement(createOrderMC.continueBtn, 300000);
////		createOrderMC.continueBtn.click();
////		TestUtils.delay(3000);
////		browser.waitForElement(createOrderMC.continueBtn, 300000);
////		createOrderMC.continueBtn.click();
////		TestUtils.delay(3000);
////		browser.waitForElement(createOrderMC.continueBtn, 300000);
////		createOrderMC.continueBtn.click();
////		TestUtils.delay(3000);
////		browser.waitForElement(createOrderMC.placeOrderBtn, 300000);
////		createOrderMC.placeOrderBtn.click();
////		PopUPHandler popUP=new PopUPHandler();
////		Assert.assertEquals(popUP.getPopUPData.read(), getMessage.getProperty("upsize_no_item_change"));
////		popUP.acceptPopUP.click();
////			
////	}
//	
//	
//	
//	@Test(dataProviderClass=TestDataProvider.class, dataProvider="TestData")
//	public void upsizeItemLess(HashMap<?, ?> data) throws Exception
//	{
//		
//		String username = data.get("UserName").toString();
//		String password = data.get("password").toString();
//		String OrderID =data.get("OrderID").toString() ;
//		String itemDetails=data.get("itemDetails").toString();
//		
//		
//		
//		loginAndListOrder(username, password);
//		
//		SearchOrder searchOrder=new SearchOrder();
//		searchOrder.orderIdTxt.write(OrderID);
//		searchOrder.searchBtn.click();
//		
//		TestUtils.delay(20000);
//		// Verify in result
//		OrderList listOfOrder = new OrderList();
//		OrderRow []rows = listOfOrder.getOrderResultRows("recent");
//				
//		// Verify only one result is found
//		Assert.assertEquals(rows.length, 1);
//		OrderISPButtons orderIspBtn=new OrderISPButtons();
//		orderIspBtn.upsizeBtn.click();
//		TestUtils.delay(2000);
//		CreateOrderMasterControl createOrderMC=new CreateOrderMasterControl();
//		browser.waitForElement(createOrderMC.continueBtn, 300000);
//		
//		PerformAction performActn=new PerformAction();
//		UpsizeOrderSelectItems items = new UpsizeOrderSelectItems();
//		UpsizeItemRow[] itemr=items.getItemRows(browser);
//		System.out.println(itemr.length);
//		OrderItemJsonHandler orderItems=new OrderItemJsonHandler();
//		ItemDetails itemdetailslst[]= orderItems.itemDetails(itemDetails);
//		
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
//		createOrderMC.continueBtn.click();
//		PopUPHandler popUP=new PopUPHandler();
//		Assert.assertEquals(popUP.getPopUPData.read(), getMessage.getProperty("upsize_item_less1")+" "+OrderID+getMessage.getProperty("upsize_item_less2"));
//		popUP.acceptPopUP.click();
//		
//	}
//	
//	
//	private void loginAndListOrder(String username, String password)
//	{
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
//	}	
//
//}
