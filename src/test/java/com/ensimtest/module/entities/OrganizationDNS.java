package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To Add or delete Domain for an Organization
 * And Also get the registered Domain name info
 * @author Dip
 *
 */
public class OrganizationDNS extends AppData{
	/**
	 * To get the registered domain names under an organization
	 * @author Dip
	 *
	 */
	public class OrgDomainNameFld extends Element{
		public OrgDomainNameFld(){
			setElement(readAppData(this));
		}
	}
	public OrgDomainNameFld orgDomainNameFld = new OrgDomainNameFld();
	
	/**
	 * To add domain under an organization
	 * @author Dip
	 *
	 */
	public class OrgAddDomainImgBtn extends Element{
		public OrgAddDomainImgBtn(){
			setElement(readAppData(this));
		}
	}
	public OrgAddDomainImgBtn orgAddDomainImgBtn = new OrgAddDomainImgBtn();
	
	/**
	 * To delete registered domain under an organization
	 * @author Dip
	 *
	 */
	public class OrgDeleteDomainImgBtn extends Element{
		public OrgDeleteDomainImgBtn(){
			setElement(readAppData(this));
		}
	}
	public OrgDeleteDomainImgBtn orgDeleteDomainImgBtn = new OrgDeleteDomainImgBtn();
}
