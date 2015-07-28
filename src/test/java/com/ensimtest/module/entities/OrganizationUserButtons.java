package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class OrganizationUserButtons extends AppData
{

	public class PermissionBtn extends Element
	{
		public PermissionBtn()
		{
			setElement(readAppData(this));
		}
	}
	public PermissionBtn permissionBtn = new PermissionBtn();

	public class EditBtn extends Element
	{
		public EditBtn()
		{
			setElement(readAppData(this));
		}
	}
	public EditBtn editBtn = new EditBtn();

	public class ActivationEmailBtn extends Element
	{
		public ActivationEmailBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ActivationEmailBtn activationEmailBtn = new ActivationEmailBtn();

	public class DeactiveUserBtn extends Element
	{
		public DeactiveUserBtn()
		{
			setElement(readAppData(this));
		}
	}
	public DeactiveUserBtn deactiveUserBtn = new DeactiveUserBtn();

	public class ResetPasswordBtn extends Element
	{
		public ResetPasswordBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ResetPasswordBtn resetPasswordBtn = new ResetPasswordBtn();

	public class RegenaratePasswordBtn extends Element
	{
		public RegenaratePasswordBtn()
		{
			setElement(readAppData(this));
		}
	}
	public RegenaratePasswordBtn regenaratePasswordBtn = new RegenaratePasswordBtn();

	
}
