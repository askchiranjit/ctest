package com.ensimtest.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.google.gson.JsonParseException;

public class OrderItemJsonHandler 
{
   public class ItemDetails
   {
	   public String itemName,value; 
	   public boolean operation,textbox,dropdown,checkbox;
	   public ItemDetails(String itemName,String value,String operation,String textbox,String dropdown,String checkbox)
	   {
		   this.itemName=itemName;
		   this.value=value;
		   this.operation=Boolean.valueOf(operation);
		   this.textbox=Boolean.valueOf(textbox);
		   this.dropdown=Boolean.valueOf(dropdown);
		   this.checkbox=Boolean.valueOf(checkbox);
	   }
   }
	
   public ItemDetails[] itemDetails(String jsonString) throws Exception
   {
	   try{
			JSONParser parser=new JSONParser();
			JSONObject parentJsonObject=new JSONObject();
			parentJsonObject=(JSONObject) parser.parse(jsonString);
			JSONArray jsonArray = (JSONArray) parentJsonObject.get("ItemList");
			ItemDetails itemDetails[]=new ItemDetails[jsonArray.size()];
			for(int i=0;i<jsonArray.size();i++)
			{
				JSONObject childObject=(JSONObject) jsonArray.get(i);
				itemDetails[i]=new ItemDetails(childObject.get("itemName").toString(),childObject.get("value").toString(),childObject.get("operation").toString(),childObject.get("textbox").toString(),childObject.get("dropdown").toString(),childObject.get("checkbox").toString());
			}
			
			return itemDetails;
			
	     }
	    catch(Exception e)
	    {
		  throw new JsonParseException("Problem in Json string Parsing:--  "+e.getStackTrace());
	    }
	    
   }
}
