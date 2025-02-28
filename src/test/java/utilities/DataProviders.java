package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx"; //taking xl file from testData folder		
		
		ExcelUtility xlutil=new ExcelUtility(path); //creating an object for ExcelUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");     //page name should be Sheet1
		int totalcols=xlutil.getCellCount("Sheet1", 1);   
				
		String logindata[][]=new String[totalrows][totalcols]; //create for two dimension array which can store ..
		
		for(int i=1;i<=totalrows;i++) //1   //read the data from xl storing in two dimensional array
		{
			for(int j=0;j<totalcols;j++) //0   i is rows j is col
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);  //1,0				
			}
		}
	return logindata; //returning two dimension array		
		
	}
	
		
	//DataProvider 2       hard code login data
	
	@DataProvider(name="LoginData2")
	public Object[][] getLoginData() {
	    return new Object[][] {
	        {"shenleimail@gmail.com", "test@123", "Valid"},
	        {"lakshmi@yahoo.com", "Laxmi", "Valid"},
	        {"laksh@yahoo.com", "Lakshmi", "Valid"},
	        {"laks@yahoo.com", "xyz", "Invalid"},
	        {"shenleibox@yahoo.com", "test@123", "Valid"},
	        {"", "test@123", "Invalid"}
	    };
	}
	
	//DataProvider 3
	
	//DataProvider 4
}
