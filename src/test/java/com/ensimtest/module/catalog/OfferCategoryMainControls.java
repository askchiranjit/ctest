package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * This will handle all the controls comes under offer category page
 * @author Dip
 *
 */
public class OfferCategoryMainControls extends AppData{
	/*
	 * To click on Add Category button to add a new category
	 */
	public class OfferAddCategoryBtn extends Element{
		public OfferAddCategoryBtn(){
			setElement(readAppData(this));
		}
	}
	
	public OfferAddCategoryBtn offerAddCategoryBtn = new OfferAddCategoryBtn();
	
	/*
	 * To click on Download catalog
	 */
	public class OfferDownloadCatalogBtn extends Element{
		public OfferDownloadCatalogBtn(){
			setElement(readAppData(this));
		}
	}
	
	public OfferDownloadCatalogBtn offerDownloadCatalogBtn = new OfferDownloadCatalogBtn();
	
	/*
	 * To click on Import offer
	 */
	public class ImportOfferBtn extends Element{
		public ImportOfferBtn(){
			setElement(readAppData(this));
		}
	}
	
	public ImportOfferBtn importOfferBtn = new ImportOfferBtn();
	
	/*
	 * To edit category rank
	 */
	public class EditOfferCategoryRankBtn extends Element{
		public EditOfferCategoryRankBtn(){
			setElement(readAppData(this));
		}
	}
	
	public EditOfferCategoryRankBtn editOfferCategoryRankBtn = new EditOfferCategoryRankBtn();
	
	/*
	 * To navigate category page, providing page number
	 */
	public class OfferCategoryNavigateUsingPageNumberTxt extends Element{
		public OfferCategoryNavigateUsingPageNumberTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCategoryNavigateUsingPageNumberTxt offerCategoryNavigateUsingPageNumberTxt = new OfferCategoryNavigateUsingPageNumberTxt();
	
	/*
	 * To click on prev category page navigate button
	 */
	public class OfferCategoryPreviousBtn extends Element{
		public OfferCategoryPreviousBtn(){
			setElement(readAppData(this));
		}
		
		@Override
		public boolean isEnabled()
		{
			if(getAttributeValue("class").contains("disabledImage"))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	}
	
	public OfferCategoryPreviousBtn offerCategoryPreviousBtn = new OfferCategoryPreviousBtn();
	
	/*
	 * To click on next category page navigate button
	 */
	public class OfferCategoryNextBtn extends Element{
		public OfferCategoryNextBtn(){
			setElement(readAppData(this));
		}
		
		@Override
		public boolean isEnabled()
		{
			if(getAttributeValue("class").contains("disabledImage"))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	}
	
	public OfferCategoryNextBtn offerCategoryNextBtn = new OfferCategoryNextBtn();
	
	/*
	 * To edit offers rank
	 */
	public class EditOffersRankBtn extends Element{
		public EditOffersRankBtn(){
			setElement(readAppData(this));
		}
	}
	
	public EditOffersRankBtn editOffersRankBtn = new EditOffersRankBtn();
	
	/*
	 * To click on Add Offer button to add a new category
	 */
	public class AddOfferBtn extends Element{
		public AddOfferBtn(){
			setElement(readAppData(this));
		}
	}
	
	public AddOfferBtn addOfferBtn = new AddOfferBtn();
	
	/*
	 * To navigate offer page, providing page number
	 */
	public class OfferPageNavigateUsingPageNumberTxt extends Element{
		public OfferPageNavigateUsingPageNumberTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferPageNavigateUsingPageNumberTxt offerPageNavigateUsingPageNumberTxt = new OfferPageNavigateUsingPageNumberTxt();
		
	/*
	 * To click on prev offer page navigate button
	 */
	public class OffersPreviousPageBtn extends Element{
		public OffersPreviousPageBtn(){
			setElement(readAppData(this));
		}
		
		@Override
		public boolean isEnabled()
		{
			if(getAttributeValue("class").contains("disabledImage"))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	}
	
	public OffersPreviousPageBtn offersPreviousPageBtn = new OffersPreviousPageBtn();
	
	/*
	 * To click on next offers page navigate button
	 */
	public class OfferNextPageBtn extends Element{
		public OfferNextPageBtn(){
			setElement(readAppData(this));
		}
		
		@Override
		public boolean isEnabled()
		{
			if(getAttributeValue("class").contains("disabledImage"))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	}
	
	public OfferNextPageBtn offerNextPageBtn = new OfferNextPageBtn();
}
