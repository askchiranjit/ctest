package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

/**
 * To list out all the categories
 * @author Dip
 *
 */

public class SearchCategory extends AppData
{
	/*
	 * To separate out rows of category
	 */
	private class RowInfo
	{
		public String []info;
		public RowInfo()
		{
			info = readAppData(this);
		}
	}
	
	/*
	 * To find out components of rows (using key,value pair)
	 */
	private class Components
	{
		public String []info;
		public Components()
		{
			info = readAppData(this);
		}
	}
	
	/*
	 * To get the full table of category
	 */
	public class CategoryResultRows extends Element
	{
		public CategoryResultRows()
		{
			setElement(readAppData(this));	
		}
		
		/*
		 * Return number of row present in a page and corresponding elements under a row
		 */
		public CategoryRow[] getCategoryList()
		{
			ElementSet elementSet=new ElementSet();
			RowInfo rowInfo=new RowInfo();
			Element elements[]=elementSet.getSubElementSet(super.getElement(), rowInfo.info[0],  rowInfo.info[1]);
			CategoryRow []rows = new CategoryRow[elements.length];
			for(int i=0;i<elements.length;i++)
			{
				rows[i] = new CategoryRow(elements[i]);
			}
			return rows;
		}
		
	}
	
	public CategoryResultRows categoryResultRows=new CategoryResultRows();
	
	/*
	 * To build individual element present in a category row
	 */
	public class CategoryRow 
	{
		
		public Element categoryNameLnk,editLink,deleteLink;
		public String categoryName;
		
		CategoryRow(Element element)
		{
			Components component=new Components();
			ElementSet es=new ElementSet();
			Element e[]=es.getSubElementSet(element, component.info[0], component.info[1]);
			categoryNameLnk=e[0];
			editLink=e[1];
			deleteLink=e[2];
			categoryName=e[0].read().split("\n")[0].trim();
		}
		
	}

}
