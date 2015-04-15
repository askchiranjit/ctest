package com.ensimtest.module.authentication;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;


public class LoginScreen extends AppData
{
		public class Username extends Element
		{
			public Username()
			{
				setElement(readAppData(this));
			}
			
			public boolean IsErrorDisplayed()
			{
				return isError();
			}
		}
		public Username username = new Username();
		
		public class Password extends Element
		{
			public Password()
			{
				setElement(readAppData(this));
			}
			public boolean IsErrorDisplayed()
			{
				return isError();
			}
		}
		public Password password = new Password();
		
		public class LoginBtn extends Element
		{
			public LoginBtn()
			{
				setElement(readAppData(this));
			}
		}
		public LoginBtn loginBtn = new LoginBtn();
		
		public class ErrorMsg extends Element
		{
			public ErrorMsg()
			{
				setElement(readAppData(this));
			}
		}
		public ErrorMsg errorMsg = new ErrorMsg();
		
		public class RememberMeBtn extends Element
		{
			public RememberMeBtn()
			{
				setElement(readAppData(this));
			}
		}
		public RememberMeBtn rememberMeBtn = new RememberMeBtn();
		
		public class ForgotPassword extends Element
		{
			public ForgotPassword()
			{
				setElement(readAppData(this));
			}
		}
		public ForgotPassword forgotPassword = new ForgotPassword();
		
		public class SignUpBtn extends Element
		{
			public SignUpBtn()
			{
				setElement(readAppData(this));
			}
		}
		public SignUpBtn signUpBtn = new SignUpBtn();
	}
