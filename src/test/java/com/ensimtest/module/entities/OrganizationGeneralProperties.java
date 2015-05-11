package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * Organization's General Properties Wizard:
 * 1. General Properties
 * 2. Organization Owner Information
 * 3. Organization Global Discount
 * 4. Custom fields
 * @author Dip
 *
 */
public class OrganizationGeneralProperties extends AppData {
	
	/**
	 * Click on General Properties Expander
	 * 1.Status
	 * 2.Change Status
	 * 3.Default Business Contact
	 * 4.Default Technical Contact
	 * 5.VAT Number
	 * 6.Communication Language
	 * 7.Billing Language
	 * 8.Macro Segment
	 * @author Dip
	 *
	 */
	public class GeneralPropertiesLnk extends Element{
		public GeneralPropertiesLnk(){
			setElement(readAppData(this));
		}
		
	}
	public GeneralPropertiesLnk gneralPropertiesLnk = new GeneralPropertiesLnk();
	
	/**
	 * Check for Status Filed value
	 * @author Dip
	 *
	 */
	public class StatusFld extends Element{
		public StatusFld(){
			setElement(readAppData(this));
		}
		
	}
	public StatusFld statusFld = new StatusFld();
	
	/**
	 * Check for Change Button value
	 * @author Dip
	 *
	 */
	public class ChangeStatusBtn extends Element{
		public ChangeStatusBtn(){
			setElement(readAppData(this));
		}
		
	}
	public ChangeStatusBtn changeStatusBtn = new ChangeStatusBtn();
	
	/**
	 * Check for Default Business Contact Filed value
	 * @author Dip
	 *
	 */
	public class DefaultBCFld extends Element{
		public DefaultBCFld(){
			setElement(readAppData(this));
		}
		
	}
	public DefaultBCFld defaultBCFld = new DefaultBCFld();
	
	/**
	 * Check for Default Technical Contact Filed value
	 * @author Dip
	 *
	 */
	public class DefaultTCFld extends Element{
		public DefaultTCFld(){
			setElement(readAppData(this));
		}
		
	}
	public DefaultTCFld defaultTCFld = new DefaultTCFld();
	
	/**
	 * Check for VAT Number Filed value
	 * @author Dip
	 *
	 */
	public class VATNumberFld extends Element{
		public VATNumberFld(){
			setElement(readAppData(this));
		}
		
	}
	public VATNumberFld vATNumberFld = new VATNumberFld();
	
	/**
	 * Check for Communication Language Filed value
	 * @author Dip
	 *
	 */
	public class CommunicationLangFld extends Element{
		public CommunicationLangFld(){
			setElement(readAppData(this));
		}
		
	}
	public CommunicationLangFld communicationLangFld = new CommunicationLangFld();
	
	/**
	 * Check for Billing Language Filed value
	 * @author Dip
	 *
	 */
	public class BillingLangFld extends Element{
		public BillingLangFld(){
			setElement(readAppData(this));
		}
		
	}
	public BillingLangFld billingLangFld = new BillingLangFld();
	
	/**
	 * Check for Macro Segment Filed value
	 * @author Dip
	 *
	 */
	public class MacroSegmentFld extends Element{
		public MacroSegmentFld(){
			setElement(readAppData(this));
		}
		
	}
	public MacroSegmentFld macroSegmentFld = new MacroSegmentFld();
	
//--------End of General Properties Expander--------
	
	/**
	 * Click on Organization Owner Information Expander
	 * 1.Organization owned by
	 * 2.Owner type
	 * 3.Change Owner
	 * 4.Sales Representative Assigned or Not
	 * 5.Change Sales Representative
	 * 6.Sales Representative Name
	 * 7.Sales Representative Email
	 * 8.Sales Representative Mobile
	 * @author Dip
	 *
	 */
	public class OrgOwnerInfoLnk extends Element{
		public OrgOwnerInfoLnk(){
			setElement(readAppData(this));
		}
		
	}
	public OrgOwnerInfoLnk orgOwnerInfoLnk = new OrgOwnerInfoLnk();
	
	/**
	 * Check for Organization Owner Name Filed value
	 * @author Dip
	 *
	 */
	public class OrgOwnedByFld extends Element{
		public OrgOwnedByFld(){
			setElement(readAppData(this));
		}
		
	}
	public OrgOwnedByFld orgOwnedByFld = new OrgOwnedByFld();
	
	/**
	 * Check for Owner type Filed value
	 * @author Dip
	 *
	 */
	public class OwnerTypeFld extends Element{
		public OwnerTypeFld(){
			setElement(readAppData(this));
		}
		
	}
	public OwnerTypeFld ownerTypeFld = new OwnerTypeFld();
	
