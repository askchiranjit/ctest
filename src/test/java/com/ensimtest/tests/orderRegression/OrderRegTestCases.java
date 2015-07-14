package com.ensimtest.tests.orderRegression;

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
import com.ensimtest.module.orders.CreateOrderSelectItems.ItemRow;
import com.ensimtest.module.orders.CreateOrderSummary;
import com.ensimtest.module.orders.OrderDetails;
import com.ensimtest.module.orders.CreateOrderSelectOffer;
import com.ensimtest.module.orders.CreateOrderSelectOffer.Offer;
import com.ensimtest.module.orders.OrderOptions;
import com.ensimtest.module.orders.SearchOrder;
import com.ensimtest.module.orders.SelectAcFromOrg;
import com.ensimtest.module.userspace.LoggedInUser;
import com.ensimtest.resource.TestDataProvider;
import com.ensimtest.utils.TestUtils;

public class OrderRegTestCases
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
	

}
