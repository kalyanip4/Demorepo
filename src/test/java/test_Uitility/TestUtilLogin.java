package test_Uitility;

import java.util.ArrayList;

import excel_Utility.ExcelReader;

public class TestUtilLogin {

	static  ExcelReader wrkbook_new;
	
	 public static ArrayList<Object[]> getting_data_from_excel_login()
	 {
		 
		 ArrayList<Object[]> data=new ArrayList<Object[]>();
		

			try {
				wrkbook_new=new ExcelReader("C:\\Users\\kalya\\eclipse-workspace\\tutorialninja\\src\\test\\java\\test_data\\tutorialninja_login.xlsx");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
       int total_rowcount_login=wrkbook_new.getRowCount("login");
       System.out.println("row count login="+total_rowcount_login);
	
	
	for(int row=2;row<= total_rowcount_login;row++)
	{
		
		 System.out.println("getting_data_from_excel_login");
		 String E_Mail=wrkbook_new.getCellData("login","E-Mail",row);
	     System.out.println(E_Mail);
		 
		
		 String Password=wrkbook_new.getCellData("login","Password",row);
		 System.out.println(Password);
		 
		
		  
		Object[] obj= {E_Mail,Password};
		data.add(obj);
	}
	
	return data;
	
}
	 
	
}