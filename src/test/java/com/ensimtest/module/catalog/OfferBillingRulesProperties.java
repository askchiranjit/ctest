package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To set different Billing Rules for an offer
 * @author Dip
 *
 */

public class OfferBillingRulesProperties extends AppData{
	
	/**
	 * To set Payment mode for Registered Organizations
	 */
	public class OfferPaymentModeForRegisteredOrganizationsLst extends Element{
		public OfferPaymentModeForRegisteredOrganizationsLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	
	public OfferPaymentModeForRegisteredOrganizationsLst offerPaymentModeForRegisteredOrganizationsLst = new OfferPaymentModeForRegisteredOrganizationsLst();
	
	/**
	 * To set Payment mode for Self-registered Organizations
	 */
	public class OfferPaymentModeForSelfRegisteredOrganizationsLst extends Element{
		public OfferPaymentModeForSelfRegisteredOrganizationsLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	
	public OfferPaymentModeForSelfRegisteredOrganizationsLst offerPaymentModeForSelfRegisteredOrganizationsLst = new OfferPaymentModeForSelfRegisteredOrganizationsLst();
	
	/**
	 * To set Billing actions for Provision as Pro-rated,Full month,next month
	 */
	public class OfferBillingActionsForProvisionProratedRdo extends Element{
		public OfferBillingActionsForProvisionProratedRdo(){
			setElement(readAppData(this));
		}
	}
	
	public OfferBillingActionsForProvisionProratedRdo offerBillingActionsForProvisionProratedRdo = new OfferBillingActionsForProvisionProratedRdo();
	
	/**
	 * To set Billing actions for Provision as Pro-rated,Full month,next month
	 */
	public class OfferBillingActionsForProvisionFullMonthRdo extends Element{
		public OfferBillingActionsForProvisionFullMonthRdo(){
			setElement(readAppData(this));
		}
	}
	
	public OfferBillingActionsForProvisionFullMonthRdo offerBillingActionsForProvisionFullMonthRdo = new OfferBillingActionsForProvisionFullMonthRdo();
	
	/**
	 * To set Billing actions for Provision as Pro-rated,Full month,next month
	 */
	public class OfferBillingActionsForProvisionNextMonthRdo extends Element{
		public OfferBillingActionsForProvisionNextMonthRdo(){
			setElement(readAppData(this));
		}
	}
	
	public OfferBillingActionsForProvisionNextMonthRdo offerBillingActionsForProvisionNextMonthRdo = new OfferBillingActionsForProvisionNextMonthRdo();
	
	/**
	 * To set Billing actions for Up-size as Pro-rated,Full month,next month
	 */
	public class OfferBillingActionsForUpsizeProratedRdo extends Element{
		public OfferBillingActionsForUpsizeProratedRdo(){
			setElement(readAppData(this));
		}
	}
	
	public OfferBillingActionsForUpsizeProratedRdo offerBillingActionsForUpsizeProratedRdo = new OfferBillingActionsForUpsizeProratedRdo();
	
	/**
	 * To set Billing actions for Up-size as Pro-rated,Full month,next month
	 */
	public class OfferBillingActionsForUpsizeFullMonthRdo extends Element{
		public OfferBillingActionsForUpsizeFullMonthRdo(){
			setElement(readAppData(this));
		}
	}
	
	public OfferBillingActionsForUpsizeFullMonthRdo offerBillingActionsForUpsizeFullMonthRdo = new OfferBillingActionsForUpsizeFullMonthRdo();
	
	/**
	 * To set Billing actions for Down-size as Pro-rated,Full month,next month
	 */
	public class OfferBillingActionsForDownsizeProratedRdo extends Element{
		public OfferBillingActionsForDownsizeProratedRdo(){
			setElement(readAppData(this));
		}
	}
	
	public OfferBillingActionsForDownsizeProratedRdo offerBillingActionsForDownsizeProratedRdo = new OfferBillingActionsForDownsizeProratedRdo();
	
	/**
	 * To set Billing actions for Down-size as Pro-rated,Full month,next month
	 */
	public class OfferBillingActionsForDownsizeFullMonthRdo extends Element{
		public OfferBillingActionsForDownsizeFullMonthRdo(){
			setElement(readAppData(this));
		}
	}
	
	public OfferBillingActionsForDownsizeFullMonthRdo offerBillingActionsForDownsizeFullMonthRdo = new OfferBillingActionsForDownsizeFullMonthRdo();
	
}