	/**
	 * Check for Change Owner Button value
	 * @author Dip
	 *
	 */
	public class ChangeOwnerBtn extends Element{
		public ChangeOwnerBtn(){
			setElement(readAppData(this));
		}
		
	}
	public ChangeOwnerBtn changeOwnerBtn = new ChangeOwnerBtn();
	
	/**
	 * Check for Sales Representative Assigned or Not Filed value
	 * @author Dip
	 *
	 */
	public class SalesRepAssignedFld extends Element{
		public SalesRepAssignedFld(){
			setElement(readAppData(this));
		}
		
	}
	public SalesRepAssignedFld salesRepAssignedFld = new SalesRepAssignedFld();
	
	/**
	 * Click on Change Sales Representative Button value
	 * @author Dip
	 *
	 */
	public class ChangeSalesRepBtn extends Element{
		public ChangeSalesRepBtn(){
			setElement(readAppData(this));
		}
		
	}
	public ChangeSalesRepBtn changeSalesRepBtn = new ChangeSalesRepBtn();
	
	/**
	 * Check for Sales Representative Name Filed value
	 * @author Dip
	 *
	 */
	public class SalesRepNameFld extends Element{
		public SalesRepNameFld(){
			setElement(readAppData(this));
		}
		
	}
	public SalesRepNameFld salesRepNameFld = new SalesRepNameFld();
	
	/**
	 * Check for Sales Representative Email Filed value
	 * @author Dip
	 *
	 */
	public class SalesRepEmailFld extends Element{
		public SalesRepEmailFld(){
			setElement(readAppData(this));
		}
		
	}
	public SalesRepEmailFld salesRepEmailFld = new SalesRepEmailFld();
	
	/**
	 * Check for Sales Representative Mobile Filed value
	 * @author Dip
	 *
	 */
	public class SalesRepMobileFld extends Element{
		public SalesRepMobileFld(){
			setElement(readAppData(this));
		}
		
	}
	public SalesRepMobileFld salesRepMobileFld = new SalesRepMobileFld();
	
	/**
	 * Edit Sales Representative : Enter Employee ID
	 * It will appear when click on "Change" Button
	 * @author Dip
	 *
	 */
	public class SalesRepresentativeIDTxt extends Element{
		public SalesRepresentativeIDTxt(){
			setElement(readAppData(this));
		}
		
	}
	public SalesRepresentativeIDTxt salesRepresentativeIDTxt = new SalesRepresentativeIDTxt();
	
	/**
	 * To check the employee ID click on "Check" Button
	 * It will appear when click on "Change" Button
	 * @author Dip
	 *
	 */
	public class SalesRepresentativeIDCheckBtn extends Element{
		public SalesRepresentativeIDCheckBtn(){
			setElement(readAppData(this));
		}
		
	}
	public SalesRepresentativeIDCheckBtn salesRepresentativeIDCheckBtn = new SalesRepresentativeIDCheckBtn();
	
	/**
	 * To cancel the edited employee ID for Sales Representative
	 * It will appear when click on "Change" Button
	 * @author Dip
	 *
	 */
	public class CancelSalesRepresentativeEditBtn extends Element{
		public CancelSalesRepresentativeEditBtn(){
			setElement(readAppData(this));
		}
		
	}
	public CancelSalesRepresentativeEditBtn cancelSalesRepresentativeEditBtn = new CancelSalesRepresentativeEditBtn();
	
	/**
	 * To Update the edited employee ID for Sales Representative
	 * It will appear when click on "Change" Button
	 * @author Dip
	 *
	 */
	public class UpdateSalesRepresentativeEditBtn extends Element{
		public UpdateSalesRepresentativeEditBtn(){
			setElement(readAppData(this));
		}
		
	}
	public UpdateSalesRepresentativeEditBtn updateSalesRepresentativeEditBtn = new UpdateSalesRepresentativeEditBtn();
	
	
//--------End of Organization Owner Information Expander--------
	
	/**
	 * Click on Organization Global Discount Expander
	 * 1.Global Discount
	 * 2.Discount
	 * 3.Enable discount
	 * @author Dip
	 *
	 */
	public class OrgGlobalDiscountLnk extends Element{
		public OrgGlobalDiscountLnk(){
			setElement(readAppData(this));
		}
		
	}
	public OrgGlobalDiscountLnk orgGlobalDiscountLnk = new OrgGlobalDiscountLnk();
	
