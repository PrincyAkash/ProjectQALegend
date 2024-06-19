package dataprovider;


import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "invaliduserCredentials") //to call using name
	public Object[][] userCredetialsData() 
	{
		Object[][] data = new Object[3][2]; // array type Object
		data[0][0] = "admin";
		data[0][1] = "1";
		
		data[1][0] = "asd";
		data[1][1] = "123456";
		
		data[2][0] = "asd";
		data[2][1] = "123";
		
		return data;
	}

}