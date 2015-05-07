
package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To get the AD OU creation info and also edit those info
 * @author Dip
 *
 */
public class OrganizationADOU extends AppData{
	/**
	 * To get the AD OU Creation Info : User Name Suffix
	 * @author Dip
	 *
	 */
	public class OrgADOUUserNameSuffixFld extends Element{
		public OrgADOUUserNameSuffixFld(){
			setElement(readAppData(this));
		}
	}
	public OrgADOUUserNameSuffixFld orgADOUUserNameSuffixFld = new OrgADOUUserNameSuffixFld();
	
	/**
	 * To get the AD OU Creation Info : Contact Email ID
	 * @author Dip
	 *
	 */
	public class OrgADOUContactEmailIDFld extends Element{
		public OrgADOUContactEmailIDFld(){
			setElement(readAppData(this));
		}
	}
	public OrgADOUContactEmailIDFld orgADOUContactEmailIDFld = new OrgADOUContactEmailIDFld();
	
	/**
	 * To get the AD OU creation Info: AD OU Role
	 * @author Dip
	 */
	public class OrgADOURoleFld extends Element{
		public OrgADOURoleFld(){
			setElement(readAppData(this));
		}
	}
	public OrgADOURoleFld orgADOURoleFld = new OrgADOURoleFld();
	
	/**
	 * To get the AD OU creation Info: AD OU Creation Status
	 * @author Dip
	 */
	public class OrgADOUCreationStatusFld extends Element{
		public OrgADOUCreationStatusFld(){
			setElement(readAppData(this));
		}
	}
	public OrgADOUCreationStatusFld orgADOUCreationStatusFld = new OrgADOUCreationStatusFld();
	
	/**
	 * To edit AD OU Creation Info : User Name Suffix and Contact Email ID
	 * @author Dip
	 *
	 */
	public class OrgADOUEditBtn extends Element{
		public OrgADOUEditBtn(){
			setElement(readAppData(this));
		}
	}
	public OrgADOUEditBtn orgADOUEditBtn = new OrgADOUEditBtn();
	
	
//--------Edit AD OU Information section--------
	/**
	 * To edit User Name Suffix
	 * @author Dip
	 */
	public class OrgADOUUserNameSuffixEditTxt extends Element{
		public OrgADOUUserNameSuffixEditTxt(){
			setElement(readAppData(this));
		}
	}
	public OrgADOUUserNameSuffixEditTxt orgADOUUserNameSuffixEditTxt = new OrgADOUUserNameSuffixEditTxt();
	
	/**
	 * To edit Contact Email ID
	 * @author Dip
	 */
	public class OrgADOUContactEmailIDEditTxt extends Element{
		public OrgADOUContactEmailIDEditTxt(){
			setElement(readAppData(this));
		}
	}
	public OrgADOUContactEmailIDEditTxt orgADOUContactEmailIDEditTxt = new OrgADOUContactEmailIDEditTxt();
	
	/**
	 * To click on Cancel Button
	 * @author Dip
	 */
	public class OrgADOUCancelBtn extends Element{
		public OrgADOUCancelBtn(){
			setElement(readAppData(this));
		}
	}
	public OrgADOUCancelBtn orgADOUCancelBtn = new OrgADOUCancelBtn();
	
	/**
	 * To click on Update Button
	 * @author Dip
	 */
	public class OrgADOUUpdateBtn extends Element{
		public OrgADOUUpdateBtn(){
			setElement(readAppData(this));
		}
	}
	public OrgADOUUpdateBtn orgADOUUpdateBtn = new OrgADOUUpdateBtn();
}

