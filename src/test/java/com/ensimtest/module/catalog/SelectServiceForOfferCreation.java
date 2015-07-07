package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To select a service under which offer gets created
 * @author Dip
 *
 */
public class SelectServiceForOfferCreation extends AppData{

	/*
	 * To create P2O offer that is select "For sale to direct Organizations"
	 */
	public class ForSaleToDirectOrganizationsRdo extends Element{
		public ForSaleToDirectOrganizationsRdo(){
			setElement(readAppData(this));
		}
	}
	
	public ForSaleToDirectOrganizationsRdo froDirectOrganizationsRdo = new ForSaleToDirectOrganizationsRdo();
	
	/*
	 * To create P2R offer that is select "For sale via Resellers"
	 */
	public class ForSaleViaResellersRdo extends Element{
		public ForSaleViaResellersRdo(){
			setElement(readAppData(this));
		}
	}
	
	public ForSaleViaResellersRdo forSaleViaResellersRdo = new ForSaleViaResellersRdo();
	
	/*
	 * To select a reseller name from reseller list
	 */
	public class SelectResellerForWhomOfferNeedToCreateLst extends Element{
		public SelectResellerForWhomOfferNeedToCreateLst(){
			setElement(readAppData(this));
		}
		
		public void selectReseller(String data){
			super.selectVisibleText(data);
		}
	}
	
	public SelectResellerForWhomOfferNeedToCreateLst selectResellerForWhomOfferNeedToCreateLst = new SelectResellerForWhomOfferNeedToCreateLst();
	
	
	/*
	 * To select a service
	 */
	public class SelectAServiceToCreateOfferRdo extends Element{
		public SelectAServiceToCreateOfferRdo(){}
		
		public void setXpath(String xpath){
			String prefixXpath = "//strong[contains(text(),'";
			String sufixXpath = "')]//preceding::input[1]";
			String customXpath = prefixXpath + xpath + sufixXpath;
			setElement("Xpath",customXpath);
			super.click();
		}
	}
	
	public SelectAServiceToCreateOfferRdo selectAServiceToCreateOfferRdo = new SelectAServiceToCreateOfferRdo();
	
	/*
	 * To click on cancel button
	 */
	public class OfferServiceSelectionCancelBtn extends Element{
		public OfferServiceSelectionCancelBtn(){
			setElement(readAppData(this));
		}
	}
	
	public OfferServiceSelectionCancelBtn offerServiceSelectionCancelBtn = new OfferServiceSelectionCancelBtn();
	
	/*
	 * To click on Continue button
	 */
	public class OfferServiceSelectionContinueBtn extends Element{
		public OfferServiceSelectionContinueBtn(){
			setElement(readAppData(this));
		}
	}
	
	public OfferServiceSelectionContinueBtn offerServiceSelectionContinueBtn = new OfferServiceSelectionContinueBtn();
	
}
