package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To search all user under a Service Provider
 * @author Dip
 *
 */
public class SearchUser extends AppData {

	/**
	 * To search User by their LogIn Name
	 */
	public class LogInNameTxt extends Element{
		public LogInNameTxt(){
			setElement(readAppData(this));
		}
	}
	public LogInNameTxt logInNameTxt = new LogInNameTxt();
	
	/**
	 * To search User by their First Name
	 */
	public class FirstNameTxt extends Element{
		public FirstNameTxt(){
			setElement(readAppData(this));
		}
	}
	public FirstNameTxt firstNameTxt = new FirstNameTxt();
	
	/**
	 * To search User by their Last Name
	 */
	public class LastNameTxt extends Element{
		public LastNameTxt(){
			setElement(readAppData(this));
		}
	}
	public LastNameTxt lastNameTxt = new LastNameTxt();
	
	/**
	 * To search User by their Email Address
	 */
	public class EmailAddressTxt extends Element{
		public EmailAddressTxt(){
			setElement(readAppData(this));
		}
	}
	public EmailAddressTxt emailAddressTxt = new EmailAddressTxt();
	
	/**
	 * To search User by their Phone Number
	 */
	public class PhoneNumberTxt extends Element{
		public PhoneNumberTxt(){
			setElement(readAppData(this));
		}
	}
	public PhoneNumberTxt phoneNumberTxt = new PhoneNumberTxt();
	
	/**
	 * Click on Search Button
	 */
	public class SearchBtn extends Element{
		public SearchBtn(){
			setElement(readAppData(this));
		}
	}
	public SearchBtn searchBtn = new SearchBtn();
	
	/**
	 * Click on Reset Button
	 */
	public class ResetBtn extends Element{
		public ResetBtn(){
			setElement(readAppData(this));
		}
	}
	public ResetBtn resetBtn = new ResetBtn();
	
	/**
	 * Click on Import User Button
	 */
	public class ImportUserBtn extends Element{
		public ImportUserBtn(){
			setElement(readAppData(this));
		}
	}
	public ImportUserBtn importUserBtn = new ImportUserBtn();
}