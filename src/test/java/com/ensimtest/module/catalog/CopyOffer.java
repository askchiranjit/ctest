package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To handle all the controls of copy offer wizard
 * @author Dip
 *
 */
public class CopyOffer extends AppData{
	
	/*
	 * Copy to self
	 */
	public class CopyOfferToSelfRdo extends Element{
		public CopyOfferToSelfRdo(){
			setElement(readAppData(this));
		}
	}
	
	public CopyOfferToSelfRdo copyOfferToSelfRdo = new CopyOfferToSelfRdo();
	
	/*
	 * Copy as P2R or P2O
	 */
	public class CopyOfferAsP2ROrP2OChk extends Element{
		public CopyOfferAsP2ROrP2OChk(){
			setElement(readAppData(this));
		}
	}
	
	public CopyOfferAsP2ROrP2OChk copyOfferAsP2ROrP2OChk = new CopyOfferAsP2ROrP2OChk();
	
	/*
	 * Copy Offer to a Reseller Radio Button
	 */
	public class CopyOfferToResellerRdo extends Element{
		public CopyOfferToResellerRdo(){
			setElement(readAppData(this));
		}
	}
	
	public CopyOfferToResellerRdo copyOfferToResellerRdo = new CopyOfferToResellerRdo();
	
	/*
	 * Copy this Offer to a Reseller Text Box
	 */
	public class CopyOfferToResellerTxt extends Element{
		public CopyOfferToResellerTxt(){
			setElement(readAppData(this));
		}
	}
	
	public CopyOfferToResellerTxt copyOfferToResellerTxt = new CopyOfferToResellerTxt();
	
	/*
	 * OK button
	 */
	public class CopyOfferOkBtn extends Element{
		public CopyOfferOkBtn(){
			setElement(readAppData(this));
		}
	}
	
	public CopyOfferOkBtn copyOfferOkBtn = new CopyOfferOkBtn();
	
	/*
	 * Cancel button
	 */
	public class CopyOfferCancelBtn extends Element{
		public CopyOfferCancelBtn(){
			setElement(readAppData(this));
		}
	}
	
	public CopyOfferCancelBtn copyOfferCancelBtn = new CopyOfferCancelBtn();

}
