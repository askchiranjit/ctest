package com.ensimtest.module.authentication;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;
import com.ensimtest.base.ElementType;

public class LoginScreen extends AppData
{
		public class Username extends Element
		{
			public Username()
			{
				readAppData(this);
				setElement("username", ElementType.ID);
			}
			
			public boolean IsErrorDisplayed()
			{
				return IsError();
			}
		}
		public Username username = new Username();
		
		public class Password extends Element
		{
			public Password()
			{
				setElement("password", ElementType.ID);
			}
			public boolean IsErrorDisplayed()
			{
				return IsError();
			}
		}
		public Password password = new Password();
		
		public class LoginBtn extends Element
		{
			public LoginBtn()
			{
				setElement("//*[@id=\"loginform\"]/li[6]/ul/li[2]/input", ElementType.Xpath);
			}
		}
		public LoginBtn loginBtn = new LoginBtn();
		
		public class RememberMeBtn extends Element
		{
			public RememberMeBtn()
			{
				setElement("rememberMe", ElementType.ID);
			}
		}
		public RememberMeBtn rememberMeBtn = new RememberMeBtn();
		
		public class ForgotPassword extends Element
		{
			public ForgotPassword()
			{
				setElement("forgot_password", ElementType.ID);
			}
		}
		public ForgotPassword forgotPassword = new ForgotPassword();
		
		public class SignUpBtn extends Element
		{
			public SignUpBtn()
			{
				setElement("//*[@id=\"EAS_login_content\"]/div/div[2]/div[1]/ul/li[2]", ElementType.Xpath);
			}
		}
		public SignUpBtn signUpBtn = new SignUpBtn();
	}
