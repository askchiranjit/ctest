package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To change the Organization's Status:
 * 1.Verified
 * 2.Self Registered
 * 3.Black Listed
 * 4.Closed
 * @author Dip
 *
 */

public class ChangeOrganizationStatus extends AppData{
	/**
	 * To change status to or verify status as Verified
	 */
	public class VerifiedOrgStatusRdo extends Element{
		public VerifiedOrgStatusRdo(){
			setElement(readAppData(this));
		}
	}
	public VerifiedOrgStatusRdo verifiedOrgStatusRdo = new VerifiedOrgStatusRdo();
	
	/**
	 * To change status to or verify status as Self Registered
	 */
	public class SelfRegisteredOrgStatusRdo extends Element{
		public SelfRegisteredOrgStatusRdo(){
			setElement(readAppData(this));
		}
	}
	public SelfRegisteredOrgStatusRdo selfRegisteredOrgStatusRdo = new SelfRegisteredOrgStatusRdo();
	
	/**
	 * To change status to or verify status as Black Listed
	 */
	public class BlackListedOrgStatusRdo extends Element{
		public BlackListedOrgStatusRdo(){
			setElement(readAppData(this));
		}
	}
	public BlackListedOrgStatusRdo blackListedOrgStatusRdo = new BlackListedOrgStatusRdo();
	
	/**
	 * To change status to or verify status as Closed
	 */
	public class ClosedOrgStatusRdo extends Element{
		public ClosedOrgStatusRdo(){
			setElement(readAppData(this));
		}
	}
	public ClosedOrgStatusRdo closedOrgStatusRdo = new ClosedOrgStatusRdo();
	
	/**
	 * To click on Save button
	 */
	public class SaveOrgStatusBtn extends Element{
		public SaveOrgStatusBtn(){
			setElement(readAppData(this));
		}
	}
	public SaveOrgStatusBtn saveOrgStatusBtn = new SaveOrgStatusBtn();
	
	/**
	 * To click on Cancel button
	 */
	public class CancelOrgStatusRdo extends Element{
		public CancelOrgStatusRdo(){
			setElement(readAppData(this));
		}
	}
	public CancelOrgStatusRdo cancelOrgStatusRdo = new CancelOrgStatusRdo();
}
