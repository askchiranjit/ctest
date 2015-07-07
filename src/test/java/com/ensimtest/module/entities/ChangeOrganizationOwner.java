package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To change the ownership of a Organization from Service Provider to Reseller
 * @author Dip
 *
 */


public class ChangeOrganizationOwner extends AppData{
	/**
	 * To get the Organization name and ID for which ownership going to be chnage
	 * @author Dip
	 *
	 */
	public class ChangeOwnershipForOrgFld extends Element{
		public ChangeOwnershipForOrgFld(){
			setElement(readAppData(this));
		}
	}
	public ChangeOwnershipForOrgFld changeOwnershipForOrgFld = new ChangeOwnershipForOrgFld();
	
	/**
	 * To get the value of Organization Currently Owned By whom
	 * @author Dip
	 *
	 */
	public class CurrentlyOwnedByFld extends Element{
		public CurrentlyOwnedByFld(){
			setElement(readAppData(this));
		}
	}
	public CurrentlyOwnedByFld currentlyOwnedByFld = new CurrentlyOwnedByFld();
	
	/**
	 * To click on Select Reseller link to select reseller, from a list of reseller, under which want to move the Organization
	 * @author Dip
	 *
	 */
	public class SelectResellerLnk extends Element{
		public SelectResellerLnk(){
			setElement(readAppData(this));
		}
	}
	public SelectResellerLnk selectResellerLnk = new SelectResellerLnk();
	
	/**
	 * To click on Cancel Button to get back from Change Ownership wizard
	 * @author Dip
	 *
	 */
	public class CancelResellerSelectionBtn extends Element{
		public CancelResellerSelectionBtn(){
			setElement(readAppData(this));
		}
	}
	public CancelResellerSelectionBtn cancelResellerSelectionBtn = new CancelResellerSelectionBtn();
	
	/**
	 * To click on Confirm button to change the ownership of a organization
	 * @author Dip
	 *
	 */
	public class ConfirmChangeOwnershipBtn extends Element{
		public ConfirmChangeOwnershipBtn(){
			setElement(readAppData(this));
		}
	}
	public ConfirmChangeOwnershipBtn confirmChangeOwnershipBtn = new ConfirmChangeOwnershipBtn();
	
	/**
	 * To provide the sales representative ID or Email to check whether internal or external and associate
	 * with that Organization
	 * @author Dip
	 *
	 */
	public class SalesRepInputTxt extends Element{
		public SalesRepInputTxt(){
			setElement(readAppData(this));
		}
	}
	public SalesRepInputTxt salesRepInputTxt = new SalesRepInputTxt();
	
	/**
	 * To click on Check button to check the Sales Representative is external or internal
	 * @author Dip
	 *
	 */
	public class SalesRepCheckBtn extends Element{
		public SalesRepCheckBtn(){
			setElement(readAppData(this));
		}
	}
	public SalesRepCheckBtn salesRepCheckBtn = new SalesRepCheckBtn();
	
	/**
	 * To get the Sales Representative's Name
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
	 * To get the Sales Representative's Email
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
	 * To get the Sales Representative's Mobile
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
	 * To select a reseller Payment Agreement
	 * @author Dip
	 *
	 */
	public class PaymentAgreementOfResellerLst extends Element{
		public PaymentAgreementOfResellerLst(){
			setElement(readAppData(this));
		}
		public void selectPaymentAgreement(String data){
			super.selectVisibleText(data);
		}
	}
	public PaymentAgreementOfResellerLst paymentAgreementOfResellerLst = new PaymentAgreementOfResellerLst();
	
//----------------WPAAS section-------------------------------------------------------	
	/**
	 * To select a Enterprise Reseller's User name Suffix
	 * @author Dip
	 *
	 */
	public class UsernameSuffixOfEnterpriseResellerLst extends Element{
		public UsernameSuffixOfEnterpriseResellerLst(){
			setElement(readAppData(this));
		}
		public void selectUsernameSuffix(String data){
			super.selectVisibleText(data);
		}
	}
	public UsernameSuffixOfEnterpriseResellerLst usernameSuffixOfEnterpriseResellerLst = new UsernameSuffixOfEnterpriseResellerLst();
	
	/**
	 * To click on check box to make an organization billable
	 * To uncheck the check box to make an organization dummy
	 * @author Dip
	 *
	 */
	public class IsBillableChk extends Element{
		public IsBillableChk(){
			setElement(readAppData(this));
		}
	}
	public IsBillableChk isBillableChk = new IsBillableChk();
	
	/**
	 * To provide Organization Attribute value with which that 
	 * Organization's user going to be identified in AD
	 * @author Dip
	 *
	 */
	public class OrganizationAttributeForADTxt extends Element{
		public OrganizationAttributeForADTxt(){
			setElement(readAppData(this));
		}
	}
	public OrganizationAttributeForADTxt organizationAttributeForADTxt = new OrganizationAttributeForADTxt();

}
