package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * This is for Add reseller screen's Resellers wizards
 * @author Pratap
 *
 */

public class AddResellerWizardBizModel extends AppData
{
	public class ImportFromTemplateLst extends Element
	{
		public ImportFromTemplateLst()
		{
			setElement(readAppData(this));
		}
	}
	public ImportFromTemplateLst importFromTemplateLst = new ImportFromTemplateLst();

	public class CurrencyLst extends Element
	{
		public CurrencyLst()
		{
			setElement(readAppData(this));
		}
		public void select(String data)
		{
			super.selectVisibleText(data);
		}
	}
	public CurrencyLst currencyLst = new CurrencyLst();

	public class PaymentAgreementLst extends Element
	{
		public PaymentAgreementLst()
		{
			setElement(readAppData(this));
		}
		public void select(String data)
		{
			super.selectVisibleText(data);
		}
	}
	public PaymentAgreementLst paymentAgreementLst = new PaymentAgreementLst();

	public class BrandingLst extends Element
	{
		public BrandingLst()
		{
			setElement(readAppData(this));
		}
		public void select(String data)
		{
			super.selectVisibleText(data);
		}
	}
	public BrandingLst brandingLst = new BrandingLst();

	public class DiscountfromServiceProviderTxt extends Element
	{
		public DiscountfromServiceProviderTxt()
		{
			setElement(readAppData(this));
		}
	}
	public DiscountfromServiceProviderTxt discountfromServiceProviderTxt = new DiscountfromServiceProviderTxt();

	public class PublishCatalognowChk extends Element
	{
		public PublishCatalognowChk()
		{
			setElement(readAppData(this));
		}
	}
	public PublishCatalognowChk publishCatalognowChk = new PublishCatalognowChk();

	public class CanSellToSPOrgChk extends Element
	{
		public CanSellToSPOrgChk()
		{
			setElement(readAppData(this));
		}
	}
	public CanSellToSPOrgChk canSellToSPOrgChk = new CanSellToSPOrgChk();

	public class CanOwnOrgChk extends Element
	{
		public CanOwnOrgChk()
		{
			setElement(readAppData(this));
		}
	}
	public CanOwnOrgChk canOwnOrgChk = new CanOwnOrgChk();

	public class SPCanSellToResellerChk extends Element
	{
		public SPCanSellToResellerChk()
		{
			setElement(readAppData(this));
		}
	}
	public SPCanSellToResellerChk sPCanSellToResellerChk = new SPCanSellToResellerChk();

	public class CanEditPriceInOfferChk extends Element
	{
		public CanEditPriceInOfferChk()
		{
			setElement(readAppData(this));
		}
	}
	public CanEditPriceInOfferChk canEditPriceInOfferChk = new CanEditPriceInOfferChk();

	public class MarkAsResellerTemplateChk extends Element
	{
		public MarkAsResellerTemplateChk()
		{
			setElement(readAppData(this));
		}
	}
	public MarkAsResellerTemplateChk markAsResellerTemplateChk = new MarkAsResellerTemplateChk();

	public class AllowUsageImportChk extends Element
	{
		public AllowUsageImportChk()
		{
			setElement(readAppData(this));
		}
	}
	public AllowUsageImportChk allowUsageImportChk = new AllowUsageImportChk();
}
