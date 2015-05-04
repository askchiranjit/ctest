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
	public class UseOrgAddressAsAccountAddress extends Element{
		public UseOrgAddressAsAccountAddress(){
			setElement(readAppData(this));
		}
	}
	public UseOrgAddressAsAccountAddress useOrgAddressAsAccountAddress = new UseOrgAddressAsAccountAddress();
	
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
}
