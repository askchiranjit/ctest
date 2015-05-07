
package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * This is use to get the all account related values of an Organization
 * @author Dip
 *
 */
public class OrganizationAccounts extends AppData{
	/**
	 * Click on Account Name Expander
	 * to get the Accounts details
	 * @author Dip
	 *
	 */
	public class OrgAccountsLnk extends Element{
		public OrgAccountsLnk(){
			setElement(readAppData(this));
		}
		
	}
	public OrgAccountsLnk orgAccountsLnk = new OrgAccountsLnk();
	
	/**
	 * To list out more than 5 organization's accounts in a single page 
	 * @author Dip
	 *
	 */
	public class DisplayAllAccountsBtn extends Element{
		public DisplayAllAccountsBtn(){
			setElement(readAppData(this));
		}
	}
	//TODO: need to handle pop-up of this button(to view and edit more than 5a/c if available in a org)
	public DisplayAllAccountsBtn displayAllAccountsBtn = new DisplayAllAccountsBtn();
	
	/**
	 * To get the Organization's Account ID 
	 * @author Dip
	 *
	 */
	public class OrgAccountIDFld extends Element{
		public OrgAccountIDFld(){
			setElement(readAppData(this));
		}
	}
	public OrgAccountIDFld orgAccountIDFld = new OrgAccountIDFld();
	
	/**
	 * To get the Organization's Account Name 
	 * @author Dip
	 *
	 */
	public class OrgAccountNameFld extends Element{
		public OrgAccountNameFld(){
			setElement(readAppData(this));
		}
	}
	public OrgAccountNameFld orgAccountNameFld = new OrgAccountNameFld();
	
	/**
	 * To get the Organization's Corporate ID 
	 * @author Dip
	 *
	 */
	public class OrgCorporateIDFld extends Element{
		public OrgCorporateIDFld(){
			setElement(readAppData(this));
		}
	}
	public OrgCorporateIDFld orgCorporateIDFld = new OrgCorporateIDFld();
	
	/**
	 * To get the Organization's Currency 
	 * @author Dip
	 *
	 */
	public class OrgCurrencyFld extends Element{
		public OrgCurrencyFld(){
			setElement(readAppData(this));
		}
	}
	public OrgCurrencyFld orgCurrencyFld = new OrgCurrencyFld();
	
	/**
	 * To get the Organization's Payment Agreement
	 * @author Dip
	 *
	 */
	public class OrgPaymentAgreementFld extends Element{
		public OrgPaymentAgreementFld(){
			setElement(readAppData(this));
		}
	}
	public OrgPaymentAgreementFld orgPaymentAgreementFld = new OrgPaymentAgreementFld();
	
	/**
	 * To get the Organization's Billable to Account 
	 * @author Dip
	 *
	 */
	public class OrgBillableToAccountFld extends Element{
		public OrgBillableToAccountFld(){
			setElement(readAppData(this));
		}
	}
	public OrgBillableToAccountFld orgBillableToAccountFld = new OrgBillableToAccountFld();
	
	/**
	 * To get the Organization's Billing Language 
	 * @author Dip
	 *
	 */
	public class OrgBillingLanguageFld extends Element{
		public OrgBillingLanguageFld(){
			setElement(readAppData(this));
		}
	}
	public OrgBillingLanguageFld orgBillingLanguageFld = new OrgBillingLanguageFld();
	
	/**
	 * To get the Organization's Communication Language 
	 * @author Dip
	 *
	 */
	public class OrgCommunicationLanguageFld extends Element{
		public OrgCommunicationLanguageFld(){
			setElement(readAppData(this));
		}
	}
	public OrgCommunicationLanguageFld orgCommunicationLanguageFld = new OrgCommunicationLanguageFld();
	
	/**
	 * To get the Organization's UserName Suffix 
	 * @author Dip
	 *
	 */
	public class OrgUserNameSuffixFld extends Element{
		public OrgUserNameSuffixFld(){
			setElement(readAppData(this));
		}
	}
	public OrgUserNameSuffixFld orgUserNameSuffixFld = new OrgUserNameSuffixFld();
	
