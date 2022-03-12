package test_Uitility;

import java.util.ArrayList;



import excel_Utility.ExcelReader;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class Test_Util {

	static  ExcelReader wrkbook;
	
	public static ArrayList<Object[]> getting_data_from_excel()
	{
		
		ArrayList<Object[]> data=new ArrayList<Object[]>();
		
	
		try {
			wrkbook=new ExcelReader("C:\\Users\\kalya\\eclipse-workspace\\tutorialninja\\src\\test\\java\\test_data\\tutorialninja_login.xlsx");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
		
		int total_rowcount=wrkbook.getRowCount("Register");
		System.out.println("row count="+total_rowcount);
		
		for(int row=2;row<=total_rowcount;row++)
		{
			 System.out.println("----------------------------------------");
			 String First_Name=wrkbook.getCellData("Register","First Name",row);
			 System.out.println(First_Name);
			  
			 String last_Name=wrkbook.getCellData("Register","Last Name",row);
			 System.out.println(last_Name);
			 
			 String E_Mail=wrkbook.getCellData("Register","E-Mail",row);
			 System.out.println(E_Mail);
			 
			 String Telephone=wrkbook.getCellData("Register","Telephone",row);
			 System.out.println(Telephone);
			 
			 String Password=wrkbook.getCellData("Register","Password",row);
			 System.out.println(Password);
			 
			 String Password_Confirm=wrkbook.getCellData("Register","Password Confirm",row);
			 System.out.println(Password_Confirm);
			  
			Object[] obj= {First_Name,last_Name,E_Mail,Telephone,Password,Password_Confirm};
			data.add(obj);
		}
		
		return data;
		
	}
	
	
	
}
