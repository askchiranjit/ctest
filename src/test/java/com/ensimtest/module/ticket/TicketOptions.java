package com.ensimtest.module.ticket;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class TicketOptions extends AppData{
	
	
	public class TicketLink extends Element{
		public TicketLink()
		{
			setElement(readAppData(this));
		}
	}
	public TicketLink ticketLink = new TicketLink();

}
