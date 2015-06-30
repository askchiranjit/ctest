package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To set the offer type
 * @author Dip
 *
 */
public class OfferTypeProperties extends AppData{
	
	/*
	 * To select a offer type from a set of Available as offer type list
	 */
	public class OfferTypeAvailableAsLst extends Element{
		public OfferTypeAvailableAsLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	
	public OfferTypeAvailableAsLst offerTypeAvailableAsLst = new OfferTypeAvailableAsLst();
	
	/*
	 * To on Discount for Type-2 Resellers
	 */
	public class OfferDiscountForType2ResellersChk extends Element{
		public OfferDiscountForType2ResellersChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferDiscountForType2ResellersChk offerDiscountForType2ResellersChk = new OfferDiscountForType2ResellersChk();
	
	/*
	 * To set value for Discount for Type-2 Resellers
	 */
	public class OfferDiscountForType2ResellersValueTxt extends Element{
		public OfferDiscountForType2ResellersValueTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferDiscountForType2ResellersValueTxt offerDiscountForType2ResellersValueTxt = new OfferDiscountForType2ResellersValueTxt();
	
	/*
	 * To set trial mode as Opt in
	 */
	public class OfferOptInTrailModeRdo extends Element{
		public OfferOptInTrailModeRdo(){
			setElement(readAppData(this));
		}
	}
	
	public OfferOptInTrailModeRdo offerOptInTrailModeRdo = new OfferOptInTrailModeRdo();
	
	/*
	 * To set trial mode as Opt Out
	 */
	public class OfferOptOutTrailModeRdo extends Element{
		public OfferOptOutTrailModeRdo(){
			setElement(readAppData(this));
		}
	}
	
	public OfferOptOutTrailModeRdo offerOptOutTrailModeRdo = new OfferOptOutTrailModeRdo();
	
	/*
	 * To set value for Trial Period of an offer
	 */
	public class OfferTrialPeriodValueTxt extends Element{
		public OfferTrialPeriodValueTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferTrialPeriodValueTxt offerTrialPeriodValueTxt = new OfferTrialPeriodValueTxt();
	
	/*
	 * To select type for Trial Period of an offer i.e. day,week,month,year
	 */
	public class OfferTrialPeriodTypeLst extends Element{
		public OfferTrialPeriodTypeLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	
	public OfferTrialPeriodTypeLst offerTrialPeriodTypeLst = new OfferTrialPeriodTypeLst();
	
	/*
	 * To on Purchase before expire on
	 */
	public class OfferPurchaseBeforeExpireChk extends Element{
		public OfferPurchaseBeforeExpireChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferPurchaseBeforeExpireChk offerPurchaseBeforeExpireChk = new OfferPurchaseBeforeExpireChk();
	
	/*
	 * To on Auto purchase after Trial period over
	 */
	public class OfferAutoPurchaseAfterTrialExpireChk extends Element{
		public OfferAutoPurchaseAfterTrialExpireChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferAutoPurchaseAfterTrialExpireChk offerAutoPurchaseAfterTrialExpireChk = new OfferAutoPurchaseAfterTrialExpireChk();
	
	/*
	 * To select offers as Trial Upgrade option for Opt In type
	 */
	public class OfferTrialUpgradeOptionLst extends Element{
		public OfferTrialUpgradeOptionLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	
	public OfferTrialUpgradeOptionLst offerTrialUpgradeOptionLst = new OfferTrialUpgradeOptionLst();
	
	/*
	 * To select offers as Trial Upgrade to option for Opt Out type
	 */
	public class OfferTrialUpgradeToLst extends Element{
		public OfferTrialUpgradeToLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	
	public OfferTrialUpgradeToLst offerTrialUpgradeToLst = new OfferTrialUpgradeToLst();
	
	/*
	 * To set a value for First notification before data wipe 
	 */
	public class OfferFirstNotificationTxt extends Element{
		public OfferFirstNotificationTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferFirstNotificationTxt offerFirstNotificationTxt = new OfferFirstNotificationTxt();
	
	/*
	 * To on Second notification option before data wipe
	 */
	public class OfferSecondNotificationChk extends Element{
		public OfferSecondNotificationChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferSecondNotificationChk offerSecondNotificationChk = new OfferSecondNotificationChk();
	
	/*
	 * To set a value for Second notification before data wipe 
	 */
	public class OfferSecondNotificationTxt extends Element{
		public OfferSecondNotificationTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferSecondNotificationTxt offerSecondNotificationTxt = new OfferSecondNotificationTxt();
	
	/*
	 * To on Third notification option before data wipe
	 */
	public class OfferThirdNotificationChk extends Element{
		public OfferThirdNotificationChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferThirdNotificationChk offerThirdNotificationChk = new OfferThirdNotificationChk();
	
	/*
	 * To set a value for Third notification before data wipe 
	 */
	public class OfferThirdNotificationTxt extends Element{
		public OfferThirdNotificationTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferThirdNotificationTxt offerThirdNotificationTxt = new OfferThirdNotificationTxt();
}
