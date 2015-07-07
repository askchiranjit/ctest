package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To add Price plan for an Item in offer
 * @author Dip
 *
 */
public class AddPriceForItemInOffer extends AppData{
	
	/*
	 * To add Price code
	 */
	public class PriceCodeForItemTxt extends Element{
		public PriceCodeForItemTxt(){
			setElement(readAppData(this));
		}
		
		@Override
		public void write(String data){
		
			String str = super.getAttributeValue("value");
			super.clearAllChars(str.length());
			super.write(data);
		}
	}
	
	public PriceCodeForItemTxt priceCodeForItemTxt = new PriceCodeForItemTxt();
	
	/*
	 * To select price rate type
	 */
	public class SelectPriceTypeOfItemLst extends Element{
		public SelectPriceTypeOfItemLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	
	public SelectPriceTypeOfItemLst selectPriceTypeOfItemLst = new SelectPriceTypeOfItemLst();
	
	/*
	 * To select Billing Frequency
	 */
	public class BillingFrequencyOfOfferLst extends Element{
		public BillingFrequencyOfOfferLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	
	public BillingFrequencyOfOfferLst billingFrequencyOfOfferLst = new BillingFrequencyOfOfferLst();
	
	/*
	 * To set a number for Installment times
	 */
	public class InstallmentTimesOfOfferTxt extends Element{
		public InstallmentTimesOfOfferTxt(){
			setElement(readAppData(this));
		}
		
		@Override
		public void write(String data){
		
			String str = super.getAttributeValue("value");
			super.clearAllChars(str.length());
			super.write(data);
		}
	}
	
	/*
	 * To on Agent Commission for an item 
	 */
	public class CommissionForItemChk extends Element{
		public CommissionForItemChk(){
			setElement(readAppData(this));
		}
	}
	
	public CommissionForItemChk commissionForItemChk = new CommissionForItemChk();
	
	/*
	 * To provide Agent Commission for an Item
	 */
	public class CommissionForItemTxt extends Element{
		public CommissionForItemTxt(){
			setElement(readAppData(this));
		}
		
		@Override
		public void write(String data){
		
			String str = super.getAttributeValue("value");
			super.clearAllChars(str.length());
			super.write(data);
		}
	}
	
	public CommissionForItemTxt commissionForItemTxt = new CommissionForItemTxt();
	
	/*
	 * To on Allow sales representatives to grant one-off discount
	 */
	public class AllowSalesRepresentativesToGrantOneOffDiscountChk extends Element{
		public AllowSalesRepresentativesToGrantOneOffDiscountChk(){
			setElement(readAppData(this));
		}
	}
	
	public AllowSalesRepresentativesToGrantOneOffDiscountChk allowSalesRepresentativesToGrantOneOffDiscountChk = new AllowSalesRepresentativesToGrantOneOffDiscountChk();
	
	/*
	 * To on Price with Discount i.e. need to provide discounted price for an Item
	 */
	public class PriceWithDiscountRdo extends Element{
		public PriceWithDiscountRdo(){
			setElement(readAppData(this));
		}
	}
	
	public PriceWithDiscountRdo priceWithDiscountRdo = new PriceWithDiscountRdo();
	
	/*
	 * To on Discount % on Unit Price i.e. discount % per item price
	 */
	public class DiscountPercentageOnUnitPriceRdo extends Element{
		public DiscountPercentageOnUnitPriceRdo(){
			setElement(readAppData(this));
		}
	}
	
	public DiscountPercentageOnUnitPriceRdo discountPercentageOnUnitPriceRdo = new DiscountPercentageOnUnitPriceRdo();
	
	/*
	 * To provide web site Link check box
	 */
	public class LinkForWebSiteChk extends Element{
		public LinkForWebSiteChk(){
			setElement(readAppData(this));
		}
	}
	
	public LinkForWebSiteChk linkForWebSiteChk = new LinkForWebSiteChk();
	
	/*
	 * To provide web site Link Text box
	 */
	public class LinkForWebSiteTxt extends Element{
		public LinkForWebSiteTxt(){
			setElement(readAppData(this));
		}
		
		@Override
		public void write(String data){
		
			String str = super.getAttributeValue("value");
			super.clearAllChars(str.length());
			super.write(data);
		}
	}
	
