package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class AddAgentWizardDetails extends AppData 
{
	public class AgentNameTxt extends Element
	{
		public AgentNameTxt()
		{
			setElement(readAppData(this));
		}
	}
	public AgentNameTxt AgentNameTxt = new AgentNameTxt();

	public class VATNumberTxt extends Element
	{
		public VATNumberTxt()
		{
			setElement(readAppData(this));
		}
	}
	public VATNumberTxt VATNumberText = new VATNumberTxt();

	public class UsernameSuffixTxt extends Element
	{
		public UsernameSuffixTxt()
		{
			setElement(readAppData(this));
		}
	}
	public UsernameSuffixTxt UsernameSuffixTxt = new UsernameSuffixTxt();

	public class ConfUsernameSuffixTxt extends Element
	{
		public ConfUsernameSuffixTxt()
		{
			setElement(readAppData(this));
		}
	}
	public ConfUsernameSuffixTxt ConfUsernameSuffixTxt = new ConfUsernameSuffixTxt();

}
