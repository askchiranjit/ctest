package com.ensimtest.resource;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSFileReader {
	//data members
	public  String Path;  //holds the path for the xlsx file
	public  FileInputStream Fis = null; //a object of FileInputStream class
	private XSSFWorkbook Workbook=null; //a object of workbook class
	private XSSFSheet Sheet = null;     //a object of Sheet class
	private XSSFRow Row=null;           //a object of Row class
	private XSSFCell Column=null;         //a object of Cell class  
	public  FileOutputStream FileOut =null;   //a object of file output string



	//constructor for Xls_Reader class which ask for the path of the xlsx file
	public XLSFileReader(String Path)
	{
		this.Path=Path;
		try {
			Fis=new FileInputStream(Path);
			Workbook=new XSSFWorkbook(Fis);  //workbook means the whole xlsx file
			Sheet=Workbook.getSheetAt(0);    //taking the default (1st) 
			Fis.close();                     //closing the fileInputStream

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	// find whether sheets exists	
	public boolean isSheetExist(String SheetName){
		Sheet = Workbook.getSheet(SheetName);
		if(Sheet==null){
			return false;
		}
		else
			return true;
	}



	//method which will give the number of rows present in a sheet //function has a limitation that if a sheet has no row but sheet present it will give you output one
	public int getRowCount(String SheetName)
	{

		if(isSheetExist(SheetName))
		{
			Sheet=Workbook.getSheet(SheetName);    //getting the particular sheet by sheet name
			return (Sheet.getLastRowNum()+1);      //total no of row in a sheet

		}
		else
		{
			return 0;       					//if sheet doesnot exists
		}

	}


	// returns number of columns in a sheet	  (applicable for our test cases at 1st row specify number of column
	public int getColumnCount(String sheetName)
	{
		// check if sheet exists
		if(!isSheetExist(sheetName))
		{
			return -1;
		}
		Sheet = Workbook.getSheet(sheetName);
		Row = Sheet.getRow(0);
		if(Row==null)
		{
			return -1;
		}
		return Row.getLastCellNum();
	}



	// returns the data from a cell(cell means a block)

	public String getCellData(String SheetName,String ColName,int RowNum)
	{
		int Col_Number=-1;
		DataFormatter fmt = new DataFormatter();                  //used to return value as it is in the xls file

		if(!isSheetExist(SheetName))
		{
			return "";                //return blank if sheet does not exists
		}
		if(RowNum<=0)
		{
			return "";        //return blank if row number is invalid
		}

		Sheet=Workbook.getSheet(SheetName);
		Row=Sheet.getRow(0);                 //take the 1st column to check if the column exists

		for(int i=0;i<Row.getLastCellNum();i++)     //to check if the column exists
		{
			if(Row.getCell(i).getStringCellValue().trim().equals(ColName.trim()))
			{
				Col_Number=i;
				break;
			}
		}

		if(Col_Number==-1)
		{
			return "";                  //return blank if column does not exists
		}

		Row=Sheet.getRow(RowNum-1);     //point to desire row
		if(Row==null)
		{
			return "";                  //return blank if row doesnot exists  
		}

        Column=Row.getCell(Col_Number);   //point to the desire cell
        
        if(Column==null)
        {
        	return "";                 //return blank if cell does not exists
        }
        
        return fmt.formatCellValue(Column);
        
        
        //comented this portion as I want the value from xls file as it is
        
        
//        if(Column.getCellType()==Cell.CELL_TYPE_STRING)
//        {
//        	return Column.getStringCellValue().trim();      //returning the value is the value is string
//        }
//        else if(Column.getCellType()==Cell.CELL_TYPE_NUMERIC||Column.getCellType()==Cell.CELL_TYPE_FORMULA)
//        {
//        	 String cellText  = String.valueOf(Column.getNumericCellValue());
//        	 if (HSSFDateUtil.isCellDateFormatted(Column)) {
//		           // format in form of M/D/YY
//				  double d = Column.getNumericCellValue();
//
//				  Calendar cal =Calendar.getInstance();
//				  cal.setTime(HSSFDateUtil.getJavaDate(d));
//		            cellText =
//		             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
//		           cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
//		                      cal.get(Calendar.MONTH)+1 + "/" + 
//		                      cellText;
//		           
//		           //System.out.println(cellText);
//
//		         }
//
//			  
//			  
//			  return cellText;
//        }else if(Column.getCellType()==Cell.CELL_TYPE_BLANK)
//        {
//        	return "";                                          //if no value
//        }
//        else
//        	return String.valueOf(Column.getBooleanCellValue());
//        

	}
	
	
	
	// returns the data from a cell(cell means a block)
	
	
	
	public String getCellData(String SheetName,int ColNum,int RowNum)
	{
		
		DataFormatter fmt = new DataFormatter();                  //used to return value as it is in the xls file

		if(!isSheetExist(SheetName))
		{
			return "";                //return blank if sheet does not exists
		}
		if(RowNum<=0)
		{
			return "";        //return blank if row number is invalid
		}
		
		if(ColNum<=0)
		{
			return "";        //return blank if column number is invalid
		}

		Sheet=Workbook.getSheet(SheetName);
		
		Row=Sheet.getRow(RowNum-1);     //point to desire row
		if(Row==null)
		{
			return "";                  //return blank if row doesnot exists  
		}

        Column=Row.getCell(ColNum-1);   //point to the desire cell
        
        if(Column==null)
        {
        	return "";                 //return blank if cell does not exists
        }
        
        return fmt.formatCellValue(Column);
			
		
	}


	
	// returns true if data is set successfully else false
		public boolean setCellData(String SheetName,String ColName,int RowNum, String Data){
			try{
			Fis = new FileInputStream(Path); 
			Workbook = new XSSFWorkbook(Fis);

			if(RowNum<=0)
				return false;
			
			int index = Workbook.getSheetIndex(SheetName);
			int colNum=-1;
			if(index==-1)
				return false;
			
			
			Sheet = Workbook.getSheetAt(index);
			

			Row=Sheet.getRow(0);
			for(int i=0;i<Row.getLastCellNum();i++){
				//System.out.println(row.getCell(i).getStringCellValue().trim());
				if(Row.getCell(i).getStringCellValue().trim().equals(ColName.trim()))
					colNum=i;
			}
			if(colNum==-1)
				return false;

			Sheet.autoSizeColumn(colNum); 
			Row = Sheet.getRow(RowNum-1);
			if (Row == null)
				Row = Sheet.createRow(RowNum-1);
			
			Column = Row.getCell(colNum);	
			if (Column == null)
		        Column = Row.createCell(colNum);

		    // cell style
		    //CellStyle cs = workbook.createCellStyle();
		    //cs.setWrapText(true);
		    //cell.setCellStyle(cs);
		    Column.setCellValue(Data);

		    FileOut = new FileOutputStream(Path);

			Workbook.write(FileOut);

		    FileOut.close();	

			}
			catch(Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}

		
		
		// returns true if data is set successfully else false
		public boolean setCellData(String SheetName,String ColName,int RowNum, String Data,String Url){
			//System.out.println("setCellData setCellData******************");
			try{
			Fis = new FileInputStream(Path); 
			Workbook = new XSSFWorkbook(Fis);

			if(RowNum<=0)
				return false;
			
			int index = Workbook.getSheetIndex(SheetName);
			int colNum=-1;
			if(index==-1)
				return false;
			
			
			Sheet = Workbook.getSheetAt(index);
			//System.out.println("A");
			Row=Sheet.getRow(0);
			for(int i=0;i<Row.getLastCellNum();i++){
				//System.out.println(row.getCell(i).getStringCellValue().trim());
				if(Row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(ColName))
					colNum=i;
			}
			
			if(colNum==-1)
				return false;
			Sheet.autoSizeColumn(colNum); //ashish
			Row = Sheet.getRow(RowNum-1);
			if (Row == null)
				Row = Sheet.createRow(RowNum-1);
			
			Column = Row.getCell(colNum);	
			if (Column == null)
				Column = Row.createCell(colNum);
				
			Column.setCellValue(Data);
		    XSSFCreationHelper createHelper = Workbook.getCreationHelper();

		    //cell style for hyperlinks
		    //by default hypelrinks are blue and underlined
		    CellStyle hlink_style = Workbook.createCellStyle();
		    XSSFFont hlink_font = Workbook.createFont();
		    hlink_font.setUnderline(XSSFFont.U_SINGLE);
		    hlink_font.setColor(IndexedColors.BLUE.getIndex());
		    hlink_style.setFont(hlink_font);
		    //hlink_style.setWrapText(true);

		    XSSFHyperlink link = createHelper.createHyperlink(XSSFHyperlink.LINK_FILE);
		    link.setAddress(Url);
		    Column.setHyperlink(link);
		    Column.setCellStyle(hlink_style);
		      
		    FileOut = new FileOutputStream(Path);
			Workbook.write(FileOut);

		    FileOut.close();	

			}
			catch(Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		// returns true if sheet is created successfully else false
		public boolean addSheet(String  SheetName){		
			
			FileOutputStream fileOut;
			try {
				 Workbook.createSheet(SheetName);	
				 fileOut = new FileOutputStream(Path);
				 Workbook.write(fileOut);
			     fileOut.close();		    
			} catch (Exception e) {			
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		
		
		// returns true if sheet is removed successfully else false if sheet does not exist
		public boolean removeSheet(String SheetName){		
			int index = Workbook.getSheetIndex(SheetName);
			if(index==-1)
				return false;
			
			FileOutputStream fileOut;
			try {
				Workbook.removeSheetAt(index);
				fileOut = new FileOutputStream(Path);
				Workbook.write(fileOut);
			    fileOut.close();		    
			} catch (Exception e) {			
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		
		
		// returns true if column is created successfully
		public boolean addColumn(String SheetName,String ColName){
			//System.out.println("**************addColumn*********************");
			
			try{				
				Fis = new FileInputStream(Path); 
				Workbook = new XSSFWorkbook(Fis);
				int index = Workbook.getSheetIndex(SheetName);
				if(index==-1)
					return false;
				
			XSSFCellStyle style = Workbook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			
			Sheet=Workbook.getSheetAt(index);
			
			Row = Sheet.getRow(0);
			if (Row == null)
				Row = Sheet.createRow(0);
			
			//cell = row.getCell();	
			//if (cell == null)
			//System.out.println(row.getLastCellNum());
			if(Row.getLastCellNum() == -1)
				Column = Row.createCell(0);
			else
				Column = Row.createCell(Row.getLastCellNum());
		        
		        Column.setCellValue(ColName);
		        Column.setCellStyle(style);
		        
		        FileOut = new FileOutputStream(Path);
				Workbook.write(FileOut);
			    FileOut.close();		    

			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			
			return true;
			
			
		}
		// removes a column and all the contents
		public boolean removeColumn(String sheetName, int colNum) {
			try{
			if(!isSheetExist(sheetName))
				return false;
			Fis = new FileInputStream(Path); 
			Workbook = new XSSFWorkbook(Fis);
			Sheet=Workbook.getSheet(sheetName);
			XSSFCellStyle style = Workbook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			XSSFCreationHelper createHelper = Workbook.getCreationHelper();
			style.setFillPattern(HSSFCellStyle.NO_FILL);
			
		    
		
			for(int i =0;i<getRowCount(sheetName);i++){
				Row=Sheet.getRow(i);	
				if(Row!=null){
					Column=Row.getCell(colNum);
					if(Column!=null){
						Column.setCellStyle(style);
						Row.removeCell(Column);
					}
				}
			}
			FileOut = new FileOutputStream(Path);
			Workbook.write(FileOut);
		    FileOut.close();
			}
			catch(Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
			
		}
		
		
		
		//String sheetName, String testCaseName,String keyword ,String URL,String message
		public boolean addHyperLink(String SheetName,String ScreenShotColName,String TestCaseName,int index,String url,String message){
			//System.out.println("ADDING addHyperLink******************");
			
			url=url.replace('\\', '/');
			if(!isSheetExist(SheetName))
				 return false;
			
		    Sheet = Workbook.getSheet(SheetName);
		    
		    for(int i=2;i<=getRowCount(SheetName);i++){
		    	if(getCellData(SheetName, 0, i).equalsIgnoreCase(TestCaseName)){
		    		//System.out.println("**caught "+(i+index));
		    		setCellData(SheetName, ScreenShotColName, i+index, message,url);
		    		break;
		    	}
		    }


			return true; 
		}
		
		
		public int getCellRowNum(String SheetName,String ColName,String CellValue){
			
			for(int i=2;i<=getRowCount(SheetName);i++){
		    	if(getCellData(SheetName,ColName , i).equalsIgnoreCase(CellValue)){
		    		return i;
		    	}
		    }
			return -1;
			
		}

}