	/**
	 * To get the Organization's Email addresses to receive financial documents 
	 * @author Dip
	 *
	 */
	public class OrgFinancialEmailFld extends Element{
		public OrgFinancialEmailFld(){
			setElement(readAppData(this));
		}
	}
	public OrgFinancialEmailFld orgFinancialEmailFld = new OrgFinancialEmailFld();
	
	/**
	 * To get the info whether Use organization address as account address or not
	 * @author Dip
	 *
	 */
	public class UseOrgAddressAsAccountAddressFld extends Element{
		public UseOrgAddressAsAccountAddressFld(){
			setElement(readAppData(this));
		}
	}
	public UseOrgAddressAsAccountAddressFld useOrgAddressAsAccountAddressFld = new UseOrgAddressAsAccountAddressFld();
	
	/**
	 * To get the Organization Account's Address Line 1 
	 * @author Dip
	 *
	 */
	public class OrgAccountAddressLine1Fld extends Element{
		public OrgAccountAddressLine1Fld(){
			setElement(readAppData(this));
		}
	}
	public OrgAccountAddressLine1Fld orgAccountAddressLine1Fld = new OrgAccountAddressLine1Fld();
	
	/**
	 * To get the Organization Account's Address Line 2 
	 * @author Dip
	 *
	 */
	public class OrgAccountAddressLine2Fld extends Element{
		public OrgAccountAddressLine2Fld(){
			setElement(readAppData(this));
		}
	}
	public OrgAccountAddressLine2Fld orgAccountAddressLine2Fld = new OrgAccountAddressLine2Fld();
	
	/**
	 * To get the Organization Account's City Name
	 * @author Dip
	 *
	 */
	public class OrgAccountCityNameFld extends Element{
		public OrgAccountCityNameFld(){
			setElement(readAppData(this));
		}
	}
	public OrgAccountCityNameFld orgAccountCityNameFld = new OrgAccountCityNameFld();
	
	/**
	 * To get the Organization Account's City Code
	 * @author Dip
	 *
	 */
	public class OrgAccountCityCodeFld extends Element{
		public OrgAccountCityCodeFld(){
			setElement(readAppData(this));
		}
	}
	public OrgAccountCityCodeFld orgAccountCityCodeFld = new OrgAccountCityCodeFld();
	
	/**
	 * To get the Organization Account's Zip Code
	 * @author Dip
	 *
	 */
	public class OrgAccountZipCodeFld extends Element{
		public OrgAccountZipCodeFld(){
			setElement(readAppData(this));
		}
	}
	public OrgAccountZipCodeFld orgAccountZipCodeFld = new OrgAccountZipCodeFld();
	
	/**
	 * To get the Organization Account's State
	 * @author Dip
	 *
	 */
	public class OrgAccountStateFld extends Element{
		public OrgAccountStateFld(){
			setElement(readAppData(this));
		}
	}
	public OrgAccountStateFld orgAccountStateFld = new OrgAccountStateFld();
	
	/**
	 * To get the Organization Account's Country
	 * @author Dip
	 *
	 */
	public class OrgAccountCountryFld extends Element{
		public OrgAccountCountryFld(){
			setElement(readAppData(this));
		}
	}
	public OrgAccountCountryFld orgAccountCountryFld = new OrgAccountCountryFld();
	
	/**
	 * To Click on Edit Account button
	 * @author Dip
	 *
	 */
	public class OrgEditAccountBtn extends Element{
		public OrgEditAccountBtn(){
			setElement(readAppData(this));
		}
	}
	public OrgEditAccountBtn orgEditAccountBtn = new OrgEditAccountBtn();
	
	
	
//--------Edit Account Details Section--------
	
	
	/**
	 * To Edit the Organization's Account ID 
	 * @author Dip
	 *
	 */
	public class OrgAccountIDEditTxt extends Element{
		public OrgAccountIDEditTxt(){
			setElement(readAppData(this));
		}
	}
	public OrgAccountIDEditTxt orgAccountIDEditTxt = new OrgAccountIDEditTxt();
	
