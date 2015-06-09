package com.ensimtest.tests.bct;

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
import com.ensimtest.module.orders.CreateOrderProvisioningInfo;
import com.ensimtest.module.orders.CreateOrderProvisioningInfo.CustomInfo;
import com.ensimtest.module.orders.CreateOrderSelectCategory;
import com.ensimtest.module.orders.CreateOrderSelectItems;
import com.ensimtest.module.orders.CreateOrderSummary;
import com.ensimtest.module.orders.OrderDetails;
import com.ensimtest.module.orders.CreateOrderSelectItems.ItemRow;
import com.ensimtest.module.orders.CreateOrderSelectOffer;
import com.ensimtest.module.orders.CreateOrderSelectOffer.Offer;
import com.ensimtest.module.orders.OrderOptions;
import com.ensimtest.module.orders.SearchOrder;
import com.ensimtest.module.orders.SelectAcFromOrg;
import com.ensimtest.module.userspace.LoggedInUser;
import com.ensimtest.resource.TestDataProvider;
import com.ensimtest.utils.TestUtils;

public class OrderTestCases
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
	public void testPlaceOrder(HashMap<?, ?> data) throws InterruptedException
    {
		String userName = data.get("UserName").toString();
		String password = data.get("Password").toString();
		String orgName = data.get("OrgName").toString();
		String category = data.get("category").toString();
		String offerName = data.get("offerName").toString();
		String orgID = data.get("orgID").toString();
		
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
		search.searchTypeContains.click();
		
		search.searchBtn.click();
		
		
		TestUtils.delay(10000);
		
		OrganizationDetailsButtons button = new OrganizationDetailsButtons();
		button.createOrderBtn.click();
		
		SelectAcFromOrg acc = new SelectAcFromOrg();
		acc.selectAccountBtn.click();
		TestUtils.delay(5000);
		
		CreateOrderSelectCategory cat = new CreateOrderSelectCategory();

		cat.categories.selectCategory(category);
		
		TestUtils.delay(2000);
		
		CreateOrderSelectOffer offer = new CreateOrderSelectOffer();
		Offer []offers = offer.getOffers();
		
		 
		offers[0].orderBtn.click();

		Assert.assertEquals(offers[0].offerName, offerName);

		TestUtils.delay(8000);

		CreateOrderSelectItems items = new CreateOrderSelectItems();
		ItemRow []rows =  items.getItemRows(browser);
		
		TestUtils.delay(3000);
		CreateOrderMasterControl buttons = new CreateOrderMasterControl();
		buttons.continueBtn.click();
		TestUtils.delay(10000);
		buttons.continueBtn.click();
		
		CreateOrderProvisioningInfo prov = new CreateOrderProvisioningInfo();
		int x = prov.getCustomFields().length;
		System.out.println(x);
		
		CustomInfo []info = prov.getCustomFields();
		for(int i=0; i <info.length; i ++)
		{
			if(info[i].label!=null)
			if(info[i].label.contains("Custom"))
			{
				info[i].elemenet.write("dfdf");
				System.out.println("writing...");
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

}