	public LinkForWebSiteTxt LinkForWebSiteTxt = new LinkForWebSiteTxt();
	
	/*
	 * To on Unit Price option
	 */
	public class UnitPriceForItemChk extends Element{
		public UnitPriceForItemChk(){
			setElement(readAppData(this));
		}
	}
	
	public UnitPriceForItemChk unitPriceForItemChk = new UnitPriceForItemChk();
	
	/*
	 * To provide Profit Margin % for unit price item i.e. mark up %
	 */
	public class ProfitMarginForUnitPriceItemTxt extends Element{
		public ProfitMarginForUnitPriceItemTxt(){
			setElement(readAppData(this));
		}
		
		@Override
		public void write(String data){
		
			String str = super.getAttributeValue("value");
			super.clearAllChars(str.length());
			super.write(data);
		}
	}
	
	public ProfitMarginForUnitPriceItemTxt profitMarginForUnitPriceItemTxt = new ProfitMarginForUnitPriceItemTxt();
	
	/*
	 * To provide Billing Name of Item which will appear in invoice
	 */
	public class BillingNameForItemTxt extends Element{
		public BillingNameForItemTxt(){
			setElement(readAppData(this));
		}
		
		@Override
		public void write(String data){
		
			String str = super.getAttributeValue("value");
			super.clearAllChars(str.length());
			super.write(data);
		}
	}
	
	public BillingNameForItemTxt billingNameForItemTxt = new BillingNameForItemTxt();
	
	/*
	 * To provide Unit Price for an Item i.e. net price of Item
	 */
	public class UnitPriceForItemTxt extends Element{
		public UnitPriceForItemTxt(){
			setElement(readAppData(this));
		}
		
		@Override
		public void write(String data){
		
			String str = super.getAttributeValue("value");
			super.clearAllChars(str.length());
			super.write(data);
		}
	}
	
	public UnitPriceForItemTxt unitPriceForItemTxt = new UnitPriceForItemTxt();
	
	/*
	 * To provide max discount % for an Item
	 */
	public class MaxDiscountPercentageTxt extends Element{
		public MaxDiscountPercentageTxt(){
			setElement(readAppData(this));
		}
		
		@Override
		public void write(String data){
		
			String str = super.getAttributeValue("value");
			super.clearAllChars(str.length());
			super.write(data);
		}
	}
	
	public MaxDiscountPercentageTxt maxDiscountPercentageTxt = new MaxDiscountPercentageTxt();
	
	/*
	 * To provide minimum discount % for an Item
	 */
	public class MinDiscountPercentageTxt extends Element{
		public MinDiscountPercentageTxt(){
			setElement(readAppData(this));
		}
		
		@Override
		public void write(String data){
		
			String str = super.getAttributeValue("value");
			super.clearAllChars(str.length());
			super.write(data);
		}
	}
	
	public MinDiscountPercentageTxt minDiscountPercentageTxt = new MinDiscountPercentageTxt();
	
	/*
	 * To save Price plan i.e. OK button
	 */
	public class PricePlanOKBtn extends Element{
		public PricePlanOKBtn(){
			setElement(readAppData(this));
		}
		
		public void click(int count){
			String []actualPath = new String[2];
			actualPath[0]="Xpath";
			actualPath[1]="(//div[@aria-labelledby='ui-dialog-title-addNewPricePlan']//div[contains(@class,'ui-dialog-buttonpane')]//button//span[contains(text(),'Ok')])[" + count + "]";
			setElement(actualPath);
			super.click();
		}
	}
	
	public PricePlanOKBtn pricePlanOKBtn = new PricePlanOKBtn();
	
	/*
	 * To save Price plan i.e. Cancel button
	 */
	public class PricePlanCancelBtn extends Element{
		public PricePlanCancelBtn(){
			setElement(readAppData(this));
		}
		
		public void click(int count){
			String []actualPath = new String[2];
			actualPath[0]="Xpath";
			actualPath[1]="(//div[@aria-labelledby='ui-dialog-title-addNewPricePlan']//div[contains(@class,'ui-dialog-buttonpane')]//button//span[contains(text(),'Cancel')])[" + count + "]";
			setElement(actualPath);
			super.click();
		}
	}
	
	public PricePlanCancelBtn pricePlanCancelBtn = new PricePlanCancelBtn();

}
