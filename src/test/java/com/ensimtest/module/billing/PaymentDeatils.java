package com.ensimtest.module.billing;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;
/**
 * Payment Deatils Screen
 * @author Karabi
 *
 */

public class PaymentDeatils extends AppData {
	
	public class CancelBtn extends Element{
		public CancelBtn()
		{
			setElement(readAppData(this));
		}
	}
	public CancelBtn cancelBtn = new CancelBtn();

	public class DeleteBtn extends Element{
		public DeleteBtn()
		{
			setElement(readAppData(this));
		}
	}
	public DeleteBtn deleteBtn = new DeleteBtn();
}
