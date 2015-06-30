package com.ensimtest.module.utility;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * Set limit of organization global discount at offer level
 * @author Dip
 *
 */
public class OfferPopupHandler extends AppData{
	
	/*
	 * To set value for Limit Organization Global Discount
	 */
	public class LimitOrganizationGlobalDiscountTxt extends Element{
		public LimitOrganizationGlobalDiscountTxt(){
			setElement(readAppData(this));
		}
	}
	
	public LimitOrganizationGlobalDiscountTxt limitOrganizationGlobalDiscountTxt = new LimitOrganizationGlobalDiscountTxt();
	
	/*
	 * To click on OK button
	 */
	public class LimitOrganizationGlobalDiscountOKBtn extends Element{
		public LimitOrganizationGlobalDiscountOKBtn(){
			setElement(readAppData(this));
		}
	}
	
	public LimitOrganizationGlobalDiscountOKBtn limitOrganizationGlobalDiscountOKBtn = new LimitOrganizationGlobalDiscountOKBtn();
	
	/*
	 * To click on cancel button
	 */
	public class LimitOrganizationGlobalDiscountCancelBtn extends Element{
		public LimitOrganizationGlobalDiscountCancelBtn(){
			setElement(readAppData(this));
		}
	}
	
	public LimitOrganizationGlobalDiscountCancelBtn limitOrganizationGlobalDiscountCancelBtn = new LimitOrganizationGlobalDiscountCancelBtn();
	

}
