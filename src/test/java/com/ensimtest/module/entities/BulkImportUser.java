
package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * This is use to implement the Bulk User Import functionality
 * @author Dip
 *
 */
public class BulkImportUser extends AppData {
	
	/**
	 * To Load a User CSV file
	 */
	public class LoadCSVFileLnk extends Element{
		public LoadCSVFileLnk(){
			setElement(readAppData(this));
		}
		
		// TODO : Handle CSV File Selection Wizard
		 
	}
	public LoadCSVFileLnk loadCSVFileLnk = new LoadCSVFileLnk();
	
	/**
	 * To Send activation email to each user after importing
	 */
	public class SendActivationEmailChk extends Element{
		public SendActivationEmailChk(){
			setElement(readAppData(this));
		}
	}
	public SendActivationEmailChk sendActivationEmailChk = new SendActivationEmailChk();
	
	/**
	 * Click on Download Sample CSV button
	 */
	public class DownloadSampleCSVBtn extends Element{
		public DownloadSampleCSVBtn(){
			setElement(readAppData(this));
		}
	}
	public DownloadSampleCSVBtn downloadSampleCSVBtn = new DownloadSampleCSVBtn();
	
	/**
	 * Click on Import Now button
	 */
	public class ImportNowBtn extends Element{
		public ImportNowBtn(){
			setElement(readAppData(this));
		}
	}
	public ImportNowBtn importNowBtn = new ImportNowBtn();

}


