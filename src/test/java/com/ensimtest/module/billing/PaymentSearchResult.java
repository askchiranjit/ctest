package com.ensimtest.module.billing;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;
/**
 * Payment Search List
 * @author Karabi
 *
 */

public class PaymentSearchResult extends AppData{
	
	/*public class OrganizationId extends Element{
		public OrganizationId()
		{
			setElement(readAppData(this));
		}
	}
	public OrganizationId organizationId = new OrganizationId();
	
	public class AccountId extends Element{
		public AccountId()
		{
			setElement(readAppData(this));
		}
	}
	public AccountId accountId = new AccountId();
	
	public class Amount extends Element{
		public Amount()
		{
			setElement(readAppData(this));
		}
	}
	public Amount amount = new Amount();
	
	public class Date extends Element{
		public Date()
		{
			setElement(readAppData(this));
		}
	}
	public Date date = new Date();
	
	public class PaymentMode extends Element{
		public PaymentMode()
		{
			setElement(readAppData(this));
		}
	}
	public PaymentMode paymentMode = new PaymentMode();
	*/
	public class CancelBtn extends Element{
		public CancelBtn()
		{
			setElement(readAppData(this));
		}
	}
	public CancelBtn cancelBtn = new CancelBtn();

	public class ProceedBtn extends Element{
		public ProceedBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ProceedBtn proceedBtn = new ProceedBtn();
}
