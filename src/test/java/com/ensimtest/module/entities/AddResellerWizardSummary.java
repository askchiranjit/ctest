package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class AddResellerWizardSummary extends AppData
{
	public class ResellerNameLbl extends Element
	{
		public ResellerNameLbl()
		{
			setElement(readAppData(this));
		}
	}
	public ResellerNameLbl resellerNameLbl = new ResellerNameLbl();

	public class CanCreateOffersLbl extends Element
	{
		public CanCreateOffersLbl()
		{
			setElement(readAppData(this));
		}
	}
	public CanCreateOffersLbl canCreateOffersLbl = new CanCreateOffersLbl();

	public class DiscountFromServiceProviderLbl extends Element
	{
		public DiscountFromServiceProviderLbl()
		{
			setElement(readAppData(this));
		}
	}
	public DiscountFromServiceProviderLbl discountFromServiceProviderLbl = new DiscountFromServiceProviderLbl();

	public class UsernameSuffixLbl extends Element
	{
		public UsernameSuffixLbl()
		{
			setElement(readAppData(this));
		}
	}
	public UsernameSuffixLbl usernameSuffixLbl = new UsernameSuffixLbl();

	public class AdminNameLbl extends Element
	{
		public AdminNameLbl()
		{
			setElement(readAppData(this));
		}
	}
	public AdminNameLbl adminNameLbl = new AdminNameLbl();

	public class CurrencyLbl extends Element
	{
		public CurrencyLbl()
		{
			setElement(readAppData(this));
		}
	}
	public CurrencyLbl currencyLbl = new CurrencyLbl();

	public class BrandingLbl extends Element
	{
		public BrandingLbl()
		{
			setElement(readAppData(this));
		}
	}
	public BrandingLbl brandingLbl = new BrandingLbl();

	public class PaymentAgreementLbl extends Element
	{
		public PaymentAgreementLbl()
		{
			setElement(readAppData(this));
		}
	}
	public PaymentAgreementLbl paymentAgreementLbl = new PaymentAgreementLbl();
	
	public class CreateStatus extends Element
	{
		public CreateStatus()
		{
			setElement(readAppData(this));
		}
	}
	public CreateStatus createStatus = new CreateStatus();
}
