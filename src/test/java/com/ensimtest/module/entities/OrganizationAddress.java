
package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To get the Organization's official Address
 * @author Dip
 *
 */
public class OrganizationAddress extends AppData{
	/**
	 * To get the Address Line 1 of an Organization
	 * @author Dip
	 *
	 */
	public class OrgAddressLine1Fld extends Element{
		public OrgAddressLine1Fld(){
			setElement(readAppData(this));
		}
	}
	public OrgAddressLine1Fld orgAddressLine1Fld = new OrgAddressLine1Fld();
	
	/**
	 * To get the Address Line 2 of an Organization
	 * @author Dip
	 *
	 */
	public class OrgAddressLine2Fld extends Element{
		public OrgAddressLine2Fld(){
			setElement(readAppData(this));
		}
	}
	public OrgAddressLine2Fld orgAddressLine2Fld = new OrgAddressLine2Fld();
	
	/**
	 * To get the City Name of an Organization
	 * @author Dip
	 *
	 */
	public class OrgCityNameFld extends Element{
		public OrgCityNameFld(){
			setElement(readAppData(this));
		}
	}
	public OrgCityNameFld orgCityNameFld = new OrgCityNameFld();
	
	/**
	 * To get the City Code of an Organization
	 * @author Dip
	 *
	 */
	public class OrgCityCodeFld extends Element{
		public OrgCityCodeFld(){
			setElement(readAppData(this));
		}
	}
	public OrgCityCodeFld OrgCityCodeFld = new OrgCityCodeFld();
	
	/**
	 * To get the State Name of an Organization
	 * @author Dip
	 *
	 */
	public class OrgStateFld extends Element{
		public OrgStateFld(){
			setElement(readAppData(this));
		}
	}
	public OrgStateFld orgStateFld = new OrgStateFld();
	
	/**
	 * To get the Country of an Organization
	 * @author Dip
	 *
	 */
	public class OrgCountryFld extends Element{
		public OrgCountryFld(){
			setElement(readAppData(this));
		}
	}
	public OrgCountryFld orgCountryFld = new OrgCountryFld();
	
	/**
	 * To get the Zip Code of an Organization
	 * @author Dip
	 *
	 */
	public class OrgZipCodeFld extends Element{
		public OrgZipCodeFld(){
			setElement(readAppData(this));
		}
	}
	public OrgZipCodeFld orgZipCodeFld = new OrgZipCodeFld();
}

