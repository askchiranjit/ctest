package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class AddResources extends AppData
{

	public class CancelBtn extends Element
	{
		public CancelBtn()
		{
			setElement(readAppData(this));
		}
	}
	public CancelBtn cancelBtn = new CancelBtn();

	public class SaveBtn extends Element
	{
		public SaveBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SaveBtn saveBtn = new SaveBtn();

	public class ResourceNameTxt extends Element
	{
		public ResourceNameTxt()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public ResourceNameTxt resourceNameTxt = new ResourceNameTxt();

	public class ResourceIDTxt extends Element
	{
		public ResourceIDTxt()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public ResourceIDTxt resourceIDTxt = new ResourceIDTxt();

	public class PayPerUseTrueRdo extends Element
	{
		public PayPerUseTrueRdo()
		{
			setElement(readAppData(this));
		}
		
		@Override
		public boolean isSelected()
		{
			return super.isSelected();
		}
	}
	public PayPerUseTrueRdo payPerUseTrueRdo = new PayPerUseTrueRdo();

	public class PayPerUseFalseRdo extends Element
	{
		public PayPerUseFalseRdo()
		{
			setElement(readAppData(this));
		}
		
		@Override
		public boolean isSelected()
		{
			return super.isSelected();
		}
	}
	public PayPerUseFalseRdo payPerUseFalseRdo = new PayPerUseFalseRdo();

	public class DafaultQuantityTxt extends Element
	{
		public DafaultQuantityTxt()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public DafaultQuantityTxt dafaultQuantityTxt = new DafaultQuantityTxt();

	public class ResourceCategoryTxt extends Element
	{
		public ResourceCategoryTxt()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public ResourceCategoryTxt resourceCategoryTxt = new ResourceCategoryTxt();

	public class AvailableForUserChk extends Element
	{
		public AvailableForUserChk()
		{
			setElement(readAppData(this));
		}
		@Override
		public boolean isSelected()
		{
			return super.isSelected();
		}
		
	}
	public AvailableForUserChk availableForUserChk = new AvailableForUserChk();

	public class ReservationUnitLst extends Element
	{
		public ReservationUnitLst()
		{
			setElement(readAppData(this));
		}
		public void selectReservationUnit(String resoureType)
		{
			super.selectVisibleText(resoureType);
		}
		public String getSelectedType()
		{
			return super.getSelectedType();
		}
	}
	public ReservationUnitLst reservationUnitLst = new ReservationUnitLst();

	public class PPUUnitLst extends Element
	{
		public PPUUnitLst()
		{
			setElement(readAppData(this));
		}
		public void selectPPUUnit(String resoureType)
		{
			super.selectVisibleText(resoureType);
		}
		public String getSelectedType()
		{
			return super.getSelectedType();
		}
	}
	public PPUUnitLst pPUUnitLst = new PPUUnitLst();

	public class MeteringRuleLst extends Element
	{
		public MeteringRuleLst()
		{
			setElement(readAppData(this));
		}
		public void selectMeteringRule(String resoureType)
		{
			super.selectVisibleText(resoureType);
		}
		public String getSelectedType()
		{
			return super.getSelectedType();
		}
	}
	public MeteringRuleLst meteringRuleLst = new MeteringRuleLst();

	public class ReservProvisioningSystemUnitTxt extends Element
	{
		public ReservProvisioningSystemUnitTxt()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public ReservProvisioningSystemUnitTxt reservProvisioningSystemUnitTxt = new ReservProvisioningSystemUnitTxt();

	public class PPUProvisioningSystemUnitTxt extends Element
	{
		public PPUProvisioningSystemUnitTxt()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public PPUProvisioningSystemUnitTxt pPUProvisioningSystemUnitTxt = new PPUProvisioningSystemUnitTxt();

	public class PPUReportingMechanismLst extends Element
	{
		public PPUReportingMechanismLst()
		{
			setElement(readAppData(this));
		}
		public void selectPPUReportingMechanism(String reportingMechanism)
		{
			super.selectVisibleText(reportingMechanism);
		}
		public String getSelectedType()
		{
			return super.getSelectedType();
		}
	}
	public PPUReportingMechanismLst pPUReportingMechanismLst = new PPUReportingMechanismLst();

	public class ReservConvertionFactorTxt extends Element
	{
		public ReservConvertionFactorTxt()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public ReservConvertionFactorTxt reservConvertionFactorTxt = new ReservConvertionFactorTxt();

	public class PPUConvertionFactorTxt extends Element
	{
		public PPUConvertionFactorTxt()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public PPUConvertionFactorTxt pPUConvertionFactorTxt = new PPUConvertionFactorTxt();

	public class ReservConversionOperationLst extends Element
	{
		public ReservConversionOperationLst()
		{
			setElement(readAppData(this));
		}
		public void selectReservConversionOperation(String resCovOperation)
		{
			super.selectVisibleText(resCovOperation);
		}
		public String getSelectedType()
		{
			return super.getSelectedType();
		}
		
	}
	public ReservConversionOperationLst reservConversionOperationLst = new ReservConversionOperationLst();

	public class ProvisioningInformationRdo extends Element
	{
		public ProvisioningInformationRdo()
		{
			setElement(readAppData(this));
		}
		@Override
		public boolean isSelected()
		{
			return super.isSelected();
		}
	}
	public ProvisioningInformationRdo provisioningInformationRdo = new ProvisioningInformationRdo();

	public class OrderItemRdo extends Element
	{
		public OrderItemRdo()
		{
			setElement(readAppData(this));
		}
		@Override
		public boolean isSelected()
		{
			return super.isSelected();
		}
	}
	public OrderItemRdo orderItemRdo = new OrderItemRdo();

	public class ReportedValuePerTxt extends Element
	{
		public ReportedValuePerTxt()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public ReportedValuePerTxt reportedValuePerTxt = new ReportedValuePerTxt();

	public class DefaultValueTxt extends Element
	{
		public DefaultValueTxt()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public DefaultValueTxt defaultValueTxt = new DefaultValueTxt();

	public class AskInFirstOrderRdo extends Element
	{
		public AskInFirstOrderRdo()
		{
			setElement(readAppData(this));
		}
		@Override
		public boolean isSelected()
		{
			return super.isSelected();
		}
	}
	public AskInFirstOrderRdo askInFirstOrderRdo = new AskInFirstOrderRdo();

	public class AskInEveryOrderRdo extends Element
	{
		public AskInEveryOrderRdo()
		{
			setElement(readAppData(this));
		}
		@Override
		public boolean isSelected()
		{
			return super.isSelected();
		}
	}
	public AskInEveryOrderRdo askInEveryOrderRdo = new AskInEveryOrderRdo();

	public class UniqueChk extends Element
	{
		public UniqueChk()
		{
			setElement(readAppData(this));
		}
		@Override
		public boolean isSelected()
		{
			return super.isSelected();
		}
	}
	public UniqueChk uniqueChk = new UniqueChk();

	public class MandetoryChk extends Element
	{
		public MandetoryChk()
		{
			setElement(readAppData(this));
		}
		@Override
		public boolean isSelected()
		{
			return super.isSelected();
		}
	}
	public MandetoryChk mandetoryChk = new MandetoryChk();

	public class EditableAfterProvisioningChk extends Element
	{
		public EditableAfterProvisioningChk()
		{
			setElement(readAppData(this));
		}
		@Override
		public boolean isSelected()
		{
			return super.isSelected();
		}
	}
	public EditableAfterProvisioningChk editableAfterProvisioningChk = new EditableAfterProvisioningChk();

	public class PIFResourceTypeLst extends Element
	{
		public PIFResourceTypeLst()
		{
			setElement(readAppData(this));
		}
		
		public void selectResourceType(String resoureType)
		{
			super.selectVisibleText(resoureType);
		}
		public String getSelectedType()
		{
			return super.getSelectedType();
		}
	}
	public PIFResourceTypeLst pIFResourceTypeLst = new PIFResourceTypeLst();
	
	
	public class PIFInputTypeLst extends Element
	{
		public PIFInputTypeLst()
		{
			setElement(readAppData(this));
		}
		
		public void selectInputType(String resoureType)
		{
			super.selectVisibleText(resoureType);
		}
		public String getSelectedType()
		{
			return super.getSelectedType();
		}
	}
	public PIFInputTypeLst pIFInputTypeLst = new PIFInputTypeLst();
	
	
	public class PPUConversionOperationLst extends Element
	{
		public PPUConversionOperationLst()
		{
			setElement(readAppData(this));
		}
		public void selectPPUConversion(String ppuConversion)
		{
			super.selectVisibleText(ppuConversion);
		}
		public String getSelectedType()
		{
			return super.getSelectedType();
		}
	}
	
	public PPUConversionOperationLst pPUConversionOperationLst= new PPUConversionOperationLst();
	
}
