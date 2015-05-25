package com.ensimtest.module.entities;

import java.util.ArrayList;
import java.util.List;

import com.ensimtest.module.entities.UserSearchResults.UserRow;
import com.ensimtest.utils.TestUtils;

public class SearchResultList
{
	public List<UserRow> getUserSearchList()
	{
		List<UserRow> list = new ArrayList<>();
		UserSearchResults results = new UserSearchResults();

		while(true)
		{
			results = new UserSearchResults();
			UserRow []rows = results.getUserResultRows();
			System.out.println("Rows " + rows);
			for(int i= 0; i<rows.length; i++)
			{
				list.add(rows[i]);
			}

			if(results.nextPageBtn.isEnabled()==true)
				{
					results.nextPageBtn.click();
					TestUtils.delay(2000);
				}
			else
				{
					if(results.nextPageBtn.isEnabled()==false)
						break;
				}
		}
		return list;
	}
}
