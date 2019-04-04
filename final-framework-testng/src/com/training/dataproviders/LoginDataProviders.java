package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[4]; 
			obj[0] = temp.getName(); 
			obj[1] = temp.getEmail();
			obj[2]= temp.getSubject();
			obj[3]= temp.getMessage();
					
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
	
	//Data Provider for RETC066Test
	
	@DataProvider(name = "excel-inputs-negative-TC66")
	public Object[][] getExceldata(){
		String fileName ="./resources/TestData04.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	//Data Provider for RETC068Test
	
		@DataProvider(name = "excel-inputs-positive-TC68")
		public Object[][] getExceldata68(){
			String fileName ="./resources/TestData05.xlsx"; 
			return new ApachePOIExcelRead().getExcelContent(fileName); 
		}
		
	//Data Provider for RETC069Test
		
			@DataProvider(name = "excel-inputs-negative-TC69")
			public Object[][] getExceldata69(){
				String fileName ="./resources/TestData06.xlsx"; 
				return new ApachePOIExcelRead().getExcelContent(fileName); 
			}

}
