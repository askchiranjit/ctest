
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
	 * Click To add domain under an organization
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
	 * To enter a Domain Name
	 * @author Dip
	 */
	public class OrgDomainNameTxt extends Element{
		public OrgDomainNameTxt(){
			setElement(readAppData(this));
		}
	}
	public OrgDomainNameTxt orgDomainNameTxt = new OrgDomainNameTxt();
	
	/**
	 * click on Add Domain Name(s) Button
	 * @author Dip
	 *
	 */
	public class OrgAddDomainNameBtn extends Element{
		public OrgAddDomainNameBtn(){
			setElement(readAppData(this));
		}
	}
	public OrgAddDomainNameBtn orgAddDomainNameBtn = new OrgAddDomainNameBtn();
	
	/**
	 * Click To cancel and exit from add domain section
	 * @author Dip
	 *
	 */
	public class OrgCancelDomainImgBtn extends Element{
		public OrgCancelDomainImgBtn(){
			setElement(readAppData(this));
		}
	}
	public OrgCancelDomainImgBtn orgCancelDomainImgBtn = new OrgCancelDomainImgBtn();
	
	/**
	 * To delete registered domain under an organization
	 * @author Dip
	 *
	 */
	public class OrgDeleteDomainImgBtn extends Element{
		public OrgDeleteDomainImgBtn(){
			setElement(readAppData(this));
		}
		
		//TODO: need to handle alert
	}
	public OrgDeleteDomainImgBtn orgDeleteDomainImgBtn = new OrgDeleteDomainImgBtn();
}

