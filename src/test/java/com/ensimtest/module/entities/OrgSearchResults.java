package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class OrgSearchResults extends AppData
{
	private class RowInfo
	{
		public String []info;
		public RowInfo()
		{
			info = readAppData(this);
		}
	}
	
	public class ResultRows extends Element
	{
		public ResultRows()
		{
			setElement(readAppData(this));
		}
		public Row[] getResultRow()
		{
			ElementSet set = new ElementSet();
			RowInfo rowInfo = new RowInfo();
			Element []elements = set.getSubElementSet(super.getElement(), rowInfo.info[0], rowInfo.info[1]);
			Row []row = new Row[elements.length];
			for(int i=0; i<elements.length; i++)
			{
				row[i] = new Row(elements[i]);
			}
			return row;
		}
	}
	public ResultRows result = new ResultRows();
	
	public class Row
	{
		public Element link;
		private String orgName, orgID;
		public Row(Element link)
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
	
	public class NextPageBtn extends Element
	{
		public NextPageBtn()
		{
			setElement(readAppData(this));
		}
	}
	public NextPageBtn nextPageBtn = new NextPageBtn();
	
	public class PreviousPageBtn extends Element
	{
		public PreviousPageBtn()
		{
			setElement(readAppData(this));
		}
	}
	public PreviousPageBtn previousPageBtn = new PreviousPageBtn();
	
}
