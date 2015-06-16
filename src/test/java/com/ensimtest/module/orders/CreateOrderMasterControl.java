package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class CreateOrderMasterControl extends AppData
{
	public class CancelBtn extends Element
	{
		public CancelBtn()
		{
			setElement(readAppData(this));
		}
	}
	public CancelBtn cancelBtn = new CancelBtn();

	public class ContinueBtn extends Element
	{
		public ContinueBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ContinueBtn continueBtn = new ContinueBtn();

	public class GoBackBtn extends Element
	{
		public GoBackBtn()
		{
			setElement(readAppData(this));
		}
	}
	public GoBackBtn goBackBtn = new GoBackBtn();

	public class PlaceOrderBtn extends Element
	{
		public PlaceOrderBtn()
		{
			setElement(readAppData(this));
		}
	}
	public PlaceOrderBtn placeOrderBtn = new PlaceOrderBtn();

	public class SaveAsDraftBtn extends Element
	{
		public SaveAsDraftBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SaveAsDraftBtn saveAsDraftBtn = new SaveAsDraftBtn();

	public class CreateOrderHeadingLbl extends Element
	{
		public CreateOrderHeadingLbl()
		{
			setElement(readAppData(this));
		}
	}
	public CreateOrderHeadingLbl createOrderHeadingLbl = new CreateOrderHeadingLbl();

	public class SelectItemsBreadCrumb extends Element
	{
		public SelectItemsBreadCrumb()
		{
			setElement(readAppData(this));
		}
	}
	public SelectItemsBreadCrumb selectItemsBreadCrumb = new SelectItemsBreadCrumb();

	public class ContactDetailsBreadCrumb extends Element
	{
		public ContactDetailsBreadCrumb()
		{
			setElement(readAppData(this));
		}
	}
	public ContactDetailsBreadCrumb contactDetailsBreadCrumb = new ContactDetailsBreadCrumb();

	public class ProvisioningInformationBreadCrumb extends Element
	{
		public ProvisioningInformationBreadCrumb()
		{
			setElement(readAppData(this));
		}
	}
	public ProvisioningInformationBreadCrumb provisioningInformationBreadCrumb = new ProvisioningInformationBreadCrumb();

	public class SummaryBreadCrumb extends Element
	{
		public SummaryBreadCrumb()
		{
			setElement(readAppData(this));
		}
	}
	public SummaryBreadCrumb summaryBreadCrumb = new SummaryBreadCrumb();
	
	public class AddToCartBtn extends Element
	{
		public AddToCartBtn()
		{
			setElement(readAppData(this));
		}
	}
	public AddToCartBtn addToCartBtn = new AddToCartBtn();
	
}
