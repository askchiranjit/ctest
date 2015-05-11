package com.ensimtest.module.billing;

import com.ensimtest.config.Element;
import com.ensimtest.module.billing.PaymentSearchResult.CancelBtn;
import com.ensimtest.resource.AppData;

/**
 * Payment Advance search
 * @author Karabi
 *
 */
public class PaymentAdvSearch extends AppData{
	public class PaymentByLst extends Element{
		public PaymentByLst()
		{
			setElement(readAppData(this));
		}
	}
	public PaymentByLst paymentByLst = new PaymentByLst();
	
	public class OrganizationIdTxt extends Element{
		public OrganizationIdTxt()
		{
			setElement(readAppData(this));
		}
	}
	public OrganizationIdTxt organizationIdTxt = new OrganizationIdTxt();
	
	public class AccountIdTxt extends Element{
		public AccountIdTxt()
		{
			setElement(readAppData(this));
		}
	}
	public AccountIdTxt accountIdTxt = new AccountIdTxt();
	/**
	 * Payment Date Range
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
	 * Amount paid range
	 */
	public class MinimumAmtTxt extends Element{
		public MinimumAmtTxt()
		{
			setElement(readAppData(this));
		}
	}
	public MinimumAmtTxt minimumAmtTxt = new MinimumAmtTxt();
			
	public class MaximumAmtTxt extends Element{
		public MaximumAmtTxt()
		{
			setElement(readAppData(this));
		}
	}
	public MaximumAmtTxt maximumAmtTxt = new MaximumAmtTxt();
	
	public class AdjustmentNumTxt extends Element{
		public AdjustmentNumTxt()
		{
			setElement(readAppData(this));
		}
	}
	public AdjustmentNumTxt adjustmentNumTxt = new AdjustmentNumTxt();
	
	public class UserLoginNameTxt extends Element{
		public UserLoginNameTxt()
		{
			setElement(readAppData(this));
		}
	}
	public UserLoginNameTxt userLoginNameTxt = new UserLoginNameTxt();
	
	public class CancelBtn extends Element{
		public CancelBtn()
		{
			setElement(readAppData(this));
		}
	}
	public CancelBtn cancelBtn = new CancelBtn();
	
	public class ResetBtn extends Element{
		public ResetBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ResetBtn resetBtn = new ResetBtn();
	
	public class SearchBtn extends Element{
		public SearchBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SearchBtn searchBtn = new SearchBtn();

}