	/**
	 * To Edit the Organization's Account Name 
	 * @author Dip
	 *
	 */
	public class OrgAccountNameEditTxt extends Element{
		public OrgAccountNameEditTxt(){
			setElement(readAppData(this));
		}
	}
	public OrgAccountNameEditTxt orgAccountNameEditTxt = new OrgAccountNameEditTxt();
	
	/**
	 * To Edit the Organization's Corporate ID 
	 * @author Dip
	 *
	 */
	public class OrgCorporateIDEditTxt extends Element{
		public OrgCorporateIDEditTxt(){
			setElement(readAppData(this));
		}
	}
	public OrgCorporateIDEditTxt orgCorporateIDEditTxt = new OrgCorporateIDEditTxt();
	
	/**
	 * To Edit the Organization's Currency 
	 * @author Dip
	 *
	 */
	public class OrgCurrencyEditLst extends Element{
		public OrgCurrencyEditLst(){
			setElement(readAppData(this));
		}
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	public OrgCurrencyEditLst orgCurrencyEditLst = new OrgCurrencyEditLst();
	
	/**
	 * To Edit the Organization's External Billing Id
	 * @author Dip
	 *
	 */
	public class OrgExternalBillingIDEditTxt extends Element{
		public OrgExternalBillingIDEditTxt(){
			setElement(readAppData(this));
		}
	}
	public OrgExternalBillingIDEditTxt orgExternalBillingIDEditTxt = new OrgExternalBillingIDEditTxt();
	
	/**
	 * To Edit the Organization's Payment Agreement
	 * @author Dip
	 *
	 */
	public class OrgPaymentAgreementEditLst extends Element{
		public OrgPaymentAgreementEditLst(){
			setElement(readAppData(this));
		}
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	public OrgPaymentAgreementEditLst orgPaymentAgreementEditLst = new OrgPaymentAgreementEditLst();
	
	/**
	 * To edit the Organization's Billable to Account 
	 * @author Dip
	 *
	 */
	public class OrgBillableToAccountEditLst extends Element{
		public OrgBillableToAccountEditLst(){
			setElement(readAppData(this));
		}
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	public OrgBillableToAccountEditLst orgBillableToAccountEditLst = new OrgBillableToAccountEditLst();
	
	/**
	 * To edit the Organization's Billing Language 
	 * @author Dip
	 *
	 */
	public class OrgBillingLanguageEditLst extends Element{
		public OrgBillingLanguageEditLst(){
			setElement(readAppData(this));
		}
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	public OrgBillingLanguageEditLst orgBillingLanguageEditLst = new OrgBillingLanguageEditLst();
	
	/**
	 * To edit the Organization's Communication Language 
	 * @author Dip
	 *
	 */
	public class OrgCommunicationLanguageEditLst extends Element{
		public OrgCommunicationLanguageEditLst(){
			setElement(readAppData(this));
		}
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	public OrgCommunicationLanguageEditLst orgCommunicationLanguageEditLst = new OrgCommunicationLanguageEditLst();
	
	/**
	 * To Edit the Organization's Email addresses to receive financial documents 
	 * @author Dip
	 *
	 */
	public class OrgFinancialEmailEditTxt extends Element{
		public OrgFinancialEmailEditTxt(){
			setElement(readAppData(this));
		}
	}
	public OrgFinancialEmailEditTxt orgFinancialEmailEditTxt = new OrgFinancialEmailEditTxt();
	
	/**
	 * To use different address rather use of organization address as account address
	 * @author Dip
	 *
	 */
	public class UseDifferentAddressAsAccountAddressImgBtn extends Element{
		public UseDifferentAddressAsAccountAddressImgBtn(){
			setElement(readAppData(this));
		}
	}
	public UseDifferentAddressAsAccountAddressImgBtn useDifferentAddressAsAccountAddressImgBtn = new UseDifferentAddressAsAccountAddressImgBtn();
	
