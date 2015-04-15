package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class AgentHomePage extends AppData
{
	public class AddAgentBtn extends Element
	{
		public AddAgentBtn()
		{
			setElement(readAppData(this));
		}
	}
   public AddAgentBtn addAgentBtn=new AddAgentBtn();
}
