package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class SearchResults extends AppData
{
	private class RowInfo
	{
		public String []info;
		public RowInfo()
		{
			info = readAppData(this);
		}
	}
	
	public class CommonResultRows extends Element
	{
		public CommonResultRows()
		{
			setElement(readAppData(this));
		}
		public Element[] getResultRow(String childType, String childValue)
		{
			ElementSet set = new ElementSet();
			Element []elements = set.getSubElementSet(super.getElement(), childType, childValue);
			return elements;
		}
	}
	
	public class OrgRow
	{
		public Element link;
		private String orgName, orgID;
		public OrgRow(Element link)
		{
			this.link = link;
			String data = link.read().trim();
			String info[] = data.split("\n");
			orgName = info[0].trim();
			if(info[2].trim().contains(","))
			{
				orgID = info[2].trim().split(",")[0].trim();
			}
			else
			{
				orgID = info[2].trim();
			}
			orgID = orgID.split(":")[1].trim();
		}
		public String getOrgName()
		{
			return orgName;
		}
		public String getOrgID()
		{
			return orgID;
		}
	}
	
	public OrgRow[] getOrgResultRows()
	{
		CommonResultRows resultRows = new CommonResultRows();
		RowInfo rowInfo = new RowInfo();
		Element[] elements = resultRows.getResultRow(rowInfo.info[0], rowInfo.info[1]);
		OrgRow []row = new OrgRow[elements.length];
		for(int i=0; i<elements.length; i++)
		{
			row[i] = new OrgRow(elements[i]);
		}
		return row;
	}
	
	public class OrgAgent
	{
		public Element link;
		private String agentName, agentID;
		public OrgAgent(Element link)
		{
			this.link = link;
			String data = link.read().trim();
			String info[] = data.split("\n");
			agentName = info[0].trim();
			if(info[1].trim().contains(","))
			{
				agentID = info[1].trim().split(",")[0].trim();
			}
			else
			{
				agentID = info[1].trim();
			}
			agentID = agentID.split(":")[1].trim();
		}
		public String getOrgName()
		{
			return agentName;
		}
		public String getOrgID()
		{
			return agentID;
		}
	}
	
	public OrgAgent[] getAgentResultRows()
	{
		CommonResultRows resultRows = new CommonResultRows();
		RowInfo rowInfo = new RowInfo();
		Element[] elements = resultRows.getResultRow(rowInfo.info[0], rowInfo.info[1]);
		OrgAgent []row = new OrgAgent[elements.length];
		for(int i=0; i<elements.length; i++)
		{
			row[i] = new OrgAgent(elements[i]);
		}
		return row;
	}
	
	public class OrgReseller
	{
		public Element link;
		private String resellerName, resellerID;
		public OrgReseller(Element link)
		{
			this.link = link;
			String data = link.read().trim();
			String info[] = data.split("\n");
			resellerName = info[0].trim();
			if(info[1].trim().contains(","))
			{
				resellerID = info[1].trim().split(",")[0].trim();
			}
			else
			{
				resellerID = info[1].trim();
			}
			resellerID = resellerID.split(":")[1].trim();
		}
		public String getResellerName()
		{
			return resellerName;
		}
		public String getResellerID()
		{
			return resellerID;
		}
	}
	
	public OrgReseller[] getResellerResultRows()
	{
		CommonResultRows resultRows = new CommonResultRows();
		RowInfo rowInfo = new RowInfo();
		Element[] elements = resultRows.getResultRow(rowInfo.info[0], rowInfo.info[1]);
		OrgReseller []row = new OrgReseller[elements.length];
		for(int i=0; i<elements.length; i++)
		{
			row[i] = new OrgReseller(elements[i]);
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
