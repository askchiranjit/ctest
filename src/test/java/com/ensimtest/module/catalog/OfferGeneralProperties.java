package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;


/**
 * To cover all controls under General Properties section
 * @author Dip
 *
 */
public class OfferGeneralProperties extends AppData{
	/*
	 * To select Category name under which new offer going to be resides
	 */
	public class OfferCategoryNameLst extends Element{
		
		public OfferCategoryNameLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
				
		@Override
		public String read()
		{
			return super.getSelectedType();
		}
	}
	
	public OfferCategoryNameLst offerCategoryNameLst = new OfferCategoryNameLst();
	
	/*
	 * To provide Service Code
	 */
	public class OfferServiceCodeTxt extends Element{
		
		public OfferServiceCodeTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferServiceCodeTxt offerServiceCodeTxt = new OfferServiceCodeTxt();
	
	/*
	 * To provide Unique Identifier
	 */
	public class OfferUniqueIdentifierTxt extends Element{
		public OfferUniqueIdentifierTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferUniqueIdentifierTxt offerUniqueIdentifierTxt = new OfferUniqueIdentifierTxt();
	
	/*
	 * To check that provided Unique Identifier is available or not
	 */
	public class OfferUniqueIdentifierMsgChkLbl extends Element{
		public OfferUniqueIdentifierMsgChkLbl(){
			setElement(readAppData(this));
		}
	}
	
	public OfferUniqueIdentifierMsgChkLbl offerUniqueIdentifierMsgChkLbl = new OfferUniqueIdentifierMsgChkLbl();
	
	/*
	 * To provide Catalog ID
	 */
	public class OfferCatalogIDTxt extends Element{
		public OfferCatalogIDTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCatalogIDTxt offerCatalogIDTxt = new OfferCatalogIDTxt();
	
	/*
	 * To provide Tariff Code
	 */
	public class OfferTariffCodeTxt extends Element{
		public OfferTariffCodeTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferTariffCodeTxt offerTariffCodeTxt = new OfferTariffCodeTxt();
	
	/*
	 * To provide Offer's display name
	 */
	public class OfferDisplayNameTxt extends Element{
		public OfferDisplayNameTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferDisplayNameTxt offerDisplayNameTxt = new OfferDisplayNameTxt();
	
	/*
	 * To select a Global region radio button 
	 */
	public class OfferGlobalRegionRdo extends Element{
		public OfferGlobalRegionRdo(){
			setElement(readAppData(this));
		}
	}
	
	public OfferGlobalRegionRdo offerGlobalRegionRdo = new OfferGlobalRegionRdo();
	
	/*
	 * To select a regional radio button 
	 */
	public class OfferRegionalRdo extends Element{
		public OfferRegionalRdo(){
			setElement(readAppData(this));
		}
	}
	
	public OfferRegionalRdo offerRegionalRdo = new OfferRegionalRdo();
	
	/*
	 * To select a region name
	 */
	public class OfferRegionSelectLst extends Element{
		public OfferRegionSelectLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	
	public OfferRegionSelectLst offerRegionSelectLst = new OfferRegionSelectLst();
	
	/*
	 * To provide offer's description
	 */
	public class OfferDescriptionTxt extends Element{
		public OfferDescriptionTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferDescriptionTxt offerDescriptionTxt = new OfferDescriptionTxt();
	
	/*
	 * To set offer Activation status as Activate or Deactivate
	 */
	public class OfferActivationStatusLst extends Element{
		public OfferActivationStatusLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	
	public OfferActivationStatusLst offerActivationStatusLst = new OfferActivationStatusLst();
	
	/*
	 * To provide value for Offer Search tags
	 */
	public class OfferSearchTagsTxt extends Element{
		public OfferSearchTagsTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferSearchTagsTxt offerSearchTagsTxt = new OfferSearchTagsTxt();
	
	/*
	 * To Lock an offer from further editing
	 */
	public class OfferLockFurtherEditingChk extends Element{
		public OfferLockFurtherEditingChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferLockFurtherEditingChk offerLockFurtherEditingChk = new OfferLockFurtherEditingChk();
	
	/*
	 * To select a reseller for P2R offer
	 */
	public class OfferTagToResellerLst extends Element{
		public OfferTagToResellerLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	
	public OfferTagToResellerLst offerTagToResellerLst = new OfferTagToResellerLst();
	
	/*
	 * To set At least One constraint in Offer
	 */
	public class OfferAtLeastOneConstraintChk extends Element{
		public OfferAtLeastOneConstraintChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferAtLeastOneConstraintChk offerAtLeastOneConstraintChk = new OfferAtLeastOneConstraintChk();
	
	/*
	 * To configured At least One constraint (configuration button)
	 */
	public class OfferConfigAtLeastOneConstraintBtn extends Element{
		public OfferConfigAtLeastOneConstraintBtn(){
			setElement(readAppData(this));
		}
	}
	
