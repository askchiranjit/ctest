package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To add a new category, download catalog, Import offer
 * @author Dip
 *
 */
public class AddNewCategory extends AppData{
	
	/*
	 * To provide Category Code
	 */
	public class OfferCategoryCodeTxt extends Element{
		public OfferCategoryCodeTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCategoryCodeTxt offerCategoryCodeTxt = new OfferCategoryCodeTxt();
	
	/*
	 * To provide category name
	 */
	public class OfferCategoryNameTxt extends Element{
		public OfferCategoryNameTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCategoryNameTxt offerCategoryNameTxt = new OfferCategoryNameTxt();
	
	/*
	 * To provide category description
	 */
	public class OfferCategoryDescriptionTxt extends Element{
		public OfferCategoryDescriptionTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCategoryDescriptionTxt offerCategoryDescriptionTxt = new OfferCategoryDescriptionTxt();
	
	/*
	 * To click on cancel button
	 */
	public class OfferCategoryCancelBtn extends Element{
		public OfferCategoryCancelBtn(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCategoryCancelBtn offerCategoryCancelBtn = new OfferCategoryCancelBtn();
	
	/*
	 * To click on save button
	 */
	public class OfferCategorySaveBtn extends Element{
		public OfferCategorySaveBtn(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCategorySaveBtn offerCategorySaveBtn = new OfferCategorySaveBtn();

}
