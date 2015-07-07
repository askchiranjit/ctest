package com.ensimtest.module.userspace;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class LoggedInUser extends AppData
{
	public class UserInfo extends Element
	{
		public UserInfo()
		{
			setElement(readAppData(this));
		}
		public void mouseHover()
		{
			super.mouseHover();
		}
	}
	public UserInfo userInfo = new UserInfo();
	
	public class LogOut extends Element
	{
		public LogOut()
		{
			setElement(readAppData(this));
		}
	}
	public LogOut logOut = new LogOut();
}
