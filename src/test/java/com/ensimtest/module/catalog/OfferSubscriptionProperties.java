package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To cover all controls under Subscription Properties section
 * @author Dip
 *
 */
public class OfferSubscriptionProperties extends AppData{
	/*
	 * To change the Subscription type as Month to Month
	 */
	public class OfferMonthToMonthSubscriptionRdo extends Element{
		public OfferMonthToMonthSubscriptionRdo(){
			setElement(readAppData(this));
		}
	}
	
	public OfferMonthToMonthSubscriptionRdo offerMonthToMonthSubscriptionRdo = new OfferMonthToMonthSubscriptionRdo();
	
	/*
	 * To change the Subscription type as Termed Subscription
	 */
	public class OfferTermedSubscriptionRdo extends Element{
		public OfferTermedSubscriptionRdo(){
			setElement(readAppData(this));
		}
	}
	
	public OfferTermedSubscriptionRdo offerTermedSubscriptionRdo = new OfferTermedSubscriptionRdo();
	
	/*
	 * To set value for Subscription period
	 */
	public class OfferSubscriptionPeriodValueTxt extends Element{
		public OfferSubscriptionPeriodValueTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferSubscriptionPeriodValueTxt offerSubscriptionPeriodValueTxt = new OfferSubscriptionPeriodValueTxt();
	
	/*
	 * To select type for Subscription period i.e. months,years
	 */
	public class OfferSubscriptionPeriodTypeLst extends Element{
		public OfferSubscriptionPeriodTypeLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	
	public OfferSubscriptionPeriodTypeLst offerSubscriptionPeriodTypeLst = new OfferSubscriptionPeriodTypeLst();
	
	/*
	 * To set value for Billing Frequency
	 */
	public class OfferBillingFrequencyValueTxt extends Element{
		public OfferBillingFrequencyValueTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferBillingFrequencyValueTxt offerBillingFrequencyValueTxt = new OfferBillingFrequencyValueTxt();
	
	/*
	 * To select type for Billing Frequency i.e. months,years
	 */
	public class OfferBillingFrequencyTypeLst extends Element{
		public OfferBillingFrequencyTypeLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	
	public OfferBillingFrequencyTypeLst offerBillingFrequencyTypeLst = new OfferBillingFrequencyTypeLst();
	
	/*
	 * To set value for Subscription Code
	 */
	public class OfferSubscriptionCodeTxt extends Element{
		public OfferSubscriptionCodeTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferSubscriptionCodeTxt offerSubscriptionCodeTxt = new OfferSubscriptionCodeTxt();
	
	/*
	 * To change the Subscription renewal as Auto Renew
	 */
	public class OfferAutoRenewSubscriptionRdo extends Element{
		public OfferAutoRenewSubscriptionRdo(){
			setElement(readAppData(this));
		}
	}
	
	public OfferAutoRenewSubscriptionRdo offerAutoRenewSubscriptionRdo = new OfferAutoRenewSubscriptionRdo();
	
	/*
	 * To change the Subscription renewal as Auto Cancel
	 */
	public class OfferAutoCancelSubscriptionRdo extends Element{
		public OfferAutoCancelSubscriptionRdo(){
			setElement(readAppData(this));
		}
	}
	
	public OfferAutoCancelSubscriptionRdo offerAutoCancelSubscriptionRdo = new OfferAutoCancelSubscriptionRdo();
	
	/*
	 * To on the option for Are Organizations allowed to upgrade from this Offer during Subscription Period?
	 */
	public class OfferAllowUpgradeDuringSubscriptionChk extends Element{
		public OfferAllowUpgradeDuringSubscriptionChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferAllowUpgradeDuringSubscriptionChk offerAllowUpgradeDuringSubscriptionChk = new OfferAllowUpgradeDuringSubscriptionChk();
	
	/*
	 * To on the option Renew Subscription with active users only
	 */
	public class OfferRenewSubscriptionWithActiveUserChk extends Element{
		public OfferRenewSubscriptionWithActiveUserChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferRenewSubscriptionWithActiveUserChk offerRenewSubscriptionWithActiveUserChk = new OfferRenewSubscriptionWithActiveUserChk();
	
	/*
	 * To on First Notification before Renewal/Expire
	 */
	public class OfferFirstNotificationChk extends Element{
		public OfferFirstNotificationChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferFirstNotificationChk offerFirstNotificationChk = new OfferFirstNotificationChk();
	
	/*
	 * To set a value for First Notification before Renewal/Expire 
	 */
	public class OfferFirstNotificationTxt extends Element{
		public OfferFirstNotificationTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferFirstNotificationTxt offerFirstNotificationTxt = new OfferFirstNotificationTxt();
	
	/*
	 * To on Second Notification before Renewal/Expire
	 */
	public class OfferSecondNotificationChk extends Element{
		public OfferSecondNotificationChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferSecondNotificationChk offerSecondNotificationChk = new OfferSecondNotificationChk();
	
	/*
	 * To set a value for Second Notification before Renewal/Expire 
	 */
	public class OfferSecondNotificationTxt extends Element{
		public OfferSecondNotificationTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferSecondNotificationTxt offerSecondNotificationTxt = new OfferSecondNotificationTxt();
	
	/*
	 * To on Third Notification before Renewal/Expire
	 */
	public class OfferThirdNotificationChk extends Element{
		public OfferThirdNotificationChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferThirdNotificationChk offerThirdNotificationChk = new OfferThirdNotificationChk();
	
	/*
	 * To set a value for Third Notification before Renewal/Expire 
	 */
	public class OfferThirdNotificationTxt extends Element{
		public OfferThirdNotificationTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferThirdNotificationTxt offerThirdNotificationTxt = new OfferThirdNotificationTxt();
}
