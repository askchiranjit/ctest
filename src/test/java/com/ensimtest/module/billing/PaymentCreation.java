package com.ensimtest.module.billing;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;
/**
 * Organization Payment Addition screen
 * @author Karabi
 *
 */

public class PaymentCreation extends AppData
{
	/**
	 * Common fields for Payment received and Adjustment
	 * @author Karabi
	 *
	 */
	public class OrganizationPaymentTab extends Element
	{
		public OrganizationPaymentTab()
		{
			setElement(readAppData(this));
		}
	}
	public OrganizationPaymentTab organizationPaymentTab = new OrganizationPaymentTab();

	public class PaymentReceivedRdo extends Element
	{
		public PaymentReceivedRdo()
		{
			setElement(readAppData(this));
		}
	}
	
	public PaymentReceivedRdo paymentReceivedRdo=new PaymentReceivedRdo();
	
	public class AdjustmentRdo extends Element
	{
		public AdjustmentRdo()
		{
			setElement(readAppData(this));
		}
	}
	public AdjustmentRdo adjustmentRdo=new AdjustmentRdo();

	
	/**
	 * Added for account id or organization id
	 */
	public class AccOrganizationIdTxt extends Element
	   {
		   public AccOrganizationIdTxt()
		   {
			   setElement(readAppData(this));
		   }
	   }
	public AccOrganizationIdTxt accOrganizationIdTxt = new AccOrganizationIdTxt();
	
    public class PaymentDate extends Element
    {
	   public PaymentDate()
	   {
		   setElement(readAppData(this));
	   }
    }
    public PaymentDate paymentDate = new PaymentDate();
	/**
	 * This field is same for Payment received and Adjustment but for adjustment the name should be Adjustment amount
	 * @author Karabi
	 *
	 */
	public class AmountPaidTxt extends Element
	   {
		   public AmountPaidTxt()
		   {
			   setElement(readAppData(this));
		   }
	   }
	public AmountPaidTxt amountPaidTxt = new AmountPaidTxt();
	
	public class CurrencyLst extends Element
	   {
		   public CurrencyLst()
		   {
			   setElement(readAppData(this));
		   }
	   }
	public CurrencyLst currencyLst = new CurrencyLst();
	
	/**
	 * Payment Received Specific Field
	 * @author Karabi
	 *
	 */
	
	public class ModeOfPaymentLst extends Element
	   {
		   public ModeOfPaymentLst()
		   {
			   setElement(readAppData(this));
		   }
			public void selectPayment(String payment)
			{
				super.selectVisibleText(payment);
			}
	   }
	public ModeOfPaymentLst modeOfPaymentLst = new ModeOfPaymentLst();
	/**
	 * Fields Based on the payment mode selected
	 */
	
	/**
	 * Field for NetBanking
	 */
	public class FinancialInstitutionLst extends Element
	{
		public FinancialInstitutionLst()
		{
			setElement(readAppData(this));
		}
	}
	public FinancialInstitutionLst financialInstitutionLst=new FinancialInstitutionLst();
	
	/**
	 * Fields when selecting Credit Card/Debit Card
	 */
	public class CardType extends Element
	{
		public CardType()
		{
			setElement(readAppData(this));
		}
	}
	public CardType cardType=new CardType();
	
	public class InstrumentNumber extends Element
	{
		public InstrumentNumber()
		{
			setElement(readAppData(this));
		}
	}
	public InstrumentNumber instrumentNumber=new InstrumentNumber();
	
	/**
	 * Field when selecting Cheque
	 */
	public class ChequeDate extends Element
	{
		public ChequeDate()
		{
			setElement(readAppData(this));
		}
	}
	public ChequeDate chequeDate=new ChequeDate();
	
	public class CommentTxt extends Element
	   {
		   public CommentTxt()
		   {
			   setElement(readAppData(this));
		   }
	   }
	public CommentTxt commentTxt = new CommentTxt();

	/**
	 * Adjustment Specific field 
	 * @author Karabi
	 *
	 */
	public class AdjustmentNumberTxt extends Element
	   {
		   public AdjustmentNumberTxt()
		   {
			   setElement(readAppData(this));
		   }
	   }
	public AdjustmentNumberTxt adjustmentNumberTxt = new AdjustmentNumberTxt();
	
	/**
	 * Adjustment Type Fields
	 * @author Karabi
	 *
	 */
	public class CreditNoteRDo extends Element
	   {
		   public CreditNoteRDo()
		   {
			   setElement(readAppData(this));
		   }
	   }
	public CreditNoteRDo creditNoteRDo = new CreditNoteRDo();
	
	public class DebitNoteRDo extends Element
	   {
		   public DebitNoteRDo()
		   {
			   setElement(readAppData(this));
		   }
	   }
	public DebitNoteRDo debitNoteRDo = new DebitNoteRDo();
	
	/**
	 * The Buttons present on the screen
	 * @author Karabi
	 *
	 */
	
	public class CancelBtn extends Element
	   {
		   public CancelBtn()
		   {
			   setElement(readAppData(this));
		   }
	   }
	public CancelBtn cancelBtn = new CancelBtn();
	
	public class SavePaymentBtn extends Element
	   {
		   public SavePaymentBtn()
		   {
			   setElement(readAppData(this));
		   }
	   }
	public SavePaymentBtn savePaymentBtn = new SavePaymentBtn();
	
	public class UploadCsvBtn extends Element
	   {
		   public UploadCsvBtn()
		   {
			   setElement(readAppData(this));
		   }
	   }
	public UploadCsvBtn uploadCsvBtn = new UploadCsvBtn();

}
