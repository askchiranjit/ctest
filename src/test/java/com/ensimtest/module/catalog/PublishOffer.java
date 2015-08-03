package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To handle all the controls comes under Publish offer wizard
 * @author Dip
 *
 */
public class PublishOffer extends AppData{
	
	/*
	 * Publish Offer to all Type-2 Resellers
	 */
	public class PublishOfferToAllT2ResellerRdo extends Element{
		public PublishOfferToAllT2ResellerRdo(){
			setElement(readAppData(this));
		}
	}
	
	public PublishOfferToAllT2ResellerRdo publishOfferToAllT2ResellerRdo = new PublishOfferToAllT2ResellerRdo();

	/*
	 * Publish Offer to a specific Type-2 Reseller Radio button
	 */
	public class PublishOfferToSpecificT2ResellerRdo extends Element{
		public PublishOfferToSpecificT2ResellerRdo(){
			setElement(readAppData(this));
		}
	}
	
	public PublishOfferToSpecificT2ResellerRdo publishOfferToSpecificT2ResellerRdo = new PublishOfferToSpecificT2ResellerRdo();
	
	/*
	 * Publish Offer to a specific Type-2 Reseller Text box
	 */
	public class PublishOfferToSpecificT2ResellerTxt extends Element{
		public PublishOfferToSpecificT2ResellerTxt(){
			setElement(readAppData(this));
		}
	}
	
	public PublishOfferToSpecificT2ResellerTxt publishOfferToSpecificT2ResellerTxt = new PublishOfferToSpecificT2ResellerTxt();
	
	/*
	 * Publish Offer as Active
	 */
	public class PublishOfferAsActiveRdo extends Element{
		public PublishOfferAsActiveRdo(){
			setElement(readAppData(this));
		}
	}
	
	public PublishOfferAsActiveRdo publishOfferAsActiveRdo = new PublishOfferAsActiveRdo();
	
	/*
	 * Publish Offer as Inactive
	 */
	public class PublishOfferAsInactiveRdo extends Element{
		public PublishOfferAsInactiveRdo(){
			setElement(readAppData(this));
		}
	}
	
	public PublishOfferAsInactiveRdo publishOfferAsInactiveRdo = new PublishOfferAsInactiveRdo();
	
	/*
	 * Publish Offer OK button
	 */
	public class PublishOfferOKBtn extends Element{
		public PublishOfferOKBtn(){
			setElement(readAppData(this));
		}
	}
	
	public PublishOfferOKBtn publishOfferOKBtn = new PublishOfferOKBtn();
	
	/*
	 * Publish Offer Cancel button
	 */
	public class PublishOfferCancelBtn extends Element{
		public PublishOfferCancelBtn(){
			setElement(readAppData(this));
		}
	}
	
	public PublishOfferCancelBtn publishOfferCancelBtn = new PublishOfferCancelBtn();
}