	public OfferConfigAtLeastOneConstraintBtn offerConfigAtLeastOneConstraintBtn = new OfferConfigAtLeastOneConstraintBtn();
	
	/*
	 * To set Depends-on constraint in Offer
	 */
	public class OfferDependsOnConstraintChk extends Element{
		public OfferDependsOnConstraintChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferDependsOnConstraintChk offerDependsOnConstraintChk = new OfferDependsOnConstraintChk();
	
	/*
	 * To configured Depends-on constraint (configuration button)
	 */
	public class OfferConfigDependsOnConstraintBtn extends Element{
		public OfferConfigDependsOnConstraintBtn(){
			setElement(readAppData(this));
		}
	}
	
	public OfferConfigDependsOnConstraintBtn offerConfigDependsOnConstraintBtn = new OfferConfigDependsOnConstraintBtn();
	
	/*
	 * To set Limit Organization Global Discount in Offer
	 */
	public class OfferLimitOrganizationGlobalDiscountChk extends Element{
		public OfferLimitOrganizationGlobalDiscountChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferLimitOrganizationGlobalDiscountChk offerLimitOrganizationGlobalDiscountChk = new OfferLimitOrganizationGlobalDiscountChk();
	
	/*
	 * To configured Limit Organization Global Discount (configuration button)
	 */
	public class OfferConfigLimitOrganizationGlobalDiscountBtn extends Element{
		public OfferConfigLimitOrganizationGlobalDiscountBtn(){
			setElement(readAppData(this));
		}
	}
	
	public OfferConfigLimitOrganizationGlobalDiscountBtn offerConfigLimitOrganizationGlobalDiscountBtn = new OfferConfigLimitOrganizationGlobalDiscountBtn();
	
	/*
	 * To set offer Up-grade path
	 */
	public class OfferUpgradableToLst extends Element{
		public OfferUpgradableToLst(){
			setElement(readAppData(this));
		}
		
		public void select(String[] upgradeList){
			for(int i=0;i<upgradeList.length;i++){
				String upgradeOfferName = getActualString(upgradeList[i]);
				super.selectVisibleText(upgradeOfferName);
			}
		}
		
		public String getActualString(String data){
			String upgradeToOffer = this.read();
			String upgradeToOfferList[] = upgradeToOffer.split("\n");
			
			for(int i=1; i<upgradeToOfferList.length;i++){
				
				int lastIndexOfWeight = upgradeToOfferList[i].lastIndexOf("(");
				
				if(data.equals(upgradeToOfferList[i].substring(0, lastIndexOfWeight).trim())){
					return upgradeToOfferList[i];
				}
			}
			
			return null;
		}
	}
	
	public OfferUpgradableToLst offerUpgradableToLst = new OfferUpgradableToLst();
	
	/*
	 * To configured the up-grade offer one time item button
	 */
	public class OfferConfigureUpgradableToBtn extends Element{
		public OfferConfigureUpgradableToBtn(){
			setElement(readAppData(this));
		}
	}
	
	public OfferConfigureUpgradableToBtn offerConfigureUpgradableToBtn = new OfferConfigureUpgradableToBtn();
	
	/*
	 * To set Upgrade weight of an Offer
	 */
	public class OfferUpgradeWeightTxt extends Element{
		public OfferUpgradeWeightTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferUpgradeWeightTxt offerUpgradeWeightTxt = new OfferUpgradeWeightTxt();
	
	/*
	 * To set Up-size allowed or not for an Offer
	 */
	public class OfferUpsizeAllowedChk extends Element{
		public OfferUpsizeAllowedChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferUpsizeAllowedChk offerUpsizeAllowedChk = new OfferUpsizeAllowedChk();
	
	/*
	 * To set Down-size allowed or not for an offer
	 */
	public class OfferDownsizeAllowedChk extends Element{
		public OfferDownsizeAllowedChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferDownsizeAllowedChk offerDownsizeAllowedChk = new OfferDownsizeAllowedChk();
	
	/*
	 * To set Message during upgrade on or off
	 */
	public class OfferMessageDuringUpgradeChk extends Element{
		public OfferMessageDuringUpgradeChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferMessageDuringUpgradeChk offerMessageDuringUpgradeChk = new OfferMessageDuringUpgradeChk();
	
	/*
	 * To set Contract period value
	 */
	public class OfferContractPeriodValueTxt extends Element{
		public OfferContractPeriodValueTxt(){
			setElement(readAppData(this));
		}
		
		@Override
		public void write(String data){
		
			String str = super.getAttributeValue("value");
			super.clearAllChars(str.length());
			super.write(data);
		}
	}
	
	public OfferContractPeriodValueTxt offerContractPeriodValueTxt = new OfferContractPeriodValueTxt();
	
