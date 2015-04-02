package com.ensimtest.module.userspace;

import com.ensimtest.base.ElementType;
import com.ensimtest.config.Element;

public class LoggedInUser
{
	public class UserInfo extends Element
	{
		public UserInfo()
		{
			super("menu", ElementType.ID);
			
		}
	}
	public UserInfo userInfo = new UserInfo();
	
	
}
