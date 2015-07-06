package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To expose all the controls comes under Item Configuration section
 * @author Dip
 *
 */
public class OfferItemConfigurationDetails extends AppData{
	
	/*
	 * To on or off Invoice zero quantity so that even if a item not purchased it will show in Invoice
	 */
	public class OfferInvoiceZeroQuantityChk extends Element{
		public OfferInvoiceZeroQuantityChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferInvoiceZeroQuantityChk offerInvoiceZeroQuantityChk = new OfferInvoiceZeroQuantityChk();
	
	/*
	 * To on or off Invoice zero price so that even if a item sold in 0.00 price that will appear in Invoice
	 */
	public class OfferInvoiceZeroPriceChk extends Element{
		public OfferInvoiceZeroPriceChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferInvoiceZeroPriceChk offerInvoiceZeroPriceChk = new OfferInvoiceZeroPriceChk();
	
	/*
	 * To on or off Billable Offer so that rated data exporter will pick or not pick this offer
	 */
	public class OfferBillableOfferChk extends Element{
		public OfferBillableOfferChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferBillableOfferChk offerBillableOfferChk = new OfferBillableOfferChk();
	
	/*
	 * To select a number Available Currencies for an offer
	 */
	public class OfferAvailableCurrenciesSelectBtn extends Element{
		public OfferAvailableCurrenciesSelectBtn(){
			setElement(readAppData(this));
		}
	}
	
	public OfferAvailableCurrenciesSelectBtn offerAvailableCurrenciesSelectBtn = new OfferAvailableCurrenciesSelectBtn();
	
	/*
	 * To on or off Use discount for selling
	 */
	public class OfferUseDiscountForSellingChk extends Element{
		public OfferUseDiscountForSellingChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferUseDiscountForSellingChk offerUseDiscountForSellingChk = new OfferUseDiscountForSellingChk();
	
	/*
	 * To provide Discount Approver Email ID
	 */
	public class OfferDiscountApproverEmailTxt extends Element{
		public OfferDiscountApproverEmailTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferDiscountApproverEmailTxt offerDiscountApproverEmailTxt = new OfferDiscountApproverEmailTxt();
	
	/*
	 * To select a Price display format
	 */
	public class OfferPriceDisplayFormatLst extends Element{
		public OfferPriceDisplayFormatLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	
	public OfferPriceDisplayFormatLst offerPriceDisplayFormatLst = new OfferPriceDisplayFormatLst();

//Add new ITEM	
	/*
	 * To Select a item name from list
	 */
	public class OfferItemNameLst extends Element{
		public OfferItemNameLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
			super.click();
		}
	}
	
	public OfferItemNameLst offerItemNameLst = new OfferItemNameLst();
	
	/*
	 * To set Purchase Options for an Item
	 */
	public class OfferPurchaseOptionsOfItemLst extends Element{
		public OfferPurchaseOptionsOfItemLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	
	public OfferPurchaseOptionsOfItemLst offerPurchaseOptionsOfItemLst = new OfferPurchaseOptionsOfItemLst();
	
	/*
	 * To add an item in offer
	 */
	public class OfferAddItemBtn extends Element{
		public OfferAddItemBtn(){
			setElement(readAppData(this));
		}
	}
	
	public OfferAddItemBtn offerAddItemBtn = new OfferAddItemBtn();
	
	/*
	 * To add price for an Item
	 */
	public class OfferItemPriceBtn extends Element{
		public OfferItemPriceBtn(){
			setElement(readAppData(this));
		}
	}
	
	public OfferItemPriceBtn offerItemPriceBtn = new OfferItemPriceBtn();
	
	/*
	 * To select from existing price of an offer
	 */
	public class OfferPriceSelectLst extends Element{
		public OfferPriceSelectLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	
	public OfferPriceSelectLst offerPriceSelectLst = new OfferPriceSelectLst();

}
