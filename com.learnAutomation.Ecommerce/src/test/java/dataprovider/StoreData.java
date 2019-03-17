package dataprovider;

import org.testng.annotations.DataProvider;

import page.BaseClass;

public class StoreData extends BaseClass {

	@DataProvider (name="TestData")
	public static Object [] [] getData()
										{
		
		System.out.println("TestData is getting ready");
		
		Object [][] arr1=new Object[2][2];
		arr1[0][0]="wcharlesivory@gmail.com";
		arr1[0][1]="Asdf1234";  
			
		arr1[1][0]="Asdfasdf123@yahoo.com";
		arr1[1][1]="Qwer1234";
		
		System.out.println("Test can get started");
		
		return arr1;
		
		
	}
	
	@DataProvider (name="TestData1")
	public static Object [] [] getData1()
	{
		
		System.out.println("TestData is getting ready");
		
		int row=excel.getNumberOfRows("Login");
		int column=excel.getNumberOfColums("Login",1);
		
		Object [][] arr1=new Object[row][column];
		
		for(int i=0; i<row; i++) 
		{
			arr1[i][0]=excel.getStringData("Login", i, 0);
			arr1[i][1]=excel.getStringData("Login", i, 1);	
		}
		

		
		System.out.println("Test can get started");
		
		return arr1;
	
}
									}