	/**
	 * Check for Global Discount Present
	 * @author Dip
	 *
	 */
	public class GlobalDiscountPresentFld extends Element{
		public GlobalDiscountPresentFld(){
			setElement(readAppData(this));
		}
		
	}
	public GlobalDiscountPresentFld globalDiscountPresentFld = new GlobalDiscountPresentFld();
	
	/**
	 * Check for Global Discount Not Present
	 * @author Dip
	 *
	 */
	public class GlobalDiscountNotPresentFld extends Element{
		public GlobalDiscountNotPresentFld(){
			setElement(readAppData(this));
		}
		
	}
	public GlobalDiscountNotPresentFld globalDiscountNotPresentFld = new GlobalDiscountNotPresentFld();
	
	/**
	 * Check for Discount %
	 * @author Dip
	 *
	 */
	public class OrgDiscountFld extends Element{
		public OrgDiscountFld(){
			setElement(readAppData(this));
		}
		
	}
	public OrgDiscountFld orgDiscountFld = new OrgDiscountFld();
	
	/**
	 * Check for Revoke Date
	 * It will appear when Global Discount is disabled for an Organization
	 * @author Dip
	 *
	 */
	public class RevokeOnFld extends Element{
		public RevokeOnFld(){
			setElement(readAppData(this));
		}
		
	}
	public RevokeOnFld revokeOnFld = new RevokeOnFld();
	
	/**
	 * Check for Revoke By
	 * It will appear when Global Discount is disabled for an Organization
	 * @author Dip
	 *
	 */
	public class RevokeByFld extends Element{
		public RevokeByFld(){
			setElement(readAppData(this));
		}
		
	}
	public RevokeByFld revokeByFld = new RevokeByFld();
	
	/**
	 * Click on Enable discount button
	 * It will appear when Global Discount is disabled for an Organization
	 * @author Dip
	 *
	 */
	public class EnableDiscountBtn extends Element{
		public EnableDiscountBtn(){
			setElement(readAppData(this));
		}
		
	}
	public EnableDiscountBtn enableDiscountBtn = new EnableDiscountBtn();
	
	/**
	 * Check for Enabled since Date
	 * It will appear when Global Discount is enabled for an Organization
	 * @author Dip
	 *
	 */
	public class EnabledSinceFld extends Element{
		public EnabledSinceFld(){
			setElement(readAppData(this));
		}
		
	}
	public EnabledSinceFld enabledSinceFld = new EnabledSinceFld();
	
	/**
	 * Check for Enabled by
	 * It will appear when Global Discount is enabled for an Organization
	 * @author Dip
	 *
	 */
	public class EnabledByFld extends Element{
		public EnabledByFld(){
			setElement(readAppData(this));
		}
		
	}
	public EnabledByFld enabledByFld = new EnabledByFld();
	
	/**
	 * Click on Revoke discount button
	 * It will appear when Global Discount is enabled for an Organization
	 * @author Dip
	 *
	 */
	public class RevokeDiscountBtn extends Element{
		public RevokeDiscountBtn(){
			setElement(readAppData(this));
		}
		
	}
	public RevokeDiscountBtn revokeDiscountBtn = new RevokeDiscountBtn();
	
	/**
	 * Click on Edit discount button
	 * It will appear when Global Discount is enabled for an Organization
	 * @author Dip
	 *
	 */
	public class EditDiscountBtn extends Element{
		public EditDiscountBtn(){
			setElement(readAppData(this));
		}
		
	}
	public EditDiscountBtn editDiscountBtn = new EditDiscountBtn();
	
	/**
	 * To Edit Discount %
	 * It will appear when Global Discount is enabled for an Organization
	 * Also appear when Global Discount not enabled but we can provide discount% in the text box and click on Enabled Button
	 * @author Dip
	 *
	 */
	public class EditDiscountTxt extends Element{
		public EditDiscountTxt(){
			setElement(readAppData(this));
		}
		
	}
	public EditDiscountTxt editDiscountTxt = new EditDiscountTxt();
	
	/**
	 * Click on Cancel edited discount button
	 * It will appear when Global Discount is enabled for an Organization
	 * @author Dip
	 *
	 */
	public class CancelDiscountBtn extends Element{
		public CancelDiscountBtn(){
			setElement(readAppData(this));
		}
		
	}
	public CancelDiscountBtn cancelDiscountBtn = new CancelDiscountBtn();
	