	/**
	 * To use organization address as account address rather use of different address as account address
	 * @author Dip
	 *
	 */
	public class UseOrgAddressAsAccountAddressImgBtn extends Element{
		public UseOrgAddressAsAccountAddressImgBtn(){
			setElement(readAppData(this));
		}
		
		//TODO: Need to handle alert
	}
	public UseOrgAddressAsAccountAddressImgBtn useOrgAddressAsAccountAddressImgBtn = new UseOrgAddressAsAccountAddressImgBtn();
	/**
	 * To Edit the Organization Account's Address Line 1 
	 * @author Dip
	 *
	 */
	public class OrgAccountAddressLine1EditTxt extends Element{
		public OrgAccountAddressLine1EditTxt(){
			setElement(readAppData(this));
		}
	}
	public OrgAccountAddressLine1EditTxt orgAccountAddressLine1EditTxt = new OrgAccountAddressLine1EditTxt();
	
	/**
	 * To Edit the Organization Account's Address Line 2 
	 * @author Dip
	 *
	 */
	public class OrgAccountAddressLine2EditTxt extends Element{
		public OrgAccountAddressLine2EditTxt(){
			setElement(readAppData(this));
		}
	}
	public OrgAccountAddressLine2EditTxt orgAccountAddressLine2EditTxt = new OrgAccountAddressLine2EditTxt();
	
	/**
	 * To Edit the Organization Account's City Name
	 * @author Dip
	 *
	 */
	public class OrgAccountCityNameEditTxt extends Element{
		public OrgAccountCityNameEditTxt(){
			setElement(readAppData(this));
		}
	}
	public OrgAccountCityNameEditTxt orgAccountCityNameEditTxt = new OrgAccountCityNameEditTxt();
	
	/**
	 * To Edit the Organization Account's City Code
	 * @author Dip
	 *
	 */
	public class OrgAccountCityCodeEditTxt extends Element{
		public OrgAccountCityCodeEditTxt(){
			setElement(readAppData(this));
		}
	}
	public OrgAccountCityCodeEditTxt orgAccountCityCodeEditTxt = new OrgAccountCityCodeEditTxt();
	
	/**
	 * To Edit the Organization Account's Zip Code
	 * @author Dip
	 *
	 */
	public class OrgAccountZipCodeEditTxt extends Element{
		public OrgAccountZipCodeEditTxt(){
			setElement(readAppData(this));
		}
	}
	public OrgAccountZipCodeEditTxt orgAccountZipCodeEditTxt = new OrgAccountZipCodeEditTxt();
	
	/**
	 * To edit the Organization Account's State
	 * @author Dip
	 *
	 */
	public class OrgAccountStateEditTxt extends Element{
		public OrgAccountStateEditTxt(){
			setElement(readAppData(this));
		}
	}
	public OrgAccountStateEditTxt orgAccountStateEditTxt = new OrgAccountStateEditTxt();
	
	/**
	 * To edit the Organization Account's Country
	 * @author Dip
	 *
	 */
	public class OrgAccountCountryEditLst extends Element{
		public OrgAccountCountryEditLst(){
			setElement(readAppData(this));
		}
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	public OrgAccountCountryEditLst orgAccountCountryEditLst = new OrgAccountCountryEditLst();
	
	/**
	 * To Click on Cancel button
	 * @author Dip
	 *
	 */
	public class CancelEditAccountBtn extends Element{
		public CancelEditAccountBtn(){
			setElement(readAppData(this));
		}
	}
	public CancelEditAccountBtn cancelEditAccountBtn = new CancelEditAccountBtn();
	
	/**
	 * To Click on Update button
	 * @author Dip
	 *
	 */
	public class UpdateEditAccountBtn extends Element{
		public UpdateEditAccountBtn(){
			setElement(readAppData(this));
		}
	}
	public UpdateEditAccountBtn updateEditAccountBtn = new UpdateEditAccountBtn();
	
}

