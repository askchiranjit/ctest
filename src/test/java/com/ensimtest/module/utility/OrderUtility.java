package com.ensimtest.module.utility;

import com.ensimtest.module.orders.OrderDetails;
import com.ensimtest.module.orders.OrderList.OrderRow;

public class OrderUtility
{
	public boolean waitForStatusUpdate(OrderRow row, String expectecStatus, int maxSecondToWait) throws InterruptedException
	{
		int timeSlice = 10 * 1000; // 10 seconds
		int totalTimeSpent = 0;
		while(totalTimeSpent < (maxSecondToWait * 1000))
		{
			// Click the row
			row.link.click();
			
			// Wait for time
			Thread.sleep(timeSlice);
			
			// Verify the status
			OrderDetails details = new OrderDetails();
			String status = details.orderInfo.status.trim().toLowerCase();
			if(status.equals(expectecStatus.trim().toLowerCase()))
			{
				return true;
			}
			
			// Increase the time-spent
			totalTimeSpent += timeSlice;
		}
		
		// Wait is over
		return false;
	}
}
