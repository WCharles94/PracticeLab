package utility;

import org.testng.Assert;

public class Validation 
{

	public static void validate(String actual,String expected)
	{
		Assert.assertEquals(actual, expected);	
	}
	
	public static void validate(int actual,int expected)
	{
		Assert.assertEquals(actual, expected);	
	}
	
	public  static void validate(double actual,double expected)
	{
		Assert.assertEquals(actual, expected);	
	}
	
	public  static void validate(char actual,char expected)
	{
		Assert.assertEquals(actual, expected);	
	}
	
	public static void validate(boolean actual,boolean expected)
	{
		Assert.assertEquals(actual, expected);	
	}
	
	
	public static void validateContent(String actual,String partialTextToBeMatched)
	{
		boolean status=actual.contains(partialTextToBeMatched);
		
		Assert.assertTrue(status, "content validation failed");
		
	}
	
}
