package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility 
{

  static Faker faker ; 
	  
	public static String getFirstName() 
	{
		faker = new Faker();
		String first_name = faker.name().firstName();
		return first_name;
		
	}
	
	public static String getLastName() 
	{
		faker = new Faker();
		String last_name = faker.name().lastName();
		return last_name;
	
	}
	
}