	/**
	 * Click on Update Edited discount button
	 * It will appear when Global Discount is enabled for an Organization
	 * @author Dip
	 *
	 */
	public class UpdateDiscountBtn extends Element{
		public UpdateDiscountBtn(){
			setElement(readAppData(this));
		}
		
	}
	public UpdateDiscountBtn updateDiscountBtn = new UpdateDiscountBtn();
	
	
	
//--------End of Organization Owner Information Expander--------
	
	/**
	 * Click on Custom Fields Expander
	 * 1.Custom Field1
	 * 2.Custom Field2
	 * 3.Custom Field3
	 * 4.Custom Field4
	 * 5.Custom Field5
	 * 6.Custom Field6
	 * 7.Custom Field7
	 * 8.Custom Field8
	 * 9.Custom Field9
	 * 10.Custom Field10
	 * 11.Custom Field11
	 * 12.Custom Field12
	 * @author Dip
	 *
	 */
	public class CustomFieldsLnk extends Element{
		public CustomFieldsLnk(){
			setElement(readAppData(this));
		}
		
	}
	public CustomFieldsLnk customFieldsLnk = new CustomFieldsLnk();
	
	/**
	 * Check for value of Custom Field1
	 * @author Dip
	 *
	 */
	public class CustomField1Fld extends Element{
		public CustomField1Fld(){
			setElement(readAppData(this));
		}
		
	}
	public CustomField1Fld customField1Fld = new CustomField1Fld();
	
	/**
	 * Check for value of Custom Field2
	 * @author Dip
	 *
	 */
	public class CustomField2Fld extends Element{
		public CustomField2Fld(){
			setElement(readAppData(this));
		}
		
	}
	public CustomField2Fld customField2Fld = new CustomField2Fld();
	
	/**
	 * Check for value of Custom Field3
	 * @author Dip
	 *
	 */
	public class CustomField3Fld extends Element{
		public CustomField3Fld(){
			setElement(readAppData(this));
		}
		
	}
	public CustomField3Fld customField3Fld = new CustomField3Fld();
	
	/**
	 * Check for value of Custom Field4
	 * @author Dip
	 *
	 */
	public class CustomField4Fld extends Element{
		public CustomField4Fld(){
			setElement(readAppData(this));
		}
		
	}
	public CustomField4Fld customField4Fld = new CustomField4Fld();
	
	/**
	 * Check for value of Custom Field5
	 * @author Dip
	 *
	 */
	public class CustomField5Fld extends Element{
		public CustomField5Fld(){
			setElement(readAppData(this));
		}
		
	}
	public CustomField5Fld customField5Fld = new CustomField5Fld();
	
	/**
	 * Check for value of Custom Field6
	 * @author Dip
	 *
	 */
	public class CustomField6Fld extends Element{
		public CustomField6Fld(){
			setElement(readAppData(this));
		}
		
	}
	public CustomField6Fld customField6Fld = new CustomField6Fld();
	
	/**
	 * Check for value of Custom Field7
	 * @author Dip
	 *
	 */
	public class CustomField7Fld extends Element{
		public CustomField7Fld(){
			setElement(readAppData(this));
		}
		
	}
	public CustomField7Fld customField7Fld = new CustomField7Fld();
	
	/**
	 * Check for value of Custom Field8
	 * @author Dip
	 *
	 */
	public class CustomField8Fld extends Element{
		public CustomField8Fld(){
			setElement(readAppData(this));
		}
		
	}
	public CustomField8Fld customField8Fld = new CustomField8Fld();
	
	/**
	 * Check for value of Custom Field9
	 * @author Dip
	 *
	 */
	public class CustomField9Fld extends Element{
		public CustomField9Fld(){
			setElement(readAppData(this));
		}
		
	}
	public CustomField9Fld customField9Fld = new CustomField9Fld();
	
	/**
	 * Check for value of Custom Field10
	 * @author Dip
	 *
	 */
	public class CustomField10Fld extends Element{
		public CustomField10Fld(){
			setElement(readAppData(this));
		}
		
	}
	public CustomField10Fld customField10Fld = new CustomField10Fld();
	
	/**
	 * Check for value of Custom Field11
	 * @author Dip
	 *
	 */
	public class CustomField11Fld extends Element{
		public CustomField11Fld(){
			setElement(readAppData(this));
		}
		
	}
	public CustomField11Fld customField11Fld = new CustomField11Fld();
	
	/**
	 * Check for value of Custom Field12
	 * @author Dip
	 *
	 */
	public class CustomField12Fld extends Element{
		public CustomField12Fld(){
			setElement(readAppData(this));
		}
		
	}
	public CustomField12Fld customField12Fld = new CustomField12Fld();
	
//--------End of Custom Fields Expander--------

}
