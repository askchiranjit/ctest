package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To create new offers with any service and any number of item and Provisioning information
 * @author Dip
 *
 */
public class OfferMainController extends AppData{
	
	/*
	 * To click on Offer's general properties section
	 */
	public class OfferGeneralPropertiesLnk extends Element{
		
		public OfferGeneralPropertiesLnk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferGeneralPropertiesLnk offerGeneralPropertiesLnk = new OfferGeneralPropertiesLnk();
	
	/*
	 * To click on Offer's Subscription Properties section
	 */
	public class OfferSubscriptionPropertiesLnk extends Element{
		
		public OfferSubscriptionPropertiesLnk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferSubscriptionPropertiesLnk offerSubscriptionPropertiesLnk = new OfferSubscriptionPropertiesLnk();
	
	/*
	 * To click on Offer's Type section
	 */
	public class OfferTypePropertiesLnk extends Element{
		
		public OfferTypePropertiesLnk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferTypePropertiesLnk offerTypePropertiesLnk = new OfferTypePropertiesLnk();
	
	/*
	 * To click on Offer's Billing Rules section
	 */
	public class OfferBillingRulesLnk extends Element{
		
		public OfferBillingRulesLnk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferBillingRulesLnk offerBillingRulesLnk = new OfferBillingRulesLnk();
	
	/*
	 * To click on Offer's Item Configuration Details section
	 */
	public class OfferItemConfigurationDetailsLnk extends Element{
		
		public OfferItemConfigurationDetailsLnk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferItemConfigurationDetailsLnk offerItemConfigurationDetailsLnk = new OfferItemConfigurationDetailsLnk();
	
	/*
	 * To click on Offer's Marketplace Content section
	 */
	public class OfferMarketplaceContentLnk extends Element{
		
		public OfferMarketplaceContentLnk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferMarketplaceContentLnk offerMarketplaceContentLnk = new OfferMarketplaceContentLnk();
	
	/*
	 * To click on Offer's Catalog Attributes section
	 */
	public class OfferCatalogAttributesLnk extends Element{
		
		public OfferCatalogAttributesLnk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCatalogAttributesLnk offerCatalogAttributesLnk = new OfferCatalogAttributesLnk();
	
	/*
	 * To click on Offer's Provisioning Work-flow section
	 */
	public class OfferProvisioningWorkflowLnk extends Element{
		
		public OfferProvisioningWorkflowLnk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferProvisioningWorkflowLnk offerProvisioningWorkflowLnk = new OfferProvisioningWorkflowLnk();
	
	/*
	 * To click on Offer's Term and Condition and Notification Macro section
	 */
	public class OfferTermsAndNotificationMacroLnk extends Element{
		
		public OfferTermsAndNotificationMacroLnk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferTermsAndNotificationMacroLnk OfferTermsAndNotificationMacroLnk = new OfferTermsAndNotificationMacroLnk();
	
	/*
	 * To click on "Cancel" button to come out without saving that offer
	 */
	public class OfferCancelBtn extends Element{
		public OfferCancelBtn(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCancelBtn offerCancelBtn = new OfferCancelBtn();
	
	/*
	 * To click on "Save" button to an offer
	 */
	public class OfferSaveBtn extends Element{
		public OfferSaveBtn(){
			setElement(readAppData(this));
		}
	}
	
	public OfferSaveBtn offerSaveBtn = new OfferSaveBtn();
}
