package com.ensimtest.module.billing;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;
/**
 * Payment Search Screen
 * @author Karabi
 *
 */
public class PaymentSearch extends AppData{
	
	/**
	 * 
	 *Advance Search Button
	 */
	
	public class AdvanceSearchBtn extends Element{
		public AdvanceSearchBtn()
		{
			setElement(readAppData(this));
		}
	}
	public AdvanceSearchBtn advanceSearchBtn = new AdvanceSearchBtn();
	
	public class PaymentByLst extends Element{
		public PaymentByLst()
		{
			setElement(readAppData(this));
		}
	}
	public PaymentByLst paymentByLst = new PaymentByLst();
	
	public class OrganizationId extends Element{
		public OrganizationId()
		{
			setElement(readAppData(this));
		}
	}
	public OrganizationId organizationId = new OrganizationId();
	
	public class ResellerId extends Element{
		public ResellerId()
		{
			setElement(readAppData(this));
		}
	}
	public ResellerId resellerId = new ResellerId();
	
	/**
	 * Payment Date Range
	 * @author Karabi
	 *
	 */
	
	public class StartDate extends Element{
		public StartDate()
		{
			setElement(readAppData(this));
		}
	}
	public StartDate startDate = new StartDate();
	
	public class EndDate extends Element{
		public EndDate()
		{
			setElement(readAppData(this));
		}
	}
	public EndDate endDate = new EndDate();
	
	/**
	 * 
	 *Amount Paid Range
	 */
	
	public class MinimumAmt extends Element{
		public MinimumAmt()
		{
			setElement(readAppData(this));
		}
	}
	public MinimumAmt minimumAmt = new MinimumAmt();
	
	public class MaximumAmt extends Element{
		public MaximumAmt()
		{
			setElement(readAppData(this));
		}
	}
	public MaximumAmt maximumAmt = new MaximumAmt();
	
	/**
	 * Search & Reset button
	 */
	public class SearchBtn extends Element{
		public SearchBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SearchBtn searchBtn = new SearchBtn();
	
	public class ResetBtn extends Element{
		public ResetBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ResetBtn resetBtn = new ResetBtn();
}