	/*
	 * To select Contract period type i.e day,week,month,year
	 */
	public class OfferContractPeriodTypeLst extends Element{
		public OfferContractPeriodTypeLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	
	public OfferContractPeriodTypeLst offerContractPeriodTypeLst = new OfferContractPeriodTypeLst();
	
	/*
	 * To set value for Maximum number of orders of an offer per organization
	 */
	public class OfferMaxOrderQtyPerOrgTxt extends Element{
		public OfferMaxOrderQtyPerOrgTxt(){
			setElement(readAppData(this));
		}
		
		@Override
		public void write(String data){
		
			String str = super.getAttributeValue("value");
			super.clearAllChars(str.length());
			super.write(data);
		}
	}
	
	public OfferMaxOrderQtyPerOrgTxt offerMaxOrderQtyPerOrgTxt = new OfferMaxOrderQtyPerOrgTxt();
	
	/*
	 * To set value for Data Retention Period of an offer
	 */
	public class OfferDataRetentionPeriodValueTxt extends Element{
		public OfferDataRetentionPeriodValueTxt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferDataRetentionPeriodValueTxt offerDataRetentionPeriodValueTxt = new OfferDataRetentionPeriodValueTxt();
	
	/*
	 * To select type for Data Retention Period of an offer i.e. day,week,month,year
	 */
	public class OfferDataRetentionPeriodTypeLst extends Element{
		public OfferDataRetentionPeriodTypeLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	
	public OfferDataRetentionPeriodTypeLst offerDataRetentionPeriodTypeLst = new OfferDataRetentionPeriodTypeLst();
	
	/*
	 * To on First notification option before data wipe
	 */
	public class OfferFirstNotificationChk extends Element{
		public OfferFirstNotificationChk(){
			setElement(readAppData(this));
		}
	}
	
	public OfferFirstNotificationChk offerFirstNotificationChk = new OfferFirstNotificationChk();
	
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
	
	/*
	 * To set a value for Custom Field1
	 */
	public class OfferCustomField1Txt extends Element{
		public OfferCustomField1Txt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCustomField1Txt offerCustomField1Txt = new OfferCustomField1Txt();
	
	/*
	 * To set a value for Custom Field2
	 */
	public class OfferCustomField2Txt extends Element{
		public OfferCustomField2Txt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCustomField2Txt offerCustomField2Txt = new OfferCustomField2Txt();
	
	/*
	 * To set a value for Custom Field3
	 */
	public class OfferCustomField3Txt extends Element{
		public OfferCustomField3Txt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCustomField3Txt offerCustomField3Txt = new OfferCustomField3Txt();
	
	/*
	 * To set a value for Custom Field4
	 */
	public class OfferCustomField4Txt extends Element{
		public OfferCustomField4Txt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCustomField4Txt offerCustomField4Txt = new OfferCustomField4Txt();
	
	/*
	 * To set a value for Custom Field5
	 */
	public class OfferCustomField5Txt extends Element{
		public OfferCustomField5Txt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCustomField5Txt offerCustomField5Txt = new OfferCustomField5Txt();
	
	/*
	 * To set a value for Custom Field6
	 */
	public class OfferCustomField6Txt extends Element{
		public OfferCustomField6Txt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCustomField6Txt offerCustomField6Txt = new OfferCustomField6Txt();
	
	/*
	 * To set a value for Custom Field7
	 */
	public class OfferCustomField7Txt extends Element{
		public OfferCustomField7Txt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCustomField7Txt offerCustomField7Txt = new OfferCustomField7Txt();
	
	/*
	 * To set a value for Custom Field8
	 */
	public class OfferCustomField8Txt extends Element{
		public OfferCustomField8Txt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCustomField8Txt offerCustomField8Txt = new OfferCustomField8Txt();
	
	/*
	 * To set a value for Custom Field9
	 */
	public class OfferCustomField9Txt extends Element{
		public OfferCustomField9Txt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCustomField9Txt offerCustomField9Txt = new OfferCustomField9Txt();
	
	/*
	 * To set a value for Custom Field10
	 */
	public class OfferCustomField10Txt extends Element{
		public OfferCustomField10Txt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCustomField10Txt offerCustomField10Txt = new OfferCustomField10Txt();
	
	/*
	 * To set a value for Custom Field11
	 */
	public class OfferCustomField11Txt extends Element{
		public OfferCustomField11Txt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCustomField11Txt offerCustomField11Txt = new OfferCustomField11Txt();
	
	/*
	 * To set a value for Custom Field12
	 */
	public class OfferCustomField12Txt extends Element{
		public OfferCustomField12Txt(){
			setElement(readAppData(this));
		}
	}
	
	public OfferCustomField12Txt offerCustomField12Txt = new OfferCustomField12Txt();
}
