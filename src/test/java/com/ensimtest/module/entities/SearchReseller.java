package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;


/**
 * This is for Reseller Search
 * @author Dip
 *
 */
public class SearchReseller extends AppData {
	
	/**
	 * To select the Reseller type
	 *
	 */
	public class ResellerTypeLst extends Element{
		public ResellerTypeLst(){
			setElement(readAppData(this));
		}
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	public ResellerTypeLst resellerTypeLst = new ResellerTypeLst();
	
	/**
	 * To search Reseller by Reseller Name, VAT Number, Reseller ID
	 */
	public class SearchByLst extends Element{
		public SearchByLst(){
			setElement(readAppData(this));
		}
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	public SearchByLst searchByLst = new SearchByLst();
	
	/**
	 * To search a Reseller by entering a keyword
	 */
	public class KeywordTxt extends Element{
		public KeywordTxt(){
			setElement(readAppData(this));
		}
	}
	public KeywordTxt keywordTxt = new KeywordTxt();
	
	/**
	 * To search deactivated Reseller
	 */
	public class DeactivatedChk extends Element{
		public DeactivatedChk(){
			setElement(readAppData(this));
		}
	}
	public DeactivatedChk deactivatedChk = new DeactivatedChk();
	
	/**
	 * Click on Search button
	 */
	public class SearchBtn extends Element{
		public SearchBtn(){
			setElement(readAppData(this));
		}
	}
	public SearchBtn searchBtn = new SearchBtn();

}
