package com.ensimtest.module.entities;

import com.ensimtest.base.ElementType;
import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class UserSearchResults extends AppData
{
	private class CommonTable
	{
		public String info[];
		public CommonTable()
		{
			info = readAppData(this);
		}
	}
	private class ActionButtonInfo
	{
		public String info[];
		public ActionButtonInfo()
		{
			info = readAppData(this);
		}
	}
	public class UserRow
	{
		public Element link;
		public Element actionButton;
		public String loginName, name, primaryEmail, actionButtonStatus;
		
		public UserRow(Element e)
		{
			// Setting the link
			link = e;
			
			// Setting ActionButton
			ElementSet set = new ElementSet();
			ActionButtonInfo act = new ActionButtonInfo();
			Element []elements = set.getSubElementSet(e, act.info[0], act.info[1]);
			actionButton = elements[0];
			
			// Check the info
			String []info = e.read().trim().split("\n");
			loginName = info[0].trim();
			name = info[1].trim();;
			primaryEmail = info[2].trim();;
			actionButtonStatus = info[info.length-1].trim();;
		}
	}
	
	public class CommonResultRows extends Element
	{
		public CommonResultRows()
		{
			setElement(ElementType.ID, "users");
			//setElement(readAppData(this));
		}
		public Element[] getResultRow(String childType, String childValue)
		{
			ElementSet set = new ElementSet();
			Element []elements = set.getElementSet(childType, childValue);
			return elements;
		}
	}
	
	public UserRow[] getUserResultRows()
	{
		CommonTable table = new CommonTable();
		CommonResultRows resultRows = new CommonResultRows();
		Element[] elements = resultRows.getResultRow(table.info[0], table.info[1]);
		UserRow []row = new UserRow[elements.length];
		System.out.println("Length = " + row.length);
		for(int i=0; i<elements.length; i++)
		{
			row[i] = new UserRow(elements[i]);
		}
		return row;
	}
	
	public class NextPageBtn extends Element
	{
		public NextPageBtn()
		{
			setElement(readAppData(this));
		}
		@Override
		public boolean isEnabled()
		{
			try
			{
				String info = super.getAttributeValue("class");
				if(info.equals("paginationDisabledImage"))
				{
					return false;
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return true;
		}
	}
	public NextPageBtn nextPageBtn = new NextPageBtn();
	
	public class PreviousPageBtn extends Element
	{
		public PreviousPageBtn()
		{
			setElement(readAppData(this));
		}
		
		@Override
		public boolean isEnabled()
		{
			try
			{
				String info = super.getAttributeValue("class");
				if(info.equals("paginationDisabledImage"))
				{
					return false;
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return true;
		}
	}
	public PreviousPageBtn previousPageBtn = new PreviousPageBtn();
}
