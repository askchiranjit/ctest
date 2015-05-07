package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * This is to search My Organization
 * @author Dip
 *
 */
public class SearchMyOrganization extends AppData{

	/**
	 * To Search ISP User by Login Name, Primary Email, First Name, Last Name
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
	 * To search ISP User by entering a keyword
	 */
	public class KeywordTxt extends Element{
		public KeywordTxt(){
			setElement(readAppData(this));
		}
	}
	public KeywordTxt keywordTxt = new KeywordTxt();
	
	/**
	 * To search deactivated ISP User
	 */
	public class DeactivatedChk extends Element{
		public DeactivatedChk(){
			setElement(readAppData(this));
		}
		public void Check()
		{
			super.check();
		}
		public void UnCheck()
		{
			super.unCheck();
		}
		
	}
	public DeactivatedChk deactivatedChk = new DeactivatedChk();
	
	/**
	 * Click on Search Button
	 */
	public class SearchBtn extends Element{
		public SearchBtn(){
			setElement(readAppData(this));
		}
	}
	public SearchBtn SearchBtn = new SearchBtn();
}
