package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To search and select a reseller under which want to move
 * an Organization
 * @author Dip
 *
 */
public class ResellerListHandler extends AppData{
	
	/**
	 * To provide Reseller ID to search a reseller
	 * @author Dip
	 *
	 */
	public class ResellerIDInputTxt extends Element{
		public ResellerIDInputTxt(){
			setElement(readAppData(this));
		}
	}
	public ResellerIDInputTxt resellerIDInputTxt = new ResellerIDInputTxt();
	
	/**
	 * To provide Reseller Name to search a reseller
	 * @author Dip
	 *
	 */
	public class ResellerNameInputTxt extends Element{
		public ResellerNameInputTxt(){
			setElement(readAppData(this));
		}
	}
	public ResellerNameInputTxt resellerNameInputTxt = new ResellerNameInputTxt();
	
	/**
	 * To Click on Search button to search a particular Reseller by ID or Name
	 * @author Dip
	 *
	 */
	public class ResellerSearchBtn extends Element{
		public ResellerSearchBtn(){
			setElement(readAppData(this));
		}
	}
	public ResellerSearchBtn resellerSearchBtn = new ResellerSearchBtn();
	
	/**
	 * To Click on Select button to confirm a particular Reseller selection
	 * @author Dip
	 *
	 */
	public class SelectResellerFromListBtn extends Element{
		public SelectResellerFromListBtn(){
			setElement(readAppData(this));
		}
	}
	public SelectResellerFromListBtn selectResellerFromListBtn = new SelectResellerFromListBtn();

}
