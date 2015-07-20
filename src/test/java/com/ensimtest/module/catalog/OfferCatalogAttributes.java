package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To handle all controls under catalog attributes properties
 * @author Dip
 *
 */
public class OfferCatalogAttributes extends AppData{
	
	/*
	 * Display Order text box
	 */
	public class DisplayOrderTxt extends Element{
		public DisplayOrderTxt(){
			setElement(readAppData(this));
		}
	}
	
	public DisplayOrderTxt displayOrderTxt = new DisplayOrderTxt();
	
	/*
	 * Display Text
	 */
	public class DisplayTextTxt extends Element{
		public DisplayTextTxt(){
			setElement(readAppData(this));
		}
	}
	
	public DisplayTextTxt displayTextTxt = new DisplayTextTxt();
	
	/*
	 * Add icon
	 */
	public class AddDisplayTextBtn extends Element{
		public AddDisplayTextBtn(){
			setElement(readAppData(this));
		}
	}
	
	public AddDisplayTextBtn addDisplayTextBtn = new AddDisplayTextBtn();
	
	/*
	 * Remove icon
	 */
	public class RemoveDisplayTextBtn extends Element{
		public RemoveDisplayTextBtn(){}
	}
	
	public RemoveDisplayTextBtn removeDisplayTextBtn = new RemoveDisplayTextBtn();
	
	/*
	 * To write values in the text box and add that one
	 */
	public void writeOfferFeaturesToDisplay(String[] displayOrderLst, String[] displayTextLst){
		
		for(int i=0;i<displayOrderLst.length;i++){
			
			displayOrderTxt.write(displayOrderLst[i]);
			displayTextTxt.write(displayTextLst[i]);
			addDisplayTextBtn.click();
		}
	}
	
	/*
	 * To edit featured values
	 */
//TODO:tom

}
