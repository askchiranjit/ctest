package com.ensimtest.module.custAccount;

import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class CustUserSearchResult extends AppData
{
	private class UserTable extends Element
	{
		public String []info;
		public UserTable()
		{
			info = readAppData(this);
		}
	}
	private class SelectThisChk extends Element
	{
		public String []info;
		public SelectThisChk()
		{
			info = readAppData(this);
		}
	}
	private class ServiceAssignBtn extends Element
	{
		public String []info;
		public ServiceAssignBtn()
		{
			info = readAppData(this);
		}
	}
	private class Status extends Element
	{
		public String []info;
		public Status()
		{
			info = readAppData(this);
		}
	}
	private class UserNameLink extends Element
	{
		public String []info;
		public UserNameLink()
		{
			info = readAppData(this);
		}
	}
	
	public class CustUserRow
	{
		public Element link, serviceAssignBtn, selectThisChk, userNameLink;
		public String userName, loginID, status;
		
		public CustUserRow(Element element)
		{
			// Setting the link
			link = element;
			
			ElementSet set = new ElementSet();
			
			// Setting selecting buttons
			SelectThisChk SelectThisChk = new SelectThisChk();
			selectThisChk = set.getSubElementSet(element, SelectThisChk.info[0], SelectThisChk.info[1])[0];
			
			// Setting the service assign button
			ServiceAssignBtn ServiceAssignBtn = new ServiceAssignBtn();
			serviceAssignBtn = set.getSubElementSet(element, ServiceAssignBtn.info[0], ServiceAssignBtn.info[1])[0];
			
			// Setting status
			Status Status = new Status();
			status = set.getSubElementSet(element, Status.info[0], Status.info[1])[0].getAttributeValue("title");

			// Setting userNameLink
			UserNameLink UserNameLink = new UserNameLink();
			userNameLink = set.getSubElementSet(element, UserNameLink.info[0], UserNameLink.info[1])[0];
			
			String data = element.read().trim();
			String []details = data.split(" ");
			
			// Setting loginId
			loginID = details[details.length-1];
			
			// Setting userName
			userName = data.replace(loginID, "");
		}
	}
	
	public CustUserRow[] getCustomerUserRows()
	{
		UserTable userTable = new UserTable();
		ElementSet set = new ElementSet();
		Element []rows = set.getElementSet(userTable.info[0], userTable.info[1]);
		CustUserRow []crows = new CustUserRow[rows.length];
		for(int i=0; i<crows.length; i++)
		{
			crows[i] = new CustUserRow(rows[i]);
		}
		return crows;
	}
}
