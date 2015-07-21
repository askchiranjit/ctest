package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To handle all the elements under market place properties
 * @author Dip
 *
 */
public class OfferMarketplaceContentProperties extends AppData{

	/*
	 * Commercial info link
	 */
	public class CommercialInfoLinkTxt extends Element{
		public CommercialInfoLinkTxt(){
			setElement(readAppData(this));
		}
	}
	
	public CommercialInfoLinkTxt commercialInfoLinkTxt = new CommercialInfoLinkTxt();
	
	/*
	 * Display in Catalog
	 */
	public class DisplayInCatalogChk extends Element{
		public DisplayInCatalogChk(){
			setElement(readAppData(this));
		}
	}
	
	public DisplayInCatalogChk displayInCatalogChk = new DisplayInCatalogChk();
	
	/*
	 * Display as Featured Service
	 */
	public class DisplayAsFeaturedServiceChk extends Element{
		public DisplayAsFeaturedServiceChk(){
			setElement(readAppData(this));
		}
	}
	
	public DisplayAsFeaturedServiceChk displayAsFeaturedServiceChk = new DisplayAsFeaturedServiceChk();
	
	/*
	 * Rank
	 */
	public class RankTxt extends Element{
		public RankTxt(){
			setElement(readAppData(this));
		}
	}
	
	public RankTxt rankTxt = new RankTxt();
	
	/*
	 * Image URL
	 */
	public class ImageURLBtn extends Element{
		public ImageURLBtn(){
			setElement(readAppData(this));
		}
	}
	
	public ImageURLBtn imageURLBtn = new ImageURLBtn();
	
//----------------------------------------------Add Image URL pop-up-----------------------------------------------
	/*
	 * Cross the pop up
	 */
	public class CrossButtonOfPopUpBtn extends Element{
		public CrossButtonOfPopUpBtn(){
			setElement(readAppData(this));
		}
	}
	
	public CrossButtonOfPopUpBtn crossButtonOfPopUpBtn = new CrossButtonOfPopUpBtn();
	
	/*
	 * Small image URL text box
	 */
	public class SmallImageURLTxt extends Element{
		public SmallImageURLTxt(){
			setElement(readAppData(this));
		}
		
		/**
		 * To write and edit URL
		 * @param data
		 */
		public void writeURL(String data){
			String str = super.getAttributeValue("value");
			super.clearAllChars(str.length());
			super.write(data);
		}
	}
	
	public SmallImageURLTxt smallImageURLTxt = new SmallImageURLTxt();
	
	/*
	 * Medium image URL text box
	 */
	public class MediumImageURLTxt extends Element{
		public MediumImageURLTxt(){
			setElement(readAppData(this));
		}
		
		/**
		 * To write and edit URL
		 * @param data
		 */
		public void writeURL(String data){
			String str = super.getAttributeValue("value");
			super.clearAllChars(str.length());
			super.write(data);
		}
	}
	
	public MediumImageURLTxt mediumImageURLTxt = new MediumImageURLTxt();
	
	/*
	 * Rectangle image URL text box
	 */
	public class RectangleImageURLTxt extends Element{
		public RectangleImageURLTxt(){
			setElement(readAppData(this));
		}
		
		/**
		 * To write and edit URL
		 * @param data
		 */
		public void writeURL(String data){
			String str = super.getAttributeValue("value");
			super.clearAllChars(str.length());
			super.write(data);
		}
	}
	
	public RectangleImageURLTxt rectangleImageURLTxt = new RectangleImageURLTxt();
	
	/*
	 * To save image URL OK button
	 */
	public class OKButtonToSaveImageURLBtn extends Element{
		public OKButtonToSaveImageURLBtn(){
			setElement(readAppData(this));
		}
	}
	
	public OKButtonToSaveImageURLBtn okButtonToSaveImageURLBtn = new OKButtonToSaveImageURLBtn();
	
	/*
	 * To cancel the changes in image URL Cancel button
	 */
	public class CancelButtonToSaveImageURLBtn extends Element{
		public CancelButtonToSaveImageURLBtn(){
			setElement(readAppData(this));
		}
	}
	
	public CancelButtonToSaveImageURLBtn cancelButtonToSaveImageURLBtn = new CancelButtonToSaveImageURLBtn();

//-----------------------------------------------END of pop up--------------------------------------------------------
	
	/*
	 * Price tag in catalog
	 */
	public class CurrencyTagSelectLnk extends Element{
		public CurrencyTagSelectLnk(){}
		
		/**
		 * Select currency tag
		 * @param currency
		 */
		public void selectCurrencyTag(String currency){
			String xpath = "//div[@id='pricetag']//table//tbody//tr//td[@class='mappedCurrency']//span[@id='" + currency + "']";
			setElement("Xpath", xpath);
			super.click();
		}
	}
	
	public CurrencyTagSelectLnk currencyTagSelectLnk = new CurrencyTagSelectLnk();
	
	/*
	 * To provide info in text area
	 */
	public class CurrencyTextAreaTxt extends Element{
		public CurrencyTextAreaTxt(){
			setElement(readAppData(this));
		}
	}
	
	public CurrencyTextAreaTxt currencyTextAreaTxt = new CurrencyTextAreaTxt();
	
	/**
	 * To write information in market place currency tag area
	 * @param currencyLst
	 * @param textValueLst
	 */
	public void writeCurrencyTagForMarketPlace(String[] currencyLst, String[] textValueLst){
		
		for(int i=0;i<currencyLst.length;i++){
			
			currencyTagSelectLnk.selectCurrencyTag(currencyLst[i]);
			
			currencyTextAreaTxt.clear();
			currencyTextAreaTxt.write(textValueLst[i]);
		}
	}
}
